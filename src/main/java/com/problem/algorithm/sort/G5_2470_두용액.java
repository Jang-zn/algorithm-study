package com.problem.algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class G5_2470_두용액 {
    static ArrayList<Integer> acid = new ArrayList<Integer>();
    static ArrayList<Integer> alk = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<N;i++){
           int solution = Integer.parseInt(temp[i]);
           if(solution>0){
               acid.add(solution);
           }else{
               alk.add(solution);
           }
        }
        Collections.sort(acid);
        Collections.sort(alk);
        print();
    }

    public static int[] calc(){
        int[] acal = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<acid.size();i++){
            int ac = acid.get(i);
            int al = binary(ac,0,alk.size()-1);
            int sum = Math.abs(ac+al);
            if(min>sum){
                min=sum;
                acal[0]=ac;
                acal[1]=al;
            }
        }
        return acal;
    }

    public static int binary(int ac, int l, int r){
        //ac랑 절대값이 가장 가까운 값을 alk에서 찾아서 그 값(alk.get(idx))을 반환해야됨
        //idx는 (l+r)/2=m 일수도 있고 m-1일수도 있고 m+1일수도 있다.
        int result=alk.get(l);
        while(l<=r){
            int m =(l+r)/2;
            if(-1*ac==alk.get(m)){
                result = alk.get(m);
                break;
            }else {
                ac=-1*ac;
                int mid = alk.get(m);
                if(ac>mid){
                    l=m+1;
                    result = mid;
                }else{
                    r=m-1;
                    result = mid;
                }
            }
        }
        return result;
    }

    public static void print(){
        if(acid.size()>=2&&alk.size()>=2) {
            int acac = acid.get(0) + acid.get(1);
            int alal = Math.abs(alk.get(alk.size() - 1) + alk.get(alk.size() - 2));
            int[] acal = calc();
            int acalSum = Math.abs(acal[0] + acal[1]);
            int min = Math.min(acac, alal) > acalSum ? acalSum : Math.min(acac, alal);
            if (min == acalSum) {
                System.out.println(acal[1] + " " + acal[0]);
            } else if (min == acac) {
                System.out.println(acid.get(0) + " " + acid.get(1));
            } else {
                System.out.println(alk.get(alk.size() - 2) + " " + alk.get(alk.size() - 1));
            }
        }else if(acid.size()==1&&alk.size()==1){
            System.out.println(acid.get(0)+alk.get(0));
        }else if(acid.size()==1){
            int alal = Math.abs(alk.get(alk.size()-1)+alk.get(alk.size()-2));
            int acal = Math.abs(acid.get(0)+alk.get(alk.size()-1));
            if(alal<acal){
                System.out.println(alk.get(alk.size()-1)+" "+alk.get(alk.size()-2));
            }else{
                System.out.println(alk.get(alk.size()-1)+" "+acid.get(0));
            }
        }else if(alk.size()==1){
            int acac = acid.get(0)+acid.get(1);
            int acal = Math.abs(acid.get(0)+alk.get(0));
            if(acac<acal){
                System.out.println(acid.get(0)+" "+acid.get(1));
            }else{
                System.out.println(alk.get(0)+" "+acid.get(0));
            }
        }else{
            if(alk.size()==0) {
                System.out.println(acid.get(0)+" "+acid.get(1));
            }else {
                System.out.println(alk.get(alk.size()-2)+" "+alk.get(alk.size()-1));
            }
        }
    }
}