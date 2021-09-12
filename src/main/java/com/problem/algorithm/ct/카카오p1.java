package com.problem.algorithm.ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 카카오p1 {
    public static void main(String[] args) {
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        int k = 2;
        int[] list = solution(id_list,report,k);
        System.out.print("[");
        for(int i : list) {
            System.out.print(" "+i+" ");
        }
        System.out.println("]");
    }


    public static int[] solution(String[] id_list, String[] report, int k) {
        //~1000 초기화
        Map<String, ArrayList<String>> singohan = new HashMap<String,ArrayList<String>>();
        Map<String, Integer> singodanghan = new HashMap<String,Integer>();
        Map<String, Integer> mail = new HashMap<String,Integer>();
        for(String s : id_list) {
            singohan.put(s,new ArrayList<String>());
            singodanghan.put(s,0);
            mail.put(s,0);
        }
        //~1000 신고한거 맵핑
        //신고 당한횟수 세기
        for(int i=0;i<report.length;i++){
            String[] temp = report[i].split(" ");
            if(!singohan.get(temp[0]).contains(temp[1])) {
                singohan.get(temp[0]).add(temp[1]);
                singodanghan.put(temp[1], singodanghan.get(temp[1]) + 1);
            }
        }
        //mail 갯수 갱신
        for(int i=0;i<id_list.length;i++){
            String man = id_list[i];
            //신고 당함?
            if(singodanghan.get(man)>=k){
                mail.put(man,mail.get(man)+1);
            }
            //신고한애들 잡힘?
            for(String s : singohan.get(man)){
                if(singodanghan.get(s)>=k){
                    mail.put(man,mail.get(man)+1);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            answer[i] = mail.get(id_list[i]);
        }
        return answer;
    }
}
