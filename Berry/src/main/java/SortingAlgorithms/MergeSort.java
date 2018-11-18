package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] input){
        if(input == null){
            return null;
        }

        if(input.length <= 1){
            return input;
        }

        int leftStart = 0;
        int leftEnd = input.length / 2;
        int rightStart = leftEnd;
        int rightEnd = input.length;
        int[] left = sort(Arrays.copyOfRange(input, leftStart, leftEnd));
        int[] right = sort(Arrays.copyOfRange(input, rightStart, rightEnd));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right){
        int length = left.length + right.length;
        int[] output = new int[length];

        int leftIndex = 0;
        int rightIndex = 0;
        for(int i = 0; i < length; i++){
            if(leftIndex < left.length && rightIndex < right.length){
                if(left[leftIndex] < right[rightIndex]){
                    output[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    output[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if(leftIndex < left.length){
                output[i] = left[leftIndex];
                leftIndex++;
            } else if(rightIndex < right.length){
                output[i] = right[rightIndex];
                rightIndex++;
            }
        }

        return output;
    }
}
