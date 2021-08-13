package com.rapidcartconsumers;

public class MainModel {

    String storename;
    String storeid;
    String storepin;
    String storephonenumber;
    String itemname;
    String price;
    String delivarymessage;
    String itemimage;
    String itemdesc;

   public MainModel()
    {

    }

    public MainModel(String storename, String storeid, String storepin, String storephonenumber, String itemname, String price, String delivarymessage, String itemimage, String itemdesc) {
        this.storename = storename;
        this.storeid = storeid;
        this.storepin = storepin;
        this.storephonenumber = storephonenumber;
        this.itemname = itemname;
        this.price = price;
        this.delivarymessage = delivarymessage;
        this.itemimage = itemimage;
        this.itemdesc = itemdesc;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStorepin() {
        return storepin;
    }

    public void setStorepin(String storepin) {
        this.storepin = storepin;
    }

    public String getStorephonenumber() {
        return storephonenumber;
    }

    public void setStorephonenumber(String storephonenumber) {
        this.storephonenumber = storephonenumber;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDelivarymessage() {
        return delivarymessage;
    }

    public void setDelivarymessage(String delivarymessage) {
        this.delivarymessage = delivarymessage;
    }

    public String getItemimage() {
        return itemimage;
    }

    public void setItemimage(String itemimage) {
        this.itemimage = itemimage;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }
}
