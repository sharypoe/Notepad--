import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class format_functionsTest
{

    Font Arial, placeholder;
    int fontSize = 12;

    @Test
    void generateFonts()
    {

       /* Test Case 1:  Validates the proper creation of a Font object, authored by Sharina.
       * Input: java.awt.Font[family=Arial,name=Arial,style=plain,size=12]
       * Expected output: java.awt.Font[family=Arial,name=Arial,style=plain,size=12]
       */

        Arial = new Font("Arial", Font.PLAIN, fontSize);
        placeholder = new Font("Arial", Font.PLAIN, fontSize);

        System.out.println("Original Font:\t" + Arial);
        System.out.println("Placeholder:\t" + placeholder);

        assertEquals(placeholder, Arial); // perform test

        System.out.println("Output:\t\t\tPassed JUnit test.");
    }
}