// patterns/trash/ParseTrash.java
// �2016 MindView LLC: see Copyright.txt
// Open a file and parse its contents into
// Trash objects, placing each into a List.
package patterns.trash;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;

public class ParseTrash {
  public static <T extends Trash> void
  fillBin(String pckg, Fillable<T> bin) {
    try {
      Files.lines(Paths.get("..", "trash", "Trash.dat"))
        // Remove empty lines and comment lines:
        .filter(line -> line.trim().length() != 0)
        .filter(line -> !line.startsWith("//"))
        .forEach( line -> {
          String type = "patterns." + pckg + "." +
            line.substring(
              0, line.indexOf(':')).trim();
          double weight = Double.valueOf(
            line.substring(line.indexOf(':') + 1)
            .trim());
          bin.addTrash(Trash.factory(
            new Trash.Info(type, weight)));
        });
    } catch(IOException |
            NumberFormatException |
            Trash.TrashClassNotFoundException |
            Trash.CannotCreateTrashException e) {
      throw new RuntimeException(e);
    }
  }
  // Special case to handle List:
  public static <T extends Trash> void
  fillBin(String pckg, List<T> bin) {
    fillBin(pckg, new FillableList<>(bin));
  }
  // Basic test:
  public static void main(String[] args) {
    List<Trash> t = new ArrayList<>();
    fillBin("trash", t);
    t.forEach(System.out::println);
  }
}
