package model;

public class Mail {
    private final String mail;
    
    public Mail(String mail){
        this.mail= mail;
    }
    public String getDomain(){
        String[] split = mail.split("@");
        return split[1];
    }
}
