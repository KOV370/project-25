package org.example.project25.repository;

import org.example.project25.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductFileRepository extends ProductRepository {
    private static String FILE_GOODS = "C:\\JetBrains Projects\\GoodsData.txt";

    @Override
    public List<Product> listProducts() {


        BufferedReader bufferedReader = null;
        List<Product> arrayProductData = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_GOODS));
            while (true) { //todo блок try catch сразу можно делать с ресурсами
                try {
                    assert bufferedReader != null;
                    String readingLane = bufferedReader.readLine();
                    Product product = parseProductFromString(readingLane);
                    arrayProductData.add(product);
                    System.out.println("04 - " + arrayProductData.add(product));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Product parseProductFromString(String lane) {

        if (lane == null) {
            System.out.println("Incorrect login, try again");// todo refactor with exception
            return null;
        }

        int indexFirstBackslash = lane.indexOf("\\");
        String code = lane.substring(0, indexFirstBackslash);
        String name = lane.substring(0, indexFirstBackslash);// исправить
        Double price = 5.55;// todo исправить bigdecimal
        return new Product(code, name, price);

    }

    @Override
    public Product getByCode(String code) {
        //так же в этом классе создать метод Product getProductByCode(String code) который будет пробегать файл и возвращать продукт c заданным кодом
        //если не нашел вернет null

        return null;
    }
}
