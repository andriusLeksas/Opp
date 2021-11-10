package NotYetDone.inProgress.flyWeightPattern;

import java.io.IOException;
import java.util.HashMap;

public class ImageFactory {

    // Uncomment the compiler directive line and
    // javac *.java will compile properly.
    // @SuppressWarnings("unchecked")
    private static final HashMap pathMap = new HashMap();

    public static Shape getImage(String path) {
        drawImage image = (drawImage) pathMap.get(path);

        if (image == null) {
            try {
                image = new drawImage(path);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         pathMap.put(path, image);
         //System.out.println("Creating image of path : " + path);
      }
      return image;
   }
}
