// functional/Games.java
// �2016 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://mindviewinc.com/Books/OnJava/ for more book information.
// Using anonymous inner classes with the Game framework.

interface Game { boolean move(); }
interface GameFactory { Game getGame(); }

class Checkers implements Game {
  private Checkers() {}
  private int moves = 0;
  private static final int MOVES = 3;
  @Override
  public boolean move() {
    System.out.println("Checkers move " + moves);
    return ++moves != MOVES;
  }
  public static GameFactory factory = new GameFactory() {
    public Game getGame() { return new Checkers(); }
  };
}

class Chess implements Game {
  private Chess() {}
  private int moves = 0;
  private static final int MOVES = 4;
  public boolean move() {
    System.out.println("Chess move " + moves);
    return ++moves != MOVES;
  }
  // Use a lambda expression instead:
  public static GameFactory factory = () -> new Chess();
}

class TicTacToe implements Game {
  private TicTacToe() {}
  private int moves = 0;
  private static final int MOVES = 4;
  public boolean move() {
    System.out.println("TicTacToe move " + moves);
    return ++moves != MOVES;
  }
  // Use a method reference instead:
  public static GameFactory factory = TicTacToe::new;
}

public class Games {
  public static void playGame(GameFactory factory) {
    Game s = factory.getGame();
    while(s.move())
      ;
  }
  public static void main(String[] args) {
    playGame(Checkers.factory);
    playGame(Chess.factory);
    playGame(TicTacToe.factory);
  }
}
/* Output:
Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3
TicTacToe move 0
TicTacToe move 1
TicTacToe move 2
TicTacToe move 3
*/
