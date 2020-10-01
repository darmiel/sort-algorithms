package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.sort.SortOrder;
import org.junit.jupiter.api.Test;

public class RadixSortTest {

  @Test
  public void test_RadixSort_Asc() {
    SortTests.testSortAlgorithm(new RadixSort(), SortOrder.ASC);
  }

  @Test
  public void test_RadixSort_Desc() {
    SortTests.testSortAlgorithm(new RadixSort(), SortOrder.DESC);
  }

}