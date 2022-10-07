package org.example.project25;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasketService {
    private static String fileListGoogs;

    //    public static List <BasketProduct> addProduct (List<Product> products,Product product,int quantity){
//
//    }
    private static List<String> copyProductData(String fileListGoogs) {
        BufferedReader bufferedReader = null;
        ArrayList<String> arrayProductData = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(fileListGoogs));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                assert bufferedReader != null;
                String readingLane = bufferedReader.readLine();
                arrayProductData.add(readingLane);
                System.out.println("04 - " + arrayProductData.add(readingLane));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // почему не выводит ArrayList???
        return  arrayProductData;
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
