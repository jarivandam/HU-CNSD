import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class InverseStringController {
    public InverseStringController (StringInverterComponent inverter, WordCounterComponent wordCountComponent, WordCountRepository cache){
        this.inverter = inverter;
        this.cache = cache;
        this.wordCountComponent = wordCountComponent;
    }

    private StringInverterComponent inverter;
    private WordCounterComponent wordCountComponent;
    private WordCountRepository cache;

    public String invert(String value){
        return this.inverter.invert(value);
    }
    public Integer wordCount (String value){
        if (this.cache.wordExsists(value)) {
            return this.cache.wordValue(value);
        }
        else{
            Integer length = this.wordCountComponent.wordCount(value);
            this.cache.storeInCache(value,length);
            return length;
        }

    }
}
