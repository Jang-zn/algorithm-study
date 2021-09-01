package com.problem.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S5_11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<XY> list = new ArrayList<XY>();
        for(int i=0;i<n;i++){
            String[] xy = br.readLine().split(" ");
            int x =Integer.parseInt(xy[0]);
            int y =Integer.parseInt(xy[1]);
            list.add(new XY(x,y));
        }
        Collections.sort(list);
        print(list);

    }

    public static class XY implements Comparable<XY>{
        int x;
        int y;
        public XY(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(XY o) {
            if(this.x!=o.x) {
                return this.x - o.x;
            }else{
                return this.y - o.y;
            }
        }

        @Override
        public String toString() {
            return this.x+" "+this.y;
        }
    }

    public static void print(ArrayList<XY> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
