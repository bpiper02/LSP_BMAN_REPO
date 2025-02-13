package org.howard.edu.lsp.assignment2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ETLPipeline {
    public static void main(String[] args) {
        // Define input and output file paths relative to the project root.
        Path inputPath = Paths.get("data", "products.csv");
        Path outputPath = Paths.get("data", "transformed_products.csv");

        // Open the files using try-with-resources to ensure proper closing.
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            // Write the header for the output CSV file.
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line;
            boolean headerSkipped = false;

            // Process the input file line by line.
            while ((line = reader.readLine()) != null) {
                // Trim extra spaces.
                line = line.trim();

                // Ignore empty lines.
                if (line.isEmpty()) {
                    continue;
                }

                // Skip the header line (assumed to be the first non-empty line).
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                // Split the line into parts separated by commas.
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    // Skip lines with insufficient data.
                    continue;
                }

                try {
                    // Parse product data.
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double originalPrice = Double.parseDouble(parts[2].trim());
                    String category = parts[3].trim();

                    // Convert the product name to uppercase.
                    name = name.toUpperCase();

                    // Start with the original price.
                    double finalPrice = originalPrice;

                    // Apply a 10% discount if the product is in the "Electronics" category.
                    if (category.equalsIgnoreCase("Electronics")) {
                        finalPrice = originalPrice * 0.9;
                        finalPrice = Math.round(finalPrice * 100.0) / 100.0; // Round to two decimals

                        // Upgrade the category for expensive electronics.
                        if (originalPrice > 500.0) {
                            category = "Premium Electronics";
                        }
                    }

                    // Determine the price range based on the final price.
                    String priceRange;
                    if (finalPrice >= 0 && finalPrice <= 10.0) {
                        priceRange = "Low";
                    } else if (finalPrice > 10.0 && finalPrice <= 100.0) {
                        priceRange = "Medium";
                    } else if (finalPrice > 100.0 && finalPrice <= 500.0) {
                        priceRange = "High";
                    } else if (finalPrice > 500.0) {
                        priceRange = "Premium";
                    } else {
                        priceRange = "Unknown";
                    }

                    // Format the final price to two decimal places.
                    String formattedPrice = String.format("%.2f", finalPrice);

                    // Build and write the output CSV line.
                    String outputLine = productId + "," + name + "," + formattedPrice + "," + category + "," + priceRange;
                    writer.write(outputLine);
                    writer.newLine();
                } catch (NumberFormatException nfe) {
                    // Print an error message for any issues with parsing.
                    System.err.println("Error parsing line: " + line + " -> " + nfe.getMessage());
                }
            }

            System.out.println("ETL process completed. Output written to: " + outputPath.toString());
        } catch (IOException e) {
            // Print an error message if file processing fails.
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
