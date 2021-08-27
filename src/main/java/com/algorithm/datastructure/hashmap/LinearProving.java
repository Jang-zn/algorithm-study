package com.algorithm.datastructure.hashmap;

public class LinearProving {

    private Slot[] slots;

    private class Slot {
        String key;
        String value;
        public Slot (String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public LinearProving(int size){
        this.slots = new Slot[size];
    }

    //data 저장 : LinearProving : Close Hashing 방식으로 충돌 발생시 HashTable 내부의 다음순서 빈공간에 순차적으로 저장함
    public boolean put(String key, String value){
        int index = hashFunction(key);
        int indexCheck = index;
        int startIndex=0;
        Slot check = this.slots[index];
        if(check==null){
            this.slots[index]=new Slot(key, value);
            return true;
        }else{
            while(check!=null){
                if(check.key.equals(key)){
                    this.slots[index].value = value;
                    return true;
                }else {
                    if (index < this.slots.length) {
                        check = this.slots[index];
                        if(check==null) {
                            this.slots[index]=new Slot(key, value);
                            return true;
                        }else {
                            index++;
                        }
                    } else {
                        if (indexCheck != startIndex) {
                            check = this.slots[startIndex];
                            if(check==null) {
                                this.slots[startIndex]=new Slot(key, value);
                                return true;
                            }else {
                                startIndex++;
                            }
                        }else{
                            return false;
                        }
                    }
                }
            }
            return false;
        }
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
        LinearProving lp = new LinearProving(11);
        lp.put("a","1");
        lp.put("b","2");
        lp.put("c","3");
        lp.put("d","4");
        lp.printAll();
        lp.put("aa","11");
        lp.put("bb","22");
        lp.put("cc","33");
        lp.put("dd","44");
        lp.printAll();

    }

}
