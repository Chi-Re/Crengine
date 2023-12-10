package crengine.util;

import crengine.Core;
import crengine.util.io.CRFile;

/**
 * @author 炽热S
 */
public class CRLog {
    public static CRFile logFile = Core.settings.getDataDirectory().child("last_log.txt");

    public static String tag(String... tag){
        StringBuilder s = new StringBuilder();
        for (var t : tag){
            s.append("[").append(t).append("] ");
        }
        return s.toString();
    }

    public static void print(String text){
        System.out.println(text);//?
    }

    public static void write(String text){
        logFile.writeString(text, true);
    }


}
