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

    public static boolean isItEmpty(int idScanned){

        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(idScanned);
        String stringScanned = sb.toString();

        if(stringScanned != null && !stringScanned.trim().isEmpty()){
            return false;
        }else{
            return true;
        }


    }

}
