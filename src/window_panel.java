import javax.swing.*;

public class window_panel
{
    private static window_panel windowPanel;

    private window_panel()
    {

    }

    public static window_panel getInstance()
    {
        if (windowPanel == null)
        {
            windowPanel = new window_panel();
        }

        return windowPanel;
    }


    public void windowProperties(JFrame window) // creates a window
    {
        window.setSize(600, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
