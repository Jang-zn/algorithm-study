package com.problem.algorithm.twopointer;

import java.io.*;

public class S3_2559_수열 {

    static int N;
    static int K;
    static int[] problem;
    static int max=0;
    static int currSum=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);
        problem = new int[N];
        temp = br.readLine().split(" ");
        for (int i = 0; i <N ; i++) {
            problem[i] = Integer.parseInt(temp[i]);
        }
        solve();
        System.out.println(max);
    }


    static void solve(){
        for (int l = 0; l < K; l++) {
            currSum+=problem[l];
            max=currSum;
        }
        int sum=0;
        for(int l = 1;l<=N-K;l++){
            sum = currSum - problem[l - 1] + problem[l + K - 1];
            max = Math.max(max,sum);
            currSum=sum;
        }
    }
}