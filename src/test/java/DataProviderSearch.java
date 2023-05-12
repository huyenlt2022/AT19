import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderSearch {
    @DataProvider(name = "data_search")
    public Object[][] getDataFromExcel() throws IOException {
        String path = System.getProperty("user.dir");
        String file = path + "\\src\\test\\resources\\testdata.xlsx";
        String sheet = "Sheet2";
        Object[][] dataSearch = ExcelUtils.getTableArray(file, sheet);
        return dataSearch;
        //dùng provider khác class
    }
}
