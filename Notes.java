import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Notes {
   static String hed="";
    static String cont="";

    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setLayout(null);
        frame.setSize(600,900);
        JLabel head= new JLabel("Notes!");
        head.setBounds(100,0,100,40);
        head.setFont(new Font("Verdana",Font.BOLD,20));
        frame.add(head);

        JTextField hd= new JTextField();
        hd.setBounds(0,50,300,35);
        frame.add(hd);

        JTextField data= new JTextField();
        data.setBounds(0,90,580,300);
        frame.add(data);

        JButton submit= new JButton("submit");
        submit.setBounds(0,400,80,30);
        frame.add(submit);

        JLabel res= new JLabel();
        res.setBounds(0,450,580,200);
        frame.add(res);

        ActionListener action= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             hed= hd.getText();
             cont=data.getText();
try{


                File fl= new File("MyNotes.txt");
                if(fl.createNewFile()){
                    System.out.println("file created");
                }

    FileWriter writer= new FileWriter("MyNotes.txt",true);
                writer.write(hed+"\n"+cont+".\n");
                writer.close();
    System.out.println("done");

            }catch (Exception f){
    System.out.println(f);
            }}
        };
submit.addActionListener(action);

JButton show= new JButton("show");
        show.setBounds(80,400,60,30);
frame.add(show);
ActionListener showact= new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      try{
          FileReader read= new FileReader("MyNotes.txt");
          Scanner sc= new Scanner(read);
          String rd= "";
          while(sc.hasNextLine()){
              rd=sc.nextLine();
          }
          res.setText(rd);


      }catch (Exception g){
          System.out.println(g);
      }
    }
};
show.addActionListener(showact);










        frame.setVisible(true);
    }
}
