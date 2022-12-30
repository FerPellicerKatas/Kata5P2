package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {
    public static List<Mail> read(String fileName) throws IOException{
        String cadena;
        List<Mail> emails = new ArrayList();
        
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!= null) {
            if(cadena.contains("@")){
                emails.add(new Mail(cadena));
            }
        }
        b.close();
        return emails;
    }
}
