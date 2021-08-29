package com.algorithm.dynamicprogramming;

public class DP_fibonacci {
    public static long fib(long n){
        long[] cache = new long[(int)n+1];
        cache[0] = 1;
        if(n>=1) {
            cache[1] = 1;
        }
        for(long i=2;i<n+1;i++){
            cache[(int)i] = cache[(int)i-1]+cache[(int)i-2];
        }
        return cache[(int)n];
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(fib(i));
        }
    }

}
