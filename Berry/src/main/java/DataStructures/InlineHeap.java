package DataStructures;

import java.util.Arrays;

/**
 * An array sorted as a heap where the n*2 + 1 value is treated as the left
 * node and the n*2 + 2 value is treated as the right node. The left and
 * right nodes must be less than their parent node for a max heap where the
 * max value is always at the root of the heap. The left and right nodes must
 * be greater than their parent node for a min heap where the min value is
 * always at the root of the heap.
 *
 * Example:
 *      input   = {10, 4, 6, 1, 5, 3, 7}
 *      maxHeap = {10, 7, 6, 5, 4, 3, 1}
 *      indexes = [ 0, 1, 2, 3, 4, 5, 6]
 *
 *      For the node at index 0 the left and right nodes are at indexes 1 and 2.
 *      For the node at index 1 the left and right nodes are at indexes 3 and 4.
 *      For the node at index 2 the left and right nodes are at indexes 5 and 6.
 *
 *      Imaginary tree structure:
 *                  10
 *                /    \
 *              7       6
 *             / \     / \
 *            5   4   3   1
 */
public class InlineHeap <T extends Comparable> {

    private T[] heap;
    private boolean isMaxHeap;
    private int heapSize;

    public InlineHeap(T[] inputArray){
        this(inputArray, true);
    }

    public InlineHeap(T[] inputArray, boolean isMaxHeap){
        heap = Arrays.copyOf(inputArray, inputArray.length);
        this.isMaxHeap = isMaxHeap;
        this.heapSize = inputArray.length;
        buildHeap(inputArray);
    }

    public void maxHeapify(int index){
        if(heap == null || index >= heapSize){
            return;
        }

        T value = heap[index];
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        boolean hasLeft = leftIndex < heapSize;
        boolean hasRight = rightIndex < heapSize;

        if(hasLeft && hasRight){
            T leftValue = heap[leftIndex];
            T rightValue = heap[rightIndex];
            if(leftValue.compareTo(rightValue) > 0 && leftValue.compareTo(value) > 0){
                heap[leftIndex] = value;
                heap[index] = leftValue;
                maxHeapify(leftIndex);
            } else if(rightValue.compareTo(value) > 0){
                heap[rightIndex] = value;
                heap[index] = rightValue;
                maxHeapify(rightIndex);
            }
        } else if(hasLeft){
            T leftValue = heap[leftIndex];
            if(leftValue.compareTo(value) > 0){
                heap[leftIndex] = value;
                heap[index] = leftValue;
                maxHeapify(leftIndex);
            }
        } else if(hasRight){
            T rightValue = heap[rightIndex];
            if(rightValue.compareTo(value) > 0){
                heap[rightIndex] = value;
                heap[index] = rightValue;
                maxHeapify(rightIndex);
            }
        }
    }

    public T[] getHeap(){
        return heap;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }


    private void buildHeap(T[] inputArray){
        for(int i = (int)Math.floor(inputArray.length / 2) - 1; i >= 0; i--){
            int leftIndex = (i * 2) + 1;
            T left = leftIndex < inputArray.length ? heap[leftIndex] : null;
            if(left == null && leftIndex < inputArray.length){
                left = inputArray[leftIndex];
                heap[leftIndex] = left;
            }

            int rightIndex = (i * 2) + 2;
            T right = rightIndex < inputArray.length ? heap[rightIndex] : null;
            if(right == null && rightIndex < inputArray.length){
                right = inputArray[rightIndex];
                heap[rightIndex] = right;
            }

            maxHeapify(i);
        }
    }
}
