package org.example.project25;

import java.io.*;
import java.util.ArrayList;

public class AccountService {
    String file;
    boolean correctLogin = false;
    boolean correctPassword = false;
    String lane;


    public ArrayList<Account> createAccountData() {
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
        long newTelLong = 0;
        try {
            System.out.println("Enter login :");
            String newLogin = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter password :");
            String newPassword = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter name :");
            String newName = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter tel :");
            try {
                newTelLong = Long.parseLong(addNewAccountBuff.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter correct number of the  phone");//todo как сделать ссылку на перебор при неправильном формате
//                Long.valueOf(addNewAccountBuff.readLine());
                //      addNewAccount();//рекурсия - возврат в начало метода при неправильном формате
            }

            String newTelString = "+" + newTelLong;
            newAccount = new Account(newLogin, newPassword, newName, newTelString);

        }  catch (NumberFormatException e) {
            System.out.println("Enter right number - not figures");
        } catch (NullPointerException r) {
            System.out.println("Enter right number - null");
        }
        catch (IOException e) {
            System.out.println("!!!!! e.printStackTrace()");
            e.printStackTrace();
        }
        return newAccount;
    }

    public boolean enterLogin(String file) {
        if (correctPassword) {
            System.out.println("You entered the account, it does not need enter again.");
        } else {
            correctLogin = false;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//чтение с клавиатуры
            System.out.println("Enter login");
            String enterLogin = null;
            try {
                enterLogin = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader fileReader = BuffReaderWriter.fileReading(file); //чтение из файла
            try {
                do {
                    lane = fileReader.readLine();
                    if (lane == null) {
                        correctPassword = false;
                        System.out.println("Incorrect login, try again with choice of operation.");
                        break;
                    } else {
                        int indexFirstBackslash = lane.indexOf("\\");
                        String loginData = lane.substring(0, indexFirstBackslash);
                        if (enterLogin.equals(loginData)) {
                            correctLogin = true;
                            enterPassword(lane, indexFirstBackslash);
                            //           System.out.println(lane);
                            break;
                        } else {
                            continue;
                        }
                    }
                } while (!lane.isEmpty() || lane != null);//todo поставить вместо do
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException r) {
                System.out.println("Mistake entering");
            }
        }
        return correctPassword;
    }


    private boolean enterPassword(String lane, int indexFirstBackslash) {
        correctPassword = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//чтение с клавиатуры
        int indexSecondBackslash = lane.indexOf("\\", indexFirstBackslash + 1);
        System.out.println("Enter password");
        String enterPassword = null;
        try {
            enterPassword = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        String passwordData = lane.substring(indexFirstBackslash + 1, indexSecondBackslash);
//        System.out.println("00 " + passwordData);
//        System.out.println("01 " + indexSecondBackslash);
        if (enterPassword.equals(passwordData)) {
            correctPassword = true;
            System.out.println("02 " + correctPassword);
        } else
            System.out.println("Password incorrect");
        return correctPassword;
    }
}
