import java.util.HashMap;
import java.util.function.Supplier;

public class FizzBuzz {
    public static String sayFizz() {
        return "Fizz";
    }

    public static String sayBuzz() {
        return "Buzz";
    }

    public static void main(String[] args){
        int[] numbers = new int[100];
        for (int i = 0; i<100; i++){
            numbers[i]=i+1;
        }

        HashMap<Integer, Supplier<String>> talkers = new HashMap();
        talkers.put(0, FizzBuzz::sayFizz);
        talkers.put(3, FizzBuzz::sayBuzz);

        StringBuilder outputString = new StringBuilder();

        for (int number: numbers){
            outputString.append(" ");
            int mod3 = number % 3;
            int mod5 = number % 5 + 3;
            try {
                outputString.append(talkers.get(mod3).get());
                outputString.append(talkers.get(mod5).get());
            } catch (NullPointerException exc1) {
                try {
                    talkers.get(mod3).get();
                } catch (NullPointerException exc2) {
                    try {
                        outputString.append(talkers.get(mod5).get());
                    } catch (NullPointerException exc3) {
                        outputString.append(number);
                    }
                }
            }
        }

        System.out.println(outputString);
    }
}
