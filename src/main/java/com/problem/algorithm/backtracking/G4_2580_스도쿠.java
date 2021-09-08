package com.problem.algorithm.backtracking;

import java.io.*;

public class G4_2580_스도쿠 {
    static int[][] board = new int[9][9];
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<9;i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(temp[j]);
                if(board[i][j]==0){
                    count++;
                }
            }
        }
        for(int i=1;i<10;i++) {
            solve(i, 0);
        }
        print();
    }
    public static void print(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    //logic
    public static void solve(int num, int currCol){
        if(num>9||currCol>=9){
            return;
        }else{
            for(int i=0;i<9;i++){
                if(board[i][currCol]==0){
                    if(check(i,currCol,num)){
                        board[i][currCol]=num;
                        solve(num+1,currCol);
                    }else{
                        solve(num,currCol+1);
                    }
                    board[i][currCol]=0;
                }
            }
        }
    }

    //proving
    public static boolean check(int i, int j, int num){
        //가로 check
        int sum=45;
        for(int n=0;n<9;n++){
            sum-=board[i][n];
        }
        if(sum<num){
            return false;
        }
        //세로 check
        sum=45;
        for(int n=0;n<9;n++){
            sum-=board[n][j];
        }
        if(sum<num){
            return false;
        }
        //3*3 check
        int boxX = (i/3)*3;
        int boxY = (j/3)*3;

        sum=45;
        for(int n=boxX;n<boxX+3;n++){
            for(int m=boxY;m<boxY+3;m++){
                sum-=board[n][m];
            }
        }
        if(sum<num){
            return false;
        }
        return true;
    }


}