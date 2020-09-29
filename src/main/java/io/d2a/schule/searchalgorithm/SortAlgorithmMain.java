package io.d2a.schule.searchalgorithm;

import io.d2a.schule.searchalgorithm.algorithms.BubbleSort;
import io.d2a.schule.searchalgorithm.algorithms.RadixSort;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

public class SortAlgorithmMain {

  public static final int ARRAY_SIZE = 8192;
  public static final Class<? extends SortAlgorithm> ALGORITHM_CLASS = RadixSort.class;

  public static void main(String[] args) throws
      // mimimi-exceptions below:
      IllegalAccessException,
      InstantiationException,
      NoSuchMethodException,
      InvocationTargetException {

    // create array
    final Integer[] array = new Integer[ARRAY_SIZE];

    // fill array
    final Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(10_000 - 1_000) + 1_000;
    }

    // start(array, SortAlgorithmMain.ALGORITHM_CLASS);

    for (final Class<? extends SortAlgorithm> clazz : Arrays.asList(
        BubbleSort.class,
        RadixSort.class
        // add / remove sort algorithms here.
    )) {

      // create a copy of the array
      final Integer[] copy = new Integer[array.length];
      System.arraycopy(array, 0, copy, 0, array.length);

      start(copy, clazz);
    }
  }

  private static void start(final Integer[] array, final Class<? extends SortAlgorithm> algoClass)
      throws NoSuchMethodException,
      IllegalAccessException,
      InvocationTargetException,
      InstantiationException {

    // create an instance of SearchAlgorithm
    final SortAlgorithm sortAlgorithm = algoClass.getDeclaredConstructor().newInstance();

    System.out.println("=== Algorithm: " + algoClass.getName());
    System.out.println("=== Unsorted:");
    System.out.println(Arrays.toString(array));

    // benchmark things
    final long stopwatchStart = System.nanoTime();

    // execute algorithm
    sortAlgorithm.sort(array);

    // end stopwatch
    final long stopwatchTook = System.nanoTime() - stopwatchStart;

    System.out.println();
    System.out.println("=== Sorted:");
    System.out.println(Arrays.toString(array));
    System.out.println();
    System.out.println("=== Took: " + (stopwatchTook / Math.pow(10, -6)) + "ms!");
  }


}