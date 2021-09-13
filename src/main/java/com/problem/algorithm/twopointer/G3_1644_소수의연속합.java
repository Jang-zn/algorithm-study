package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.ArrayList;

public class G3_1644_소수의연속합 {

    static int count;
    static int currSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(count);
    }

    public static void solve(int N){
        //소수구하기
        ArrayList<Integer> prime = prime(N);

        //투포인터
        int r=0;
        int l=0;
        currSum = prime.get(l);
        while(l<=r){
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

    public static ArrayList<Integer> prime(int N){
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] check = new boolean[N+1];
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (check[i]) {
                continue;
            }

            for (int j = i + i; j <= N; j += i) {
                check[j] = true;
            }

            if(!check[i]&&!result.contains(i)){
                result.add(i);
            }
        }
        System.out.println(result);
        return result;
    }
}