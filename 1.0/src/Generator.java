import java.io.*;

public class Generator
{
    private final String FOUR_DIGIT_FILE_NAME = "4_digit_password_dic.txt";
    private final String SIX_DIGIT_FILE_NAME = "6_digit_password_dic.txt";

    public boolean cleanFiles() throws FileNotFoundException
    {
        File fourDigitFile = new File(FOUR_DIGIT_FILE_NAME);
        File sixDigitFile = new File(SIX_DIGIT_FILE_NAME);

        PrintWriter fourDigitCleaner = new PrintWriter(fourDigitFile);
        PrintWriter sixDigitCleaner = new PrintWriter(fourDigitFile);

        if(fourDigitFile.exists())
            fourDigitCleaner.print("");

        if(sixDigitFile.exists())
            sixDigitCleaner.print("");

        return true;
    }

    public void writeToFile(String data, String name)
    {
        try
        {
            File file = new File(name);
            FileOutputStream writer = new FileOutputStream(file, true);

            writer.write(data.getBytes());
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean fourDigitGenerate()
    {
        String password = "";

        for(int a = 0; a < 10; a++)
        {
            for(int b = 0; b < 10; b++)
            {
                for(int c = 0; c < 10; c++)
                {
                    for(int d = 0; d < 10; d++)
                    {
                        password =  String.format("%d%d%d%d%s", a, b, c, d, "\n");
                        writeToFile(password, FOUR_DIGIT_FILE_NAME);
                    }
                }
            }
        }

        return true;
    }

    public boolean sixDigitGenerate()
    {
        String password = "";

        for(int a = 0; a < 10; a++)
        {
            for(int b = 0; b < 10; b++)
            {
                for(int c = 0; c < 10; c++)
                {
                    for(int d = 0; d < 10; d++)
                    {
                        for(int e = 0; e < 10; e++)
                        {
                            for(int f = 0; f < 10; f++)
                            {
                                password = String.format("%d%d%d%d%d%d%s", a, b, c, d, e, f, "\n");
                                writeToFile(password, SIX_DIGIT_FILE_NAME);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        Generator generatorObj = new Generator();

        try
        {
            if(generatorObj.cleanFiles())
            {
                if(generatorObj.fourDigitGenerate())
                {
                    System.out.println("4 Digit passwords successfully generated and written to the file!");
                }

                if(generatorObj.sixDigitGenerate())
                {
                    System.out.println("6 Digit passwords successfully generated and written to the file!");
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There's been an error!");
            e.printStackTrace();
        }
    }
}
