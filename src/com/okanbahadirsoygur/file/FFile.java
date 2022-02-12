package com.okanbahadirsoygur.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author okan bahadır soygür
 *
 * <p>Bu kütüphane macOS ve Windows arasında standart oluşturmak için yazılmıştır.
 * Burdaki bütün fonksiyonlar iki playfromda da sorunsuz çalışmaktadır.</p>
 */

public class FFile {

    /**
     * Bu fonksiyon hem Windows hem macOS'da dosya okuma işlemini sorunsuz gerçekleştiriyor.
     * While ile satır satır dosya okuma işlemi windows'da çalışmadığı için(dosyanın yarısını okuyor) Windows ve macOS'a özel olarak bu kodu geliştirdim.
     */
    public String FileReadWindowsAndMac(String path){

        String string_data = "";
        try{

            File file = new File(path);

            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[(int) file.length()];

            fis.read(data);

            fis.close();

            string_data = new String(data, "UTF-8");

        }catch (Exception e){

            System.out.println(e);

        }

        return string_data;

    }


    public String  stringReplaceAll(String data, String oldText, String newText){

            return data.replaceAll(oldText,newText);

    }


    public boolean fileExists(String path){
        File f = new File(path);


        if (f.exists())
            return true;

        else
            return false;
    }



    public boolean createFolder(String path){
        try {

            File ffe = new File(path);

            ffe.mkdirs();

            return  true;

        }catch (Exception e){

            System.out.println(e);
            return false;
        }
    }


    /**
     * Windows ve MacOS'da karekter sorunu olmadan string dataları, dosya olarak dışarıya çıkartır.
     */
    public boolean createFileUtf8Encoding(String path, String fileName ,String data){

        try{
            File dosya = new File(path + File.separator + fileName);
            FileWriter yazici = new FileWriter(dosya);
            BufferedWriter yaz = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dosya), StandardCharsets.UTF_8));
            yaz.write(data);
            yaz.close();

            return true;

        }
        catch(Exception hata){
            hata.printStackTrace();
            System.out.println(hata);
            return false;
        }
    }

    /**
     * <p>Kullanıcı klasörünün yolunu döndürür.</p>
     *
     * <p>maccOS etc:/Users/okanbahadirsoygur/</p>
     * <p>Windows etc:C\Kullanıcılar\okanbahadirsoygur</p>
     */

    public String getHomeFolderPath(){
        String path = new File("").getAbsolutePath()+File.separator;
        return path;
    }



}
