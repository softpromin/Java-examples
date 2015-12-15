// exceptions/MessyExceptions.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
import java.io.*;

public class MessyExceptions {
  public static void main(String[] args) {
    InputStream in = null;
    try {
      in = new FileInputStream(
        new File("MessyExceptions.java"));
      int contents = in.read();
      // Process contents
    } catch(IOException e) {
      // Handle the error
    } finally {
      if(in != null) {
        try {
          in.close();
        } catch(IOException e) {
          // Handle the close() error
        }
      }
    }
  }
}
