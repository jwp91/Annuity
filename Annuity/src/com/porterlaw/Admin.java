package com.porterlaw;

public class Admin extends Client{
    public Admin(String userName){
        System.out.println("Creating new Admin account...");
        mUserName=userName;
        mFirstName=getStringFromUser("Enter your first name: ");
        mLastName=getStringFromUser("Enter your last name: ");
        mAge=(int)getDoubleFromUser("Enter your current Age: ");
        setPassword();
    }
}
