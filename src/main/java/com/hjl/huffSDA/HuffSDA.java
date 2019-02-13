package com.hjl.huffSDA;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

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

    public void compress(File source) throws Exception{

    }

    public int []  statistics(File source) {
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return table;
    }

    public void HuffManTreeCreater(int [] table){

    }
}
