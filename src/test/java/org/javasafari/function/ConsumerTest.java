package org.javasafari.function;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

/**
 * Represents an operation that accepts a single input argument and returns no result.
 * Unlike most other functional interface, Consumer is expected to operate via side-effects.
 * <p>
 * Consumer only accept with one argument, no return.
 */
public class ConsumerTest
{

   @Test
   public void testConsumer()
   {
      //given
      Consumer<String> printer = (message) -> System.out.println(message.toUpperCase());

      //when
      printer.accept("message!!");
      //verify
   }

   @Test
   public void testConsumerThen()
   {

      //given
      Consumer<Integer> consumer = i -> System.out.print(i);
      Consumer<Integer> consumerWithAndThen = consumer.andThen(i -> System.out.print(" (after printed *" + i + ")"));
      consumerWithAndThen.accept(22);
      //verify

   }
}
