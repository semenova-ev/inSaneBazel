package build;

import abc.build.Generated2;

public class UsesGeneratedCode {
    public static String getMessage() {
        return Generated1.getGeneratedMessage() + Generated2.getGeneratedMessage();
    }
}
