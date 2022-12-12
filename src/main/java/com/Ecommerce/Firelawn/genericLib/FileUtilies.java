package com.Ecommerce.Firelawn.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.mysql.jdbc.Driver;

/**
 * 
 * @author user
 *
 */
public class FileUtilies {
	
	public static Connection con;
	/**
	 * It is used to read the data from property file. (@param= parameter)
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertydata(String key) throws IOException {
	Properties p= new Properties();
	FileInputStream fis=new FileInputStream(AutoConstant.propertyFilepath);
	p.load(fis);
	return p.getProperty(key);

}
	
	/**
	 * 
	 * @param Sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String Sheetname,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		String s =wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
		return s;
		
	}
	
	/**
	 * it is used to read the data from database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getDataDb() throws SQLException {
		Driver dref= new Driver();
		DriverManager.registerDriver(dref);
		 return  DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
					
	}
	
	/**
	 * it is execute the query
	 * @param query
	 * @param columnName
	 * @param ExpectedResults
	 * @return
	 * @throws SQLException
	 */
	
	public String queryExecution(String query, int columnName, String ExpectedResults) throws SQLException {
		Statement statement= con.createStatement();
		ResultSet result= statement.executeQuery(query);
		
		while(result.next()) {
			if (result.getString(columnName).equals(ExpectedResults)) {
				break;
			}
			else
			{
				System.out.println("Data not found");
			}
		}
		return ExpectedResults;
	}
	/**
	 * close the database connection
	 * @throws SQLException 
	 * 
	 */
	public static void closedb() throws SQLException {
		con.close();
	}
}

