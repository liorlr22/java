package com.company;

import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        Node<Integer> n = null;
        Node<Integer> manualList = null;
        Node<Character> charList = null;
        Node<Character> alphabeticalList = null;
        Node<Character> symbolList = null;
        Node<String> studentList = null;
        Node<Product> productsList = null;
        Node<Basket> myBasket = null;
        Node<Polinom> equation1 = null;
        Node<Polinom> equation2 = null;
        Node<Integer> arrange = null;
        Node<Integer> reversedArranged = null;

        Product p = new Product("rice", "cereal", 9.9);

        int[] formanualList = {3, 1, 2, 3, 3, 4, 5, 6, 3, 7, 8, 9, 10, 3};
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', '0', 'a', 't'};
        char[] alphabeticalArray = new char[52];
        char[] symbolArray = {'1', '+', '2', '5', '-', '4', '0', '/', '8'};
        String[] nameArray = {"Lior Lerner", "Jeremy Toledano", "Nir Gitelman", "Lior Example"};
        Product[] products = {new Product("rice", "cereal", 9.9),
                new Product("pargiot", "meat", 49.9),
                new Product("mozarella", "milk products", 33.5)};

        Basket b = new Basket("Lior");
        char character = 'A';
        Polinom[] polinoms1 = {new Polinom(1, 3), new Polinom(-1, 0)};
        Polinom[] polinoms2 = {new Polinom(2, 2), new Polinom(-3, 1)};
        int[] toArrange = {7, 2, 4, 8, 20, 18, 19, 20, 20, 5, -3, 0, 9};

        for (int i = 0; i < 10; i++) {
            n = new Node<>((int) (Math.random() * 10 + 1), n);
        }

        for (int j : formanualList) {
            manualList = new Node<>(j, manualList);
        }

        for (char c : charArray) {
            charList = new Node<>(c, charList);
        }

        for (int i = 0; i < alphabeticalArray.length; i++) {
            while (character > 'Z' && character < 'a') {
                character++;
            }
            alphabeticalArray[i] = character;
            character++;

        }

        for (char c : alphabeticalArray) {
            alphabeticalList = new Node<>(c, alphabeticalList);
        }

        for (char c : symbolArray) {
            symbolList = new Node<>(c, symbolList);
        }

        for (String s : nameArray) {
            studentList = new Node<>(s, studentList);
        }

        for (Polinom polinom : polinoms1) {
            equation1 = new Node<>(polinom, equation1);
        }
        for (Polinom polinom : polinoms2) {
            equation2 = new Node<>(polinom, equation2);
        }

        for (int j : toArrange) {
            arrange = new Node<>(j, arrange);
        }


        System.out.println(alphabeticalArray);

        int rand = (int) (Math.random() * 10 + 1);
        System.out.println(n);
        System.out.println("Does " + rand + " exist in the list? " + isExistList(n, rand));
        System.out.println("Sum of list: " + sumList(n));
        System.out.println(manualList);
        System.out.println("delete " + 3 + " from manual list = " + debugList(manualList, 3));
        System.out.println("the list: " + charList + " has " + hasList(charList, 'a') + " 'a' in it");

        while (alphabeticalList.getNext() != null) {
            System.out.println("character " + alphabeticalList.getValue() + " is " + hasList(alphabeticalList, alphabeticalList.getValue()) + " times in list");
            alphabeticalList = alphabeticalList.getNext();
        }

        System.out.println("character " + alphabeticalList.getValue() + " is " + hasList(alphabeticalList, alphabeticalList.getValue()) + " times in list");
        System.out.println(symbolList);
        System.out.println("the result of " + symbolList + " is " + mathGenerator(symbolList));

        System.out.println("the name Lior shows " + countStudents(studentList, "Lior") + " times");
        System.out.println("reversed list " + studentList + ": " + reverseString(studentList));

        for (Product product : products) {
            b.addProduct(product);
        }

        System.out.println("Total basket: " + b.total());
        b.addProduct(new Product("Chocolate", "sweets", 10.9));
        System.out.println("now it is: " + b);
        b.removeProduct(products[products.length - 1]);
        System.out.println("now it is: " + b);
        System.out.println(polinomCounter(equation1, equation2));
        System.out.println(rearrangeSumList(reverse(arrange)));
    }

    public static void insertAtEnd(Node<Integer> list, int value) {
        Node<Integer> p = list;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        Node<Integer> temp = new Node<Integer>(value);
        p.setNext(temp);
    }

    public static Node<Integer> reverse(Node<Integer> toReverse) {
        Node<Integer> p = toReverse;
        Node<Integer> reversed = new Node<>(0);
        while (p != null) {
            insertAtEnd(reversed, p.getValue());
            p = p.getNext();
        }
        return reversed.getNext();
    }

    public static boolean isExistList(Node<Integer> n, int num) {
        while (n.getNext() != null) {
            n = n.getNext();
            if (n.getValue() == num) {
                return true;
            }
        }
        return false;
    }

    public static int sumList(Node<Integer> n) {
        int sum = 0;
        int count = 0;
        while (count != listLength(n)) {
            sum += n.getValue();
            n = n.getNext();
        }
        return sum;
    }

    public static <T> int listLength(Node<T> n) {
        int count = 0;
        Node<T> p = n;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    }

    public static Node<Integer> debugList(Node<Integer> n, int num) {
        Node<Integer> p = n;
        while (n.getNext() != null) {
            if (n.getNext().getValue() == num) {
                n.setNext(n.getNext().getNext());
            }
            if (n.getNext() != null && n.getNext().getValue() != num) {
                n = n.getNext();
            }
        }
        if (p.getValue() == num) {
            p = p.getNext();
        }
        return p;
    }

    public static int hasList(Node<Character> n, char c) {
        int count = 0;
        while (n.getNext() != null) {
            if (n.getValue() == c) {
                count++;
            }
            n = n.getNext();
        }
        if (n.getValue() == c) {
            count++;
        }
        return count;
    }

    public static Node<Integer> mathGenerator(Node<Character> numOperatorList) {
        Node<Integer> resultsList = new Node<Integer>(0);
        Node<Integer> p = resultsList;
        int num1 = 1, num2 = 1;
        char operator = 'a';

        while (numOperatorList != null) {
            try {
                num1 = numOperatorList.getValue() - '0';
                num2 = numOperatorList.getNext().getNext().getValue() - '0';
                operator = numOperatorList.getNext().getValue();
                if (operator == '+') {
                    p.setNext(new Node<>(num1 + num2));
                }
                if (operator == '-') {
                    p.setNext(new Node<>(num1 - num2));
                }
                if (operator == '*') {
                    p.setNext(new Node<>(num1 * num2));
                }
                if (operator == '/') {
                    p.setNext(new Node<>(num1 / num2));
                }
                p = p.getNext();
                numOperatorList = numOperatorList.getNext().getNext().getNext();

            } catch (ArithmeticException e) {
                System.out.println("you cant devide by zero");
                numOperatorList = numOperatorList.getNext().getNext().getNext();
            }
        }

        return resultsList.getNext();
    }

    public static int countStudents(Node<String> studentsList, String name) {
        String firstName = "";
        int count = 0;
        int countStudent = 0;
        boolean wasSpace = false;

        while (studentsList != null) {
            count = 0;
            wasSpace = false;
            for (int i = 0; i < studentsList.getValue().length(); i++) {
                if (wasSpace || studentsList.getValue().charAt(i) == ' ') {
                    wasSpace = true;
                } else {
                    count++;
                }
            }
            firstName = studentsList.getValue().substring(0, count);
            studentsList = studentsList.getNext();

            if (name.equals(firstName)) {
                countStudent++;
            }
        }
        return countStudent;
    }

    public static Node<String> reverseString(Node<String> strings) {
        int length = listLength(strings);
        String[] stringsArr = new String[length];
        Node<String> reversed = null;

        for (int i = 1; i <= stringsArr.length; i++) {
            stringsArr[stringsArr.length - i] = strings.getValue();
            strings = strings.getNext();
        }
        for (int i = 0; i < length; i++) {
            reversed = new Node<>(stringsArr[i]);
        }
        return reversed;
    }

    public static int countMost(Node<Sheshbesh> numbers) {
        int[] arr = new int[listLength(numbers)];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        Node<Sheshbesh> p = numbers;

        while (p != null) {
            arr[p.getValue().getNum1() - 1]++;
            arr[p.getValue().getNum2() - 1]++;
            p = p.getNext();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return max;
    }

    public static Node<Polinom> polinomCounter(Node<Polinom> list1, Node<Polinom> list2) {
        Node<Polinom> sum = null;
        int factor = 0;
        int power = 0;
        int maxFactor = Integer.MIN_VALUE;
        int maxPower = Integer.MIN_VALUE;

        while (list1 != null || list2 != null) {
            factor += list1.getValue().getFactor() + list2.getValue().getFactor();
            power += list1.getValue().getPower() + list2.getValue().getPower();

            sum = new Node<>(new Polinom(factor, power));

            list1 = list1.getNext();
            list2 = list2.getNext();
        }
        return sum;
    }

    public static Node<Integer> rearrangeSumList(Node<Integer> integerNode) {
        Node<Integer> arranged = null;
        Node<Integer> copy = integerNode;
        int sum = 0;
        while (copy != null) {
            sum = 0;
            if (copy.getValue() < copy.getNext().getValue()) {
                sum += copy.getValue();
                copy = copy.getNext();
                while (copy != null && copy.getValue() < copy.getNext().getValue()) {
                    sum += copy.getValue();
                    copy = copy.getNext();
                }
                arranged = new Node<>(sum, arranged);
            } else {
                sum += copy.getValue();
                arranged = new Node<>(sum, arranged);
                copy = copy.getNext();
            }
        }
        return arranged;
    }
}
