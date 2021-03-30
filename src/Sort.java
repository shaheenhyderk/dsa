import java.util.Arrays;

public class Sort {
    public static void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

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


    public static int[] heapSort(int[] array) {
        buildHeap(array);
        for (int endIdx = array.length -1; endIdx > 0; endIdx--){
            swap(array, 0, endIdx);
            shiftDown(0, endIdx-1 ,array);
        }
        return array;
    }

    private static void buildHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            shiftDown(currentIdx, array.length-1, array);
        }
    }

    private static void shiftDown(int currentIdx, int endIdx, int[] heap) {
        int child1Idx = currentIdx * 2 + 1;
        while (child1Idx <= endIdx) {
            int child2Idx = currentIdx * 2 + 2;
            int idxToSwap;
            if (child2Idx <= endIdx && heap[child2Idx] > heap[child1Idx]) {
                idxToSwap = child2Idx;
            } else {
                idxToSwap = child1Idx;
            }
            if (heap[idxToSwap] > heap[currentIdx]) {
                swap(heap, currentIdx, idxToSwap);
                currentIdx = idxToSwap;
                child1Idx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 4, 8, 31, 5, 7, 9};
        int[] result = mergeSort(array);
        Arrays.stream(result).forEach(System.out::println);
    }
}
