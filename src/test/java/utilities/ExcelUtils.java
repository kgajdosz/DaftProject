package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 1;
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
			tabArray = new String[totalRows][totalCols - startCol]; 

			for (int row = startRow; row <= totalRows; row++) {
				for (int col = startCol; col < totalCols; col++) {
					tabArray[row - startRow][col - startCol] = getCellData(row, col);}}}
		catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();}
		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();}
		return (tabArray);
	}

	@SuppressWarnings("deprecation")
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		String retVal;
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		
		switch (Cell.getCellTypeEnum()) {
			case STRING:
				retVal = Cell.getRichStringCellValue().getString();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(Cell)) {
					retVal = String.valueOf(Cell.getDateCellValue());
				} else {
					retVal = String.valueOf(Cell.getNumericCellValue());
				}
				break;
			case BOOLEAN:
				retVal = String.valueOf(Cell.getBooleanCellValue());
				break;
			case FORMULA:
				retVal = String.valueOf(Cell.getNumericCellValue());
				break;
			case BLANK:
				retVal = "";
				break;
			default:
				retVal = "";
			}
		return retVal;
		
	}
}