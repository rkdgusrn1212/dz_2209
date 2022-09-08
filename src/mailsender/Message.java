package mailsender;

import java.io.Serializable;

public class Message implements Serializable {
    public String receiverEmail;
    public String subject;
    public String msg;
}
