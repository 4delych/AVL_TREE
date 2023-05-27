import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

public class NewFile {
    public static void main(String[] args) throws IOException {
        File file = new File("src/file.txt");
        try{
            int max= 1000;
            int min = 1;
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < 10000; i++){
                writer.write((int) ((Math.random()*((max-min)+1))+min) + "\n");
            }
            writer.close();
        }catch (IOException e){
            throw new RuntimeException();
        }

    }
}
