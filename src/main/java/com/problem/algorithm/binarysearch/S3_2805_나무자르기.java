package com.problem.algorithm.binarysearch;

import java.io.*;
import java.util.Arrays;

public class S3_2805_나무자르기 {
    static int N;
    static int M;
    static int[] trees;
    static long length=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        String[] tree = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        trees = new int[N];
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(tree[i]);
        }
        Arrays.sort(trees);
        System.out.println(binarySearch());
    }

    public static boolean cut(int H){
        for(int i=0;i<N;i++){
            if(trees[i]>H){
                length+=trees[i]-H;
            }
        }
        return length>=M;
    }

    public static int binarySearch(){
        long l=0, r=2000000000;
        int H = 0;
        while(l<=r){
            long m = (l+r)/2;
            length=0;
            if(cut((int)m)){
                l=m+1;
                H=(int)m;
            }else{
                r=m-1;
            }
        }
        return H;
    }
}
