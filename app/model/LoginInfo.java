package model;

import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;

public class LoginInfo {
    @Constraints.Required(message="Requires Input To Login. Try Again.")
    @MaxLength(value = 255)
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String input) {
        this.loginName = input;
    }
}
