package com.problem.algorithm.backtracking;

import java.io.*;

public class S3_15649_N과M1 {
    static int N;
    static int M;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] p = br.readLine().split(" ");
        N = Integer.parseInt(p[0]);
        M = Integer.parseInt(p[1]);
        list = new int[M+1];
        //1~N까지 M칸에 출력
        nm(1, bw);
        bw.flush();
    }

    public static void nm(int k, BufferedWriter bw) throws IOException{
        if(k==M+1){
            for(int i=1;i<list.length;i++){
                bw.write(list[i]+" ");
            }
            bw.write("\n");
            return;
        }else{
            for(int i=1;i<=N;i++){
                boolean check = false;
                for(int j=1;j<k;j++){
                    if(list[j]==i){
                        check=true;
                        break;
                    }else{
                        check=false;
                    }
                }
                if(!check) {
                    list[k] = i;
                    nm(k + 1, bw);
                }
            }
        }
    }
}