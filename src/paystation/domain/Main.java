package paystation.domain;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalCoinException {
        //need a while loop to make the program run
        //give them a list of options to select
        boolean loop = true;
        boolean coinsLoop = true;
        int menuChoice = 0;
        int coinAmount = 0;
        String addMoreCoins;
        int city = 1;

        PayStation payStation = new PayStationImpl();
        Scanner obj = new Scanner(System.in);
        Scanner objStrings = new Scanner(System.in);


        do {
            System.out.println("Enter a number: ");
            System.out.println("    0 - Quit ");
            System.out.println("    1 - Deposit Coins ");
            System.out.println("    2 - Display Time So Far ");
            System.out.println("    3 - Buy Ticket ");
            System.out.println("    4 - Cancel Transaction ");
            System.out.println("    5 - Administrator Mode: Change Rate Strategy ");
            menuChoice = obj.nextInt();
            switch (menuChoice) {
                //deposit coins
                case 1:
                    System.out.println("Would you like to enter a coin?");
                    coinsLoop = true;
                    do {
                        System.out.println("Enter the coin amount");
                        coinAmount = obj.nextInt();
                        payStation.addPayment(coinAmount);

                        System.out.println("Do you have another to enter? (y/n)");
                        addMoreCoins = objStrings.nextLine();

                        if (addMoreCoins.equals("y")) {
                            coinsLoop = true;
                        } else if (addMoreCoins.equals("n")) {
                            coinsLoop = false;
                        } else {
                            //try again
                        }
                    } while (coinsLoop);
                    break;
                    //Display
                case 2:
                    System.out.println("Total time accrued so far: " + payStation.readDisplay() + " minutes.");
                    break;
                    //Buy ticket
                case 3:
                    Receipt r = payStation.buy();
                    System.out.println("Ticket bought. Total time purchased: " + r.value() + " minutes.");
                    break;
                    //Cancel
                case 4:
                    System.out.println("You've cancelled the transaction. Coins returned: ");
                    Map<Integer, Integer> tempMap = payStation.cancel();
                    for (Integer key : tempMap.keySet()) {
                        String mapKey = key.toString();
                        String mapValue = tempMap.get(key).toString();
                        if (mapKey.equals("1")) {
                            System.out.println(mapValue + " Nickel(s). ");
                        } else if (mapKey.equals("2")) {
                            System.out.println(mapValue + " Dime(s). ");
                        } else if (mapKey.equals("3")){
                            System.out.println(mapValue + " Quarter(s). ");
                        }

                    }
                    break;
                    //Administrator mode/change rate strategy meaning change city
                case 5:
                    System.out.println("This is the administrator mode. Select your town: ");
                    System.out.println("1 - Alphatown");
                    System.out.println("2 - Betatown");
                    System.out.println("3 - Gammatown");

                    city = objStrings.nextInt();
                    payStation.setTown(city);

                    if (city == 1) {
                        System.out.println("You chose Alphatown");
                    } else if (city == 2) {
                        System.out.println("You chose Betatown");
                    } else if (city == 3) {
                        System.out.println("You chose Gammatown");
                    }

                    break;
                    //quit
                case 0:
                    loop = false;
                    break;
                default:
                    //loop = false;
                    break;

            }
        } while (loop);

    }
}