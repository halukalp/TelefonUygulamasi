package com.sg.telefonlar;

import com.sg.utility.Arayabilir;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public abstract class AbstractTelefon implements Arayabilir
{
    protected String numara;

    public AbstractTelefon(String numara)
    {
        this.numara = numara;
    }

    protected void aramaBilgisiGoster(String aranacakNumara)
    {
        System.out.println("Cihaz türü: " + getClass().getSimpleName()
                + ".\n" + numara + " numarasindan aranan numara: " + aranacakNumara);
    }
}
