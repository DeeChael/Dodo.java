package net.deechael.dodo.utils;

public final class StringUtils {

    public static String safePattern(String string) {
        String[] keywords = new String[]{"*", ".", "?", "+", "$", "^", "[", "]", "(", ")", "{", "}", "|", "\"", "/"};
        for (String keyword : keywords) {
            string = string.replace(keyword, "\\" + keyword);
        }
        return string;
    }

    public static String unsafePattern(String string) {
        String[] keywords = new String[]{"*", ".", "?", "+", "$", "^", "[", "]", "(", ")", "{", "}", "|", "\"", "/"};
        for (String keyword : keywords) {
            string = string.replace("\\" + keyword, keyword);
        }
        return string;
    }

    private StringUtils() {
    }

}
