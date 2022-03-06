package com.sg.telefonlar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CepTelefonu extends AbstractTelefon
{
    private boolean sebekeVar;
    private boolean kontorVar;

    public CepTelefonu(String numara)
    {
        super(numara);
    }

    @Override
    public void aramaYap(String aranacakNumara)
    {
        if(sebekeVar)
        {
            if(kontorVar)
            {
                aramaBilgisiGoster(aranacakNumara);
            }
            else
            {
                System.out.println("Arama yapılamıyor. Kontör yükleyiniz.");
            }
        }
        else
        {
            System.out.println("Arama yapılamıyor. Şebeke yok.");
        }
    }
}
