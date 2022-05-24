import javax.swing.*; // for GUI interface
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class blueprint implements ActionListener
{
    public JFrame window;

    public JTextArea textArea;

    public JScrollPane scrollPane;

    public JMenuBar menuBar;

    public JMenu menuFile, menuEdit, menuFormat, menuColor;

    // for file menu
    public JMenuItem iNew, iSave, iSaveAs, iOpen, iClose;

    //for format menu
    JMenuItem iWrap, fontArial, fontTNR, fontComicSans, fontCalibri, fontGeorgia, fontCambria, fontRockwell, fontGaramond,
            fontCentury, fontConsolas, fontTahoma, fontConstantia;
    JMenuItem iSize8, iSize12, iSize16, iSize20, iSize24, iSize28, iSize36, iSize48, iSize72, iSize100, iSize125;
    JMenu iFont, iFontSize;
    boolean isWordWrapOn = false;

    // for color menu
    JMenuItem color1, color2, color3, color4, color5, color6, color7, color8, color9, color10, color11, color12;

    // for edit menu
    JMenuItem undo, redo;

    file_functions file = new file_functions(this);
    format_functions format = new format_functions(this);

    color_functions color = new color_functions(this);

    edit_functions edit = new edit_functions(this);

    keyboard_handler key = new keyboard_handler(this);

    UndoManager un = new UndoManager();

    public static void main(String[] args)
    {
        new blueprint();
    }

    public blueprint() // main GUI blueprint
    {
        generateWindow();
        window_panel wPanel = window_panel.getInstance();
        wPanel.windowProperties(window);
        generateTextArea();
        generateScrollBar();
        generateMenuBar();
        file();
        generateFormatMenu();
        generateColorMenu();
        generateEditMenu();


        window.setVisible(true); // makes the window visible so users are able to see it
        format.chosenFont = "Arial";
        format.generateFonts(16);
        color.setColor("Black");

    }

    public void generateWindow() // creates a window
    {
        window = new JFrame("Notepad--"); // program name
        //window.setSize(600, 500); // setting size
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // for appropriately closing our program
    }

    public void generateTextArea()
    {
        textArea = new JTextArea(); // will allow users to type in characters.
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener()
        {
            @Override
            public void undoableEditHappened(UndoableEditEvent e)
            {
                un.addEdit(e.getEdit());
            }
        });

        textArea.addKeyListener(key);
    }

    public void generateScrollBar() // generates a scroll bar that will be displayed horizontally AS NEEDED, and a vertical
    // one that will be displayed ALWAYS
    {
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, // uses textArea
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // deletes border which does not look aesthetically
        // pleasing.
        window.add(scrollPane);
    }

    public void generateMenuBar() // generates menu bar
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar); // will have four components: file, edit, format, and color

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }

    public void file()
    {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);


        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iClose = new JMenuItem("Close");
        iClose.addActionListener(this);
        iClose.setActionCommand("Close");
        menuFile.add(iClose);
    }

    public void generateFormatMenu()
    {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        iFont = new JMenu("Font");
        menuFormat.add(iFont);

        fontArial = new JMenuItem("Arial");
        fontArial.addActionListener(this);
        fontArial.setActionCommand("Arial");
        iFont.add(fontArial);

        fontCalibri = new JMenuItem("Calibri");
        fontCalibri.addActionListener(this);
        fontCalibri.setActionCommand("Calibri");
        iFont.add(fontCalibri);

        fontCambria = new JMenuItem("Cambria");
        fontCambria.addActionListener(this);
        fontCambria.setActionCommand("Cambria");
        iFont.add(fontCambria);

        fontGeorgia = new JMenuItem("Georgia");
        fontGeorgia.addActionListener(this);
        fontGeorgia.setActionCommand("Georgia");
        iFont.add(fontGeorgia);

        fontTNR = new JMenuItem("Times New Roman");
        fontTNR.addActionListener(this);
        fontTNR.setActionCommand("Times New Roman");
        iFont.add(fontTNR);

        fontComicSans = new JMenuItem("Comic Sans MS");
        fontComicSans.addActionListener(this);
        fontComicSans.setActionCommand("Comic Sans MS");
        iFont.add(fontComicSans);

        fontRockwell = new JMenuItem("Rockwell");
        fontRockwell.addActionListener(this);
        fontRockwell.setActionCommand("Rockwell");
        iFont.add(fontRockwell);

        fontGaramond = new JMenuItem("Garamond");
        fontGaramond.addActionListener(this);
        fontGaramond.setActionCommand("Garamond");
        iFont.add(fontGaramond);

        fontCentury = new JMenuItem("Century");
        fontCentury.addActionListener(this);
        fontCentury.setActionCommand("Century");
        iFont.add(fontCentury);

        fontConsolas = new JMenuItem("Consolas");
        fontConsolas.addActionListener(this);
        fontConsolas.setActionCommand("Consolas");
        iFont.add(fontConsolas);

        fontTahoma = new JMenuItem("Tahoma");
        fontTahoma.addActionListener(this);
        fontTahoma.setActionCommand("Tahoma");
        iFont.add(fontTahoma);

        fontConstantia = new JMenuItem("Constantia");
        fontConstantia.addActionListener(this);
        fontConstantia.setActionCommand("Constantia");
        iFont.add(fontConstantia);

        iFontSize = new JMenu("Font Size");
        menuFormat.add(iFontSize);

        iSize8 = new JMenuItem("8");
        iSize8.addActionListener(this);
        iSize8.setActionCommand("8");
        iFontSize.add(iSize8);

        iSize12 = new JMenuItem("12");
        iSize12.addActionListener(this);
        iSize12.setActionCommand("12");
        iFontSize.add(iSize12);

        iSize16 = new JMenuItem("16");
        iSize16.addActionListener(this);
        iSize16.setActionCommand("16");
        iFontSize.add(iSize16);

        iSize20 = new JMenuItem("20");
        iSize20.addActionListener(this);
        iSize20.setActionCommand("20");
        iFontSize.add(iSize20);

        iSize24 = new JMenuItem("24");
        iSize24.addActionListener(this);
        iSize24.setActionCommand("24");
        iFontSize.add(iSize24);

        iSize28 = new JMenuItem("28");
        iSize28.addActionListener(this);
        iSize28.setActionCommand("28");
        iFontSize.add(iSize28);

        iSize36 = new JMenuItem("36");
        iSize36.addActionListener(this);
        iSize36.setActionCommand("36");
        iFontSize.add(iSize36);

        iSize48 = new JMenuItem("48");
        iSize48.addActionListener(this);
        iSize48.setActionCommand("48");
        iFontSize.add(iSize48);

        iSize72 = new JMenuItem("72");
        iSize72.addActionListener(this);
        iSize72.setActionCommand("72");
        iFontSize.add(iSize72);

        iSize100 = new JMenuItem("100");
        iSize100.addActionListener(this);
        iSize100.setActionCommand("100");
        iFontSize.add(iSize100);

        iSize125 = new JMenuItem("125");
        iSize125.addActionListener(this);
        iSize125.setActionCommand("125");
        iFontSize.add(iSize125);
    }

    public void generateColorMenu()
    {
        color1 = new JMenuItem("Red");
        color1.addActionListener(this);
        color1.setActionCommand("Red");
        menuColor.add(color1);

        color2 = new JMenuItem("Blue");
        color2.addActionListener(this);
        color2.setActionCommand("Blue");
        menuColor.add(color2);

        color3 = new JMenuItem("Yellow");
        color3.addActionListener(this);
        color3.setActionCommand("Yellow");
        menuColor.add(color3);

        color4 = new JMenuItem("Pink");
        color4.addActionListener(this);
        color4.setActionCommand("Pink");
        menuColor.add(color4);

        color5 = new JMenuItem("Gray");
        color5.addActionListener(this);
        color5.setActionCommand("Gray");
        menuColor.add(color5);

        color6 = new JMenuItem("Cyan");
        color6.addActionListener(this);
        color6.setActionCommand("Cyan");
        menuColor.add(color6);

        color7 = new JMenuItem("Green");
        color7.addActionListener(this);
        color7.setActionCommand("Green");
        menuColor.add(color7);

        color8 = new JMenuItem("Black");
        color8.addActionListener(this);
        color8.setActionCommand("Black");
        menuColor.add(color8);

        color9 = new JMenuItem("Purple");
        color9.addActionListener(this);
        color9.setActionCommand("Purple");
        menuColor.add(color9);

        color10 = new JMenuItem("Brown");
        color10.addActionListener(this);
        color10.setActionCommand("Brown");
        menuColor.add(color10);

        color11 = new JMenuItem("Orange");
        color11.addActionListener(this);
        color11.setActionCommand("Orange");
        menuColor.add(color11);

        color12 = new JMenuItem("Gold");
        color12.addActionListener(this);
        color12.setActionCommand("Gold");
        menuColor.add(color12);
    }

    public void generateEditMenu()
    {
        undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        menuEdit.add(undo);

        redo = new JMenuItem("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        menuEdit.add(redo);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch(command)
        {
            case "New": file.setNewFile(); // if you click new, then the text on your screen will be deleted
                break;
            case "Open": file.open(); // if you click new, then the text on your screen will be deleted
                break;
            case "Save As": file.saveAs();
                break;
            case "Save": file.save();
                break;
            case "Close": file.close();
                break;
            case "Word Wrap": format.setWordWrap();
                break;
            case "8": format.generateFonts(8);
                break;
            case "12": format.generateFonts(12);;
                break;
            case "16": format.generateFonts(16);
                break;
            case "20": format.generateFonts(20);
                break;
            case "24": format.generateFonts(24);
                break;
            case "28": format.generateFonts(28);
                break;
            case "36": format.generateFonts(36);
                break;
            case "48": format.generateFonts(48);
                break;
            case "72": format.generateFonts(72);
                break;
            case "100": format.generateFonts(100);
                break;
            case "125": format.generateFonts(125);
                break;
            case "Arial":
            case "Calibri":
            case "Comic Sans MS":
            case "Cambria":
            case "Georgia":
            case "Times New Roman":
            case "Rockwell":
            case "Garamond":
            case "Century":
            case "Consolas":
            case "Tahoma":
            case "Constantia":
                format.setFont(command);
                break;
            case "Blue":
            case "Red":
            case "Yellow":
            case "Gray":
            case "Pink":
            case "Cyan":
            case "Green":
            case "Black":
            case "Purple":
            case "Brown":
            case "Orange":
            case "Gold":
                color.setColor(command);
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
        }
    }
}