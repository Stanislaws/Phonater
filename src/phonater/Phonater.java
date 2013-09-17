/*
 *  Phonater - reformats phone numbers in a specific way
 *  Copyright (C) 2013  Jan Zajaczkowski
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package phonater;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Reformats phone numbers in a specific way
 */
public class Phonater extends JFrame{

    private JTextField phone = new JTextField(15);
    
    private JButton fix = new JButton("");

    /**
     * Defines the GUI
     */
    public Phonater (){
        JPanel jp = new JPanel();
        jp.add(phone);
        
        fix.setPreferredSize(new Dimension(20,20));
        
        jp.add(fix);
        add(jp);
          
        phone.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fixNumber();
            }       
        });
        
        fix.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fixNumber();
            }       
        });
    }
    
    /**
     * Defines and applies the reformatting cases
     */
    public void fixNumber(){
        try{
          //Stores the string from the JTextField
          String number = phone.getText();

          //Removes every non number character
          String stripped = number.replaceAll("[^0-9]", "");

          //Stores the formatted number
          String formatted;

          //1 +0, 2 +00, 3 +000
          if(stripped.length() < 4 && (!"".equals(stripped))){
              formatted = "+"   + stripped;
          }
          
          //4 +00 00
          else if(stripped.length() == 4){
              formatted = "+" +   stripped.substring(0, 2) + " "
                              +   stripped.substring(2, 4);
          }
          //5 +00 000
          else if(stripped.length() == 5){
              formatted = "+" +   stripped.substring(0, 2) + " "
                              +   stripped.substring(2, 5);
          }
          
          //6 +00 00 00 
          else if(stripped.length() == 6){
              formatted = "+" +   stripped.substring(0, 2) + " "
                              +   stripped.substring(2, 4) + " "
                              +   stripped.substring(4, 6);
          }          
          
          //7 +00 00 000
          else if(stripped.length() == 7){
              formatted = "+" +   stripped.substring(0, 2) + " "
                              +   stripped.substring(2, 4) + " "
                              +   stripped.substring(4, 7);
          }             
          
          //8 +00 00 0000
          else if(stripped.length() == 8){
              formatted = "+" +   stripped.substring(0, 2) + " "
                              +   stripped.substring(2, 4) + " "
                              +   stripped.substring(4, 8);
          }            
          
          //9 +00 00 00 000
          else if(stripped.length() == 9){
              formatted = "+" +   stripped.substring(0, 2) + " "
                              +   stripped.substring(2, 4) + " "
                              +   stripped.substring(4, 6) + " "
                              +   stripped.substring(6, 9);
          }               
          
          //10 +1 000 000 0000 (US, 10 digit Int'l not supported)
          else if(stripped.length() == 10){
              formatted = "+1 " + stripped.substring(0, 3) + " "
                                + stripped.substring(3, 6) + " "
                                + stripped.substring(6,10);
          }

          //11 +1 000 000 0000 (US)
          else if("1".equals(     stripped.substring(0, 1)) 
                               && stripped.length() == 11){
              formatted = "+"   + stripped.substring(0, 1) + " "
                                + stripped.substring(1, 4) + " "
                                + stripped.substring(4, 7) + " "
                                + stripped.substring(7,11);
          }

          //11 +00 00 000 0000
          else if(stripped.length() == 11) {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 7) + " "
                                + stripped.substring(7,11);
          }

          //12 +00 00 0000 0000
          else if(stripped.length() == 12) {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 8) + " "
                                + stripped.substring(8,12);
          }

          //13 +00 00 000 000 000
          else if(stripped.length() == 13) {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 7) + " "
                                + stripped.substring(7,10) + " "
                                + stripped.substring(10,13);
          }
          
          //14 +00 00 000 000 0000
          else if(stripped.length() == 14) {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 7) + " "
                                + stripped.substring(7,10) + " "
                                + stripped.substring(10,14);
          }  
          
          //15 +00 00 000 0000 0000
          else if(stripped.length() == 15) {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 7) + " "
                                + stripped.substring(7,11) + " "
                                + stripped.substring(11,15);
          }          
          
          //16 +00 00 0000 0000 0000
          else if(stripped.length() == 16) {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 8) + " "
                                + stripped.substring(8,12) + " "
                                + stripped.substring(12,16);
          }               
          
          //17+ will start out like 16 but not bother doing anything more
          else {
              formatted = "+"   + stripped.substring(0, 2) + " "
                                + stripped.substring(2, 4) + " "
                                + stripped.substring(4, 8) + " "
                                + stripped.substring(8,12) + " "
                                + stripped.substring(12,16)+ " "
                                + stripped.substring(16,stripped.length());
          }

          //replace the text with the formatted version
          phone.setText(formatted);

          //request focus to be on the text box
          phone.requestFocus();
          
          //highlight the contents of the text box
          phone.selectAll();

          //transfer the contents of the text box to the clipboard
          phone.copy();
          
        } catch(StringIndexOutOfBoundsException e){ //error when box is empty
            //replace the text with the error message
            phone.setText("Paste the phone number here");
            
            //request focus to be on the text box
            phone.requestFocus();
            
            //highlight the contents of the text box
            phone.selectAll();
        }
        
    }   
    
    /**
     * Creates an instance of the GUI with typical parameters
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        //define f as a new instance of Phonater
        Phonater f = new Phonater();
        
        //place the window in the center of the screen
        f.setLocationRelativeTo(null);
        
        //terminate the program if the closed button is pressed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set the title of the window
        f.setTitle("Phonater");
        
        //resize the window to be the minimum size to fit all UI elements
        f.pack();
        
        //show the window
        f.setVisible(true);  
        
        //set the window to always be on top
        f.setAlwaysOnTop(true);
        
        //disable resize
        f.setResizable(false);
    }
}
