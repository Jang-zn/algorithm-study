package com.algorithm.recursion;

public class Recursion4 {
    //fibonacci 수열
    public static int fib(int n){
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.println(fib(i));
        }
    }
}
