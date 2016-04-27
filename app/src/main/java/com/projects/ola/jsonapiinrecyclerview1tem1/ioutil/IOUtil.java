package com.projects.ola.jsonapiinrecyclerview1tem1.ioutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Ola on 2016-04-27.
 */
public class IOUtil {

    public static String getStringFromInputStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        if (in != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            tryToAppendString(sb, br);
        }
        return sb.toString();
    }

    private static void tryToAppendString(StringBuilder sb, BufferedReader br) {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

