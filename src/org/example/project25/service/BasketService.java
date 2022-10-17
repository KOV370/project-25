package org.example.project25.service;

import org.example.project25.BuffReaderWriter;
import org.example.project25.model.BasketProduct;
import org.example.project25.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasketService {

    public static List<String> copyProductData(String fileListProduct) {
        ArrayList<String> arrayProductData = new ArrayList<>();
        BufferedReader bufferedReader = BuffReaderWriter.fileReading(fileListProduct);
        try {
            String readingLane;
            do {
                readingLane = bufferedReader.readLine();
                if (readingLane != null) {
                    arrayProductData.add(readingLane);
                    //              System.out.println("04 - " + arrayProductData.get(0) + " size - " + arrayProductData.size());
                }
            } while (!readingLane.isEmpty() || readingLane != null || readingLane.length() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException t) {
            System.out.println("Loading has finished");
        }
        return arrayProductData;
    }

    public static void addProductToBasket(List<Product> products, String productCode, int quantity) {
        Product foundedProduct = null;
        for (Product product : products) {
            if (product.getCode().equals(productCode)) {
                foundedProduct = product;
            }
        }
        if (foundedProduct == null) {
            System.out.println("Product not found.");//todo throw RuntimeException
        }
        // add found product of basket
        //todo добавить новый  basketProduct в класс Basket + количество
        BasketProduct basketProducts = new BasketProduct(foundedProduct, quantity);
        List<BasketProduct> basketProductList = new ArrayList<>();
        basketProductList.add(basketProducts);
        //может нужно в return вывести basketProductList?
    }

    public static void addProductToBasketOld(List<String> products, String basketFile) {
        double itogSum = 0.0;
        int itogQuantity = 0;
        int enterQuantity;
        String lane;
        boolean finishSeeking = false;
        System.out.println("Choose the code of product");
        String enterCode = BuffReaderWriter.consoleReading();//чтение кода с консоли
        for (int i = 0; i < products.size(); i++) {
            lane = products.get(i);
            String codeFromLane = lane.substring(0, lane.indexOf("\\"));//нахождение кода в строке товара
            //       System.out.println("Code =" + codeFromLane);
            if (enterCode.equals(codeFromLane)) {
                System.out.println(lane);
                System.out.println("Enter the quantity");
                try {
                    enterQuantity = Integer.valueOf(BuffReaderWriter.consoleReading());//ввод количества товара
                } catch (NumberFormatException e) {
                    System.out.println("Enter correct figures");
                    continue;
                }
                double price = Double.valueOf(lane.substring(lane.lastIndexOf("\\") + 1, lane.length() - 1));//вывод цены в формате  int
                //       System.out.println("Price = " + price);
                double sum = price * Double.valueOf(enterQuantity);// вычисление суммы товара по строке
                itogSum += sum;
                itogQuantity += enterQuantity;
                String textToWrite = lane + " " + enterQuantity + "=" + sum;//формирование строки с кол-вом и ценой
                System.out.println(textToWrite);
                try {
                    FileWriter buffReaderWriter = BuffReaderWriter.writeToFile(basketFile, true);//запись строки в файл-корзину
                    buffReaderWriter.write(textToWrite + '\n');
                    buffReaderWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finishSeeking = true;
                if (finishSeeking) {
                    System.out.println("Common quantity = " + itogQuantity);
                    System.out.println("Common sum = " + itogSum);
                }
                break;
            }
        }
        System.out.println("Enter correct code or 21 - exit");
        //      addProduct(products, basketFile);//рекурсия
    }
}

//    private static String fileListGoogs;
//
//    //    public static List <BasketProduct> addProduct (List<Product> products,Product product,int quantity){
////
////    }
//    //todo Serhii нужно создать новый класс ProductFileRepository и перенести этот метод туда
//    //метод пеименовать в List<Product> getAllProducts()
//    //так же в этом классе создать метод Product getProductByCode(String code) который будет пробегать файл и возвращать продукт c заданным кодом
//    //если не нашел вернет null
//    private static List<String> getAllProducts(String fileListGoogs) { //todo Serhii: метод должен возвращать List<Product>
//        BufferedReader bufferedReader = null;
//        List<String> arrayProductData = new ArrayList<>();
//        try {
//            bufferedReader = new BufferedReader(new FileReader(fileListGoogs));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        while (true) { //todo Serhii этот цикл должен быть внутри try/catch блока, блок try catch сразу можно делать с ресурсами
//            try {
//                assert bufferedReader != null;
//                String readingLane = bufferedReader.readLine(); //todo Serhii: тут сразу парсим строку и делаем создаем продукт через new Product()
//                arrayProductData.add(readingLane); //todo Serhii: добавляем в List не линию а Product
//                System.out.println("04 - " + arrayProductData.add(readingLane));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        // почему не выводит ArrayList???
//        // todo Serhii: наводишь мышкой на красное, Идея показывает ошибку, Unreachable statement
//        //это значит что эта строка когда не будет выполнена никогда, из-за того что выше в строках 20-29 идет вечный цикл while (true)
//        //надо использовать конструкцию как в примере https://stackoverflow.com/questions/17991470/how-to-read-until-end-of-file-eof-using-bufferedreader-in-java
//        //while((str=input.readLine())!=null && str.length()!=0)
//
//    }
////}



