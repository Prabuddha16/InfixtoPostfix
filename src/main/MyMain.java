package main;

import infix.postfix.InfixToPostfix;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the infix :");
        String infixString = sc.next();
        InfixToPostfix convertor = new InfixToPostfix();
        String postfix = convertor.infixToPostfix(infixString);
        System.out.println("Postfix = " + postfix);
    }
}
