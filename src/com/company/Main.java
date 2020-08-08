package com.company;
import java.sql.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// write your code here
        // add();
        edit();
        display();
    }

    static void add() throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");

        Scanner key = new Scanner(System.in);
        String catDesc,catCode;
        System.out.print("Please input the Code: ");
        catCode = key.nextLine();

        System.out.print("Please input the Description: ");
        catDesc = key.nextLine();

        query = con1.prepareStatement("Insert into category values (?,?)");
        query.setString(1,catCode);
        query.setString(2,catDesc);
        query.executeUpdate();
        System.out.println("Record Added");
    }

    static void display() throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");


        query = con1.prepareStatement("Select * from category");

        ResultSet rs = query.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("CatCode"));
            System.out.println(rs.getString("CatDesc"));
        }

        System.out.println("Display works");
    }

    static void edit() throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");

        Scanner key = new Scanner(System.in);
        String catDesc,catCode;
        System.out.print("Please input the Code: ");
        catCode = key.nextLine();

        System.out.print("Please input the Description: ");
        catDesc = key.nextLine();
        query = con1.prepareStatement("Update category set CatDesc=? where CatCode=?");
        query.setString(1,catDesc);
        query.setString(2,catCode);
        query.executeUpdate();
        System.out.println("Record Edited");
    }

}
