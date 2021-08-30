package com.study.algorithm.recursion;

import java.util.Scanner;

public class Recursion3 {
    //정수 n이 입력으로 주어질 때 n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하라
    //ex) n=4 -> {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, {2,2}, {1,3}, {3,1} = 7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n : ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(combo(n));

    }
    public static int combo(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3) {
            return 4;
        }else{
            return combo(n-1)+combo(n-2)+combo(n-3);
        }
    }
}
