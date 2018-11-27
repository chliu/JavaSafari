package org.javasafari.function;

import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Represents a predicate of one argument.
 */
public class PredicateTest
{


   /**
    * Evaluates this predicate on the given argument.
    */
   @Test
   public void testPredicateTest()
   {
      //given
      Predicate<Integer> isEven = (num) -> num % 2 == 0;

      //verify
      Assertions.assertTrue(isEven.test(4));
      Assertions.assertTrue(isEven.test(0));
      Assertions.assertFalse(isEven.test(1));

   }

   /**
    * Returns a composed predicate that represents a short-circuiting logical
    * AND of this predicate and another.  When evaluating the composed
    * predicate, if this predicate is {@code false}, then the {@code other}
    * predicate is not evaluated.
    *
    * <p>Any exceptions thrown during evaluation of either predicate are relayed
    * to the caller; if evaluation of this predicate throws an exception, the
    * {@code other} predicate will not be evaluated.
    */
   @Test
   public void testPredicateTestAnd()
   {
      //given
      Predicate<Integer> isEven = (num) -> num % 2 == 0;
      Predicate<Integer> isEvenAndGreater100 = isEven.and((num) -> num > 100);

      //verify
      Assertions.assertTrue(isEvenAndGreater100.test(102));
      Assertions.assertFalse(isEvenAndGreater100.test(101));
      Assertions.assertFalse(isEvenAndGreater100.test(3));

   }


   @Test
   public void testPredicateTestOr()
   {
      //given
      Predicate<Integer> isEven = (num) -> num % 2 == 0;
      Predicate<Integer> isEvenOrGreater100 = isEven.or((num) -> num > 100);

      //verify
      Assertions.assertTrue(isEvenOrGreater100.test(102));
      Assertions.assertTrue(isEvenOrGreater100.test(101));
      Assertions.assertFalse(isEvenOrGreater100.test(3));

   }

   /**
    * Returns a predicate that tests if two arguments are equal according
    * to {@link Objects#equals(Object, Object)}.
    */
   @Test
   public void testPredicateIsEqual()
   {
      Assertions.assertTrue(Predicate.isEqual(20).test(20));
   }
}
