package com.problem.algorithm.binarysearch;

import java.io.*;
import java.util.Arrays;

public class S3_2512_예산 {
    static int[] area;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        area=new int[N];
        String[] A = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            area[i]=Integer.parseInt(A[i]);
        }
        M=Integer.parseInt(br.readLine());
        Arrays.sort(area);
        System.out.println(parSearch());
    }

    static boolean check(long money){
        long sum=0;
        for(int i=0;i<N;i++){
            if(area[i]>money){
                sum+=money;
            }else{
                sum+=area[i];
            }

        }
        return M>=sum;
    }

    static int parSearch(){
        long l=0, r=1000000000;
        long money=0;
        while(l<=r){
            long m = (l+r)/2;
            if(check(m)){
                if(m>area[area.length-1]) {
                    money = area[area.length-1];
                    m=area[area.length-1];
                    r=m;
                }else{
                    money=m;
                    l = m + 1;
                }
            }else{
                r=m-1;
            }
        }
        return (int)money;
    }
}