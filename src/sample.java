public class sample {

    public static int[] moveElementToEnd(int[] array, int target) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && array[j] == target) {
                j--;
            }
            if (array[i] == target) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 2, 2, 2, 3, 4, 2};
        int target = 2;
        int[] result = moveElementToEnd(array, target);
        for (int j : result) {
            System.out.println(j);
        }
    }

}
