import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class save {
    private String filename = "save number.txt";
    private ArrayList<String> dataArr = new ArrayList<>();
    private String number;

    public String getNumber() {
        if (dataArr.isEmpty()) {
            return null;
        }
        return dataArr.get(0);
    }

    public void setNumber(String number) {
        this.number = number;
        if (dataArr.isEmpty()) {
            dataArr.add(this.number);
        } else {
            dataArr.set(0, this.number);
        }
    }

    public boolean open() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dataArr = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            return true;  // File doesn't exist or is corrupted, return true to create a new file
        }
        return false;
    }

    public void close() {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dataArr);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        dataArr.add("1");
    }
}
