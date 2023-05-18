package question4153;

import java.io.*;

public class Serialisator {
    final static String FILE_NAME = "File.dat";

    public static void serialize(Object object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // проверяется маркер Serializable
        objectOutputStream.writeObject(object);

        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();

        objectInputStream.close();

        return object;
    }
}

