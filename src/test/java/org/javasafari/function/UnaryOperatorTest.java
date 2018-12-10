package org.javasafari.function;

import java.util.function.UnaryOperator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * Represents an operation on a single operand that produces a result of  the same type as its operand.
 * This is a specialization of {@code Function} for
 * the case where the operand and result are of the same type.
 */

public class UnaryOperatorTest
{

   @Test
   public void testUnaryOperator()
   {
      //given

      //when
      UnaryOperator<Integer> squared = integer -> integer * integer;

      //verify
      Assertions.assertEquals(Integer.valueOf(4), squared.apply(2));
      Assertions.assertEquals(Integer.valueOf(9), squared.apply(3));
      Assertions.assertEquals(Integer.valueOf(16), squared.apply(4));

   }

}
