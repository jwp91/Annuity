package com.porterlaw;
import java.io.Serializable;
import java.util.Scanner;

public class Client implements Serializable {
    private static final long serialVersionUID = 1875456294127103373L;
    String mFirstName, mLastName, mUserName;
    private String mPassword;
    int mAge;
    private boolean passwordAlreadySet = false;

    public Client(){
        //Used only for instantiation purposes.
    }
    public Client(String userName){
        mUserName=userName;
        mFirstName=getStringFromUser("Enter your first name: ");
        mLastName=getStringFromUser("Enter your last name: ");
        mAge=(int)getDoubleFromUser("Enter your current Age: ");

        setPassword();
    }
    public String toString(){
        return mUserName+"("+mFirstName+" "+mLastName+", "+mAge+")";
    }
    public void setPassword(){
        if(passwordAlreadySet){
            System.out.println("Password already set. ");
        } else{
            String input1,input2="";
            Scanner in = new Scanner(System.in);
            do{
                input1 = getStringFromUser("Enter a new Password: ");
                input2 = getStringFromUser("Confirm your password: ");
                if(!input1.equals(input2)){
                    System.out.println("Error: Passwords do not match. Try again: ");
                }
            }while(!input1.equals(input2));
            passwordAlreadySet = true;
            mPassword = input1;
        }
    }
    public String getUserName() {
        return mUserName;
    }

    public static String getStringFromUser(String promptText){
        Scanner in = new Scanner(System.in);
        System.out.println(promptText);
        return in.nextLine();
    }
    public static double getDoubleFromUser(String promptText){
        double result=0;
        boolean isValidInput=false;
        Scanner in = new Scanner(System.in);
        System.out.println(promptText);
        do{
            try{
                result = Double.parseDouble(in.nextLine());
                isValidInput=true;
            } catch(NumberFormatException nfe){
                System.out.println("Invalid input type. Try again: ");
            }
        }while(!isValidInput);
        return result;
    }
}
