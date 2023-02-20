import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question_Paper {
    public static void main(String[] args) {


        JFrame f = new JFrame("Java Test");

        f.setBounds(200, 100, 500, 500);
        f.setLayout(null);
        JPanel panel = new JPanel();

        panel.setBounds(0, 0, 480, 480);
        panel.setLayout(null);
        f.add(panel);
        JLabel Title = new JLabel("Java Test");
        Title.setBounds(200, 5, 200, 30);
        Title.setFont(new Font("Arial", Font.ITALIC, 20));
        JLabel que1 = new JLabel();
        JLabel que2= new JLabel();
        JLabel que3 = new JLabel();
        JLabel que4 = new JLabel();
        JLabel que5 = new JLabel();
        JLabel que6 = new JLabel();
        JLabel que7= new JLabel();
        JLabel que8 = new JLabel();
        JLabel que9 = new JLabel();
        JLabel que10 = new JLabel();
        que1.setText("1. Who invented Java Programming? ");
        que1.setBounds(40,50,400,30);
        JRadioButton A=new JRadioButton();
        JRadioButton B=new JRadioButton();
        JRadioButton C=new JRadioButton();
        JRadioButton D=new JRadioButton();
        ButtonGroup bg=new ButtonGroup();
        A.setBounds(40,90,400,30);
        B.setBounds(40,130,400,30);
        C.setBounds(40,170,400,30);
        D.setBounds(40,210,400,30);
        A.setText("Rasssie van Rossum"); B.setText("James Gosling");
        C.setText("Dennis Vitory"); D.setText("Bjarne Frenklin");

        JButton Privious =new JButton("Privious");
        Privious.setBounds(60,300,100,30);

        JButton Next =new JButton("Next");
        Next.setBounds(220,300,100,30);
        bg.add(A);bg.add(B);bg.add(C);bg.add(D);
        panel.add(Title);panel.add(que1);
        panel.add(que1);
        panel.add(que2);
        panel.add(que3);
        panel.add(que4);
        panel.add(que5);
        panel.add(que6);
        panel.add(que7);
        panel.add(que8);
        panel.add(que9);
        panel.add(que10);
        panel.add(A);  panel.add(B);  panel.add(C);  panel.add(D);
        panel.add(Privious); panel.add(Next);
        /// A.setDisabledSelectedIcon((Icon) A);
        f.setVisible(true);

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(C.isSelected()){
                    System.out.println("Correct");
                } else{
                    System.out.println("incorrect");
                }
                que1.setText("2. Number of primitive data types in Java are?");
                A.setText("6");
                B.setText("7");
                C.setText("8");
                D.setText("4");

            }
        }  ; Next.addActionListener(ac);

    }


}
