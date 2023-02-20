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
import java.util.Scanner;

public class WeatherReport{
    static String st1="";
    static String st2="";
    static double d,d1;
    static String  city="";
    static String state="";
    static JTextField fl,fl1;
    static String temp="";
    static String hum="";
    static String vis="";
    static String pre="";

   static  void weather() {

       try {

           try {
               city = fl.getText();
               state = fl1.getText();
               URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + city + "," + state + ",IN&limit=1&appid=a021e43ac1f97ad82ceb29693d4f7403");
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
                   Object lt = obj.get("lat");
//                     st1= lt.toString();
//                    System.out.println(st1);
                   Object ln = obj.get("lon");
//                     st2= ln.toString();
//                    System.out.println(st2);
                   d = (Double) lt;
                   d1 = (Double) ln;


               }
           } catch (Exception t) {
               System.out.println(t);
           }

           URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + d + "&lon=" + d1 + "&limit=1&appid=6a07768660ff2343e9ecbacb198e79f6");
           HttpURLConnection dat = (HttpURLConnection) url.openConnection();
           dat.setRequestMethod("GET");

           InputStreamReader in = new InputStreamReader(dat.getInputStream());
           BufferedReader in1 = new BufferedReader(in);

           String st = "";
           String st1 = "";
           while (st != null) {
               st = in1.readLine();
               st1 = st1 + st;
               // System.out.println(st);
               in.close();

               JSONParser par = new JSONParser();
               JSONObject obj = (JSONObject) par.parse(st1);
               System.out.println(obj.get("main"));
               JSONObject obj1 = (JSONObject) obj.get("main");

                temp = obj1.get("temp").toString();
                hum = obj1.get("humidity").toString();
                pre = obj1.get("pressure").toString();
                vis = obj.get("visibility").toString();
               System.out.println(temp);
               System.out.println(pre);
               System.out.println(hum);
               System.out.println(vis);



           }
       } catch (Exception t) {
           System.out.println(t);
       }

   }

    public static void main(String[] args) {



        JFrame fm1= new JFrame("Status");
        fm1.setSize(300,350);
        fm1.setLayout(null);
        JLabel lb= new JLabel("for weather info plz enter!");
        lb.setBounds(20,00,300,30);
        fm1.add(lb);
        JLabel cit= new JLabel("city name");
        cit.setBounds(0,50,100,30);
        fm1.add(cit);
        JLabel box= new JLabel();
        box.setBounds(70,50,120,30);
         fl= new JTextField();
        fl.setBounds(0,0,150,30);
        box.add(fl);

        JLabel stt= new JLabel("state name");
        stt.setBounds(0,90,100,30);
        fm1.add(stt);
         fl1= new JTextField();
        fl1.setBounds(70,90,150,30);
        fm1.add(fl1);



        fm1.add(box);

        JButton bt1= new JButton("submit");
        bt1.setBounds(70,150,90,30);
        fm1.add(bt1);

        JTextArea res= new JTextArea();
        res.setBounds(10,200,300,300);
        res.setEditable(false);
        fm1.add(res);






        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               weather();
               res.setText("temperature is:"+temp+"\n"+"pressure is:"+pre+"\n"+"humidity is:"+hum+"\n"+"visibility is:"+vis);
            }

        };
        bt1.addActionListener(action);

        fm1.setVisible(true);
    }


}
