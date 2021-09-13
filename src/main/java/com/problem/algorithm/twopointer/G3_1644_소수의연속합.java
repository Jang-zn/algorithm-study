package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.ArrayList;

public class G3_1644_소수의연속합 {

    static int count;
    static int currSum;
    static ArrayList<Integer> prime = new ArrayList<Integer>();
    //
    static int MAX = 4000000;
    static boolean[] array = new boolean[MAX + 1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        calPrime();
        setPrime();
        solve(N);
        System.out.println(count);
    }

    public static void solve(int N){
        //투포인터
        int r=0;
        int l=0;
        currSum = prime.get(l);
        while(l<=r&&r< prime.size()-1){
            if(currSum==N){
                count++;
                currSum-=prime.get(l);
                l++;
            }else if(currSum<N){
                r++;
                currSum+=prime.get(r);
            }else{
                currSum-=prime.get(l);
                l++;
            }
        }
    }

    public static void calPrime() {
        int sqrt = (int) Math.sqrt(MAX);
        for (int i = 2; i <= sqrt; i++) {
            if (array[i]) {
                continue;
            }

            for (int j = i + i; j <= MAX; j += i) {
                array[j] = true;
            }
        }
    }

    public static void setPrime() {
        for (int i = 2; i <= MAX; i++) {
            if (!array[i]) {
                prime.add(i);
            }
        }
    }
}