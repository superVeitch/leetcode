package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || s == null) {
            return 0;
        }
        int re = 0;
        int m = 0;
        String[] source = s.split("");
        List<String> f = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if (f.contains(source[i])) {
                if (m > re) {
                    re = m;
                }
                if (i == source.length -1) {
                    m--;
                    f.remove(source[i]);
                } else {
                    m = m-(f.indexOf(source[i])+1);
                    f.removeAll(f.subList(0, f.indexOf(source[i])+1));
                }

            }
            f.add(source[i]);
            m++;
        }
        if (m > re) {
            re = m;
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
