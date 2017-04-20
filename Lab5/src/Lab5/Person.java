/**
 * Created by bespa on 21.02.2017.
 */
package Lab5;
import com.alibaba.fastjson.*;
import java.util.*;
public class Person {
    public String name1;
    public Map<Rods, Person> M = new HashMap<Rods,Person>();
    public Set<SecretS> S = new LinkedHashSet<SecretS>();

    public Person() {
        name1 = null;
    }

    public Person(String Name) {
        name1 = Name;
    }

    public String GetName() {
        return name1;
    }

    public void SetName(String Name) {
        name1 = Name;
    }

    public void SetRod(Person a, Rods b) {
        if (M.containsKey(b)) {
            Rods c = new Rods();
            b.Eq(c);
            M.put(c, a);
        } else
            M.put(b, a);
    }
    /** Показывает всех родственников данного человека
     * @author Vlad
     * @version 1.0 */
    public void GetRods() {
        if (M.isEmpty()) {
            System.out.println(this.GetName() + " не имеет родственников!");
            return;
        }

        System.out.println(this.GetName() + " имеет родственников : ");
        for (Map.Entry entry : M.entrySet()) {
            System.out.println(JSON.toJSONString(entry));
        }
    }

    public void Think() {
        System.out.println(this.GetName() + " думает,что у него лучшие в мире родственники");
        System.out.println("Ему нравятся подарки");
    }

    public String toString() {
        return GetName();
    }

    public void SetSecret(SecretS a) {
        S.add(a);
    }
    /** Показывает все подарки данного человека
     * @version 1.0 */
    public void ShowSecrets() {
        System.out.println(this.GetName() + " имеет подарки:");
        for (SecretS s : S) {
            System.out.println(JSON.toJSONString(s));
        }
    }

    public void GiveSecret(Person a, SecretS s) {
        if (S.contains(s)) {
            a.SetSecret(s);
            S.remove(s);
        } else {
            System.out.println("У этого человека нет такого подарка!");
        }
    }
    /** info - Выводит информацию о коллекции LinkedHashSet
     * @param start дата создания коллекции {@link Date}
     * @version 1.0*/
    public void info(Date start) {
        System.out.println("Тип коллекции : LinkedHashSet.");
        System.out.println("Полная дата создания : " + start.toString());
        System.out.println("Размер коллекции : " + S.size());
    }

    /** clear - Очищает коллекцию LinkedHashSet
     * @version 1.0*/
    public void clear() {
        S.clear();
    }
    /** add_if_min - Добавляет элемент в коллекцию, если он по весу и объёму меньше каждого элемента в коллекции
     * @param object добавляемый объект класса {@link SecretS}
     * @version 1.0
     */
    public void add_if_min(SecretS object) {
        int a = 2147483647;
        for (SecretS min : S) {
            if (min.GetSize() * min.GetWeight() < a) {
                a = min.GetSize() * min.GetWeight();
            }
        }
        if (object.GetSize() * object.GetWeight() < a) {
            System.out.println("Элемент добавлен!");
            System.out.println(JSON.toJSONString(object));
            S.add(object);
        }
        else
            System.out.println("Элемент не добавлен!");
    }
    public Set<SecretS> GetSet(){return S;}

    /** AddAll - Добавляет все элементы в коллекцию
     * @param NewSecretS коллекция из {@link JSONObject}, все элементы которой должны быть переданы в основную, состоящую из {@link SecretS}
     * @version 1.0
     * */
    public void AddAll(JSONArray NewSecretS) {
        for (int i = 0;i < NewSecretS.size();i++) {
            SecretS New = JSON.parseObject(NewSecretS.get(i).toString(),SecretS.class);
            System.out.println(JSON.toJSONString(New));
            S.add(New);
        }
    }
    /** sort - Сортирует коллекцию LinkedHashList
     * @version 1.1*/
    public void sortSet() throws NullPointerException{
        SecretS [] sec =  new SecretS[S.size()];
        int j=0;
        for (SecretS compare:S) {
            sec[j] = compare;
            j++;
        }
        for (int i = S.size() - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (sec[j].compareTo(sec[j + 1])>0) {
                    SecretS tmp = sec[j];
                    sec[j] = sec[j + 1];
                    sec[j + 1] = tmp;
                }
            }
        }
        Set<SecretS> New = new LinkedHashSet<SecretS>();
        for(int i = 0;i < sec.length;i++){
            New.add(sec[i]);
        }
        S = New;
    }
}