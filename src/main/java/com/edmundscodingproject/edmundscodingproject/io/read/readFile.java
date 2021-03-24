package com.edmundscodingproject.edmundscodingproject.io.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readFile {

    private static final String COMMA_DELIMITER = ",";

    public static List<ArrayList<String>> readImportedFile(String fileName){
        List<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
        BufferedReader br = null;
        ArrayList<String> values = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {

                values = (ArrayList<String>) Stream.of(line.split(COMMA_DELIMITER)).map(elem -> new String(elem)).collect(Collectors.toList());
                records.add(values);
            }
            // removes headers
            records.remove(0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return records;
    }
}