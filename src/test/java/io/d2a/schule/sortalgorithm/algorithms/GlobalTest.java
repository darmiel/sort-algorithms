package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class GlobalTest {


  public static void testSortAsc(final SortAlgorithm sort) {
    final Integer[] input = {9, 10, 8, 7, 5, 6, 3, 4, 0, 2, 1, 11, 12, 14, 13};
    final Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    sort.sort(input);

    System.out.println(Arrays.toString(input));

    Assertions.assertArrayEquals(input, expected);
  }

  public static void testSortDesc(final SortAlgorithm sort) {
    final Integer[] input = {9, 10, 8, 7, 5, 6, 3, 4, 0, 2, 1, 11, 12, 14, 13};
    final Integer[] expected = {14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    sort.sort(input);

    System.out.println(Arrays.toString(input));

    Assertions.assertArrayEquals(input, expected);
  }

}
