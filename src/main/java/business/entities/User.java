package business.entities;

public class User
{
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private double balance;

    public User(int id, String email, String password, String role, double balance)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public User(String email, String password, String role, double balance)
    {
        this.id = -1;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public User(int id)
    {
        this.id = id;
        this.email = "";
        this.password = "";
        this.role = "";
        this.balance = 0;
    }

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
