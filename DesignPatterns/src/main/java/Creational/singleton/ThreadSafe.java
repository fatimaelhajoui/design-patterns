/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creational.singleton;

/**
 *
 * @author marwa
 */
public class ThreadSafe {
    
    // Static field to store the single instance of the class    
    // Volatile ensures visibility across threads and prevents instruction reordering
    private static volatile ThreadSafe instance ;
    
    //add the attributes
    private String[] role={"admin", "leader", "employee"};
    
    //Singleton´s constructor should always be private 
    private ThreadSafe(String[] role) {
        this.role = role;
    }
    
    //the static method that controls access to the singleton instance
    public static ThreadSafe getInstance(String[] role){
        
        // First check: Read the volatile field into a local variable
        // The usage of a local variable to avoid direct read of the memory so it can improve the method performance
        ThreadSafe result= instance;
        
        // Check if instance is null (not yet created)
        if(result == null){
        // Enter synchronized block only if instance is null
        //every thread in our application that try to access it have to wait thier turn to returning it
        synchronized(ThreadSafe.class){
            
            // Second check: Re-read the volatile field inside synchronized block
            // This prevents race conditions where another thread might have
            // created the instance between the first check and entering the synchronized block
            result= instance;
            
            // If instance is still null, create it
            if(result == null){ 
                // Create the singleton instance
                instance = new ThreadSafe(role) ;
            
                // Update local variable to point to the new instance
                result = instance;
            }
        }
        }
        
        // Return the singleton instance    
        return instance;
    }
    
     
}
