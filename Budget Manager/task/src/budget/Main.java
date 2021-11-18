package budget;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> listToSave = new LinkedHashMap<>();

       Map<String, Double> listAll = new LinkedHashMap<>();
        Map<String, Double> listFood = new LinkedHashMap<>();
        Map<String, Double> listClothes = new LinkedHashMap<>();
        Map<String, Double> listEntertainment = new LinkedHashMap<>();
        Map<String, Double> listOther = new LinkedHashMap<>();



        double totalPrice = 0;
        double totalPriceFood = 0;
        double totalPriceClothes = 0;
        double totalPriceEntertainment = 0;
        double totalPriceOther = 0;
        double balance = 0;

        boolean finished = true;

        while (finished) {
            System.out.println("Choose your action:" + "\n" + "1) Add income" + "\n" + "2) Add purchase" +
                    "\n" + "3) Show list of purchases" + "\n" + "4) Balance" + "\n" + "5) Save" + "\n" +
                    "6) Load" + "\n" + "7) Analyze (Sort)" + "\n" + "0) Exit");


            String input = scanner.nextLine().replace("> ", "");
            System.out.println("\n");

            switch (input) {

                case "1": {
                    System.out.println("Enter income:");

                    String income = scanner.nextLine().replace("> ", "");
                    double sum = Double.parseDouble(income);

                    balance += sum;

                    System.out.println("Income was added!");
                    System.out.println("\n");

                    break;

                }
                case "2": {

                    boolean paid = true;

                    while (paid) {
                        String purchase;

                        System.out.println("Choose the type of purchase" + "\n" + "1) Food" + "\n" + "2) Clothes" + "\n" + "3) Entertainment" + "\n" + "4) Other" + "\n" + "5) Back");

                        String type = scanner.nextLine().replace("> ", "");
                        System.out.println("\n");

                        switch (type) {

                            case "1": {
                                System.out.println("Enter purchase name:");
                                purchase = scanner.nextLine().replace("> ", "");
                                System.out.println("Enter its price:");

                                String price = scanner.nextLine().replace("> ", "");

                                double price1 = Double.parseDouble(price);

                                totalPriceFood += price1;
                                totalPrice += price1;

                                String add = purchase + " $";

                                listFood.put(add, price1);
                                listAll.put(add, price1);
                                listToSave.put(add, price1);

                                balance -= price1;

                                System.out.println("Purchase was added!");
                                System.out.println("\n");
                                break;
                            }
                            case "2": {
                                System.out.println("Enter purchase name:");
                                purchase = scanner.nextLine().replace("> ", "");
                                System.out.println("Enter its price:");

                                String price = scanner.nextLine().replace("> ", "");

                                double price1 = Double.parseDouble(price);

                                totalPriceClothes += price1;
                                totalPrice += price1;

                                String add = purchase + " $";

                                listClothes.put(add, price1);
                                listAll.put(add, price1);
                                listToSave.put(add, price1);

                                balance -= price1;

                                System.out.println("Purchase was added!");
                                System.out.println("\n");
                                break;
                            }

                            case "3": {
                                System.out.println("Enter purchase name:");
                                purchase = scanner.nextLine().replace("> ", "");
                                System.out.println("Enter its price:");

                                String price = scanner.nextLine().replace("> ", "");

                                double price1 = Double.parseDouble(price);

                                totalPriceEntertainment += price1;
                                totalPrice += price1;

                                String add = purchase + " $";

                                listEntertainment.put(add, price1);
                                listAll.put(add, price1);
                                listToSave.put(add, price1);

                                balance -= price1;

                                System.out.println("Purchase was added!");
                                System.out.println("\n");
                                break;
                            }

                            case "4": {
                                System.out.println("Enter purchase name:");
                                purchase = scanner.nextLine().replace("> ", "");
                                System.out.println("Enter its price:");

                                String price = scanner.nextLine().replace("> ", "");

                                double price1 = Double.parseDouble(price);

                                totalPriceOther += price1;
                                totalPrice += price1;

                                String add = purchase + " $";

                                listOther.put(add, price1);
                                listAll.put(add, price1);
                                listToSave.put(add, price1);

                                balance -= price1;

                                System.out.println("Purchase was added!");
                                System.out.println("\n");
                                break;
                            }
                            case "5": {
                                paid = false;
                                break;
                            }

                        }

                    }
                    break;
                }

                case "3": {
                    boolean choice = true;
                    String input1;

                    while (choice) {

                        System.out.println("Choose the type of purchases" + "\n" + "1) Food" + "\n" + "2) Clothes" + "\n" + "3) Entertainment" + "\n" + "4) Other" + "\n" + "5) All" + "\n" + "6) Back");
                        input1 = scanner.nextLine().replace("> ", "");
                        System.out.println("\n");

                        switch (input1) {

                            case "1": {
                                System.out.println("Food:");
                                if (listFood.isEmpty()) {
                                    System.out.println("The purchase list is empty");

                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    listFood.entrySet().forEach(entry -> {
                                        System.out.println(entry.getKey() + format.format(entry.getValue()));
                                    });

                                    System.out.println("Total sum: $" + format.format(totalPriceFood));
                                }
                                System.out.println("\n");

                                break;

                            }

                            case "2": {
                                System.out.println("Clothes:");
                                if (listClothes.isEmpty()) {
                                    System.out.println("The purchase list is empty");

                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    listClothes.entrySet().forEach(entry -> {
                                        System.out.println(entry.getKey() + format.format(entry.getValue()));
                                    });

                                    System.out.println("Total sum: $" + format.format(totalPriceClothes));
                                }
                                System.out.println("\n");

                                break;
                            }

                            case "3": {
                                System.out.println("Entertainment:");
                                if (listEntertainment.isEmpty()) {
                                    System.out.println("The purchase list is empty");

                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    listEntertainment.entrySet().forEach(entry -> {
                                        System.out.println(entry.getKey() + format.format(entry.getValue()));
                                    });

                                    System.out.println("Total sum: $" + format.format(totalPriceEntertainment));
                                }

                                System.out.println("\n");

                                break;
                            }
                            case "4": {
                                System.out.println("Other:");
                                if (listOther.isEmpty()) {
                                    System.out.println("The purchase list is empty");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    listOther.entrySet().forEach(entry -> {
                                        System.out.println(entry.getKey() + format.format(entry.getValue()));
                                    });

                                    System.out.println("Total sum: $" + format.format(totalPriceOther));
                                }
                                System.out.println("\n");

                                break;
                            }

                            case "5": {
                                System.out.println("All:");
                                if (listAll.isEmpty()) {
                                    System.out.println("The purchase list is empty");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    listAll.entrySet().forEach(entry -> {
                                        System.out.println(entry.getKey() + format.format(entry.getValue()));
                                    });

                                    System.out.println("Total sum: $" + format.format(totalPrice));
                                }
                                System.out.println("\n");

                                break;
                            }

                            case "6": {
                                choice = false;
                                break;
                            }
                        }
                    }

                    break;
                }

                case "4": {

                        DecimalFormat format = new DecimalFormat("#.00");
                        System.out.println("Balance: $" + balance);
                        System.out.println("\n");


                    break;
                }

                case "5": {
                    String s = "Balance: $";

                    listToSave.put(s, balance);

                    String filePath = "C:\\Users\\Алевтина\\Pictures\\Screenshots\\purchases.txt";

                    File file = new File(filePath);
                    BufferedWriter bf = null;
                    try {

                        // create new BufferedWriter for the output file
                        bf = new BufferedWriter(new FileWriter(file));
                        bf.write(String.valueOf(listToSave.size()));
                        bf.newLine();

                        for (Map.Entry<String, Double> entry : listToSave.entrySet()) {
                            bf.write(entry.getKey());
                            bf.newLine();
                            bf.write(String.valueOf(entry.getValue()));
                            bf.newLine();

                        }

                        bf.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Exception!!!!! while saving file");
                    } catch (Exception e) {
                        System.out.println("Exception!!!!! while saving file");
                    } finally {

                        try {

                            // always close the writer
                            bf.close();
                        } catch (Exception e) {
                        }
                    }

                    System.out.println("Purchases were saved!");
                    System.out.println("\n");

                    break;
                }

                case "6": {

                 List<String> words = new ArrayList<String>();
                 

                    String filePath = "C:\\Users\\Алевтина\\Pictures\\Screenshots\\purchases.txt";
                    BufferedReader br = null;

                    try {

                        // create file object

                        File file = new File(filePath);
                        br = new BufferedReader(new FileReader(file));

                        String numCardsStr = br.readLine();
                        Integer numCards = Integer.parseInt(numCardsStr);


                        while (numCards != 0) {
                            String purchase = br.readLine();
                            String price = br.readLine();
                            Double price1 = Double.parseDouble(price);

                            listAll.put(purchase, price1);

                            listToSave.put(purchase,price1);


                            if (purchase.contains("Almond") || purchase.contains("Milk") || purchase.contains("Apple") || purchase.contains("Eggs") || purchase.contains("Water") || purchase.contains("chocolate") || purchase.contains("Broccoli") || purchase.contains("Keystone")) {
                                listFood.put(purchase, price1);
                                totalPriceFood = getTotalPriceClothes(totalPriceFood, price1);
                            }
                            if (purchase.contains("Gildan") || purchase.contains("Socks") || purchase.contains("Wrangler")) {
                                listClothes.put(purchase, price1);
                                totalPriceClothes = getTotalPriceClothes(totalPriceClothes, price1);
                            }

                            if (purchase.contains("LEGO") || purchase.contains("Cinema") || purchase.contains("Skate")) {
                                listEntertainment.put(purchase, price1);
                                totalPriceEntertainment = getTotalPriceClothes(totalPriceEntertainment, price1);
                            }

                            if (purchase.contains("Toothpaste") || purchase.contains("Card") || purchase.contains("Debt")) {
                                listOther.put(purchase, price1);
                                totalPriceOther = getTotalPriceClothes(totalPriceOther, price1);
                            }
                            if (purchase.contains("Balance")) {
                                listAll.remove(purchase, price1);
                                balance = listToSave.get(purchase);

                            }
                            totalPrice = totalPriceClothes + totalPriceEntertainment + totalPriceFood + totalPriceOther;

                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("File not found.");
                    } catch (Exception e) {
                        System.out.println("Error." + e.toString());
                    } finally {

                        // Always close the BufferedReader
                        if (br != null) {
                            try {
                                br.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    System.out.println("Purchases were loaded!");
                    System.out.println("\n");



                    for (int i = 0; i < words.size(); i++) {

                        String num = words.get(i).substring(words.get(i).lastIndexOf("$") + 1);

                        double geld = Double.parseDouble(num);

                        totalPrice += geld;
                        balance += balance;
                    }


                    break;

                }

                case "7": {

                    boolean choice = true;
                    String input2;

                    while (choice) {
                        System.out.println("How do you want to sort?");
                        System.out.println("1) Sort all purchases" + "\n" + "2) Sort by type" + "\n" + "3) Sort certain type" + "\n" + "4) Back");
                        input2 = scanner.nextLine().replace("> ", "");
                        System.out.println("\n");

                        switch (input2) {

                            case "1": {

                                sorted(listAll);


                                break;
                            }
                            case "2": {

                                System.out.println("Types:");
                                if (listFood.isEmpty()) {
                                    System.out.println(" Food - $0");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    System.out.println("Food - $" + format.format(totalPriceFood));
                                }
                                if (listEntertainment.isEmpty()) {
                                    System.out.println("Entertainment - $0");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    System.out.println("Entertainment - $" + format.format(totalPriceEntertainment));
                                }
                                if (listClothes.isEmpty()) {
                                    System.out.println("Clothes - $0");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    System.out.println("Clothes - $" + format.format(totalPriceClothes));
                                }
                                if (listOther.isEmpty()) {
                                    System.out.println("Other - $0");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    System.out.println("Other - $" + format.format(totalPriceOther));
                                }
                                if (listClothes.isEmpty() && listFood.isEmpty() && listOther.isEmpty() && listEntertainment.isEmpty()) {
                                    System.out.println("Total sum: $0");
                                } else {
                                    DecimalFormat format = new DecimalFormat("#.00");
                                    System.out.println("Total sum: $" + format.format(totalPrice));
                                }
                                System.out.println("\n");

                                break;
                            }
                            case "3": {
                                System.out.println("Choose the type of purchase");
                                System.out.println("1) Food" + "\n" + "2) Clothes" + "\n" + "3) Entertainment" + "\n" + "4) Other");
                                String type = scanner.nextLine().replace("> ", "");
                                System.out.println(("\n"));

                                switch (type) {
                                    case "1":
                                        sorted(listFood);
                                        break;
                                    case "2":
                                        sorted(listClothes);
                                        break;
                                    case "3":
                                        sorted(listEntertainment);
                                        break;
                                    case "4":
                                        sorted(listOther);
                                        break;
                                }

                                break;
                            }

                            case "4": {
                                choice = false;
                                break;
                            }
                        }

                    }
                    break;
                }

                case "0": {

                    System.out.println("Bye!");

                    finished = false;
                    break;
                }


                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }

        }

    }

    private static void sorted(Map<String, Double> listAll) {
        List<String> keys = new ArrayList<>();

        if (listAll.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {

            List<Map.Entry> a = new ArrayList<Map.Entry>(listAll.entrySet());
            Collections.sort(a,
                    new Comparator() {
                        public int compare(Object o1, Object o2) {
                            Map.Entry e1 = (Map.Entry) o1;
                            Map.Entry e2 = (Map.Entry) o2;
                            return ((Comparable) e2.getValue()).compareTo(e1.getValue());
                        }
                    });

            for (Map.Entry e : a) {
                DecimalFormat format = new DecimalFormat("#.00");
                System.out.println(e.getKey() + format.format(e.getValue()));
            }
        }
        System.out.println("\n");
    }


    private static double getTotalPriceClothes(double totalPriceClothes, double price1) {

            totalPriceClothes += price1;

        return totalPriceClothes;
    }

}
