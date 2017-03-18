package PointOfSaleService;

import java.util.Scanner;

import static PointOfSaleService.OutDisplays.allProducts;

/**
 * Created by kalisiaczki on 15.03.2017.
 */
public class CodeScanner {

    public static String readLine() {
        try {
            return new Scanner(System.in).nextLine().trim();
        } catch (Exception e) {
            return null;
        }
    }

    public static int readInt() {
        try {

            return new Scanner(System.in).nextInt();
        } catch (Exception e) {

            return intAlert();
        }
    }

    public static int intAlert() {
        try {
            String alert = "It is not a number, try again: ";
            System.out.println(alert);
            return new Scanner(System.in).nextInt();
        } catch (Exception e) {

            return intAlert();
        }
    }

    public static int readScan() {

        try {
            Scanner in = new Scanner(System.in);
            String text = in.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("Invalid bar-code");
                return 0;
            } else {
                final int number = Integer.valueOf(text);

                return number;

            }
        } catch (Exception e) {

            return intAlert();

        }


    }
}
