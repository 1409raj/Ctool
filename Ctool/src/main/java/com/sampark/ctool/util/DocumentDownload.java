package com.sampark.ctool.util;

import java.io.*;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
// Document Object
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
//For adding content into PDF document
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.repository.EmployeeRepository;
import com.sampark.ctool.repositoryImpl.EmployeeRepositoryImpl;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;


@WebServlet("/documentDownload")
public class DocumentDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DocumentDownload() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
		try {
		//Getting list of employee to generate pdf documents.
		List<EmployeeBasicDetails> list = employeeRepository.employeePromtionListNotGenerated();
		
		//Set content type to application / pdf
        //browser will open the document only if this is set
        response.setContentType("application/pdf");
        //Get the output stream for writing PDF object        
        OutputStream out=response.getOutputStream();
        try {
        	
        	
            Document doc = new Document();
            
            BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font font = new Font(bf, 12);
            Font fontSmall = new Font(bf, 10);
            Font fontUnderline = FontFactory.getFont("Times-Roman", 11, Font.UNDERLINE);
            
            /* Basic PDF Creation inside servlet */
            PdfWriter.getInstance(doc, out);
            doc.open();
            String imageName1 = "D:\\CtoolPDF\\logo.jpg";
            Image image1 = Image.getInstance(imageName1);
            String imageName2 = "D:\\CtoolPDF\\H1.PNG";
            Image image2 = Image.getInstance(imageName2);
            String imageName3 = "D:\\CtoolPDF\\H2.PNG";
            for(int i=0;i<list.size();i++)
            {
            Image image3 = Image.getInstance(imageName3);
            // Creating image by file name
            image1 = Image.getInstance(imageName1);
            image1.scaleToFit(100f, 200f);
            image1.setAlignment(Element.ALIGN_RIGHT);
            doc.add(image1);
            
            PdfPTable table1 = new PdfPTable(1);
            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
            for(int aw=0;aw<1 ; aw++){
            	PdfPCell cell1 = new PdfPCell(new Phrase("Date :"+new Date().getDate(),font));
            	PdfPCell cell2 = new PdfPCell(new Phrase("Document No :",font));
            	PdfPCell cell3 = new PdfPCell(new Phrase(""));
            	PdfPCell cell4 = new PdfPCell(new Phrase(""));
            	PdfPCell cell5 = new PdfPCell(new Phrase("Mr.",font));
            	PdfPCell cell6 = new PdfPCell(new Phrase("Emp Code :",font));
                cell1.setBorder(PdfPCell.NO_BORDER); 
                cell2.setBorder(PdfPCell.NO_BORDER); 
                cell1.setPaddingLeft(0f);
                cell2.setPaddingLeft(0f);
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setBorder(PdfPCell.NO_BORDER); 
                cell4.setBorder(PdfPCell.NO_BORDER); 
                cell3.setPaddingLeft(0f);
                cell4.setPaddingLeft(0f);
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell5.setBorder(PdfPCell.NO_BORDER); 
                cell6.setBorder(PdfPCell.NO_BORDER); 
                cell5.setPaddingLeft(0f);
                cell6.setPaddingLeft(0f);
                cell5.setPaddingTop(20);
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                table1.addCell(cell1);
                table1.addCell(cell2);
                table1.addCell(cell3);
                table1.addCell(cell4);
                table1.addCell(cell5);
                table1.addCell(cell6);
 		    }
 		    doc.add(table1);
 		    String para = "INCREMENT LETTER";
	   		Paragraph paragraph = new Paragraph(para);
	   		paragraph.setAlignment(Element.ALIGN_CENTER);
	   		paragraph.setSpacingBefore(10);
	   		paragraph.setSpacingAfter(10);
	   		doc.add(paragraph);
 
	   		PdfPTable table2 = new PdfPTable(1);
	   		table2.setHorizontalAlignment(Element.ALIGN_LEFT);
            for(int aw=0;aw<1 ; aw++){
            	PdfPCell cell1 = new PdfPCell(new Phrase("Dear "+"tishu",font));
                cell1.setBorder(PdfPCell.NO_BORDER); 
                cell1.setPaddingLeft(0f);
                cell1.setNoWrap(false);
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(cell1);
 		    }
 		    doc.add(table2);
 		    String mainPara1 = "As a Company, we accomplished our target for the year 2017-2018 leaving a small percentage to be commissioned." + 
 		    		"Together we can achieve better overcoming the odds that we face in business. We need to continuously synergise " + 
 		    		"and collaborate to achieve Organisational goals.";
	   		Paragraph para1 = new Paragraph(mainPara1,font);
	   		para1.setSpacingBefore(10);
	   		para1.setSpacingAfter(5);
	   		doc.add(para1);
	   		String mainPara2 = "Based on your Self assessment and your Superior’s assessment of your performance for the year 2017-2018, we " + 
	   				"revise your CTC as per the following:";
	   		Paragraph para2 = new Paragraph(mainPara2,font);
	   		para2.setSpacingBefore(5);
	   		para2.setSpacingAfter(5);
	   		doc.add(para2);
	   		String mainPara3 = "1. Your new Fixed Annual CTC for the year 2018-2019 has been revised to Rs. ………/-. Detailed CTC break up will " + 
	   				"be as per the enclosed Annexure-A. This revised CTC will be effective from April 01, 2018.";
	   		Paragraph para3 = new Paragraph(mainPara3,font);
	   		para3.setSpacingBefore(3);
	   		para3.setSpacingAfter(3);
	   		doc.add(para3);
	   		String mainPara4 = "2. Your Incentive for the year 2017-2018 based on Solar Rooftop performance and your performance is Rs………/- " + 
	   				"which will be disbursed to you in this month itself. Same will be subject to taxation as per Government rules.";
	   		Paragraph para4 = new Paragraph(mainPara4,font);
	   		para4.setSpacingBefore(3);
	   		para4.setSpacingAfter(3);
	   		doc.add(para4);
	   		String mainPara5 = "3. Information in Clause 1 & 2 are highly confidential and therefore not to be disclosed to anyone in and/or outside the " + 
	   				"Company. In case, it is discovered that someone has breached this Clause then the Company reserves the right to " + 
	   				"take action against that individual.";
	   		Paragraph para5 = new Paragraph(mainPara5,font);
	   		para5.setSpacingBefore(3);
	   		para5.setSpacingAfter(3);
	   		doc.add(para5);
	   		String mainPara6 = "4. In case you resign within a period of two months from the date of disbursement of Variable Pay for 2017-2018, the " + 
	   				"Company will recover the Variable pay disbursed to you as part of the full and final settlement.";
	   		Paragraph para6 = new Paragraph(mainPara6,font);
	   		para6.setSpacingBefore(3);
	   		para6.setSpacingAfter(3);
	   		doc.add(para6);
	   		String mainPara7 = "5. Please continue to align with Organizational culture and Organizational Policies and Procedures";
	   		Paragraph para7 = new Paragraph(mainPara7,font);
	   		para7.setSpacingBefore(3);
	   		para7.setSpacingAfter(3);
	   		doc.add(para7);
	   		String mainPara8 = "Kindly acknowledge receipt of this letter by returning signed duplicate copy to HR.";
	   		Paragraph para8 = new Paragraph(mainPara8,font);
	   		para8.setSpacingBefore(10);
	   		para8.setSpacingAfter(10);
	   		doc.add(para8);
	   		String mainPara9 = "With best regards,";
	   		Paragraph para9 = new Paragraph(mainPara9,font);
	   		para9.setSpacingBefore(10);
	   		para9.setSpacingAfter(2);
	   		doc.add(para9);
	   		String mainPara10 = "For and on behalf of Hero Solar Energy Pvt. Ltd.";
	   		Paragraph para10 = new Paragraph(mainPara10,font);
	   		para10.setSpacingAfter(10);
	   		doc.add(para10);
	   		String mainPara11 = "Sunil Jain";
	   		Paragraph para11 = new Paragraph(mainPara11,font);
	   		para11.setSpacingAfter(1);
	   		doc.add(para11);
	   		String mainPara12 = "Director";
	   		Paragraph para12 = new Paragraph(mainPara12,font);
	   		para12.setSpacingAfter(15);
	   		doc.add(para12);
			image2 = Image.getInstance(imageName2);
			image2.scaleToFit(350f, 600f);
			image2.setAlignment(Element.ALIGN_LEFT);
			doc.add(image2);
			
			image3 = Image.getInstance(imageName1);
			image3.scaleToFit(100f, 200f);
			image3.setAlignment(Element.ALIGN_RIGHT);
			doc.add(image3);
			
			String mainPara13 = "Annexure – A";
	   		Paragraph para13 = new Paragraph(mainPara13,font);
	   		para13.setSpacingAfter(10);
	   		doc.add(para13);
			 
			
	   		PdfPTable table3 = new PdfPTable(2);
	   		
            	PdfPCell cell1 = new PdfPCell(new Phrase(" Name:",font));
            	PdfPCell cell2 = new PdfPCell(new Phrase("tishu",font));
            	PdfPCell cell3 = new PdfPCell(new Phrase("Employee Code:",font));
            	PdfPCell cell4 = new PdfPCell(new Phrase("EMP001",font));
            	PdfPCell cell5 = new PdfPCell(new Phrase("Designation: ",font));
            	PdfPCell cell6 = new PdfPCell(new Phrase("HR",font));
            	
                cell1.setPaddingLeft(2f);
                cell1.setNoWrap(false);
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                cell6.setPaddingLeft(0f);
                cell6.setNoWrap(false);
                cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                cell2.setPaddingLeft(0f);
                cell2.setNoWrap(false);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                cell3.setPaddingLeft(0f);
                cell3.setNoWrap(false);
                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                cell4.setPaddingLeft(0f);
                cell4.setNoWrap(false);
                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                cell5.setPaddingLeft(0f);
                cell5.setNoWrap(false);
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                table3.addCell(cell1);
                table3.addCell(cell2);
                table3.addCell(cell3);
                table3.addCell(cell4);
                table3.addCell(cell5);
                table3.addCell(cell6);
 		    doc.add(table3);
			
 		  
 		    
 		    String para14 = "CTC BREAK-UP";
	   		Paragraph para15 = new Paragraph(para14,fontUnderline);
	   		para15.setAlignment(Element.ALIGN_CENTER);
	   		para15.setSpacingBefore(10);
	   		para15.setSpacingAfter(10);
	   		doc.add(para15);
	   		
	   		
	   		PdfPTable table4 = new PdfPTable(3);
	   		table4.setWidthPercentage(100);
        	PdfPCell cell7 = new PdfPCell(new Phrase("SALARY COMPONENTS",fontSmall));
        	PdfPCell cell8 = new PdfPCell(new Phrase("MONTHLY",fontSmall));
        	PdfPCell cell9 = new PdfPCell(new Phrase("ANNUAL",fontSmall));
        	PdfPCell cell10 = new PdfPCell(new Phrase("INR",fontSmall));
        	PdfPCell cell11= new PdfPCell(new Phrase("A.                         BASE SALARY",fontSmall));
        	PdfPCell cell12 = new PdfPCell(new Phrase("Basic",fontSmall));
        	PdfPCell cell13 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell14 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell15 = new PdfPCell(new Phrase("HR",fontSmall));
        	PdfPCell cell16 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell17 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell18 = new PdfPCell(new Phrase("Transport Allowance",fontSmall));
        	PdfPCell cell19 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell20 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell21 = new PdfPCell(new Phrase("Special Allowance",fontSmall));
        	PdfPCell cell22 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell23 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell24 = new PdfPCell(new Phrase("Supplementary Allowance",fontSmall));
        	PdfPCell cell25 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell26 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell27 = new PdfPCell(new Phrase("Children Education Allowance",fontSmall));
        	PdfPCell cell28 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell29 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell30 = new PdfPCell(new Phrase("PF (Company's share)",fontSmall));
        	PdfPCell cell31 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell32 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell33 = new PdfPCell(new Phrase("TOTAL",fontSmall));
        	PdfPCell cell34 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell35 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell36= new PdfPCell(new Phrase("B.                         REIMBURSABLE (bills to be submitted as instructed)",fontSmall));
        	
        	PdfPCell cell37 = new PdfPCell(new Phrase("Medical",fontSmall));
        	PdfPCell cell38 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell39 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell40 = new PdfPCell(new Phrase("Residential Telephone",fontSmall));
        	PdfPCell cell41 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell42 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell43 = new PdfPCell(new Phrase("Attire",fontSmall));
        	PdfPCell cell44 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell45 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell46 = new PdfPCell(new Phrase("News paper, Books and periodicals",fontSmall));
        	PdfPCell cell47 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell48 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell49= new PdfPCell(new Phrase("C.                         TAXABLE COMPONENT (reimbursable as per law))",fontSmall));
        	
        	PdfPCell cell50 = new PdfPCell(new Phrase("LTA (1 basic)",fontSmall));
        	PdfPCell cell51 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell52 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell53= new PdfPCell(new Phrase("D.                         ELIGIBILITY AS PER COMPANY POLICY))",fontSmall));
        	
        	PdfPCell cell54 = new PdfPCell(new Phrase("Gratuity",fontSmall));
        	PdfPCell cell55 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell56 = new PdfPCell(new Phrase(" ",fontSmall));
        
        	PdfPCell cell57 = new PdfPCell(new Phrase("FIXED CTC (A+B+C+D)",fontSmall));
        	PdfPCell cell58 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell59 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	PdfPCell cell60 = new PdfPCell(new Phrase("Incentive \n \n \n (One time payment to be disbursed as per Company Policy)",fontSmall));
        	PdfPCell cell61 = new PdfPCell(new Phrase(" ",fontSmall));
        	PdfPCell cell62 = new PdfPCell(new Phrase("TOTAL CTC in INR (FIXED CTC + VARIABLE PAY)",fontSmall));
        	PdfPCell cell63 = new PdfPCell(new Phrase(" ",fontSmall));
        	
        	cell7.setRowspan(2);
            cell7.setNoWrap(false);
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell8.setNoWrap(false);
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            cell9.setNoWrap(false);
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            cell10.setNoWrap(false);
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            cell11.setNoWrap(false);
            cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell11.setColspan(3);
            
            cell12.setNoWrap(false);
            cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell13.setNoWrap(false);
            cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell14.setNoWrap(false);
            cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell15.setNoWrap(false);
            cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell16.setNoWrap(false);
            cell16.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell17.setNoWrap(false);
            cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell18.setNoWrap(false);
            cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell19.setNoWrap(false);
            cell19.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell20.setNoWrap(false);
            cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell21.setNoWrap(false);
            cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell22.setNoWrap(false);
            cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell23.setNoWrap(false);
            cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell24.setNoWrap(false);
            cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell25.setNoWrap(false);
            cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell26.setNoWrap(false);
            cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell27.setNoWrap(false);
            cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell28.setNoWrap(false);
            cell28.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell29.setNoWrap(false);
            cell29.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell30.setNoWrap(false);
            cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell31.setNoWrap(false);
            cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell32.setNoWrap(false);
            cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell33.setNoWrap(false);
            cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell34.setNoWrap(false);
            cell34.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell35.setNoWrap(false);
            cell35.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell36.setNoWrap(false);
            cell36.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell36.setColspan(3);
            
            cell37.setNoWrap(false);
            cell37.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell38.setNoWrap(false);
            cell38.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell39.setNoWrap(false);
            cell39.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell40.setNoWrap(false);
            cell40.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell41.setNoWrap(false);
            cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell42.setNoWrap(false);
            cell42.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell43.setNoWrap(false);
            cell43.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell44.setNoWrap(false);
            cell44.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell45.setNoWrap(false);
            cell45.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell46.setNoWrap(false);
            cell46.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell47.setNoWrap(false);
            cell47.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell48.setNoWrap(false);
            cell48.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell49.setNoWrap(false);
            cell49.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell49.setColspan(3);
            
            cell50.setNoWrap(false);
            cell50.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell51.setNoWrap(false);
            cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell52.setNoWrap(false);
            cell52.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell53.setNoWrap(false);
            cell53.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell53.setColspan(3);
            
            cell54.setNoWrap(false);
            cell54.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell55.setNoWrap(false);
            cell55.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell56.setNoWrap(false);
            cell56.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell57.setNoWrap(false);
            cell57.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell58.setNoWrap(false);
            cell58.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell59.setNoWrap(false);
            cell59.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell60.setNoWrap(false);
            cell60.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell60.setColspan(2);
            cell61.setNoWrap(false);
            cell61.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell62.setNoWrap(false);
            cell62.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell62.setColspan(2);
            cell63.setNoWrap(false);
            cell63.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            table4.addCell(cell7);
            table4.addCell(cell8);
            table4.addCell(cell9);
            table4.addCell(cell10);
            table4.addCell(cell10);
            table4.addCell(cell11);
            table4.addCell(cell12);
            table4.addCell(cell13);
            table4.addCell(cell14);
            
            table4.addCell(cell15);
            table4.addCell(cell16);
            table4.addCell(cell17);
            table4.addCell(cell18);
            table4.addCell(cell19);
            table4.addCell(cell20);
            table4.addCell(cell21);
            table4.addCell(cell22);
            table4.addCell(cell23);
            table4.addCell(cell24);
            table4.addCell(cell25);
            table4.addCell(cell26);
            table4.addCell(cell27);
            table4.addCell(cell28);
            table4.addCell(cell29);
            table4.addCell(cell30);
            table4.addCell(cell31);
            table4.addCell(cell32);
            table4.addCell(cell33);
            table4.addCell(cell34);
            table4.addCell(cell35);
            table4.addCell(cell36);
            table4.addCell(cell37);
            table4.addCell(cell38);
            table4.addCell(cell39);
            table4.addCell(cell40);
            table4.addCell(cell41);
            table4.addCell(cell42);
            table4.addCell(cell43);
            table4.addCell(cell44);
            table4.addCell(cell45);
            table4.addCell(cell46);
            table4.addCell(cell47);
            table4.addCell(cell48);
            table4.addCell(cell49);
            table4.addCell(cell50);
            table4.addCell(cell51);
            table4.addCell(cell52);
            table4.addCell(cell53);
            table4.addCell(cell54);
            table4.addCell(cell55);
            table4.addCell(cell56);
            table4.addCell(cell57);
            table4.addCell(cell58);
            table4.addCell(cell59);
            table4.addCell(cell60);
            table4.addCell(cell61);
            table4.addCell(cell62);
            table4.addCell(cell63);
            doc.add(table4);
            
            String mainPara14 = "*Figures have been rounded to nearest Rupees";
	   		Paragraph para16 = new Paragraph(mainPara14,font);
	   		para16.setSpacingAfter(10);
	   		doc.add(para16);
            
		   	image3 = Image.getInstance(imageName3);
	        image3.scaleToFit(100f, 400f);
	        image3.setAbsolutePosition(30, 10);
	        image3.setSpacingBefore(1000);
	        image3.setAlignment(Element.ALIGN_LEFT);
	        
	        doc.add(image3);
            }
            
          
    		doc.close();
        }
                catch (DocumentException exc){
                throw new IOException(exc.getMessage());
                }
        finally {            
            out.close();
        }
		}catch(Exception ex)
		{
			System.out.println("doGet EXCEEEEEEE------->"+ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
