import javax.swing.*;
import java.util.Scanner; // newly added import, imports scanner class
import java.awt.Color;    // color class to change color of text that pops up

/**
 * Main class with main method invoked on app start.
 * @version 1.0.0
 * @author Dr. Jody Paul
 */

public class Main {
    
    /** Private constructor to prevent instantiation of entry point class. */
    private Main() { }

    /**
     * Invoked on start.
     * @param args ignored
     */
    public static void main(String[] args) {
        int a = 0;
        while(a < 5 ){
            askUserforInput();
            a = a + 1;
        }
        
        exitMessage();
       

    }
       // function definitions below
         public static void outputBox(String userWord){
                JFrame frame = new JFrame("Wordly");
                JLabel label = new JLabel("Your word: " + userWord 
                                            + " is not 5 letters", SwingConstants.CENTER);

                new Color (32,192,155);
                label.setForeground(new Color(54,15,90)); // color of text
                frame.add(label);
                frame.setSize(400, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
        }

        public static void exitMessage(){

             Scanner myScannerObjtoExit = new Scanner(System.in); //created scanner object
             System.out.println("Would you like to continue Y/N: ");

             String userSelection = myScannerObjtoExit.nextLine();  //save user input as string

                if (userSelection.equals("N")){
                   System.out.println("exiting the wordly program");
                   myScannerObjtoExit.close();
                   System.exit(0);
                }
                else {
                    askUserforInput();
                    exitMessage();
                }
                    
                
                }
        
        public static void askUserforInput(){
                 Scanner myScannerObj = new Scanner(System.in); //created scanner object
                 System.out.println("Enter a five letter word"); //


                 String userWord = myScannerObj.nextLine();  //save user input as string
                 System.out.println("Your word was: " + userWord);

                if(userWord.length() != 5){
                        outputBox(userWord);
                }
        }
    
}
