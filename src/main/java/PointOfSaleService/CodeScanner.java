package PointOfSaleService;

import java.util.Scanner;

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

    public static int readInt(){
        try {

            return new Scanner(System.in).nextInt();
        }
        catch (Exception e){

            return intAlert();
        }
    }

    public static int intAlert()
    {
        try {
            String alert = "It is not a number, try again: ";
            System.out.println(alert);
            return new Scanner(System.in).nextInt();
        }catch (Exception e){

            return intAlert();
        }
    }

    public static int readScan(){

        Scanner in = new Scanner(System.in);
        int numberFirst = 0;
        String text = in.nextLine();
        if(text.isEmpty()){
            System.out.println("Invalid bar-code");
            return numberFirst;

        }else
        {
            int number = 0;
            number = Integer.valueOf(text);
            return number;
        }

    }



}
