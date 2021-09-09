package com.problem.algorithm.sort;

import java.io.*;
import java.util.Arrays;

public class S4_15970_화살표그리기 {
    static long length=0;

    public static class Arrow implements Comparable<Arrow>{
        int color;
        int x;

        @Override
        public boolean equals(Object obj) {
            return this.color==((Arrow)obj).color;
        }

        @Override
        public int compareTo(Arrow o) {
            if(this.color!=o.color) {
                return this.color - o.color;
            }else{
                return this.x - o.x;
            }
        }

        @Override
        public String toString() {
            return "["+this.x+" "+this.color+"]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Arrow[] list = new Arrow[N];
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split(" ");
            Arrow a = new Arrow();
            a.x = Integer.parseInt(temp[0]);
            a.color = Integer.parseInt(temp[1]);
            list[i]=a;
        }
        Arrays.sort(list);
        calc(list);
        System.out.println(length);

    }
    public static void calc(Arrow[] list){
        Arrow currPoint = list[0];
        if(list.length==2){
            length+=2*(list[1].x-list[0].x);
            return;
        }
        for(int i=1;i<list.length;i++){
            if(currPoint.equals(list[i])){
                if(i==1){
                    length+=list[i].x-currPoint.x;
                    currPoint = list[i];
                }else if(i<list.length-1) {
                    int left = Integer.MAX_VALUE;
                    if(list[i-2].equals(currPoint)){
                        left = currPoint.x-list[i-2].x;
                    }
                    int right = Integer.MAX_VALUE;
                    if(list[i].equals(currPoint)) {
                        right = list[i].x - currPoint.x;
                    }
                    length += left<right?left:right;
                    currPoint=list[i];
                }else{
                    int left = Integer.MAX_VALUE;
                    if(list[i-2].equals(currPoint)){
                        left = currPoint.x-list[i-2].x;
                    }
                    int right = Integer.MAX_VALUE;
                    if(list[i].equals(currPoint)) {
                        right =list[i].x-currPoint.x;
                    }
                    length += left<right?left:right;
                    length+=right;
                }
            }else{
                length+=currPoint.x-list[i-2].x;
                currPoint=list[i];
            }
        }
    }
}