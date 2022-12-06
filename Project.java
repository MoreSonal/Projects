//Q. Write java program to implement CRUD application with MySQL database.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Project {
public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/product","root","root");
PreparedStatement st = con.prepareStatement("insert into cars values(?,?,?,?,?,?,?,?)");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Scanner sc=new Scanner(System.in);
char ans;
do
{
System.out.println("1:Display Vehicle");
System.out.println("2:Insert Vehicle");
System.out.println("3:Update Vehicle");
System.out.println("4:Delete Vehicle");
System.out.println("5:Exit");
System.out.println("Enter your choice number");
int ch = Integer.parseInt(br.readLine());
String address;
int Price;
int Mileage;
String name, Fuel_Type;
int Sr_No;
String Brand = null;
String Model;
int Seats;
int Engine;
switch(ch)
{
case 1:
System.out.println("Display operation:");
ResultSet rs=st.executeQuery("select*from cars");
while(rs.next())
{
System.out.println(rs.getInt("Sr_No")+"\t"+rs.getString("Brand")+"\t "+rs.getString("Model")+"\t"+rs.getInt("Price")+"\t "+rs.getString("Mileage")+"\t"+rs.getString("Fuel_Type")+rs.getInt("Seats")+"\t "+rs.getInt("Engine")+"\t ");
}
break;
case 2:
System.out.println("Insert operation:");
System.out.println("How many vehicles you want to insert?");
int n=Integer.parseInt(br.readLine());
for(int i=0;i<n;i++)
{
System.out.println("Enter Sr_No");
Sr_No = Integer.parseInt(br.readLine());
System.out.println("Enter Brand");
Brand= br.readLine();
System.out.println("Enter Model");
Model = br.readLine();
System.out.println("Enter Price");
Price = Integer.parseInt(br.readLine());
System.out.println("Enter Mileage");
Mileage = Integer.parseInt(br.readLine());
System.out.println("Enter Fuel_Type");
Fuel_Type = br.readLine();
System.out.println("Enter Seats");
Seats = Integer.parseInt(br.readLine());
System.out.println("Enter Engine");
Engine = Integer.parseInt(br.readLine());
st.setInt(1, Sr_No);
st.setString(2, Brand);
st.setString(3, Model);
st.setInt(4, Price);
st.setInt(5, Mileage);
st.setString(6, Fuel_Type);
st.setInt(7, Seats);
st.setInt(8, Engine);
st.executeUpdate();
System.out.println("Data is inserted successfully!!!");
System.out.println("THANK YOU");
}	
break;
case 3:
System.out.println("Update Vehicle:");
System.out.println("Enter the Sr_No which you want to update");
Sr_No = Integer.parseInt(br.readLine());
System.out.println("What do you want to update?");
System.out.println("\n 1.Brand \n 2.Model \n 3.Price \n 4.Mileage\n 5.Fuel_Type \n 7.Seats\n 8.Engine \n 9.Exit ");
System.out.println("Enter option for update : ");
int ch11=Integer.parseInt(br.readLine());
switch(ch11)
{
case 1:System.out.println("Enter Brand for update");
st.executeUpdate("update Cars set Brand='"+Brand+"' where Sr_No="+Sr_No);
Brand=br.readLine();
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;
case 2:System.out.println("Enter Model for update");	
Model = br.readLine();
st.executeUpdate("update Cars set  Model='"+Model+"' where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;
case 3:System.out.println("Enter Price for update");
Price = Integer.parseInt(br.readLine());
st.executeUpdate("update Cars set  Price='"+Price+"' where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;
case 4:System.out.println("Enter Mileage for update");
Mileage = Integer.parseInt(br.readLine());
st.executeUpdate("update Cars set  Mileage='"+Mileage+"' where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;
case 5:System.out.println("enter Fuel_Type for update");	
Fuel_Type = br.readLine();
st.executeUpdate("update Cars set  Fuel_Type='"+Fuel_Type+"' where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;
case 6:System.out.println("enter Seats for update");	
Seats = Integer.parseInt(br.readLine());
st.executeUpdate("update Cars set  Seats='"+Seats+"' where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;	
case 7:System.out.println("enter Engine for update");	
Engine = Integer.parseInt(br.readLine());
st.executeUpdate("update Cars set  Engine='"+Engine+"' where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN UPDATED SUCCESSFULLY!!");
break;	
case 8:
System.out.println("Exit");
break;		
default:System.out.println("Invalid choice");		
}
break;
case 4:
System.out.println("Delete Vehicle:");
System.out.println("Enter the Sr_No which you want to delete ");
Sr_No = Integer.parseInt(br.readLine());
st.executeUpdate("delete from Cars where Sr_No="+Sr_No);
System.out.println("THE DATA HAS BEEN DELETED SUCCESSFULLY !!");
break;
case 5:
System.out.println("exit");
break;
default:
System.out.println("Invalid choice");
break;
}		
System.out.println("Do you want to try again ? y/n");
ans=sc.next().charAt(0);
}
while(ans=='y'||ans=='Y');
System.out.println("Thank You!");
con.close();	
}
}

/*First output:
 

Output to insert vehicle data:
 
 
Output to update data:
 
Output to delete data:
 
Exit:
 
*/
