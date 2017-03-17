package PointOfSale;

import DBManagement.SystemManagment;
import PointOfSaleService.CodeScanner;
import PointOfSaleService.Information;
import PointOfSaleService.OutDisplays;

import java.sql.*;

/**
 * Created by kalisiaczki on 15.03.2017.
 */
public class PointOfSale {

    public static void main(String[] args) throws SQLException {

        Information.welcomeFirst();

            System.out.println("Please type first column name (e.g. id): ");
            String firstColumnName = CodeScanner.readLine();

            System.out.println("Please type second column name (e.g. name): ");
            String secondColumnName = CodeScanner.readLine();

            System.out.println("Please type third column name (e.g. price): ");
            String thirdColumnName = CodeScanner.readLine();

        SystemManagment.createTable(firstColumnName,secondColumnName,thirdColumnName);
        Information.welcome();

       do {
            int chosenMenu = CodeScanner.readInt();
            switch (chosenMenu) {
                case 1:
                        System.out.println("Insert product " + firstColumnName + " :");
                    int idProduct = CodeScanner.readInt();

                        System.out.println("Insert product " + secondColumnName + " :");
                    String nameProduct = CodeScanner.readLine();

                        System.out.println("Insert product " + thirdColumnName + " :");
                    int priceProduct = CodeScanner.readInt();

                    SystemManagment.insertProduct(idProduct,nameProduct,priceProduct,firstColumnName,secondColumnName,thirdColumnName);
                    SystemManagment.showProducts(firstColumnName,secondColumnName,thirdColumnName);

                    break;
                case 2:
                    SystemManagment.insertSample(firstColumnName,secondColumnName,thirdColumnName);
                    SystemManagment.showProducts(firstColumnName,secondColumnName,thirdColumnName);
                    break;
                case 3:
                        System.out.println("Scan by this number: ");
                    int idScanned = CodeScanner.readInt();
                    OutDisplays.scanProduct(firstColumnName,secondColumnName,thirdColumnName,idScanned);

                    break;
                case 4:
                    System.exit(0);


                    break;
                case 5:

                    break;

                default:
                        System.out.println("Please choose a command number from the MENU below:");
                    Information.welcome();
            }
        } while(true);

       }
    }






















