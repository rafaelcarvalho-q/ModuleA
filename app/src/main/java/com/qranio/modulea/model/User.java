package com.qranio.modulea.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;

import org.parceler.Parcel;

/**
 * Created by Rafael C. Almeida on 07/07/16.
 */
@Parcel
public class User {

    String firstName;
    String lastName;
    int imageIdRes;
    String email;
    String date;

    public User() {
    }

    public User(String firstName, String lastName, @DrawableRes int imageIdRes, String email, String date) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.imageIdRes = imageIdRes;
        this.email = email;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getImageIdRes() {
        return imageIdRes;
    }

    public void setImageIdRes(int imageIdRes) {
        this.imageIdRes = imageIdRes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
