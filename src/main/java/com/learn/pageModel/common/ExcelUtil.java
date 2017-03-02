package com.learn.pageModel.common;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by chandrad on 2/23/17.
 */
public class ExcelUtil {


    public static class StaticProvider {


        @DataProvider(name = "register")
        public static Object[][] testDataSignIn() {
            Object[][] arrayObject = getExcelData("src/main/resources/TestData.xls", "Sheet1");
            return arrayObject;
        }

        @DataProvider(name = "20columnData")
        public static Object[][] testDataSignUP() {
            Object[][] arrayObject = getExcelData("src/main/resources/TestData.xls", "Sheet0");
            return arrayObject;
        }


        public static String[][] getExcelData(String filePath, String sheetName) {
            String[][] arrayExcelData = null;

            FileInputStream fs = null;
            try {
                fs = new FileInputStream(filePath);

               // jxl library

                Workbook wb = Workbook.getWorkbook(fs);
                Sheet sh = wb.getSheet(sheetName);

                int totalNoOfCols = sh.getColumns();   // 20
                int totalNoOfRows = sh.getRows();       // 8

                arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];


                for (int i = 1; i < totalNoOfRows; i++) {


                    for (int j = 0; j < totalNoOfCols; j++) {


                        arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();

                        // [0][0] = A1
                        // [0][1] = john




                     //   [3][3] = bar4

                        // arrayExcelData[0][0] = sh.getCell(0, 1).getContents();
                        // arrayExcelData[0][1] = sh.getCell(1, 1).getContents();
                        // arrayExcelData[0][2] = sh.getCell(2, 1).getContents();


                        // arrayExcelData[0][20] = sh.getCell(20, 1).getContents();


                        //  arrayExcelData[1][0] = sh.getCell(0, 2).getContents();
                        // arrayExcelData[1][1] = sh.getCell(1, 2).getContents();
                        // arrayExcelData[1][2] = sh.getCell(2, 2).getContents();

                        // arrayExcelData[1][20] = sh.getCell(20, 2).getContents();


                        // arrayExcelData[7][0] = sh.getCell(0, 8).getContents();

                    }
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return arrayExcelData;
        }


    }
}
