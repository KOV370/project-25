package org.example.project25.repository;

import org.example.project25.model.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductFileRepository extends ProductRepository {
    private static String FILE_GOODS = "C:\\JetBrains Projects\\GoodsData.txt";

    public static String getFileGoods() {
        return FILE_GOODS;
    }

    public static void setFileGoods(String fileGoods) {
        FILE_GOODS = fileGoods;
    }

    @Override
    public List<Product> readAllProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_GOODS))) {
            String lane;
            while ((lane = bufferedReader.readLine()) != null && !lane.isBlank()) {
                Product product = parseProductFromString(lane);
                products.add(product);
                System.out.println("04 - " + product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product parseProductFromString(String lane) {

        if (lane == null) {
            //      System.out.println("Incorrect login, try again");// todo refactor with exception
            return null;
        }
        int indexFirstBackslash = lane.indexOf("\\");
        int indexLastBackslash = lane.lastIndexOf("\\");
        int indexSignMultiply = lane.indexOf("*");
        String code = lane.substring(0, indexFirstBackslash);
        String name = lane.substring(indexFirstBackslash + 1, indexLastBackslash);
        String priceDouble = lane.substring(indexLastBackslash + 1, indexSignMultiply);
        BigDecimal price = BigDecimal.valueOf(Double.valueOf(priceDouble));// todo  проверить правильность перевода в BigDecimal
        return new Product(code, name, price);

    }

    @Override
    public Product getByCode(String code) {
        //так же в этом классе создать метод Product getProductByCode(String code) который будет пробегать файл и возвращать продукт c заданным кодом
        //если не нашел вернет null

        return null;
    }
}
