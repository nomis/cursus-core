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
package eu.lp0.cursus.util;

import java.io.IOException;
import java.io.Writer;

import com.google.common.base.Preconditions;

public class ForwardingLineWriter extends Writer {
	protected Writer writer;

	private StringBuilder buffer = new StringBuilder();

	public ForwardingLineWriter(Writer writer) {
		this.writer = writer;
	}

	private void flushBuffer() throws IOException {
		int newLine;
		while ((newLine = buffer.indexOf("\n")) != -1) { //$NON-NLS-1$
			String line = buffer.substring(0, newLine + 1);
			buffer.replace(0, buffer.length() - (newLine + 1), buffer.substring(newLine + 1));
			buffer.setLength(buffer.length() - (newLine + 1));
			writeLine(line);
		}
	}

	@Override
	public final void flush() throws IOException {
		if (buffer == null) {
			return;
		}
		flushBuffer();
		if (buffer.length() > 0) {
			writeLine(buffer.toString());
			buffer.setLength(0);
		}
		writer.flush();
	}

	@Override
	public void close() throws IOException {
		flush();
		writer.close();
		buffer = null;
	}

	@Override
	public final void write(int c) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append((char)c);
		flushBuffer();
	}

	@Override
	public final void write(char[] cbuf) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(cbuf);
		flushBuffer();
	}

	@Override
	public final void write(char[] cbuf, int off, int len) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(cbuf, off, len);
		flushBuffer();
	}

	@Override
	public final void write(String str, int off, int len) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(str, off, off + len);
		flushBuffer();
	}

	@Override
	public final void write(String str) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(str);
		flushBuffer();
	}

	protected void writeLine(String line) throws IOException {
		writer.write(line);
	}
}
