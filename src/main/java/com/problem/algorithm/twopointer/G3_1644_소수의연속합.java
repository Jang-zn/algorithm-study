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
        for(int l=0;l<prime.size();l++){
            if(prime.get(l)==N) {
                count++;
                continue;
            }
            currSum = prime.get(l);
            r=l;
            while(r< prime.size()-1){
                r++;
                currSum+=prime.get(r);
                if(currSum==N){
                    count++;
                    break;
                }
            }
        }
    }

    public static ArrayList<Integer> prime(int N){
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] check = new boolean[N+1];
        for(int i=2;i<N+1;i++){
            if(!result.isEmpty()) {
                for (int j = result.get(result.size() - 1); j < i; j++) {
                    if (i % j == 0) {
                        check[i] = true;
                        break;
                    }
                }
            }
            if(!check[i]){
                result.add(i);
            }
        }
        return result;
    }
}