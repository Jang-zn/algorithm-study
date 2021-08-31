package com.problem.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S4_13305_주유소 {
    //문제 너무 길어서 생략
    //대충 기름값 / 다음도시까지 거리 따져서 최저비용으로 끝까지 가는거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        ArrayList<City> list = new ArrayList<City>();
        String[] d = br.readLine().split(" ");
        String[] oP = br.readLine().split(" ");
        //리스트 세팅
        for(int i=0;i<N;i++){
            long oilPrice = Long.parseLong(oP[i]);
            list.add(new City(oilPrice));
            if(i<N-1) {
                long distance = Long.parseLong(d[i]);
                list.get(i).setNextDistance(distance);
            }else{
                list.get(i).setNextDistance(-1);
            }
        }

        //풀이
        trip(list);
    }

    public static class City{
        private long oilPrice;
        private long nextDistance=-1;
        public City(long oilPrice){
            this.oilPrice=oilPrice;
        }

        public void setNextDistance(long nextDistance) {
            this.nextDistance = nextDistance;
        }
    }

    public static void trip(ArrayList<City> list){
        City currCity = list.get(0);
        long totalDistance=0;
        long totalPrice = 0;
        for(int i=1;i<list.size();i++) {
            City nextCity = list.get(i);
            //다음도시 기름값이 더 쌈
            if (currCity.oilPrice >= nextCity.oilPrice){
                totalDistance+=currCity.nextDistance;
                totalPrice+=currCity.oilPrice*totalDistance;
                currCity=nextCity;
                totalDistance=0;

            //더 비쌈
            }else{
                //다음 도시가 끝이면
                if(nextCity.nextDistance==-1){
                    totalDistance+=currCity.nextDistance;
                    totalPrice+=currCity.oilPrice*totalDistance;

                //끝이 아니면
                }else{
                    totalDistance+=nextCity.nextDistance;
                }
            }
        }
        System.out.println(totalPrice);
    }

}
