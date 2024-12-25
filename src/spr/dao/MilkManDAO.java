package spr.dao;

import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import spr.hib.MilkMan;
import spr.hib.User;

public class MilkManDAO implements Comparable<Object> {
    private HibernateTemplate template;
    private Scanner scanner = new Scanner(System.in);

    
    public MilkManDAO() {
    }

    public MilkManDAO(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        return template + "";
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public HibernateTemplate getTemplate() {
        return template;
    }
    
    public boolean checkVerification(String userId, String password){
        List<User> list = template.find("from User where userId=? and password=?",userId,password);
        if(list.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void insertRecord(spr.hib.MilkMan milkMan){
        //        template.save(milkMan);
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(Session sn)throws HibernateException,SQLException{
                sn.save(milkMan);
                return null;
            }
        });
    }

    public void deleteRecord(long contactNo){
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(Session sn)throws HibernateException,SQLException{
                MilkMan milkMan = (MilkMan)sn.get(MilkMan.class, contactNo);
                if(milkMan==null){
                    out.println("No record found to Delete");
                }
                else{
                    sn.delete(milkMan);
                }
                return null;
            }
        });
    }
    public void updateRecord(long contactNo){
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(Session sn) throws HibernateException, SQLException {
                MilkMan milkMan = (MilkMan)sn.get(MilkMan.class, contactNo);
                if(milkMan==null){
                    out.println("No record found to Update");
                }
                else{
                    System.out.println("Choose which Field to Update");
                    System.out.println("1.Name");
                    System.out.println("2.ContactNo");
                    System.out.println("3.Address");
                    System.out.println("4.Price");
                    System.out.println("5.Age");
                    System.out.println("6.Exit");
                    
                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println("Enter Updated Name :");
                            String uName = scanner.next();
                            milkMan.setName(uName);
                            sn.update(milkMan);
                            break;
                        
                        case 2:
                            System.out.println("Enter Updated Contact No:");
                            long ucontactNo = scanner.nextLong();
                            milkMan.setContactNo(ucontactNo);
                            sn.update(milkMan);
                            break;
                        
                        case 3:
                            System.out.println("Enter Updated Address:");
                            String uAddress = scanner.next();
                            milkMan.setAddress(uAddress);
                            sn.update(milkMan);
                            break;
                        
                        case 4:
                            System.out.println("Enter Updated Price :");
                            float uPrice = scanner.nextFloat();
                            milkMan.setPrice(uPrice);
                            sn.update(milkMan);
                            break;
                        case 5:
                            System.out.println("Enter Updated Price :");
                            int uAge = scanner.nextInt();
                            milkMan.setAge(uAge);
                            sn.update(milkMan);
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.out.println("INVALID choice");
                    }
                }
                return null;
            }
        });
    }
    
    public void searchRecord(long contactNo){
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(Session sn) throws HibernateException, SQLException {
                MilkMan milkMan = (MilkMan)sn.get(MilkMan.class, contactNo);
                if(milkMan==null){
                    out.println("No record found to Delete");
                }
                else{
                    System.out.println(milkMan);  
                }
                return null;
            }
        });
    }
    
    public void showAllRecord(){
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(Session sn) throws HibernateException, SQLException {
                Criteria crit = sn.createCriteria(MilkMan.class);
                List<MilkMan> list = crit.list();
                if(list.isEmpty()){
                    System.out.println("No Reord Found");
                }
                else{
                    for(MilkMan data:list){
                        System.out.println(data);
                    }
                }
                return null;
            }
        });
    }
 
    
}