package data;

import POJO.RegistrationModel;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.testng.annotations.DataProvider;
import utils.CSVUtils;
import utils.DatabaseUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RegistrationDP {
    @DataProvider(name = "registrationValidDataProvider")
    public Iterator<Object[]> registrationValidDataProvider() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();
//        here we will map XML to loginModel
        File xmlFile = new File("src/test/resources/testData/registrationValidTestData.xml");

        RegistrationModel registrationModel = (RegistrationModel) unMarshalObjectModel(xmlFile, RegistrationModel.class);

//        Adding to data provider
        dp.add(new Object[]{registrationModel});
        return dp.iterator();
    }

    private Object unMarshalObjectModel(File f, Class<?>... classesToBeBound) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

//        Loading XML and map based on tags added on LoginModel and AccountModel
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(f);
    }

    @DataProvider(name = "registrationNegativeDataProvider")
    public Iterator<Object[]> registrationNegativeDataProvider() throws SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();

        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            RegistrationModel register = new RegistrationModel
                    (databaseUtils.getElementFromDB(resultSet, "email"));
            dp.add(new Object[]{register});
        }
        return dp.iterator();
    }

// DataProvider for validating email format for registration page
    @DataProvider(name = "emailFormatDataProvider")
    public Iterator<Object[]> emailFormatDataProvider() throws IOException, CsvException {
        Collection<Object[]> dp = new ArrayList<>();

        List<String[]> csvData = CSVUtils.readCSV("src/test/resources/testData/registrationEmailFormatValidation.csv");

        int lastnameIndex = 0, firstnameIndex = 1, phoneIndex = 2, emailIndex = 3,
                addressIndex = 4, cityIndex = 5, countyIndex = 6, passwordIndex = 7, confirmPasswordIndex = 8, registerErrorIndex = 9;

        for (int i = 1; i < csvData.size(); i++) {
            String[] line = csvData.get(i);
            RegistrationModel registrationModel = new RegistrationModel(
                    line[emailIndex]);

            dp.add(new Object[]{registrationModel});

        }
        return dp.iterator();
    }

}