package com.bloggenerate.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fibonacciSeries {
    public static void main(String[] args) {
        int firstNum = 0;
        int secNum = 1;



        Scanner sc = new Scanner(System.in);
        System.out.println("enter n term to produce fibonacci series:");
        int n = sc.nextInt();
        List<Integer> fibonacciSeries = new ArrayList<>();
        convertIntoFibonacciSeries(n,firstNum,secNum,fibonacciSeries);
        System.out.println(fibonacciSeries);
    }

    public static int convertIntoFibonacciSeries(int n,int firstNum,int secNum,List<Integer> fibonacciSeries){
//        System.out.println(firstNum);
        fibonacciSeries.add(firstNum);

        int temp=firstNum+secNum;
        firstNum=secNum;
        secNum=temp;
        
        
        if(n==0||n==1){
              return n;
        }else{
            n=n-1;
            return convertIntoFibonacciSeries(n,firstNum,secNum,fibonacciSeries);

        }
    }
}
