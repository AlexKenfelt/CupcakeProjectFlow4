package business.entities;

public class User
{

    public User(String email, String password, String role, double balance)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }
 
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private double balance;

    public void drawAmount(double amount){
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


}
