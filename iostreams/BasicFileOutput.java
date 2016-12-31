// iostreams/BasicFileOutput.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ValidateByHand}
import java.io.*;

public class BasicFileOutput {
  static String file = "BasicFileOutput.dat";
  public static void
  main(String[] args) throws IOException {
    try(
      BufferedReader in = new BufferedReader(
        new StringReader(
          BufferedInputFile.read(
            "BasicFileOutput.java")));
      PrintWriter out = new PrintWriter(
        new BufferedWriter(new FileWriter(file)))
    ) {
      int lineCount = 1;
      String s;
      while((s = in.readLine()) != null )
        out.println(lineCount++ + ": " + s);
    }
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
  }
}
