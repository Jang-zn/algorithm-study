package com.problem.algorithm.twopointer;

import java.io.*;

public class G4_1806_부분합 {
    static int N,S;
    static int[] sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ns = br.readLine().split(" ");
        N = Integer.parseInt(ns[0]);
        S = Integer.parseInt(ns[1]);
        sequence = new int[N];
        String[] num = br.readLine().split(" ");
        for(int i=0;i<N;i++){
             sequence[i] = Integer.parseInt(num[i]);
        }
        System.out.println(partial());
    }
    static int partial() {
        int length = Integer.MAX_VALUE;
        int sum = 0;
        int R = -1;
        for (int L = 0; L < N; L++) {
            if (L > 0) {
                sum -= sequence[L - 1];
            }

            while (R+1 < N && sum < S) {
                R++;
                sum += sequence[R];
            }

            if (sum >= S) {
                length = Math.min(length, Math.abs(L - R) + 1);
            }

            System.out.println(L+" "+R);
            System.out.println(sum);
            System.out.println(length);
        }
        if (length == Integer.MAX_VALUE) {
            length=0;
        }
        return length;
    }
}