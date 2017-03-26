package pointOfSale;

import dbManagement.SystemManagment;
import pointOfSaleService.CodeScanner;
import pointOfSaleService.Information;
import pointOfSaleService.OutDisplays;
import java.sql.*;

/**
 * Created by kalisiaczki on 15.03.2017.
 */
public class PointOfSale {

    public static void main(String[] args) throws SQLException {

        Information information = new Information();
        SystemManagment systemManagment = new SystemManagment();
        OutDisplays outDisplays = new OutDisplays();

            information.welcomeFirst();

            System.out.println("Please write down name for the first column which contains numerical data in Products Database (e.g. id or unique id): ");
            final String firstColumnName = CodeScanner.readLine();

            System.out.println("Please write down name for the second column which contains text data in Products Database (e.g. name or product name): ");
            final String secondColumnName = CodeScanner.readLine();

            System.out.println("Please write down name for the third column which contains numerical data in Products Database (e.g. price or product price): ");
            final String thirdColumnName = CodeScanner.readLine();

            systemManagment.createTable(firstColumnName,secondColumnName,thirdColumnName);
            information.welcome();

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

                    systemManagment.insertProduct(idProduct,nameProduct,priceProduct,firstColumnName,secondColumnName,thirdColumnName);
                    systemManagment.showProducts(firstColumnName,secondColumnName,thirdColumnName);
                    information.welcome();

                    break;
                case 2:
                    systemManagment.insertSample(firstColumnName,secondColumnName,thirdColumnName);
                    systemManagment.showProducts(firstColumnName,secondColumnName,thirdColumnName);
                    information.welcome();
                    break;
                case 3:
                        System.out.println("Scan products by this number: ");

                    outDisplays.isItInDatabase(firstColumnName,secondColumnName,thirdColumnName);
                    int idScanned = CodeScanner.readScan();
                    outDisplays.scanProduct(firstColumnName, secondColumnName, thirdColumnName, idScanned);
                    information.welcome();

                    break;
                case 4:
                    OutDisplays.exitDisplayAndCount(secondColumnName,thirdColumnName);
                    System.exit(0);
                    break;
                default:
                        System.out.println("Please choose a command number from the MENU below:");

                    information.welcome();
            }
        } while(true);
       }
    }






















