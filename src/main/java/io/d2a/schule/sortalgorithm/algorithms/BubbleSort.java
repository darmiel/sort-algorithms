package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import io.d2a.schule.sortalgorithm.sort.SortOrder;

@SortAlgorithm.Info(
    name = "Bubble Sort",
    author = "darmiel",
    see = "https://www.geeksforgeeks.org/bubble-sort/"
)
public class BubbleSort implements SortAlgorithm {

  @Override
  public void sort(final Integer[] array, final SortOrder order) {
    for (int i = array.length - 1; i >= 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (order == SortOrder.ASC ? (array[j - 1] > array[j]) : (array[j - 1] < array[j])) {
          final int temp = array[j - 1];
          array[j - 1] = array[j];
          array[j] = temp;
        }

      }
    }
  }

}
