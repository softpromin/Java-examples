// functional/Closure1.java
// �2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
import java.util.function.*;

public class Closure1 {
  int i;
  IntSupplier make_fun(int x) {
    return () -> x + i++;
  }
}
