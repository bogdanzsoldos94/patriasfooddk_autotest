package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {
    private AccountModel account;
    private String loginErr;

    public LoginModel() {
    }


    public AccountModel getAccount() {
        return account;
    }

    @XmlElement
    public void setAccount(AccountModel account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "LoginModel value: {\n" +
                "account:{\nusername" + account.getUsername() + ",\n password=" + account.getPassword() +
                "\n}, \n loginErr='" + loginErr + '\n' +
                '}';
    }
}
