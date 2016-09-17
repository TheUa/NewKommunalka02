package com.example.admin.newkommunalka02;

/**
 * Created by Admin on 26.01.2016.
 */
public class ArchiveItem {

    private String archiveCount;
    private String archiveDate;
    private String archiveSum;
    private String archiveDescr;
    private int archiveId;

    public ArchiveItem(int i, String s, String string, String summ, String descr) {
        this.archiveId = i;
        this.archiveCount = s;
        this.archiveDate = string;
        this.archiveSum = summ;
        this.archiveDescr = descr;
    }
    @Override
    public String toString() {
        return this.archiveCount;
    }
    public String string() {
        return this.archiveSum + "  -  " + this.archiveSum;
    }

    public ArchiveItem(String s, String string, String summ, String descr) {
        this.archiveCount = s;
        this.archiveDate = string;
        this.archiveSum = summ;
        this.archiveDescr = descr;
    }
    public ArchiveItem() {
    }

    public int getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(int archiveId) {
        this.archiveId = archiveId;
    }

    public String getArchiveCount() {
        return archiveCount;
    }

    public void setArchiveCount(String archiveCount) {
        this.archiveCount = archiveCount;
    }

    public String getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(String archiveDate) {
        this.archiveDate = archiveDate;
    }

    public String getArchiveSum() {
        return archiveSum;
    }

    public void setArchiveSum(String archiveSum) {
        this.archiveSum = archiveSum;
    }

    public String getArchiveDescr() {
        return archiveDescr;
    }

    public void setArchiveDescr(String archiveDescr) {
        this.archiveDescr = archiveDescr;
    }
}
