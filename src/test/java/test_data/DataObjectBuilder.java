package test_data;

import com.google.gson.Gson;
import test_data.models.LoginCred;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static<T> T buildDataObject(String filePath, Class<T> dataType){
        T returnedData;
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath))
                ){
            Gson gson = new Gson();
            returnedData = gson.fromJson(reader, dataType);
        }catch (NoSuchFileException noSuchFileException){
            throw new RuntimeException("[ERR] Can't locate the fiel: ".concat(absoluteFilePath));
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return returnedData;
    }

    public static void main(String[] args) {
        LoginCred loginCred = new LoginCred("teo@sth.com", "12345678");

        // Convert from Object data to json
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCred));

        // Convert from JSON to Object data
        String loginCredJSONData = "{\"email\":\"teo@sth.com\",\"password\":\"12345678\"}";
        LoginCred convertedFromJSON = gson.fromJson(loginCredJSONData, LoginCred.class);
        System.out.println(convertedFromJSON);
    }
}
