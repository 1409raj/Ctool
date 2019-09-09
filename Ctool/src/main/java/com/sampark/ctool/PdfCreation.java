package com.sampark.ctool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sampark.ctool.util.CommonUtils;

public class PdfCreation {

	public static void main(String[] args) {
		 String FILE = CtoolConstanats.folder_base+"Testpdf"+".pdf";
     	
         Document doc = new Document();
         BaseFont bf;
		try {
			bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
	         Font font = new Font(Font.getFamily("Trebuchet MS"), 10,Font.NORMAL);
	         Font tabletext = new Font(Font.getFamily("Trebuchet MS"), 10,Font.NORMAL);
	         Font fontnumber = new Font(Font.getFamily("Freight sans"), 11,Font.NORMAL);
	         Date date = new Date();
	 		String dateName = CommonUtils.formatDate(date,"dd-MM-yyyy");
	 		
	         /* Basic PDF Creation inside servlet */
	 		
	      //   PdfWriter.getInstance(doc, out);
	      PdfWriter.getInstance(doc, new FileOutputStream(FILE));   
	 		
	 		
	         doc.open();
	         
	         
	         String imageName1 = CtoolConstanats.folder_base+"logo.jpg";
             Image image1 = Image.getInstance(imageName1);
             image1.scaleToFit(100f, 200f);
             image1.setAlignment(Element.ALIGN_RIGHT);
             
             String imageName2 = CtoolConstanats.folder_base+"H1.png";
             Image image2 = Image.getInstance(imageName2);
             image2.scaleToFit(350f, 350f);
 			image2.setAlignment(Element.ALIGN_LEFT);
 			image2.setAbsolutePosition(40, 10);
 			image2.setSpacingBefore(1000);
 			
             doc.add(image1);
             doc.add(image2);
  			
             PdfPTable table1 = new PdfPTable(1);
            
             PdfPCell cell=new PdfPCell(new Phrase("Date :20-06-2019", font));
             cell.setBorder(PdfPCell.NO_BORDER); 
             cell.setPaddingTop(1f);
             cell.setNoWrap(false);
             cell.setHorizontalAlignment(Element.ALIGN_LEFT);
             table1.setHorizontalAlignment(Element.ALIGN_LEFT);
             table1.addCell(cell);
             
             PdfPCell cell2=new PdfPCell(new Phrase("Document No :0.9538961874249628", font));
             cell2.setBorder(PdfPCell.NO_BORDER); 
             cell2.setPaddingTop(3f);
             cell2.setNoWrap(false);
             cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
             table1.setHorizontalAlignment(Element.ALIGN_LEFT);
             table1.addCell(cell2);
             
	         doc.add(table1);
	         
	         PdfPTable table2 = new PdfPTable(1);
	            
             PdfPCell cell3=new PdfPCell(new Phrase("Mr.Vibhash Gaurav", font));
             cell3.setBorder(PdfPCell.NO_BORDER); 
             cell3.setPaddingTop(15f);
             cell3.setNoWrap(false);
             cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
             table2.setHorizontalAlignment(Element.ALIGN_LEFT);
             table2.addCell(cell3);
             
             PdfPCell cell4=new PdfPCell(new Phrase("Emp Code :1302017", font));
             cell4.setBorder(PdfPCell.NO_BORDER); 
             cell4.setPaddingTop(3f);
             cell4.setNoWrap(false);
             cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
             table2.setHorizontalAlignment(Element.ALIGN_LEFT);
             table2.addCell(cell4);
             
			doc.add(table2);
			Font underlineFont = new Font(Font.getFamily("Trebuchet MS"), 11, Font.UNDERLINE);
			Paragraph paragraph = new Paragraph("INCREMENT LETTER", underlineFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setSpacingBefore(5);
			paragraph.setSpacingAfter(5);

			doc.add(paragraph);
			
			
			Paragraph paragraph1 = new Paragraph("Dear Vibhash",font);
			paragraph1.setAlignment(Element.ALIGN_LEFT);
			
			doc.add(paragraph1);
			
		   	String para1="As a Company, we accomplished our target for the year 2017-2018 leaving a small percentage to be commissioned.Together we can achieve better overcoming the odds that we face in business. We need to continuously synergise and collaborate to achieve Organisational goals.";	
			Paragraph paragraph2 = new Paragraph(para1,font);
			paragraph2.setSpacingBefore(5);
			paragraph2.setSpacingAfter(5);
			paragraph2.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph2);
	   		
	   		
	   		String para2="Based on your Self assessment and your Superior’s assessment of your performance for the year 2017-2018,we revise your CTC as per the following:";	
			Paragraph paragraph3 = new Paragraph(para2,font);
			paragraph3.setSpacingBefore(5);
			paragraph3.setSpacingAfter(5);
			
			paragraph3.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph3);
	   		
	   		String para3="1. Your new Fixed Annual CTC for the year 2018 - 2019 has been revised to Rs. 835440/-. Detailed CTC break up will be as per the enclosed Annexure-A. This revised CTC will be effective from April 01, 2018.";	
			Paragraph paragraph4 = new Paragraph(para3,font);
			paragraph4.setSpacingBefore(5);
			paragraph4.setSpacingAfter(5);
			
			paragraph4.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph4);
	   		
	   		
	   		String para4="2. Your Variable Pay for the year 2017-2018 based on Company’s performance and your performance is Rs 83544/- which will be disbursed to you in this month itself. Same will be subject to taxation as per Government rules";	
			Paragraph paragraph5 = new Paragraph(para4,font);
			paragraph5.setSpacingBefore(5);
			paragraph5.setSpacingAfter(5);
			
