import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenTesting_Day11 {
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        String file = path + "\\src\\test\\resources\\testdata.xlsx";
        String sheet = "Sheet2";
        //read file excel
//        FileInputStream excelFile = new FileInputStream(file);
        //truy cập vào file data test, file excel và sheet chứa data
//        excelWBook = new XSSFWorkbook(excelFile);
//        excelSheet = excelWBook.getSheet("Sheet1");
//        System.out.println(getCellData(1, 1));
        getTableArray(file, sheet);
    }

    //đọc data từ file excel
    public static String getCellData(int row, int col) {
        excelCell = excelSheet.getRow(row).getCell(col);
        String cellData = excelCell.getStringCellValue();
        return cellData;
    }

    public static Object[][] getTableArray(String filePath, String sheetName) throws IOException {
        //int array = new int[3][4]; 3 dòng , 4 cột
        //int [][] array = new int[3][4]; 3 dòng , 4 cột
        //int array = new int[][]{{1,2}, {2,5}}

        String[][] newTableArray = null;
        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            //truy cập vào file data test, file excel và sheet chứa data
            excelWBook = new XSSFWorkbook(excelFile);
            excelSheet = excelWBook.getSheet(sheetName);
            int startRow = 1;
            int startCol = 1;
            int ci, cj;
            int totalRows = excelSheet.getLastRowNum();
            int totalCols = excelSheet.getRow(1).getLastCellNum() - 1;
            System.out.println("totalRow " + totalRows);
            System.out.println("totalCol " + totalCols);

            newTableArray = new String[totalRows][totalCols];
            for (int i = startRow; i <= totalRows; i++) {
                ci = i - 1; //vị trí index row của new table
                for (int j = startCol; j <= totalCols; j++) {
                    cj = j - 1;
                    System.out.println("table array:" + ci + cj);
                    newTableArray[ci][cj] = getCellData(i, j);
                    System.out.println(newTableArray[ci][cj]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newTableArray;
    }
}
