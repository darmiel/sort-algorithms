package io.d2a.schule.searchalgorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Radix-Sort is a search algorithm with 0 comparisons.
 * @see https://en.m.wikipedia.org/wiki/Radix_sort
 *
 * <pre>
 *   array = [6, 66, 43, 123, 98, 291, 20, 21, 21, 22, 911]
 *   n = 1
 *   |0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
 *   20 291  22  43                  98
 *       21     123
 *       21
 *      911
 *
 *   array = [20, 291, 21, 21, 911, 22, 43, 123, 98]
 *   n = 2
 *   |0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
 *       911  20      43                 291
 *            21                          98
 *            21
 *            22
 *           123
 *
 *   array = [911, 20, 21, 21, 22, 123, 43, 291, 98]
 *   n = 3
 *   |0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
 *     20 123 291
 *     21
 *     21
 *     22
 *     43
 *     98
 *
 *   array = [20, 21, 21, 22, 43, 98, 123, 291] <- sorted
 * </pre>
 */
public class RadixSort {

  public static final int N_TOO_LOW = -1;
  public static final int DIGIT_NOT_FOUND = -404;

  /**
   * Returns the n^th digit of a number:
   * <pre>
   *   input = 1337
   *   n = 2        _
   *   -> digit = 1337 = 3
   *   n = 3       _
   *   -> digit = 1337 = 3
   *   n = 4      _
   *   -> digit = 1337 = 1
   * </pre>
   *
   * @param input Input number
   * @param n     Digit
   * 
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

  /**
  * Same as {@link RadixSort#getDigit(input, n)} but returns 0 if digit was not found
  *
  * @param input Input number
  * @param n     Digit
  *
  * @return n^th digit of input number or 0 if not found
  */
  private static int getDigitUnsafe(final int input, final int n) {
    return Math.max(0, getDigit(input, n));
  }

  /**
   * Swaps two objects in an array:
   * <pre>
   *   array = [1, 2, 3, 4, 5]
   *   swap (array, 0, 1)
   *   array = [2, 1, 3, 4, 5]
   * </pre>
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

  /**
   * Sorts an array with the radix sort algorithm
   *
   * @param array The array to be sorted
   */
  private static void radixSortLsd(final Integer[] array) {

    // an (signed) 32-bit integers' max length is 10
    // 2^31-1 = 2 147 483 647 = 10 digits
    for (int n = 1; n <= 10; n++) {

      // this array holds every value for each n^th digit
      final int[][] digits = new int[10][];

      // first, find frequency of every digit for array initialization
      final int[] frequency = new int[10];
      for (final Integer integer : array) {
        frequency[getDigitUnsafe(integer, n)]++;
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
