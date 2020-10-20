package design_patterns;

import design_patterns.service.TempleCode;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DistributionService {
    private Map<Integer,MailGenerator> map = new HashMap<>();
    public static int getAnnotation(Class<? extends MailGenerator> aClass){
        return aClass.getAnnotation(TempleCode.class).value();
    }
    @SneakyThrows
    public static MailGenerator genarate(Class<? extends MailGenerator>aClass){
        return aClass.getDeclaredConstructor().newInstance();
    }

    @SneakyThrows
    public DistributionService() {
        Reflections scanner = new Reflections("design_patterns");
        Set<Class<? extends MailGenerator>> set = scanner.getSubTypesOf(MailGenerator.class);
       map =set.stream()
                .filter(cl -> !Modifier.isAbstract(cl.getModifiers()))
                .filter(cl -> cl.isAnnotationPresent(TempleCode.class))
                .collect(Collectors.toMap(DistributionService::getAnnotation, DistributionService::genarate ));


    }

    public void sendMail(){
        int mailCode = DBUtils.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
        if(mailGenerator== null){
            throw new UnsupportedOperationException(mailCode+ " not supported yet");
        }
        String html = mailGenerator.genarateMail();
        send(html);
    }

    private void send(String html) {
        System.out.println("html "+html);
    }
}
