import java.sql.*;
import java.util.*;


public class DBoutique {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        try {
            // create connection
            //String url = "jdbc:mysql://cps-database.gonzaga.edu/cpsc321";
            String url = "jdbc:mysql://cps-database.gonzaga.edu/svowlesDB";
            String user = "svowles";
            String pass = "Shv@022797";

            //System.out.println("1");

            Connection cn = DriverManager.getConnection(url, user, pass);
            //System.out.println("cn:" +  cn);
            //System.out.println("2");
            // create a statement and execute it
            Statement st = cn.createStatement();
            //System.out.println("3");
            String query = "";

            System.out.println("*************************");
            System.out.println("  Welcome to DBoutique!");
            System.out.println("*************************");
            System.out.println();
            System.out.println();
            System.out.println("Select an option:");
            //mange = add/remove boutique
            System.out.println("    1) Manage a boutique");
            //add/remove
            System.out.println("    2) Manage inventory items");
            //compare sales, view inventory doing well and not doing well, see what brands are doing well
            System.out.println("    3) Analyze Data");
            System.out.println("    4) Record an item sold");
            System.out.println("");

            System.out.print("Enter your option selection: ");
            int selectedChoice = reader.nextInt();
            System.out.println("");

            //want to manage boutique
            if (selectedChoice == 1) {
                System.out.println("You have selected 'Manage a boutique'.");
                System.out.println("");

                System.out.println("Select an option:");
                //mange = add/remove boutique
                System.out.println("    1) Add a boutique");
                //add/remove
                System.out.println("    2) Remove a boutique");
                System.out.println("");
                System.out.print("Enter your option selection: ");
                selectedChoice = reader.nextInt();
                System.out.println("");

                if (selectedChoice == 1) {
                    //System.out.println("Desired action: add a boutique");
                    //System.out.println("Execute add boutique action.");
                }
                if (selectedChoice == 2) {
                    //System.out.println("Desired action: remove a boutique");
                    //System.out.println("Execute remove boutique action.");
                    System.out.println("You have selected 'Remove a boutique'\n");
                    System.out.print("Please enter the id of the boutique you would like to delete: ");
                    int boutque_id = reader.nextInt();

                    //execute query

                    System.out.println("Boutique " + boutque_id + " has been deleted.");

                }
            }

            if (selectedChoice == 2) {
                System.out.println("You have selected 'Manage inventory item'.");
                System.out.println("");

                System.out.println("Select an option:");
                //mange = add/remove boutique
                System.out.println("    1) Add an inventory item");
                //add/remove
                System.out.println("    2) Remove an inventory item");
                System.out.println("");
                System.out.print("Enter your option selection: ");
                selectedChoice = reader.nextInt();
                System.out.println("");

                if (selectedChoice == 1) {
                    System.out.println("You have selected 'Add an inventory item'.");
                    System.out.println("");
                    System.out.print("Please enter an inventory id (integer): ");
                    int inventory_id = reader.nextInt();
                    System.out.println("");
                    System.out.print("Please enter an brand: ");
                    String brand = reader.next();
                    System.out.println("");
                    System.out.print("Please enter an category ('bottom', 'top', 'accessory', 'shoes', etc.): ");
                    String category_name = reader.next();
                    System.out.println("");
                }

                if (selectedChoice == 2) {
                    System.out.println("You have selected 'Remove an inventory item'.");
                    System.out.println("");
                    System.out.print("Please enter an inventory id (integer): ");
                    int inventory_id = reader.nextInt();

                    System.out.println("");
                    System.out.print("item " + inventory_id + "has been removed.");

                }

            }

            if (selectedChoice == 3) {
                System.out.println("You have selected 'Analyze Data'.");
                System.out.println("");

                System.out.println("Select an option:");
                System.out.println("    1) Compare sales of all boutique stores");
                System.out.println("    2) View inventory item(s) selling the most at a particular store");
                System.out.println("    3) View inventory item(s) selling the least at a particular store");
                System.out.println("    4) View inventory item(s) selling the most in all stores");
                System.out.println("    5) View inventory item(s) selling the least in all stores");
                System.out.println("    6) View the brand(s) selling the most in all stores");
                System.out.println("");
                System.out.print("Enter your option selection: ");
                selectedChoice = reader.nextInt();
                System.out.println("");

                if (selectedChoice == 1) {
                    System.out.println("You have selected 'Compare sales of all boutique stores'.");
                    System.out.println("");
                }
                if (selectedChoice == 2) {
                    System.out.println("You have selected 'View inventory item(s) selling the most at a particular store'.");
                    System.out.println("");
                }
                if (selectedChoice == 3) {
                    System.out.println("You have selected 'View inventory item(s) selling the least at a particular store'.");
                    System.out.println("");
                }
                if (selectedChoice == 4) {
                    System.out.println("You have selected 'View inventory item(s) selling the most in all stores'.");
                    System.out.println("");
                }
                if (selectedChoice == 5) {
                    System.out.println("You have selected 'View inventory item(s) selling the least in all stores'.");
                    System.out.println("");
                }
                if (selectedChoice == 6) {
                    System.out.println("You have selected 'View the brand(s) selling the most in all stores'.");
                    System.out.println("");
                }

            }

            if (selectedChoice == 4) {
                System.out.println("You have selected 'Record an item sold'.");
                System.out.println("");
                System.out.print("Please enter a sale id (integer): ");
                int sale_id = reader.nextInt();
                System.out.println("");
                System.out.print("Please enter an inventory id (integer): ");
                int inventory_id = reader.nextInt();
                System.out.println("");
                System.out.print("Please enter a quantity (integer): ");
                int quantity = reader.nextInt();
                System.out.println("");
                System.out.print("Please enter the price the item was sold for (decimal): ");
                double sold_price = reader.nextDouble();
                System.out.println("");
                System.out.print("Please enter the store id of the store the item was sold at (integer): ");
                int store_id = reader.nextInt();
                System.out.println("");
            }
        }
        catch(SQLException e) {
            System.out.println("error");
        }
    }

}
