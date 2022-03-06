package com.sg.telefonlar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class AnkesorluTelefon extends AbstractTelefon
{
    private boolean elektrikVar;
    private boolean kartDolu;

    public AnkesorluTelefon(String numara)
    {
        super(numara);
    }

    @Override
    public void aramaYap(String aranacakNumara)
    {
        if(elektrikVar)
        {
            if(kartDolu)
            {
                aramaBilgisiGoster(aranacakNumara);
            }
            else
            {
                System.out.println("Arama yapılamıyor. Karta yükleme yapınız.");
            }
        }
        else
        {
            System.out.println("Arama yapılamıyor. Elektrik yok.");
        }
    }
}
