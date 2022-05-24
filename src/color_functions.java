import java.awt.*;

public class color_functions
{
    blueprint blue_print;

    public color_functions(blueprint blue_print)
    {
        this.blue_print = blue_print;
    }

    public void setColor(String color)
    {
        switch(color)
        {
            case"Red":
                blue_print.textArea.setForeground(Color.RED);
                break;
            case"Blue":
                blue_print.textArea.setForeground(Color.BLUE);
                break;
            case"Pink":
                blue_print.textArea.setForeground(Color.PINK);
                break;
            case"Yellow":
                blue_print.textArea.setForeground(Color.YELLOW);
                break;
            case"Gray":
                blue_print.textArea.setForeground(Color.lightGray);
                break;
            case"Green":
                blue_print.textArea.setForeground(Color.GREEN);
                break;
            case"Cyan":
                blue_print.textArea.setForeground(Color.CYAN);
                break;
            case"Black":
                blue_print.textArea.setForeground(Color.BLACK);
                break;
            case"Purple":
                blue_print.textArea.setForeground(new Color(134, 69, 211 ));
                break;
            case"Brown":
                blue_print.textArea.setForeground(new Color(112, 61, 11));
                break;
            case"Orange":
                blue_print.textArea.setForeground(new Color(239, 117, 5));
                break;
            case"Gold":
                blue_print.textArea.setForeground(new Color(210, 154, 22));
                break;
        }
    }
}
