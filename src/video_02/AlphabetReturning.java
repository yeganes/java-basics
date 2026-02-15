package video_02;
//پرینت a-z یکی درمیون
public class AlphabetReturning {
    public static void main(String[] args){

//با استفاده از اسکی کد موجود برای هر کاراکتر انرا یکی درمیون پرینت میکنیم
        for(int i = 65;  i <= 90 ; i++){
            char asciivalue = (char) i;
            if (i % 2 == 1){
            System.out.println(asciivalue);

            }
        }
    }
}



