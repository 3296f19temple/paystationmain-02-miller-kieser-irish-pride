package paystation.domain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //need a while loop to make the program run
        //give them a list of options to select
        boolean loop = true;
        int menuChoice = 0;
        String city = "alpha";

        Scanner obj = new Scanner(System.in);


        do {
            System.out.println("Enter a number: ");
            menuChoice = obj.nextInt();
            switch (menuChoice) {
                //deposit coins
                case 1:
                    System.out.println("Would you like to enter a coin?");
                    //Display
                case 2:

                    //Buy ticket
                case 3:

                    //Cancel
                case 4:

                    //Administrator mode/change rate strategy meaning change city
                case 5:

                    //quit
                case 0:
                    loop = false;

                default:

            }
        } while (loop == true);

    }
}