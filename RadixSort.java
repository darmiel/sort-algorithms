package io.d2a.schule.searchalgorithm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.Random;

/**
 * <pre>
 * [0003, 0004, 0010, 0015, 0044, 0108, 1004, 1000]
 * --  _
 * [1000, 0010, 0003, 0044, 1004, 0015, 0008, 0108]
 * -- _
 * [1000, 0003, 1004, 0008, 0108, 0010, 0015, 0044]
 * --_
 * [1000, 0003, 1004, 0008, 0010, 0015, 0044, 0108]
 * -_
 * [0003, 0008, 0010, 0015, 0044, 0108, 1000, 1004]
 * </pre>
 *
 * //
 *
 * array = [1000, 1100, 1110, 1111]
 *  |0|   |1|   |2| |3| |4| |5| |6| |7| |8| |9|
 * 1000  11111
 * 1100
 * 1110
 *
 * array = [1000, 1100, 1110, 1111]
 *  |0|   |1|   ...
 * 1000  1110
 * 1100  1111
 *
 * array = [1000, 1100, 1110, 1111]
 * |0|   |1|   |2| ...
 * 1000 1100
 *      1110
 *      1111
 *
 * array = [1000, 1100, 1110, 1111]  <-- sorted
 */
public class RadixSort {

  public static final int N_TOO_LOW = -19;
  public static final int DIGIT_NOT_FOUND = -404;

  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  /**
   * Returns the n^th digit of a number
   *
   * @param input Input number
   * @param n     Digit
   * @return n^th digit of input number
   */
  private static int getDigit(final int input, final int n) {
    if (n <= 0) {
      return N_TOO_LOW;
    }
    if (input < Math.pow(10, n - 1)) {
      return DIGIT_NOT_FOUND;
    }
    return (int) Math.floor((input % (int) Math.pow(10, n)) / Math.pow(10, n - 1));
  }


  private static int getDigitUnsafe(final int input, final int n) {
    return Math.max(0, getDigit(input, n));
  }

  /**
   * Swaps two objects in an array
   *
   * @param array The array to swap the objects
   * @param i     Index A)
   * @param j     Index B)
   * @param <T>   Type of array
   */
  private static <T> void swap(final T[] array, final int i, final int j) {
    final T o = array[i];
    array[i] = array[j];
    array[j] = o;
  }

  private static void printArray(final Integer[] array) {
    for (final Integer integer : array) {
      System.out.printf("%04d, ", integer);
    }
    System.out.println();
  }


  /**
   * Sorts an array with the radix sort algorithm
   *
   * @param array The array to be sorted
   */
  private static void radixSortLsd(final Integer[] array) {

    // an (signed) 32-bit integers' max length is 10
    // 2 147 483 647
    for (int n = 1; n <= 10; n++) {

      // this array holds every value for each n^th digit
      final int[][] digits = new int[10][];

      // first, find frequency of every digit for array initialization
      final int[] frequency = new int[10];
      for (final Integer integer : array) {
        final int digit = getDigitUnsafe(integer, n);
        if (digit >= 0) {
          frequency[digit]++;
        }
      }

      // now create the arrays of every digit
      for (int i = 0; i < frequency.length; i++) {
        digits[i] = new int[frequency[i]];
        // reset frequency for later use
        frequency[i] = 0;
      }

      // because we don't want to waste power,
      // we want to stop after there are no more digits left on all numbers in the array.
      boolean noMoreDigitFound = true;

      // iterate through every object in array
      for (final int integer : array) {
        int digit = getDigit(integer, n);

        // if a digit WAS found, set noMoreDigitFound to false
        // se we won't break this loop
        if (digit != DIGIT_NOT_FOUND) {
          noMoreDigitFound = false;
        }

        digit = Math.max(0, digit);

        // Add digit to array
        // array = [100, 110, 111]
        // |0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
        // 100 111  <- this
        // 110      <- and this
        //
        digits[digit][frequency[digit]++] = integer;
      }

      // overwrite current array
      // start from the top left to the bottom right
      int i = 0;
      for (final int[] digitsb : digits) {
        for (final int digit : digitsb) {
          array[i++] = digit;
        }
      }

      // break loop if there were no more digits found
      if (noMoreDigitFound) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    // fill array [100] with random numbers from 1000 to 10000
    final Random random = new Random();
    final Integer[] array = new Integer[100];
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(10000 - 1000) + 1000;
    }

    // print array before sort
    System.out.println(Arrays.toString(array));

    // sort array by radix lsd sort
    radixSortLsd(array);

    // print array after sort
    System.out.println(Arrays.toString(array));
  }

}
