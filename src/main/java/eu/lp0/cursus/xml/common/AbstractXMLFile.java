/*
	cursus - Race series management program
	Copyright 2012-2014  Simon Arlott

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
package eu.lp0.cursus.xml.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;

import eu.lp0.cursus.util.PackageConstants;
import eu.lp0.cursus.xml.ExportException;
import eu.lp0.cursus.xml.ImportException;

public abstract class AbstractXMLFile<T> {
	private static StreamFactory factory = StreamFactory.newInstance();

	static {
		factory.loadResource(PackageConstants.RESOURCE_PATH + "/beanio.xml"); //$NON-NLS-1$
	}

	private final Class<T> type;
	private T data;

	public AbstractXMLFile(Class<T> type) {
		this.type = type;
	}

	public AbstractXMLFile(Class<T> type, T data) {
		this.type = type;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public final void from(InputStream stream) throws ImportException {
		from(new InputStreamReader(stream, Charsets.UTF_8));
	}

	public final void to(OutputStream stream) throws ExportException {
		to(new OutputStreamWriter(stream, Charsets.UTF_8));
	}

	public final ByteSource toByteSource() throws ExportException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		to(out);
		return ByteSource.wrap(out.toByteArray());
	}

	public final void from(File file) throws ImportException {
		FileInputStream in;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new ImportException(e);
		}

		try {
			from(in);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
	}

	public final void to(File file) throws ExportException {
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			throw new ExportException(e);
		}

		try {
			to(out);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}

	public void from(Reader reader) throws ImportException {
		try {
			BeanReader in = factory.createReader(type.getSimpleName(), reader);
			data = type.cast(in.read());
			in.close();
		} catch (Exception e) {
			throw new ImportException(e);
		}
	}

	public void to(Writer writer) throws ExportException {
		try {
			BeanWriter out = factory.createWriter(type.getSimpleName(), writer);
			out.write(data);
			out.close();
		} catch (Exception e) {
			throw new ExportException(e);
		}
	}
}
