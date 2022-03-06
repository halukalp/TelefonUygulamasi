package com.sg.program;

import com.sg.telefonlar.AbstractTelefon;
import com.sg.telefonlar.AnkesorluTelefon;
import com.sg.telefonlar.CepTelefonu;
import com.sg.telefonlar.UyduTelefonu;
import com.sg.utility.AnkesorluKulube;
import com.sg.utility.Arayabilir;
import com.sg.utility.TelCesit;

import javax.swing.*;
import java.util.Scanner;

public final class Uygulama
{
    private static String aranacakTelefonNumarasi;
    private static String kendiTelefonNumarasi;

    private Uygulama()
    {
    }

    private static boolean kendiNumaraniIste(TelCesit telCesit)
    {
        if(telCesit != TelCesit.ANKESORLU_TELEFON)
        {
            kendiTelefonNumarasi = JOptionPane.showInputDialog("Lütfen kendi " + telCesit + " numaranızı giriniz:");

            return true;
        }
        else
        {
            String ilce =  JOptionPane.showInputDialog("İlçe giriniz (Özel karakter kullanmayınız.) :");

            String mahalle =  JOptionPane.showInputDialog("Mahalle giriniz (Özel karakter kullanmayınız.) :");

            int kulubeNo =  Integer.parseInt( JOptionPane.showInputDialog("Kulube no giriniz (Özel karakter kullanmayınız.) :") );

            String ankesorluKulubeAnahtar = ilce + "_" + mahalle + "_kulube" + kulubeNo;

            boolean kulubeBulundu = false;
            AnkesorluKulube[] kulubeler = AnkesorluKulube.values();
            for (int i = 0; i < kulubeler.length; i++)
            {
                if(kulubeler[i].toString().equalsIgnoreCase(ankesorluKulubeAnahtar.toString()))
                {
                    kendiTelefonNumarasi = kulubeler[i].getTelNo();

                    kulubeBulundu = true;

                    break;
                }
            }

            if(!kulubeBulundu)
            {
                System.out.println("\nKulube bulunamadı.");
                return false;
            }
            else
            {
                return true;
            }
        }
    }

    private static void aranacakNumarayiIste(TelCesit telCesit)
    {
        aranacakTelefonNumarasi = JOptionPane.showInputDialog("Lütfen aranacak " + telCesit + " numarasını giriniz:");
    }

    private static void numaraIste(TelCesit telCesit)
    {
        if( kendiNumaraniIste(telCesit) ) aranacakNumarayiIste(telCesit);
    }



    public static void calistir(Arayabilir arayabilir)
    {

        AbstractTelefon telefon;
        String input = "";
        char telefonSecim = ' ';
        while (true)
        {
            input = JOptionPane.showInputDialog("Lütfen telefon tipini seçiniz \n " +
                    "Cep tel için c:\nUydu tel için u:\nAnkesörlü tel için a:\nÇıkış için e");
            if(input == null) break;

            telefonSecim = input.charAt(0);
            if(telefonSecim == 'e') break;

            switch (telefonSecim)
            {
                case 'c':
                    numaraIste(TelCesit.CEP_TELEFONU);
                    telefon = new CepTelefonu(kendiTelefonNumarasi);
                    aramayaHazirla(telefon);
                    break;

                case 'u':
                    numaraIste(TelCesit.UYDU_TELEFONU);
                    telefon = new UyduTelefonu(kendiTelefonNumarasi);
                    aramayaHazirla(telefon);
                    break;

                case 'a':
                    numaraIste(TelCesit.ANKESORLU_TELEFON);
                    telefon = new AnkesorluTelefon(kendiTelefonNumarasi);
                    aramayaHazirla(telefon);
                    break;

                case 'e':
                    System.out.println("Çıkış yaptınız.");
                    break;

                default:
                    System.out.println("Yanlış bir seçim yaptınız.");
                    break;
            }
        }
    }


    private static void aramayaHazirla(Arayabilir arayabilir)
    {
        if(arayabilir instanceof UyduTelefonu)
        {
            ((UyduTelefonu) arayabilir).setUyduVar(true);
        }
        else if(arayabilir instanceof CepTelefonu)
        {
            ((CepTelefonu) arayabilir).setSebekeVar(true);
            ((CepTelefonu) arayabilir).setKontorVar(true);
        }
        else if(arayabilir instanceof AnkesorluTelefon)
        {
            ((AnkesorluTelefon) arayabilir).setElektrikVar(true);
            ((AnkesorluTelefon) arayabilir).setKartDolu(true);
        }

        if(kendiTelefonNumarasi != null)
        {
            arayabilir.aramaYap(aranacakTelefonNumarasi);

            kendiTelefonNumarasi = null;
            aranacakTelefonNumarasi = null;
        }
        else
        {
            System.out.println("Numara geçersiz olduğu için arama yapılamıyor.");
        }
    }
}
