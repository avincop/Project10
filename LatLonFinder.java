import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class Search{
   static String city;
   static String state;
   static String lati;
   static String longi;
    void find(){
        // Scanner sc= new Scanner(System.in);
        //city= sc.nextLine();
        JFrame fm1= new JFrame("Status");
        fm1.setSize(300,350);
        fm1.setLayout(null);
        JLabel lb= new JLabel("for Lang & Lat plz enter!");
        lb.setBounds(20,00,300,30);
        fm1.add(lb);
        JLabel cit= new JLabel("city name");
        cit.setBounds(0,50,100,30);
        fm1.add(cit);
        JLabel box= new JLabel();
        box.setBounds(70,50,120,30);
        JTextField fl= new JTextField();
        fl.setBounds(0,0,150,30);
        box.add(fl);

        JLabel stt= new JLabel("state name");
        stt.setBounds(0,90,100,30);
        fm1.add(stt);
        JTextField fl1= new JTextField();
        fl1.setBounds(70,90,150,30);
       fm1.add(fl1);



        fm1.add(box);

        JButton bt1= new JButton("submit");
        bt1.setBounds(70,150,90,30);
        fm1.add(bt1);

        JTextArea res= new JTextArea();
        res.setBounds(10,200,200,60);
        fm1.add(res);






        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city = fl.getText();
                state=fl1.getText();
                try {
                    URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+","+state+",IN&limit=1&appid=a021e43ac1f97ad82ceb29693d4f7403");
                    HttpURLConnection dat = (HttpURLConnection) url.openConnection();
                    dat.setRequestMethod("GET");

                    InputStreamReader in = new InputStreamReader(dat.getInputStream());
                    BufferedReader in1 = new BufferedReader(in);

                    String st = "";
                    while (st != null) {
                        st = in1.readLine();
                        //System.out.println(st);
                        in.close();
                        JSONParser par = new JSONParser();
                        JSONArray array = (JSONArray) par.parse(st);
                        JSONObject obj = (JSONObject) array.get(0);
                        System.out.println(obj.get("lat"));
                        System.out.println(obj.get("lon"));
                        Object lt=obj.get("lat");
                        String st1= lt.toString();
                        System.out.println(st1);
                        Object ln=obj.get("lon");
                        String st2= ln.toString();
                        System.out.println(st2);
                       // Double d= (Double) ln;

                        res.setText("latitude is:-"+st1+"\n"+"longitude is:-"+st2);

                    }
                } catch (Exception t) {
                    System.out.println(t);
                }
            }

        };
        bt1.addActionListener(action);

        fm1.setVisible(true);}

    }


public class LatLonFinder {

    public static void main(String[] args) {

Search s= new Search();
s.find();






    }
}