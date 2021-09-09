package com.problem.algorithm.sort;

import java.io.*;
import java.util.Arrays;

public class S4_11652_카드 {
    static int maxCount=0;
    static long maxValue=0;
    static int count=0;
    static long currval=0;
    static long[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        list = new long[N];
        for(int i=0;i<N;i++){
            list[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(list);
        getMax(list);
        System.out.println(maxValue);
    }

    public static void getMax(long[] list){
        boolean check = true;
        //초기화
        currval=list[0];
        count=1;
        maxCount=1;
        maxValue=list[0];
        //1번부터 검사
        for(int i=1;i<list.length;i++){
            if(currval!=list[i]) {
                count=1;
                currval = list[i];
            }else{
                count++;
                if(count>maxCount) {
                    maxCount = count;
                    maxValue = currval;
                }
            }
        }
    }
}