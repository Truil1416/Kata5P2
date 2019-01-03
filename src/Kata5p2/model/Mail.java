/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kata5p2.model;

import java.util.regex.Pattern;

/**
 *
 * @author ALberto del Rosario Déniz
 */
public class Mail {
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain(){
        
        return mail.substring(mail.indexOf("@") + 1);
    }
    
    public boolean isValidAddress(){
        Pattern pat = 
                Pattern.compile("^(.+)@(.+)$");
        return pat.matcher(mail).matches();
    }
}
