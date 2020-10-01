package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.sort.SortOrder;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

  @Test
  public void test_BubbleSort_Asc() {
    SortTests.testSortAlgorithm(new BubbleSort(), SortOrder.ASC);
  }

  @Test
  public void test_BubbleSort_Desc() {
    SortTests.testSortAlgorithm(new BubbleSort(), SortOrder.DESC);
  }

}