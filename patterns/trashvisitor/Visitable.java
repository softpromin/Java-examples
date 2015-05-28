//: patterns/trashvisitor/Visitable.java
// An interface to add visitor functionality to 
// the Trash hierarchy without modifying the 
// base class.
package patterns.trashvisitor;

interface Visitable {
  // The new method:
  void accept(Visitor v);
} ///:~
