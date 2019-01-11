package org.javasafari.lambda;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaBytecode
{
   private Function<String, Integer> f = s -> Integer.parseInt(s);

   public String test()
   {
      Function<String, String> c = (a) -> a.toUpperCase();
      Supplier<Date> s = () -> new Date();
      return c.apply("java") + s.get() + f.apply("99");
   }

}

/**
 public class org.javasafari.lambda.LambdaBytecode {
 private java.util.function.Function<java.lang.String, java.lang.Integer> f;

 public org.javasafari.lambda.LambdaBytecode();
 Code:
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: aload_0
 5: invokedynamic #2,  0              // InvokeDynamic #0:apply:()Ljava/util/function/Function;
 10: putfield      #3                  // Field f:Ljava/util/function/Function;
 13: return

 public java.lang.String test();
 Code:
 0: invokedynamic #4,  0              // InvokeDynamic #1:apply:()Ljava/util/function/Function;
 5: astore_1
 6: invokedynamic #5,  0              // InvokeDynamic #2:get:()Ljava/util/function/Supplier;
 11: astore_2
 12: new           #6                  // class java/lang/StringBuilder
 15: dup
 16: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
 19: aload_1
 20: ldc           #8                  // String java
 22: invokeinterface #9,  2            // InterfaceMethod java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
 27: checkcast     #10                 // class java/lang/String
 30: invokevirtual #11                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 33: aload_2
 34: invokeinterface #12,  1           // InterfaceMethod java/util/function/Supplier.get:()Ljava/lang/Object;
 39: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 42: aload_0
 43: getfield      #3                  // Field f:Ljava/util/function/Function;
 46: ldc           #14                 // String 99
 48: invokeinterface #9,  2            // InterfaceMethod java/util/function/Function.apply:(Ljava/lang/Object;)Ljava/lang/Object;
 53: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 56: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 59: areturn

 private static java.util.Date lambda$test$2();
 Code:
 0: new           #16                 // class java/util/Date
 3: dup
 4: invokespecial #17                 // Method java/util/Date."<init>":()V
 7: areturn

 private static java.lang.String lambda$test$1(java.lang.String);
 Code:
 0: aload_0
 1: invokevirtual #18                 // Method java/lang/String.toUpperCase:()Ljava/lang/String;
 4: areturn

 private static java.lang.Integer lambda$new$0(java.lang.String);
 Code:
 0: aload_0
 1: invokestatic  #19                 // Method java/lang/Integer.parseInt:(Ljava/lang/String;)I
 4: invokestatic  #20                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 7: areturn
 }
 */