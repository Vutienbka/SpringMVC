package com.codegym.Model;

public class MyPageViewCounter {
    private int count;

    public MyPageViewCounter() {
    }

    public MyPageViewCounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment(){
        return count++;
    }
}
