package ru.vsu.cs.avdeeva_p_a;

import java.util.*;

public class sortRepeatedNumsAscending {

    public static List<Integer> createNewList(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        assignValue(list, map);
        List<Integer> listNew = new ArrayList<>();
        findDuplicatesValues(map, listNew);

        return sortList(listNew);
    }

    private static void assignValue(List<Integer> list, HashMap<Integer, Integer> map) {
        for (int item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
    }

    private static void findDuplicatesValues(HashMap<Integer, Integer> map, List<Integer> listNew) {
        int maxValue = Collections.max(map.values());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == maxValue) {
                listNew.add(entry.getKey());
            }
        }

    }

    private static List<Integer> sortList(List<Integer> listNew) {
        Collections.sort(listNew);
        return listNew;
    }

}
