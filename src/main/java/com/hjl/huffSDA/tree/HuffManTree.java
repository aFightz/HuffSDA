package com.hjl.huffSDA.tree;

import com.hjl.huffSDA.HuffSDA;

import java.util.HashMap;
import java.util.Map;

public class HuffManTree {

    private HuffManNode head;

    public HuffManNode getHead() {
        return head;
    }

    public void setHead(HuffManNode head) {
        this.head = head;
    }

    public Map<Integer , String> getValuePathMap(){
        Map<Integer , String> map = new HashMap<>();
        look(map , new StringBuffer() , head);
        return map;
    }

    public void look(Map<Integer , String> map , StringBuffer path , HuffManNode node){
        if(node == null){
            return ;
        }
        if(node.getElement().getValue() == HuffSDA.nullValue){
            look(map , new StringBuffer(path).append(1) , node.right);
            look(map , new StringBuffer(path).append(0) , node.left);
        }else if(node.getElement().getValue() == node.getElement().getValue()){
            map.put(node.getElement().getValue() , path.toString());
        }
    }


}
