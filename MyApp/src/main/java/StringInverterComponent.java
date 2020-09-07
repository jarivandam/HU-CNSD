import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StringInverterComponent {
    public String invert(String value){
        ArrayList<Character> invertedString = new ArrayList<Character>();
        for (int i =1 ; i<value.length() + 1; i++){
            invertedString.add(value.charAt(value.length()-i));
        }
        return invertedString.toString();
    }
}
