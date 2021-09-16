package com.problem.algorithm.twopointer;

import java.io.*;
import java.util.ArrayList;

public class S1_15565_귀여운라이언 {

    static int N;
    static int M;
    static int[] problem;
    static ArrayList<Integer> sol;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        temp = br.readLine().split(" ");
        problem = new int[N];
        sol = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(temp[i]);
            if(problem[i]==1){
                sol.add(i);
            }

        }
        solve();
        System.out.println(min);
    }

    public static void solve(){
        int l=0;
        int r=l+M-1;
        while(r<sol.size()){
            min = Math.min(min,sol.get(r)-sol.get(l)+1);
            l++;
            r++;
        }
        if(min==Integer.MAX_VALUE){
            min=-1;
        }
    }
}
