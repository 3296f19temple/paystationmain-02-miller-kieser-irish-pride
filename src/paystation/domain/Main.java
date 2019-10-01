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
        String city = "alpha";

        PayStationImpl payStation = new PayStationImpl();
        Scanner obj = new Scanner(System.in);
        Scanner objStrings = new Scanner(System.in);


        do {
            System.out.println("Enter a number: ");
            menuChoice = obj.nextInt();
            switch (menuChoice) {
                //deposit coins
                case 1:
                    System.out.println("Would you like to enter a coin?");
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
                    System.out.println("Total time accrued so far: ");
                    System.out.println(payStation.readDisplay());
                    break;
                    //Buy ticket
                case 3:
                    Receipt r = payStation.buy();
                    System.out.println("Ticket bought. Total time purchased: " + r.value());
                    break;
                    //Cancel
                case 4:
                    System.out.println("You've cancelled the transaction.");
                    Map tempMap = payStation.cancel();
                    for (Object key : tempMap.keySet()) {
                        String mapKey = key.toString();
                        String mapValue = tempMap.get(key).toString();
                        System.out.println(mapKey + " : " + mapValue);
                    }
                    break;
                    //Administrator mode/change rate strategy meaning change city
                case 5:

                    break;
                    //quit
                case 0:
                    loop = false;
                    break;
                default:
                    break;

            }
        } while (loop);

    }
}