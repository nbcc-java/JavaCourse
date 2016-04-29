package cn.nbcc.chap05.snippets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexExamples {
 
    public static void main(String[] args) {
        // 使用CASE_INSENSITIVE指定大小写不敏感
        Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("ABcabdAb");
        // 使用Matcher中的 find(), group(), start() 和 end() 方法
        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group()
                    + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
        }
 
        // 使用Pattern的 split() 方法
        pattern = Pattern.compile("\\W");
        String[] words = pattern.split("one@two#three:four$five");
        for (String s : words) {
            System.out.println("Split using Pattern.split(): " + s);
        }
 
        // 使用Matcher.replaceFirst() 和 replaceAll() 方法
        pattern = Pattern.compile("1*2");
        matcher = pattern.matcher("11234512678");
        System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
        System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
    }
}
