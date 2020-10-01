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
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i == j) {
          continue;
        }

        if (order == SortOrder.ASC ? (array[i] < array[j]) : (array[i] > array[j])) {
          final int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

}
