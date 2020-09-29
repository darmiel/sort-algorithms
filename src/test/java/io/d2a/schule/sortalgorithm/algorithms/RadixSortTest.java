package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.SortAlgorithm;
import io.d2a.schule.sortalgorithm.sort.SortOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RadixSortTest {

  @Test
  public void test_RadixSort_sort_asc() {
    RadixSort.order = SortOrder.ASC;
    GlobalTest.testSortAsc(new RadixSort());
  }

  @Test
  public void test_RadixSort_sort_desc() {
    RadixSort.order = SortOrder.DESC;
    GlobalTest.testSortDesc(new RadixSort());
  }

}