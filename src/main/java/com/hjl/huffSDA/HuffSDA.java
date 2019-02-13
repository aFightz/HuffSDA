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

    public Map<Byte , Integer>  statistics(File source) {
        Map<Byte , Integer> map = new HashMap<>();
        try(FileInputStream fis = new FileInputStream(source)){
            byte [] bytes = new byte[1024];
            int size;
            while((size = fis.read(bytes)) != -1){
                for(int i = 0 ; i <size ; i ++){
                    byte b = bytes[i];
                    map.put(b , map.getOrDefault(b , 0) + 1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public void HuffManTreeCreater(Map<Byte , Integer> map){

    }
}
