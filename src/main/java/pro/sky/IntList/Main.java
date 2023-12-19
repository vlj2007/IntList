package pro.sky.IntList;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        IntList int2 = new IntListImpl(4);
//        System.out.println(int2.add(1));
//        System.out.println(int2.add(2));
//        int2.remove(1);
//        System.out.println(Arrays.toString(int2.toArray()));
//        System.out.println(int2.contains(1));
//        System.out.println(int2.contains(2));


        long start0 = System.currentTimeMillis();
        sortInsertion(randomArray());
        System.out.println(System.currentTimeMillis() - start0);

        long start1 = System.currentTimeMillis();
        sortBubble(randomArray());
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        sortSelection(randomArray());
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        sortSelection(randomArray());
        System.out.println(System.currentTimeMillis() - start3);

    }

    public static int[] randomArray() {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000) + 100000;
        }
        return array;
    }

    //    утилити-метода по перемещению элементов местами.

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

//    Пузырьковая сортировка

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

//    Сортировка выбором

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

//    Сортировка вставкой

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

//    Линейный поиск

    public static boolean containsOne(int[] arr, int element) {
        for (int i : arr) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

//    Бинарный поиск

    public static boolean containsTwo(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }



}
