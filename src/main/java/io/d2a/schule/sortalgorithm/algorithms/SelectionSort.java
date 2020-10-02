package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import io.d2a.schule.sortalgorithm.sort.ArrayUtils;
import io.d2a.schule.sortalgorithm.sort.SortOrder;

@SortAlgorithm.Info(
    name = "Selection Sort",
    author = "Niklas"
)
public class SelectionSort implements SortAlgorithm {

  @Override
  public void sort(final Integer[] array, final SortOrder order) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          final int speischer = array[i];
          array[i] = array[j];
          array[j] = speischer;
        }
      }
    }
    if (order == SortOrder.DESC) {
      ArrayUtils.reverse(array);
    }
  }

}