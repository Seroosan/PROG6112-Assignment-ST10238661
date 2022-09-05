package com.mycompany.assignment_1_question_1_extremeproducts;

public class Assignment_1_Question_1_ExtremeProducts {

    public static void main(String[] args) {
        Product pd = new Product();
        pd.writeMessage("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        pd.writeMessage("**************************************");
        int exitInput = pd.showExitMenu();
        pd.showProductSelection(exitInput);
        
    

    }
    /*
        This is the main method if I get the input then I can see if its between
        1-6, There after an input is recieved. then there is actions that are taken 
        based on that 
     */
}