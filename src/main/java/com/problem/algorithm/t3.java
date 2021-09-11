package com.problem.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class t3 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Car> cars = new HashMap<Integer, Car>();
        for(int i=0;i<records.length;i++){
            String[] info = records[i].split(" ");
            int num = Integer.parseInt(info[1]);
            String[] time = info[0].split(":");
            if(cars.get(num)==null){
                cars.put(num,new Car());
                cars.get(num).num=num;
            }
            if(info[2].equals("IN")) {
                int h = Integer.parseInt(time[0]);
                int m = Integer.parseInt(time[1]);
                cars.get(num).inTime.add(h*60+m);
            }else{
                int h = Integer.parseInt(time[0]);
                int m = Integer.parseInt(time[1]);
                cars.get(num).outTime.add(h*60+m);
            }
        }
        int[] answer = howmuch(fees, cars);
        return answer;
    }

    static class Car implements Comparable<Car>{
        int num;
        ArrayList<Integer> inTime = new ArrayList<Integer>();
        ArrayList<Integer> outTime = new ArrayList<Integer>();
        int payment;

        @Override
        public int compareTo(Car o) {
            return this.num-o.num;
        }
    }

    static int[] howmuch(int[] fees, Map<Integer, Car> cars){
        int baseTime = fees[0];
        int baseMoney = fees[1];
        int perTime = fees[2];
        int moneyPerTime = fees[3];
        ArrayList<Car> cList = new ArrayList<Car>();
        //맵에서 꺼내와서 계산
        for(int n : cars.keySet()){
            Car c = cars.get(n);
            ArrayList<Integer> inTime = c.inTime;
            ArrayList<Integer> outTime =c.outTime;
            int spendTime=0;
            //입/출 완료인 경우
            if(outTime.size()>0&&inTime.size()==outTime.size()) {
                for (int i = 0; i < outTime.size(); i++) {
                     spendTime+= outTime.get(i) - inTime.get(i);
                }
            //입출..입 하고 출 안하고 남은경우
            }else if(inTime.size()>outTime.size()){
                for (int i = 0; i < outTime.size(); i++) {
                    spendTime+= outTime.get(i) - inTime.get(i);
                }
                spendTime += (23*60+59)-inTime.get(inTime.size()-1);
            //입차만 한 경우
            }else{
                spendTime = (23*60+59)-inTime.get(0);
            }

            //누적시간이 기본시간 이하
            if(spendTime<=baseTime){
                c.payment=baseMoney;
            //기본시간 초과
            }else{
                int pay = 0;
                pay+=baseMoney;
                spendTime-=baseTime;
                pay+=Math.ceil((double)spendTime/perTime)*moneyPerTime;
                c.payment=pay;
            }
            cList.add(c);
        }
        Collections.sort(cList);
        int[] result = new int[cList.size()];
        for(int i=0;i<cList.size();i++){
            result[i] = cList.get(i).payment;
        }
        return result;
    }
}
