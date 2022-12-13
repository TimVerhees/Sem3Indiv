package sem3indiv.logic.impl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageGetter {
    public static void main(String[] args) throws Exception {
        String imageUrl = "https://images.ygoprodeck.com/images/cards/72302403.jpg";
        String destinationFile = "C:\\Users\\timve\\Desktop\\Fontys\\Sem3\\Individuele opdracht\\git\\front-end-indiv-app\\src\\images\\Swords of Revealing Light.jpg";

        saveImage(imageUrl, destinationFile);
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }



}
