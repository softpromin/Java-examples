// generics/UseList.java
// �2015 MindView LLC: see Copyright.txt
// {CompileTimeError} (Will not compile)

public class UseList<W,T> {
  void f(List<T> v) {}
  void f(List<W> v) {}
}
