package com.study.algorithm.backtracking;

import java.util.ArrayList;

public class NQueen {
    static int count = 0;
    public static void main(String[] args) {
        nqueen(4,0, new ArrayList<Integer>());
        System.out.println(count);
    }

    public static void nqueen(int N, int currRow, ArrayList<Integer> queenList){
        if(currRow==N){
            System.out.println(queenList);
            count++;
            return;
        }
        for(int i=0; i<N;i++){
            if(isOkay(queenList, i)){
                queenList.add(i);
                nqueen(N,currRow+1, queenList);
                //Pruning
                queenList.remove(queenList.size()-1);
            }
        }

    }

    //Promising
    public static boolean isOkay(ArrayList<Integer> queenList, int currCol){
        int currRow = queenList.size();
        for(int i=0;i<currRow;i++){
            //수직 or 대각선일때
            if(queenList.get(i)==currCol||Math.abs(queenList.get(i)-currCol)==currRow-i){
                return false;
            }
        }
        return true;
    }
}
