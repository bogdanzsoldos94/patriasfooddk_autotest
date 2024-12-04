package POJO;

import jakarta.xml.bind.annotation.XmlElement;

public class RegistrationDetailsModel {
    private String email;


    public RegistrationDetailsModel(String lastname) {

        this.email = email;

    }
    @XmlElement
    public String getEmail() {
        return email;
    }



    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }


    }

