package com.problem.algorithm.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S2_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        ArrayList<Integer> p = new ArrayList<Integer>();
        HashMap<Integer, Integer> sortP = new HashMap<Integer, Integer>();
        for(String s : temp){
            int n = Integer.parseInt(s);
            p.add(n);
        }
        ArrayList<Integer> tempP = (ArrayList<Integer>) p.clone();
        Collections.sort(tempP);
        int count = 0;
        for(int i = 0 ; i < tempP.size() ; i++) {
            if(!sortP.containsKey(tempP.get(i))) {
                sortP.put(tempP.get(i), count++);
            }
        }
        for(int i : p){
            bw.write(sortP.get(i)+" ");
        }
        bw.flush();
    }
}
