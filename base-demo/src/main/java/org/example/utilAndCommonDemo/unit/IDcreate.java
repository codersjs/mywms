package org.example.utilAndCommonDemo.unit;

import java.util.Random;

public class IDcreate {

    /**
     * 36个
     */
    private static char[] R = {
        '1','2','3','4','5','6','7','8','9','0',
        'A','B','C','D','E','F','G','H','I','J',
        'K','L','M','N','O','P','Q','R','S','T',
        'U','V','W','X','Y','Z'
    };

    /**
     * 获取长度为ch.length+5位的ID
     * @return
     */
    public static String getRandomBatchId(String ch) {
        String ans = "";
        String random = getStringId(5);
        ans = ch+random;
        return ans;
    }

    /**
     * 获取长度为6位的ID
     * @return
     */
    public static String getRandomBatchId() {
        String ch = "B";
        String ans = "";
        String random = getStringId(5);
        ans = ch+random;
        return ans;
    }

    /**
     * 获取长度为length的类型为String的ID
     * @param length
     * @return
     */
    public static String getStringId(Integer length) {
        String ans = "";
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            ans += R[r.nextInt(36)];
        }
        return ans;
    }

    /**
     * 获取长度为length的类型为Long的ID,最大长度为18
     * @param length
     * @return
     */
    public static Long getLongId(Integer length) {
        if (length>=18) length = 18;
        String ans = "";
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            ans += R[r.nextInt(9)];
            if (i == 0 && ans.equals("0")) {
                ans = "";
                i--;
            }
        }
        return Long.valueOf(ans);
    }

    public static Long getLongIdMIN6() {
        String ans = "";
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            if (r.nextInt(100)>=20) {
                ans += R[r.nextInt(9)];
                if (i == 0 && ans.equals("0")) {
                    ans = "";
                    i--;
                }
            }
        }

        while (ans.length()<=5) {
            ans += R[r.nextInt(9)];
        }

        return Long.valueOf(ans);
    }

    /**
     * 获取长度为length的类型为String的纯数字ID
     * @param length
     * @return
     */
    public static String getNUMStringId(Integer length) {
        String ans = "";
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            ans += R[r.nextInt(10)];
        }
        return ans;
    }

}
