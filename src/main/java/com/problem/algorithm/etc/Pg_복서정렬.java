package com.problem.algorithm.etc;

import java.util.ArrayList;
import java.util.Collections;

public class Pg_복서정렬 {

    public static void main(String[] args) {
        int[] a = {50,82,75,120};
        String[] b = {"NLWL","WNLL","LWNW","WWLN"};
        int[] sol = solution(a,b);
        for (int i = 0; i < sol.length; i++) {
            System.out.print(sol[i]+" ");
        }
    }


    public static class boxer implements Comparable<boxer>{
        int no;
        int weight;
        int win;
        int lose;
        int moreWeight;
        double rate;

        public boxer(int no, int weight, int win, int lose, int moreWeight){
            this.no = no;
            this.weight = weight;
            this.win = win;
            this.lose = lose;
            this.moreWeight = moreWeight;
            if(win+lose!=0){
                this.rate = (win*100.0/(win+lose));
            }else{
                this.rate = 0;
            }
        }

        @Override
        public int compareTo(boxer o) {
            if(this.rate!=o.rate) {
                return o.rate-this.rate<0?-1:1;
            }else if(this.moreWeight != o.moreWeight){
                return ( o.moreWeight - this.moreWeight);
            }else if(this.weight!=o.weight){
                return (o.weight - this.weight);
            }else{
                return this.no-o.no;
            }
        }

        @Override
        public String toString() {
            return "["+this.no+" "+this.weight+" "+this.rate+" "+this.moreWeight+"]";
        }
    }


    public static int[] solution(int[] weights, String[] head2head) {
        int[] win = new int[weights.length];
        int[] lose = new int[weights.length];
        int[] moreWeight = new int [weights.length];

        for(int i=0;i<weights.length;i++){
            int w=0;
            int l=0;
            int m=0;
            String[] hh = head2head[i].split("");
            for(int j=0;j<hh.length;j++){
                switch(hh[j]){
                    case "N" : break;
                    case "W" : w++;
                               if(weights[i]<weights[j]){
                                   m++;
                               }
                                break;
                    case "L" : l++; break;
                }
            }

            win[i] = w;
            lose[i]=l;
            moreWeight[i]=m;
        }

        ArrayList<boxer> list = new ArrayList<boxer>();
        for(int i=0;i<weights.length;i++){
            boxer b = new boxer(i+1, weights[i], win[i], lose[i], moreWeight[i]);
            list.add(b);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).no;
        }
        return answer;
    }

}
