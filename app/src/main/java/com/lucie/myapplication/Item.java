package com.lucie.myapplication;

/**
 * Created by lucie on 11/16/15.
 */
public class Item {
    int id;
    String name, price, imgUrl;

    public Item(){

    }

    //constructor for the data
    public Item(int id, String name, String price, String imgUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }


    //functions for returning the data
  /*  public int getId(){
        return  id;
    }

    public String getName(){
        return  name;
    }

    public String getPrice(){
        return price;
    }
    public String getImgUrl(){
        return imgUrl;
    }*/
}
