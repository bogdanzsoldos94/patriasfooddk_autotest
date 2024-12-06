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
    }

    @XmlElement // Only apply the annotation here
    public RegistrationDetailsModel getRegistrationDetailsModel() {
        return registrationDetailsModel;
    }

    public void setRegistrationDetailsModel(RegistrationDetailsModel registrationDetailsModel) {
        this.registrationDetailsModel = registrationDetailsModel;
    }

    @XmlElement // Only apply the annotation here
    public String getRegisterError() {
        return registerError;
    }

    public void setRegisterError(String registerError) {
        this.registerError = registerError;
    }

    @Override
    public String toString() {
        return "RegistrationModel: {" +
                "registrationDetailsModel: \n \t email: " + registrationDetailsModel.getEmail() +
                "\n }, \n registerError: " + registerError + "\n}";
    }
}