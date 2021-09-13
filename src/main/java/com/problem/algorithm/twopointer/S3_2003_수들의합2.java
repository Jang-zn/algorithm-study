package com.problem.algorithm.twopointer;

import java.io.*;

public class S3_2003_수들의합2 {

    static int[] nm;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmt = br.readLine().split(" ");
        String[] at = br.readLine().split(" ");
        nm[0] = Integer.parseInt(nmt[0]);
        nm[1] = Integer.parseInt(nmt[1]);
        for(int i=0;i<at.length;i++){
            a[i]=Integer.parseInt(at[i]);
        }

    }
}