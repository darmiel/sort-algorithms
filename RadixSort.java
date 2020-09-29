package io.d2a.schule.searchalgorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * [0003, 0008, 0010, 0015, 0044, 0108, 1004, 1000]
 * --  _
 * [1000, 0010, 0003, 0044, 1004, 0015, 0008, 0108]
 * -- _
 * [1000, 0003, 1004, 0008, 0108, 0010, 0015, 0044]
 * --_
 * [1000, 0003, 1004, 0008, 0010, 0015, 0044, 0108]
 * -_
 * [0003, 0008, 0010, 0015, 0044, 0108, 1000, 1004]
 */
public class RadixSort {

  /**
   * Returns the n^th digit of a number
   *
   * @param input Input number
   * @param n     Digit
   *
   * @return  n^th digit of input number
   */
  private static int getDigit(final int input, final int n) {
    return (int) Math.floor((input % (int) Math.pow(10, n)) / Math.pow(10, n - 1));
  }

  /**
   * Sorts an array with the radix sort algorithm
   *
   * @param array The array to be sorted
   */
  // TODO: Implement this
  private static void radixSortLsd(final int[] array) {

  }

  public static void main(String[] args) {

    // fill array [100] with random numbers from 1000 to 10000
    final Random random = new Random();
    final int[] array = new int[100];
    for (int i = 0; i < args.length; i++) {
      array[i] = random.nextInt(10000 + 1000) - 1000;
    }

    // print array before sort
    System.out.println(Arrays.toString(array));

    // sort array by radix lsd sort
    radixSortLsd(array);

    // print array after sort
    System.out.println(Arrays.toString(array));
  }

}
