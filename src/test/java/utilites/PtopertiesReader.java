package utilites;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PtopertiesReader {
    private static FileInputStream fileInputStream;
    private static Properties property = new Properties();
    private static Logger LOG = Logger.getLogger(PtopertiesReader.class);

    public static String getValueProperty(String propertyKey, String propertyURL){
        if(propertyURL != null && new File(propertyURL).exists()){
          try{
              fileInputStream = new FileInputStream(propertyURL);
              LOG.debug("Property PATH: " + propertyURL);
              property.load(fileInputStream);
          }catch (IOException e){
              LOG.error("Properties file not found", e);
              e.printStackTrace();
          }
          return property.getProperty(propertyKey);
        }else {
            return null;
        }
    }
}
