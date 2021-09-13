package com.problem.algorithm.twopointer;

import java.io.*;

public class S3_2003_수들의합2 {

    static int N;
    static int M;
    static int[] a;
    static int count=0;
    static int currSum=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmt = br.readLine().split(" ");
        String[] at = br.readLine().split(" ");
        N = Integer.parseInt(nmt[0]);
        M = Integer.parseInt(nmt[1]);
        a = new int[N];
        for(int i=0;i<at.length;i++){
            a[i]=Integer.parseInt(at[i]);
        }
        solve();
        System.out.println(count);

    }

    static void solve(){
        int r=0;
        for(int l=0;l<a.length;l++){
            //l위치에서 M하고 같을때
            if(a[l]==M){
                count++;
                continue;
            }
            //다를때
            //currSum 초기화(l위치값), r=l+1
            currSum=a[l];
            r=l;

            //r 하나씩 밀면서 합 확인
            while(r<a.length-1){
                r++;
                currSum+=a[r];
                if(currSum==M){
                    count++;
                    break;
                }
            }
        }
    }
}