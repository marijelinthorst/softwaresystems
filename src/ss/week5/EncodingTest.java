package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";
        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        char[] bytearray = "4d6f64756c652032".toCharArray();       
        System.out.println(new String(Hex.decodeHex(bytearray)));
        
        
       // Base 64
        String input2 = "Hello World";
        System.out.println(Base64.encodeBase64String(input2.getBytes()));
        
        char[] bytearray2 = "0102030406".toCharArray();
        String news = new String(Hex.decodeHex(bytearray2));
        System.out.println(Base64.encodeBase64String(news.getBytes()));
        
        String bytearray3 = "U29mdHdhcmUgU3lzdGVtcw==";      
        System.out.println(new String(Base64.decodeBase64(bytearray3)));
        
        String one = "a";
        String two = "aa";
        String three = "aaa";
        String four = "aaaa";
        String five = "aaaaa";
        System.out.println(Base64.encodeBase64String(one.getBytes()));
        System.out.println(Base64.encodeBase64String(two.getBytes()));
        System.out.println(Base64.encodeBase64String(three.getBytes()));
        System.out.println(Base64.encodeBase64String(four.getBytes()));
        System.out.println(Base64.encodeBase64String(five.getBytes()));
        
    }
}
