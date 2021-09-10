package com.problem.algorithm.sort;

import java.io.*;
import java.util.Arrays;

public class S3_7795_먹을or먹힐 {
    static int[] n;
    static int[] m;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            //기본세팅 N, M
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);
            n=new int[N];
            m=new int[M];
            String[] ns = br.readLine().split(" ");
            String[] ms = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                n[j] = Integer.parseInt(ns[j]);
            }
            for(int j=0;j<M;j++){
                m[j] = Integer.parseInt(ms[j]);
            }
            Arrays.sort(m);
            solve(0);
            System.out.println(count);
            count=0;
        }
    }
    public static void solve(int nIdx){
        if(nIdx>=n.length){
            return;
        }else {
            int x = n[nIdx];
            if(m[m.length-1]<x){
                count+=m.length;
            }else{
                int result = binary(x,0,m.length-1);
                count+=result;
            }
            solve(nIdx+1);
        }
    }

    public static int binary(int x, int l, int r) {
        int mid = (l + r) / 2;
        if (r-l<=1) {
            if(x<=m[mid]){
                return mid;
            }else {
                return mid + 1;
            }
        }else {
            if (x <= m[mid]) {
                return binary(x,l,mid);
            }else{
                return binary(x,mid,r);
            }
        }
    }
}