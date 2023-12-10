package crengine.util;

import crengine.util.exception.CrengineRuntimeException;

import java.io.IOError;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 对字符串操作的工具类。
 * @author 炽热S
 */
public class CRString {
    /**分隔符*/
    public final static java.lang.String regexKey = "<~>";

    public final static java.lang.String patternKey = "\\{\\{"+ regexKey + "\\}\\}";

    /**你可以通过<~>来设置需要寻找的关键词<br>例如 as<~>as<br>他会寻找满足的字符，例如 asddas 会返回dd*/
    public static List<java.lang.String> findAll(java.lang.String pattern, java.lang.String string){
        try {
            java.lang.String[] lm = split(pattern);
            List<java.lang.String> sr = new ArrayList<>();
            for (var m2 : string.split(lm[0])){
                if (m2.contains(harmless(lm[1]))){
                    for (int i = 0; i < m2.split(lm[1]).length; i+=2) {
                        sr.add(m2.split(lm[1])[i]);
                    }
                }
            }

            return sr;
        } catch (IOError e){
            throw new CrengineRuntimeException("未知错误，无法查找findAll", e);
        }
    }

    public static List<java.lang.String> findAll(java.lang.String string){
        return findAll(patternKey, string);
    }
    
    public static java.lang.String[] split(java.lang.String regex){
        return regex.split(regexKey);
    }

    public static java.lang.String harmless(java.lang.String text){
        return text.replace("\\{", "{")
                .replace("\\}", "}")
                .replace("\\[", "[")
                .replace("\\]", "]");
    }

    public static boolean havaStr(String text, String hava, String partition, int location){
        String[] lst = text.split(partition);
        return lst[location].contains(hava);
    }

    public static boolean havaPathStr(String text, String hava, int location){
        String[] lst = text.split("/");
        return lst[location].contains(hava);
    }

    public static boolean havaPathStr(String text, String hava){
        String[] lst = text.split("/");
        return lst[lst.length - 1].contains(hava);
    }

    public static String onUFT8(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
