package build;

import build.Generated;

public class UsesGeneratedCode {
    public static String getMessage() {
        return Generated.getGeneratedMessage();
    }
}
