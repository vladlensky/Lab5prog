package Lab5;
public class SecretS extends Secret implements Comparable{
    public SecretS(){
        thing = null;
        giver = null;
    }
    public SecretS(String T,String G){
        thing = T;
        giver = G;
    }
    public SecretS(String T,String G,int s,int w) {
        thing = T;
        giver = G;
        size = s;
        weight = w;
    }
    public void SetWeightAndSize(int w,int s){weight = w;size = s;}
    public SecretS(String T){
        thing = T;
    }
    public String OpenSecret()
    {
        return thing;
    }
    public String GetGiver() {return giver;}
    public int GetWeight(){return weight;}
    public int GetSize(){return size;}
    public String OpenSecret(String opener)
    {
        System.out.println(opener + " открывает подарок! ");
        if(giver == null){
            return thing;
        }
        else{
            return thing + " подарил(а) " + giver;
        }
    }
    public String OpenSecret(String opener,int n)
    {
        System.out.println(opener + " открывает " + n + " подарок! ");
        if(giver == null){
            return thing;
        }
        else{
            return thing + " подарил(а) " + giver;
        }
    }
    public int compareTo(Object s){
        SecretS compare = (SecretS)s;
        if(thing == null && compare.OpenSecret()!=null)
            return -1;
        if(thing != null && compare.OpenSecret()==null)
            return 1;
        if(thing == null && compare.OpenSecret()==null)
            return weight*size - compare.weight*compare.size;
        int result = thing.compareTo(compare.OpenSecret());
        if(result != 0)
            return result;
        result = weight*size - compare.weight*size;
        if(result == 0)
            return 0;
        return  result / Math.abs( result );
    }
    public void SetSecret(String s)
    {
        thing = s;
    }
    public void SetGiver(String g)
    {
        giver = g;
    }
    public String toString()
    {
        return  OpenSecret();
    }
}
