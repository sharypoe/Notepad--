import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard_handler implements KeyListener
{
    blueprint blue_print;

    public keyboard_handler(blueprint blue_print)
    {
        this.blue_print = blue_print;
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            blue_print.file.save();
        }

        else if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S)
        {
            blue_print.file.saveAs();
        }

        else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F)
        {
            blue_print.menuFile.doClick();
        }

        else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_E)
        {
            blue_print.menuEdit.doClick();
        }

        else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_C)
        {
            blue_print.menuColor.doClick();

        }
        else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_R)
        {
            blue_print.menuFormat.doClick();
        }

        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z)
        {
            blue_print.edit.undo();
        }

        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y)
        {
            blue_print.edit.redo();
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
