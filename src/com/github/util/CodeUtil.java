package com.github.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        //1.创建一个集合
        ArrayList<Character> list = new ArrayList<>();//52      索引的范围: 0 ~ 51
        //2.添加字母 a-z A-Z
        for(int i=0;i<26;i++){
            list.add((char)('a'+i));//a-z
            list.add((char)('A'+i));//A-Z
        }
        //3.生成随机字符串
        String result = "";
        Random r = new Random();
        for(int i=0;i<4;i++){
            int randomIndex=r.nextInt(list.size());
            char c = list.get(randomIndex);
            result=result+c;
        }
        //4.拼接数字0-9随机
        int number = r.nextInt(10);
        result=result+number;
        //5.字符串转换为字符数组
        char[] chars = result.toCharArray();
        int index = r.nextInt(chars.length);
        //6.4索引上的数字和随机索引上数字进行交换
        char temp =chars[4];
        chars[4]=chars[index];
        chars[index]=temp;
        //7.将字符数组转换回字符串
        String code = new String(chars);
        return code;
    }
}
