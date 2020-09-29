package io.d2a.schule.searchalgorithm.algorithms;

import io.d2a.schule.searchalgorithm.SortAlgorithm;

public class EasySort implements SortAlgorithm {

  @Override
  public void sort(final Integer[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i == j) {
          continue;
        }
        if (array[i] < array[j]) {
          final int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

}
