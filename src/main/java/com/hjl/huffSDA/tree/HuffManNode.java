package com.hjl.huffSDA.tree;

import com.hjl.huffSDA.comparable.ElementVo;

public class HuffManNode {
    private ElementVo element;
    HuffManNode left;
    HuffManNode right;

    public HuffManNode(ElementVo element){
        this.element = element;
    }

    public ElementVo getElement() {
        return element;
    }

    public void setElement(ElementVo element) {
        this.element = element;
    }

    public HuffManNode getLeft() {
        return left;
    }

    public void setLeft(HuffManNode left) {
        this.left = left;
    }

    public HuffManNode getRight() {
        return right;
    }

    public void setRight(HuffManNode right) {
        this.right = right;
    }
}
