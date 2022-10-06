package org.example.project25;

import java.io.*;
import java.util.ArrayList;

public class AccountService {
    String file;
    boolean rightLogin = false;
    boolean rightPassword = false;
    String lane;

    public ArrayList<Account> createDemoData() {
        ArrayList<Account> newArrayList = new ArrayList<>();
        Account account01 = new Account("qwe123", "123", "Name01", "+380505234501");
        Account account02 = new Account("qwe234", "234", "Name02", "+380505234502");
        Account account03 = new Account("qwe345", "345", "Name03", "+380505234503");
        Account account04 = new Account("qwe456", "456", "Name04", "+380505234504");
        newArrayList.add(account01);
        newArrayList.add(account02);
        newArrayList.add(account03);
        newArrayList.add(account04);
        return newArrayList;
    }

    public Account addNewAccount() {
        BufferedReader addNewAccountBuff = new BufferedReader(new InputStreamReader(System.in));
        Account newAccount = null;
        try {
            System.out.println("Enter login :");
            String newLogin = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter password :");
            String newPassword = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter name :");
            String newName = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter tel :");
            //    Long.parseLong(addNewAccountBuff.readLine());
            String newTel = String.valueOf(addNewAccountBuff.readLine());
            newAccount = new Account(newLogin, newPassword, newName, newTel);
        } catch (IOException e) {
            System.out.println("!!!!! e.printStackTrace()");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Enter right number");
        } catch (NullPointerException r) {
            System.out.println("Enter right number");
        }
        return newAccount;
    }

    public boolean enterLogin(String file) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//чтение с клавиатуры
        System.out.println("Enter login");
        String enterLogin = null;
        try {
            enterLogin = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader fileReader = null; //чтение из файла почему ноль?
        try {
            fileReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            do {
                lane = fileReader.readLine();
                System.out.println("lane - " + lane);
                if (lane == null) {
                    System.out.println("Incorrect login, try again");
                    break;
                } else {
                    int indexFirstBackslash = lane.indexOf("\\");
                    String loginData = lane.substring(0, indexFirstBackslash);
                    if (enterLogin.equals(loginData)) {
                        rightLogin = true;
                        enterPassword(lane, indexFirstBackslash);
                        System.out.println(lane);
                        break;
                    } else {
                        continue;
                    }
                }
            } while (lane.isEmpty() || lane != null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException r) {
            System.out.println("Mistake entering");
        }
        return rightPassword;
    }

    private boolean enterPassword(String lane, int indexFirstBackslash) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//чтение с клавиатуры
        int indexSecondBackslash = lane.substring(indexFirstBackslash + 1).indexOf("\\");
        System.out.println("Enter password");
        String enterPassword = null;
        try {
            enterPassword = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String passwordData = lane.substring(indexFirstBackslash + 1, indexFirstBackslash + indexSecondBackslash + 1);
        System.out.println("00 " + indexFirstBackslash);
        System.out.println("01 " + indexSecondBackslash);
        if (enterPassword.equals(passwordData)) {
            rightPassword = true;
            System.out.println("02 " + rightPassword);
        } else
            System.out.println("Password incorrect");
        return rightPassword;
    }
}
