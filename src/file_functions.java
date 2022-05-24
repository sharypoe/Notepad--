import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class file_functions
{
    blueprint blue_print;
    String fileName;
    String fileAddress;

    public file_functions(blueprint blue_print)
    {
        this.blue_print = blue_print;
    }

    public void setNewFile()
    {
        blue_print.textArea.setText(""); // erases current text
        blue_print.window.setTitle("Notepad--");
        fileName = null; // need to reset these values
        fileAddress = null;
    }

    public void open()
    {
        FileDialog fd = new FileDialog(blue_print.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        // if statement to see if there are contents in the file

        if (fd.getFile() != null )
        {
            fileName = fd.getFile();
            fileAddress =fd.getDirectory();
            blue_print.window.setTitle(fileName + " - Notepad--");
        }

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            blue_print.textArea.setText(""); // clearing previous text
            String holder = null;

            while((holder = br.readLine()) != null)
            {
                blue_print.textArea.append(holder + "\n");
            }

            br.close();
        }
        catch(Exception e)
        {
            System.out.println("File cannot be accessed. Please try again.");
        }
    }

    public void save()
    {
        if(fileName == null) // when we have a new file and have yet to save it
        {
            saveAs();
        }
        else // if I am overwriting a file
        {
            try
            {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(blue_print.textArea.getText());
                blue_print.window.setTitle(fileName + " - Notepad--");
                fw.close();

            } catch (Exception e)
            {
                System.out.println("Something went wrong. Please try again");
            }
        }
    }

    public void saveAs()
    {
        FileDialog fd = new FileDialog(blue_print.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress =fd.getDirectory();
            blue_print.window.setTitle(fileName + " - Notepad--");
        }
        try
        {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(blue_print.textArea.getText());
            fw.close();
        }catch(Exception e){
            System.out.println("Something went wrong. Please try again");
        }
    }

    public void close()
    {
        System.exit(0);
    }
}