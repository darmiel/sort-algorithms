package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import io.d2a.schule.sortalgorithm.sort.ArrayUtils;
import io.d2a.schule.sortalgorithm.sort.SortOrder;

@SortAlgorithm.Info(
    name = "Insertion Sort",
    author = "Gae-Simon",
    see = ""
)
public class InsertionSort implements SortAlgorithm {

  @Override
  public void sort(Integer[] array, final SortOrder order) {
    insertion(array, order);
  }

  public static void insertion(Integer[] line, final SortOrder order) {

    // Durchläuft den Array
    for (int i = 0; i < line.length - 1; i++) {
      int b = i + 1;
      int temp = line[b];

      while (b > 0 && temp < line[b - 1]) {
        line[b] = line[b - 1];
        b--;
      }

      line[b] = temp;
    }

    if (order == SortOrder.DESC) {
      ArrayUtils.reverse(line);
    }

  }
}
