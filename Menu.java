package com.shevlik;

import java.util.Scanner;
public class Menu{
    private int numberOfMenu=-1;
    private int menuItemCount;
    private String[] menuDescription;

    Menu(String... menuDescription){
        menuItemCount=menuDescription.length+1;
        this.menuDescription=new String[menuItemCount];
        for(int i=0;i<menuItemCount;i++){
            if(i<menuItemCount-1){
                this.menuDescription[i]=menuDescription[i];
            } else {
                this.menuDescription[i]="0. QUIT";
            }
        }
    }

    public void showMenu(){
        for (int i=0;i<menuItemCount;i++){
            System.out.println(menuDescription[i]);
        }
    }

    public int chooseMenuItem(){
        do {
            Scanner in=new Scanner(System.in);
            System.out.print("Choose menu item (0-" + (menuItemCount - 1) + "):");
            numberOfMenu=in.nextInt();
            System.out.println();
            /*in.close();*/
            for(int i=0;i<menuItemCount;i++){
                if(numberOfMenu==0) return 0;
                if(numberOfMenu==i+1){
                    return numberOfMenu;
                }
            }
        }while(true);
    }

    public int chooseMenuItem(Menu...menus){
        int size=menus.length;
        do {
            Scanner in=new Scanner(System.in);
            System.out.print("Choose menu item (0-" + (menuItemCount - 1) + "):");
            numberOfMenu=in.nextInt();
            System.out.println();
            /*in.close();*/
            for(int i=0;i<size;i++){
                if(numberOfMenu==0) break;
                if(numberOfMenu==i+1){
                    menus[i].chooseMenuItem();
                    break;
                }
            }
        }while(numberOfMenu!=0);
        return numberOfMenu;
    }

    public int getMenu() {
        return numberOfMenu;
    }

    public int getMenuItemCount() {
        return menuItemCount;
    }

}
