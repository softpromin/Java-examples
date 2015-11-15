// assertions/Assert2.java
// �2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
// Assert with an informative message
// {JVMArgs: -ea}
// {ThrowsException}

public class Assert2 {
  public static void main(String[] args) {
    assert false: "Here's a message saying what happened";
  }
}
/* Output:
___[ Error Output ]___
Exception in thread "main" java.lang.AssertionError: Here's
a message saying what happened
        at Assert2.main(Assert2.java:8)
___[ Exception is Expected ]___
*/
