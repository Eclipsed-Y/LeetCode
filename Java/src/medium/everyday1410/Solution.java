package medium.everyday1410;

public class Solution {
    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&frasl;", "/").replaceAll("&amp;", "&");
    }
}
