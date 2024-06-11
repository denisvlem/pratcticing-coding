package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @see <a href="https://coderun.yandex.ru/problem/bank-accounts"/>
 */
public class BankAccount {
  private static final Map<String, Integer> accounts = new HashMap<>();

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){

      String input;
      StringBuilder output = new StringBuilder();
      while((input = reader.readLine()) != null) {
        var commandArgs = input.split(" ");
        var command = commandArgs[0];

        if("DEPOSIT".equals(command)) {
          deposit(commandArgs[1], Integer.parseInt(commandArgs[2]));
        } else if ("WITHDRAW".equals(command)) {
          withdraw(commandArgs[1], Integer.parseInt(commandArgs[2]));
        } else if ("BALANCE".equals(command)) {
          output.append(balance(commandArgs[1])).append("\n");
        } else if("TRANSFER".equals(command)) {
          transfer(commandArgs[1], commandArgs[2], Integer.parseInt(commandArgs[3]));
        } else if("INCOME".equals(command)) {
          income(Integer.parseInt(commandArgs[1]));
        }
      }
      System.out.print(output.toString().trim());
    }
  }

  private static Integer getAccountValue(String name) {
    if(accounts.containsKey(name)) {
      return accounts.get(name);
    } else {
      accounts.put(name, 0);
      return 0;
    }
  }

  private static void deposit(String name, Integer amount) {
    var account = getAccountValue(name);
    account += amount;
    accounts.put(name, account);
  }

  private static void withdraw(String name, Integer amount) {
    var account = getAccountValue(name);
    account -= amount;
    accounts.put(name, account);
  }

  private static void transfer(String from, String to, Integer amount) {
    withdraw(from, amount);
    deposit(to, amount);
  }

  private static String balance(String name) {
    if(accounts.containsKey(name)) {
      return String.valueOf(accounts.get(name));
    } else {
      return "ERROR";
    }
  }

  private static void income(Integer incomePercent) {
    var incomeReceivers = accounts.entrySet().stream()
        .filter(entry -> entry.getValue() > 0)
        .map(Entry::getKey)
        .collect(Collectors.toSet());

    incomeReceivers.forEach(name -> {
      var currentAmount = accounts.get(name);
      var newAmount = Math.floorDiv(currentAmount * (100 + incomePercent),  100);
      accounts.put(name, newAmount);
    });
  }

}
