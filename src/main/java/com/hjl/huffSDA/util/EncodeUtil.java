package com.hjl.huffSDA.util;

import com.hjl.huffSDA.tree.HuffManTree;

import java.io.*;
import java.util.Map;

public class EncodeUtil {

    public static final int newLineSize = 50;
    public static final int codeSize = 8;

    public static void encode(File source , HuffManTree tree , String targetPath) throws Exception {
        File file = new File(targetPath);
        Map<Integer , String> map = tree.getValuePathMap();
        StringBuffer stringBuffer = new StringBuffer();
        int size;
        try(FileInputStream fis = new FileInputStream(source);DataOutputStream writer =new DataOutputStream(new FileOutputStream(file))){
            byte [] bytes = new byte[1024];
            while((size = fis.read(bytes)) != -1){
                for(int i = 0 ; i <size ; i ++){
                    byte b = bytes[i];
                    String path = map.get(b + 128);
                    stringBuffer.append(path);
                    while(stringBuffer.length() >= codeSize){
                        String value = stringBuffer.substring(0 , codeSize);
                        byte code = (byte)Integer.parseInt(value , 2);
                        writer.write(code);

                        stringBuffer = new StringBuffer(stringBuffer.substring(codeSize));
                    }
                }

            }
            while(stringBuffer.length() > 0){
                int end = codeSize < stringBuffer.length()? codeSize:stringBuffer.length();
                String value = stringBuffer.substring(0 , end);
                byte code = (byte)Integer.parseInt(value , 2);
                writer.write(code);
                stringBuffer = new StringBuffer(stringBuffer.substring(end));
            }
        }


    }

    private void writeValue(){

    }

    public void decode(FileInputStream fis , String targetPath){

    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\huangjunlong\\Desktop\\hjl.txt");

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            byte b = (byte)Integer.parseInt("011111111" , 2);
            dos.write(b);
        }
    }



}
