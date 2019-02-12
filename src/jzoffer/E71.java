package jzoffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class E71 {
    HashMap<Character, Integer> map=new LinkedHashMap<>();

    public void Insert(char ch) {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }
        else{
            map.put(ch,1);
        }
    }
    public char FirstAppearingOnce() {
        char c='#';
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                c=entry.getKey();
                break;
            }
        }
        return c;

    }

}
