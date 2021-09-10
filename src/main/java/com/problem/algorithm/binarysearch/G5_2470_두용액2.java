package com.problem.algorithm.binarysearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class G5_2470_두용액2 {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<N;i++){
           int solution = Integer.parseInt(temp[i]);
           list.add(solution);
        }
        Collections.sort(list);
        int[]sol = calc();
        System.out.println(sol[0]+" "+sol[1]);

    }

    public static int[] calc(){
        int[] pair = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            int x = list.get(i);
            int yIdx= binary(-1*x,i+1,list.size()-1);
            if(i<yIdx-1&&yIdx-1<list.size()&&Math.abs(min)>Math.abs(x+list.get(yIdx-1))) {
                pair[0] = x;
                pair[1] = list.get(yIdx);
                min=x+list.get(yIdx);
            }
            if(i<yIdx&&yIdx<list.size()&&Math.abs(min)>Math.abs(x+list.get(yIdx))) {
                pair[0] = x;
                pair[1] = list.get(yIdx);
                min=x+list.get(yIdx);
            }
        }
        return pair;
    }

    public static int binary(int x, int l, int r){
        //배열에서 x이상의 수 중 가장 작은값의 인덱스(mid)+1을 반환하는 함수
        //x이상의 수가 없다면 r을 반환
        //강사가 인덱스를 1~N으로 자꾸 잡아서 존나 헷갈리네 ㅆ비ㅏㄹ년아
        int result = r;
        while(l<=r){
            int mid = (l+r)/2;
            if(list.get(mid)>=x){
                result = mid;//(ea)
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return result;
    }

}