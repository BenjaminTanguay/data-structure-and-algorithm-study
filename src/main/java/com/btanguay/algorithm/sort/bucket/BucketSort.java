package com.btanguay.algorithm.sort.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BucketSort {

    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalStateException("Shouldn't pass a null array");
        }
        if (array.length == 0) {
            return array;
        }

        int numberOfBuckets = 5;
        int max = max(array);
        int min = min(array);
        double range = ((double)(max - min)) / ((double) numberOfBuckets - 1);

        List<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < array.length; ++i) {
            int value = array[i];
            buckets[bucketResolver(value, min, range)].add(value);
        }

        List<Integer> result = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            result.addAll(bucket);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private int bucketResolver(int value, int min, double range) {
//        return min + ((int)(value / range));
        return (int) ((value - min) / range);
    }

    private int max(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("Shouln't have a null or empty array");
        }
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int min(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("Shouln't have a null or empty array");
        }
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
