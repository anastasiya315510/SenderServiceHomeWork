package design_patterns.service;

import design_patterns.MailGenerator;

@TempleCode(1)
public class WelcomeMailGeneratorGenarator implements MailGenerator {
    @Override
    public String genarateMail() {
        return "<HTML>Welcome to our Company</HTML>";
    }
}
