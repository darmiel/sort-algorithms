package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.sort.SortOrder;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

  @Test
  public void test_BubbleSort_sort_asc() {
    BubbleSort.order = SortOrder.ASC;
    GlobalTest.testSortAsc(new BubbleSort());
  }

  @Test
  public void test_BubbleSort_sort_desc() {
    BubbleSort.order = SortOrder.DESC;
    GlobalTest.testSortDesc(new BubbleSort());
  }

}