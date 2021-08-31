package com.problem.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S2_1931_강의실배정 {
    //문제
    //한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
    // 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
    // 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
    // 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
    //
    //입력
    //첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
    //둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
    // 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
    //
    //출력
    //첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetingList = new ArrayList<Meeting>();
//        for(int i=0;i<N;i++){
//            String[] temp = br.readLine().split(" ");
//            meetingList.add(new Meeting(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
//        }
        meetingList.add(new Meeting(1,4));
        meetingList.add(new Meeting(3,5));
        meetingList.add(new Meeting(0,6));
        meetingList.add(new Meeting(5,7));
        meetingList.add(new Meeting(3,8));
        meetingList.add(new Meeting(5,9));
        meetingList.add(new Meeting(6,10));
        meetingList.add(new Meeting(8,11));
        meetingList.add(new Meeting(8,12));
        meetingList.add(new Meeting(6,6));
        meetingList.add(new Meeting(4,4));



        Collections.sort(meetingList);
        System.out.println(meetingList.toString());
        schedule(meetingList);
    }

    public static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        int range;
        int sort;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
            this.range = end-start;
            this.sort = start+range;
        }

        @Override
        public int compareTo(Meeting m) {
            return this.end-m.end;
        }

        @Override
        public String toString() {
            return "["+start+" "+end+"]";
        }
    }

    public static void schedule(ArrayList<Meeting> meetingList){
        int count=1;
        Meeting currMeeting = meetingList.get(0);
        for(int i=1;i<meetingList.size();i++){
            Meeting nextMeeting =meetingList.get(i);

            if(i==1&&currMeeting.range>nextMeeting.range){
                currMeeting=nextMeeting;
                continue;
            }

            if(nextMeeting.start!= nextMeeting.end) {
                if (currMeeting.end <= nextMeeting.start) {
                    //System.out.println(nextMeeting+"O");
                    currMeeting = nextMeeting;
                    count++;

                }else{
                    //System.out.println(nextMeeting+"X");
                }
            }else{
                if(currMeeting.end <= nextMeeting.start){
                    //System.out.println(nextMeeting + "O");
                    currMeeting = nextMeeting;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
