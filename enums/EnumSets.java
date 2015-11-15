// enums/EnumSets.java
// �2016 MindView LLC: see Copyright.txt
// Operations on EnumSets
package enums;
import java.util.*;
import static enums.AlarmPoints.*;

public class EnumSets {
  public static void main(String[] args) {
    EnumSet<AlarmPoints> points =
      EnumSet.noneOf(AlarmPoints.class); // Empty set
    points.add(BATHROOM);
    System.out.println(points);
    points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
    System.out.println(points);
    points = EnumSet.allOf(AlarmPoints.class);
    points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
    System.out.println(points);
    points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
    System.out.println(points);
    points = EnumSet.complementOf(points);
    System.out.println(points);
  }
}
/* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM,
UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4,
KITCHEN]
*/
