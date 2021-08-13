package com.rapidcartconsumers;

public class Shoppickmodel {

    String shopname,minmumorder;
    String Shopimageurl;
    String shopid;


    public Shoppickmodel(){}
    //empty constructer required


    public Shoppickmodel(String shopname, String minmumorder, String shopimageurl, String shopid) {
        this.shopname = shopname;
        this.minmumorder = minmumorder;
        Shopimageurl = shopimageurl;
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getMinmumorder() {
        return minmumorder;
    }

    public void setMinmumorder(String minmumorder) {
        this.minmumorder = minmumorder;
    }

    public String getShopimageurl() {
        return Shopimageurl;
    }

    public void setShopimageurl(String shopimageurl) {
        Shopimageurl = shopimageurl;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }
}
