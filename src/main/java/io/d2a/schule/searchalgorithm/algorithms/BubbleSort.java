package io.d2a.schule.searchalgorithm.algorithms;

import io.d2a.schule.searchalgorithm.SortAlgorithm;
import io.d2a.schule.searchalgorithm.sort.SortOrder;

@SortAlgorithm.Info(
    name = "Bubble Sort",
    author = "darmiel",
    see = "https://www.geeksforgeeks.org/bubble-sort/"
)
public class BubbleSort implements SortAlgorithm {

  private final static SortOrder order = SortOrder.ASC;

  @Override
  public void sort(final Integer[] array) {
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
