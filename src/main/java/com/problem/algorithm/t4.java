package com.problem.algorithm;

public class t4 {

    public static void main(String[] args) {
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] list = solution(5,info);
        System.out.print("[");
        for(int i : list){
            System.out.print(" "+i+" ");
        }
        System.out.println("]");
    }


    static int[] score;

    public static int[] solution(int n, int[] info) {
        score = new int[info.length];
        arrow(n, info);
        return score;
    }

    public static void arrow(int n, int[] info){
        int m=n;
        //어피치의 현재점수
        int apScore =0;
        for(int i=0;i<11;i++){
            if(info[i]!=0){
                apScore+=10-i;
            }
        }
        //1. n>2 이면 높은점수부터 1개면 2발 쏜다
        if(n>2){
            for (int i = 0; i < 10; i++) {
                if (info[i] == 1) {
                    score[i]+=2;
                    n-=2;
                }
                if(n<2){
                    break;
                }
            }
        }
        //2. 남은거 높은점수부터 0개면 쏜다. / 단 0점은 안쏜다
        if(n>=1) {
            for (int i = 0; i < 10; i++) {
                if (info[i] == 0) {
                    score[i]++;
                    n--;
                }
                if(n==0){
                    break;
                }
            }
        }
        if(!scoreCheck(info)){
            score = new int[info.length];
            if(m>=1) {
                for (int i = 0; i < 10; i++) {
                    if (info[i] == 0) {
                        score[i]++;
                        n--;
                    }
                    if(n==0){
                        break;
                    }
                }
            }
            if(m>2){
                for (int i = 0; i < 10; i++) {
                    if (info[i] == 1) {
                        score[i]+=2;
                        n-=2;
                    }
                    if(n<2){
                        break;
                    }
                }
            }
        }


        if(!scoreCheck(info)){
            score=new int[]{-1};
        }

    }
    static boolean scoreCheck(int[] info){
        int currScore = 0;
        int apScore =0;

        for(int i=0;i<11;i++){
            if(info[i]>=score[i]&&info[i]!=0&&score[i]!=0){
                apScore+=10-i;
            }else if(info[i]<score[i]&&info[i]!=0&&score[i]!=0){
                currScore+=10-i;
            }
        }
        return currScore>apScore;
    }
}
