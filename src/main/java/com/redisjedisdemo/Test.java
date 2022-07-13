package com.redisjedisdemo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入学生人数");
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        int num = 0;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("请输入数字！");
            return;
        }
        String[] names = new String[num];
        sc.nextLine();

        for(int i = 0; i < num; i++){
            System.out.println("学生"+(i+1));
            String name = sc.nextLine();
            names[i] = name;
        }
        System.out.println("请输入要查找的学生");
        String s = sc.nextLine();
        for(int j = 0; j < names.length; j++){
            if(names[j].equals(s) ){
                System.out.println("有这个学生");
                return;
            }
        }
        System.out.println("没有这个学生");

    }
}
