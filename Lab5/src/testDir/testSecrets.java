package testDir;
import static org.junit.Assert.*;
import org.junit.*;
import Lab5.SecretS;
import Lab5.*;
/**
 * Created by bespa on 11.04.2017.
 */
public class testSecrets {
    SecretS sec;
    @Before
    public void set(){
        sec = new SecretS("Box","Roma Kaban",150,150);
    }
    @Test
    public void testComp() {
        if(sec.compareTo(new SecretS("Box","Roma Kaban",150,150))!=0)
            fail("Ошибка в сравнении");
    }
    @Test
    public void testCthing() {
        if(!sec.OpenSecret().equals("Box"))
            fail("Ошибка в создании thing");
    }
    @Test
    public void testCgiver() {
        if(!sec.GetGiver().equals("Roma Kaban"))
            fail("Ошибка в создании giver");
    }
    @Test
    public void testCsize() {
        if(sec.GetSize()!=150)
            fail("Ошибка в создании size");
    }
    @Test
    public void testCweight() {
        if(sec.GetWeight()!=150)
            fail("Ошибка в создании weight");
    }
    @Test
    public void testSetWS(){
        sec.SetWeightAndSize(15,15);
        if(sec.GetWeight()!=15||sec.GetSize()!=15)
            fail("Ошибка в методе SetWeightAndSize");
    }
    @Test
    public void testOpenSecretWithOpener(){
        if(!sec.OpenSecret("Vasya").equals("Box подарил(а) Roma Kaban"))
            fail("Ошибка в методе OpenSecret(Opener)");
    }
    @Test
    public void testOpenSecretWithOpenerAndNumber(){
        if(!sec.OpenSecret("Vasya",5).equals("Box подарил(а) Roma Kaban"))
            fail("Ошибка в методе OpenSecret(Opener,number)");
    }
    @Test
    public void testGiver(){
        if(!sec.GetGiver().equals("Roma Kaban"))
            fail("Ошибка при получении giver'a");
    }
    @Test
    public void testPod(){
        if(!sec.OpenSecret().equals("Box"))
            fail("Ошибка при открытии подарка!");
    }
    @Test
    public void testSetGiver(){
        sec.SetGiver("Roma");
        if(sec.GetGiver()!="Roma")
            fail("Ошибка при установке родителя!");
    }
    @Test
    public void testSetThing(){
        sec.SetSecret("Roma");
        if(!sec.OpenSecret().equals("Roma"))
            fail("Ошибка при установке подарка!");
    }
    @Test
    public void testSetHW(){
        sec.SetWeightAndSize(10,10);
        if(sec.GetWeight()!=10||10!=sec.GetSize())
            fail("Ошибка при установке веса или размера!");
    }
    @Test
    public void testToString(){
        if(sec.OpenSecret()!= sec.toString())
            fail("Ошибка при переводе объекта в строку!");
    }

    @Test
    public void testEquals(){
        if(sec.equals(new SecretS("Box","Roma Kaban",150,150)))
            fail("Ошибка при сравнении!");
    }
}
