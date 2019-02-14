package com.hjl.huffSDA;

import com.hjl.huffSDA.comparable.ElementVo;
import com.hjl.huffSDA.comparable.ElementVoComparable;
import com.hjl.huffSDA.tree.HuffManNode;
import com.hjl.huffSDA.tree.HuffManTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class HuffSDA {
    public static void main(String[] args) {
        String sourcePath = args[0];
        String targetPath = args[1];

        File source = new File(sourcePath);
        if(!source.exists()){
            System.out.println("source path error");
            return ;
        }
    }

    public void compress(File source) {
        try(FileInputStream fis = new FileInputStream(source)){
            int [] table = statistics(fis);
            HuffManTree huffManTree = HuffManTreeCreater(table);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public int []  statistics(FileInputStream fis) throws IOException {
        int [] table = new int[256];
        byte [] bytes = new byte[1024];
        int size;
        while((size = fis.read(bytes)) != -1){
            for(int i = 0 ; i <size ; i ++){
                byte b = bytes[i];
                table[b + 128]++;
            }
        }
        return table;
    }

    public HuffManTree HuffManTreeCreater(int [] table){
        List<ElementVo> elements = new ArrayList<>();

        for(int i = 0 ; i < table.length ; i ++){
            elements.add(new ElementVo(i , table[i]));
        }

        Collections.sort(elements , new ElementVoComparable());

        HuffManTree tree = new HuffManTree();
        tree.setHead(new HuffManNode(new ElementVo(-1 , 0)));

        for(ElementVo element : elements){
            if(element.getNum() == 0){
                break;
            }
            HuffManNode head = tree.getHead();
            HuffManNode node = new HuffManNode(element);
            if(head.getLeft() == null){
                head.setLeft(node);
                head.getElement().addNum(element.getNum());
            }else if(head.getRight() == null){
                head.setRight(node);
                head.getElement().addNum(element.getNum());
            }else{
                HuffManNode newHead = new HuffManNode(new ElementVo(-1 , 0));
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
