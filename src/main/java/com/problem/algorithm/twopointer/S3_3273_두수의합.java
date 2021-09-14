package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.Arrays;

public class S3_3273_두수의합 {
    static int N;
    static int X;
    static int[] P;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        P=new int[N];

        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(temp[i]);
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(P);

        solve();

        System.out.println(count);
    }

    public static void solve(){
        int l=0;
        int r=N-1;
        while(l<r){
            int sum = P[l]+P[r];
            if(sum==X){
                count++;
            }

            if(sum<=X){
                l++;
            }else{
                r--;
            }
        }
    }
}