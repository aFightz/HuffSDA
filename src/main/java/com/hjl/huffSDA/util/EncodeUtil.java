package com.hjl.huffSDA.util;

import com.hjl.huffSDA.tree.HuffManTree;

import java.io.FileInputStream;

public class EncodeUtil {

    public static void encode(FileInputStream fis , HuffManTree tree) throws Exception {
        byte [] bytes = new byte[1024];
        int size;
        while((size = fis.read(bytes)) != -1){
            for(int i = 0 ; i <size ; i ++){
                byte b = bytes[i];

            }
        }
    }
}
