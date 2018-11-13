package java;

import java.util.Arrays;
import java.util.PriorityQueue;

class FindNRank {
    static class Node implements Comparable<Node> {
        Integer value;
        int index;

        Node(Integer value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value.compareTo(o.value);
        }
    }

    static int find(Integer[] arr, int rank) {
        PriorityQueue<Node> tempRank = new PriorityQueue<>();
        if (rank > arr.length) {
            return -1;
        }
        for (int index = 0; index < arr.length; index++) {
            Node node = new Node(arr[index], index);
            if (tempRank.size() < rank) {
                tempRank.add(node);
            } else if (tempRank.peek().value < arr[index]) {
                tempRank.poll();
                tempRank.add(node);
            }
        }
        return tempRank.peek().index;
    }
}

public class Solution {

    public static void main(String[] args) {
        Integer[] testArr = {1, 3, 4, 6, 6, 4, 3, 3, 3, 6, 7, 9};
        System.out.println(FindNRank.find(testArr, 12));
        System.out.println(Arrays.toString(testArr));
        Arrays.sort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
