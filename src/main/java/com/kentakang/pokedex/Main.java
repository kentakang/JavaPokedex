package com.kentakang.pokedex;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DexParser dex = new DexParser();
        Scanner s = new Scanner(System.in);
        int n = 0;

        if (dex.dataCheck() == false)
            dex.dataInit();

        System.out.print("Hi, This is Pokedex Finder\n");
        while (true) {
            System.out.print("Please enter the Pokedex Number : ");

            String str = s.nextLine();
            if (str.equals("reinit"))
                dex.dataReInit();

            n = Integer.parseInt(str);
            if (n < dex.countLines())
                break;
            else
                System.out.println("There is no Pokemon for that number.");
        }

        String[] type = dex.getType(n);

        System.out.print(
                "Pokemon Info\n" + "Pokedex Number : " + n +
                        "\nName : " + dex.getName(n) + "\nType : ");

        for (int i = 0; i < 2; i++) {
            if (type[i] == null)
                break;

            System.out.print(type[i] + " ");
        }
    }
}
