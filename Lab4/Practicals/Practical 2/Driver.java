import java.util.Scanner;

public class Driver{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] logs =
        {
        "10:05 alice Hello there",
        "10:10 bob How are you?",
        "InvalidLine"
        };

        System.out.println("Enter A Word : ");
        String word = sc.next();

        String result = ChatFilter.filter(logs, word);
        System.out.println(" ");
        System.out.println(result);

        sc.close();
    }
}