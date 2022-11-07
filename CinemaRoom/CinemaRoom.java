package CinemaRoom;

import java.util.Scanner;

public class CinemaRoom {

  public static void main(String[] args) {
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
    mainMenu(sc, numSeats, numRows, cinemaSeats);

  }

  public static void displaySeating(int numberOfSeats, int numberOfRows, char[][] cinema) {

    System.out.println("Cinema:");
    System.out.print("  ");
    for (int cols = 1; cols < numberOfSeats + 1; cols++) {
      System.out.print(cols + " ");
    }
    System.out.println();
    for (int row = 0; row < numberOfRows; row++) {
      System.out.print(row + 1 + " ");
      for (int j = 0; j < cinema[row].length; j++) {
        System.out.print(cinema[row][j] + " ");
      }
      System.out.println();
    }

  }

  public static void mainMenu(Scanner scanner, int numberOfSeats, int numberOfRows, char[][] cinema) {

    int signal;
    int currentIncome = 0;
    int ticketsSold = 0;
    do {
      System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
      signal = scanner.nextInt();
      switch (signal) {
        case 1:
          displaySeating(numberOfSeats, numberOfRows, cinema);
          break;

        case 2:
          while (true) {
            System.out.println("Enter the row number:");
            int seatRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNum = scanner.nextInt();
            if (seatRow > numberOfRows || seatNum > numberOfSeats || seatRow <= 0 || seatNum <= 0) {
              System.out.println("Wrong input!");

            } else if (cinema[seatRow - 1][seatNum - 1] == 'B') {
              System.out.println("That ticket has already been purchased!");

            } else {
              bookTicket(seatRow, seatNum, cinema);
              ticketsSold += 1;
              int ticketprice = findTicketPrice(numberOfSeats, numberOfRows, seatRow);
              currentIncome += ticketprice;
              System.out.println(ticketprice);
              break;
            }

          }
          break;

        case 3:

          int highIncome = PossibleIncome(numberOfSeats, numberOfRows);
          printStats(currentIncome, highIncome, ticketsSold, numberOfSeats, numberOfRows);
          break;

        case 0:
          break;
      }

    } while (signal != 0);

  }

  public static int findTicketPrice(int numberOfSeats, int numberOfRows, int rowOfSeat) {

    int totalSeats = numberOfSeats * numberOfRows;
    int price;
    if (totalSeats <= 60) {
      price = 10;

    } else {
      int frontRows = numberOfRows / 2;
      if (rowOfSeat <= frontRows) {
        price = 10;
      } else {
        price = 8;
      }
    }

    return price;
  }

  public static void bookTicket(int rowOfSeat, int colOfSeat, char[][] cinema) {
    cinema[rowOfSeat - 1][colOfSeat - 1] = 'B';
  }

  public static int PossibleIncome(int numberOfSeats, int numberOfRows) {
    int totalSeats = numberOfSeats * numberOfRows;
    if (totalSeats <= 60) {
      return totalSeats * 10;
    } else {
      return ((numberOfRows / 2) * numberOfSeats * 10) + ((numberOfRows - numberOfRows / 2) * numberOfSeats * 8);
    }
  }

  public static void printStats(int currIncome, int possibleIncome, int soldTickets, int numberOfRows,
      int numberOfSeats) {
    System.out.printf("Number of purchased tickets: %d\n", soldTickets);
    double percentageTicketsSold = ((float) soldTickets / (numberOfRows * numberOfSeats)) * 100;
    System.out.printf("Percentage: %.2f%%\n", percentageTicketsSold);
    System.out.printf("Current income: $%d\n", currIncome);
    System.out.printf("Possible income: $%d\n", possibleIncome);
  }

}
