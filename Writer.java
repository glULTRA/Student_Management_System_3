import java.io.FileOutputStream;

public class Writer {
    
    public static void import_data(String path, String data)
    {
        FileOutputStream ofile = null;
        try {
            ofile = new FileOutputStream(path, true);
            ofile.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                ofile.flush();
                ofile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void clear_data(String path){
        FileOutputStream ofile = null;
        try {
            ofile = new FileOutputStream(path, false);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                ofile.flush();
                ofile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
