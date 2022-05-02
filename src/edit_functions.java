public class edit_functions
{
    blueprint blue_print;

    public edit_functions(blueprint blue_print)
    {
       this.blue_print = blue_print;
    }

    public void undo()
    {
        blue_print.un.undo();
    }

    public void redo()
    {
        blue_print.un.redo();
    }
}
