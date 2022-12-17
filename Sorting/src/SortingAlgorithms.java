import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
    // ascending order

    // selectionSort method
    public static void selectionSort(Comparable[] array){
        int minIndex;
        Comparable temp;

        for (int i = 0; i < array.length; i++){
            temp = array[i];
            minIndex = i;
            for (int j = i; j < array.length; j++){
                if (array[minIndex].compareTo(array[j]) > 0){
                    minIndex = j;
                }
            }

            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // mergeSort method
    private static void merge(Comparable[] array, int start1, int end1, int start2, int end2){
        Comparable[] subArray1 = new Comparable[end1 - start1 + 1];
        Comparable[] subArray2 = new Comparable[end2 - start2 + 1];
        for (int i = start1, j = 0; i <= end1; i++, j++){
            subArray1[j] = array[i];
        }
        for (int i = start2, j = 0; i <= end2; i++, j++){
            subArray2[j] = array[i];
        }

        int subIndex1 = 0, subIndex2 = 0;
        for(int i = start1; i <= end2; i++){
            if (subIndex1 < subArray1.length && subIndex2 < subArray2.length){
                if (subArray1[subIndex1].compareTo(subArray2[subIndex2]) <= 0){
                    array[i] = subArray1[subIndex1++];
                }
                else {
                    array[i] = subArray2[subIndex2++];
                }
            }
            else if (subIndex1 == subArray1.length) {
                array[i] = subArray2[subIndex2++];
            }
            else {
                array[i] = subArray1[subIndex1++];
            }
        }
    }

    public static void mergeSort(Comparable[] array, int start, int end) {
        if (start == end){
            return;
        }
        else {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, mid+1, end);
        }
    }

    public static void mergeSort(Comparable[] array){
        mergeSort(array, 0, array.length-1);
    }

    // insertionSort method
    public static void insertionSort(Comparable[] array){
        Comparable key;

        for (int i = 1, j = i-1; i < array.length; j = i++){
            key = array[i];
            j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    // test code
    public static void main(String[] args) {
        testObject[] testArray1 = {
                new testObject(6),
                new testObject(9),
                new testObject(194),
                new testObject(3),
                new testObject(16),
                new testObject(-7)
        };
        System.out.println("The origin array1 is:");
        System.out.println(Arrays.toString(testArray1));

        // Interger has implemented Comparable interface while int hasn't
        Integer[] testArray2 = new Integer[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            testArray2[i] = random.nextInt(1000);
        }
        System.out.println("The origin array2 is:");
        System.out.println(Arrays.toString(testArray2));

//        // test for selectionSort method
//        selectionSort(testArray1);
//        System.out.println("The array after selectionSort is:");
//        System.out.println(Arrays.toString(testArray1));

        // test for mergeSort method
//        mergeSort(testArray1);
//        System.out.println("The array after mergeSort is:");
//        System.out.println(Arrays.toString(testArray1));

        insertionSort(testArray1);
        insertionSort(testArray2);
        System.out.println("The array1 after insertionSort is:");
        System.out.println(Arrays.toString(testArray1));
        System.out.println("The array2 after insertionSort is:");
        System.out.println(Arrays.toString(testArray2));
    }
}