
package com.mycompany.assignment_1_question_1_extremeproducts;
import java.util.ArrayList;

public class ReportData {
        public String printReport(long totalCost, ArrayList<String>productsList) {
        if (!productsList.isEmpty()) {
            var response = "PRODUCT REPORT \n";
            response += "===============================\n";
            for (int i = 0; i < productsList.size(); i++) {
                response += "PRODUCT " + (i + 1) + "\n";
                response += "-----------------------------\n";
                response += productsList.get(i);
                response += "-----------------------------\n";
            }
            response += "===============================\n";
            response += "TOTAL PRODUCT COUNT: " + productsList.size() + "\n";
            response += "TOTAL PRODUCT VALUE: R " + totalCost + "\n";
            response += "AVERAGE PRODUCT VALUE: R " + (totalCost / productsList.size()) + "\n";
            response += "===============================\n";
            return response;
        }
        return "There is no products";

    }
}
