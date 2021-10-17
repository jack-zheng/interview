package com.interview.designpattern.singleton;

/**
 * Double check
 */
public class S02 {
    private S02() {}

    private static volatile S02 instance;

    public static S02 getInstance() {
        if (instance == null) {
            synchronized (S02.class) {
                if (instance == null) {
                    instance = new S02();
                }
            }
        }
        return instance;
    }
}
