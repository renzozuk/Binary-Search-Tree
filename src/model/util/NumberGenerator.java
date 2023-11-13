package model.util;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {
    public static Set<Integer> numberGenerator(){
        int quantity = (int)(Math.random() * 50 + 1);

        Set<Integer> list = new HashSet<>();

        while(list.size() < quantity){
            list.add((int) (Math.random() * 200) + 1);
        }

        return list;
    }
}
