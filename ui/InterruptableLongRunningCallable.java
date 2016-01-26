// ui/InterruptableLongRunningCallable.java
// (c)2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
// Using Callables for long-running tasks
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import onjava.*;
import static onjava.SwingConsole.*;

class CallableTask extends Task
implements Callable<String> {
  @Override
  public String call() {
    run();
    return "Return value of " + this;
  }
}

public class
InterruptableLongRunningCallable extends JFrame {
  private JButton
    b1 = new JButton("Start Long Running Task"),
    b2 = new JButton("End Long Running Task"),
    b3 = new JButton("Get results");
  private TaskManager<String,CallableTask> manager =
    new TaskManager<>();
  public InterruptableLongRunningCallable() {
    b1.addActionListener(e -> {
      CallableTask task = new CallableTask();
      manager.add(task);
      System.out.println(task + " added to the queue");
    });
    b2.addActionListener(e -> {
      for(String result : manager.purge())
        System.out.println(result);
    });
    b3.addActionListener(e -> {
      // Sample call to a Task method:
      for(TaskItem<String,CallableTask> tt : manager)
        tt.task.id(); // No cast required
      for(String result : manager.getResults())
        System.out.println(result);
    });
    setLayout(new FlowLayout());
    add(b1);
    add(b2);
    add(b3);
  }
  public static void main(String[] args) {
    run(new InterruptableLongRunningCallable(), 200, 150);
  }
}
