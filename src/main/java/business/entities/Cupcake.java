package business.entities;

public class Cupcake
{
    private int cupcake_id;
    private String name;

    public Cupcake(int cupcake_id, String name)
    {
        this.cupcake_id = cupcake_id;
        this.name = name;
    }

    public int getCupcake_id()
    {
        return cupcake_id;
    }

    public String getName()
    {
        return name;
    }
}