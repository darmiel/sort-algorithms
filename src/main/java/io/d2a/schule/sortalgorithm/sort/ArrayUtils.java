package io.d2a.schule.sortalgorithm.sort;

public class ArrayUtils {

  public static <T> void swap(T[] arr, int i, int j) {
    final T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static <T> void reverse(T[] arr) {
    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
      swap(arr, i, j);
      i++;
      j--;
    }
  }

}