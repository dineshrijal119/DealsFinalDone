package com.technocurl.www.deals;

import java.io.Serializable;

/**
 * Created by deadlydragger on 7/6/16.
 */
public class GetdealData implements Serializable {
    String category;
    String dealDesc;
    String dealId;
    String distance;
    String estbName;
    String imgUrl1;
    String imgUrl2;
    String imgUrl3;
    String locLat;
    String locLng;
    String locPhone;
    String website;
    String imgUrl5;
    String imgUrl6;
    String imgUrl7;
    String imgUrl4;
    String imgUrl8;
    String featureFlag;
    public  String getCategory(){
        return category;
    }
    public String getDealDesc(){
        return dealDesc;
    }
    public String getDealId(){
        return dealId;
    }
    public String getDistance(){
        return distance;
    }
    public String getEstbName(){
        return estbName;
    }
    public  String  getImgUrl1(){
        return imgUrl1;
    }
    public String getImgUrl2(){
        return imgUrl2;
    }
    public String getImgUrl3(){
        return imgUrl3;
    }
    public String getLocLat(){
        return locLat;
    }
    public String getLocLng(){
        return locLng;
    }
    public String getLocPhone(){
        return locPhone;
    }
    public String getWebsite(){
        return website;
    }
    public  String getImgUrl4(){
        return imgUrl4;
    }
    public String getImgUrl5(){
        return  imgUrl5;
    }
    public  String getImgUrl6(){
        return imgUrl6;
    }
    public  String getImgUrl7(){
        return imgUrl7;
    }
    public String getImgUrl8(){
        return imgUrl8;
    }
    public  String getFeatureFlag(){
        return featureFlag;
    }

    public void setCategory(String category){
        this.category=category;
    }
    public void setDealDesc(String dealDesc){
        this.dealDesc=dealDesc;
    }
    public void setDealId(String dealId){
        this.dealId=dealId;
    }
    public void setDistance(String distance){
        this.distance=distance;
    }
    public void setEstbName(String estbName){
        this.estbName=estbName;
    }
    public void setImgUrl1(String imgUrl1){
        this.imgUrl1=imgUrl1;
    }
    public void setImgUrl2(String imgUrl2){
        this.imgUrl2=imgUrl2;
    }
    public void setImgUrl3(String imgUrl3){
        this.imgUrl3=imgUrl3;
    }
    public void setLocLat(String locLat){
        this.locLat=locLat;
    }
    public void setLocLng(String locLng){
        this.locLng=locLng;
    }
    public void setLocPhone(String locPhone){
        this.locPhone=locPhone;
    }
    public void setWebsite(String website){
        this.website=website;
    }
    public  void setImgUrl4(String imgUrl4){
        this.imgUrl4=imgUrl4;
    }
    public  void setImgUrl5(String imgUrl5){
        this.imgUrl5=imgUrl5;
    }
    public  void setImgUrl6(String imgUrl6){
        this.imgUrl6=imgUrl6;
    }
    public void setImgUrl7(String imgUrl7){
        this.imgUrl7=imgUrl7;
    }
    public  void setImgUrl8(String imgUrl8){
        this.imgUrl8=imgUrl8;
    }
    public  void  setFeatureFlag(String featureFlag){
        this.featureFlag=featureFlag;
    }
}