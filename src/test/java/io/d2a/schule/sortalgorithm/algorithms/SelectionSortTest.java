package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.sort.SortOrder;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

  @Test
  public void test_SelectionSort_Asc() {
    SortTests.testSortAlgorithm(new SelectionSort(), SortOrder.ASC);
  }

  @Test
  public void test_SelectionSort_Desc() {
    SortTests.testSortAlgorithm(new SelectionSort(), SortOrder.DESC);
  }

}
