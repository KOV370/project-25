package org.example.project25;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasketService {
    private static String fileListGoogs;

    //    public static List <BasketProduct> addProduct (List<Product> products,Product product,int quantity){
//
//    }
    //todo Serhii нужно создать новый класс ProductFileRepository и перенести этот метод туда
    //метод пеименовать в List<Product> getAllProducts()
    //так же в этом классе создать метод Product getProductByCode(String code) который будет пробегать файл и возвращать продукт c заданным кодом
    //если не нашел вернет null
    private static List<String> getAllProducts(String fileListGoogs) { //todo Serhii: метод должен возвращать List<Product>
        BufferedReader bufferedReader = null;
        List<String> arrayProductData = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(fileListGoogs));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) { //todo Serhii этот цикл должен быть внутри try/catch блока, блок try catch сразу можно делать с ресурсами
            try {
                assert bufferedReader != null;
                String readingLane = bufferedReader.readLine(); //todo Serhii: тут сразу парсим строку и делаем создаем продукт через new Product()
                arrayProductData.add(readingLane); //todo Serhii: добавляем в List не линию а Product
                System.out.println("04 - " + arrayProductData.add(readingLane));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // почему не выводит ArrayList???
        // todo Serhii: наводишь мышкой на красное, Идея показывает ошибку, Unreachable statement
        //это значит что эта строка когда не будет выполнена никогда, из-за того что выше в строках 20-29 идет вечный цикл while (true)
        //надо использовать конструкцию как в примере https://stackoverflow.com/questions/17991470/how-to-read-until-end-of-file-eof-using-bufferedreader-in-java
        //while((str=input.readLine())!=null && str.length()!=0)
        return  arrayProductData; //todo Serhii: можешь вопросы писать в тудушках, тогда их легче искать и комментировать
    }
}
//    public static List<String> fillBasket() throws IOException {
//        String laneGoods;
//        ArrayList<String> goodArrayList = new ArrayList<>();
//        BufferedReader enterGoodsName = new BufferedReader(new InputStreamReader(System.in));//чтение названия товара с консоли
//        String goodsName = enterGoodsName.readLine();
//        BufferedReader readListGoods = new BufferedReader(new FileReader(fileListGoogs));//чтение списка товара из файла
//        do {
//            laneGoods = readListGoods.readLine();
//            String nameInLane = extractName(laneGoods);
//            if (goodsName.equals(nameInLane)) {
//                //   goodArrayList.add(laneGoods);
//                System.out.println("Choose the quantity");
//                BufferedReader enterQuantity = new BufferedReader(new InputStreamReader(System.in));
//                try {
//                    Integer.parseInt(enterQuantity.readLine());
//                    goodArrayList.add(laneGoods + enterQuantity.readLine());
//                } catch (NumberFormatException t) {
//                    System.out.println("Enter right number");
//                    continue;
//                }
//            }
//        }
//        while (!laneGoods.isEmpty()||laneGoods!=null);
//        System.out.println(goodArrayList);
//        return goodArrayList;
//    }
//
//    private static String extractName(String laneGoods) {
//        int firstBackslash = laneGoods.indexOf("\\");
//        String nameInLane = laneGoods.substring(0, firstBackslash + 1);
//        return nameInLane;
//    }
//}
