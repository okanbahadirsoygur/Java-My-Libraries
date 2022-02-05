package com.okanbahadirsoygur.ui;

import java.util.List;

public class Ui {

    private List<String> menuItems;
    private String title, iteratorTitle, selectMessage;

    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_BLACK = "\u001B[30m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_YELLOW = "\u001B[33m";
    private String ANSI_BLUE = "\u001B[34m";
    private String ANSI_PURPLE = "\u001B[35m";
    private String ANSI_CYAN = "\u001B[36m";
    private String ANSI_WHITE = "\u001B[37m";

    private String color;

    public Ui( String iteratorTitle, String title,String selectMessage,List<String> menuItems){

        this.menuItems = menuItems;
        this.title = title;
        this.iteratorTitle = iteratorTitle;
        this.selectMessage = selectMessage;
        color = this.ANSI_RESET;

    }


    public void pushMessage(String message,boolean breakLine){
        if(breakLine)
        System.out.println(this.color+message+this.ANSI_RESET);
        else
            System.out.print(this.color+message+this.ANSI_RESET);
    }

    public void breakLine(){
        System.out.println("");
    }


    public void draw(){

        String heading1 = this.iteratorTitle;
        String heading2 = this.title;

        System.out.printf(this.color + "%-15s %2s %n" + this.ANSI_RESET, heading1, heading2);
        System.out.println(this.color +"-----------------------------------------------------"+ this.ANSI_RESET);

        for (int i = 0; i < this.menuItems.size(); i++){

            System.out.printf(this.color+"%-15s %2s %n" +this.ANSI_RESET, (i+1)+")", menuItems.get(i));


        }//for

        System.out.println(this.color +"-----------------------------------------------------"+ this.ANSI_RESET);
        System.out.print(this.color+"[1-"+menuItems.size()+"] "+selectMessage+":"+this.ANSI_RESET);

    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * geçerli olması için draw() fonksiyonundan önce çalıştırılmalıdır.
     */
    public void colorRed(){

        this.color = this.ANSI_RED;
    }

    public void colorBlue(){

        this.color = this.ANSI_BLUE;
    }

    public void colorBlack(){

        this.color = this.ANSI_BLACK;
    }

    public void colorYellow(){

        this.color = this.ANSI_YELLOW;
    }

    public void colorWhite(){

        this.color = this.ANSI_WHITE;
    }

    public void colorCyan(){

        this.color = this.ANSI_CYAN;
    }

    public void colorGreen(){

        this.color = this.ANSI_GREEN;
    }

    public void colorPruple(){

        this.color = this.ANSI_PURPLE;
    }

}
