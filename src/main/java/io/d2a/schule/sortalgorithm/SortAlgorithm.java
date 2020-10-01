package io.d2a.schule.sortalgorithm;

import io.d2a.schule.sortalgorithm.sort.SortOrder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface SortAlgorithm {

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @interface Info {
    String name();
    String author() default "";
    String see() default ""; // url of an explanation of the algorithm
  }

  void sort(final Integer[] array, final SortOrder order);

}