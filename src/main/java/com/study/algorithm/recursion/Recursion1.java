package com.study.algorithm.recursion;

public class Recursion1 {
    //팩토리얼의 재귀호출 처리
    public static void main(String[] args) {
        System.out.println(fact(10));
    }
    public static int fact(int n){
        if(n<=1){
            return 1;
        }else{
         return n*fact(n-1);
        }
    }
}
