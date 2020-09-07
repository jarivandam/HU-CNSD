public class WordCounterComponent {
    public Integer wordCount(String text){
        Integer result = 1;
        for (int i =0; i< text.length(); i++){
            if (text.charAt(i) == ' '){
                result +=1 ;
            }
        }
        return result;
    }
}
