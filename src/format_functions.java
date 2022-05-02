import javax.swing.*;
import java.awt.*;

public class format_functions
{
    blueprint blue_print;
    Font Arial, ComicSansMS, TimesNewRoman, Calibri, Georgia, Cambria, Rockwell;
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
        }
    }
}
