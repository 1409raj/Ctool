package com.sampark.ctool.common;

import java.io.*;

import java.math.BigInteger;

import java.text.Format;

import java.util.*;

import org.apache.poi.xwpf.usermodel.*;

 

/**

*

* @author Mark Beardsley

*/

public class NumberingTest1 {

   

 

   

    public static void main(String abc[]) {

      

       String strCurr = null;

      

       strCurr = getIndianCurrencyFormat("1000000");

      

       System.out.println(" Currency output "+strCurr);

   

      

    }

   

    public static String getIndianCurrencyFormat(String amount) {

        StringBuilder stringBuilder = new StringBuilder();

        char amountArray[] = amount.toCharArray();

        int a = 0, b = 0;

        for (int i = amountArray.length - 1; i >= 0; i--) {

            if (a < 3) {

                stringBuilder.append(amountArray[i]);

                a++;

            } else if (b < 2) {

                if (b == 0) {

                    stringBuilder.append(",");

                    stringBuilder.append(amountArray[i]);

                    b++;

                } else {

                    stringBuilder.append(amountArray[i]);

                    b = 0;

                }

            }

        }

        return stringBuilder.reverse().toString();

    }

   

    

    

}
