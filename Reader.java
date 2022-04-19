import java.io.BufferedReader;
import java.io.FileReader;

public class Reader 
{
    public static String reader(String path){
        String data = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int i;
            while((i = reader.read()) != -1){
                data += (char)i;
            }
            return data;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "File is empty!");
            System.out.println("File is empty !");
            return null;
        }
    }
    
    public static boolean isEmpty(String path)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            if (reader.readLine() == null) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "File is empty!");
            System.out.println("File is empty !");
            Writer.import_data(path, null);
            return true;
        }
    }
    
    
}
