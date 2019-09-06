package com.shevlik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Menu menu=new Menu("1. Задача 1.","2. Задача 2.");

        do {
            menu.showMenu();
            int numberOfMenu=menu.chooseMenuItem();
            if(numberOfMenu==0) return;
            else{
                switch (numberOfMenu){
                    case 1:
                        List<String> list=new ArrayList<String>();
                        String str;
                        try(FileReader fr=new FileReader("./Text.txt")){
                            BufferedReader br=new BufferedReader(fr);
                            while((str=br.readLine())!=null){
                                list.add(str);
                            }
                        }catch (IOException ex){
                            System.out.println(ex.getMessage());
                        }
                        int listSize=list.size();
                        String str2="";
                        for(int i=0;i<listSize;i++){
                            str2+=list.get(i);
                        }
                        List<String> list1=new ArrayList<String>();
                        Collections.addAll(list1,str2.split("[ ()\"!.,?-]+"));
                        /*for (int i=0;i<list1.size();i++){
                            System.out.println(list1.get(i));
                        }*/
                        int list1Size=list1.size();
                        String[] strArray=list1.toArray(new String[list1Size]);
                        List<String> listOut=new ArrayList<>();
                        for(int i=0;i<strArray.length-1;i++){
                            char chEnd1=strArray[i].charAt(strArray[i].length()-1);
                            char chStart2=strArray[i+1].charAt(0);
                            if(chEnd1==chStart2){
                                Collections.addAll(listOut,strArray[i]+" "+strArray[i+1]);
                            }
                        }
                        for (int i=0;i<listOut.size();i++){
                            System.out.println(listOut.get(i));
                        }
                        break;
                    case 2:
                        Menu menu2=new Menu("1. Создать список студентов и сохранить на диск.",
                                "2. Вывести на консоль сохраненный список студентов.");

                        do{
                            menu2.showMenu();
                            int numberOfMenu2=menu2.chooseMenuItem();
                            if(numberOfMenu2==0) break;
                            else {
                                File file=new File("./FileOfSerialization.txt");
                                switch (numberOfMenu2){
                                    case 1:
                                        ArrayList<Student> list2=new ArrayList<Student>();
                                        Collections.addAll(list2,new Student("Ольга","Петрова",21,7),
                                                new Student("Максим","Сидоров",22,8));
                                        FunctionsInOutput.serializeOfObject(file,list2);
                                        break;
                                    case 2:
                                        ArrayList<Student> listRead;
                                        listRead=(ArrayList)FunctionsInOutput.deserializeFromFile(file);
                                        for(Student st:listRead){
                                            System.out.println(st);
                                        }
                                        break;
                                }
                            }

                        }while (true);
                        break;
                }
            }
        }while (true);

    }
}
