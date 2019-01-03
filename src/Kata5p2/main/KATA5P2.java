package Kata5p2.main;

import Kata5p2.model.Histogram;
import Kata5p2.model.Mail;
import Kata5p2.view.HistogramDisplay;
import Kata5p2.view.MailHistogramBuilder;
import Kata5p2.view.MailListReaderDB;
import java.util.List;

public class KATA5P2 {
    
    private List<Mail> mailList;
    private Histogram<String> histogram;
    
    public static void main(String[] args) {
        KATA5P2 kata = new KATA5P2();
        kata.control();
    }
    private void control(){
        input();
        process();
        output();
    }
    
    private void input(){
        MailListReaderDB reader = new MailListReaderDB();
        mailList = reader.read();
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        new HistogramDisplay(histogram).execute();
    }
}
