package com.bloggenerate.demo;

public class test {
    public static void main(String[] args) {
        int a= 0;
        int b=1;
        int temp;


        for (int i=0; i<10;i++){
            System.out.println(a);
            temp=a+b;
            a=b;
            b=temp;

        }
    }
}
