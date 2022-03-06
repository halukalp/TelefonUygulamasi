package com.sg.utility;

public enum TelCesit
{
    CEP_TELEFONU("cep telefonu"),
    UYDU_TELEFONU("uydu telefonu"),
    ANKESORLU_TELEFON("ankesorlu telefon");

    private String deger;

    private TelCesit(String deger)
    {
        this.deger = deger;
    }

    public String getDeger()
    {
        return deger;
    }
}
