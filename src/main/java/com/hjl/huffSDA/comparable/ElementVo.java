package com.hjl.huffSDA.comparable;

public class ElementVo {
    private int value;
    private int num;

    public ElementVo(int value , int num){
        this.value = value;
        this.num = num;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void addNum(int num){
        this.num += num;
    }
}
