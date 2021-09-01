package com.problem.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class S5_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<Person>();
        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            String name = s[1];
            int age = Integer.parseInt(s[0]);
            list.add(new Person(name,age,i));
        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age!=o2.age) {
                    return o1.age-o2.age;
                }else{
                    return o1.p-o2.p;
                }
            }
        });
        for(Person p : list){
            System.out.println(p);
        }
    }

    public static class Person{
        String name;
        int age;
        int p;
        public Person(String name, int age, int p){
            this.name=name;
            this.age=age;
            this.p=p;
        }

        @Override
        public String toString() {
            return this.age+" "+this.name;
        }
    }
}
