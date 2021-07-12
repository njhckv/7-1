import java.io.FileNotFoundException;

interface FileIO
{
    public abstract void saveFile(String a_fileName)
            throws FileNotFoundException;
    public abstract void loadFile(String a_fileName)
            throws FileNotFoundException;
}