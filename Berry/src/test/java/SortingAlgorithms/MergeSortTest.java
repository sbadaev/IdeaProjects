package SortingAlgorithms;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortTest(){
        int[] unorderedArray = new int[] {10, 4, 6, 1, 5, 3, 7};
        int[] orderedArray = new int[] {1, 3, 4, 5, 6, 7, 10};

        MergeSort mergeSort = new MergeSort();
        int[] output = mergeSort.sort(unorderedArray);

        Assert.assertArrayEquals(orderedArray, output);
    }

    @Test
    public void sort2Test(){
        int[] unorderedArray = new int[] {10, 4, 6, 1, 5, 7};
        int[] orderedArray = new int[] {1, 4, 5, 6, 7, 10};

        MergeSort mergeSort = new MergeSort();
        int[] output = mergeSort.sort(unorderedArray);

        Assert.assertArrayEquals(orderedArray, output);
    }
}
