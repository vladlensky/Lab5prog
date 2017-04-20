package testDir;
import static org.junit.Assert.*;
import Lab5.Rods;
import com.alibaba.fastjson.JSONArray;
import org.junit.*;
import Lab5.SecretS;
import Lab5.Person;
import Lab5.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;


/**
 * Created by bespa on 08.04.2017.
 */
public class testPerson {
    Person chel;
    @Before
    public void set(){
        chel = new Person("Vasya");
    }
    @Test
    public void testComp() {
        if(chel.equals(new Person("Vasya")))
            fail("Ошибка в инициализации");
    }
    @Test
    public void testSetName() {
        chel.SetName("Vitya");
        if(!chel.GetName().equals("Vitya"))
            fail("Ошибка в изменении имени");
    }
    @Test
    public void testSetSecretNull() {
        chel.SetSecret(null);
        if(chel.S.isEmpty())
            fail("Ошибка в добавлении секрета (null)");
    }
    @Test
    public void testSetSecretNullArgument() {
        chel.SetSecret(new SecretS());
        if(chel.S.isEmpty())
            fail("Ошибка в добавлении секрета (nullArgument)");
    }
    @Test
    public void testSetSecretNotNull() {
        chel.SetSecret(new SecretS("Krek"));
        if(chel.S.isEmpty())
            fail("Ошибка в добавлении секрета (null)");
    }
    @Test
    public void testSet() {
        chel.add_if_min(new SecretS("312"));
        if(chel.S.isEmpty())
            fail("Ошибка в Set");
    }
    @Test
    public void testMapNormal() {
        chel.SetRod(new Person("sdsds"),new Rods("sdsd"));
        if(chel.M.isEmpty())
            fail("Ошибка в Map");
    }
    @Test
    public void testMapNull() {
        chel.SetRod(null,null);
        if(chel.M.isEmpty())
            fail("Ошибка в Map(Null)");
    }
    @Test
    public void testMapNullArgument() {
        chel.SetRod(new Person(),new Rods());
        if(chel.M.isEmpty())
            fail("Ошибка в Map(NullArgument)");
    }
    @Test
    public void testJson() {
        chel.AddAll(new JSONArray());
        if(!chel.S.isEmpty())
            fail("Ошибка в добавлении в формате JSON");
    }
    @Test
    public void testRods(){
        chel.M.clear();
        chel.SetRod(new Person("sdsd"),new Rods("dssd"));
        if(chel.M.isEmpty())
            fail("Ошибка при добавлении родственника");
    }
    @Test
    public void testAddToSet(){
        chel.S.clear();
        chel.S.add(new SecretS("Krek"));
        if(chel.S.isEmpty()) {
            fail("Ошибка при добавлении подарка");
        }
    }
    @Test
    public void testGiveEmpty(){
        Person chel1 = new Person();
        chel.GiveSecret(chel1,new SecretS());
        if(!chel1.S.isEmpty()) {
            fail("Ошибка при передаче подарка,которого нет у человека!");
        }
    }
    @Test
    public void testAddIfMin(){
        chel.S.clear();
        chel.add_if_min(new SecretS());
        chel.add_if_min(new SecretS());
        if(chel.S.size()==2)
            fail("Ошибка в функции add_if_min");
    }
    @Test
    public void testGive(){
        Person chel1 = new Person();
        SecretS a = new SecretS("sd");
        chel.SetSecret(a);
        chel.GiveSecret(chel1,a);
        if(chel1.S.isEmpty()) {
            fail("Ошибка при передаче подарка!");
        }
    }
    @Test
    public void testToString(){
        if(!chel.toString().equals("Vasya"))
            fail("Ошибка при преобразовании к String");
    }

}
