

package com.mycompany.assignment_1_question_1_extremeproducts;
import java.util.ArrayList;
import java.util.Scanner;
public class Product {
    
       public void showProductSelection(int exitInput){
            while (exitInput == 1) {
            int menuInput = Integer.parseInt(DisplayMenu());
            if(menuInput <= 6 && menuInput >= 1 )
            {
                if (menuInput == 1) {
                    SaveProduct();
                }
                if (!productsList.isEmpty()) {
                
                if (menuInput == 2) {

                    writeMessage(SearchProduct());
                }
                if (menuInput == 3) {
                    UpdateProduct();
                }
                if (menuInput == 4) {
                    var deleteIndex = DeleteProduct();
                    if (deleteIndex >= 0) {
                        productsList.remove(deleteIndex);
                        writeMessage("***********************************\n");
                        writeMessage("Product Deleted Successfully.\n");
                        writeMessage("***********************************\n");

                    }
                }
                if (menuInput == 5) {
                    writeMessage(printReport());
                }
                if (menuInput == 6) {
                    ExitApplication();
                }
                    exitInput = showExitMenu();
                } else {
                writeMessage("***********************************\n");
                writeMessage("Please enter some new products to start\n");
                writeMessage("***********************************\n");
                menuInput = Integer.parseInt(DisplayMenu());
            }
            }
            
             
        }
        if (exitInput != 1) {
            ExitApplication();
        }
    }
    static String[] newProductsQuestionnaire = new String[]{
        "Enter the product code: ",
        "Enter the product name: "};
    static String[] categoryList = new String[]{
        "Desktop Computer - 1",
        "Laptop - 2",
        "Tablet - 3",
        "Printer - 4",
        "Gaming Console - 5"};
    static String[] categoryQuestionnaire = new String[]{
        "Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years. ",
        "Enter the price for EliteBook >> ",
        "Enter the stock level for EliteBook >>",
        "Enter the supplier for EliteBook >>"};
    static String[] updateProductsQuestionnaire = new String[]{
        "Update the warrenty? (y) Yes, (n) No",
        "Update the product price? (y) Yes, (n) No",
        "Update the stock level?(y) Yes, (n) No",
        "Update the supplier?(y) Yes, (n) No"};
    static String[] updateProductData = new String[]{
        "Enter a new warrenty >>",
        "Enter a new product price for Elitebook >>",
        "Enter a new stock level >>",
        "Enter a new supplier >>"};

    static String[] resultsOutput = new String[]{
        "PRODUCTS CODE: ",
        "PRODUCTS NAME: ",
        "PRODUCTS CATEGORY: ",
        "PRODUCTS WARRENTY: ",
        "PRODUCTS PRICE: ",
        "PRODUCTS STOCK LEVELS: ",
        "PRODUCTS SUPPLIER: "};
    static ArrayList<String> productsList = new ArrayList<>();

    /*
        This is the main method if I get the input then I can see if its between
        1-6, There after an input is recieved. then there is actions that are taken 
        based on that 
     */

    public static int showExitMenu() {
        writeMessage("Enter (1) to launch menu or any other key to exit.");
        var output = readInput();
        return Integer.parseInt(output.next());
    }

    public static String DisplayMenu() {
        /*
            Show menu 
         */
        writeMessage("Please select one of the following menu items:");
        writeMessage("(1) Capture a new product");
        writeMessage("(2) Search for a product");
        writeMessage("(3) Update a product");
        writeMessage("(4) Delete a product");
        writeMessage("(5) Print report");
        writeMessage("(6) Exit application");

        return readInput().next();
    }
    static String singleTemp = "";

    public static String[] SaveProduct() {
        /*
            STarting of creating a new products.
            saves the data to a single temp string and then stores it in a products list
        
         */
        writeMessage("**********************");
        writeMessage("CAPTURE A NEW PRODUCT");
        writeMessage("**********************");
        String[] newCategoryAnswers = new String[newProductsQuestionnaire.length];
        for (int i = 0; i < newProductsQuestionnaire.length; i++) {
            writeMessage(newProductsQuestionnaire[i]);
            var nestedInput = readInput().next();
            newCategoryAnswers[i] = newProductsQuestionnaire[i] + " " + nestedInput;
            singleTemp += resultsOutput[i] + " " + nestedInput + "\n";
        }
        int productCategory = Integer.parseInt(selectCategory());
        while (!(productCategory >= 1 && productCategory <= 5)) {
            writeMessage("*******************************************************************\n");
            writeMessage("Category you selected has doesnt comply with our selection offer");
            writeMessage("*******************************************************************\n");

            productCategory = Integer.parseInt(selectCategory());
        }
        var newProductTemp = CaptureProduct(productCategory);
        for (int i = 0; i < newProductTemp.length; i++) {
        }
        return newCategoryAnswers;
    }

    public static String selectCategory() {
        /*
            Select the category based on those arrays then I show the 
            output and wait for a selection
         */
        writeMessage("Select the product category: ");
        for (int i = 0; i < categoryList.length; i++) {
            writeMessage(categoryList[i]);
        }
        var x = readInput().next();
        if (Integer.parseInt(x)>=1 && Integer.parseInt(x)<=5 ) {
            singleTemp += resultsOutput[2] + " " + categoryList[Integer.parseInt(x) - 1].split("-")[0] + "\n";
        }
        return x;
    }
    static long totalCost = 0;

