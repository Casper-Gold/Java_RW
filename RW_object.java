package Aston;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


// имплементируем интерфейс Serializable, чтобы система знала, что объект этого класса может быть сериализован
public class RW_object implements Serializable
{

    String name;
    int age;

    public RW_object(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName(){return name;}
    public int getAge(){return age;}

    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}

    @Override
    public String toString()
    {
        return "Имя " + name + ", возраст " + age;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException  // передаём обработку на верх
    {
        // создаём объект "object" класса RW_object, который будем записывать в файл.
        RW_object object = new RW_object("Иван",  23);
        
        try(ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream("object.dat"));
            ObjectInputStream oIS = new ObjectInputStream(new FileInputStream("object.dat")))
        {
            // записываем объект "object" в файл object.dat
            oOS.writeObject(object);
            
            // читаем файл object.dat
            Object readObj = oIS.readObject();
            System.out.println("Прочитанный объект: " + readObj);
        }
        catch(IOException | ClassNotFoundException f)  // обработка ошибки ClassNotFoundException
        {
            System.out.println("Класс не найден.");
        }
    }
}
