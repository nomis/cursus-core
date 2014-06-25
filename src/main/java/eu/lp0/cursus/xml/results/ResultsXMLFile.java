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
package eu.lp0.cursus.xml.results;

import java.io.IOException;
import java.io.Writer;

import com.google.common.escape.Escaper;
import com.google.common.xml.XmlEscapers;

import eu.lp0.cursus.publish.html.XSLTHTMLGenerator;
import eu.lp0.cursus.util.ForwardingLineWriter;
import eu.lp0.cursus.xml.ExportException;
import eu.lp0.cursus.xml.common.AbstractXMLFile;
import eu.lp0.cursus.xml.results.data.ResultsXMLSplit;

public class ResultsXMLFile extends AbstractXMLFile<ResultsXML> {
	private static final Escaper XML_ATTRIBUTE_ESCAPER = XmlEscapers.xmlAttributeEscaper();

	private final String xslStyleSheetHref;

	public ResultsXMLFile() {
		super(ResultsXML.class);
		this.xslStyleSheetHref = null;
	}

	public ResultsXMLFile(XSLTHTMLGenerator generator, String xslStyleSheetHref) {
		super(ResultsXML.class, new ResultsXML(generator, xslStyleSheetHref));
		this.xslStyleSheetHref = xslStyleSheetHref;
	}

	public ResultsXMLFile(XSLTHTMLGenerator generator, String xslStyleSheetHref, ResultsXMLSplit split) {
		super(ResultsXML.class, new ResultsXML(generator, xslStyleSheetHref, split));
		this.xslStyleSheetHref = xslStyleSheetHref;
	}

	@Override
	public void to(Writer writer) throws ExportException {
		super.to(new ForwardingLineWriter(writer) {
			@Override
			protected void writeLine(String line) throws IOException {
				super.writeLine(line);

				if (line.startsWith("<?xml ")) { //$NON-NLS-1$
					super.writeLine("<?xml-stylesheet type=\"text/xsl\" href=\"" + XML_ATTRIBUTE_ESCAPER.escape(xslStyleSheetHref) + "\"?>\n"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		});
	}
}