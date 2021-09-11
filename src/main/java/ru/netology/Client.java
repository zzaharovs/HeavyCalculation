package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 8081;

        try (Socket client = new Socket(host, port);
             Scanner sc = new Scanner(System.in);
             PrintWriter output = new
                     PrintWriter(client.getOutputStream(), true);
             BufferedReader input = new
                     BufferedReader(new InputStreamReader(client.getInputStream()))) {


            //Печатаем запрос числа
            System.out.println(input.readLine());

            //Отправляем число от которого надо рассчитать число Фиббоначи
            output.println(sc.nextLine());

            //Печатаем число фиббоначи
            System.out.println(input.readLine());


        } catch (IOException ex) {

            ex.printStackTrace();

        }
    }
}
