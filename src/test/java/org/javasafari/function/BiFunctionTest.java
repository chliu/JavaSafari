package org.javasafari.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.CoreMatchers.hasItems;


/**
 * Represents a function that accepts two arguments and produces a result.
 * This is the two-arity specialization of {@link java.util.function.Function}.
 */
public class BiFunctionTest
{
   @Test
   public void testBiFunction()
   {

      //when
      BiFunction<String, String, String> function1 = (s1, s2) -> s1 + s2;

      //verify
      Assertions.assertEquals("hello world", function1.apply("hello ", "world"));
   }


   @Test
   public void testFindEvenNumbers()
   {

      //given
      BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> evenFinder = (list, even) -> {
         return list.stream().filter(even).collect(Collectors.toList());
      };

      //when
      List<Integer> evenNumList = evenFinder.apply(
         Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
         (num) -> num % 2 == 0
      );

      //verify
      MatcherAssert.assertThat(evenNumList, hasItems(2, 4, 6, 8));
   }

}
