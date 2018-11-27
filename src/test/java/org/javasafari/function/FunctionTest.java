package org.javasafari.function;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Represents a function that accepts one argument and produces a result.
 */
public class FunctionTest
{

   /**
    * Applies this function to the given argument.
    */
   @Test
   public void testFuncApply()
   {
      Function<Integer, Integer> sqrt = (num) -> num * num;

      Assertions.assertEquals(Integer.valueOf(100), sqrt.apply(10));
   }


   @Test
   public void testFuncCompose()
   {
      //given
      Function<Integer, Integer> abs = (num) -> Math.abs(num);
      Function<Integer, Integer> sqrt = abs.compose((num) -> num * num);

      //when
      Integer result = sqrt.apply(-9);

      //verify
      Assertions.assertEquals(Integer.valueOf(81), result);
   }


   @Test
   public void testFuncAndThen()
   {
      //given
      Function<Integer, Integer> abs = (num) -> Math.abs(num);
      Function<Integer, Integer> sqrt = abs.compose((num) -> num * num);
      Function<Integer, Integer> time = sqrt.andThen((num) -> num * 2);

      //when
      Integer result = time.apply(10);

      //verify
      Assertions.assertEquals(Integer.valueOf(200), result);
   }

   @Test
   public void testIdentity()
   {
      //given
      Map<String, String> result = Arrays.asList("a", "b", "c")
                                      .stream()
                                      .collect(
                                         Collectors.toMap(
                                            Function.identity(),
                                            str -> str));


      //verify
      Assertions.assertTrue(result.size() == 3);
      Assertions.assertEquals(result.get("a"), "a");
      Assertions.assertEquals(result.get("b"), "b");
      Assertions.assertEquals(result.get("c"), "c");
   }
}
