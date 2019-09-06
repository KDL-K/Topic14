package com.shevlik;

import java.io.*;

public class FunctionsInOutput {

    //Сериализуем объект object и записываем в файл file
    public static <T>void serializeOfObject(File file,T object){
        try(FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream ous=new ObjectOutputStream(fos)){
            ous.writeObject(object);
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //Десериализуем объект из файла file и возвращаем на него ссылку
    public static Object deserializeFromFile(File file){
        Object obj=null;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file))){
            return ois.readObject();
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
