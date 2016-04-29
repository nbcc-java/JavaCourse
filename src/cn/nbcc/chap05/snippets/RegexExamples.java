package cn.nbcc.chap05.snippets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexExamples {
 
    public static void main(String[] args) {
        // ʹ��CASE_INSENSITIVEָ����Сд������
        Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("ABcabdAb");
        // ʹ��Matcher�е� find(), group(), start() �� end() ����
        while (matcher.find()) {
            System.out.println("Found the text \"" + matcher.group()
                    + "\" starting at " + matcher.start()
                    + " index and ending at index " + matcher.end());
        }
 
        // ʹ��Pattern�� split() ����
        pattern = Pattern.compile("\\W");
        String[] words = pattern.split("one@two#three:four$five");
        for (String s : words) {
            System.out.println("Split using Pattern.split(): " + s);
        }
 
        // ʹ��Matcher.replaceFirst() �� replaceAll() ����
        pattern = Pattern.compile("1*2");
        matcher = pattern.matcher("11234512678");
        System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
        System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
    }
}
