/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kata5p2.view;

import Kata5p2.model.Mail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author ALberto del Rosario Déniz
 */
public class MailListReader {
    private final String fileName;

    public MailListReader(String fileName) {
        this.fileName = fileName;
    }
    
    public List<Mail> read(){
        List<Mail> list = new LinkedList<>();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(email->{
                if (pattern.matcher(email).matches()){
                    list.add(new Mail(email));
                }
            });
}       catch (IOException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

}
