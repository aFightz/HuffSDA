package com.hjl.huffSDA.tree;

public class HuffManTree {

    private HuffManNode head;

    public HuffManNode getHead() {
        return head;
    }

    public void setHead(HuffManNode head) {
        this.head = head;
    }

    public String getValuePath(int value){
        StringBuffer path = new StringBuffer();
        HuffManNode now = head;
        while(true){
            if(now.getElement().getValue() == -1){

                continue;
            }
            break;
        }
        return path.toString();
    }
}
