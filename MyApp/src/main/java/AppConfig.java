import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Bean
    @Profile("Invert")
        public StringInverterComponent stringInverterComponent(){
            return new StringInverterComponent();
    }
    @Bean
    @Profile("CAPS")
    public AllCapsComponent allCapsComponent(){
        return new AllCapsComponent();
    }


    @Bean
    public WordCountRepository wordCountRepository(){
        return new WordCountRepository();
    }

    @Bean
    public WordCounterComponent wordCounterComponent(){
        return new WordCounterComponent();
    }
}


