package com.shevlik;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Menu menu=new Menu("1. Задача 1: Вывести пары слов, где последняя буква первого слова = первой букве второго.",
                "2. Задача 2: Работа со списком студентов.");

        do {
            menu.showMenu();
            int numberOfMenu=menu.chooseMenuItem();
            if(numberOfMenu==0) return;
            else{
                switch (numberOfMenu){
                    case 1:
                        List<String> list=Transformation.readToList();
                        String str=Transformation.listToOneString(list);
                        list=new ArrayList<String>();
                        list=Transformation.splitStringToList(str);
                        List<String> listOut=Transformation.getWordsEndIsStart(list);
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
