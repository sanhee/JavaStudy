package annotation.normal;

import java.util.List;

public class PasswordUtils {

    @CustomAnnotation(id = 47, description = "password must contatin at leat one numberic!!!")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @CustomAnnotation(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @CustomAnnotation(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
