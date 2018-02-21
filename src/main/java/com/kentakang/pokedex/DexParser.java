package com.kentakang.pokedex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.StringTokenizer;

public class DexParser {
    public static void dataInit() throws IOException {
        FileOutputStream output = new FileOutputStream("pokedex.txt");
        Document doc = Jsoup.connect("http://pokemondb.net/pokedex/national").get();
        Elements pokemonList = doc.select(".infocard-tall");

        for (Element pokemon : pokemonList) {
            Elements pokemonName = pokemon.select(".ent-name");
            Elements pokemonType = pokemon.select(".itype");
            String data = pokemonName.text() + ",";

            for (Element type : pokemonType) {
                data += type.text() + ",";
            }

            data += "\n";
            output.write(data.getBytes());
        }

        output.close();
    }

    public static boolean dataCheck() throws IOException {
        File file = new File("pokedex.txt");

        return file.exists();
    }

    public static int countLines() throws IOException {
        if (dataCheck() == false)
            dataInit();

        BufferedReader br = new BufferedReader(new FileReader("pokedex.txt"));
        int cnt = 0;

        while (true) {
            String line = br.readLine();
            cnt++;
            if (line == null)
                break;
        }

        br.close();
        return cnt;
    }

    public String getName(int n) throws IOException {
        if (dataCheck() == false)
            dataInit();

        BufferedReader br = new BufferedReader(new FileReader("pokedex.txt"));
        String line = "";

        if (n > countLines() - 1)
            return "There is no Pokemon for that number.";

        for (int i = 0; i < n; i++) {
            line = br.readLine();
        }

        StringTokenizer st = new StringTokenizer(line, ",");
        return st.nextToken();
    }

    public String[] getType(int n) throws IOException {
        if (dataCheck() == false)
            dataInit();

        BufferedReader br = new BufferedReader(new FileReader("pokedex.txt"));
        String line = "";
        String[] result = new String[2];
        int idx = 0;

        for (int i = 0; i < n; i++)
            line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, ",");
        st.nextToken();

        while (st.hasMoreTokens()) {
            result[idx] = st.nextToken();
            idx++;
        }

        return result;
    }
}
