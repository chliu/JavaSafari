package org.javasafari.function;

import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Represents a supplier of results.
 * <p>
 * there is no requirement that a new or distinct result be return each time the supplier is invoked.
 */
public class SupplierTest
{


   /**
    * Gets a result.
    */
   @Test
   public void testGetBySupplier()
   {
      //given
      Supplier<String> supplier = () -> "Hello World";

      //when

      //verify
      Assertions.assertEquals("Hello World", supplier.get());
   }


}
