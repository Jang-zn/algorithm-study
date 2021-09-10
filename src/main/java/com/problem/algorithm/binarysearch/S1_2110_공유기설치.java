package com.problem.algorithm.binarysearch;

import java.io.*;
import java.util.Arrays;

public class S1_2110_공유기설치 {
    static int N;
    static int C;
    static int[] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nc= br.readLine().split(" ");
        N = Integer.parseInt(nc[0]);
        C = Integer.parseInt(nc[1]);
        home = new int[N];
        for(int i=0;i<N;i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        System.out.println(parSearch());
    }

    static boolean check(int distance){
        int count=1;
        int last = home[0];
        for(int i=1;i<N;i++){
            if(home[i]-last>=distance){
                count++;
                last = home[i];
            }
        }
        return count>=C;
    }

    static int parSearch(){
        int l = 1, r = 1000000000;
        int distance = 0;
        while(l<=r){
            int m = (l+r)/2;
            if(check(m)){
                distance=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return distance;
    }
}