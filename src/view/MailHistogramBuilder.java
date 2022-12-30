package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build (List<Mail> emails){
        Histogram<String> mails = new Histogram<String>();
        for (Mail mail1: emails){
            mails.increment(mail1.getDomain());
        }
        return mails;
    }
}