package SortingAlgorithms;

import java.util.Arrays;

public class HeapSort {

    public <T extends Comparable> T[] sort(final T[] input){
        if(input == null || input.length <= 1){
            return input;
        }

        MaxHeap<T>[] maxHeaps = buildMaxHeap(input);

        // Counter to track the last node in the heap
        // The important thing about the last node is that it is
        // a leaf node, it's actual value doesn't matter as long as it
        // is less than the value of its parent.
        int maxHeapLastIndex = input.length - 1;
        T[] output = Arrays.copyOf(input, input.length);

        // Build out the output in descending order
        for(int i = 0; i < input.length; i++){
            MaxHeap<T> max = maxHeaps[0];
            T value = max.getValue();
            output[i] = value;

            // Move the value of a leaf node to the top of the Heap
            // so that we can remove the leaf node from the heap
            // and Max Heapify the heap.
            MaxHeap<T> last = maxHeaps[maxHeapLastIndex];
            max.setValue(last.getValue());

            MaxHeap<T> lastParent = last.getParent();
            if(lastParent == null) break; // end of the line

            // Remove the last node in the heap
            if(lastParent.getLeft() != null && lastParent.getLeft().getValue() == last.getValue()){
                lastParent.setLeft(null);
            } else if(lastParent.getRight() != null && lastParent.getRight().getValue() == last.getValue()){
                lastParent.setRight(null);
            }
            maxHeapLastIndex--;

            // Max Heapify the heap so that the max value is at the top of the heap
            maxHeapify(max);
        }

        return output;
    }

    public <T extends Comparable> MaxHeap<T>[] buildMaxHeap(final T[] input){
        if(input == null || input.length == 0){
            return null;
        }

        MaxHeap[] maxHeaps = new MaxHeap[input.length];
        for(int i = (int)Math.floor(input.length / 2) - 1; i >= 0; i--){
            int leftIndex = (i * 2) + 1;
            MaxHeap<T> left = leftIndex < input.length ? maxHeaps[leftIndex] : null;
            if(left == null && leftIndex < input.length){
                left = new MaxHeap<>(input[leftIndex], null, null);
                maxHeaps[leftIndex] = left;
            }

            int rightIndex = (i * 2) + 2;
            MaxHeap<T> right = rightIndex < input.length ? maxHeaps[rightIndex] : null;
            if(right == null && rightIndex < input.length){
                right = new MaxHeap<>(input[rightIndex], null, null);
                maxHeaps[rightIndex] = right;
            }

            MaxHeap<T> heap = new MaxHeap<>(input[i], left, right);
            maxHeaps[i] = heap;
            maxHeapify(heap);
        }
        return maxHeaps;
    }

    /**
     * Adjusts the passed in heap so that it becomes a max heap.
     * A max heap is one where the value of the heap is greater than the
     * values of the left and right heaps it contains.
     *
     * @param heap
     *          Heap with left and right MaxHeaps. Left or right values can be
     *          null but they must be max heaps.
     * @param <T>
     *          An Object which implements the Comparable interface.
     */
    public <T extends Comparable> void maxHeapify(MaxHeap<T> heap){
        if(heap == null){
            return;
        }

        T value = heap.getValue();
        MaxHeap<T> left = heap.getLeft();
        MaxHeap<T> right = heap.getRight();

        boolean hasLeft = left != null;
        boolean hasRight = right != null;

        if(hasLeft && hasRight){
            T leftValue = left.getValue();
            T rightValue = right.getValue();
            if(leftValue.compareTo(rightValue) > 0 && leftValue.compareTo(value) > 0){
                left.setValue(value);
                heap.setValue(leftValue);
                maxHeapify(left);
            } else if(rightValue.compareTo(value) > 0){
                right.setValue(value);
                heap.setValue(rightValue);
                maxHeapify(right);
            }
        } else if(hasLeft){
            T leftValue = left.getValue();
            if(leftValue.compareTo(value) > 0){
                left.setValue(value);
                heap.setValue(leftValue);
                maxHeapify(left);
            }
        } else if(hasRight){
            T rightValue = right.getValue();
            if(rightValue.compareTo(value) > 0){
                right.setValue(value);
                heap.setValue(rightValue);
                maxHeapify(right);
            }
        }
    }
}
