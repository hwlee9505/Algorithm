package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        boolean isRight = new PhoneNumberList().solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(isRight);
        isRight = new PhoneNumberList().solution(new String[]{"123","456","789"});
        System.out.println(isRight);
        isRight = new PhoneNumberList().solution(new String[]{"12","123","1235","567","88"});
        System.out.println(isRight);
        isRight = new PhoneNumberList().solution(new String[]{"1234", "1235", "567"});
        System.out.println(isRight);
    }
}

/**
 *
 */
public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j]))
                    return (false);
                if (phone_book[j].startsWith(phone_book[i]))
                    return (false);
            }
        }
        return (true);
    }
}
