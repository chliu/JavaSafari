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
      Function<Integer, Integer> sqrt = (num) -> num * num;
      Function<String, Integer> input = sqrt.compose(((s) -> Integer.parseInt(s)));

      //when
      Integer result = input.apply("9");

      //verify
      Assertions.assertEquals(Integer.valueOf(81), result);
   }


   @Test
   public void testFuncAndThen()
   {
      //given
      Function<Integer, Integer> sqrt = (num) -> num * num;
      Function<Integer, Integer> times = sqrt.andThen((num) -> num * num);
      Function<String, Integer> input = times.compose(((s) -> Integer.parseInt(s)));

      //when
      Integer result = input.apply("10");

      //verify
      Assertions.assertEquals(Integer.valueOf(10000), result);
   }

   @Test
   public void testIdentity()
   {
      //given
      Map<String, String> result =
         Arrays.asList("a", "b", "c")
            .stream()
            .collect(Collectors.toMap(Function.identity(), str -> str));
      //verify
      Assertions.assertTrue(result.size() == 3);
      Assertions.assertEquals(result.get("a"), "a");
      Assertions.assertEquals(result.get("b"), "b");
      Assertions.assertEquals(result.get("c"), "c");
   }
}
