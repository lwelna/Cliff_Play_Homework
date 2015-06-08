package model;

import play.data.validation.Constraints;

public class LoginInfo {
    @Constraints.Required(message="Requires Input To Login. Try Again.")
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String input) {
        this.loginName = input;
    }
}
