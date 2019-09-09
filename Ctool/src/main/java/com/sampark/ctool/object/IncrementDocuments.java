package com.sampark.ctool.object;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Date;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.sampark.ctool.util.CommonUtils;

public class IncrementDocuments {

	public static void main(String args[]) throws Exception {
//	public static String generatePDf() throws FileNotFoundException, MalformedURLException {
		Date date = new Date();
		String dateName = CommonUtils.formatDate(date,"dd-MM-yyyy");
//		String timeName = CommonUtils.formatTime(date,"hh:mm:ss");
		String fileName = dateName+".pdf";
		String dest = "D:\\CtoolPDF\\"+fileName;
		System.out.println("FileName--->"+ dest);
		PdfWriter writer = new PdfWriter(dest);
		PdfDocument pdf = new PdfDocument(writer);
		Document doc = new Document(pdf);
		ImageData imageData = ImageDataFactory.create("D:\\CtoolPDF\\logo.jpg");
		ImageData imageData1 = ImageDataFactory.create("D:\\CtoolPDF\\H1.PNG");
		ImageData imageData2 = ImageDataFactory.create("D:\\CtoolPDF\\H2.PNG");

		Image image = new Image(imageData);
		image.setWidth(100);
		image.setHeight(100);
		image.setRelativePosition(420, 0, 0, 0);
		doc.add(image);

		Table table1 = new Table(1);
		table1.addCell(new Cell().add("Date: ").setBorder(Border.NO_BORDER));
		table1.addCell(new Cell().add("Document No.: ").setBorder(Border.NO_BORDER));
		table1.setRelativePosition(0, 20, 9, 10);
		table1.setFontSize(10);
		doc.add(table1);

		Table table2 = new Table(1);
		table2.addCell(new Cell().add("Mr.").setBorder(Border.NO_BORDER));
		table2.addCell(new Cell().add("Emp Code: ").setBorder(Border.NO_BORDER));
		table2.setRelativePosition(0, 30, 9, 0);
		table2.setFontSize(10);
		doc.add(table2);

		String para = "INCREMENT LETTER";
		Paragraph paragraph = new Paragraph(para);
		paragraph.setFontSize(10);
		paragraph.setUnderline();
		paragraph.setRelativePosition(0, 25, 0, 0);
		paragraph.setTextAlignment(TextAlignment.CENTER);
		doc.add(paragraph);

		Table table3 = new Table(1);
		table3.addCell(new Cell().add("Dear").setBorder(Border.NO_BORDER));
		table3.setRelativePosition(0, 35, 9, 0);
		table3.setFontSize(10);
		doc.add(table3);

		Table table4 = new Table(1);
		table4.addCell(new Cell().add("As a Company, we accomplished our target for the year 2017-2018"
				+ " leaving a small percentage to be commissioned. Together we can"
				+ " achieve better overcoming the odds that we face in business."
				+ " We need to continuously synergise and collaborate to achieve Organisational goals.").setBorder(Border.NO_BORDER));
		table4.setRelativePosition(0, 50, 9, 0);
		table4.setFontSize(10);
		doc.add(table4);
		
		
		Table table6 = new Table(1);
		table6.addCell(new Cell().add("Based on your Self assessment and your Superior’s"
				+ " assessment of your performance for the year 2017-2018, we revise your"
				+ " CTC as per the following:").setBorder(Border.NO_BORDER));
		table6.setRelativePosition(0, 50, 9, 0);
		table6.setFontSize(10);
		doc.add(table6);
		
		Table table7 = new Table(1);
		table7.addCell(new Cell().add("1.  Your new Fixed Annual CTC for the year 2018-2019 has "
				+ "been revised to Rs. ………/-. Detailed CTC break up will be as per the enclosed "
				+ "Annexure-A. This revised CTC will be effective from April 01, 2018.").setBorder(Border.NO_BORDER));
		table7.addCell(new Cell().add("2.  Your Incentive for the year 2017-2018based on Solar "
				+ "Rooftop performance and your performance is Rs………/-which will be disbursed "
				+ "to you in this month itself.  Same will be subject to taxation as per Government rules. ").setBorder(Border.NO_BORDER));
		table7.addCell(new Cell().add("3.	Information in Clause 1 & 2 are highly confidential "
				+ "and therefore not to be disclosed to anyone in and/or outside the Company. "
				+ "In case, it is discovered that someone has breached this Clause then the Company "
				+ "reserves the right to take action against that individual.").setBorder(Border.NO_BORDER));
		table7.addCell(new Cell().add("4.	In case you resign within a period of two months from the date "
				+ "of disbursement of Variable Pay for 2017-2018, the Company will recover the Variable pay "
				+ "disbursed to you as part of the full and final settlement.").setBorder(Border.NO_BORDER));
		table7.addCell(new Cell().add("5.	Please continue to align with Organizational culture and "
				+ "Organizational Policies and Procedures.").setBorder(Border.NO_BORDER));
		table7.setRelativePosition(0, 60, 9, 0);
		table7.setFontSize(10);
		doc.add(table7);
		
		Table table8 = new Table(1);
		table8.addCell(new Cell().add("Kindly acknowledge receipt of this letter"
				+ " by returning signed duplicate copy to HR.").setBorder(Border.NO_BORDER));
		table8.setRelativePosition(0, 70, 9, 0);
		table8.setFontSize(10);
		doc.add(table8);

		Table table9 = new Table(1);
		table9.addCell(new Cell().add("With best regards,").setBorder(Border.NO_BORDER).setBold());
		table9.addCell(new Cell().add("For and on behalf of Hero Solar Energy Pvt. Ltd.").setBorder(Border.NO_BORDER).setBold());
		table9.setRelativePosition(0, 80, 9, 0);
		table9.setFontSize(10);
		doc.add(table9);
		
		Table table10 = new Table(1);
		table10.addCell(new Cell().add("Sunil Jain").setBorder(Border.NO_BORDER).setBold());
		table10.addCell(new Cell().add("Director").setBorder(Border.NO_BORDER).setBold());
		table10.setRelativePosition(0, 90, 9, 0);
		table10.setFontSize(10);
		doc.add(table10);
		
		Image image1 = new Image(imageData1);
		image1.setWidth(400);
		image1.setHeight(400);
		image1.setRelativePosition(-10, 100, 0, 0);
		doc.add(image1);
		
//		Table table11 = new Table(1);
//
//		// Adding cells to the table
//		table11.addCell(new Cell().add("planet positive power").setBorder(Border.NO_BORDER));
//		table11.addCell(new Cell().add("HERO SOLAR ENERGY PVT. LTD").setBorder(Border.NO_BORDER).setBold().setFontColor(Color.BLACK));
//		table11.addCell(new Cell().add("CIN: U40106DL2013PTC250501").setBorder(Border.NO_BORDER));
//		table11.addCell(new Cell().add("Registered office: 210, GROUND FLOOR, OKHLA INDUSTRIAL ESTATE PH-III, NEW DELHI 110020, INDIA").setBorder(Border.NO_BORDER));
//		table11.addCell(new Cell().add("Corporate office: 202, THIRD FLOOR, OKHLA INDUSTRIAL ESTATE PH-III, NEW DELHI 110020, INDIA").setBorder(Border.NO_BORDER));
//		table11.addCell(new Cell().add("Landline No.:+91 11 49598000, Fax No. +91 11 49598022").setBorder(Border.NO_BORDER));
//		table11.addCell(new Cell().add("Email: info@herofutureenergies.com; Website: www.herofutureenergies.com").setBorder(Border.NO_BORDER));
//		table11.setRelativePosition(0, 100, 9, 0);
//		table11.setFontSize(7);
//		doc.add(table11);
		
		doc.add(new AreaBreak());

		Image image2 = new Image(imageData);
		image2.setWidth(100);
		image2.setHeight(100);
		image2.setRelativePosition(420, 0, 0, 0);
		doc.add(image2);
		
		Table table12 = new Table(1);
		table12.addCell(new Cell().add("Annexure – A").setBorder(Border.NO_BORDER).setBold());
		table12.setRelativePosition(0, 0, 10, 0);
		table12.setFontSize(10);
		doc.add(table12);

		float[] pointColumnWidths = { 100F,200F };
		Table table13 = new Table(pointColumnWidths);
		table13.addCell(new Cell().add("Name:"));
		table13.addCell(new Cell().add("Annexure – A"));
		table13.addCell(new Cell().add("Employee Code:"));
		table13.addCell(new Cell().add("Annexure – A"));
		table13.addCell(new Cell().add("Designation:"));
		table13.addCell(new Cell().add("Annexure – A"));
		table13.setRelativePosition(100, 5, 9, 100);
		table13.setFontSize(10);
		doc.add(table13);
		
		Table table14 = new Table(1);
		table14.addCell(new Cell().add("CTC BREAK-UP").setBorder(Border.NO_BORDER).setBold().setUnderline().setTextAlignment(TextAlignment.CENTER));
		table14.setRelativePosition(0, 40, 10, 0);
		table14.setFontSize(10);
		doc.add(table14);
		
		Table table16 = new Table(1);
		Table table17 = new Table(1);
		Table table15 = new Table(3);
		
		table15.addCell(new Cell().add("SALARY COMPONENTS").setBold().setTextAlignment(TextAlignment.CENTER));
		table15.addCell(
		table16.addCell(new Cell().add("MONTHLY").setBorderBottom(new SolidBorder(Color.BLACK, 1)).setBorderTop(new SolidBorder(Color.WHITE, 1))
				.setBorderLeft(new SolidBorder(Color.WHITE, 1)).setBorderRight(new SolidBorder(Color.WHITE, 1)).setBold().setTextAlignment(TextAlignment.CENTER)));
		table16.addCell(new Cell().add("INR").setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.CENTER));
		table16.setFontSize(10);
		table15.addCell(new Cell().add(
		table17.addCell(new Cell().add("ANNUAL").setBorderBottom(new SolidBorder(Color.BLACK, 1)).setBorderTop(new SolidBorder(Color.WHITE, 1))
				.setBorderLeft(new SolidBorder(Color.WHITE, 1)).setBorderRight(new SolidBorder(Color.WHITE, 1)).setBold().setTextAlignment(TextAlignment.CENTER))));
		table17.addCell(new Cell().add("INR").setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.CENTER));
		table17.setFontSize(10);
		table15.setRelativePosition(0, 50, 0, 0);
		table15.setFontSize(10);
		table15.addCell(new Cell(1,3).add("A.                         BASE SALARY").setBold());
		table15.addCell(new Cell().add("Basic"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("HR"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("Transport Allowance"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
//		table15.addCell(new Cell().add("").setBold().setHeight(20f));
//		table15.addCell(new Cell().add("").setBold());
//		table15.addCell(new Cell().add("").setBold());
		table15.addCell(new Cell().add("Special Allowance"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("Supplementary Allowance"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("Children Education Allowance"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("PF (Company's share)"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("TOTAL "));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,3).add("B.                         REIMBURSABLE (bills to be submitted as instructed)").setBold());
		table15.addCell(new Cell().add("Medical"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("Residential Telephone"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("Attire"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("News paper, Books and periodicals"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,3).add("C.                         TAXABLE COMPONENT (reimbursable as per law))").setBold());
		table15.addCell(new Cell().add("LTA (1 basic)"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,3).add("D.                         ELIGIBILITY AS PER COMPANY POLICY))").setBold());
		table15.addCell(new Cell().add("Gratuity"));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell().add("FIXED CTC (A+B+C+D)").setBold());
		table15.addCell(new Cell().add("").setBold());
		table15.addCell(new Cell().add("").setBold());
		table15.addCell(new Cell(1,2).add("Incentive \n \n \n (One time payment to be disbursed as per Company Policy)").setBold());
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,2).add("TOTAL CTC in INR (FIXED CTC + VARIABLE PAY)").setBold());
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,3).add("* Figures have been rounded to nearest Rupees").setBorder(Border.NO_BORDER));
		doc.add(table15);
		
		Image image3 = new Image(imageData2);
		image3.setWidth(100);
		image3.setHeight(100);
		image3.setRelativePosition(0, 80, 0, 0);
		doc.add(image3);

		doc.close();
		System.out.println("File created successfully..");
//		return fileName;
	}

}
