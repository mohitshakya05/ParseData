package com.Test.Parse.ReadData;

import com.Test.Parse.Model.Order;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileConversion {
    public void conversion() {
        String readLine = "";
        String my = "data";
        Gson gson = new Gson();
        try {
            File csvfile = new File("src/main/resources/Files/OrderCSV.csv");
            File jsonFile = new File("src/main/resources/Files/OrderJson.json");
            BufferedReader[] buffer = new BufferedReader[2];
            buffer[0] = new BufferedReader(new FileReader(csvfile));
            buffer[1] = new BufferedReader(new FileReader(jsonFile));

            // Thread creation for parsing jsonfile parallelly

            Thread thread = new Thread(() -> new ParseThread().parseJson(buffer[1]));
            thread.start();
            while ((readLine = buffer[0].readLine()) != null) {
                String[] arr = readLine.split(",");
                Order order = new Order();
                order.setAmount(arr[1]);
                order.setOrderId(arr[0]);
                order.setCurrency(arr[2]);
                order.setComment(arr[3]);
                order.setFilename(csvfile.getName());
                order.setResult("OK");
                System.out.println(gson.toJson(order));
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
