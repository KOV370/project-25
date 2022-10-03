package org.example.project25;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

import static java.lang.Character.isDigit;

public class RunApp {
    private static AccountService accountService = new AccountService();
    private static ArrayList<Account> accounts;
    private static String file = "C:\\JetBrains Projects\\Accountdata.txt";

    private static GoodData goodList = new GoodData();
    private static ArrayList<Good> goods = new ArrayList<>();
    private static String fileGoods = "C:\\JetBrains Projects\\GoodsData.txt";

    public static void main(String[] args) throws Exception {

        BufferedReader objBufReader = new BufferedReader(new InputStreamReader(System.in));
        int readNumber;
        boolean checkSymbol = false;


        while (true) {
            System.out.println("Made your choice:");
            try {
                readNumber = Integer.parseInt(objBufReader.readLine());
                choiceMenu(readNumber);
            } catch (NumberFormatException e) {
                System.out.println("Enter right number");
                continue;
            }

        }
    }

    private static void choiceMenu(int readNumber)  {
        switch (readNumber) {
            case 0:
                createDemoData();
                break;
            case 1:
                loadToFileCurrentAccount();
                break;
            case 2:
                createGooddata();
                loadGoodToFile();
                break;
            case 3:
                addGooddata();
                break;
            case 4:
                break;
            default: {
                System.out.println("Mistake with entering");
                System.exit(0);
            }

        }
    }

    private static void createDemoData() {
        accounts = accountService.createDemoData();
        int i = 0;
        for (Account a : accounts) {
            if (i++ == 1){
                accounts.remove(i);
            }
                System.out.println(a);
        }
//        for (int i=0;i<accounts.size (); ++i) {
//            System.out.println("01" + accounts.get(i));
//            if (i == 0) {
//                accounts.remove(i);
//
//            }
//            System.out.println("02" +accounts.get(i));
//        }
    }

    private static void loadToFileCurrentAccount()  {

        accounts.add(accountService.addNewAccount());

        try( FileWriter fileWriter = new FileWriter(file, true)) {
            for (Account s : accounts) {
                System.out.println("Added list :" + s);
                fileWriter.write((s) + "\n");
                //      fileWriter.append(System.lineSeparator());// todo перенос на новую строку в Buffered Reader
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createGooddata() {
        goods = goodList.goodData();
        ListIterator<Good> listIterator = goods.listIterator();//можно было и не делать
        while (listIterator.hasNext()) {
            Good x = listIterator.next();
            System.out.println(x);
        }
    }

    private static void loadGoodToFile() throws IOException {
        FileWriter loadGoodsData = new FileWriter(fileGoods, true);
        for (Good e : goods) {
            loadGoodsData.write(e + "\n");
        }
        loadGoodsData.close();
    }

    private static void addGooddata() throws IOException {
        FileWriter writeNewGoodsData = new FileWriter(fileGoods, true);
        goods.add(GoodData.addNewGoods());
        for (Good c : goods) {
            System.out.println(c);
            writeNewGoodsData.write(c + "\n");
        }
        writeNewGoodsData.close();
    }
}