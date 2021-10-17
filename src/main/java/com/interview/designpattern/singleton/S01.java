package com.interview.designpattern.singleton;

/**
 * Using static inner class
 */
public class S01 {
    private S01() {}

    private static class Holder {
        private static final S01 instance = new S01();
    }

    public static S01 getInstance() {
        return Holder.instance;
    }
}
