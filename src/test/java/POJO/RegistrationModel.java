package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrationModel {
    private RegistrationDetailsModel registrationDetailsModel;
    private String registerError;


    public RegistrationModel() {
    }

    public RegistrationModel(String email) {
        this.registrationDetailsModel = new RegistrationDetailsModel(email);
        this.registerError = registerError;
    }

    public RegistrationDetailsModel getRegistrationDetailsModel() {
        return registrationDetailsModel;
    }

    @XmlElement
    public void setRegistrationDetailsModel(RegistrationDetailsModel registrationDetailsModel) {
        this.registrationDetailsModel = registrationDetailsModel;
    }

    public String getRegisterError() {
        return registerError;
    }

    @XmlElement
    public void setRegisterError(String registerError) {
        this.registerError = registerError;
    }

    @Override
    public String toString() {
        return "RegistrationModel: {" +
                "registrationDetailsModel: \n \t lastname: " + registrationDetailsModel.getEmail() +
                "\n }, \n registerError: " + registerError + "\n}";

    }
}

