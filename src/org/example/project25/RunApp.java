package org.example.project25;

import org.example.project25.model.Account;
import org.example.project25.model.Product;
import org.example.project25.repository.ProductFileRepository;
import org.example.project25.service.AccountService;
import org.example.project25.service.BasketService;
import org.example.project25.service.ProductService;

import java.io.*;
import java.util.ArrayList;

public class RunApp {
    private static AccountService accountService = new AccountService();
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static String file = "C:\\JetBrains Projects\\Accountdata.txt";

    private static ProductService goodList = new ProductService();
    private static ArrayList<Product> goods = new ArrayList<>();

    private static boolean openAccount = false;
    private static String basketFile = "C:\\JetBrains Projects\\BasketData.txt";

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
                loadAccountData();
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
                if (openAccount) {    //привязка входа в аккаунт к разрешению выбора товара
                    fillBasket();
                } else {
                    System.out.println("You have not entered to the account yet");
                    break;
                }
                break;
            case 9: {
                System.exit(0);
            }
            default:
                System.out.println("Mistake with entering - try again");
        }
    }

    //ввод аккаунтов из списка
    private static void loadAccountData() {
        accounts = accountService.createAccountData();
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
        Account newAccount = accountService.addNewAccount();
        accounts.add(newAccount);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(newAccount + "\n");
            System.out.println("Added list :" + newAccount);
            System.out.println("Choose the next operation or push 9 for exit.");
            //      fileWriter.append(System.lineSeparator());// перенос на новую строку в Buffered Reader
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ввод списка товаров в лист
    private static void createGooddata() {
        goods = goodList.goodData(); //можно ли сослаться на класс?
//        ListIterator<Good> listIterator = goods.listIterator();//можно было и не делать
//        while (listIterator.hasNext()) {
//            Good x = listIterator.next();
//            System.out.println(x);
//        }
    }

    //ввод списка товаров в файл
    private static void loadGoodToFile() {
        FileWriter loadGoodsData = BuffReaderWriter.writeToFile(ProductFileRepository.getFileGoods(), true);
        for (Product e : goods) {
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
        FileWriter writeNewGoodsData = BuffReaderWriter.writeToFile(ProductFileRepository.getFileGoods(), true);
        Product newProduct = ProductService.addNewGoods();
        if (newProduct != null) {
            goods.add(newProduct);
            try {
                writeNewGoodsData.write(newProduct + "\n");
                System.out.println(newProduct + " - added successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writeNewGoodsData.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("You have returned to the main menu.");
    }

    private static boolean enterToAccount() {
        openAccount = accountService.enterLogin(file);
        System.out.println("Your access to the account - " + openAccount);
        return openAccount;
    }

    private static void fillBasket() {
        BasketService.addProduct(BasketService.copyProductData(ProductFileRepository.getFileGoods()), basketFile);
    }
}

