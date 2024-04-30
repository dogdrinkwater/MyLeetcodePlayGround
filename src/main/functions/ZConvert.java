package main.functions;

import java.util.ArrayList;
import java.util.List;

public class ZConvert {
    public static void main(String[] args) {
        convert("PAYPALISHIRING", 4);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }
}

