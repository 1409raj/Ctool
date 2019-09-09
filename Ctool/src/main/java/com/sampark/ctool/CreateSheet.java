package com.sampark.ctool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.qoppa.org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.qoppa.org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.qoppa.org.apache.poi.xwpf.usermodel.XWPFRun;
import com.qoppa.org.apache.poi.xwpf.usermodel.XWPFTable;
import com.qoppa.org.apache.poi.xwpf.usermodel.XWPFTableCell;
import com.qoppa.org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreateSheet {

	
	public static void main(String[] args)throws Exception {

	      //Blank Document
	      XWPFDocument document = new XWPFDocument();

	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File("D:\\home\\create_table.docx"));
	      XWPFParagraph paragraph = document.createParagraph();
	      
	      XWPFRun run1=paragraph.createRun();
	      run1.setText("Date :31-05-2019 \\n");
	     
	    //create Paragraph
	     
	      XWPFRun run = paragraph.createRun();
	      run.setText("At tutorialspoint.com, we strive hard to " +
	         "provide quality tutorials for self-learning " +
	         "purpose in the domains of Academics, Information " +
	         "Technology, Management and Computer Programming"+
	         "Languages.");
	      
	      //create table
	      XWPFTable table = document.createTable();
	      
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	    
	      tableRowOne.getCell(0).setText("col one, row one");
	      tableRowOne.addNewTableCell().setText("col two, row one");
	      tableRowOne.addNewTableCell().setText("col three, row one");

	      //create second row
	      XWPFTableRow tableRowTwo = table.createRow();
	      
	      tableRowTwo.getCell(0).setText("col one, row two");
	      tableRowTwo.getCell(1).setText("col two, row two");
	      tableRowTwo.getCell(2).setText("col three, row two");

	      //create third row
	      XWPFTableRow tableRowThree = table.createRow();
	      
	      tableRowThree.getCell(0).setText("col one, row three");
	      tableRowThree.getCell(1).setText("col two, row three");
	      tableRowThree.getCell(2).setText("col three, row three");

	      document.write(out);
	      out.close();
	      
	      
	       

	      
	     
	   }
}
