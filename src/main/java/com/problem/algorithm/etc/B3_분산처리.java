package com.problem.algorithm.etc;

import java.io.*;

public class B3_분산처리 {

    static int N;
    static int a;
    static int b;
    static int[][] solution = {{6,2,4,8}, {1,3,9,7}, {6,4,6,4}, {1,7,9,3}, {6,8,4,2}, {1,9,1,9}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] temp  = br.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            int pa = a%10;
            int pb = b%4;
            switch(pa){
                case 1:bw.write(1+"\n"); break;
                case 2:
                    bw.write(solution[0][pb]+"\n");
                    break;
                case 3:
                    bw.write(solution[1][pb]+"\n");
                    break;
                case 4:
                    bw.write(solution[2][pb]+"\n");
                    break;
                case 5:bw.write(5+"\n"); break;
                case 6:bw.write(6+"\n"); break;
                case 7:
                    bw.write(solution[3][pb]+"\n");
                    break;
                case 8:
                    bw.write(solution[4][pb]+"\n");
                    break;
                case 9:
                    bw.write(solution[5][pb]+"\n");
                    break;
                case 0:bw.write(10+"\n"); break;
            }
        }
        bw.flush();
    }
}