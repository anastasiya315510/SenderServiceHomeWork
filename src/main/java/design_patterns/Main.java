package design_patterns;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        DistributionService distributionService= new DistributionService();
        while(true){
            try {
                distributionService.sendMail();
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
