import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Sort {
    public static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;
        while (rightIdx >= leftIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx += 1;
            }
            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx -= 1;
            }
        }
        swap(array, pivotIdx, rightIdx);
        boolean isLeftArraySmaller = rightIdx - 1 - startIdx < endIdx - rightIdx + 1;
        if (isLeftArraySmaller) {
            quickSortHelper(array, startIdx, rightIdx - 1);
            quickSortHelper(array, rightIdx + 1, endIdx);
        } else {
            quickSortHelper(array, rightIdx + 1, endIdx);
            quickSortHelper(array, startIdx, rightIdx - 1);
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middleIdx = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middleIdx);
        int[] rightHalf = Arrays.copyOfRange(array, middleIdx, array.length);
        return mergeSortedArrays(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    public static int[] mergeSortedArrays(int[] leftHalf, int[] rightHalf) {
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]){
                sortedArray[k++] = leftHalf[i++];
            } else {
                sortedArray[k++] = rightHalf[j++];
            }
        }
        while (i < leftHalf.length){
            sortedArray[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length){
            sortedArray[k++] = rightHalf[j++];
        }
        return sortedArray;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 4, 8, 31, 5, 7, 9};
        int[] result = mergeSort(array);
        Arrays.stream(result).forEach(System.out::println);
    }
}
