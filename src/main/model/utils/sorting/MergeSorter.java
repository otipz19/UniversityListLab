package main.model.utils.sorting;

import java.util.Arrays;

public class MergeSorter<T> implements ISorter<T>{
    public void sort(T[] arr, IComparator<T> comparator){
        sort(arr, 0, arr.length - 1, comparator);
    }

    public void sort(T[] arr, int left, int right, IComparator<T> comparator){
        if(left >= right){
            return;
        }

        int mid = (left + right) / 2;

        sort(arr, left, mid, comparator);
        sort(arr, mid + 1, right, comparator);

        merge(arr, left, mid, right, comparator);
    }

    private void merge(T[] arr, int left, int mid, int right, IComparator<T> comparator) {
        T[] leftTmp = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightTmp = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int leftCur = 0;
        int rightCur = 0;
        int mergedCur = left;
        while(leftCur < leftTmp.length && rightCur < rightTmp.length){
            if(comparator.compare(leftTmp[leftCur], rightTmp[rightCur]) < 0){
                arr[mergedCur] = leftTmp[leftCur++];
            }
            else{
                arr[mergedCur] = rightTmp[rightCur++];
            }
            mergedCur++;
        }

        while(leftCur < leftTmp.length){
            arr[mergedCur++] = leftTmp[leftCur++];
        }

        while(rightCur < rightTmp.length){
            arr[mergedCur++] = rightTmp[rightCur++];
        }
    }
}
