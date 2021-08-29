package com.algorithm.dynamicprogramming;

public class DP_fibonacci {
    public static int fib(int n){
        int[] cache = new int[n+1];
        cache[0] = 1;
        if(n>1) {
            cache[1] = 1;
        }
        for(int i=2;i<n+1;i++){
            cache[i] = cache[i-1]+cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(fib(i));
        }
    }

}
