package differenttypesoflists;

import java.util.*;

public class test {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>(); //Dictionary //Map=Interface
        Collection hashSet = new HashSet<>(); //extended hashmap with no order and no duplicates
        Collection treeSet = new TreeSet<>(); //like hashset but slower and has order
        Collection arrayList = new ArrayList<>(); //has insertion order and can have duplicate values in its collection
        //We save everything in Collection to be able to use its methods-I guess

        //Collections.shuffle(elements);
        map.put("Hash",String.valueOf(hashSet.add(0)));
        map.put("Tree",String.valueOf(treeSet.add(1)));
        map.put("ArrayList",String.valueOf(arrayList.add(2)));
        System.out.println(map);
        System.out.println(hashSet);
        System.out.println(treeSet);
        System.out.println(arrayList);
    }
}
