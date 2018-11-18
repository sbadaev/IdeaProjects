package SortingAlgorithms;

import java.util.Objects;

public class MaxHeap<T> {

    private T value;
    private MaxHeap<T> parent;
    private MaxHeap<T> left;
    private MaxHeap<T> right;

    public MaxHeap(T value, MaxHeap<T> left, MaxHeap<T> right){
        this.value = value;
        this.left = left;
        this.right = right;

        if(left != null){
            left.parent = this;
        }

        if(right != null){
            right.parent = this;
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MaxHeap<T> getLeft() {
        return left;
    }

    public void setLeft(MaxHeap<T> left) {
        this.left = left;
    }

    public MaxHeap<T> getRight() {
        return right;
    }

    public void setRight(MaxHeap<T> right) {
        this.right = right;
    }

    public MaxHeap<T> getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxHeap<?> maxHeap = (MaxHeap<?>) o;
        return Objects.equals(value, maxHeap.value) &&
                Objects.equals(left, maxHeap.left) &&
                Objects.equals(right, maxHeap.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}
