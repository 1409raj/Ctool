package com.sampark.ctool.object;

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

public class IncrementPromotionDocuments {

	public static void main(String args[]) throws Exception {
		String dest = "D:\\CtoolPDF\\IncrementPromotionDocuments.pdf";
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

		String para = "INCREMENT & PROMOTION LETTER";
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
		
		Table table5 = new Table(1);
		table5.addCell(new Cell().add("We recognise your “Commitment, passion and"
				+ " discipline towards your responsibilities which you demonstrated"
				+ " in your work and ability to accept challenges. In recognition of"
				+ " the same, we are pleased to promote you to “……………………” with immediate effect").setBorder(Border.NO_BORDER));
		table5.setRelativePosition(0, 50, 9, 0);
		table5.setFontSize(10);
		doc.add(table5);
		
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
		table7.addCell(new Cell().add("2.	Your Variable Pay for the year 2017-2018 based on "
				+ "Company’s performance and your performance is Rs………/-which will be disbursed "
				+ "to you in this month itself.  Same will be subject to taxation as per Government rules.").setBorder(Border.NO_BORDER));
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
//		table15.addCell(new Cell().add("").setBold().setHeight(20f));
//		table15.addCell(new Cell().add("").setBold());
//		table15.addCell(new Cell().add("").setBold());
		table15.addCell(new Cell().add("Special Allowance"));
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
		table15.addCell(new Cell(1,2).add("Variable Pay \n \n \n (One time payment to be disbursed as per Company Policy)").setBold());
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,2).add("TOTAL CTC in INR (FIXED CTC + VARIABLE PAY)").setBold());
		table15.addCell(new Cell().add(""));
		table15.addCell(new Cell(1,3).add("* Figures have been rounded to nearest Rupees").setBorder(Border.NO_BORDER));
		doc.add(table15);
		
		Image image3 = new Image(imageData2);
		image3.setWidth(100);
		image3.setHeight(100);
		image3.setRelativePosition(0, 140, 0, 0);
		doc.add(image3);
		
		// Creating a table
		// float[] pointColumnWidths = { 540F };
		// Table table = new Table(pointColumnWidths);
		//
		// // Adding cells to the table
		// table.addCell(new Cell().add(
		// "This Document is an official copy of the latest version of the
		// Purchase Order specified above. Please note that historical versions
		// are not official copies."));
		//
		// table.setRelativePosition(0, 0, 10, 10);
		// // table.setWidthPercent(310);
		// table.setFontSize(10);
		//
		// // Adding Table to document
		// doc.add(table);

		// float[] secondTablecolumnwidth = { 200f, 200f, 140f };
		// Table secondTable = new Table(secondTablecolumnwidth);
		//
		// // Adding cells to the table
		// secondTable
		// .addCell(new Cell().add("Requisitioner\r\n" + "Supratim Das\r\n" +
		// "supratim.a.das@ericsson.com Das"));
		// secondTable.addCell(new Cell()
		// .add("Supplier contact\r\n" + "SAMPARK SOFTWARES PVT LTD\r\n" +
		// "siddharth.agarwal@sspvl.com"));
		// secondTable.addCell(new Cell().add("Date\r\n" + "20-November-2018"));
		//
		// secondTable.setRelativePosition(0, 0, 10, 0);
		// secondTable.setFontSize(8);
		// doc.add(secondTable);
		//
		// float[] thirdTablecolumnwidth = { 135f, 135f, 135f, 135f };
		// Table thirdTable = new Table(thirdTablecolumnwidth);
		//
		// // Adding cells to the table
		// thirdTable.addCell(new Cell().add("Requisitioner Telephone No\r\n" +
		// "Extn"));
		// thirdTable.addCell(new Cell().add("Requisitioner Telefax No\r\n" +
		// "Extn"));
		// thirdTable.addCell(new Cell().add("Supplier Telephone No\r\n" +
		// "9873415969 Extn"));
		// thirdTable.addCell(new Cell().add("Supplier Telefax No\r\n" +
		// "Extn\r\n"));
		//
		// thirdTable.setRelativePosition(0, 0, 10, 0);
		// thirdTable.setFontSize(8);
		// doc.add(thirdTable);

		// String supplier = "SAMPARK SOFTWARES PVT LTD C-35, \nTRANS YAMUNA
		// COLONY,RAMBAGH, \nAGRA 282006 AGRA,\n INDIA";
		//
		// Paragraph supplierp = new Paragraph(TextBold.textBold("Supplier",8));
		// supplierp.setFontSize(10);
		// supplierp.setRelativePosition(0, 0, 0, 0);
		// doc.add(supplierp);
		//// paragraph.setFixedLeading(20);
		//
		// Paragraph supplierparagraph = new Paragraph(supplier);
		// supplierparagraph.setFontSize(8);
		// supplierparagraph.setRelativePosition(0, 0, 0, 5);
		// doc.add(supplierparagraph);
		//// paragraph.setFixedLeading(20);
		//
		// String order = "SAMPARK SOFTWARES PVT LTD C-35, \nTRANS YAMUNA
		// COLONY,RAMBAGH, \nAGRA 282006 AGRA,\n INDIA";
		//
		// Paragraph orderp = new Paragraph(TextBold.textBold("Order
		// Acknowledgement", 8));
		// orderp.setFontSize(10);
		// orderp.setRelativePosition(300, 0, 0, 75);
		// doc.add(orderp);
		//// paragraph.setFixedLeading(20);
		//
		// Paragraph orderparagraph = new Paragraph(order);
		// orderparagraph.setFontSize(8);
		// orderparagraph.setRelativePosition(300, 0, 0, 80);
		// doc.add(orderparagraph);
		//
		// String invoice = "Ericsson India Global Serv Pvt Ltd, \n Block A,
		// King CanyonASF Insignia, \nGurgaon Faridabad Road,\n Gwal
		// Pahari,\nGurgaon";
		//
		// Paragraph invoicep = new Paragraph(TextBold.textBold("Invoice
		// Address", 8));
		// invoicep.setFontSize(10);
		// invoicep.setRelativePosition(0, 0, 0, 85);
		// doc.add(invoicep);
		//
		// Paragraph invoiceparagraph = new Paragraph(invoice);
		// invoiceparagraph.setFontSize(8);
		// invoiceparagraph.setRelativePosition(0, 0, 0, 90);
		// doc.add(invoiceparagraph);
		//
		// String delivery = "Ericsson India Global Serv Pvt Ltd, \n Block A,
		// King CanyonASF Insignia, \nGurgaon Faridabad Road,\n Gwal
		// Pahari,\nGurgaon";
		//
		// Paragraph deliveryp = new Paragraph(TextBold.textBold("Delivery
		// Address", 8));
		// deliveryp.setFontSize(10);
		// deliveryp.setRelativePosition(300, 0, 0, 175);
		// doc.add(deliveryp);
		//
		// Paragraph deliveryparagraph = new Paragraph(delivery);
		// deliveryparagraph.setFontSize(8);
		// deliveryparagraph.setRelativePosition(300, 0, 0, 178);
		// doc.add(deliveryparagraph);
		//
		// // Fourth table
		//
		// float[] fourthTablecolumnwidth = { 30f, 50f, 50f, 70f, 100f, 50f,
		// 50f, 50f, 70f };
		// Table fourTable = new Table(fourthTablecolumnwidth);
		//
		// // Adding cells to the table
		// fourTable.addCell(new Cell().add("S.No"));
		// fourTable.addCell(new Cell().add("Quantity"));
		// fourTable.addCell(new Cell().add("UoM"));
		// fourTable.addCell(new Cell().add("Product Number"));
		// fourTable.addCell(new Cell().add("Product"));
		// fourTable.addCell(new Cell().add("Delivery"));
		// fourTable.addCell(new Cell().add("Unit Price"));
		// fourTable.addCell(new Cell().add("Currency"));
		// fourTable.addCell(new Cell().add("Total Amount"));
		//
		// for (int i = 1; i <= 5; i++) {
		//
		// fourTable.addCell(new Cell().add(i + ""));
		// fourTable.addCell(new Cell().add("Quantity"));
		// fourTable.addCell(new Cell().add("UoM"));
		// fourTable.addCell(new Cell().add("Product Number"));
		// fourTable.addCell(new Cell().add("Product"));
		// fourTable.addCell(new Cell().add("Delivery"));
		// fourTable.addCell(new Cell().add("Unit Price"));
		// fourTable.addCell(new Cell().add("Currency"));
		// fourTable.addCell(new Cell().add("Total Amount"));
		//
		// }
		//
		// fourTable.setRelativePosition(0, 0, 10, 175);
		// fourTable.setFontSize(8);
		// doc.add(fourTable);
		//
		// float[] fifthTablecolumnwidth = { 540f };
		// Table fifthTable = new Table(fifthTablecolumnwidth);
		// fifthTable.addCell(new Cell().add(
		// "Additional comments on the line item\nASP - EMC Backup @ 6 months -
		// Blr #Hiring Type (New/Extesnion) : New#Unit Name : ITIS#Duration of
		// Assignment : 6\nmonths#Assignment s\nstart date : 1-Jan-17, End Date
		// : 30-Jun-17#Skill Set Description : EMC Backup#Project : EGI IT (RAJ
		// RAN)#"));
		// fifthTable.addCell(new Cell().add("Agreement Number: GPC"));
		// fifthTable.addCell(new Cell().add("Total Amount: 462.000,00
		// INR").setMarginLeft(350));
		// fifthTable.setRelativePosition(0, 0, 10, 175);
		// fifthTable.setFontSize(8);
		// doc.add(fifthTable);
		//
		// float[] sixTablecolumnwidth = { 540f };
		// Table sixTable = new Table(sixTablecolumnwidth);
		// sixTable.addCell(new Cell().add("General terms and conditions\r\n"
		// + "Unless otherwise agreed by the parties in a separate written
		// agreement, the relevant purchase shall in case of products\r\n"
		// + "be subject to Ericsson's General Purchasing Conditions (04:0194,
		// which can be found at\r\n"
		// + "http://www.ericsson.com/sustainability/supplier_guides.shtml
		// )\r\n"
		// + "or in case of services be subject to Ericsson's General Conditions
		// for Services (05:0040, which can be found at\r\n"
		// + "http://www.ericsson.com/sustainability/supplier_guides.shtml
		// ).\r\n"
		// + "The content of this purchase order is not subject to any changes
		// without Ericsson's written acceptance. If the content of\r\n"
		// + "this purchase order is not in accordance with what has been
		// offered by seller, discussed or otherwise agreed upon by\r\n"
		// + "the parties, Seller shall reject the purchase order by sending a
		// written rejection to Ericsson.\r\n"
		// + "Order created by the web-based electronic purchasing system SAP
		// EBP.\r\n"
		// + "Please note all decimalisation uses the point symbol (.) rather
		// than comma symbol (,). For example, 1.000 in the\r\n"
		// + "quantity field means a quantity of one."));
		// sixTable.setRelativePosition(0, 0, 10, 170);
		// sixTable.setFontSize(8);
		// doc.add(sixTable);

		// Closing the document
		doc.close();
		System.out.println("Table created successfully..");
	}

}
