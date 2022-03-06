package com.sg.telefonlar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class UyduTelefonu extends AbstractTelefon
{
    private boolean uyduVar;

    public UyduTelefonu(String numara)
    {
        super(numara);
    }

    @Override
    public void aramaYap(String aranacakNumara)
    {
        if(uyduVar)
        {
            aramaBilgisiGoster(aranacakNumara);
        }
        else
        {
            System.out.println("Arama yapılamıyor. Uydu yok.");
        }
    }
}
