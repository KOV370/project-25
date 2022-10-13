package org.example.project25;

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
                assert bufferedReader != null;
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
        // почему не выводит ArrayList???
        return arrayProductData;
    }


    public static void addProduct(List<String> products, String basketFile) {
        double itogSum = 0.0;
        int itogQuantity = 0;
        int enterQuantity;
        String lane;
        boolean finishSeeking = false;
        //попытка выйти из подбора
//        if (BuffReaderWriter.consoleReading() == String.valueOf(8)) {
//            System.exit(0);
//            return;
//        } else {

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
            addProduct(products, basketFile);//рекурсия
        }
    }
//}



