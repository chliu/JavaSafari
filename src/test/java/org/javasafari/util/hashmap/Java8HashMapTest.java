package org.javasafari.util.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Java8HashMapTest
{

   //given
   Map<String, Integer> collector = new HashMap();

   @Before
   public void setUp()
   {
      String text = "All algorithms are built with parameters created by humans. All algorithms are built with ";
      //when
      for (String word : text.split(" "))
      {
         collector.computeIfAbsent(word, (key) -> 0);
         collector.compute(word, (key, value) -> ++value);
      }

   }


   @Test
   public void testGetOfDefault()
   {
      assertEquals(Integer.valueOf(0), collector.getOrDefault("ABC", 0));
   }


   @Test
   public void testForEach()
   {
      collector.forEach((key, value) -> System.out.println(String.format("%s#%s", key, value)));
   }


   @Test
   public void testReplaceAll()
   {
      collector.replaceAll((key, value) -> value * value);
   }


   @Test
   public void testMerge()
   {
      //given
      Map<String, List<String>> users = new HashMap<>();
      users.computeIfAbsent("user1", (name) -> new ArrayList<>());

      //when
      users.merge("user1", Arrays.asList("Math"), (v, v2) -> {
         v.addAll(v2);
         return v;
      });

      //verify
      assertEquals("Math", users.get("user1").get(0));

   }


   @Test
   public void testMergeSum()
   {
      //given
      Map<String, Integer> counters = new HashMap<>();

      //when
      counters.computeIfAbsent("c1", (n) -> 0);
      counters.merge("c1", 10, (v, v1) -> v + v1);
      //verify
      assertEquals(Integer.valueOf(10), counters.get("c1"));
   }

   @Test
   public void testComputeIfPresentAndAbsent()
   {

      //given
      Map<String, Integer> counters = new HashMap<>();

      //when
      counters.computeIfAbsent("c1", (n) -> 0);
      counters.computeIfAbsent("c2", (n) -> 2);
      //when


      counters.computeIfPresent("c1", (k, v) -> ++v);
      counters.computeIfPresent("c2", (k, v) -> ++v);

      //verify
      assertEquals(Integer.valueOf(1), counters.get("c1"));
      assertEquals(Integer.valueOf(3), counters.get("c2"));

   }


   @Test
   public void testPutIfAbsent()
   {

      //given
      Map<String, Integer> counters = new HashMap<>();
      counters.put("c0", null);
      counters.put("c1", 1);
      counters.putIfAbsent("c2", 99);

      //when
      counters.putIfAbsent("c0", 99);
      counters.putIfAbsent("c1", 99);

      //verify
      assertEquals(Integer.valueOf(99), counters.get("c0"));
      assertEquals(Integer.valueOf(1), counters.get("c1"));
      assertEquals(Integer.valueOf(99), counters.get("c2"));

   }


}
