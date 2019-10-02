package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        try (FileInputStream inputStream = new FileInputStream(file1)) {
            try (FileOutputStream outputStream = new FileOutputStream(file2)) {

                //put file into a byte array
                byte[] bytes = new byte[inputStream.available()];
                int count = inputStream.read(bytes);

                //convert byte array to chars
                ArrayList<Character> characterArrayList = new ArrayList<>();
                for (int i = 0; i < bytes.length; i++) {
                    characterArrayList.add((char) bytes[i]);
                }

                //convert chars into strings that are doubles
                ArrayList<String> stringArrayList = new ArrayList<>();
                String temp = null;
                for (int i = 0; i < characterArrayList.size(); i++) {
                    if (characterArrayList.get(i) > 32) {
                        if (temp == null) {
                            temp = String.valueOf(characterArrayList.get(i));
                        } else {
                            temp = temp + characterArrayList.get(i);
                        }
                    } else {
                        if (temp != null) {
                            stringArrayList.add(temp);
                            temp = null;
                        }
                        temp = null;
                    }
                }
                stringArrayList.add(temp);

                //write doubles to file two
                int sALCount = 0;

                for (String string : stringArrayList) {
                    double dHold = Double.valueOf(string);
                    int intBuf = (int) Math.round(dHold);
                    byte[] buffer = String.valueOf(intBuf).getBytes();
                    outputStream.write(buffer);
                    sALCount++;
                    if (sALCount != stringArrayList.size()) {
                        outputStream.write(' ');
                        count++;
                    }
                }
                inputStream.close();
                outputStream.close();
            }
        }

    }
}
