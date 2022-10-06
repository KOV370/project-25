package org.example.project25;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

import static java.lang.Character.isDigit;

public class RunApp {
    private static AccountService accountService = new AccountService();
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static String file = "C:\\JetBrains Projects\\Accountdata.txt";

    private static GoodData goodList = new GoodData();
    private static ArrayList<Good> goods = new ArrayList<>();
    private static String fileGoods = "C:\\JetBrains Projects\\GoodsData.txt";
    private static boolean openAccount = false;

    public static void main(String[] args) throws Exception {
        System.out.println("Made your choice:");
        System.out.println("0-load list of accounts, " + "1-create new account, " + "2-load list of goods,");
        System.out.println("3-create new goods, " + "4-enter to your account, " + "5-fill your basket, ");
        System.out.println("9-exit.");
        BufferedReader objBufReader = new BufferedReader(new InputStreamReader(System.in));
        int readNumber;

        while (true) {  //разъяснить

            try {
                readNumber = Integer.parseInt(objBufReader.readLine());
                choiceMenu(readNumber);
            } catch (NumberFormatException e) {
                System.out.println("Enter right number");
                continue;
            }

        }
    }

    private static void choiceMenu(int readNumber) {
        switch (readNumber) {
            case 0: //ввод аккаунтов из списка
                createDemoData();
                break;
            case 1://создание нового аккаунта и вывод его во внешний файл и в список
                loadToFileCurrentAccount();
                break;
            case 2://ввод списка товаров в лист
                createGooddata();
                loadGoodToFile();
                break;
            case 3://создание нового товара и добавление его во внешний файл
                addGooddata();
                break;
            case 4://вход в аккаунт
                enterToAccount();
                break;
            case 5://подбор товара в корзину
                if (enterToAccount()) {   // enterToAccount()=true не проходит
     //               chosingGoods();
                }
            {
                System.out.println("You have not enter to the account yet");
                break;}
            case 9: {

                System.exit(0);
            }
            default:
                System.out.println("Mistake with entering - try again");

        }
    }

    //ввод аккаунтов из списка
    private static void createDemoData() {
        accounts = accountService.createDemoData();
        int i = 0;
        for (Account a : accounts) {
//            if (i++ == 1){
//                accounts.remove(i);
//            }
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

    //создание нового аккаунта и вывод его во внешний файл и в список
    private static void loadToFileCurrentAccount() {

        accounts.add(accountService.addNewAccount());

        try (FileWriter fileWriter = new FileWriter(file, false)) {
            for (Account s : accounts) {
                System.out.println("Added list :" + s);
                fileWriter.write((s) + "\n");
                //      fileWriter.append(System.lineSeparator());// todo перенос на новую строку в Buffered Reader
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //ввод списка товаров в лист
    private static void createGooddata() {
        goods = goodList.goodData();
//        ListIterator<Good> listIterator = goods.listIterator();//можно было и не делать
//        while (listIterator.hasNext()) {
//            Good x = listIterator.next();
//            System.out.println(x);
//        }
    }

    //ввод списка товаров в лист
    private static void loadGoodToFile() {

        FileWriter loadGoodsData = null;
        try {
            loadGoodsData = new FileWriter(fileGoods, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Good e : goods) {
            try {
                loadGoodsData.write(e + "\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            loadGoodsData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //создание нового товара и добавление его во внешний файл
    private static void addGooddata() {
        FileWriter writeNewGoodsData = null;
        try {
            writeNewGoodsData = new FileWriter(fileGoods, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            goods.add(GoodData.addNewGoods());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Good c : goods) {
            System.out.println(c);
            try {
                writeNewGoodsData.write(c + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writeNewGoodsData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean enterToAccount() {
        openAccount = accountService.enterLogin(file);
        System.out.println("Your access to the account - " + openAccount);
        return openAccount;
    }
//    private static Good choosingGoods(){
//
//    }
}

