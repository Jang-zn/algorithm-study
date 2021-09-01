package com.problem.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class S5_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<n;i++){
            String s = br.readLine();
            if(!list.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()) {
                    return o1.length()-o2.length();
                }else{
                    for(int i=0;i<o1.length();i++){
                        if(o1.charAt(i)!=o2.charAt(i)){
                         return o1.charAt(i)-o2.charAt(i);
                        }
                    }
                    return 0;
                }
            }
        });
        for(String s : list){
            System.out.println(s);
        }

    }

}
