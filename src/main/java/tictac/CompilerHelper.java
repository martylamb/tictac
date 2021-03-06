// Automatically generated - DO NOT EDIT!!!
// Generated by tictac Tue Jun 10 20:21:17 EDT 2014
package tictac;  // line 1: 0-18

public class CompilerHelper {

	public static String escapeMethod() {
		StringBuilder _tictacOut = new StringBuilder();
		_tictacOut.append("\n"); // line 4: 0-0
		_tictacOut.append("    // this method is based upon Android's Html.withinStyle() method, published"); // line 5: 0-79
		_tictacOut.append("\n"); // line 5: 79-79
		_tictacOut.append("    // under the Apache 2.0 license, retrieved on June 1, 2014 from"); // line 6: 0-67
		_tictacOut.append("\n"); // line 6: 67-67
		_tictacOut.append("    // http://grepcode.com/file_/repository.grepcode.com/java/ext/com.google.android/android/4.4.2_r1/android/text/Html.java/?v=source"); // line 7: 0-134
		_tictacOut.append("\n"); // line 7: 134-134
		_tictacOut.append("    // License available at http://www.apache.org/licenses/LICENSE-2.0"); // line 8: 0-70
		_tictacOut.append("\n"); // line 8: 70-70
		_tictacOut.append("    private static String _tictacEscape(Object o) {"); // line 9: 0-51
		_tictacOut.append("\n"); // line 9: 51-51
		_tictacOut.append("        if (o == null) return \"\";"); // line 10: 0-33
		_tictacOut.append("\n"); // line 10: 33-33
		_tictacOut.append("        String text = o.toString();"); // line 11: 0-35
		_tictacOut.append("\n"); // line 11: 35-35
		_tictacOut.append("        StringBuilder out = new StringBuilder();"); // line 12: 0-48
		_tictacOut.append("\n"); // line 12: 48-48
		_tictacOut.append("        int end = text.length();"); // line 13: 0-32
		_tictacOut.append("\n"); // line 13: 32-32
		_tictacOut.append("        for (int i = 0; i < end; i++) {"); // line 14: 0-39
		_tictacOut.append("\n"); // line 14: 39-39
		_tictacOut.append("            char c = text.charAt(i);"); // line 15: 0-36
		_tictacOut.append("\n"); // line 15: 36-36
		_tictacOut.append("            if (c == '<') {"); // line 16: 0-27
		_tictacOut.append("\n"); // line 16: 27-27
		_tictacOut.append("                out.append(\"&lt;\");"); // line 17: 0-35
		_tictacOut.append("\n"); // line 17: 35-35
		_tictacOut.append("            } else if (c == '>') {"); // line 18: 0-34
		_tictacOut.append("\n"); // line 18: 34-34
		_tictacOut.append("                out.append(\"&gt;\");"); // line 19: 0-35
		_tictacOut.append("\n"); // line 19: 35-35
		_tictacOut.append("            } else if (c == '&') {"); // line 20: 0-34
		_tictacOut.append("\n"); // line 20: 34-34
		_tictacOut.append("                out.append(\"&amp;\");"); // line 21: 0-36
		_tictacOut.append("\n"); // line 21: 36-36
		_tictacOut.append("            } else if (c >= 0xD800 && c <= 0xDFFF) {"); // line 22: 0-52
		_tictacOut.append("\n"); // line 22: 52-52
		_tictacOut.append("                if (c < 0xDC00 && i + 1 < end) {"); // line 23: 0-48
		_tictacOut.append("\n"); // line 23: 48-48
		_tictacOut.append("                    char d = text.charAt(i + 1);"); // line 24: 0-48
		_tictacOut.append("\n"); // line 24: 48-48
		_tictacOut.append("                    if (d >= 0xDC00 && d <= 0xDFFF) {"); // line 25: 0-53
		_tictacOut.append("\n"); // line 25: 53-53
		_tictacOut.append("                        i++;"); // line 26: 0-28
		_tictacOut.append("\n"); // line 26: 28-28
		_tictacOut.append("                        int codepoint = 0x010000 | (int) c - 0xD800 << 10 | (int) d - 0xDC00;"); // line 27: 0-93
		_tictacOut.append("\n"); // line 27: 93-93
		_tictacOut.append("                        out.append(\"&#\").append(codepoint).append(\";\");"); // line 28: 0-71
		_tictacOut.append("\n"); // line 28: 71-71
		_tictacOut.append("                    }"); // line 29: 0-21
		_tictacOut.append("\n"); // line 29: 21-21
		_tictacOut.append("                }"); // line 30: 0-17
		_tictacOut.append("\n"); // line 30: 17-17
		_tictacOut.append("            } else if (c > 0x7E || c < ' ') {"); // line 31: 0-45
		_tictacOut.append("\n"); // line 31: 45-45
		_tictacOut.append("                out.append(\"&#\").append((int) c).append(\";\");"); // line 32: 0-61
		_tictacOut.append("\n"); // line 32: 61-61
		_tictacOut.append("            } else if (c == ' ') {"); // line 33: 0-34
		_tictacOut.append("\n"); // line 33: 34-34
		_tictacOut.append("                while (i + 1 < end && text.charAt(i + 1) == ' ') {"); // line 34: 0-66
		_tictacOut.append("\n"); // line 34: 66-66
		_tictacOut.append("                    out.append(\"&nbsp;\");"); // line 35: 0-41
		_tictacOut.append("\n"); // line 35: 41-41
		_tictacOut.append("                    i++;"); // line 36: 0-24
		_tictacOut.append("\n"); // line 36: 24-24
		_tictacOut.append("                }"); // line 37: 0-17
		_tictacOut.append("\n"); // line 37: 17-17
		_tictacOut.append("                out.append(' ');"); // line 38: 0-32
		_tictacOut.append("\n"); // line 38: 32-32
		_tictacOut.append("            } else {"); // line 39: 0-20
		_tictacOut.append("\n"); // line 39: 20-20
		_tictacOut.append("                out.append(c);"); // line 40: 0-30
		_tictacOut.append("\n"); // line 40: 30-30
		_tictacOut.append("            }"); // line 41: 0-13
		_tictacOut.append("\n"); // line 41: 13-13
		_tictacOut.append("        }"); // line 42: 0-9
		_tictacOut.append("\n"); // line 42: 9-9
		_tictacOut.append("        return out.toString();"); // line 43: 0-30
		_tictacOut.append("\n"); // line 43: 30-30
		_tictacOut.append("    }"); // line 44: 0-5
		_tictacOut.append("\n"); // line 44: 5-5
		return _tictacOut.toString();
	}

}
