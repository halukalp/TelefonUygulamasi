package com.sg.utility;

public enum AnkesorluKulube
{
    KADIKOY_RASIMPASA_KULUBE1("0216-999-88-22"),
    KADIKOY_RASIMPASA_KULUBE2("0216-999-88-33"),
    KADIKOY_RASIMPASA_KULUBE3("0216-999-88-44"),

    KADIKOY_OSMANAGA_KULUBE1("0216-777-88-22"),
    KADIKOY_OSMANAGA_KULUBE2("0216-777-88-33"),
    KADIKOY_OSMANAGA_KULUBE3("0216-999-88-44");

    private String telNo;

    private AnkesorluKulube(String telNo)
    {
        this.telNo = telNo;
    }

    public String getTelNo()
    {
        return telNo;
    }
}
