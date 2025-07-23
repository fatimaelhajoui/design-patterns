/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creational.singleton;

/**
 *
 * @author marwa
 */
public class Basic {
    //this field will store the singleton instance
    private static Basic instance ;
    
    //add the attributes
    private String username ="fatima";
    private int password =1234;
    
    //Singleton´s constructor should always be private 
    private Basic(String username, int password) {
        this.username = username;
        this.password = password;
    }
    
    //the static method that controls access to the singleton instance
    public static Basic getInstance(String username, int password){
        if(instance == null){
            instance = new Basic(username, password);
        }
        return instance;
    }
    
    
    
}
