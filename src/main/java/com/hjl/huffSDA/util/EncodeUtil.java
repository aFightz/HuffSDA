package com.hjl.huffSDA.util;

import com.hjl.huffSDA.tree.HuffManTree;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public class EncodeUtil {

    public static final int newLineSize = 50;
    public static final int codeSize = 32;

    public static void encode(File source , HuffManTree tree , String targetPath) throws Exception {
        File file = new File(targetPath);
        Map<Integer , String> map = tree.getValuePathMap();
        StringBuffer stringBuffer = new StringBuffer();
        int size;
        int writerSize = 0;
        try(FileInputStream fis = new FileInputStream(source);FileWriter writer =new FileWriter(file)){
            byte [] bytes = new byte[1024];
            while((size = fis.read(bytes)) != -1){
                for(int i = 0 ; i <size ; i ++){
                    byte b = bytes[i];
                    String path = map.get(b + 128);
                    stringBuffer.append(path);
                    if(stringBuffer.length() >= codeSize){
                        int end = codeSize < stringBuffer.length()? codeSize : stringBuffer.length();
                        String value = stringBuffer.substring(0 , end);
                        long code = Long.valueOf(value , 2);
                        writer.write(String.valueOf(code));

//                        writerSize++;
//                        if(writerSize % newLineSize == 0){
//                            writer.write("\n");
//                        }else{
//                            writer.write(" ");
//                        }

                        stringBuffer = new StringBuffer(stringBuffer.substring(end));
                    }
                }
                if(stringBuffer.length() > 0){
                    String value = stringBuffer.substring(0);
                    long code = Long.valueOf(value , 36);
                    writer.write(String.valueOf(code));
                }

            }
        }


    }

    public void decode(FileInputStream fis , String targetPath){

    }

//    public String toBinaryString(String value){
//        StringBuffer sb = new StringBuffer();
//        char [] chars = value.toCharArray();
//        for(char c : chars){
//
//            BigDecimal b;
//
//        }
//
//        return sb.toString();
//    }

    public static void main(String[] args) {
        System.out.println(changeStringToInt("10101010"));
    }

    public static int changeStringToInt(String s){
        int v1=(s.charAt(0)-48)*128;
        int v2=(s.charAt(1)-48)*64;
        int v3=(s.charAt(2)-48)*32;
        int v4=(s.charAt(3)-48)*16;
        int v5=(s.charAt(4)-48)*8;
        int v6=(s.charAt(5)-48)*4;
        int v7=(s.charAt(6)-48)*2;
        int v8=(s.charAt(7)-48)*1;
        return v1+v2+v3+v4+v5+v6+v7+v8;

    }


}
