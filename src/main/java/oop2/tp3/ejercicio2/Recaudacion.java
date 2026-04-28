package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"));
        /*
        van leyendo 1 por 1 el contenido del archivo y guardandolo en csvData
        String[] row = null;
        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }
        */
        //2 opcion guardar el contentenido del archivo directamente
        csvData = reader.readAll();

        reader.close();
        //remueve el header
        csvData.remove(0);

        return csvData.stream().filter(
                filtro -> !options.containsKey("company_name") || filtro[1].equals(options.get("company_name")))
                .filter(filtro -> !options.containsKey("city") || filtro[4].equals(options.get("city")))
                .filter(filtro -> !options.containsKey("state") || filtro[5].equals(options.get("state")))
                .filter(filtro -> !options.containsKey("round") || filtro[9].equals(options.get("round")))
                .map(filtro -> {
                    Map<String, String> mapped = new HashMap<>();
                    mapped.put("permalink", filtro[0]);
                    mapped.put("company_name", filtro[1]);
                    mapped.put("number_employees", filtro[2]);
                    mapped.put("category", filtro[3]);
                    mapped.put("city", filtro[4]);
                    mapped.put("state", filtro[5]);
                    mapped.put("funded_date", filtro[6]);
                    mapped.put("raised_amount", filtro[7]);
                    mapped.put("raised_currency", filtro[8]);
                    mapped.put("round", filtro[9]);
                    return mapped;
                }).toList();
/*
        if (options.containsKey("company_name")) {
            List<String[]> results = new ArrayList<String[]>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i)[1].equals(options.get("company_name"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("city")) {
            List<String[]> results = new ArrayList<String[]>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i)[4].equals(options.get("city"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("state")) {
            List<String[]> results = new ArrayList<String[]>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i)[5].equals(options.get("state"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("round")) {
            List<String[]> results = new ArrayList<String[]>();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i)[9].equals(options.get("round"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (int i = 0; i < csvData.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("permalink", csvData.get(i)[0]);
            mapped.put("company_name", csvData.get(i)[1]);
            mapped.put("number_employees", csvData.get(i)[2]);
            mapped.put("category", csvData.get(i)[3]);
            mapped.put("city", csvData.get(i)[4]);
            mapped.put("state", csvData.get(i)[5]);
            mapped.put("funded_date", csvData.get(i)[6]);
            mapped.put("raised_amount", csvData.get(i)[7]);
            mapped.put("raised_currency", csvData.get(i)[8]);
            mapped.put("round", csvData.get(i)[9]);
            output.add(mapped);
        }
        return output;

 */
    }
}
