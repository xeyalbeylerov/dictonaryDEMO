/*
 * Copyright (c) 2020.
 * xeyalbeylerov
 */

package util;

public class TestGenerics {
    public static void main(String[] args) {

//
        Float a = TestGenerics.<Float>foo(new Float(5));
        System.out.println(a);
    }

    public static <T> T foo(T i) {
        return (T) i;
    }
}
