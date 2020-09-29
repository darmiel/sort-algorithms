package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;

@SortAlgorithm.Info(
    name = "Insertion Sort",
    author = "Gae-Simon",
    see = ""
)
public class InsertionSort implements SortAlgorithm {

  @Override
  public void sort(Integer[] array) {
    insertion(array);
  }

  public static void insertion(Integer[] line) {

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
  }
}
