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
			writeLine(buffer.substring(0, newLine + 1), false);
			buffer.replace(0, buffer.length() - (newLine + 1), buffer.substring(newLine + 1));
			buffer.setLength(buffer.length() - (newLine + 1));
		}
	}

	@Override
	public void flush() throws IOException {
		if (buffer == null) {
			return;
		}
		writer.flush();
	}

	@Override
	public void close() throws IOException {
		if (buffer == null) {
			return;
		}
		writeLine(buffer.toString(), true);
		writer.close();
		buffer = null;
	}

	@Override
	public Writer append(char c) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(c);
		flushBuffer();
		return this;
	}

	@Override
	public Writer append(CharSequence csq, int start, int end) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(csq, start, end);
		flushBuffer();
		return this;
	}

	@Override
	public Writer append(CharSequence csq) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(csq);
		flushBuffer();
		return this;
	}

	@Override
	public void write(char[] cbuf) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(cbuf);
		flushBuffer();
	}

	@Override
	public void write(int c) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(c);
		flushBuffer();
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(str, off, len);
		flushBuffer();
	}

	@Override
	public void write(String str) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(str);
		flushBuffer();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		Preconditions.checkState(buffer != null);
		buffer.append(cbuf, off, len);
		flushBuffer();
	}

	protected void writeLine(String line) throws IOException {
		writer.write(line);
	}

	protected void writeLine(String line, boolean close) throws IOException {
		writeLine(line);
	}
}
