// enums/NonEnum.java
// �2016 MindView LLC: see Copyright.txt

public class NonEnum {
  public static void main(String[] args) {
    Class<Integer> intClass = Integer.class;
    try {
      for(Object en : intClass.getEnumConstants())
        System.out.println(en);
    } catch(Exception e) {
      System.out.println("Expected: " + e);
    }
  }
}
/* Output:
Expected: java.lang.NullPointerException
*/
