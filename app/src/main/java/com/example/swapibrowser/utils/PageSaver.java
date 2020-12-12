package com.example.swapibrowser.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PageSaver {

    public void save(Context c, String url, String itemType) {
        FileOutputStream fos = null;

        try {
            StringBuilder builder = new StringBuilder();
            builder.append(url);
            builder.append(" :");
            builder.append(itemType);
            fos = c.openFileOutput("lastPage.txt", Context.MODE_PRIVATE);
            fos.write(builder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveFavorite(Context c){
        FileOutputStream fos = null;
        StringBuilder builder = new StringBuilder();
        builder.append(read(c));
        if (check(builder.toString(), c)){
            builder.append("\n");
            try {
                fos = c.openFileOutput("favorites.txt", c.MODE_APPEND);
                fos.write(builder.toString().getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public ArrayList<String> readFavorite(Context c) {
        FileInputStream fis = null;
        ArrayList<String> faves = new ArrayList<>();
        try {
            fis = c.openFileInput("favorites.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;
            while((text = br.readLine()) != null){
                faves.add(text);
            }
            return faves;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faves;
    }

    public String read(Context c){
        FileInputStream fis = null;
        try {
            fis = c.openFileInput("lastPage.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while((text = br.readLine()) != null){
                sb.append(text);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public boolean check(String fav, Context c){
        ArrayList<String> exists = readFavorite(c);
        for (String s : exists){
            if (s.equals(fav)){
                return false;
            }
        }
        return true;
    }

    public void removeFavorite(Context c){
        FileOutputStream fos = null;
        ArrayList<String> exists = readFavorite(c);
        String page = read(c);
        StringBuilder sb = new StringBuilder();
        for (String s : exists) {
            if (!page.equals(s)) {
                sb.append(s);
                sb.append("\n");
            }
        }
        try {
            fos = c.openFileOutput("favorites.txt", c.MODE_PRIVATE);
            fos.write(sb.toString().getBytes());
            for (String s : readFavorite(c)) {
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
