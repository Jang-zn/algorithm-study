package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.Arrays;

public class G5_2230_수고르기2 {

    static int N;
    static int M;
    static int[] problem;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        problem = new int[N];
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(problem);
        solve();
        System.out.println(min);
    }

    public static void solve(){
        int l=0;
        int r=0;
        while (r < N) {
            if (problem[r] - problem[l] < M) {
                r++;
                continue;
            }

            if (problem[r] - problem[l] == M) {
                min = M;
                break;
            }

            min = Math.min(min, problem[r] - problem[l]);
            l++;
        }
    }
}