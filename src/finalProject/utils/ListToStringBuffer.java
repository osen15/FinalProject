package finalProject.utils;

import java.util.ArrayList;

public class ListToStringBuffer {
    public static <T> StringBuffer listInStrBuff(ArrayList<T> ts) {
        StringBuffer stBuff = new StringBuffer();
        for (T t : ts) {
            if (ts.lastIndexOf(t) == (ts.size() - 1)) {
                stBuff.append(t.toString());
                break;
            }
            stBuff.append(t.toString()).append("\r\n");

        }

        return stBuff;
    }
}
