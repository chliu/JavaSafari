package org.javasafari.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
 * Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (return a default value if value not present) and ifPresent() (execute a block of code if the value is present).
 * <p>
 * This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization) on instances of Optional may have unpredictable results and should be avoided.
 */
public class OptionalTest
{
   @Test
   public void testCreateNullObject()
   {
      Assertions.assertEquals(false, Optional.ofNullable(null).isPresent());
      Assertions.assertEquals("defaultValue", Optional.ofNullable(null).orElse("defaultValue"));
      Assertions.assertEquals("test", Optional.of("test").get());
   }

   @Test
   public void testOrElse()
   {
      Date dateNow = null;
      Assertions.assertNotNull(Optional.ofNullable(dateNow).orElse(new Date()));
   }

   @Test
   public void testOrElseGet()
   {
      Date dateNow = null;
      Assertions.assertNotNull(Optional.ofNullable(dateNow).orElseGet(() -> Calendar.getInstance().getTime()));
   }

   @Test
   public void testOrElseThrow()
   {
      Date dateNow = null;
      Assertions.assertThrows(IllegalArgumentException.class, () -> Optional.ofNullable(dateNow).orElseThrow(IllegalArgumentException::new));
   }

   @Test
   public void testFilter()
   {
      Optional<String> country = Optional.of("Taiwan").filter((v) -> v.contains("No.1"));
      Assertions.assertEquals(Optional.empty(), country);
      Assertions.assertEquals("input is wrong!!", country.orElse("input is wrong!!"));

   }

   @Test
   public void testFlatMap()
   {
      String lowerCountryName = Optional.of("Taiwan").flatMap((v) -> Optional.of(v.toLowerCase())).get();
      Assertions.assertEquals("taiwan", lowerCountryName);
   }
}
