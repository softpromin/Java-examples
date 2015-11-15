// strings/ArrayListDisplay.java
// �2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
import generics.coffee.*;
import java.util.*;

public class ArrayListDisplay {
  public static void main(String[] args) {
    ArrayList<Coffee> coffees = new ArrayList<>();
    for(Coffee c : new CoffeeSupplier(10))
      coffees.add(c);
    System.out.println(coffees);
  }
}
/* Output:
[Americano 0, Latte 1, Americano 2, Mocha 3, Mocha 4, Breve
5, Americano 6, Latte 7, Cappuccino 8, Cappuccino 9]
*/
