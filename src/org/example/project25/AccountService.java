package org.example.project25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    public ArrayList<Account> createDemoData() {
        ArrayList<Account> newArrayList = new ArrayList<>();
        Account account01 = new Account("qwe123", "123", "Name01", "380505234501");
        Account account02 = new Account("qwe234", "234", "Name02", "380505234502");
        Account account03 = new Account("qwe345", "345", "Name03", "380505234503");
        Account account04 = new Account("qwe456", "456", "Name04", "380505234504");
        newArrayList.add(account01);
        newArrayList.add(account02);
        newArrayList.add(account03);
        newArrayList.add(account04);
        return newArrayList;
    }

    public Account addNewAccount()  {
        BufferedReader addNewAccountBuff = new BufferedReader(new InputStreamReader(System.in));
        Account newAccount = null;
        String newTel;
        try{
            System.out.println("Enter login :");
            String newLogin = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter password :");
            String newPassword = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter name :");
            String newName = String.valueOf(addNewAccountBuff.readLine());
            System.out.println("Enter tel :");
            Long.parseLong(addNewAccountBuff.readLine());
            newTel = String.valueOf(addNewAccountBuff.readLine());
            newAccount = new Account(newLogin, newPassword, newName, newTel);
        }
        catch (IOException e) {
            System.out.println("!!!!! e.printStackTrace()");
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Enter right number");
        } catch (NullPointerException r) {
            System.out.println("Enter right number");
        }
        return newAccount;
    }

}
