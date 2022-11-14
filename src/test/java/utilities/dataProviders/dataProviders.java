package utilities.dataProviders;

import org.testng.annotations.DataProvider;

import utilities.Constants;
import utilities.ExcelUtils;

public class dataProviders 
{
	@DataProvider
	public Object[][] reg() throws Exception
	{
		String rootDir = System.getProperty("user.dir");
        Object[][] testObjArray = ExcelUtils.getTableArray(rootDir + Constants.EXCEL_DIRECTORY,Constants.EXCEL_FIRST_TAB);

        return (testObjArray);

	}
}
