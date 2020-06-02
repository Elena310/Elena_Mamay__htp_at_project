package utilites;

import java.io.File;
import java.util.Objects;

public class ResourceHelper {
    public static File getFile(String path) {
        File file = new File((Objects.requireNonNull(ResourceHelper.class.getClassLoader()
                .getResource(path))).getFile());
        return file;
    }
}
