package com.problem.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class S5_1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<problem.length();i++){
            list.add(Integer.parseInt(String.valueOf(problem.charAt(i))));
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1-o2);
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }

    }
}
