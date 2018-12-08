package org.javasafari.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Assertions;
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
   public void testConsumerAccept()
   {
      //given
      List<String> names = new ArrayList();
      Consumer<String> addStudents = (name) -> names.add(name);
      //when
      addStudents.accept("chris");
      //verify
      Assertions.assertEquals("chris", names.get(0));
   }

   @Test
   public void testConsumerAcceptAndThenPrint()
   {
      //given
      List<String> names = new ArrayList();
      Consumer<String> addStudent = (name) -> names.add(name);
      Consumer<String> printStudentAfterAdding = addStudent.andThen(name -> System.out.println("added " + name));
      //when
      printStudentAfterAdding.accept("chris");
      //verify
      Assertions.assertEquals("chris", names.get(0));
   }

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
      //when
      consumerWithAndThen.accept(22);
      //verify

   }
}
