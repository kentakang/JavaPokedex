package com.kentakang.pokedex;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DexParser dex = new DexParser();
        Scanner s = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Hi, This is Pokedex Finder : ");
            n = s.nextInt();
            if (n < dex.countLines() - 1)
                break;
            else
                System.out.println("There is no Pokemon for that number.");
        }
        String[] type = dex.getType(n);

        System.out.println("Pokemon Info");
        System.out.println("Pokedex Number : " + n);
        System.out.println("Name : " + dex.getName(n));
        System.out.print("Type : ");
        for (int i = 0; i < 2; i++) {
            if (type[i] == null)
                break;

            System.out.print(type[i] + " ");
        }
    }
}
