package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.Arrays;

public class G4_1253_좋다 {
    static int N;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        String[] ns = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(ns[i]);
        }
        Arrays.sort(seq);
        System.out.println(good());
    }
    static int good(){
        int count=0;
        for(int i=0;i<N;i++){
            if(check(i)){
                count++;
            }
        }
        return count;
    }

    static boolean check(int idx){
        int L=0, R=N-1;
        int target = seq[idx];
        while (L < R) {
            if(L==idx) {
                L++;
            }else if(R==idx) {
                R--;
            }else{
                if(seq[L]+seq[R]==target) {
                    return true;
                }
                if(seq[L]+seq[R]>target){
                    R--;
                }else{
                    L++;
                }
            }
        }
        return false;
    }
}