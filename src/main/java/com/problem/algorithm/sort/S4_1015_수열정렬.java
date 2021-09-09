package com.problem.algorithm.sort;

import java.io.*;
import java.util.Arrays;

public class S4_1015_수열정렬 {

    static Value[] a;
    static Value[] b;
    static int[] sol;

    public static class Value implements Comparable<Value>{
        int oriIdx;
        int changeIdx;
        int value;
        @Override
        public int compareTo(Value o) {
            return this.value-o.value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        a = new Value[N];
        b = new Value[N];
        sol = new int[N];
        for(int i=0;i<N;i++){
            Value v = new Value();
            v.value =Integer.parseInt(temp[i]);
            v.oriIdx = i;
            a[i] = v;
            b[i] = v;
        }
        Arrays.sort(b);

        for(int i=0;i<N;i++){
            sol[b[i].oriIdx] = i;
        }

        for(int i:sol){
            System.out.print(i+" ");
        }
    }
}