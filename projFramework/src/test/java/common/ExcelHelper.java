package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper
{
	private ArrayList<String> listHeader = new ArrayList<String>();
	private ArrayList<ArrayList<String>> listData = new ArrayList<ArrayList<String>>();

	public void SetExcelHeader()
	{
		try
		{
			File xlsxFile = new File(TestConfig.testDataDir + "TestData.xlsx");
			FileInputStream fis = new FileInputStream(xlsxFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			XSSFRow row = sheet.getRow(0);
			int colCount = row.getLastCellNum();
			System.out.println("ColCount=" + colCount);
			for (int j = 0; j < colCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				if(cell==null)
					listHeader.add("");
				else
					listHeader.add(cell.toString());
			}
			workbook.close();
			fis.close();
			System.out.println(listHeader);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void SetExcelData(String tcName)
	{
		try
		{
			File xlsxFile = new File(TestConfig.testDataDir + "TestData.xlsx");
			FileInputStream fis = new FileInputStream(xlsxFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowCount = sheet.getLastRowNum() + 1;
			for (int i = 1; i < rowCount; i++)
			{
				XSSFRow row = sheet.getRow(i);
				int colCount = row.getLastCellNum();
				String xlTcName = row.getCell(0).toString();
				if(xlTcName.equalsIgnoreCase(tcName))
				{
					ArrayList<String> currRow = new ArrayList<String>();
					for (int j = 0; j < colCount; j++)
					{
						XSSFCell cell = row.getCell(j);
						if(cell==null)
							currRow.add("");
						else
							currRow.add(cell.toString());
					}
					listData.add(currRow);
				}
				
			}
			workbook.close();
			fis.close();
			System.out.println(listData);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public String GetValue(int rowNum, String colName)
	{
		int colIndex = listHeader.indexOf(colName);
		return listData.get(rowNum).get(colIndex);
	}

}
