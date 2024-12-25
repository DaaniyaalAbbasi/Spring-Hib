package springhib;

import java.util.Properties;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spr.dao.MilkManDAO;
import spr.hib.MilkMan;

public class SpringHIB {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/SpringXMLConfig.xml");
        MilkManDAO dao = (MilkManDAO)context.getBean("technosoft");
        Scanner scanner = new Scanner(System.in);
        Properties prop = System.getProperties();
        
        System.out.println("======SELECT USER======");
        System.out.println("1. Admin\n 2.Operator\n 3.Exit");
        String level=scanner.nextLine();
        
        if (level.equalsIgnoreCase("Admin")){
            System.out.println("Please enter ID and PASSWORD to load the menu");
            String id= scanner.next();
            String password= scanner.next();
            if (dao.checkVerification(id, password)){
                System.out.println("======INDEX======");
                System.out.println("1. Insert");
                System.out.println("2. Delete Record ");
                System.out.println("3. Update Record");
                System.out.println("4. Search Record");
                System.out.println("5. Show All Record");
                System.out.println("6. Exit");

                switch(scanner.nextInt()){
                    case 1:
                        System.out.println("Enter the name of the milkman");
                        String name=scanner.next();
                        System.out.println("Enter contact number");
                        long contactNo=scanner.nextLong();
                        System.out.println("Enter the address");
                        String address=scanner.next();
                        System.out.println("Enter the price");
                        float price=scanner.nextFloat();
                        System.out.println("Enter the age");
                        int age=scanner.nextInt();
                        MilkMan milkMan= new MilkMan(name, contactNo, address, price, age);
                        dao.insertRecord(milkMan);
                        break;
                    case 2:
                        System.out.println("Enter contact number");
                        contactNo=scanner.nextLong();
                        dao.deleteRecord(contactNo);
                        break;
                    case 3:
                        System.out.println("Enter contact number");
                        contactNo=scanner.nextLong();
                        dao.updateRecord(contactNo);
                        break;
                    case 4:
                        System.out.println("Enter contact number");
                        contactNo=scanner.nextLong();
                        dao.searchRecord(contactNo);
                        break;
                    case 5:
                        dao.showAllRecord();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            }
            else{
                System.out.println("Invalid ID/PASSWORD");
            }
        }
        else if (level.equalsIgnoreCase("Operator")){
            System.out.println("Dashboard under construction.");
        }
    }
}