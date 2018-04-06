package com.ardakazanci.ozellistview;

public class Kisiler {

    private String isim;

    private boolean kadinMi; // true Kadın , False ise Erkek

    public Kisiler(String isim, boolean kadinMi) {
        this.isim = isim;
        this.kadinMi = kadinMi;
    }

    @Override
    public String toString() {
        return isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public boolean isKadinMi() {
        return kadinMi;
    }

    public void setKadinMi(boolean kadinMi) {
        this.kadinMi = kadinMi;
    }
}
