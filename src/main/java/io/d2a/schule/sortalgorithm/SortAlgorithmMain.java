package io.d2a.schule.sortalgorithm;

import io.d2a.schule.sortalgorithm.algorithms.BubbleSort;
import io.d2a.schule.sortalgorithm.algorithms.InsertionSort;
import io.d2a.schule.sortalgorithm.algorithms.RadixSort;
import io.d2a.schule.sortalgorithm.sort.SortOrder;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

public class SortAlgorithmMain {

  public static final int ARRAY_SIZE = 10;
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
            InsertionSort.class,
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

    // create an instance of SortAlgorithm
    final SortAlgorithm sortAlgorithm = algoClass.getDeclaredConstructor().newInstance();

    // get info of algorithm
    final SortAlgorithm.Info sortAlgorithmInfo =
        algoClass.isAnnotationPresent(SortAlgorithm.Info.class)
            ? algoClass.getAnnotation(SortAlgorithm.Info.class)
            : getDefaultInfoFor(algoClass);

    System.out.println("=== Algorithm: " + sortAlgorithmInfo.name());
    if (!sortAlgorithmInfo.author().trim().isEmpty()) {
      System.out.println("* Implementation author: " + sortAlgorithmInfo.author());
    }
    if (!sortAlgorithmInfo.see().trim().isEmpty()) {
      System.out.println("* More information: " + sortAlgorithmInfo.see());
    }
    System.out.println();

    System.out.println("=== Unsorted:");
    System.out.println(Arrays.toString(array));

    // benchmark things
    final long stopwatchStart = System.nanoTime();

    // execute algorithm
    sortAlgorithm.sort(array, SortOrder.ASC);

    // end stopwatch
    final long stopwatchTook = System.nanoTime() - stopwatchStart;

    System.out.println();
    System.out.println("=== Sorted:");
    System.out.println(Arrays.toString(array));
    System.out.println();
    System.out.println("=== Took: " + (stopwatchTook / Math.pow(10, -6)) + "ms!");
    System.out.println();
    System.out.println("---");
    System.out.println();
  }

  private static SortAlgorithm.Info getDefaultInfoFor(final Class<? extends SortAlgorithm> clazz) {
    return new SortAlgorithm.Info() {
      @Override
      public String name() {
        return clazz.getName() + " [proper name not set!]";
      }

      @Override
      public String author() {
        return "anonymous";
      }

      @Override
      public String see() {
        return "";
      }

      @Override
      public Class<? extends Annotation> annotationType() {
        return null;
      }
    };
  }


}