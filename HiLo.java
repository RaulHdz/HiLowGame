import javax.swing.JOptionPane;
import java.util.*;

class HiLo {
  public static Scanner keyboard = new Scanner(System.in);
  public static Random generator = new Random ();
  public static int A = generator.nextInt(100) + 1;
  public static int B = 0;
  public static int C = 0;
  public static int D = 0;
  public static String S = "";
  public static void main(String[] args) {
    S = JOptionPane.showInputDialog("Do you want you or the computer to guess? (1 = You, 2 = Computer)");
    int F = Integer.parseInt(S);
    switch ( F ) {
      case 1:
        you();
        break;
      case 2:
        computer();
        break;
      default:
        JOptionPane.showMessageDialog(null, "Enter only 1 or 2!", "ERROR!", JOptionPane.PLAIN_MESSAGE);
        break;
    }
  }
  public static void you() {
    S = JOptionPane.showInputDialog("Guess the number between 1 and 100:");
    B = Integer.parseInt(S);
    while (B > A || B < A) {
      while (B > 100 || B < 1) {
        S = JOptionPane.showInputDialog("The number is between 1 and 100. Guess again: ");
        B = Integer.parseInt(S);
      }
      C = C + 1;
      if (B > A) {
        S = JOptionPane.showInputDialog("Too high! You have guessed " + C + " time(s). Guess again: ");
        B = Integer.parseInt(S);
        D = D + 1;
      }
      if (B < A && (D > C || D < C)) {
        S = JOptionPane.showInputDialog("Too low! You have guessed " + C + " time(s). Guess again: ");
        B = Integer.parseInt(S);
        D = D + 1;
      }
    }
    C = C + 1;
    JOptionPane.showMessageDialog(null, "Number of guesses: " + C, "YOU WIN!", JOptionPane.PLAIN_MESSAGE);
  }
  public static void computer() {
    int E = 0;
    while (E == 0) {
    S = JOptionPane.showInputDialog("Is the number " + A + "? (1 = Too low, 2 = Too high, 3 = Yes)");
    B = Integer.parseInt(S);
    switch ( B ) {
      case 1:
        C = C + 1;
        if (C == 1) {
        D = 50 - A/2;
      }
        else {
          D = D / 2;
        }
        if (D/2 < 1) {
        D = 1;
      }
        A = A + D;
        break;
      case 2:
        C = C + 1;
        if (C == 1) {
        D = A/2;
      }
        else {
          D = D / 2;
        }
        if (D/2 < 1) {
        D = 1;
      }
        A = A - D;
        break;
      case 3:
        C = C + 1;
        E = 1;
        JOptionPane.showMessageDialog(null, "Number of guesses: " + C, "I WIN!", JOptionPane.PLAIN_MESSAGE);
        break;
      default:
        JOptionPane.showMessageDialog(null, "Enter only 1, 2 or 3!", "ERROR!", JOptionPane.PLAIN_MESSAGE);
        break;
    }
    }
  }
}