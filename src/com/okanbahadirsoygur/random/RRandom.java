package com.okanbahadirsoygur.random;

import java.util.ArrayList;
import java.util.List;

public class RRandom {


    public  List<Integer> randomIntegerListWithBlackList(int start, int end, int count ,List<Integer> BlackList, boolean uniqueAll){

        java.util.Random rnd = new java.util.Random();
        int r;
        List<Integer> sayilar = new ArrayList<Integer>();

        while (true){

            boolean varmi = false;

            r = rnd.nextInt(start,end);


            for(int i = 0; i< BlackList.size(); i++){

                if(BlackList.get(i) == r){

                    varmi = true;
                }
            }

            for (int i = 0; i< sayilar.size(); i++){

                if(sayilar.get(i) == r && uniqueAll == true){
                    varmi = true;
                }

            }


            if(varmi == false){
                sayilar.add(r);
            }

            if(sayilar.size() == count){
                break;
            }

        }

        return sayilar;

    }


}
