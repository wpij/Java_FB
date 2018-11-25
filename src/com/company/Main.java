package com.company;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class Main {

    public static final String ACCOUNT_SID =
            "ACb804d755ac277f51b057277f5a807cff";
    public static final String AUTH_TOKEN =
            "fa99fc3cddbe06d99c92fe1511f99db5";


    public static void main(String[] args) throws IOException {

        try {
            while (true) {

                Document doc = Jsoup.connect("https://www.facebook.com/Brasserie-Cantillon-110627652322553/").get();

                String pomoc = doc.toString();

                System.out.println(doc);

                if (pomoc.contains("www.billetweb.fr")

                   )
                       {

                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

                    Message message = Message
                            .creator(new PhoneNumber("+48605990790"), // to
                                    new PhoneNumber("+48732483799"), // from
                                    "!!!! JEST SPRZEDAZ W CANTILLON !!!!!")
                            .create();

                    System.out.println(message.getSid());

                    System.out.println(" !!!! JEST SPRZEDAZ !!!!! ");
                } else {
                    System.out.println("NIE MA SPRZEDAZY :(  ");
                }
                Thread.sleep(60000);
            }
        } catch (InterruptedException ex) {
            System.out.println("test");
        }

    }

}