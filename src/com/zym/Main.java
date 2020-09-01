package com.zym;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int [] arr_1 = {1, 3, 5, 8, 9, 0, 12, 4, 6, 7, 99, 97, 21,6 };
        List<Map<Integer, Integer>> list = findSum2(arr_1, 100);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Map<Integer, Integer> i : list) {
                for (Integer k : i.keySet()) {
                    System.out.println("arr[" + (k+1) + "] = " + i.get(k));
                }
                System.out.println("-----------------");
            }
        }


        if ( false ) {
            // write your code here
            int x = Integer.valueOf("100");
            int y = Integer.parseInt("100");
            int [] arr = {1, 3, 5, 8, 9, 0, 12, 4, 6, 7, 99, 0, 21,6 };
            ArrayList<Integer> toSort = new ArrayList<Integer>();
            for (int item : arr) {
                toSort.add(item);
            }

            Main main = new Main();
            ArrayList<Integer> res = main.kuaiSort(toSort);
            for (int item: res) {
                System.out.println(item);
            }

            System.out.println("------------------");
            int[] ares = main.kuaiSort(arr);
            for (int item : ares) {
                System.out.println(item);
            }
        }

    }

    /**
     * 递归快排: ArrayList
     * @param toSort
     * @return
     */
    public ArrayList<Integer> kuaiSort(ArrayList<Integer> toSort) {
        if ( toSort.size() < 2 ) {
            return toSort;
        } else {
            int first = toSort.get(0);
            ArrayList<Integer> left = new ArrayList();
            ArrayList<Integer> right = new ArrayList();

            for (int i = 1; i < toSort.size(); i++) {
                if ( toSort.get(i) < first ) {
                    left.add(toSort.get(i));
                } else {
                    right.add(toSort.get(i));
                }
            }

            ArrayList<Integer> res = new ArrayList<>();
            res.addAll( kuaiSort(left) );
            res.add(first);
            res.addAll( kuaiSort(right) );
            return res;
        }
    }

    /**
     * 递归快排: int[]
     * @param toSort
     * @return
     */
    public int[] kuaiSort(int[] toSort) {
        if (toSort.length < 2)
            return toSort;
        else {
            int first = toSort[0];
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            for (int i = 1; i < toSort.length; i++) {
                if (toSort[i] < first) {
                    left.add(toSort[i]);
                } else {
                    right.add(toSort[i]);
                }
            }
            int[] res = new int[toSort.length];

            System.arraycopy(kuaiSort(left.stream().mapToInt(Integer::intValue).toArray()), 0, res, 0, left.size());
            res[left.size()] = first;
            System.arraycopy(kuaiSort(right.stream().mapToInt(Integer::intValue).toArray()), 0, res, left.size()+1, right.size());
            return res;
        }
    }

    /**
     * 求数组中2个数的和等于给定的某个数
     * @param arrToFind
     * @param sum
     * @return 返回满足条件的数值对
     */
    public static List<Map<Integer, Integer>> findSum2(int[] arrToFind, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Map<Integer, Integer>> list = new LinkedList<>();
        for (int i=arrToFind.length-1; i > -1; i--) {
            int temp = sum - arrToFind[i];
            if (map.containsKey(temp)) {
                Map<Integer, Integer> rs = new HashMap<>();
                rs.put(i, arrToFind[i]);
                rs.put(map.get(temp), temp);
                list.add(rs);
            } else {
                map.put(arrToFind[i], i);
            }
        }
        return list;
    }
}
