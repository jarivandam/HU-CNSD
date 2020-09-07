import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class WordCountRepository {
    private Map<String,Integer> wordCountCache = new HashMap<String, Integer>();
    public Boolean wordExsists(String value){
            return wordCountCache.containsKey(value);
    }

        public Integer wordValue(String value){
            System.out.println("Cache hit");
            return wordCountCache.get(value);
        }

        public void storeInCache(String value,Integer length){
            wordCountCache.put(value,length);
        }

}
