package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import io.d2a.schule.sortalgorithm.sort.SortOrder;
import java.util.Random;
import org.junit.jupiter.api.Assertions;

public class SortTests {

  private static final Random random = new Random();

  public static void testSortAlgorithm(
      final SortAlgorithm algorithm,
      final SortOrder order,
      final int n) {

    // create random array and fill it
    final Integer[] array = new Integer[n];
    for (int i1 = 0; i1 < array.length; i1++) {
      array[i1] = random.nextInt(10_000);
    }

    // now create a sorted array
    final Integer[] expected = new Integer[n];

    // copy
    System.arraycopy(array, 0, expected, 0, array.length);

    // for that we'll be using: BubbleSort
    for (int k = 0; k < expected.length; k++) {
      for (int l = 0; l < expected.length; l++) {
        if (k == l) {
          continue;
        }
        if (order == SortOrder.ASC ? (expected[k] < expected[l]) : (expected[k] > expected[l])) {
          final int temp = expected[k];
          expected[k] = expected[l];
          expected[l] = temp;
        }
      }
    }

    // apply algorithm
    algorithm.sort(array, order);

    // assert equality
    Assertions.assertArrayEquals(array, expected);
  }


  public static void testSortAlgorithm(
      final SortAlgorithm algorithm,
      final SortOrder order) {

    for (final int i : new int[]{8, 100, 1000, 10000}) {
      testSortAlgorithm(algorithm, order, i);
    }
  }

}