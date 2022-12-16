package sem3indiv.logic.impl;

import java.io.*;
import java.net.URL;
import java.util.Map;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

public class ImageGetter {

    public static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dz6wz2wfd",
            "api_key", "417581682995282",
            "api_secret", "M2bMr5MPcG7WXzqsFPJii-lr-oo"));

    public static void main(String[] args) {
        String imageUrl = "https://images.ygoprodeck.com/images/cards/20366275.jpg";
        String imageName = "El Shaddoll Construct";
        String destinationFile = "C:\\Users\\timve\\Desktop\\Fontys\\Sem3\\Individuele opdracht\\git\\front-end-indiv-app\\src\\images\\" + imageName + ".jpg";
        try {
            UploadImage(imageUrl, imageName);
        } catch (Exception e) {
            System.out.println("Failed to get Image");
        }
    }
        public static void UploadImage (String imageUrl, String imageName) throws IOException {
            cloudinary.uploader().upload((imageUrl),
                    ObjectUtils.asMap("public_id", imageName));
        }

}
