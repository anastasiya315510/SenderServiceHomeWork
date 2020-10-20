package design_patterns.service;

import design_patterns.MailGenerator;

@TempleCode(3)
public class GoodByGenaration implements MailGenerator {
    @Override
    public String genarateMail() {
        return "Good by my love";
    }
}
