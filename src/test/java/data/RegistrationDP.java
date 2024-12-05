package data;

import POJO.RegistrationModel;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDP {

    @DataProvider(name = "registrationValidDataProvider")
    public Iterator<Object[]> registrationValidDataProvider() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();

        // Load XML and map to RegistrationModel
        File xmlFile = new File("src/test/resources/testData/registrationValidTestData.xml");
        RegistrationModel registrationModel = (RegistrationModel) unMarshalObjectModel(xmlFile, RegistrationModel.class);

        // Debugging: Print the email to ensure it's not null
        System.out.println("Loaded email for registration: " + registrationModel.getRegistrationDetailsModel().getEmail());

        // Adding to data provider
        dp.add(new Object[]{registrationModel});
        return dp.iterator();
    }

    // Method to unmarshal XML file into a Java object
    private Object unMarshalObjectModel(File file, Class<?>... classesToBeBound) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

        // Loading XML and map based on the tags
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(file);
    }


}