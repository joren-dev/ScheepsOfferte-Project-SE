package managers;


import java.io.*;

public class FileManager implements Serializable{

    public void exportFile(String file_name, Object export){
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(export);
            out.close();

            fileOut.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
          }
    }

    public Object importFile(String file_name){
        Object fileImport;
        try{
            FileInputStream fileIn = new FileInputStream(file_name);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            fileImport = in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return fileImport;
    }

}
