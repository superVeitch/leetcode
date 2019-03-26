package com.leetcode.algorithms;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * ***要考虑最大栈和空栈
 */
public class MinStack {
//    private int[] list;
//    private int size;
//    private int minNum = Integer.MAX_VALUE;
//
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//        list = new int[1000];
//        size = 0;
//    }
//
//    public void push(int x) {
//        if (size < 1000) {
//            list[size++] = x;
//            minNum = Math.min(minNum, x);
//        }
//    }
//
//    public void pop() {
//        if (size >= 1) {
//            int topNum = list[size - 1];
//            size--;
//            if (minNum == topNum) {
//                findMin();
//            }
//        }
//    }
//
//    public int top() {
//        return list[size - 1];
//
//    }
//
//    public int getMin() {
//        return minNum;
//    }
//
//    private void findMin() {
//        minNum = Integer.MAX_VALUE;
//        for (int i = 0; i < size; i++) {
//            minNum = Math.min(minNum, list[i]);
//        }
//    }

    private int[] list;
    private int size;

    /** initialize your data structure here. */
    public MinStack() {
        list = new int[1000];
        size = 0;
    }

    public void push(int x) {
        if (size < 1000) {
            list[size] = x;
            ++size;
        }
    }

    public void pop() {
        if (size>=1){
            --size;
            list[size] = 0;
        }
    }

    public int top() {
        return list[size-1];
    }

    public int getMin() {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (list[i] < minNum){
                minNum = list[i];
            }
        }
        return minNum;
    }
}