    public static String[] CaptureProduct(int category) {
        /* 
            save the product 
            loop through the questions and save the answer in a  string 
            then takes the string and saves it to the products array
            and the if statements based on the conditions that is in the assignment 
            if they enter anything other then 1 for warrenty then its 2 years if not then its 6 months
            if they enter a price I made a totalCost variable and then I add it there 
            when I enter a new product I save the costs and the data entered. 
         */
        writeMessage("Product Category: " + category);
        String[] categoryAnswers = new String[categoryQuestionnaire.length];
        for (int i = 0; i < categoryQuestionnaire.length; i++) {
            writeMessage(categoryQuestionnaire[i]);
            var output = readInput().next();
            if (i == 0) {
                if (output.equals("1")) {
                    singleTemp += resultsOutput[i + 3] + " 6 Months" + "\n";
                    categoryAnswers[i] = categoryQuestionnaire[i] + " 6 Months";
                } else {
                    singleTemp += resultsOutput[i + 3] + " 2 Years" + "\n";
                    categoryAnswers[i] = categoryQuestionnaire[i] + " 2 Years";
                }
            } else {
                if (i == 1) {
                    totalCost += Long.parseLong(output);
                }
                singleTemp += resultsOutput[i + 3] + " " + output + "\n";
                categoryAnswers[i] = categoryQuestionnaire[i] + " " + output;
            }
        }
        writeMessage("Product details has been saved successfully!!!");
        writeMessage("***********************************************");
        writeMessage("Product Saved Review");
        writeMessage("***********************************************");
        productsList.add(singleTemp);

        writeMessage(singleTemp);
        writeMessage("***********************************************");

        
        singleTemp = "";

        return categoryAnswers;
    }

    public static void writeMessage(String message) {
        /* 
            common method that we use to display output
         */
        System.out.println(message);
    }

    public static Scanner readInput() {
        /* 
            common method that we use to read input
         */
        Scanner input = new Scanner(System.in);
        return input;
    }

    public static String SearchProduct() {
        /* 
            Search the list based on what the product is searched for and prints it out 
         */
        if (!productsList.isEmpty()) {
            writeMessage("Please enter the product code to search:");
            var output = readInput().next();
            if (results(output) == -1) {
                return "There is no product with that code.";
            } else {
                String results = "**********************************\n";
                results += "PRODUCT SEARCH RESULTS\n";
                results += "**********************************\n";
                results += productsList.get(results(output));
                results += "**********************************\n";
                return results;
            }
        }
        return "There is no products to print.";
    }

    public static int results(String output) {
        /* 
            global search based on the input that the user enters instead of writing the code 
            1 million times rather have this method then I can actually get the index and there after 
            I can get the index of the product list.
         */
        for (int i = 0; i < productsList.size(); i++) {
            String x = productsList.get(i);
            if (x.contains("PRODUCTS CODE:  " + output)) {
                return productsList.indexOf(x);
            }
        }
        return -1;
    }

    public static int DeleteProduct() {
        // delete based on the product code we search for 
        if (!productsList.isEmpty()) {
            writeMessage("Please enter the product code that you would like to update:");
            var output = readInput().next();
            return results(output);
        }

        return -1;
    }

    public static String UpdateProduct() {
        /*
            You need to updatge the list so we have to search for the item there after we search then we need to split the string because we know 
            how we saved the data. We manipulate the data based on what we know how we saved thedata 
            we split the array and then we replace the while array with the new data so then we delete the element thats been updated 
            then we take that element and add it back in the array 
      
         */
        if (!productsList.isEmpty()) {
            writeMessage("Please enter the product code that you would like to update:");
            var output = readInput().next();
            int index = results(output);
            String[] results = new String[]{};
            results = productsList.get(index).split("\n");

            for (int i = 0; i < updateProductsQuestionnaire.length; i++) {
                writeMessage(updateProductsQuestionnaire[i]);
                var response = readInput().next();
                if ("y".equals(response)) {
                    writeMessage(updateProductData[i]);
                    var nestedResponse = readInput().next();
                    if (i == 0) {
                        if (nestedResponse.equals("1")) {
                            results[i + 3] = resultsOutput[i + 3] + " 6 Months";

                        } else {
                            results[i + 3] = resultsOutput[i + 3] + " 2 years";

                        }
                    } else {
                        if (i == 1) {
                            totalCost += Long.parseLong(nestedResponse);
                        }
                        results[i + 3] = resultsOutput[i + 3] + " " + nestedResponse;

                    }
                } else if ("n".equals(response)) {

                } else {

                }

            }
            var finalResults = "";
            for (int i = 0; i < results.length; i++) {
                finalResults += results[i] + "\n";
            }
            productsList.remove(index);
            productsList.add(finalResults);
            writeMessage("-----------------------------\n");
            writeMessage(finalResults);
            writeMessage("-----------------------------\n");
            writeMessage("Your record has been successfully updated");
            return finalResults;
        }
        return "There is no products";
    }
// This methode instatiates the reportdata class to get the print out of the data.

    public static String printReport() {
        ReportData rd = new ReportData();
        return rd.printReport(totalCost, productsList);

    }
    public void ExitApplication(){ 
        System.exit(0);
    }
}