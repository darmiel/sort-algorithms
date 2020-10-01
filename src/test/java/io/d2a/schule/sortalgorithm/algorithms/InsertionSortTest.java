package io.d2a.schule.sortalgorithm.algorithms;

import io.d2a.schule.sortalgorithm.sort.SortOrder;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

  @Test
  public void test_InsertionSort_Asc() {
    SortTests.testSortAlgorithm(new InsertionSort(), SortOrder.ASC);
  }

  @Test
  public void test_InsertionSort_Desc() {
    SortTests.testSortAlgorithm(new InsertionSort(), SortOrder.DESC);
  }

}