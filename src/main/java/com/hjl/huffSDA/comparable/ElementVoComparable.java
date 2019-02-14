package com.hjl.huffSDA.comparable;

import java.util.Comparator;

public class ElementVoComparable implements Comparator<ElementVo> {

    @Override
    public int compare(ElementVo o1, ElementVo o2) {
        return o2.getNum() - o1.getNum();
    }
}