			paragraph5.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph5);
	   		
	   		String para5="3. Information in Clause 1 & 2 are highly confidential and therefore not to be disclosed to anyone in and/or outside the Company. In case, it is discovered that someone has breached this Clause then the Company reserves the right to take action against that individual.";	
			Paragraph paragraph6 = new Paragraph(para5,font);
			paragraph6.setSpacingBefore(5);
			paragraph6.setSpacingAfter(5);
			
			paragraph5.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph6);
	   		
	   		String para6="4. In case you resign within a period of two months from the date of disbursement of Variable Pay for 2017-2018, the Company will recover the Variable pay disbursed to you as part of the full and final settlement.";	
			Paragraph paragraph7 = new Paragraph(para6,font);
			paragraph7.setSpacingBefore(5);
			paragraph7.setSpacingAfter(5);
			
			paragraph5.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph7);
	   		
	   		
	   		String para7="5. Please continue to align with Organizational culture and Organizational Policies and Procedures";	
			Paragraph paragraph8 = new Paragraph(para7,font);
			paragraph8.setSpacingBefore(5);
			paragraph8.setSpacingAfter(5);
			
			paragraph5.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph8);
	   		
	   		
	   		String para8="Kindly acknowledge receipt of this letter by returning signed duplicate copy to HR.";	
			Paragraph paragraph9 = new Paragraph(para8,font);
			paragraph9.setSpacingBefore(5);
			paragraph9.setSpacingAfter(5);
			
			paragraph5.setAlignment(Element.ALIGN_JUSTIFIED);
	   		doc.add(paragraph9);
	   		
	   		
	   		
	   	  PdfPTable table3 = new PdfPTable(1);
          
          PdfPCell cell5=new PdfPCell(new Phrase("With best regards,", font));
          cell5.setBorder(PdfPCell.NO_BORDER); 
          cell5.setPaddingTop(20f);
          cell5.setNoWrap(false);
          cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
          table3.setHorizontalAlignment(Element.ALIGN_LEFT);
          table3.addCell(cell5);
          
          PdfPCell cell6=new PdfPCell(new Phrase("For and on behalf of VAYU URJA BHARAT", font));
          cell6.setBorder(PdfPCell.NO_BORDER); 
          cell6.setPaddingTop(5f);
          cell6.setNoWrap(false);
          cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
          table3.setHorizontalAlignment(Element.ALIGN_LEFT);
          table3.addCell(cell6);
          
	         doc.add(table3);
	         
	         PdfPTable table4 = new PdfPTable(1);
	            
          PdfPCell cell7=new PdfPCell(new Phrase("Ankit", font));
          cell7.setBorder(PdfPCell.NO_BORDER); 
          cell7.setPaddingTop(15f);
          cell7.setNoWrap(false);
          cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
          table4.setHorizontalAlignment(Element.ALIGN_LEFT);
          table4.addCell(cell7);
          
          PdfPCell cell8=new PdfPCell(new Phrase("Director", font));
          cell8.setBorder(PdfPCell.NO_BORDER); 
          cell8.setPaddingTop(3f);
          cell8.setNoWrap(false);
          cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
          table4.setHorizontalAlignment(Element.ALIGN_LEFT);
          table4.addCell(cell8);
          
          doc.add(table4);
			
	   	
			 
			   
			   doc.add(image1);
			   
			   String para9="Annexure – A";	
				Paragraph paragraph10 = new Paragraph(para9,font);
				paragraph10.setSpacingBefore(5);
				paragraph10.setSpacingAfter(5);
				
				paragraph10.setAlignment(Element.ALIGN_JUSTIFIED);
		   		doc.add(paragraph10);
			  
	         doc.close();
	         
	         System.out.println("created");
	         
	         
	         
	         

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Font font = new Font(bf, 12);
      
	}

}
