package com.problem.algorithm.dp;

import java.io.*;

public class S5_1010_다리놓기 {


    static int T;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            if(N!=1) {
                if(N!=M) {
                    System.out.println((solve(1, 1, M - 1))+1);
                }else {
                    System.out.println(1);
                }
            }else{
                System.out.println(M);
            }
        }

    }

    static int solve(int before, int selected, int point){
        if(before>=N){
            return point;
        }else {
            int result = 0;
            while (point != N - before){
                result += solve(before + 1, selected++, point--);
            }
            return result;
        }
    }



    public static int combination(int n, int r) {
        if(n == r || r == 0)
            return 1;
        else
            return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}