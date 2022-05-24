import javax.swing.*;
import java.awt.*;

public class format_functions
{
    blueprint blue_print;
    Font Arial, ComicSansMS, TimesNewRoman, Calibri, Georgia, Cambria, Rockwell, Garamond, Century, Consolas, Tahoma, Constantia;
    String chosenFont;

    public format_functions(blueprint blue_print)
    {
        this.blue_print = blue_print;
    }

    public void setWordWrap()
    {
        // determine whether wordwrap is on or off

        if(blue_print.isWordWrapOn == false)
        {
            blue_print.isWordWrapOn = true;
            blue_print.textArea.setLineWrap(true);
            blue_print.textArea.setWrapStyleWord(true);
            blue_print.iWrap.setText("Word Wrap: On");
        }
        else if (blue_print.isWordWrapOn == true)
        {
            blue_print.isWordWrapOn = false;
            blue_print.textArea.setLineWrap(false);
            blue_print.textArea.setWrapStyleWord(false);
            blue_print.iWrap.setText("Word Wrap: Off");
        }
    }

    public void generateFonts(int fontSize)
    {
        // I might add more fonts in the future
        Arial = new Font("Arial", Font.PLAIN, fontSize);
        ComicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        Calibri = new Font("Calibri", Font.PLAIN, fontSize);
        Georgia = new Font("Georgia", Font.PLAIN, fontSize);
        Cambria = new Font("Cambria", Font.PLAIN, fontSize);
        TimesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        Rockwell = new Font("Rockwell", Font.PLAIN, fontSize);
        Garamond = new Font("Garamond", Font.PLAIN, fontSize);
        Century = new Font("Century", Font.PLAIN, fontSize);
        Consolas = new Font("Consolas", Font.PLAIN, fontSize);
        Tahoma = new Font("Tahoma", Font.PLAIN, fontSize);
        Constantia = new Font("Constantia", Font.PLAIN, fontSize);
        setFont(chosenFont);
    }

    public void setFont(String font)
    {
        chosenFont = font;

        switch(chosenFont)
        {
            case"Arial":
                blue_print.textArea.setFont(Arial);
                break;
            case"Comic Sans MS":
                blue_print.textArea.setFont(ComicSansMS);
                break;
            case"Calibri":
                blue_print.textArea.setFont(Calibri);
                break;
            case"Georgia":
                blue_print.textArea.setFont(Georgia);
                break;
            case"Cambria":
                blue_print.textArea.setFont(Cambria);
                break;
            case"Times New Roman":
                blue_print.textArea.setFont(TimesNewRoman);
                break;
            case"Rockwell":
                blue_print.textArea.setFont(Rockwell);
                break;
            case"Garamond":
                blue_print.textArea.setFont(Garamond);
                break;
            case"Century":
                blue_print.textArea.setFont(Century);
                break;
            case"Consolas":
                blue_print.textArea.setFont(Consolas);
                break;
            case"Tahoma":
                blue_print.textArea.setFont(Tahoma);
                break;
            case"Constantia":
                blue_print.textArea.setFont(Constantia);
                break;
        }
    }
}
