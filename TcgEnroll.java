import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

public class TcgEnroll {

    static int a=1;
    public static void main(String[] args) {
        JFrame frame= new JFrame("TCG enroll");
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.lightGray);

        JLabel head = new JLabel("For enrollment in TCG! ");
        head.setBounds(40,10,400,40);
        head.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(head);

        JLabel name= new JLabel("Name:");
        name.setBounds(10,40,60,30);
        frame.add(name);

        JTextField name1= new JTextField();
        name1.setBounds(60,45,100,25);
        frame.add(name1);


        JLabel rank= new JLabel("Rank:");
        rank.setBounds(10,80,60,30);
        frame.add(rank);

        JTextField rank1= new JTextField();
        rank1.setBounds(60,85,100,25);
        frame.add(rank1);

        JLabel domain= new JLabel("Domain:");
        domain.setBounds(10,120,60,30);
        frame.add(domain);

        JTextField domain1= new JTextField();
        domain1.setBounds(60,125,100,25);
        frame.add(domain1);

        JLabel mob= new JLabel("Mob.N:");
        mob.setBounds(10,160,60,30);
        frame.add(mob);

        JTextField mob1= new JTextField();
        mob1.setBounds(60,165,100,25);
        frame.add(mob1);

        JLabel mail= new JLabel("Email:");
        mail.setBounds(10,200,60,30);
        frame.add(mail);

        JTextField mail1= new JTextField();
        mail1.setBounds(60,205,100,25);
        frame.add(mail1);

        JButton enroll= new JButton("Enroll");
        enroll.setBounds(60,240,75,30);
        frame.add(enroll);

        JLabel msg= new JLabel("Congrates! You are successfully enrolled in TCG");
        msg.setBounds(10,270,300,50);



        ActionListener action= new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                JSONObject obj= new JSONObject();
                JSONArray arr= new JSONArray();
                obj.put(name.getText(),name1.getText());
                obj.put(rank.getText(),rank1.getText());
                obj.put(domain.getText(),domain1.getText());
                obj.put(mob.getText(),mob1.getText());
                obj.put(mail.getText(),mail1.getText());
                arr.add(obj);

                try {
                    File nf= new File("tcgdata.json");
                    if(nf.createNewFile()){
                        System.out.println("file created");
                    }
//                    else{
//                        System.out.println("file already exist");
//                    }


                    FileWriter writer= new FileWriter("tcgdata.json",true);
                    writer.write(a+ obj.toJSONString() );
                    writer.close();
                    a++;




                }catch (Exception r){
                    System.out.println(r);
                }












                System.out.println("action");
                frame.add(msg);


            }
        };

        enroll.addActionListener(action);


        frame.setVisible(true);
    }
}
