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
package eu.lp0.cursus.test.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;

import eu.lp0.cursus.util.ForwardingLineWriter;

public class ForwardingLineWriterTest {
	@SuppressWarnings("nls")
	@Test
	public void test1() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ForwardingLineWriter lineWriter = new ForwardingLineWriter(new PrintWriter(output));
		lineWriter.write("");
		lineWriter.write("test1");
		lineWriter.write("test2");
		lineWriter.write("test3\n");
		lineWriter.write("test4");
		lineWriter.write("test5");
		lineWriter.write("\n");
		lineWriter.write("\n");
		lineWriter.write("test6\ntest7\ntest8\n");
		lineWriter.write("\n");
		lineWriter.write("test9");
		lineWriter.write("");
		lineWriter.close();

		Assert.assertEquals("test1test2test3\ntest4test5\n\ntest6\ntest7\ntest8\n\ntest9", new String(output.toByteArray()));
	}

	@SuppressWarnings("nls")
	@Test
	public void test2() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ForwardingLineWriter lineWriter = new ForwardingLineWriter(new PrintWriter(output)) {
			int lineNo = 0;

			@Override
			protected void writeLine(String line) throws IOException {
				super.writeLine(line);
				if (lineNo == 0) {
					super.writeLine("added\n");
				}
				lineNo++;
			}
		};
		lineWriter.write("");
		lineWriter.write("test1");
		lineWriter.write("test2");
		lineWriter.write("test3\n");
		lineWriter.write("test4");
		lineWriter.write("test5");
		lineWriter.write("\n");
		lineWriter.write("\n");
		lineWriter.write("test6\ntest7\ntest8\n");
		lineWriter.write("\n");
		lineWriter.write("test9");
		lineWriter.write("");
		lineWriter.close();

		Assert.assertEquals("test1test2test3\nadded\ntest4test5\n\ntest6\ntest7\ntest8\n\ntest9", new String(output.toByteArray()));
	}

	@SuppressWarnings("nls")
	@Test
	public void test3() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ForwardingLineWriter lineWriter = new ForwardingLineWriter(new PrintWriter(output)) {
			int lineNo = 0;

			@Override
			protected void writeLine(String line) throws IOException {
				super.writeLine(line);
				if (lineNo % 2 == 0) {
					super.writeLine("added\n");
				}
				lineNo++;

				if (line.endsWith("\n")) {
					flush();
				}
			}
		};
		lineWriter.write("");
		lineWriter.write("test1");
		lineWriter.write("test2");
		lineWriter.write("test3\n");
		lineWriter.write("test4");
		lineWriter.write("test5");
		lineWriter.write("\n");
		lineWriter.write("\n");
		lineWriter.write("test6\ntest7\ntest8\n");
		lineWriter.write("\n");
		lineWriter.write("test9");
		lineWriter.write("");
		lineWriter.close();

		Assert.assertEquals("test1test2test3\nadded\ntest4test5\n\nadded\ntest6\ntest7\nadded\ntest8\n\nadded\ntest9", new String(output.toByteArray()));
	}

	@SuppressWarnings("nls")
	@Test
	public void test4() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ForwardingLineWriter lineWriter = new ForwardingLineWriter(new PrintWriter(output)) {
			@Override
			public void close() throws IOException {
				flush();
				writeLine("added\n");
				super.close();
			}
		};
		lineWriter.write("");
		lineWriter.write("test1");
		lineWriter.write("test2");
		lineWriter.write("test3\n");
		lineWriter.write("test4");
		lineWriter.write("test5");
		lineWriter.write("\n");
		lineWriter.write("\n");
		lineWriter.write("test6\ntest7\ntest8\n");
		lineWriter.write("\n");
		lineWriter.write("test9");
		lineWriter.write("");
		lineWriter.close();

		Assert.assertEquals("test1test2test3\ntest4test5\n\ntest6\ntest7\ntest8\n\ntest9added\n", new String(output.toByteArray()));
	}

	@SuppressWarnings("nls")
	@Test
	public void test5() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ForwardingLineWriter lineWriter = new ForwardingLineWriter(new PrintWriter(output)) {
			@Override
			protected void writeLine(String line) throws IOException {
				super.writeLine(line);
				if (line.equals("test4")) {
					super.writeLine("added");
				}
			}
		};
		lineWriter.write("");
		lineWriter.write("test1");
		lineWriter.flush();
		lineWriter.write("test2");
		lineWriter.write("test3\n");
		lineWriter.write("test4");
		lineWriter.flush();
		lineWriter.write("test5");
		lineWriter.write("\n");
		lineWriter.write("\n");
		lineWriter.write("test6\ntest7\ntest8\n");
		lineWriter.write("\n");
		lineWriter.write("test9");
		lineWriter.write("");
		lineWriter.close();

		Assert.assertEquals("test1test2test3\ntest4addedtest5\n\ntest6\ntest7\ntest8\n\ntest9", new String(output.toByteArray()));
	}

	@SuppressWarnings("nls")
	@Test
	public void test6() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ForwardingLineWriter lineWriter = new ForwardingLineWriter(new PrintWriter(output));
		lineWriter.write(60);
		lineWriter.append((char)62);
		lineWriter.close();

		Assert.assertEquals("<>", new String(output.toByteArray()));
	}
}
