package com.problem.algorithm.backtracking;

import java.io.*;
import java.util.ArrayList;

public class G5_9663_NQueens {
    static ArrayList<Integer> board = new ArrayList<Integer>();
    static int N;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        queen(0);
        System.out.println(count);
    }

    public static void queen(int currRow){
        if(currRow>=N){
            count++;
            return;
        }else{
            for(int i=0;i<N;i++) {
                if (isOkay(i)) {
                    board.add(i);
                    queen(currRow + 1);
                    //Pruning... 조건 안맞는 루트 기록 삭제용
                    board.remove(board.size()-1);
                }
            }
        }
    }

    public static boolean isOkay(int col){
        int currRow = board.size();
        for(int i=0;i<currRow;i++){
            //수직 확인 + 대각선확인 (대각선 : 가로차이==세로차이 이면 대각선)
            if(board.get(i)==col||Math.abs(board.get(i)-col)==currRow-i){
                return false;
            }
        }
        return true;
    }
}