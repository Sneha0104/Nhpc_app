package com.example.snehasaj.nhpcapp;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DataQ {
    String filename = "username_password.txt";
    //String driverName = "com.mysql.jdbc.Driver";
    static String driverName = "oracle.jdbc.driver.OracleDriver";
    static String serverName;
    // String serverName = "localhost";
    static String portNumber;
    // String sid = "xe";
    static String sid;
    static String uri;
    //String uri = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
    static String username;
    static String password;
    int count = 4;
    //FileReader in = null;
    DataQ() {
        System.out.println(filename);
        File usernameFile = new File(filename);
        try {
      //      in = new FileReader("username_password.txt");
            BufferedReader br = new BufferedReader(new FileReader(usernameFile));

            String line = br.readLine();
            System.out.println(line);
            while (line.startsWith("#")) {
                line = br.readLine();

            }
            System.out.println(line);

            String[] buff = line.split(":");
            serverName = buff[0];
            portNumber = buff[1];
            sid = buff[2];
            username = buff[3];
            password = buff[4];
            System.out.println(username);
            //changed
            uri = "jdbc:oracle:thin:@" + serverName + ":" + 1521 + ":" + sid;
            System.out.println(uri);
        } catch (Exception e) {
            System.out.println("file issue in daaaaaaaaaaaateQ");
        }

    }


   
    public String Get_Authentication_for_NHPC_APPS(String user_id,String password1) {

        String result = new String();

        try{
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-9C05BA2N:1521:XE", user_id, password1);
            result="S";
            System.out.println("Success");
            conn.close();
        }
        catch(Exception e)
        {
            result="E";
            System.out.println(e);
        }
        if(result.equalsIgnoreCase("E"))
        {
            try{
                Class.forName(driverName);
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-9C05BA2N:1521:XE", user_id, password1);
                result="S";
                System.out.println("Success");
                conn.close();
            }
            catch(Exception e)
            {
                result="E";
                System.out.println(e);
                System.out.println("failllllll");
            }
        }
        if(result.equalsIgnoreCase("E")) result="E:Could not connect to Database";
        return result;
    }



    public String ValidateLogin(String Username, String pwd , String deptId) {
        String result = new String();
        try {

            Class.forName(driverName);
            //Connection conn = DriverManager.getConnection(uri, username, password);
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-9C05BA2N:1521:XE", "nhpcapp", "apple1234");
            Statement stmt = conn.createStatement();
            String sql = "select user_name, password from users where USER_NAME= '" + Username + " '" +"AND '"+ "password = '" + pwd+"'"+"DepID = '"+deptId+"'";
            System.out.println("heloo");
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.getString("user_name") == Username && rs.getString("password")== pwd && rs.getString("DepID")==deptId)
            {
                result =  "Y";

            }
            else
                result =  "N";

            } catch (Exception e) {
            System.out.println("error in daaaaaaaaaaaaaaaa"+e);
            return  "Invalid User Name or Password or deptID";
                                }

        return result;
    }
}
