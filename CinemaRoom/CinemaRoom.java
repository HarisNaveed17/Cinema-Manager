package CinemaRoom;
import java.util.Scanner;

public class CinemaRoom {

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number of rows:");
    int numRows = sc.nextInt();
    System.out.println("Enter the number of seats in each row:");
    int numSeats = sc.nextInt();

    char[][] cinemaSeats = new char[numRows][numSeats];
    for (int i = 0; i < cinemaSeats.length; i++) {
      for (int j = 0; j < cinemaSeats[i].length; j++) {
        cinemaSeats[i][j] = 'S';
      }
    }

    System.out.println("Cinema:");
    System.out.print("  ");
    for (int cols = 1; cols < numSeats + 1; cols++) {
      System.out.print(cols + " ");
    }
    System.out.println();
    for (int row = 0; row < numRows; row++) {
      System.out.print(row + 1 + " ");
      for (int j = 0; j < cinemaSeats[row].length; j++) {
        System.out.print(cinemaSeats[row][j] + " ");
      }
      System.out.println();
    }
    System.out.println("Enter the row number:");
    int seatRow = sc.nextInt();
    System.out.println("Enter a seat number in that row:");
    int seatNum = sc.nextInt();

    int totalSeats = numRows * numSeats;
    int price;
    if (totalSeats <= 60) {
      price = 10;

    } else {
      int frontRows = numRows / 2;
      if (seatRow <= frontRows) {
        price = 10;
      } else {
        price = 8;
      }
    }
    System.out.printf("Ticket price: $%d\n", price);
    cinemaSeats[seatRow - 1][seatNum - 1] = 'B';
    System.out.println("Cinema:");
    System.out.print("  ");
    for (int cols = 1; cols < numSeats + 1; cols++) {
      System.out.print(cols + " ");
    }
    System.out.println();
    for (int row = 0; row < numRows; row++) {
      System.out.print(row + 1 + " ");
      for (int j = 0; j < cinemaSeats[row].length; j++) {
        System.out.print(cinemaSeats[row][j] + " ");
      }
      System.out.println();
    }

  }
  
}
