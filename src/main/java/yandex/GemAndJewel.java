package yandex;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** The type GemAndJewel */
public class GemAndJewel {

    @SneakyThrows
    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String jewels = r.readLine();
        String gems = r.readLine();

        int[] bank = new int[26];
        int jewelBank = 0;

        for (char gem : gems.toCharArray()) {
            bank[gem - 'a']++;
        }

        for (char jewel : jewels.toCharArray()) {
            jewelBank += bank[jewel - 'a'];
        }

        System.out.println(jewelBank);
    }
}
