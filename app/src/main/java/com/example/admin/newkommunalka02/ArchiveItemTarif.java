package com.example.admin.newkommunalka02;

/**
 * Created by Admin on 25.02.2016.
 */
public class ArchiveItemTarif {

    private String regionCWater;
    private String tarifCwater;
    private String inCWater;
    private String outCWater;
    private int tarifId;

    public ArchiveItemTarif(int i, String s, String string, String summ) {
        this.tarifId = i;
        this.tarifCwater = s;
        this.inCWater = string;
        this.outCWater = summ;
    }
    @Override
    public String toString() {
        return this.tarifCwater;
    }

    public String string() {
        return this.outCWater + "  -  " + this.outCWater;
    }

    public ArchiveItemTarif(String s, String string, String summ) {
        this.tarifCwater = s;
        this.inCWater = string;
        this.outCWater = summ;
    }
    public ArchiveItemTarif() {
    }

    public int getTarifId() {
        return tarifId;
    }

    public void setTarifId(int tarifIdId) {
        this.tarifId = tarifIdId;
    }

    public String getRegionCWater (String regionCWater) {
        return regionCWater;
    }

    public void setRegionCWater (String regionCWater) {
        this.regionCWater = regionCWater;
    }

    public String getTarifCwater() {
        return tarifCwater;
    }

    public void setTarifCwater(String tarifCwater) {
        this.tarifCwater = tarifCwater;
    }

    public String getInCWater() {
        return inCWater;
    }

    public void setInCWater(String inCWater) {
        this.inCWater = inCWater;
    }

    public String getOutCWater() {
        return outCWater;
    }

    public void setOutCWater(String outCWater) {
        this.outCWater = outCWater;
    }
}