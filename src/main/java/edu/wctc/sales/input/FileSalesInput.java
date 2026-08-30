package edu.wctc.sales.input;

import edu.wctc.sales.Sale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSalesInput implements SalesInput {

    private String filename;

    public FileSalesInput(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(filename));

            for (String line : lines) {
                String[] parts = line.split(",");

                String customer = parts[0];
                String country = parts[1];
                double amount = Double.parseDouble(parts[2]);
                double tax = Double.parseDouble(parts[3]);

                sales.add(new Sale(customer, country, amount, tax));
            }

        } catch (IOException e) {
            System.out.println("Could not read sales file.");
            e.printStackTrace();
        }

        return sales;
    }
}