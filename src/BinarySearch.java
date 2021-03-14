public class BinarySearch {
    public static int binarySearchRec(int[] array, int target) {
        return binarySearchRecHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchRecHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int potentialMatch = array[middle];
        if (target == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearchRecHelper(array, target, left, middle - 1);
        } else {
            return binarySearchRecHelper(array, target, middle + 1, right);
        }
    }

    public static int binarySearchIter(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int potentialMatch = array[middle];
            if (target == potentialMatch) {
                return middle;
            } else if (target < potentialMatch) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearchRec(array, 0));
    }
}
