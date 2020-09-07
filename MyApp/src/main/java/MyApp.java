import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StringInverterComponent inverter = context.getBean(StringInverterComponent.class);
        WordCounterComponent wordCounter = context.getBean(WordCounterComponent.class);
        WordCountRepository cache = context.getBean(WordCountRepository.class);

        InverseStringController inverterController = new InverseStringController(inverter,wordCounter,cache);

        System.out.println(inverterController.invert("Hello"));
        System.out.println(inverterController.wordCount("Hello world this is a test"));
        System.out.println(inverterController.wordCount("Hello world"));
        System.out.println(inverterController.wordCount("Hello world"));
        System.out.println(inverterController.wordCount("Hello world this is a test"));

    }
}
