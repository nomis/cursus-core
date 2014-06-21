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
package eu.lp0.cursus.test.xml;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public enum Namespace implements LSResourceResolver, LSInput {
	W3C_XML (XMLConstants.W3C_XML_SCHEMA_NS_URI, "http://www.w3.org/XML/1998/namespace", null, "org/w3/www/2001/xml.xsd"), //$NON-NLS-1$ //$NON-NLS-2$

	W3C_XML_SCHEMA (XMLConstants.XML_DTD_NS_URI, XMLConstants.W3C_XML_SCHEMA_NS_URI, "-//W3C//DTD XMLSCHEMA 200102//EN", "org/w3/www/2001/XMLSchema.dtd"), //$NON-NLS-1$ //$NON-NLS-2$

	DATA_V1 (XMLConstants.W3C_XML_SCHEMA_NS_URI, "urn:oid:1.3.6.1.4.1.39777.1.0.1.0.1", null, "eu/lp0/cursus/data-v1.xsd"), //$NON-NLS-1$ //$NON-NLS-2$

	RESULTS_V1 (XMLConstants.W3C_XML_SCHEMA_NS_URI, "urn:oid:1.3.6.1.4.1.39777.1.0.1.2.1", null, "eu/lp0/cursus/results-v1.xsd"), //$NON-NLS-1$ //$NON-NLS-2$

	SCORES_V1 (XMLConstants.W3C_XML_SCHEMA_NS_URI, "urn:oid:1.3.6.1.4.1.39777.1.0.1.1.1", null, "eu/lp0/cursus/scores-v1.xsd"); //$NON-NLS-1$ //$NON-NLS-2$

	private final String type;
	private final String namespaceURI;
	private final String publicId;
	private final String resource;
	private SchemaFactory factory;

	private Namespace(String type, String namespaceURI, String publicId, String resource) {
		this.type = type;
		this.namespaceURI = namespaceURI;
		this.publicId = publicId;
		this.resource = resource;

		try {
			factory = SchemaFactory.newInstance(type);
			factory.setResourceResolver(this);
		} catch (IllegalArgumentException e) {
			factory = null;
		}
	}

	public synchronized Validator newValidator() throws SAXException {
		Validator validator = factory.newSchema(getStreamSource()).newValidator();
		validator.setResourceResolver(this);
		return validator;
	}

	public StreamSource getStreamSource() {
		return new StreamSource(getByteStream(), namespaceURI);
	}

	public InputSource getInputSource() {
		return new InputSource(getByteStream());
	}

	@Override
	public LSInput resolveResource(String _type, String _namespaceURI, String _publicId, String systemId, String baseURI) {
		for (final Namespace ns : values()) {
			if (ns.type.equals(_type)) {
				if (ns.namespaceURI.equals(_namespaceURI) || (ns.publicId != null && ns.publicId.equals(_publicId))) {
					return ns;
				}
			}
		}
		throw new IllegalArgumentException("Unknown resource " + Arrays.toString(new String[] { _type, _namespaceURI, _publicId, systemId, baseURI })); //$NON-NLS-1$
	}

	@Override
	public Reader getCharacterStream() {
		return new InputStreamReader(getByteStream());
	}

	@Override
	public void setCharacterStream(Reader characterStream) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputStream getByteStream() {
		return getClass().getClassLoader().getResourceAsStream(resource);
	}

	@Override
	public void setByteStream(InputStream byteStream) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getStringData() {
		return null;
	}

	@Override
	public void setStringData(String stringData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getSystemId() {
		return null;
	}

	@Override
	public void setSystemId(String systemId) {
		throw new UnsupportedOperationException();

	}

	@Override
	public String getPublicId() {
		return null;
	}

	@Override
	public void setPublicId(String publicId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getBaseURI() {
		return null;
	}

	@Override
	public void setBaseURI(String baseURI) {
		throw new UnsupportedOperationException();

	}

	@Override
	public String getEncoding() {
		return null;
	}

	@Override
	public void setEncoding(String encoding) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean getCertifiedText() {
		return false;
	}

	@Override
	public void setCertifiedText(boolean certifiedText) {
		throw new UnsupportedOperationException();
	}
}
