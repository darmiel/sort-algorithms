package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import io.d2a.schule.sortalgorithm.sort.ArrayUtils;
import io.d2a.schule.sortalgorithm.sort.SortOrder;

/**
 * Radix-Sort is a sort algorithm with 0 comparisons.
 *
 * @see <a href="https://en.m.wikipedia.org/wiki/Radix_sort">Radix_sort</a>
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
@SortAlgorithm.Info(
    name = "Radix (LSD) Sort",
    author = "darmiel",
    see = "https://de.wikipedia.org/wiki/Radixsort"
)
public class RadixSort implements SortAlgorithm {

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
   * Same as {@link RadixSort#getDigit(int, int)}} but returns 0 if digit was not found
   *
   * @param input Input number
   * @param n     Digit
   * @return n^th digit of input number or 0 if not found
   */
  private static int getDigitUnsafe(final int input, final int n) {
    return Math.max(0, getDigit(input, n));
  }

  private static <T> void reverseArray(final T[] a) {
    final int length = a.length;

    for (int i = 0; i < length; i++) {
      final T temp = a[i];

      a[i] = a[length - i - 1];
      a[length - i - 1] = temp;

      if (i >= length - i - 1) {
        break;
      }
    }
  }

  /**
   * Sorts an array with the radix sort algorithm
   *
   * @param array The array to be sorted
   */
  private static void radixSortLsd(final Integer[] array, final SortOrder order) {

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

    if (order == SortOrder.DESC) {
      ArrayUtils.reverse(array);
    } else if (order != SortOrder.ASC) {
      throw new UnsupportedOperationException(
          "Order-Operator " + order + " not implemented (yet).");
    }
  }

  @Override
  public void sort(final Integer[] array, final SortOrder order) {
    radixSortLsd(array, order);
  }
}