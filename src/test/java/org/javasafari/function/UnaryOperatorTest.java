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
      //when
      UnaryOperator<Integer> increment = (n) -> ++n;
      //verify
      Assertions.assertEquals(Integer.valueOf(2), increment.apply(1));

   }

}
