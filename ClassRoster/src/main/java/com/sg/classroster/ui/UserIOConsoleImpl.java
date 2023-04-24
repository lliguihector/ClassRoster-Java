/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import java.util.Scanner;

/**
 *
 * @author hectorlliguichuzca
 */
public class UserIOConsoleImpl implements UserIO {

    
    Scanner scanner = new Scanner(System.in);
    
    
    
    
    @Override
    public void print(String msg) { 
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        
      
   return 3;           
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        
           return 3;   
    }

    @Override
    public float readFloat(String prompt) {
        
    return 3;        
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        
        
        return 2;
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return Integer.parseInt(input);

    }

    @Override
    public int readInt(String prompt, int min, int max) {
        
        return 2;
    }

    @Override
    public long readLong(String prompt) {
        return 2;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        
        return 2;
    }

    @Override
    public String readString(String prompt) {
        
        print(prompt);
        Scanner sc = new Scanner(System.in);
        return  sc.nextLine();
    }
    
    
    
}
