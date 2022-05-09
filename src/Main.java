import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.Base64;

public class Main {
  public static void main(String[] args) throws Exception {
//    System.out.println(encodeImage(
//      "C:\\Users\\ycanchar\\Documents\\intellij\\ImageManagement\\src\\paisaje.jpg",
//      "C:\\Users\\ycanchar\\Documents\\intellij\\ImageManagement\\src\\paisaje.txt"));
    decodeImg("C:\\Users\\ycanchar\\Documents\\intellij\\ImageManagement\\src\\paisaje.txt", "C:\\Users\\ycanchar\\Documents\\intellij\\ImageManagement\\src\\paisajemodificado.jpg");
  }

  private static String encodeImage(String imgPath, String savePath) throws Exception {
    FileInputStream imageStream = new FileInputStream(imgPath);
    byte[] data = imageStream.readAllBytes();
    String imageString = Base64.getEncoder().encodeToString(data);
    FileWriter fileWriter = new FileWriter(savePath);
    fileWriter.write(imageString);
    fileWriter.close();
    imageStream.close();
    return imageString;
  }
  private static void decodeImg(String textPath, String savePath) throws Exception{
    FileInputStream inputStream = new FileInputStream(textPath);
    byte [] data = Base64.getDecoder().decode(new String(inputStream.readAllBytes()));
    FileOutputStream fileOutputStream = new FileOutputStream(savePath);
    fileOutputStream.write(data);
    fileOutputStream.close();
    inputStream.close();
  }
}
