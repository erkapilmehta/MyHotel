package com.example.httpwww.reshotel.entities;

/**
 * Created by silenthacker on 04/04/16.
 */
public class UserInformation {

    String name;
    String email;
    String password;
    String mobileNo;
    String gender;
    String country;
    String iphone;
    String android;
    String windows;
    String date;
    String rating;

    public UserInformation(String name, String email, String password, String mobileNo, String gender, String country, String iphone, String android, String windows, String date, String rating) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.country = country;
        this.iphone = iphone;
        this.android = android;
        this.windows = windows;
        this.date = date;
        this.rating = rating;
    }




    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
