package com.okanbahadirsoygur.ui;

import java.util.List;

public class Ui {

    private List<String> menuItems;
    private String title, iteratorTitle, selectMessage;

    public Ui(String title, String iteratorTitle,String selectMessage,List<String> menuItems){

        this.menuItems = menuItems;
        this.title = title;
        this.iteratorTitle = iteratorTitle;
        this.selectMessage = selectMessage;
        draw();

    }


    public void draw(){

        String heading1 = this.iteratorTitle;
        String heading2 = this.title;
        System.out.printf( "%-15s %2s %n", heading1, heading2);
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < this.menuItems.size(); i++){

            System.out.printf( "%-15s %2s %n", (i+1)+")", menuItems.get(i));


        }//for

        System.out.println("-----------------------------------------------------");
        System.out.print("[1-"+menuItems.size()+"] "+selectMessage+":");

    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
