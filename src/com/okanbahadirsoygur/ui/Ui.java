package com.okanbahadirsoygur.ui;

import java.util.List;

/**
 * @author okan bahadır soygür
 *
 * macOS, Linux ve Windows'a uyumlu konsol tabanlı ui geliştirmek için yazılmıştır.
 * Renk kodları Windows'da çalışmadığı için kütüphane tarafından otomatik devredışı bırakılır.
 */

public class Ui {

    private List<String> menuItems;
    private String title, iteratorTitle, selectMessage;

    //renk kodları Windows'da çalışmıyor. O yüzden windows'da disable etmeliyiz.
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
        System.out.println(getCurrentColor()+message);
        else
            System.out.print(getCurrentColor()+message);
    }

    public void breakLine(){
        System.out.println("");
    }


    public void draw(){

        String heading1 = this.iteratorTitle;
        String heading2 = this.title;

        System.out.printf(getCurrentColor() + "%-15s %2s %n", heading1, heading2);
        System.out.println(getCurrentColor()+"-----------------------------------------------------");

        for (int i = 0; i < this.menuItems.size(); i++){

            System.out.printf(getCurrentColor()+"%-15s %2s %n", (i+1)+")", menuItems.get(i));


        }//for

        System.out.println(getCurrentColor() +"-----------------------------------------------------");
        System.out.print(getCurrentColor()+"[1-"+menuItems.size()+"] "+selectMessage+":");

    }

    public void clearScreen(){


        if(getOs().indexOf("Linux") != -1 || getOs().indexOf("Mac")!= -1 || getOs().indexOf("windows")!= -1 ||  getOs().indexOf("windows")!= -1) {

            //bu kod Windows'da çalışmamaktadır.
            System.out.print("\033[H\033[2J");
        }

        //her iki sistemdede çalışır.
        System.out.flush();
    }

    /**
     * geçerli olması için draw() fonksiyonundan önce çalıştırılmalıdır.
     */
    public void colorRed(){

        setCurrentColor(this.ANSI_RED);

    }

    public void colorBlue(){

        setCurrentColor(this.ANSI_BLUE);
    }

    public void colorBlack(){

        setCurrentColor(this.ANSI_BLACK);
    }

    public void colorYellow(){

        setCurrentColor(this.ANSI_YELLOW);
    }

    public void colorWhite(){

        setCurrentColor(this.ANSI_WHITE);
    }

    public void colorCyan(){

        setCurrentColor(this.ANSI_CYAN);
    }

    public void colorGreen(){

        setCurrentColor(this.ANSI_GREEN);
    }

    public void colorPruple(){

      setCurrentColor(this.ANSI_PURPLE);
    }

    private void setCurrentColor(String color){

        //eğer sistem linux yada mac ise renk kodlarını aktif edeceğiz. Eğer windows ise renk kodları disable olacak.
        if(getOs().indexOf("Linux") != -1 || getOs().indexOf("Mac")!= -1 || getOs().indexOf("windows")!= -1 ||  getOs().indexOf("windows")!= -1){

            this.color = color;

        }else{

            this.color = "";

        }
    }

    private String getCurrentColor(){
        //eğer sistem linux yada mac ise renk kodlarını aktif edeceğiz. Eğer windows ise renk kodları disable olacak.
        if(getOs().indexOf("Linux") != -1 || getOs().indexOf("Mac")!= -1 || getOs().indexOf("windows")!= -1 ||  getOs().indexOf("windows")!= -1){

           return this.color;

        }else{

            return "";

        }
    }

    private String getOs(){

        String os = System.getProperty("os.name");
        return os;
    }



}
