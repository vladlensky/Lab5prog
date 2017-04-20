package Lab5;
import java.io.*;
import java.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
public class Main {
    static Person malish = new Person();
    public static void main (String args[]) throws IOException {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    BufferedOutputStream end = new BufferedOutputStream(new FileOutputStream("//home//s225110//Lab5end.txt"));
                    end.write(JSON.toJSONString(malish.GetSet()).getBytes());
                    end.flush();
                }catch(FileNotFoundException e){
                    System.out.println("Неверный файл!Неудачная запись!");
                }catch(IOException e){}
            }});
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(System.getenv().get("PathLAB5"))));
            //BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("//home//s225110//Lab5.txt")));
           // malish = JSON.parseObject(buf.readLine(), Person.class);
            Date curTime = new Date();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Список доступных команд для работы с коллекцией : ");
            System.out.println("1.close - закрыть программу, сохранив коллекцию в файл Lab5end.txt ");
            System.out.println("2.info - вывести тип коллекции, дату создания и размер коллекции  ");
            System.out.println("3.import {Path} - добавить в коллекцию все элементы из файла ");
            System.out.println("4.add_if_min {Элемент в формате JSON} - добавить элемент, если он меньше минимального в коллекции");
            System.out.println("5.clear - очистить коллекцию ");
            System.out.println("Бонусные команды : ");
            System.out.println("1.sort - сортирует коллекцию");
            System.out.println("2.get_collection_set - выводит все элементы коллекции set");
            System.out.println("3.get_collection_map - выводит все элементы коллекции map");
            System.out.println();
            System.out.println("Введите вашу команду: ");
            String comand = reader.readLine();
            String time = new String();
            while (comand!=null) {
                if(comand.trim().equals("i")){
                    System.out.println("2 доступных команды : info , import");
                    time = comand;
                    System.out.print(time);
                    comand = reader.readLine();
                    comand = time + comand;
                    continue;
                }
                if(comand.trim().equals("c")){
                    System.out.println("2 доступных команды : close , clear");
                    time = "cl";
                    System.out.print(time);
                    comand = reader.readLine();
                    comand = "cl" + comand;
                    continue;
                }
                if(comand.trim().equals("cl")){
                    System.out.println("2 доступных команды : close , clear");
                    time = comand;
                    System.out.print(time);
                    comand = reader.readLine();
                    comand = time + comand;
                    continue;
                }
                if(comand.trim().length() <=3) {
                    if(comand.equals("")){
                        System.out.println("Неправильное название команды!");
                        System.out.println("Повторный ввод : ");
                        comand = reader.readLine();
                        continue;
                    }
                    if (comand.substring(0, comand.length()).equals("info".substring(0, comand.length()))) {
                        System.out.print("info");
                        time = "info";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                    if (comand.substring(0, comand.length()).equals("sort".substring(0, comand.length()))) {
                        System.out.print("sort");
                        time = "sort";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                }
                if(comand.trim().length() <=4) {
                    if (comand.substring(0, comand.length()).equals("clear".substring(0, comand.length()))) {
                        System.out.print("clear");
                        time = "clear";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                    if (comand.substring(0, comand.length()).equals("close".substring(0, comand.length()))) {
                        System.out.print("close");
                        time = "close";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                }
                if(comand.trim().length() <=5) {
                    if (comand.substring(0, comand.length()).equals("import".substring(0, comand.length()))) {
                        System.out.print("import ");
                        time = "import ";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                }
                if(comand.trim().length() <=9) {
                    if (comand.substring(0, comand.length()).equals("add_if_min".substring(0, comand.length()))) {
                        System.out.print("add_if_min ");
                        time = "add_if_min ";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                }
                if(comand.trim().length() <=15) {
                    if (comand.substring(0, comand.length()).equals("get_collection_".substring(0, comand.length()))) {
                        System.out.println("2 варианта команды : get_collection_set , get_collection_map");
                        time = "get_collection_";
                        System.out.print(time);
                        comand = reader.readLine();
                        comand = "get_collection_" + comand;
                        continue;
                    }
                }
                if(comand.trim().length() <=17 &&comand.trim().length() >=16) {
                    if (comand.substring(0, comand.length()).equals("get_collection_set".substring(0, comand.length()))) {
                        System.out.print("get_collection_set");
                        time = "get_collection_set";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                    if (comand.substring(0, comand.length()).equals("get_collection_map".substring(0, comand.length()))) {
                        System.out.print("get_collection_map");
                        time = "get_collection_map";
                        comand = reader.readLine();
                        comand = time + comand;
                        continue;
                    }
                }
                if (comand.trim().equals("close")) {
                    System.out.println("Спасибо за внимание!");
                    return;
                }
                if (comand.trim().equals("info")) {
                    malish.info(curTime);
                    System.out.println("Введите следующую команду : ");
                    comand = reader.readLine();
                    continue;
                }
                if (comand.trim().equals("clear")) {
                    malish.clear();
                    System.out.println("Введите следующую команду : ");
                    comand = reader.readLine();
                    continue;
                }
                if (comand.trim().equals("sort")) {
                    malish.sortSet();
                    System.out.println("Коллекция отсортирована!");
                    System.out.println("Введите следующую команду : ");
                    comand = reader.readLine();
                    continue;
                }
                if (comand.trim().equals("get_collection_set")) {
                    malish.ShowSecrets();
                    System.out.println("Введите следующую команду : ");
                    comand = reader.readLine();
                    continue;
                }
                if (comand.trim().equals("get_collection_map")) {
                    malish.GetRods();
                    System.out.println("Введите следующую команду : ");
                    comand = reader.readLine();
                    continue;
                }
                A:
                {
                    try {

                            if (comand.trim().equals("import")) {
                                System.out.println("Вы ввели команду import без параметров!");
                                System.out.println("Повторный ввод : ");
                                break A;
                            } else if (comand.trim().substring(0, 6).equals("import")) {
                                try {
                                    comand = comand.trim().substring(7, comand.length() - 1);
                                    BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(comand)));
                                    String next = buff.readLine();
                                    JSONArray New = JSON.parseArray(next);
                                    System.out.println("Элементы добавлены из файла :");
                                    malish.AddAll(New);
                                    System.out.println("Введите следующую команду : ");
                                    break A;
                                } catch (com.alibaba.fastjson.JSONException e) {
                                    System.out.println("Неправильный формат данных в команде import!");
                                    System.out.println("Повторный ввод : ");
                                    break A;
                                } catch (FileNotFoundException e) {
                                    System.out.println("Неправильный путь к файлу в команде import!");
                                    System.out.println("Повторный ввод : ");
                                    break A;
                                } catch (NullPointerException e) {
                                    System.out.println("Неправильный путь к файлу в команде import!");
                                    System.out.println("Повторный ввод : ");
                                    break A;
                                } catch (StringIndexOutOfBoundsException e) {
                                    System.out.println("Неправильный форма записи в команде import!");
                                    System.out.println("Повторный ввод : ");
                                    break A;
                                }
                            }
                        try {
                            if (comand.trim().equals("add_if_min")) {
                                System.out.println("Вы ввели команду add_if_min без параметров!");
                                System.out.println("Повторный ввод : ");
                                break A;
                            }
                            if (comand.trim().substring(0, 10).equals("add_if_min")) {
                                comand = comand.trim().substring(10);
                                SecretS min = JSON.parseObject(comand, SecretS.class);
                                malish.add_if_min(min);
                                System.out.println("Введите следующую команду : ");
                                break A;
                            }
                        } catch (com.alibaba.fastjson.JSONException e) {
                            System.out.println("Неправильная форма записи в команде add_if_min!");
                            System.out.println("Повторный ввод : ");
                            break A;
                        } catch (NullPointerException e) {
                            System.out.println("Неправильный ввод команды add_if_min!");
                            System.out.println("Повторный ввод : ");
                            break A;
                        }
                    }catch(StringIndexOutOfBoundsException e) {}
                    System.out.println("Неправильное название команды!");
                    System.out.println("Повторный ввод : ");
                } // конец метки A
                comand = reader.readLine();
            }
            System.out.println("Спасибо за внимание!");
        } catch (FileNotFoundException e) {
            System.out.println("Неправильное имя файла в переменной окружения!");
        } catch (com.alibaba.fastjson.JSONException e) {
            System.out.println("Неправильная форма записи в файле!");
        }catch (NullPointerException e) {
            System.out.println("Нет файла, на который ссылается переменная окружения!");
            System.out.println("Переменная окружения : PathLAB5");
    }
}}
//стандартная библиотека java collections - 1 вопрос;
//зачем так много реализаций - stack,deque,queue,map,set,list
//javadoc
//hashmap
//hash - hashset
//hashtable