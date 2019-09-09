package com.shevlik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Transformation {
    static List readToList(){
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
        return list;
    }

    static String listToOneString(List<String> list){
        int listSize=list.size();
        String str="";
        for(int i=0;i<listSize;i++){
            str+=list.get(i);
        }
        return str;
    }

    static List splitStringToList(String str){
        List<String> list=new ArrayList<String>();
        Collections.addAll(list,str.split("[ ()\"!.,?-]+"));
        /*for (int i=0;i<list1.size();i++){
            System.out.println(list1.get(i));
        }*/
        return list;
    }

    static List getWordsEndIsStart(List<String> list){
        int listSize=list.size();
        String[] strArray=list.toArray(new String[listSize]);
        List<String> listOut=new ArrayList<>();
        for(int i=0;i<strArray.length-1;i++){
            char chEnd1=strArray[i].charAt(strArray[i].length()-1);
            char chStart2=strArray[i+1].charAt(0);
            if(chEnd1==chStart2){
                Collections.addAll(listOut,strArray[i]+" "+strArray[i+1]);
            }
        }
        return listOut;
    }
}
