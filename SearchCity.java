package search.city;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;



public class SearchCity {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        //creating session object  
	Session session=factory.openSession();  
 


        String csvFile = "E:\\University\\Semester 6\\Software Construction\\Labs\\Lab 5\\GeoLiteCity-Location.csv";
        String line;
        String commaSeparater = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] country = line.split(commaSeparater);
                int id = Integer.parseInt(country[0]);
                double latitude = Double.parseDouble(country[5]);
                double longitude = Double.parseDouble(country[6]);
                
                Transaction t=session.beginTransaction();  
                City e1=new City();  
                e1.setId(id);  
                e1.setCountry(country[1]);  
                e1.setLongitude(longitude);
                e1.setLatitude(latitude);
                session.persist(e1);//persisting the object  
                t.commit();//transaction is commited  
		
                /**System.out.println(country[0]);
                System.out.print(country[1]);
                System.out.println(country[2]);
                System.out.println(country[3]);
                System.out.println(country[4]);
                System.out.println(country[5]);
                System.out.println(country[6]);
                **/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        session.close();
    }
}
