package com.problem.algorithm.twopointer;

import java.io.*;

public class S1_15565_귀여운라이언 {

    static int N;
    static int M;
    static int[] problem;
    static int[] sol;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        temp = br.readLine().split(" ");
        problem = new int[N];
        sol=new int[N];
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(temp[i]);
            int count=0;
            if(problem[i]==1){
                count++;
                sol[i]=count;
            }
        }
        solve();
        System.out.println(min);
    }

    public static void solve(){
        int r=0;
        int count = 0;
        for (int l = 0; l < N; l++) {
            if(problem[l]!=1){
                continue;
            }else{
                count++;
            }
            while(r<N-1){
                r++;
                if(problem[r]==1){
                    count++;
                }
                if(count==M){
                    min = Math.min(min,r-l+1);
                    count--;
                    break;
                }
            }
        }

        if(min==Integer.MAX_VALUE){
            min=-1;
        }
    }
}
