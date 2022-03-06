package com.sg.program;

import com.sg.utility.Arayabilir;

import javax.swing.*;
import java.util.function.Consumer;

/**
 * "Lambda Expressions" örnekleri bu sınıftadır.
 */
public class Main2
{
    private static final String ENGELLENEN_NO = "444";

    public static void main(String[] args)
    {
        /*
        Uygulama.calistir(new Arayabilir()
        {
            @Override
            public void aramaYap(String aranacakNumara) {
                if (aranacakNumara.startsWith(ENGELLENEN_NO)) {
                    System.out.println("Aranacak numara " + ENGELLENEN_NO + " ile başlayamaz.");
                } else {
                    String numara = JOptionPane.showInputDialog("Kendi numaranızı giriniz:");
                    System.out.println(numara + " numarasından aranan numara: " + aranacakNumara);
                }
            }
        });
        */

        /*
        Uygulama.calistir(
                (String aranacakNumara) ->
                {
                    if (aranacakNumara.startsWith(ENGELLENEN_NO)) {
                        System.out.println("Aranacak numara " + ENGELLENEN_NO + " ile başlayamaz.");
                    } else {
                        String numara = JOptionPane.showInputDialog("Kendi numaranızı giriniz:");
                        System.out.println(numara + " numarasından aranan numara: " + aranacakNumara);
                    }
                }
        );
        */


        Uygulama.calistir(
                aranacakNumara ->
                {
                    if (aranacakNumara.startsWith(ENGELLENEN_NO))
                    {
                        System.out.println("Aranacak numara " + ENGELLENEN_NO + " ile başlayamaz.");
                    } else
                    {
                        String numara = JOptionPane.showInputDialog("Kendi numaranızı giriniz:");
                        System.out.println(numara + " numarasından aranan numara: " + aranacakNumara);
                    }
                }
        );
    }
}
