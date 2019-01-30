package com.leetcode.algorithms;

import java.util.*;

public class LeastInterval {
    private static Map<String, Integer> waiting = new HashMap<>();
    private static int[] init = {0,0,0,0,0,0,0,0,0};
    private static Stack<String> stack = new Stack<>();
    private static int re = 0;
    public static int leastInterval(char[] tasks, int n) {
        getS(tasks);
        while (!stack.isEmpty()) {
            String task = stack.pop();
            if (same()){
                if (waiting.containsKey(task)) {
                    re = re + 1 + waiting.get(task);
                } else {
                    ++re;
                }
            }

            if (waiting.containsKey(task)){
                stack.add(n > task.length()-1 ? task.length()-1 : n, task);
            } else {
                ++re;
                down();
                waiting.put(task, n);
            }
        }
        return re;
    }

    private static void down(){
        List<String> removes = new ArrayList<>();
        for (String s : waiting.keySet()){
            if (waiting.get(s)-1 != 0){
                waiting.put(s, waiting.get(s)-1);
            } else {
                removes.add(s);
            }
        }
        removes.forEach(i -> waiting.remove(i));
    }

    private static boolean same(){
        Set<String> set = new HashSet<>(stack);
        if (set.size() == 1){
            return true;
        }
        return false;
    }

    private static void getS(char[] tasks){
        for (int i = 0; i < tasks.length; i++) {
            stack.add(String.valueOf(tasks[i]));
        }
    }

    public static void main(String[] args) {
        char[] ta = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(ta, 2));

    }
}
