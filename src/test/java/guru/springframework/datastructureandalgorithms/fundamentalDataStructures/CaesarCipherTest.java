package guru.springframework.datastructureandalgorithms.fundamentalDataStructures;

import org.junit.Test;

//test[Feature being tested]: This one makes it easy to read the test as the feature to be tested is written as part of test name. Although, there are arguments that the “test” prefix is redundant. However, some sections of developer love to use this technique. Following is how the above tests would read like if named using this technique:
// testIsNotAnAdultIfAgeLessThan18
// testFailToWithdrawMoneyIfAccountIsInvalid
// testStudentIsNotAdmittedIfMandatoryFieldsAreMissing
//https://dzone.com/articles/7-popular-unit-test-naming
//https://www.vogella.com/tutorials/JUnit/article.html
public class CaesarCipherTest {

    @Test
    public void shouldReturnsCipherEncodeWhenEncryptCode() {
        CaesarCipher cipher = new CaesarCipher(1);
        System.out.println("Encryption code" + new String(cipher.encoder));
        System.out.println("Decryption code" + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }
}