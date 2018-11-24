package SortingAlgorithms;

import DataStructures.MaxHeap;
import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {

    @Test
    public void sortTest(){
        Integer[] unorderedArray = new Integer[] {10, 4, 6, 1, 5, 3, 7};
        Integer[] orderedArray = new Integer[] {10, 7, 6, 5, 4, 3, 1};

        HeapSort heapSort = new HeapSort();
        Integer[] output = heapSort.sort(unorderedArray);

        Assert.assertArrayEquals(orderedArray, output);
    }

    @Test
    public void sort2Test(){
        Integer[] unorderedArray = new Integer[] {10, 4, 6, 1, 3, 7};
        Integer[] orderedArray = new Integer[] {10, 7, 6, 4, 3, 1};

        HeapSort heapSort = new HeapSort();
        Integer[] output = heapSort.sort(unorderedArray);

        Assert.assertArrayEquals(orderedArray, output);
    }

    @Test
    public void sortInlineTest(){
        Integer[] unorderedArray = new Integer[] {10, 4, 6, 1, 5, 3, 7};
        Integer[] orderedArray = new Integer[] {10, 7, 6, 5, 4, 3, 1};

        HeapSort heapSort = new HeapSort();
        Integer[] output = heapSort.sortInline(unorderedArray);

        Assert.assertArrayEquals(orderedArray, output);
    }

    @Test
    public void sortInline2Test(){
        Integer[] unorderedArray = new Integer[] {10, 4, 6, 1, 3, 7};
        Integer[] orderedArray = new Integer[] {10, 7, 6, 4, 3, 1};

        HeapSort heapSort = new HeapSort();
        Integer[] output = heapSort.sortInline(unorderedArray);

        Assert.assertArrayEquals(orderedArray, output);
    }

    @Test
    public void buildMaxHeapTest(){
        Integer[] unorderedArray = new Integer[] {10, 4, 6, 1, 5, 3, 7};

        MaxHeap<Integer> leftLeft = new MaxHeap<>(1, null, null);
        MaxHeap<Integer> leftRight = new MaxHeap<>(4, null, null);
        MaxHeap<Integer> left = new MaxHeap<>(5, leftLeft, leftRight);

        MaxHeap<Integer> rightLeft = new MaxHeap<>(3, null, null);
        MaxHeap<Integer> rightRight = new MaxHeap<>(6, null, null);
        MaxHeap<Integer> right = new MaxHeap<>(7, rightLeft, rightRight);

        MaxHeap<Integer> heap = new MaxHeap<>(10, left, right);

        HeapSort heapSort = new HeapSort();
        MaxHeap<Integer>[] actualHeap = heapSort.buildMaxHeap(unorderedArray);
        Assert.assertEquals(heap, actualHeap[0]);
    }

    @Test
    public void buildMaxHeapOddTest(){
        Integer[] unorderedArray = new Integer[] {10, 4, 6, 1, 5, 3};

        MaxHeap<Integer> leftLeft = new MaxHeap<>(1, null, null);
        MaxHeap<Integer> leftRight = new MaxHeap<>(4, null, null);
        MaxHeap<Integer> left = new MaxHeap<>(5, leftLeft, leftRight);

        MaxHeap<Integer> rightLeft = new MaxHeap<>(3, null, null);
        MaxHeap<Integer> right = new MaxHeap<>(6, rightLeft, null);

        MaxHeap<Integer> heap = new MaxHeap<>(10, left, right);

        HeapSort heapSort = new HeapSort();
        MaxHeap<Integer>[] actualHeap = heapSort.buildMaxHeap(unorderedArray);
        Assert.assertEquals(heap, actualHeap[0]);
    }

    @Test
    public void MaxHeapifyTest(){
        MaxHeap<Integer> leftLeft = new MaxHeap<>(3, null, null);
        MaxHeap<Integer> leftRight = new MaxHeap<>(1, null, null);
        MaxHeap<Integer> left = new MaxHeap<>(6, leftLeft, leftRight);

        MaxHeap<Integer> rightLeft = new MaxHeap<>(5, null, null);
        MaxHeap<Integer> rightRight = new MaxHeap<>(7, null, null);
        MaxHeap<Integer> right = new MaxHeap<>(10, rightLeft, rightRight);

        MaxHeap<Integer> heap = new MaxHeap<>(4, left, right);

        HeapSort heapSort = new HeapSort();
        heapSort.maxHeapify(heap);

        Assert.assertEquals(Integer.valueOf(10), heap.getValue());
        Assert.assertEquals(Integer.valueOf(7), heap.getRight().getValue());
        Assert.assertEquals(Integer.valueOf(4), heap.getRight().getRight().getValue());
    }
}
