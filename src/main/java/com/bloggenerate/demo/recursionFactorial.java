package com.bloggenerate.demo;

import java.util.Scanner;

public class recursionFactorial {

        public static void main(String[] arg) {

            Scanner sc = new Scanner(System.in);
            System.out.println("which Factorial do oyu want:");
            int num = sc.nextInt();
            int sumOfNum = sumOfFactorial(num);
            System.out.println(sumOfNum);
        }

        public static int sumOfFactorial(int num) {
            if (num == 1 || num == 0) {
                return num;
            } else {
                return (num * sumOfFactorial(num - 1));
            }
        }

    }
