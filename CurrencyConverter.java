import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Converter{
   void conv(){
       JFrame frame= new JFrame("currency converter");
       frame.setLayout(null);
       frame.setSize(250,250);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setBackground(Color.BLUE);

       JLabel l2= new JLabel("currency converter");
       l2.setBounds(30,0,150,30);
       l2.setForeground(Color.red);
       frame.add(l2);


       JTextField f1= new JTextField();
       f1.setBounds(0,30,60,30);
       frame.add(f1);
       JLabel l1= new JLabel("=");
       l1.setBounds(70,30,40,30);
       frame.add(l1);
       JTextField f2= new JTextField();
       f2.setBounds(90,30,140,30);
       frame.add(f2);
//       JButton usd= new JButton("$");
//       usd.setBounds(0,40,50,30);
//       frame.add(usd);
//       JButton pound= new JButton("£");
//       pound.setBounds(50,40,50,30);
//       frame.add(pound);
//       JButton yen= new JButton("¥");
//       yen.setBounds(100,40,50,30);
//       frame.add(yen);



       ButtonGroup bg= new ButtonGroup();

       JRadioButton usd= new JRadioButton("₹->$");
       usd.setBounds(0,70,80,30);
       frame.add(usd);
       bg.add(usd);

       JRadioButton pound= new JRadioButton("₹->£");
       pound.setBounds(0,100,80,30);
       frame.add(pound);
       bg.add(pound);

       JRadioButton yen= new JRadioButton("₹->¥");
       yen.setBounds(0,130,80,30);
       frame.add(yen);
       bg.add(yen);






       ActionListener act_usd= new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String a= f1.getText();
               double x=Double.parseDouble(a);
               double y= x/80;
               String c=String.valueOf(y);
               f2.setText(c);

           }
       };
       ActionListener act_pound= new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String a= f1.getText();
               double x=Double.parseDouble(a);
               double y= x/101;
               String c=String.valueOf(y);
               f2.setText(c);

           }
       };

       ActionListener act_yen= new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String a= f1.getText();
               double x=Double.parseDouble(a);
               double y= x*1.59;
               String c=String.valueOf(y);
               f2.setText(c);

           }
       };


       usd.addActionListener(act_usd);
       pound.addActionListener(act_pound);
       yen.addActionListener(act_yen);






       frame.setVisible(true);

    }
}


public class CurrencyConverter {
    public static void main(String[] args) {
        Converter c= new Converter();
        c.conv();

    }
}
