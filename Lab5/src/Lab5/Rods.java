/**
 * Created by bespa on 21.02.2017.
 */
package Lab5;
public class Rods {
    public String name;
    public Rods()
    {
        name  = null;
    }
    public Rods(String n)
    {
        name  = n;
    }
    public String GetName()
    {
        return name;
    }
    public String toString()
    {
        return  GetName();
    }
    public void Eq(Rods a)
    {
        a.name = this.name;
    }
}

