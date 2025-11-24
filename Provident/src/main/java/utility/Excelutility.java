package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelutility {

	public static Workbook workbook;
	private static Sheet sheet;
	private static String excelFilePath;
	private static FileInputStream fileInputStream;

	public Excelutility(String excelFilePath, String sheetName) {
		this.excelFilePath = excelFilePath;
		try {
			FileInputStream fileInputStream = new FileInputStream(excelFilePath);
			workbook = WorkbookFactory.create(fileInputStream);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Excelutility() {

	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColumnCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	public String getCellData(int rowNum, int colNum) {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}

	public void setCellData(int rowNum, int colNum, String data) {
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellValue(data);

		try {
			FileOutputStream fileOut = new FileOutputStream(excelFilePath);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static List<String> getExcelData(String filePath, String sheetName) {
	        List<String> excelDataList = new ArrayList<>();

	        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
	            Workbook workbook = new XSSFWorkbook(fileInputStream);
	            Sheet sheet = workbook.getSheet(sheetName);

	            Iterator<Row> rowIterator = sheet.iterator();

	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Iterator<Cell> cellIterator = row.iterator();

	                while (cellIterator.hasNext()) {
	                    Cell cell = cellIterator.next();
	                    excelDataList.add(cell.toString());
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return excelDataList;
	    }

	public List<Map<String, String>> getDataFromExcel() {
		List<Map<String, String>> data = new ArrayList<>();

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		for (int i = 1; i < rowCount; i++) {
			Map<String, String> rowData = new HashMap<>();

			for (int j = 0; j < colCount; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				DataFormatter formatter = new DataFormatter();
				String columnName = sheet.getRow(0).getCell(j).getStringCellValue();
				rowData.put(columnName, formatter.formatCellValue(cell));
			}

			data.add(rowData);
		}

		return data;
	}

	public static Map<String, Map<String, String>> readExcelData() {
		Map<String, Map<String, String>> agencyDataMap = new HashMap<>();

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// Skip the header row
			if (row.getRowNum() == 0) {
				continue;
			}

			Map<String, String> rowData = new HashMap<>();
			String agencyName = row.getCell(0).getStringCellValue(); // Assuming agency name is in the first column

			// Iterate over cells in the current row and store data in the map
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int columnIndex = cell.getColumnIndex();
				String columnName = sheet.getRow(0).getCell(columnIndex).getStringCellValue();
				String cellValue = cell.getStringCellValue();
				rowData.put(columnName, cellValue);
			}

			// Store the row data in the agencyDataMap
			agencyDataMap.put(agencyName, rowData);
		}

		return agencyDataMap;
	}

	// get all row value in map from excel sheet
	public LinkedHashMap<String, Map<String, String>> getAllDataInMap(String fileName, String sheetName)
			throws IOException {
		fileInputStream = new FileInputStream(fileName);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);

		LinkedHashMap<String, Map<String, String>> rowData = new LinkedHashMap<>();
		List<String> columnHeader = new ArrayList<>();

		Row row = sheet.getRow(0);

		Iterator<Cell> cellIterator = row.cellIterator();

		while (cellIterator.hasNext()) {
			columnHeader.add(cellIterator.next().getStringCellValue());
		}

		int columnCount = row.getPhysicalNumberOfCells();


		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Map<String, String> singleRowData = new HashMap<String, String>();
			Row row1 = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row1.getCell(j);
				cell.setCellType(CellType.STRING);
				singleRowData.put(columnHeader.get(j), cell.getStringCellValue());
				singleRowData.put("rowNum", String.valueOf(row1.getRowNum()));

			}
			rowData.put(String.valueOf(i), singleRowData);
		}

		return rowData;

	}

	// Get all column values of single row based on condition
	public HashMap<String, String> getValueUsingRowValue(String filePath, String sheetName, String scenario)
            throws IOException {
        fileInputStream = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fileInputStream); // Use WorkbookFactory to handle both XLSX and XLS
        sheet = workbook.getSheet(sheetName);
        HashMap<String, String> hashMap = new HashMap<>();

        for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Cell firstCell = sheet.getRow(rowNum).getCell(0);

            if (firstCell != null && firstCell.toString().equalsIgnoreCase(scenario)) {
                Row currentRow = sheet.getRow(rowNum);

                for (int i = 1; i < currentRow.getPhysicalNumberOfCells(); i++) {
                    Cell cell = currentRow.getCell(i);
                    String columnname = sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue();

                    // Use DataFormatter to get cell value as string
                    DataFormatter dataFormatter = new DataFormatter();
                    String columnValue = dataFormatter.formatCellValue(cell);

                    hashMap.put(columnname, columnValue);
                }
            }
        }
        System.out.println(hashMap);
        return hashMap;
    }

	public static void main(String[] args) throws IOException {
		Map<String, String> excelValue = new HashMap<>();
		/*
		 * for (Iterator<Map.Entry<String, Map<String, String>>> iterator =
		 * getAllDataInMap("", "").entrySet() .iterator(); iterator.hasNext();) {
		 * Map.Entry<String,Map<String,String>> values=iterator.next();
		 * excelValue=values.getValue();
		 * 
		 * } System.out.println(excelValue); }
		 */

	}
}