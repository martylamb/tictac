package tictac;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Splits individual lines of text into the four different types of tokens used
 * by our templates.
 * 
 * @author mlamb
 */
class Tokenizer implements Iterable<Tokenizer.Token>, Iterator<Tokenizer.Token> {
    
    private int _lineNumber = 0;
    private String _line;
    private int _pos;
    
    // the types of delimited tokens we search for, in the order in which we check.
    // order is important if one start delimiter is an extension of another (like UNESCAPED vs. ESCAPED),
    // in which case we need to check for the longest match first.
    private final TokenType[] dTypes = { TokenType.JAVA, TokenType.UNESCAPED, TokenType.ESCAPED };

    public Tokenizer() {}
    
    public Tokenizer reset(String s) {
        _line = s;
        _pos = 0;
        ++_lineNumber;
        return this;
    }

    @Override
    public Iterator<Token> iterator() { 
        return this;
    }

    @Override
    public boolean hasNext() {
        return _pos < _line.length();
    }

    @Override
    public Token next() {
        if (!hasNext()) throw new NoSuchElementException();
        return bestMatch();
    }

    public Token eol() {
        return new Token(_lineNumber, _line.length(), _line.length(), "\n", TokenType.RAW);
    }
    
    private Token bestMatch() {
        Token result = null;
        for (TokenType type : dTypes) {
            Token token = match(type);
            if (token == null) continue;
            if (result == null) result = token;
            else if (token.start < result.start ) result = token; // we want the first match at earliest position
        }
        if (result == null) {
            // no matches, consume the whole line
            result = new Token(_lineNumber, _pos, _line.length(), _line.substring(_pos), TokenType.RAW);
        } else if (result.start != _pos) {
            // got some raw text before first delimited token
            result = new Token(_lineNumber, _pos, result.start, _line.substring(_pos, result.start), TokenType.RAW);
        }
        _pos = result.end;
        return result;
    }
    
    private Token match(TokenType t) {
        int start = _line.indexOf(t.open, _pos);
        if (start < 0) return null; // no match
        int end = _line.indexOf(t.close, start + t.open.length());
        String body = (end < 0) ? _line.substring(start + t.open.length()) : _line.substring(start + t.open.length(), end);
        end = (end < 0) ? _line.length() : end + t.close.length();
        return new Token(_lineNumber, start, end, body, t);
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() not implemented");
    }
    
    public enum TokenType {
        RAW(null, null),
        JAVA("%%", "%%"),
        ESCAPED("<%", "%>"),
        UNESCAPED("<%!", "%>");
        
        public final String open, close;
        private TokenType(String open, String close) {
            this.open = open;
            this.close = close;
        }
    }

    public class Token {
        public final int lineNumber;
        public final int start, end;
        public final String body;
        public final Tokenizer.TokenType type;

        public Token(int lineNumber, int start, int end, String body, Tokenizer.TokenType type) {
            this.lineNumber = lineNumber;
            this.start = start;
            this.end = end;
            this.body = body;
            this.type = type;
        }
        
        public boolean isEmpty() {
            if (body == null || body.length() == 0) return true;            
            if (type != TokenType.RAW && body.trim().length() == 0) return true;
            return false;
        }
        
        public String comment() {
            return String.format("// line %d: %d-%d", lineNumber, start, end);
        }
            
        @Override public String toString() {
            return String.format("%d  %s: [%s] %d-%d", lineNumber, type, body, start, end);
        }
    }
    
}
