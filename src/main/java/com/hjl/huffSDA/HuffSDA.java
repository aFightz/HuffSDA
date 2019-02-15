package com.hjl.huffSDA;

import com.hjl.huffSDA.comparable.ElementVo;
import com.hjl.huffSDA.comparable.ElementVoComparable;
import com.hjl.huffSDA.tree.HuffManNode;
import com.hjl.huffSDA.tree.HuffManTree;
import com.hjl.huffSDA.util.EncodeUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class HuffSDA {
    public final static int nullValue = -300;
    public static void main(String[] args) throws Exception {
        String sourcePath = args[0];
        String targetPath = args[1];
        File source = new File(sourcePath);
        if(!source.exists()){
            System.out.println("source path error");
            return ;
        }
        compress(source , targetPath);

    }

    public static void compress(File source , String targetPath) throws Exception{
        int [] table = statistics(source);
        HuffManTree huffManTree = HuffManTreeCreater(table);
        EncodeUtil.encode(source , huffManTree , targetPath);

    }

    public static int [] statistics(File source) throws IOException {
        int [] table = new int[256];
        try(FileInputStream fis = new FileInputStream(source)){
            byte [] bytes = new byte[1024];
            int size;
            while((size = fis.read(bytes)) != -1){
                for(int i = 0 ; i <size ; i ++){
                    byte b = bytes[i];
                    table[b + 128]++;
                }
            }
        }
        return table;
    }

    public static HuffManTree HuffManTreeCreater(int [] table){
        List<ElementVo> elements = new ArrayList<>();

        for(int i = 0 ; i < table.length ; i ++){
            elements.add(new ElementVo(i , table[i]));
        }

        Collections.sort(elements , new ElementVoComparable());

        HuffManTree tree = new HuffManTree();
        tree.setHead(new HuffManNode(new ElementVo(nullValue , 0)));
        int lastNum = 0;
        for(ElementVo element : elements){
            if(element.getNum() == 0){
                continue;
            }
            while(lastNum != 0 && element.getNum() <= lastNum){
                element.addNum(1);
            }
            lastNum = element.getNum();

            HuffManNode head = tree.getHead();
            HuffManNode node = new HuffManNode(element);
            if(head.getLeft() == null){
                head.setLeft(node);
                head.getElement().addNum(element.getNum());
            }else if(head.getRight() == null){
                head.setRight(node);
                head.getElement().addNum(element.getNum());
            }else{
                HuffManNode newHead = new HuffManNode(new ElementVo(nullValue , 0));
                if(element.getNum() >= head.getElement().getNum()){
                    newHead.setLeft(node);
                    newHead.setRight(head);
                }else{
                    newHead.setLeft(head);
                    newHead.setRight(node);
                }
                newHead.getElement().addNum(element.getNum() + head.getElement().getNum());
                tree.setHead(newHead);
            }


        }
        return tree;
    }


}
