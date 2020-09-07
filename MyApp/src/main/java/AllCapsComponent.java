import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AllCapsComponent {
    public String invert(String value){
        ArrayList<Character> result = new ArrayList<Character>();
        for (char c: value.toCharArray()){
            result.add(Character.toUpperCase(c));
        }
        return result.toString();
    }
}