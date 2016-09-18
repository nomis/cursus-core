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
package uk.uuid.cursus.xml.results;

import java.util.ArrayList;
import java.util.Map;

import uk.uuid.cursus.publish.html.XSLTHTMLGenerator;
import uk.uuid.cursus.xml.results.data.ResultsXMLClass;
import uk.uuid.cursus.xml.results.data.ResultsXMLFlag;
import uk.uuid.cursus.xml.results.data.ResultsXMLInclude;
import uk.uuid.cursus.xml.results.data.ResultsXMLSplit;

public class ResultsXML {
	public ResultsXML() {
	}

	public ResultsXML(XSLTHTMLGenerator generator, String xslStyleSheetHref) {
		this(generator, xslStyleSheetHref, null);
	}

	public ResultsXML(XSLTHTMLGenerator generator, String xslStyleSheetHref, ResultsXMLSplit split) {
		this.xslStyleSheetHref = xslStyleSheetHref;

		this.loadURI = generator.getScoresFileName();

		for (String header : generator.getHeaders()) {
			headers.add(new ResultsXMLInclude(header));
		}

		for (String footer : generator.getFooters()) {
			footers.add(new ResultsXMLInclude(footer));
		}

		for (String styleSheet : generator.getStyleSheets()) {
			styleSheets.add(new ResultsXMLInclude(styleSheet));
		}

		for (Map.Entry<String, String> flag : generator.getFlags().entrySet()) {
			flags.add(new ResultsXMLFlag(flag.getKey(), flag.getValue()));
		}

		this.split = split;

		for (Map.Entry<String, String> class_ : generator.getClasses().entrySet()) {
			classes.add(new ResultsXMLClass(class_.getKey(), class_.getValue()));
		}
	}

	private String xslStyleSheetHref;

	public String getXslStyleSheetHref() {
		return xslStyleSheetHref;
	}

	public void setXslStyleSheetHref(String xslStyleSheetHref) {
		this.xslStyleSheetHref = xslStyleSheetHref;
	}

	private String loadURI;

	public String getLoadURI() {
		return loadURI;
	}

	public void setLoadURI(String loadURI) {
		this.loadURI = loadURI;
	}

	private ArrayList<ResultsXMLInclude> headers = new ArrayList<ResultsXMLInclude>();

	public ArrayList<ResultsXMLInclude> getHeaders() {
		return headers;
	}

	public void setHeaders(ArrayList<ResultsXMLInclude> headers) {
		this.headers = headers;
	}

	private ArrayList<ResultsXMLInclude> footers = new ArrayList<ResultsXMLInclude>();

	public ArrayList<ResultsXMLInclude> getFooters() {
		return footers;
	}

	public void setFooters(ArrayList<ResultsXMLInclude> footers) {
		this.footers = footers;
	}

	private ArrayList<ResultsXMLInclude> styleSheets = new ArrayList<ResultsXMLInclude>();

	public ArrayList<ResultsXMLInclude> getStyleSheets() {
		return styleSheets;
	}

	public void setStyleSheets(ArrayList<ResultsXMLInclude> styleSheets) {
		this.styleSheets = styleSheets;
	}

	private ArrayList<ResultsXMLFlag> flags = new ArrayList<ResultsXMLFlag>();

	public ArrayList<ResultsXMLFlag> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<ResultsXMLFlag> flags) {
		this.flags = flags;
	}

	private ResultsXMLSplit split;

	public ResultsXMLSplit getSplit() {
		return split;
	}

	public void setSplit(ResultsXMLSplit split) {
		this.split = split;
	}

	private ArrayList<ResultsXMLClass> classes = new ArrayList<ResultsXMLClass>();

	public ArrayList<ResultsXMLClass> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<ResultsXMLClass> classes) {
		this.classes = classes;
	}
}