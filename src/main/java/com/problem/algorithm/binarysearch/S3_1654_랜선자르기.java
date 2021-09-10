package com.problem.algorithm.binarysearch;

import java.io.*;

public class S3_1654_랜선자르기 {
    static int N;
    static int K;
    static long[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = br.readLine().split(" ");
        K = Integer.parseInt(nk[0]);
        N = Integer.parseInt(nk[1]);
        lan = new long[K];
        for(int i=0;i<K;i++){
            lan[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(parSearch());
    }

    static boolean check(long length){
        int ea = 0;
        for(int i=0;i<K;i++){
            ea+=lan[i]/length;
        }
        return ea>=N;
    }

    static int parSearch() {
        long l = 0, r = Integer.MAX_VALUE;
        int length = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            if (check(m)) {
                l = m + 1;
                length = (int) m;
            } else {
                r = m - 1;
            }
        }
        return length;
    }
}