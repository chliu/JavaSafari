package org.javasafari.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Lambda expressions are a new and important feature  included in java8.
 * They provide a clear and concise way to represent one method interface using an expression.
 * <p>
 * Lambda expressions also improve the Collection libraries making it easier to iterate through, filter,
 * and extract data from a Collection. In addition, new concurrency features improve performance in multicore environment.
 * <p>
 * A lambda expression represents an anonymous function. It comprises of a set of parameters, a lambda operator (->) and a function body.
 */
public class BasicLambdaTest
{

   @Test
   public void testAnonymousAndLambdaRunnable()
   {
      Runnable r1 = new Runnable()
      {
         @Override
         public void run()
         {
            System.out.println("Hello world!");
         }
      };

      Runnable r2 = () -> System.out.println("Hello world!");

      r1.run();
      r2.run();
   }

   @FunctionalInterface
   interface Function3<A, B, C, R>
   {
      R apply(A a, B b, C c);
   }


   @Test
   public void testMultipleArguments()
   {
      Function3<String, Double, Double, Double> multiAdder = (a, b, c) -> Double.parseDouble(a) + b + c;
      Assertions.assertTrue(64.4 == multiAdder.apply("22.4", 2.0, 40.0));
   }

   /**
    * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
    * In the foregoing description, the notation sgn(expression) designates the mathematical signum function, which is defined to return one of -1, 0, or 1 according to whether the value of expression is negative, zero or positive.
    * The implementor must ensure that sgn(compare(x, y)) == -sgn(compare(y, x)) for all x and y. (This implies that compare(x, y) must throw an exception if and only if compare(y, x) throws an exception.)
    */
   @Test
   public void testComparator()
   {
      List<String> strings = new ArrayList()
      {{
         add("234");
         add("2");
         add("helloworld");
         add("12");
      }};

      Collections.sort(strings, (x, y) -> y.length() - x.length());
      Assertions.assertEquals("helloworld", strings.get(0));
      Assertions.assertEquals("2", strings.get(strings.size() - 1));
   }

   public class Person
   {
      private String firstName;
      private String lastName;
      private int age;

      public Person(String fn, String ln, int a)
      {
         this.firstName = fn;
         this.lastName = ln;
         this.age = a;
      }

      public String getFirstName() { return firstName; }

      public String getLastName() { return lastName; }

      public int getAge() { return age; }

      @Override
      public String toString()
      {
         final StringBuffer sb = new StringBuffer("Person{");
         sb.append("firstName='").append(firstName).append('\'');
         sb.append(", lastName='").append(lastName).append('\'');
         sb.append(", age=").append(age);
         sb.append('}');
         return sb.toString();
      }
   }

   @Test
   public void testSortPeopelByLambda()
   {
      List<Person> people = Arrays.asList(
         new Person("Ted", "Neward", 42),
         new Person("Charlotte", "Neward", 39),
         new Person("Michael", "Neward", 19),
         new Person("Matthew", "Neward", 13),
         new Person("Neal", "Ford", 45),
         new Person("Candy", "Ford", 39),
         new Person("Jeff", "Brown", 43),
         new Person("Betsy", "Brown", 39)
      );

      Collections.sort(people, (lhs, rhs) ->
      {
         if (lhs.getLastName().equals(rhs.getLastName()))
            return lhs.getAge() - rhs.getAge();
         else
            return lhs.getLastName().compareTo(rhs.getLastName());
      });
      System.out.println(people);
   }


   @Test
   public void testSortPeopelByLambda2()
   {
      List<Person> people = Arrays.asList(
         new Person("Ted", "Neward", 42),
         new Person("Charlotte", "Neward", 39),
         new Person("Michael", "Neward", 19),
         new Person("Matthew", "Neward", 13),
         new Person("Neal", "Ford", 45),
         new Person("Candy", "Ford", 39),
         new Person("Jeff", "Brown", 43),
         new Person("Betsy", "Brown", 39)
      );

      Comparator<Person> comparator = Comparator.comparing(person -> person.lastName);
      comparator = comparator.thenComparing(Comparator.comparing(person -> person.age));
      Stream<Person> personStream = people.stream().sorted(comparator);

      List<Person> sortedPeople = personStream.collect(Collectors.toList());

      Assertions.assertEquals("Brown", sortedPeople.get(0).getLastName());
      Assertions.assertEquals(39, sortedPeople.get(0).getAge());
   }


   @Test
   public void testLambdaSyntax()
   {


   }

}
