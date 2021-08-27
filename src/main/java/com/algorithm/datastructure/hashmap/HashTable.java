package com.algorithm.datastructure.hashmap;

public class HashTable {

    private Slot[] slots;

    class Slot {
        String key;
        String value;
        public Slot (String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(int size){
        this.slots = new Slot[size];
    }

    //data 저장
    public void put(String key, String value){
        this.slots[hashFunction(key)]= new Slot(key, value);
    }

    //data 가져오기
    public String get(String key){
        return this.slots[hashFunction(key)].value;
    }

    //간단한 해쉬함수 - 디비전 방식(나머지 이용) : 충돌(Collision) 발생 처리방식은 다른 구조에서
    public int hashFunction(String key){
        int index = (int)key.charAt(0)%this.slots.length;
        return index;
    }

    //출력
    public void printAll(){
        System.out.print("[");
        for(Slot s : this.slots){
            if(s!=null) {
                System.out.print("{" + s.key + ":" + s.value + "}");
            }else{
                System.out.print("{" + "null" + "}");
            }
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(17);
        ht.put("일","1");
        ht.put("이","2");
        ht.put("삼","3");
        ht.put("사","4");
        ht.put("a","5");
        ht.put("b","6");
        ht.put("c","7");
        ht.put("d","8");
        ht.printAll();
        System.out.println(ht.get("일"));
        System.out.println(ht.get("이"));
        System.out.println(ht.get("삼"));
        System.out.println(ht.get("사"));
        System.out.println(ht.get("a"));
        System.out.println(ht.get("b"));
        System.out.println(ht.get("c"));
        System.out.println(ht.get("d"));
    }

}
