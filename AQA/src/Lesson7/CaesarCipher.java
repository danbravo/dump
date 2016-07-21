package Lesson7;

public class CaesarCipher {
    private static int key;
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ?!%$#()&@-,.=+:;";

    public CaesarCipher(int aKey) {
        setKey(aKey);
    }

    public void setKey(int newKey) {
        key = newKey;
    }

    public String encode(String textToEncode) {
        StringBuilder text = new StringBuilder(textToEncode);
        for (int i=0; i<text.length(); i++) {
            for (int j=0; j<CHARS.length(); j++) {
                if (text.charAt(i)==CHARS.charAt(j)) {
                    if ((j+key)<CHARS.length()) {
                        text.setCharAt(i, CHARS.charAt(j+key));
                        break;
                    } else {
                        text.setCharAt(i, CHARS.charAt((j+key)-CHARS.length()));
                        break;
                    }
                }
            }
        }
        return text.toString();
    }

    public String decode(String textToDecode) {
        StringBuilder text = new StringBuilder(textToDecode);
        for (int i=0; i<text.length(); i++) {
            for (int j=0; j<CHARS.length(); j++) {
                if (text.charAt(i)==CHARS.charAt(j)) {
                    if ((j-key)<0) {
                        text.setCharAt(i, CHARS.charAt((j-key)+CHARS.length()));
                        break;
                    } else {
                        text.setCharAt(i, CHARS.charAt(j-key));
                        break;
                    }
                }
            }
        }
        return text.toString();
    }
}
