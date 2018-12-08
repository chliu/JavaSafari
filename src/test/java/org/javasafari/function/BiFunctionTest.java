package org.javasafari.function;

import java.util.function.BiFunction;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
}
