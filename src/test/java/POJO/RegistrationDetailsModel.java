package POJO;

import jakarta.xml.bind.annotation.XmlElement;

public class RegistrationDetailsModel {
    private String email;

    public RegistrationDetailsModel() {
    }

    public RegistrationDetailsModel(String email) {
        this.email = email;
    }

    @XmlElement // Only apply the annotation here
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}