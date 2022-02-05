package com.okanbahadirsoygur.app;

import com.okanbahadirsoygur.random.RRandom;
import com.okanbahadirsoygur.ui.Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        RRandom rnd = new RRandom();

        List<Integer> blackList = new ArrayList<>();
        blackList.add(1);
        blackList.add(2);
        blackList.add(3);

        System.out.println(rnd.randomIntegerListWithBlackList(0,20,10,blackList,true));

        List<String> menuItems = new ArrayList<>();
        menuItems.add("Random Sayi");
        menuItems.add("Deneme");

        Ui ui = new Ui("İşlemler","ID","Arasında bir işlem seçin",menuItems);




    }
}