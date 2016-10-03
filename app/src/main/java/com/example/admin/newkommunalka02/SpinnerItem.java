package com.example.admin.newkommunalka02;

/**
 * Created by Admin on 16.09.2016.
 */
public class SpinnerItem {
    private String textSpinner = "";
    private int imageSpinner = 0;

    /***********
     * Set Methods
     ******************/
    public void setTextSpinner(String CompanyName) {
        this.textSpinner = CompanyName;
    }

    public void setImageSpinner(int Image) {
        this.imageSpinner = Image;
    }

    /***********
     * Get Methods
     ****************/
    public String getTextSpinner() {
        return this.textSpinner;
    }

    public int getImageSpinner() {
        return this.imageSpinner;
    }
}
