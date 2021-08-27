package com.algorithm.datastructure.hashmap;

public class Chainning {
    private Slot[] slots;

    private class Slot {
        String key;
        String value;
        Slot next;
        public Slot (String key, String value){
            this.key = key;
            this.value = value;
        }
    }
    public Chainning(int size){
        this.slots = new Slot[size];
    }
    //data 저장 : Chainning 방식 - 충돌나면 LinkedList로 처리
    public void put(String key, String value){
        int index = hashFunction(key);
        Slot beforeSlot=null;
        Slot check = this.slots[index];
        if(check==null){
            this.slots[index] = new Slot(key, value);
        }else if(check.key.equals(key)){
            this.slots[index].value = value;
        }else{
            Slot newSlot = check.next;
            while(newSlot!=null){
                beforeSlot = newSlot;
                newSlot = newSlot.next;
            }
            if(beforeSlot==null) {
                newSlot = new Slot(key, value);
                this.slots[index].next = newSlot;
            }else{
                newSlot = new Slot(key, value);
                beforeSlot.next = newSlot;
            }

        }
    }

    //data 가져오기
    public String get(String key){
        int index = hashFunction(key);
        Slot check = this.slots[index];
        if(check==null){
            return null;
        }else if(check.key.equals(key)){
            return check.value;
        }else{
            Slot next = check.next;
            while(next!=null){
                if(next.key.equals(key)){
                    return next.value;
                }else{
                    next = next.next;
                }
            }
            return null;
        }
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
        Chainning c = new Chainning(11);
        c.put("a","1");
        c.put("b","2");
        c.put("c","3");
        c.put("d","4");
        c.put("aa","11");
        c.put("aaa","111");
        c.put("aaaa","1111");
        c.put("bb","22");
        c.put("bbb","222");
        c.put("bbbb","2222");
        c.put("bbbbb","22222");
        c.put("cc","33");
        c.put("dd","44");
        System.out.println(c.get("a"));
        System.out.println(c.get("aa"));
        System.out.println(c.get("aaa"));
        System.out.println(c.get("aaaa"));
        System.out.println(c.get("b"));
        System.out.println(c.get("bb"));
        System.out.println(c.get("bbb"));
        System.out.println(c.get("bbbb"));
        System.out.println(c.get("bbbbb"));
    }
}
