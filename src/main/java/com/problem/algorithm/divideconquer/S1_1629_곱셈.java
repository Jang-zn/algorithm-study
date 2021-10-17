package com.problem.algorithm.divideconquer;

import java.io.*;

public class S1_1629_곱셈 {

    static int[] N = new int[3];
    static int M;
    static int[] problem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            N[i] = Integer.parseInt(temp[i]);
        }
        int a = N[0];
        int b = N[1];
        int c = N[2];
        long sol = solve(a,b,c);
        System.out.println(sol);
    }

    public static long solve(int a, int b, int c){
        if(b==0){
            return 1;
        }else{
            long n = solve(a,b/2,c);
            if(b%2==0){
                return n*n%c;
            }else{
                return (n*n%c)*a%c;
            }
        }
    }
}