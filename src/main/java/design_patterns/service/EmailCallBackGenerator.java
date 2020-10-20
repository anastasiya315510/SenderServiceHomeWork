package design_patterns.service;

import design_patterns.MailGenerator;

@TempleCode(2)
public class EmailCallBackGenerator implements MailGenerator {
    @Override
    public String genarateMail() {
        return "<HTML>Dont Call us</HTML>";
    }
}
