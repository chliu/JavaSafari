package org.javasafari.util.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class Java8HashMapTest
{

   @Test
   public void testGetOfDefault()
   {
      Map<String, Integer> studentGrades = new HashMap<>();
      assertThat(studentGrades.getOrDefault("Chris", 0), equalTo(new Integer(0)));
   }


   @Test
   public void testForEach()
   {
      Map<String, Integer> collector = new HashMap()
      {
         {
            put("A", 99);
            put("B", 80);
            put("C", 70);
         }
      };
      collector.forEach((key, value) -> System.out.println(String.format("%s => %s", key, value)));
   }


   @Test
   public void testReplaceAll()
   {
      Map<String, Integer> collector = new HashMap()
      {
         {
            put("A", 99);
            put("B", 82);
            put("C", 71);
         }
      };
      collector.replaceAll((key, value) -> value < 90 ? value + 10 : value);
      assertThat(collector, hasEntry("A", 99));
      assertThat(collector, hasEntry("B", 92));
      assertThat(collector, hasEntry("C", 81));
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
   public void testMergeValue()
   {
      Map<String, String> holder = new HashMap();
      holder.put("chris", "^^~");
      holder.merge("chris", "Java", (v1, v2) -> v1.concat(v2));
      Assert.assertThat(holder.get("chris"), is("^^~Java"));
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
   public void testComputeIfPresent()
   {
      Map<String, Integer> map = new HashMap()
      {{
         put("key", 2);
      }};
      map.computeIfPresent("key", (k, v) -> v / 2);
      assertThat(map.get("key"), equalTo(1));
   }


   @Test
   public void testComputeIfAbsent()
   {
      Map<String, List<Integer>> counters = new HashMap<>();
      counters.computeIfAbsent("key", k -> new ArrayList<>()).addAll(Arrays.asList(1, 3, 5));
      assertThat(counters.get("key"), hasItems(1, 3, 5));
   }


   @Test
   public void testPutIfAbsent()
   {
      Map<String, Integer> counters = new HashMap()
      {{ put("c0", 0); }};

      counters.putIfAbsent("c0", 99);
      counters.putIfAbsent("c1", 99);

      assertEquals(Integer.valueOf(0), counters.get("c0"));
      assertEquals(Integer.valueOf(99), counters.get("c1"));
   }

}

