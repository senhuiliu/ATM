/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Huige1
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class ATM extends JFrame {
   private JPasswordField passwordField;
   final String CorrectPin = "1234";
   public int count;

   public ATM() {
       JFrame frame = new JFrame("ATM PIN AUTHENTICATION.");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new BorderLayout());
       // adds buttons to the frame
       JPanel j = new JPanel();
       j.setBackground(Color.GRAY);

       passwordField = new JPasswordField(10);
       passwordField.setActionCommand("ENTER");

       // FlowLayout experimentLayout = new FlowLayout();
       j.setLayout(new GridLayout(5, 4));
       JButton b1 = new JButton("1");
       JButton b2 = new JButton("2");
       JButton b3 = new JButton("3");
       JButton b4 = new JButton("4");
       JButton b5 = new JButton("5");
       JButton b6 = new JButton("6");
       JButton b7 = new JButton("7");
       JButton b8 = new JButton("8");
       JButton b9 = new JButton("9");
       JButton b0 = new JButton("0");
       JButton Enterbtn = new JButton("ENTER");
       // Enterbtn.setActionCommand("ENTER");
       JButton Clearbtn = new JButton("CLEAR");
       // Clearbtn.setActionCommand("CLEAR");
       b1.addActionListener(new Buttonaction());
       b2.addActionListener(new Buttonaction());
       b3.addActionListener(new Buttonaction());
       b4.addActionListener(new Buttonaction());
       b5.addActionListener(new Buttonaction());
       b6.addActionListener(new Buttonaction());
       b7.addActionListener(new Buttonaction());
       b8.addActionListener(new Buttonaction());
       b9.addActionListener(new Buttonaction());
       b0.addActionListener(new Buttonaction());
       Enterbtn.addActionListener(new EnterAction());
       Clearbtn.addActionListener(new ClearAction());
       j.add(b1);
       j.add(b2);
       j.add(b3);
       j.add(b4);
       j.add(b5);
       j.add(b6);
       j.add(b7);
       j.add(b8);
       j.add(b9);
       j.add(b0);
       j.add(Enterbtn);
       j.add(Clearbtn);
       frame.add(j, BorderLayout.SOUTH);
       frame.add(passwordField, BorderLayout.NORTH);
      
       frame.setSize(800, 600);
       frame.pack();
       // setContentPane(frame);
       frame.setVisible(true);

   }
//internal listener class buttonaction
   private class Buttonaction implements ActionListener {

       @Override
       public void actionPerformed(ActionEvent e) {
           String action = e.getActionCommand();

           char[] str = passwordField.getPassword();
           String str1 = String.valueOf(str);
           str1 += action;
           passwordField.setText(str1);

       }

   }
   //internal listener class Clearaction
   private class ClearAction implements ActionListener {

       @Override
       public void actionPerformed(ActionEvent arg0) {
           passwordField.setText("");
       }

   }
   //internal listener class Enteraction
   private class EnterAction implements ActionListener {

       @Override
       public void actionPerformed(ActionEvent arg0) {
           char[] a = passwordField.getPassword();
           String value = String.valueOf(a);
           if (CorrectPin.equals(value)) {

               JOptionPane.showMessageDialog(null, "Welcome customer");
           } else {
               count++;
               if(count>3)
               {
                   JOptionPane.showMessageDialog(null, "contact administrator your card is blocked");
      
               }
               //masking the input password in the input dialogue
               Object[] ob = { passwordField };
               int rlt = JOptionPane.showConfirmDialog(null, ob,
                       "Please re-enter correct password",
                       JOptionPane.OK_CANCEL_OPTION);
               if (rlt == JOptionPane.OK_OPTION) {
                   char[] pwd = passwordField.getPassword();
              
                   String val = String.valueOf(pwd);
                   passwordField.setText("");
                   passwordField.setText(val);
               }

           }
       }

   }

   public static void main(String args[]) {
  
       ATM atm = new ATM();
   }

}
