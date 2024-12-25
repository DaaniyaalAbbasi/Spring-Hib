package spr.hib;
public class MilkMan {
    private String name;
    private long contactNo;
    private String address;
    private float price;
    private int age;

    @Override
    public String toString() {
        return getName()+" "+getContactNo()+" "+getAddress()+" "+getPrice()+" "+getAge();
    }
    
    public MilkMan() {
    }

    public MilkMan(String name, long contactNo, String address, float price, int age) {
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.price = price;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contactNo
     */
    public long getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    
}
