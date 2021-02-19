import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aaron
 * @date 2021-02-09 13:13
 */
public class _05ReplaceSpace {
    // 1. 正则 3 ms	36.3 MB
    public String replaceSpace1(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        return s.replaceAll(" ", "%20");
    }
    // 2. 遍历数组替换 0 ms	36.4 MB
    public String replaceSpace(String s) {
        if (s == null || s.equals("")) {
            return "";
        }

        char[] chars = s.toCharArray();
        char[] newChars = new char[3 * s.length()];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                newChars[j] = '%';
                newChars[++j] = '2';
                newChars[++j] = '0';
                j++;
            } else {
                newChars[j] = chars[i];
                j++;
            }
        }

        return String.valueOf(newChars, 0, j);
    }


    @Test
    public void testRunner() {
        // 异常情况
        Assert.assertEquals("", replaceSpace(null));
        Assert.assertEquals("", replaceSpace(""));
        Assert.assertEquals("%20", replaceSpace(" "));

        String s = "We are happy.";
        Assert.assertEquals("We%20are%20happy.", replaceSpace(s));
    }
}
