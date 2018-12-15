package org.javasafari.util;

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
   public void testCreateNonNullOptional()
   {
      Optional<String> country = Optional.of("Taiwan");
      Assertions.assertTrue(country.isPresent());
      Assertions.assertEquals("Taiwan", country.get());
   }

   @Test
   public void testCreateNullValueOptional()
   {
      Assertions.assertEquals(false, Optional.ofNullable(null).isPresent());
      Assertions.assertEquals("defaultValue", Optional.ofNullable(null).orElse("defaultValue"));
   }

   @Test
   public void testGetElseOption()
   {
      Optional<Date> current = Optional.ofNullable(null);
      Assertions.assertNotNull(current.orElse(new Date()));
   }

   @Test
   public void testOrElseGet()
   {
      Date dateNow = null;
      Assertions.assertNotNull(Optional.ofNullable(dateNow).orElseGet(Date::new));
   }

   @Test
   public void testOrElseThrow()
   {
      Date dateNow = null;
      Assertions.assertThrows(IllegalArgumentException.class,
         () -> Optional.ofNullable(dateNow).orElseThrow(IllegalArgumentException::new));
   }

   @Test
   public void testFilter()
   {
      Optional<String> taipeiCity = Optional.of("Taipei").filter((v) -> v.contains("No.1 City"));
      Assertions.assertEquals(Optional.empty(), taipeiCity);

      Optional<String> county = Optional.of("Taiwan").filter(v -> v.contains("Taiwan"));
      Assertions.assertEquals("Taiwan", county.get());
   }

   @Test
   public void testFlatMap()
   {
      Optional<Integer> numOp = Optional.of("111").flatMap(v -> Optional.of(Integer.valueOf(v)));
      Assertions.assertEquals(Integer.valueOf(111), numOp.get());
   }
}
