package com.btanguay.algorithm.search.binary;

import java.util.List;

public final class BinarySearchImpl implements BinarySearch {

    private int[] array;

    @Override
    public void setArray(List<Integer> values) {
        this.array = values.stream().mapToInt(i->i).toArray();
    }

    // -1 if not found, else return index of target in array
    @Override
    public int search(int target) {
        int lowerBound = 0;
        int higherBound = array.length - 1;

        while (lowerBound <= higherBound) {
            int midIndex = lowerBound + (higherBound - lowerBound) / 2;
            int mid = array[midIndex];

            if (mid == target) {
                return midIndex;
            } else if (mid < target) {
                lowerBound = midIndex + 1;
            } else {
                higherBound = midIndex - 1;
            }
        }
        return -1;
    }
}
