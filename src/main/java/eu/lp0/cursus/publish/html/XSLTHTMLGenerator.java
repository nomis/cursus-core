/*
	cursus - Race series management program
	Copyright 2014  Simon Arlott

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU Affero General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU Affero General Public License for more details.

	You should have received a copy of the GNU Affero General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.lp0.cursus.publish.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

import eu.lp0.cursus.util.PackageConstants;
import eu.lp0.cursus.xml.ExportException;
import eu.lp0.cursus.xml.results.ResultsXMLFile;
import eu.lp0.cursus.xml.results.data.ResultsXMLSplit;
import eu.lp0.cursus.xml.scores.ScoresXML;
import eu.lp0.cursus.xml.scores.ScoresXMLFile;
import eu.lp0.cursus.xml.scores.XMLScores;
import eu.lp0.cursus.xml.scores.results.ScoresXMLEventResults;
import eu.lp0.cursus.xml.scores.results.ScoresXMLRaceResults;
import eu.lp0.cursus.xml.scores.results.ScoresXMLSeriesResults;

public class XSLTHTMLGenerator {
	private static final String SIMPLE_NAME = "%1$sa%2$s"; //$NON-NLS-1$
	private static final String MENU_NAME = "%1$st%2$s"; //$NON-NLS-1$
	private static final String SPLIT_NAME_PREFIX = "%1$s"; //$NON-NLS-1$

	private static final String SIMPLE_LONG_NAME = "%1$s_simple%2$s"; //$NON-NLS-1$
	private static final String MENU_LONG_NAME = "%1$s_tabs%2$s"; //$NON-NLS-1$
	private static final String SPLIT_LONG_NAME_PREFIX = "%1$s_split-"; //$NON-NLS-1$

	private static final String MENU_FILE = "results-html-menu.xsl"; //$NON-NLS-1$
	private static final String SIMPLE_FILE = "results-html-simple.xsl"; //$NON-NLS-1$
	private static final String SPLIT_FILE = "results-html-split.xsl"; //$NON-NLS-1$
	private static final String FILE_EXT = ".xml"; //$NON-NLS-1$

	public static final List<String> CODE_PAGES = Arrays.asList("results-html.xsl", MENU_FILE, SIMPLE_FILE, SPLIT_FILE); //$NON-NLS-1$ 

	private final String scoresFileName;
	private final String fileNamePrefix;
	private final String codeDir;
	private final int seriesResults;
	private final int eventResults;
	private final int raceResults;
	private boolean longNames;

	private List<String> headers = new ArrayList<String>();
	private List<String> footers = new ArrayList<String>();
	private List<String> styleSheets = new ArrayList<String>();
	private Map<String, String> flags = new TreeMap<String, String>();
	private Map<String, String> classes = new LinkedHashMap<String, String>();

	public XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, ScoresXML scores) {
		this(scoresFileName, fileNamePrefix, null, scores.getSeriesResults(), scores.getEventResults(), scores.getRaceResults());
	}

	public XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, ScoresXMLFile scoresFile) {
		this(scoresFileName, fileNamePrefix, null, scoresFile.getData());
	}

	public XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, XMLScores xmlScores) {
		this(scoresFileName, fileNamePrefix, null, xmlScores.getData());
	}

	public XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, String codeDir, ScoresXML scores) {
		this(scoresFileName, fileNamePrefix, codeDir, scores.getSeriesResults(), scores.getEventResults(), scores.getRaceResults());
	}

	public XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, String codeDir, ScoresXMLFile scoresFile) {
		this(scoresFileName, fileNamePrefix, codeDir, scoresFile.getData());
	}

	public XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, String codeDir, XMLScores xmlScores) {
		this(scoresFileName, fileNamePrefix, codeDir, xmlScores.getData());
	}

	protected XSLTHTMLGenerator(String scoresFileName, String fileNamePrefix, String codeDir, ScoresXMLSeriesResults seriesResults,
			List<ScoresXMLEventResults> eventResults, List<ScoresXMLRaceResults> raceResults) {
		this.fileNamePrefix = fileNamePrefix;
		this.scoresFileName = scoresFileName;
		this.codeDir = codeDir != null ? codeDir + "/" : ""; //$NON-NLS-1$ //$NON-NLS-2$
		this.seriesResults = seriesResults != null ? 1 : 0;
		this.eventResults = eventResults != null ? eventResults.size() : 0;
		this.raceResults = raceResults != null ? raceResults.size() : 0;
	}

	public boolean isLongNames() {
		return longNames;
	}

	public void setLongNames(boolean longNames) {
		this.longNames = longNames;
	}

	public String getScoresFileName() {
		return scoresFileName;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public List<String> getFooters() {
		return footers;
	}

	public List<String> getStyleSheets() {
		return styleSheets;
	}

	public Map<String, String> getFlags() {
		return flags;
	}

	public Map<String, String> getClasses() {
		return classes;
	}

	public Map<String, ByteSource> getMenuPage() throws ExportException {
		return Collections.<String, ByteSource>singletonMap(String.format(longNames ? MENU_LONG_NAME : MENU_NAME, fileNamePrefix, FILE_EXT),
				new ResultsXMLFile(this, codeDir + MENU_FILE).toByteSource());
	}

	public Map<String, ByteSource> getSimplePage() throws ExportException {
		return Collections.<String, ByteSource>singletonMap(String.format(longNames ? SIMPLE_LONG_NAME : SIMPLE_NAME, fileNamePrefix, FILE_EXT),
				new ResultsXMLFile(this, codeDir + SIMPLE_FILE).toByteSource());
	}

	public Map<String, ByteSource> getSplitPages() throws ExportException {
		Map<String, ByteSource> pages = new LinkedHashMap<String, ByteSource>();
		LinkedHashMultimap<ResultsXMLSplit.Type, Integer> splits = LinkedHashMultimap.create();
		String codeFile = codeDir + SPLIT_FILE;

		for (int i = 1; i <= seriesResults; i++) {
			splits.put(ResultsXMLSplit.Type.SERIES, i);
		}

		for (int i = 1; i <= eventResults; i++) {
			splits.put(ResultsXMLSplit.Type.EVENT, i);
		}

		for (int i = 1; i <= raceResults; i++) {
			splits.put(ResultsXMLSplit.Type.RACE, i);
		}

		for (Map.Entry<ResultsXMLSplit.Type, Integer> splitEntry : splits.entries()) {
			ResultsXMLSplit split = new ResultsXMLSplit(String.format(longNames ? SPLIT_LONG_NAME_PREFIX : SPLIT_NAME_PREFIX, fileNamePrefix),
					splitEntry.getKey(), splitEntry.getValue(), FILE_EXT);
			pages.put(split.createFileName(), new ResultsXMLFile(this, codeFile, split).toByteSource());
		}

		return ImmutableMap.copyOf(pages);
	}

	public Map<String, ByteSource> getCodePages() {
		return Maps.toMap(CODE_PAGES, new Function<String, ByteSource>() {
			@Override
			@Nullable
			public ByteSource apply(@Nullable String input) {
				return Resources.asByteSource(Resources.getResource(PackageConstants.RESOURCE_PATH + "/" + input)); //$NON-NLS-1$
			}
		});
	}
}
