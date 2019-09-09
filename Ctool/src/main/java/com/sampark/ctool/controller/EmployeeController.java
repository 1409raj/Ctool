package com.sampark.ctool.controller;

import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.AttributedString;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.metadata.ValidateUnwrappedValue;

import org.apache.commons.io.output.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.apache.mina.filter.firewall.BlacklistFilter;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.converter.core.styles.paragraph.ParagraphAlignmentValueProvider;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.docx4j.Docx4J;
import org.docx4j.org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xlsx4j.sml.Cols;

import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.qoppa.ooxml.jaxb_schemas.spreadsheetml2006.main.CTIconSet;
import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.entity.FinalCalculations;
import com.sampark.ctool.entity.IncrementLetterDetails;
import com.sampark.ctool.entity.PDFDocuments;
import com.sampark.ctool.entity.SpvsDetailsEntity;
import com.sampark.ctool.entity.WordDocument;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.Incrementvariablerepositiory;
import com.sampark.ctool.repository.SpvsRepository;
import com.sampark.ctool.service.EmployeeService;
import com.sampark.ctool.service.PDFDocumentsService;
import com.sampark.ctool.service.WordDocumentService;
import com.sampark.ctool.util.CommonUtils;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	final static Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@Autowired
	PDFDocumentsService pfdDocumentsService;

	@Autowired
	WordDocumentService wordDocumentService;

	@Autowired
	SpvsRepository SpvsRepository;

	@Autowired
	Incrementvariablerepositiory incrementvariablerepositiory;

	@RequestMapping(value = "/bulk", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveDocument(@RequestParam("file1") MultipartFile file, HttpSession session)
			throws ParseException {
		ResponseObject rsobj = new ResponseObject();
		BufferedReader br;
		List<EmployeeBasicDetails> employeelist = new ArrayList<EmployeeBasicDetails>();
		try {
			String line;
			boolean check = true;
			InputStream is = file.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				String[] parst = null;
				if (check == true) {
					parst = line.split(",");
					check = false;
				} else {
					parst = line.split(",");
					EmployeeBasicDetails employee = new EmployeeBasicDetails();
					employee.setEmpCode(parst[1]);
					employee.setEmpName(parst[2]);
					employee.setLocation(parst[6]);
					employee.setMobile(parst[7]);
					employee.setEmail(parst[8]);
					employee.setDesignation(parst[9]);
					employee.setDepartment(parst[10]);
					System.out.println(parst[11].substring(0, 10));
					Date doj = new SimpleDateFormat("dd.MM.yyyy").parse(parst[11].substring(1, 10));
					employee.setDateOfJoining(doj);
					employee.setKra(parst[12]);
					employee.setKraRating(parst[13]);
					employee.setBehaviouralCompetence(parst[14]);
					employee.setBehaviouralCompetenceRating(parst[15]);
					employee.setExtraOrdinaryInitiative(parst[16]);
					employee.setExtraOrdinaryInitiativeRating(parst[17]);
					employee.setFinalYearRating(parst[18]);
					employee.setAssessmentYear(parst[21]);
					employee.setCreatedOn(new Date());
					employee.setCreatedBy(CommonUtils.getCurrentUserName());
//		    		  employee.setStatus(CtoolConstanats.STATUS_ACTIVE);

					employeelist.add(employee);
				}
			}
			try {
				rsobj = employeeService.saveEmployee(employeelist);
			} catch (Exception e) {

				e.printStackTrace();
				logger.info("Client bulk exception" + e);

			}
		} catch (IOException e) {

			e.printStackTrace();
			logger.error("Client bulk exception" + e);
		}
		return rsobj;
	}

	@RequestMapping(value = "/finalCalculation", method = RequestMethod.POST)
	public @ResponseBody ResponseObject finalCalculation(@RequestParam("file1") MultipartFile file, HttpSession session)
			throws ParseException {
		ResponseObject rsobj = new ResponseObject();
		BufferedReader br;
		List<FinalCalculations> finalCalculationslist = new ArrayList<FinalCalculations>();
		try {
			String line;
			boolean check = true;
			InputStream is = file.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				String[] parst = null;
				if (check == true) {
					parst = line.split(",");
					check = false;
				} else {
					parst = line.split(",");
					FinalCalculations finalCalculations = new FinalCalculations();
					finalCalculations.setEmpCode(parst[0]);
					finalCalculations.setEmpName(parst[1]);
					finalCalculations.setDepartment(parst[2]);
					finalCalculations.setDesignation(parst[3]);
					Date doj = new SimpleDateFormat("dd.MM.yyyy").parse(parst[4]);
					finalCalculations.setDateOfJoining(doj);
					finalCalculations.setAssessmentYear(parst[5]);
					finalCalculations.setKraRating(parst[6]);
					finalCalculations.setPromotionIndicator(Integer.valueOf(parst[7]));
					finalCalculations.setTenureMonth(parst[8]);
					finalCalculations.setExtraOrdinaryInitiative(parst[9]);
					finalCalculations.setBehaviouralCompetenceRating(parst[10]);
					finalCalculations.setNewDesignation(parst[11]);
					finalCalculations.setFinalYearRating(parst[12]);
					finalCalculations.setCurrentFixedSalaryPerYear(parst[13]);
					finalCalculations.setFixedSalaryPerYear(parst[14]);
					finalCalculations.setFixedSalaryPerMonth(parst[15]);
					finalCalculations.setCurrentVariable(Integer.valueOf(parst[16]));
					finalCalculations.setCurrentVariableAmountCurrentYear(Integer.valueOf(parst[17]));
					finalCalculations.setCurrentCTCPerYear(parst[18]);
					finalCalculations.setCurrentCTCPerMonth(parst[19]);
					finalCalculations.setDisbursedVariable(Integer.valueOf(parst[20]));
					finalCalculations.setVariableX(Integer.valueOf(parst[21]));
					finalCalculations.setVariableY(Integer.valueOf(parst[22]));
					finalCalculations.setIncrementWRTRating(parst[23]);
					finalCalculations.setRationalizationHRFactor(Integer.valueOf(parst[24]));
					finalCalculations.setPromotion(parst[25]);
					finalCalculations.setRetention(parst[26]);
					finalCalculations.setVariableX33Per(Integer.valueOf(parst[27]));
					finalCalculations.setVariableX67Per(Integer.valueOf(parst[28]));
					finalCalculations.setDisbursedVariableD(parst[29]);
					finalCalculations.setIncrementWEFApril(parst[30]);
					finalCalculations.setIncrementAmount(parst[31]);
					finalCalculations.setNewFixSalaryPerYear(parst[32]);
					finalCalculations.setNewFixSalaryPerMonth(parst[33]);
					finalCalculations.setNewVariable(Integer.valueOf(parst[34]));
					finalCalculations.setNewCTC(parst[35]);
					finalCalculations.setNetIncreaseYearly(parst[36]);
					finalCalculations.setSpecialBonus(parst[37]);
					finalCalculations.setCreatedOn(new Date());
					finalCalculations.setModifiedOn(new Date());
					finalCalculations.setModifiedBy("HR");
					finalCalculations.setCreatedBy("HR");
					finalCalculations.setStatus(CtoolConstanats.STATUS_ACTIVE);
					finalCalculationslist.add(finalCalculations);
				}
			}
			try {
				rsobj = employeeService.saveFinalCalculation(finalCalculationslist);
			} catch (Exception e) {
				System.out.println("Error ---->" + e);
				e.printStackTrace();
				logger.info("Final Calculation bulk exception" + e);

			}
		} catch (Exception e) {
			System.out.println("Error ---->" + e);
			e.printStackTrace();
			logger.error("Final Calculation bulk exception" + e);
		}
		return rsobj;
	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.POST)
	public @ResponseBody ResponseObject employeeList() throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = employeeService.employeeList();
		return rsobj;
	}

	@RequestMapping(value = "/employeePromtionListgenerated", method = RequestMethod.POST)
	public @ResponseBody List<EmployeeBasicDetails> employeePromtionListGenerated() throws Exception {
		return employeeService.employeePromtionListGenerated();
	}

	@RequestMapping(value = "/employeePromtionListnotgenerated", method = RequestMethod.POST)
	public @ResponseBody List<EmployeeBasicDetails> employeePromtionListNotGenerated() throws Exception {
		return employeeService.employeePromtionListNotGenerated();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ResponseObject updateEmployee(@RequestBody EmployeeBasicDetails employee) {
		ResponseObject rsobj = new ResponseObject();
		employee.setStatus(CtoolConstanats.STATUS_ACTIVE);
		employee.setDocStatus(CtoolConstanats.docNotGenerated);
		rsobj = employeeService.updateEmployee(employee);
		return rsobj;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseObject delete(@RequestBody EmployeeBasicDetails employeeBasicDetails) {
		return employeeService.deleteEmployee(employeeBasicDetails);
	}

	@RequestMapping(value = "/employeeGeneratePDF", method = RequestMethod.POST)
	public @ResponseBody ResponseObject employeeGeneratePDF() {
		ResponseObject rsobj = new ResponseObject();
//		try {
//			IncrementDocuments.generatePDf();
		String fileName = "random.pdf";
		PDFDocuments pdfDocuments = new PDFDocuments();
		pdfDocuments.setName(fileName);
		pdfDocuments.setCreatedOn(new Date());
		pdfDocuments.setStatus(CtoolConstanats.STATUS_ACTIVE);
		rsobj = pfdDocumentsService.savePDFDocuments(pdfDocuments);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		return rsobj;
	}

	@RequestMapping(value = "/convertpdftoword", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> pdfDocumentsList(@RequestParam("filename") String filename)
			throws Exception {

		return new ResponseEntity<String>("Generated", HttpStatus.OK);
	}

	@RequestMapping(value = "/pdfDocumentsList", method = RequestMethod.POST)
	public @ResponseBody List<PDFDocuments> convertpdftoword() throws Exception {
		List<PDFDocuments> list = pfdDocumentsService.pdfDocumentsList();

		return list;
	}

	@RequestMapping(value = "/getEmployeePDF", method = RequestMethod.GET)
	public @ResponseBody void getEmployeePDF(HttpServletRequest request, HttpServletResponse response) {
		String fileName = UUID.randomUUID().toString();

		Integer spacingbefore = 5;
		Integer spacingAfter = 5;

		List<PDFDocuments> pfDocuments = new ArrayList<PDFDocuments>();

		try {
			// Getting list of employee to generate pdf documents.
			List<EmployeeBasicDetails> list = employeeService.employeePromtionListNotGenerated();

			// Set content type to application / pdf
			// browser will open the document only if this is set
			response.setContentType("application/pdf");
			// Get the output stream for writing PDF object
			OutputStream out = response.getOutputStream();
			try {
				String FILE = CtoolConstanats.folder_base + fileName + ".pdf";

				Document doc = new Document();
				BaseFont base = BaseFont.createFont(CtoolConstanats.folder_base + "trebuchet-ms/trebuc.ttf",
						BaseFont.WINANSI, true);
				Font font = new Font(base, 10f, Font.NORMAL);
				Font font9_5 = new Font(base, 9.5f, Font.NORMAL);
				Font fontUnderline = new Font(base, 11f, Font.UNDERLINE);
				Font tabletext = new Font(base, 10f, Font.NORMAL);

				Font fontBold = FontFactory.getFont("Times-Roman", 10, Font.BOLD);
				Font trebucfontBols = new Font(base, 10f, Font.BOLD);

				Date date = new Date();
				String dateName = CommonUtils.formatDate(date, "MMMM dd, yyyy");

				/* Basic PDF Creation inside servlet */

				PdfWriter.getInstance(doc, out);
				PdfWriter.getInstance(doc, new FileOutputStream(FILE));
				doc.open();

				for (int i = 0; i < list.size(); i++) {

					SpvsDetailsEntity spvsDetailsEntity = SpvsRepository.spvsDetails(list.get(i).getSpvsId());
					IncrementLetterDetails incrementLetterDetails = incrementvariablerepositiory
							.getIncrementLetterDetails(list.get(i).getIncrementLetterDetailsId());

					String imageName1 = CtoolConstanats.folder_base + "logo.jpg";
					Image image1 = Image.getInstance(imageName1);
					String imageName2 = CtoolConstanats.folder_base + spvsDetailsEntity.getHeaderImage();
					Image image2 = Image.getInstance(imageName2);
					String imageName3 = CtoolConstanats.folder_base + spvsDetailsEntity.getFooterImage();
					Image image3 = Image.getInstance(imageName3);
					PDFDocuments pdfDocuments = new PDFDocuments();
					pdfDocuments.setEmpName(list.get(i).getEmpName());
					pdfDocuments.setEmpCode(list.get(i).getEmpCode());
					pdfDocuments.setCreatedOn(new Date());
					pdfDocuments.setName(fileName + ".pdf");
					pdfDocuments.setStatus(CtoolConstanats.STATUS_ACTIVE);
					pfDocuments.add(pdfDocuments);

					// Creating image by file name
					image1 = Image.getInstance(imageName1);
					image1.scaleToFit(100f, 200f);
					image1.setAlignment(Element.ALIGN_RIGHT);
					doc.add(image1);

					PdfPTable table1 = new PdfPTable(1);
					table1.setHorizontalAlignment(Element.ALIGN_LEFT);
					for (int aw = 0; aw < 1; aw++) {

						PdfPCell cell1 = new PdfPCell(new Phrase("Date: " + dateName, font));
						PdfPCell cell2 = new PdfPCell(new Phrase("Document No: " + list.get(i).getDocumentNo(), font));
						PdfPCell cell3 = new PdfPCell(new Phrase(""));
						PdfPCell cell4 = new PdfPCell(new Phrase(""));
						PdfPCell cell5 = new PdfPCell(
								new Phrase("Mr./ Ms. " + list.get(i).getEmpName(), trebucfontBols));
						PdfPCell cell6 = new PdfPCell(
								new Phrase("Emp Code:" + list.get(i).getEmpCode(), trebucfontBols));
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
					String para = incrementLetterDetails.getTitle();

					Paragraph paragraph = new Paragraph(para, fontUnderline);
					paragraph.setAlignment(Element.ALIGN_CENTER);
					paragraph.setSpacingBefore(10);
					paragraph.setSpacingAfter(10);

					doc.add(paragraph);

					PdfPTable table2 = new PdfPTable(1);
					table2.setHorizontalAlignment(Element.ALIGN_LEFT);
					for (int aw = 0; aw < 1; aw++) {

						String[] splitStr = list.get(i).getEmpName().split("\\s+");

						PdfPCell cell1 = new PdfPCell(new Phrase("Dear " + splitStr[0], font));
						cell1.setBorder(PdfPCell.NO_BORDER);
						cell1.setPaddingLeft(0f);
						cell1.setNoWrap(false);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						table2.addCell(cell1);
					}
					doc.add(table2);
// 		    String mainPara1 = "As a Company, we accomplished our target for the year 2017-2018 leaving a small percentage to be commissioned." + 
// 		    		"Together we can achieve better overcoming the odds that we face in business. We need to continuously synergise " + 
// 		    		"and collaborate to achieve Organisational goals.";

					Paragraph para1 = new Paragraph(incrementLetterDetails.getParagraph6(), font);
					para1.setSpacingBefore(10);
					para1.setSpacingAfter(5);
					para1.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para1);
//	   		String mainPara2 = "Based on your Self assessment and your Superior’s assessment of your performance for the year 2017-2018, we " + 
//	   				"revise your CTC as per the following:";

					Paragraph para2 = null;
					String p2 = incrementLetterDetails.getParagraph7();
					if (list.get(i).getIncrementLetterDetailsId() == 2) {

						String designation = list.get(i).getNewDesignation();
						String p21 = p2.replace("~~designation~~", designation);
						para2 = new Paragraph(p21, font);
					} else {
						para2 = new Paragraph(p2, font);
					}
					para2.setSpacingBefore(5);
					para2.setSpacingAfter(5);
					para2.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para2);
//	   		String mainPara3 = "1. Your new Fixed Annual CTC for the year "+list.get(i).getAssessmentYear()+" has been revised to Rs."+list.get(i).getNewCTCYear()+"/-. Detailed CTC break up will " + 
//	   				"be as per the enclosed Annexure-A. This revised CTC will be effective from April 01, 2018.";

					String para3_1 = incrementLetterDetails.getParagraph1().replace("~~year~~",
							list.get(i).getAssessmentYear());
					String mainPara3 = para3_1.replace("~~revisedsalary~~", list.get(i).getNewCTCYear() + "/-");
					Paragraph para3 = new Paragraph("1. " + mainPara3, font);
					para3.setSpacingBefore(5);
					para3.setSpacingAfter(5);
					para3.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para3);
//	   		String mainPara4 = "2. Your Incentive for the year 2017-2018 based on Solar Rooftop performance and your performance is Rs………/- " + 
//	   				"which will be disbursed to you in this month itself. Same will be subject to taxation as per Government rules.";

					String mainPara4 = incrementLetterDetails.getParagraph2().replace("~~performancesalary~~",
							list.get(i).getVariablePay());
					Paragraph para4 = new Paragraph("2. " + mainPara4, font);
					para4.setSpacingBefore(5);
					para4.setSpacingAfter(5);
					para4.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para4);

					Paragraph para5 = new Paragraph("3. " + incrementLetterDetails.getParagraph3(), font);
					para5.setSpacingBefore(5);
					para5.setSpacingAfter(5);
					para5.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para5);

					Paragraph para6 = new Paragraph("4. " + incrementLetterDetails.getParagraph4(), font);
					para6.setSpacingBefore(5);
					para6.setSpacingAfter(5);
					para6.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para6);
					Paragraph para7 = new Paragraph("5. " + incrementLetterDetails.getParagraph5(), font);
					para7.setSpacingBefore(5);
					para7.setSpacingAfter(5);
					para7.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para7);
					String mainPara8 = "Kindly acknowledge receipt of this letter by returning signed duplicate copy to HR.";
					Paragraph para8 = new Paragraph(mainPara8, font);
					para8.setSpacingBefore(10);
					para8.setSpacingAfter(10);
					para8.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para8);
					String mainPara9 = "With best regards,";
					Paragraph para9 = new Paragraph(mainPara9, font);
					para9.setSpacingBefore(10);
					para9.setSpacingAfter(2);
					para9.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para9);
					String mainPara10 = "For and on behalf of " + spvsDetailsEntity.getSpvsEntitiy().getCompanyName();
					Paragraph para10 = new Paragraph(mainPara10, font);
					para10.setSpacingAfter(10);
					para10.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para10);
					String mainPara11 = spvsDetailsEntity.getSpvsEntitiy().getDirector();
					Paragraph para11 = new Paragraph(mainPara11, font);
					para11.setSpacingAfter(1);
					para11.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para11);
					String mainPara12 = "Director";
					Paragraph para12 = new Paragraph(mainPara12, font);
					para12.setSpacingAfter(15);
					para12.setAlignment(Element.ALIGN_JUSTIFIED);
					doc.add(para12);

					image2 = Image.getInstance(imageName2);
					image2.scaleToFit(350f, 350f);

					image2.setAlignment(Element.ALIGN_LEFT);
					image2.setAbsolutePosition(40, 10);
					image2.setSpacingBefore(1000);
					doc.add(image2);

					doc.newPage();
					image3 = Image.getInstance(imageName1);
					image3.scaleToFit(100f, 100f);
					image3.setAlignment(Element.ALIGN_RIGHT);
					doc.add(image3);

					String mainPara13 = "Annexure – A";
					Paragraph para13 = new Paragraph(mainPara13, font);
					para13.setSpacingAfter(10);
					doc.add(para13);

					PdfPTable table3 = new PdfPTable(2);

					PdfPCell cell1 = new PdfPCell(new Phrase("Name:", trebucfontBols));
					cell1.setPadding(2);

					PdfPCell cell2 = new PdfPCell(new Phrase(list.get(i).getEmpName(), font));
					cell2.setPadding(2);
					PdfPCell cell3 = new PdfPCell(new Phrase("Employee Code:", trebucfontBols));
					cell3.setPadding(2);
					PdfPCell cell4 = new PdfPCell(new Phrase(list.get(i).getEmpCode(), font));
					cell4.setPadding(2);
					PdfPCell cell5 = new PdfPCell(new Phrase("Designation: ", trebucfontBols));
					cell5.setPadding(2);
					PdfPCell cell6 = new PdfPCell(new Phrase(list.get(i).getDesignation(), font));

					cell1.setPaddingLeft(0f);
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
					table3.setHeaderRows(10);
					doc.add(table3);

					String para14 = "CTC BREAK-UP";
					Paragraph para15 = new Paragraph(para14, fontUnderline);
					para15.setAlignment(Element.ALIGN_CENTER);
					para15.setSpacingBefore(10);
					para15.setSpacingAfter(10);

					float table4Width[] = { 60, 20, 20 };
					PdfPTable table4 = new PdfPTable(table4Width);
					table4.setWidthPercentage(70);
					PdfPCell cell7 = new PdfPCell(new Phrase("SALARY COMPONENTS", tabletext));
					PdfPCell cell8 = new PdfPCell(new Phrase("MONTHLY", tabletext));
					PdfPCell cell9 = new PdfPCell(new Phrase("ANNUAL", tabletext));
					PdfPCell cell10 = new PdfPCell(new Phrase("INR", tabletext));
					PdfPCell cell11 = new PdfPCell(new Phrase("A.                         BASE SALARY", tabletext));
					PdfPCell cell12 = new PdfPCell(new Phrase("Basic", tabletext));
					PdfPCell cell13 = new PdfPCell(new Phrase(list.get(i).getBasicSalary(), font9_5));
					cell13.setPaddingRight(5f);
					PdfPCell cell14 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getBasicSalary()) * 12), font9_5));
					cell14.setPaddingRight(5f);
					PdfPCell cell15 = new PdfPCell(new Phrase("HR", tabletext));
					PdfPCell cell16 = new PdfPCell(new Phrase(list.get(i).getHr(), font9_5));
					cell16.setPaddingRight(5f);
					PdfPCell cell17 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getHr()) * 12), font9_5));
					cell17.setPaddingRight(5f);
//        	PdfPCell cell18 = new PdfPCell(new Phrase("Transport Allowance",fontnumber));
//        	PdfPCell cell19 = new PdfPCell(new Phrase(list.get(i).getTransportAllowance(),fontnumber));
//        	PdfPCell cell20 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.get(i).getTransportAllowance())*12),fontnumber));
//        	
					PdfPCell cell21 = new PdfPCell(new Phrase("Special Allowance", tabletext));
					PdfPCell cell22 = new PdfPCell(new Phrase(list.get(i).getSpecialAllowance(), font9_5));
					cell22.setPaddingRight(5f);
					PdfPCell cell23 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getSpecialAllowance()) * 12), font9_5));
					cell23.setPaddingRight(5f);
					PdfPCell cell24 = new PdfPCell(new Phrase("Supplementary Allowance", tabletext));
					PdfPCell cell25 = new PdfPCell(new Phrase(list.get(i).getSupplementaryAllowance(), font9_5));
					cell25.setPaddingRight(5f);
					PdfPCell cell26 = new PdfPCell(new Phrase(
							String.valueOf(Float.valueOf(list.get(i).getSupplementaryAllowance()) * 12), font9_5));
					cell26.setPaddingRight(5f);

					PdfPCell cell27 = new PdfPCell(new Phrase("Children Education Allowance", tabletext));
					PdfPCell cell28 = new PdfPCell(new Phrase(list.get(i).getChildrenEducationAllowance(), font9_5));
					cell28.setPaddingRight(5f);
					PdfPCell cell29 = new PdfPCell(new Phrase(
							String.valueOf(Float.valueOf(list.get(i).getChildrenEducationAllowance()) * 12), font9_5));
					cell29.setPaddingRight(5f);
					PdfPCell cell30 = null;

					if (list.get(i).getDepartment().equalsIgnoreCase("Solar Rooftop")) {
						cell30 = new PdfPCell(new Phrase("Sales incentive pay ", tabletext));

					} else {
						cell30 = new PdfPCell(new Phrase("PF (Company's share)", tabletext));
					}

					PdfPCell cell31 = new PdfPCell(new Phrase(list.get(i).getPf(), font9_5));
					cell31.setPaddingRight(5f);
					PdfPCell cell32 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getPf()) * 12), font9_5));
					cell32.setPaddingRight(5f);
					Float totalAmountMonth = Float.valueOf(list.get(i).getBasicSalary())
							+ Float.valueOf(list.get(i).getHr()) + +Float.valueOf(list.get(i).getSpecialAllowance())
							+ Float.valueOf(list.get(i).getSupplementaryAllowance())
							+ Float.valueOf(list.get(i).getChildrenEducationAllowance())
							+ Float.valueOf(list.get(i).getPf());

					Float totalAmountYear = (Float.valueOf(list.get(i).getBasicSalary()) * 12)
							+ (Float.valueOf(list.get(i).getHr()) * 12)
							+ +(Float.valueOf(list.get(i).getSpecialAllowance()) * 12)
							+ (Float.valueOf(list.get(i).getSupplementaryAllowance()) * 12)
							+ (Float.valueOf(list.get(i).getChildrenEducationAllowance()) * 12)
							+ (Float.valueOf(list.get(i).getPf()) * 12);

					PdfPCell cell33 = new PdfPCell(new Phrase("TOTAL", tabletext));
					PdfPCell cell34 = new PdfPCell(new Phrase(String.valueOf(totalAmountMonth), font9_5));
					cell34.setPaddingRight(5f);
					PdfPCell cell35 = new PdfPCell(new Phrase(String.valueOf(totalAmountYear), font9_5));
					cell35.setPaddingRight(5f);
					PdfPCell cell36 = new PdfPCell(
							new Phrase("B.                         REIMBURSABLE (bills to be submitted as instructed)",
									tabletext));

//        	PdfPCell cell37 = new PdfPCell(new Phrase("Medical",tabletext));
//        	PdfPCell cell38 = new PdfPCell(new Phrase(list.get(i).getMedical(),font9_5));
//        	cell38.setPaddingRight(5f);
//        	PdfPCell cell39 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.get(i).getMedical())*12),font9_5));
//        	cell39.setPaddingRight(5f);
					PdfPCell cell40 = new PdfPCell(new Phrase("Residential Telephone", tabletext));
					PdfPCell cell41 = new PdfPCell(new Phrase(list.get(i).getResidentTelephone(), font9_5));
					cell41.setPaddingRight(5f);
					PdfPCell cell42 = new PdfPCell(new Phrase(
							String.valueOf(Float.valueOf(list.get(i).getResidentTelephone()) * 12), font9_5));
					cell42.setPaddingRight(5f);

					PdfPCell cell43 = new PdfPCell(new Phrase("Attire", tabletext));
					PdfPCell cell44 = new PdfPCell(new Phrase(list.get(i).getAttire(), font9_5));
					cell44.setPaddingRight(5f);
					PdfPCell cell45 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getAttire()) * 12), font9_5));
					cell45.setPaddingRight(5f);

//        	Float sectionBExtraMonth = 
//        			Float.valueOf(list.get(i).getNewspaper()) + Float.valueOf(list.get(i).getCarLease())+ Float.valueOf(list.get(i).getDriver()) + Float.valueOf(list.get(i).getPetrol());
//        	
					Float sectionBExtraMonth = Float.valueOf(list.get(i).getNewspaper());

//        	Float sectionBExtraYear = 
//        			(Float.valueOf(list.get(i).getNewspaper())*12) + (Float.valueOf(list.get(i).getCarLease())*12) + (Float.valueOf(list.get(i).getDriver())*12) + (Float.valueOf(list.get(i).getPetrol())*12);
//        	

					Float sectionBExtraYear = (Float.valueOf(list.get(i).getNewspaper()) * 12);

					PdfPCell cell46 = new PdfPCell(new Phrase("Newspaper, Books and periodicals", tabletext));
					PdfPCell cell47 = new PdfPCell(new Phrase(String.valueOf(sectionBExtraMonth), font9_5));
					cell47.setPaddingRight(5f);
					PdfPCell cell48 = new PdfPCell(new Phrase(String.valueOf(sectionBExtraYear), font9_5));
					cell48.setPaddingRight(5f);

					PdfPCell cell49 = new PdfPCell(new Phrase(
							"C.                         TAXABLE COMPONENT (reimbursable as per law))", tabletext));

					PdfPCell cell50 = new PdfPCell(new Phrase("LTA (1 basic)", tabletext));
					PdfPCell cell51 = new PdfPCell(new Phrase(list.get(i).getLta(), font9_5));
					cell51.setPaddingRight(5f);

					PdfPCell cell52 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getLta()) * 12), font9_5));
					cell52.setPaddingRight(5f);
					PdfPCell cell53 = new PdfPCell(
							new Phrase("D.                         ELIGIBILITY AS PER COMPANY POLICY))", tabletext));
					PdfPCell cell54 = new PdfPCell(new Phrase("Gratuity", tabletext));
					PdfPCell cell55 = new PdfPCell(new Phrase(list.get(i).getGratuity(), font9_5));
					cell55.setPaddingRight(5f);
					PdfPCell cell56 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getGratuity()) * 12), font9_5));
					cell56.setPaddingRight(5f);

					PdfPCell carLeaseCell = new PdfPCell(new Phrase(
							"E.           Car Lease with the Third Party purely for official purposes", tabletext));

					carLeaseCell.setNoWrap(false);
					carLeaseCell.setHorizontalAlignment(Element.ALIGN_LEFT);
					carLeaseCell.setColspan(3);

					PdfPCell carLeaseCell1 = new PdfPCell(new Phrase("Payment towards Car Lease", tabletext));

					carLeaseCell1.setNoWrap(false);
					carLeaseCell1.setHorizontalAlignment(Element.ALIGN_LEFT);

					PdfPCell carLeaseCell2 = new PdfPCell(
							new Phrase(String.valueOf(list.get(i).getCarLeaseAmount()), font9_5));
					carLeaseCell2.setPaddingRight(5f);

					carLeaseCell2.setNoWrap(false);
					carLeaseCell2.setHorizontalAlignment(Element.ALIGN_RIGHT);

					PdfPCell carLeaseCell3 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getCarLeaseAmount()) * 12), font9_5));
					carLeaseCell3.setPaddingRight(5f);
					carLeaseCell3.setNoWrap(false);
					carLeaseCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);

					Float fixedCTCYear = totalAmountYear + (Float.valueOf(list.get(i).getResidentTelephone()) * 12)
							+ (Float.valueOf(list.get(i).getAttire()) * 12) + sectionBExtraYear
							+ (Float.valueOf(list.get(i).getLta()) * 12)
							+ (Float.valueOf(list.get(i).getGratuity()) * 12);

					// Float totalCTCYear = fixedCTCYear +
					// Float.valueOf(list.get(i).getVariablePay());

					Float totalCTCYear = Float.valueOf(list.get(i).getNewFixedSalaryPerYear())
							+ Float.valueOf(list.get(i).getNewVariablePerYear());
					Float ctcWitoutVariblePay = Float.valueOf(list.get(i).getNewFixedSalaryPerYear());
					Float fixedCTCMonth = null;
					String fixedCtc = null;
					if (list.get(i).getCarLease().equalsIgnoreCase("Yes")) {
						fixedCtc = "FIXED CTC (A+B+C+D+E)";
//        	 fixedCTCMonth =  totalAmountMonth + Float.valueOf(list.get(i).getResidentTelephone()) + Float.valueOf(list.get(i).getAttire()) +
//            			sectionBExtraMonth + Float.valueOf(list.get(i).getLta()) + Float.valueOf(list.get(i).getGratuity());
//        	 fixedCTCMonth=fixedCTCMonth + list.get(i).getCarLeaseAmount();
//        	 System.out.println("fixedCTCMonth" +list.get(i).getCarLeaseAmount());
						fixedCTCMonth = Float.valueOf(list.get(i).getNewFixedSalaryPerMonth());
					} else {
						fixedCtc = "FIXED CTC (A+B+C+D)";
//        		 fixedCTCMonth =  totalAmountMonth + Float.valueOf(list.get(i).getResidentTelephone()) + Float.valueOf(list.get(i).getAttire()) +
//            			sectionBExtraMonth + Float.valueOf(list.get(i).getLta()) + Float.valueOf(list.get(i).getGratuity());
//        		 fixedCTCMonth=fixedCTCMonth-list.get(i).getCarLeaseAmount();
						fixedCTCMonth = Float.valueOf(list.get(i).getNewFixedSalaryPerMonth());

					}

					PdfPCell cell57 = new PdfPCell(new Phrase(fixedCtc, tabletext));
					PdfPCell cell58 = new PdfPCell(new Phrase(String.valueOf(fixedCTCMonth), font9_5));
					cell58.setPaddingRight(5f);
					// PdfPCell cell59 = new PdfPCell(new
					// Phrase(String.valueOf(fixedCTCYear),font9_5));
					PdfPCell cell59 = new PdfPCell(
							new Phrase(String.valueOf(Float.valueOf(list.get(i).getNewFixedSalaryPerYear())), font9_5));
					cell59.setPaddingRight(5f);
					PdfPCell cell60 = null;
					String variabletext = "";
					if (list.get(i).getVariableTypeId() == 2) {

						variabletext = "Sales incentive pay";
					} else if (list.get(i).getVariableTypeId() == 1) {
						variabletext = "Variable Pay";
					} else {

					}
					PdfPCell cell63 = null;

					if (list.get(i).getVariableTypeId() != 3) {
						cell60 = new PdfPCell(new Phrase(
								variabletext + "\n \n (Onetime payment to be disbursed as per Company Policy)",
								tabletext));
						// cell63=new PdfPCell(new Phrase(String.valueOf(totalCTCYear),font9_5));
						cell63 = new PdfPCell(new Phrase(String.valueOf(totalCTCYear), font9_5));
						cell63.setPaddingRight(5f);
					} else {
						cell60 = new PdfPCell(new Phrase("No Incentive Avialable", tabletext));
						cell63 = new PdfPCell(new Phrase(String.valueOf(ctcWitoutVariblePay), font9_5));
						cell63.setPaddingRight(5f);

					}
					String newVariablePerYear = null;
					;
					if (list.get(i).getVariableTypeId() != 3) {
						newVariablePerYear = list.get(i).getNewVariablePerYear();
					} else {
						newVariablePerYear = "0";
					}

					PdfPCell cell61 = new PdfPCell(new Phrase(newVariablePerYear, font9_5));
					cell61.setPaddingRight(5f);
					PdfPCell cell62 = new PdfPCell(
							new Phrase("TOTAL CTC in INR (FIXED CTC + " + variabletext + " )", tabletext));

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
					cell13.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell14.setNoWrap(false);
					cell14.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell15.setNoWrap(false);
					cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell16.setNoWrap(false);
					cell16.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell17.setNoWrap(false);
					cell17.setHorizontalAlignment(Element.ALIGN_RIGHT);

//            cell18.setNoWrap(false);
//            cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
//            cell19.setNoWrap(false);
//            cell19.setHorizontalAlignment(Element.ALIGN_LEFT);
//            cell20.setNoWrap(false);
//            cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
//            
					cell21.setNoWrap(false);
					cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell22.setNoWrap(false);
					cell22.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell23.setNoWrap(false);
					cell23.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell24.setNoWrap(false);
					cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell25.setNoWrap(false);
					cell25.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell26.setNoWrap(false);
					cell26.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell27.setNoWrap(false);
					cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell28.setNoWrap(false);
					cell28.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell29.setNoWrap(false);
					cell29.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell30.setNoWrap(false);
					cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell31.setNoWrap(false);
					cell31.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell32.setNoWrap(false);
					cell32.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell33.setNoWrap(false);
					cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell34.setNoWrap(false);
					cell34.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell35.setNoWrap(false);
					cell35.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell36.setNoWrap(false);
					cell36.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell36.setColspan(3);

//            cell37.setNoWrap(false);
//            cell37.setHorizontalAlignment(Element.ALIGN_LEFT);
//            cell38.setNoWrap(false);
//            cell38.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell39.setNoWrap(false);
//            cell39.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            
					cell40.setNoWrap(false);
					cell40.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell41.setNoWrap(false);
					cell41.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell42.setNoWrap(false);
					cell42.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell43.setNoWrap(false);
					cell43.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell44.setNoWrap(false);
					cell44.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell45.setNoWrap(false);
					cell45.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell46.setNoWrap(false);
					cell46.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell47.setNoWrap(false);
					cell47.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell48.setNoWrap(false);
					cell48.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell49.setNoWrap(false);
					cell49.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell49.setColspan(3);

					cell50.setNoWrap(false);
					cell50.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell51.setNoWrap(false);
					cell51.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell52.setNoWrap(false);
					cell52.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell53.setNoWrap(false);
					cell53.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell53.setColspan(3);

					cell54.setNoWrap(false);
					cell54.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell55.setNoWrap(false);
					cell55.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell56.setNoWrap(false);
					cell56.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell57.setNoWrap(false);
					cell57.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell58.setNoWrap(false);
					cell58.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell59.setNoWrap(false);
					cell59.setHorizontalAlignment(Element.ALIGN_RIGHT);

					cell60.setNoWrap(false);
					cell60.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell60.setColspan(2);
					cell61.setNoWrap(false);
					cell61.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell62.setNoWrap(false);
					cell62.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell62.setColspan(2);
					cell63.setNoWrap(false);
					cell63.setHorizontalAlignment(Element.ALIGN_RIGHT);

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
					// table4.addCell(cell18);
					// table4.addCell(cell19);
					// table4.addCell(cell20);
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
//            table4.addCell(cell37);
//            table4.addCell(cell38);
//            table4.addCell(cell39);
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

					if (list.get(i).getCarLease().equalsIgnoreCase("Yes")) {
						table4.addCell(carLeaseCell);
						table4.addCell(carLeaseCell1);
						table4.addCell(carLeaseCell2);
						table4.addCell(carLeaseCell3);

					}

					table4.addCell(cell57);
					table4.addCell(cell58);
					table4.addCell(cell59);
					table4.addCell(cell60);
					table4.addCell(cell61);
					table4.addCell(cell62);
					table4.addCell(cell63);

					PdfPTable table5 = new PdfPTable(2);
					table1.setHorizontalAlignment(Element.ALIGN_LEFT);

					PdfPCell cell64 = new PdfPCell(new Phrase("Name :", font));
					PdfPCell cell65 = new PdfPCell(new Phrase(list.get(i).getEmpName(), fontBold));
					PdfPCell cell66 = new PdfPCell(new Phrase("Employee Code  :", font));
					PdfPCell cell67 = new PdfPCell(new Phrase(list.get(i).getEmpCode(), fontBold));
					PdfPCell cell68 = new PdfPCell(new Phrase("Designation : ", font));
					PdfPCell cell69 = new PdfPCell(new Phrase(list.get(i).getDesignation(), fontBold));
					table5.setSpacingBefore(10);
					table5.setSpacingAfter(10);
					table5.setWidthPercentage(50);
					table5.addCell(cell64);
					table5.addCell(cell65);

					table5.addCell(cell66);
					table5.addCell(cell67);
					table5.addCell(cell68);
					table5.addCell(cell69);

					String mainPara14 = "*Figures have been rounded to nearest Rupees";
					Paragraph para16 = new Paragraph(mainPara14, tabletext);
					para16.setSpacingAfter(10);
					para16.setIndentationLeft(70);

					image3 = Image.getInstance(imageName3);
					image3.scaleToFit(150f, 400f);
					image3.setAbsolutePosition(30, 10);
					image3.setSpacingBefore(1000);
					image3.setAlignment(Element.ALIGN_LEFT);
					doc.add(table5);

					doc.add(para15);

					table4.setWidthPercentage(70);
					doc.add(table4);
					doc.add(para16);
					doc.add(image3);
					doc.newPage();

				}

				pfdDocumentsService.savePDFDocuments(pfDocuments);

				doc.close();

				logger.info("sahi chl rha ha i");
			} catch (DocumentException exc) {
				// logs an exception thrown from somewhere
				logger.error("DocumentException", exc);
				throw new IOException(exc.getMessage());
			} finally {
				out.close();
			}
		} catch (Exception ex) {
			logger.error("doGet EXCEEEEEEE------->\"", ex);
			ex.printStackTrace();
			System.out.println("doGet EXCEEEEEEE------->" + ex);
		}

	}

	@RequestMapping(value = "/employeeGenerateWord", method = RequestMethod.POST)
	public @ResponseBody ResponseObject employeeGenerateWord() {

		ResponseObject robj = new ResponseObject();

		String fileName = "random.docx";
		WordDocument wordDocument = new WordDocument();
		wordDocument.setFileName(fileName);
		wordDocument.setCreatedOn(new Date());
		wordDocument.setStatus(CtoolConstanats.STATUS_ACTIVE);
		robj = wordDocumentService.saveWordDocuments(wordDocument);

		return robj;

	}

	public static String getIndianCurrencyFormat(String amount) {

		StringBuilder stringBuilder = new StringBuilder();

		char amountArray[] = amount.toCharArray();

		int a = 0, b = 0;

		for (int i = amountArray.length - 1; i >= 0; i--) {

			if (a < 3) {

				stringBuilder.append(amountArray[i]);

				a++;

			} else if (b < 2) {

				if (b == 0) {

					stringBuilder.append(",");

					stringBuilder.append(amountArray[i]);

					b++;

				} else {

					stringBuilder.append(amountArray[i]);

					b = 0;

				}

			}

		}

		return stringBuilder.reverse().toString();

	}

	protected XWPFDocument document;

	private BigInteger addListStyle(String style) {
		try {
			XWPFNumbering numbering = document.getNumbering();
			// generate numbering style from XML
			CTAbstractNum abstractNum = CTAbstractNum.Factory.parse(style);
			XWPFAbstractNum abs = new XWPFAbstractNum(abstractNum, numbering);

			// find available id in document
			BigInteger id = BigInteger.valueOf(0);
			boolean found = false;
			while (!found) {
				Object o = numbering.getAbstractNum(id);
				found = (o == null);
				if (!found)
					id = id.add(BigInteger.ONE);
			}
			// assign id
			abs.getAbstractNum().setAbstractNumId(id);
			// add to numbering, should get back same id
			id = numbering.addAbstractNum(abs);
			// add to num list, result is numid
			return document.getNumbering().addNum(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/getEmployeeWord", method = RequestMethod.GET)
	public @ResponseBody void getEmployeeWord(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String fileName = UUID.randomUUID().toString();

		response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		OutputStream out = response.getOutputStream();
		List<WordDocument> wordDocument = new ArrayList<WordDocument>();
		List<EmployeeBasicDetails> list = employeeService.employeePromtionListNotGenerated();

		System.out.println("value of" + getIndianCurrencyFormat(String.valueOf(1567124635)));

		try {
			String file = CtoolConstanats.folder_base + fileName + ".docx";

			XWPFDocument document = new XWPFDocument();

			String pattern = "#,##,##0.##";
			DecimalFormat formatter = new DecimalFormat(pattern);

			/*
			 * CTP ctp = CTP.Factory.newInstance(); //this add page number incremental
			 * 
			 * ctp.addNewR().addNewPgNum();
			 * 
			 * XWPFParagraph codePara = new XWPFParagraph(ctp, document); XWPFParagraph[]
			 * paragraphs = new XWPFParagraph[1];
			 * 
			 * paragraphs[0] = codePara; //position of number
			 * codePara.setAlignment(ParagraphAlignment.RIGHT);
			 * 
			 * CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
			 * 
			 * XWPFHeaderFooterPolicy headerFooterPolicy = new
			 * XWPFHeaderFooterPolicy(document, sectPr);
			 * headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, paragraphs);
			 */

			/*
			 * XWPFParagraph p1 = document.createParagraph(); XWPFRun r1 = p1.createRun();
			 * 
			 * XWPFHeaderFooterPolicy headerFooterPolicy = document.getHeaderFooterPolicy();
			 * // headerFooterPolicy = document.createHeaderFooterPolicy(); XWPFFooter
			 * footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT); p1
			 * = footer.getParagraphArray(0); p1.setAlignment(ParagraphAlignment.RIGHT);
			 * r1=p1.createRun(); r1.setText("Page"); r1.getCTR().addNewPgNum();
			 * r1.setText(" of 2");
			 */
			/*
			 * CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
			 * XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
			 * 
			 * CTP ctpFooter = CTP.Factory.newInstance(); CTR ctrFooter =
			 * ctpFooter.addNewR(); CTText ctFooter = ctrFooter.addNewT(); String footerText
			 * = "This is footer";
			 * 
			 * XWPFParagraph p1 = document.createParagraph(); XWPFRun r1 = p1.createRun();
			 * r1.setText("Page "); r1.getCTR().addNewPgNum(); r1.setText(" of 2");
			 * p1.setAlignment(ParagraphAlignment.RIGHT);
			 * ctFooter.setStringValue(String.valueOf(p1)); XWPFParagraph footerParagraph =
			 * new XWPFParagraph(ctpFooter, document); XWPFParagraph[] parsFooter = new
			 * XWPFParagraph[1]; parsFooter[0] = footerParagraph;
			 * policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
			 */

			Date date = new Date();
			String dateName = CommonUtils.formatDate(date, "MMMM dd, yyyy");

			for (int i = 0; i < list.size(); i++) {
				SpvsDetailsEntity spvsDetailsEntity = SpvsRepository.spvsDetails(list.get(i).getSpvsId());
				IncrementLetterDetails incrementLetterDetails = incrementvariablerepositiory
						.getIncrementLetterDetails(list.get(i).getIncrementLetterDetailsId());

				WordDocument wordDocuments = new WordDocument();
				wordDocuments.setEmpName(list.get(i).getEmpName());
				wordDocuments.setEmpCode(list.get(i).getEmpCode());
				wordDocuments.setCreatedOn(new Date());
				wordDocuments.setName(fileName + ".docx");
				wordDocuments.setStatus(CtoolConstanats.STATUS_ACTIVE);

				/*
				 * XWPFParagraph p = document.createParagraph(); XWPFRun r = p.createRun();
				 * 
				 * // create header start CTSectPr sectPr1 =
				 * document.getDocument().getBody().addNewSectPr(); XWPFHeaderFooterPolicy
				 * headerFooterPolicy1 = new XWPFHeaderFooterPolicy(document, sectPr1);
				 * 
				 * XWPFHeader header =
				 * headerFooterPolicy1.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
				 * 
				 * p = header.createParagraph(); p.setAlignment(ParagraphAlignment.RIGHT);
				 * 
				 * 
				 * r = p.createRun(); String imgFile = CtoolConstanats.folder_base + "logo.jpg";
				 * r.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_PNG,
				 * imgFile, Units.toEMU(150),Units.toEMU(70));
				 * 
				 * 
				 * 
				 * CTSectPr sectPr = document.getDocument().getBody().getSectPr(); if (sectPr ==
				 * null) sectPr = document.getDocument().getBody().addNewSectPr(); CTPageMar
				 * pageMar99 = sectPr.getPgMar(); if (pageMar99 == null) pageMar99 =
				 * sectPr.addNewPgMar(); pageMar99.setRight(BigInteger.valueOf(8720));
				 * pageMar99.setHeader(BigInteger.valueOf(300));
				 * 
				 */

				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun run = paragraph.createRun();

				XWPFHeader header = document.createHeader(HeaderFooterType.FIRST);

				paragraph = header.createParagraph();
				paragraph.setAlignment(ParagraphAlignment.RIGHT);

				CTSectPr sectPr11111 = document.getDocument().getBody().addNewSectPr();
				CTPageMar pageMar1111 = sectPr11111.addNewPgMar();

				pageMar1111.setRight(BigInteger.valueOf(3440L));

				run = paragraph.createRun();
				run.setShadow(true);
				String imgFile = CtoolConstanats.folder_base + "logo.jpg";
				run.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(150),
						Units.toEMU(70));
				run.setShadow(true);
				CTSectPr sectPr = document.getDocument().getBody().getSectPr();
				if (sectPr == null)
					sectPr = document.getDocument().getBody().addNewSectPr();
				CTPageMar pageMar99 = sectPr.getPgMar();
				if (pageMar99 == null)
					pageMar99 = sectPr.addNewPgMar();
				pageMar99.setHeader(BigInteger.valueOf(230));

				header = document.createHeader(HeaderFooterType.DEFAULT);

				paragraph = header.createParagraph();
				paragraph.setAlignment(ParagraphAlignment.RIGHT);
				run = paragraph.createRun();
				run.setShadow(true);
				run.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(150),
						Units.toEMU(70));
				run.setShadow(true);
				// create footer
				XWPFFooter footer = document.createFooter(HeaderFooterType.FIRST);

				paragraph = footer.createParagraph();
				paragraph.setAlignment(ParagraphAlignment.LEFT);

				run = paragraph.createRun();
				String imageName2 = CtoolConstanats.folder_base + spvsDetailsEntity.getHeaderImage();
				String imageName3 = CtoolConstanats.folder_base + spvsDetailsEntity.getFooterImage();
				run.addPicture(new FileInputStream(imageName2), XWPFDocument.PICTURE_TYPE_PNG, imageName2,
						Units.toEMU(500), Units.toEMU(70));
				run.setShadow(true);

				footer = document.createFooter(HeaderFooterType.DEFAULT);

				paragraph = footer.createParagraph();
				paragraph.setAlignment(ParagraphAlignment.LEFT);

				run = paragraph.createRun();
				run.setShadow(true);

				run.addPicture(new FileInputStream(imageName3), XWPFDocument.PICTURE_TYPE_PNG, imageName3,
						Units.toEMU(150), Units.toEMU(15));

				CTSectPr sectPr97 = document.getDocument().getBody().getSectPr();
				if (sectPr97 == null)
					sectPr97 = document.getDocument().getBody().addNewSectPr();
				CTPageMar pageMar97 = sectPr97.getPgMar();
				if (pageMar97 == null)
					pageMar97 = sectPr97.addNewPgMar();
				// pageMar97.setTop(BigInteger.valueOf(714L));
				pageMar97.setFooter(BigInteger.valueOf(100));

				/*
				 * XWPFFooter footer =
				 * headerFooterPolicy1.createFooter(XWPFHeaderFooterPolicy.DEFAULT);
				 * 
				 * p = footer.createParagraph(); p.setAlignment(ParagraphAlignment.LEFT);
				 * 
				 * CTTabStop tabStop = p.getCTP().getPPr().addNewTabs().addNewTab();
				 * tabStop.setVal(STTabJc.LEFT);
				 * 
				 * r = p.createRun(); String imageName2 = CtoolConstanats.folder_base +
				 * spvsDetailsEntity.getHeaderImage(); r.addPicture(new
				 * FileInputStream(imageName2), XWPFDocument.PICTURE_TYPE_PNG, imageName2,
				 * Units.toEMU(420), Units.toEMU(70));
				 * 
				 * CTSectPr sectPr97 = document.getDocument().getBody().getSectPr(); if
				 * (sectPr97 == null) sectPr97 =
				 * document.getDocument().getBody().addNewSectPr(); CTPageMar pageMar97 =
				 * sectPr97.getPgMar(); if (pageMar97 == null) pageMar97 =
				 * sectPr97.addNewPgMar(); // pageMar97.setRight(BigInteger.valueOf(8720));
				 * pageMar97.setFooter(BigInteger.valueOf(250));
				 * 
				 */

				// String imageName2 = CtoolConstanats.folder_base +
				// spvsDetailsEntity.getHeaderImage();

				// XWPFFooter footer = document.createFooter(HeaderFooterType.FIRST);

				// p = footer.createParagraph();
				// p.setAlignment(ParagraphAlignment.RIGHT);

				// r = p.createRun();
				// r.setText("Page ");
				// p.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");
				// r = p.createRun();
				// r.setText(" of ");
				// p.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* MERGEFORMAT");

				// r.addPicture(new FileInputStream(imageName2), XWPFDocument.PICTURE_TYPE_PNG,
				// imageName2, Units.toEMU(420), Units.toEMU(70));

				/*
				 * XWPFParagraph p = document.createParagraph(); XWPFRun r = p.createRun();
				 * 
				 * // create header start CTSectPr sectPr2 =
				 * document.getDocument().getBody().addNewSectPr(); XWPFHeaderFooterPolicy
				 * headerFooterPolicy1 = new XWPFHeaderFooterPolicy(document, sectPr2);
				 * 
				 * XWPFFooter header =
				 * headerFooterPolicy1.createFooter(XWPFHeaderFooterPolicy.DEFAULT);
				 * 
				 * p = header.createParagraph(); p.setAlignment(ParagraphAlignment.RIGHT);
				 * 
				 * CTTabStop tabStop = p.getCTP().getPPr().addNewTabs().addNewTab();
				 * tabStop.setVal(STTabJc.RIGHT); r = p.createRun(); r.setText("Page ");
				 * r.getCTR().addNewPgNum(); r.setText(" of 2");
				 * r.setFontFamily("Trebuchet MS"); ;
				 * 
				 * CTSectPr sectPr111 = document.getDocument().getBody().addNewSectPr();
				 * CTPageMar pageMar2 = sectPr111.addNewPgMar();
				 * 
				 * pageMar2.setRight(BigInteger.valueOf(17200L));
				 */

				/*
				 * r = p.createRun(); String imgFile=CtoolConstanats.folder_base+"logo.jpg";
				 * r.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_PNG,
				 * imgFile, Units.toEMU(150), Units.toEMU(70));
				 */

				/*
				 * CTSectPr sectPr1 = document.getDocument().getBody().addNewSectPr();
				 * XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document,
				 * sectPr1);
				 * 
				 * //write header content CTP ctpHeader = CTP.Factory.newInstance(); CTR
				 * ctrHeader = ctpHeader.addNewR(); CTText ctHeader = ctrHeader.addNewT();
				 * 
				 * String headerText = "This is header"; ctHeader.setStringValue(headerText);
				 * XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
				 * XWPFParagraph[] parsHeader = new XWPFParagraph[1]; parsHeader[0] =
				 * headerParagraph; policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT,
				 * parsHeader);
				 */

				/*
				 * XWPFParagraph title = document.createParagraph(); XWPFRun run =
				 * title.createRun(); title.setAlignment(ParagraphAlignment.RIGHT); String
				 * imgFile = CtoolConstanats.folder_base+"logo.jpg"; FileInputStream is = new
				 * FileInputStream(imgFile); run.addBreak(); run.addPicture(is,
				 * XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(50), Units.toEMU(50));
				 * // 200x200 pixels is.close();
				 * 
				 * 
				 * 
				 */

				XWPFParagraph date1 = document.createParagraph();
				date1.setAlignment(ParagraphAlignment.LEFT);

				XWPFRun date1Run = date1.createRun();
				date1Run.setText("Date: " + dateName);
				date1Run.setColor("001005");
				date1Run.setFontFamily("Trebuchet MS");
				date1Run.setFontSize(10);
				date1.setSpacingBefore(5);
				date1.setSpacingAfter(5);
				// date1Run.setBold(true);

				XWPFParagraph documentNo = document.createParagraph();
				documentNo.setAlignment(ParagraphAlignment.LEFT);

				XWPFRun documentNoRun = documentNo.createRun();
				documentNoRun.setText("Document No.: " + list.get(i).getDocumentNo());
				documentNoRun.setColor("001005");
				documentNoRun.setFontFamily("Trebuchet MS ");
				documentNoRun.setFontSize(10);
				// documentNoRun.setBold(true);
				documentNo.setSpacingBefore(5);
				documentNo.setSpacingAfter(250);

				XWPFParagraph employee = document.createParagraph();
				employee.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun employeeRun = employee.createRun();
				employeeRun.setText("Mr./Ms. " + list.get(i).getEmpName());
				employeeRun.setColor("001005"); // employeeRun.setBold(true);
				employeeRun.setFontFamily("Trebuchet MS");
				employeeRun.setFontSize(10);
				employee.setSpacingBefore(5);
				employee.setSpacingAfter(5);

				XWPFParagraph employeeCode = document.createParagraph();
				employeeCode.setAlignment(ParagraphAlignment.LEFT);
				employeeCode.setSpacingAfterLines(200);
				XWPFRun employeeCodeRun = employeeCode.createRun();
				employeeCodeRun.setText("Emp Code :" + list.get(i).getEmpCode());
				employeeCodeRun.setColor("001005"); // employeeCodeRun.setBold(true);
				employeeCodeRun.setFontFamily("Trebuchet MS");

				employeeCodeRun.setFontSize(10);

				employeeCode.setSpacingBefore(5);
				employeeCode.setSpacingAfter(5);
				// String para =incrementLetterDetails.getTitle();

				XWPFParagraph para = document.createParagraph();
				para.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun paraRun = para.createRun();
				paraRun.setText(incrementLetterDetails.getTitle());
				// paraRun.setColor("001005"); //employeeRun.setBold(true);
				paraRun.setFontFamily("Trebuchet MS");
				paraRun.setFontSize(11);
				paraRun.setUnderline(UnderlinePatterns.SINGLE);

				String[] spliteStr = list.get(i).getEmpName().split("\\s+");
				XWPFParagraph para1 = document.createParagraph();
				para1.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para1Run = para1.createRun();
				para1Run.setText("Dear " + spliteStr[0]);
				para1Run.setFontFamily("FreightSans Pro Light");
				para1Run.setFontSize(11);
				// para1Run.setBold(true);

				/* Number formate */

				CTAbstractNum cTAbstractNum = CTAbstractNum.Factory.newInstance();
				cTAbstractNum.setAbstractNumId(BigInteger.valueOf(0));
				CTLvl cTLvl = cTAbstractNum.addNewLvl();
				cTLvl.addNewNumFmt().setVal(STNumberFormat.DECIMAL);
				cTLvl.addNewLvlText().setVal("%1.");
				cTLvl.addNewStart().setVal(BigInteger.valueOf(1));

				XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);
				XWPFNumbering numbering = document.createNumbering();

				BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);

				BigInteger numID = numbering.addNum(abstractNumID);

				XWPFParagraph para2 = document.createParagraph();
				para2.setAlignment(ParagraphAlignment.BOTH);
				XWPFRun para2Run = para2.createRun();
				para2Run.setText(incrementLetterDetails.getParagraph6());
				para2Run.setColor("001005"); // employeeRun.setBold(true);
				para2Run.setFontFamily("FreightSans Pro Light");
				para2Run.setFontSize(11);

				String p2 = incrementLetterDetails.getParagraph7();
				if (list.get(i).getIncrementLetterDetailsId() == 2) {

					String designation = list.get(i).getNewDesignation();
					String p21 = p2.replace("~~designation~~", designation);
					XWPFParagraph para3 = document.createParagraph();
					para3.setAlignment(ParagraphAlignment.BOTH);
					XWPFRun para3Run = para3.createRun();
					para3Run.setText(p21);
					para3Run.setColor("001005"); // employeeRun.setBold(true);
					para3Run.setFontFamily("FreightSans Pro Light");
					para3Run.setFontSize(11);

				} else {
					XWPFParagraph para3 = document.createParagraph();
					para3.setAlignment(ParagraphAlignment.BOTH);
					XWPFRun para3Run = para3.createRun();
					para3Run.setText(incrementLetterDetails.getParagraph7());
					para3Run.setColor("001005"); // employeeRun.setBold(true);
					para3Run.setFontFamily("FreightSans Pro Light");
					para3Run.setFontSize(11);
				}

//					String p2=incrementLetterDetails.getParagraph7();
//					if(list.get(i).getIncrementLetterDetailsId()==2)
//					{
//						String designation=list.get(i).getNewDesignation();
//						String p12=p2.replace("~~designtion~~", designation);
//
//					}

				// Math.round((Float.valueOf(list.get(i).getNewFixedSalaryPerMonth())*12)))

				String para4_1 = incrementLetterDetails.getParagraph1().replace("~~year~~",
						list.get(i).getAssessmentYear());
				String mainpara4 = para4_1.replace("~~revisedsalary~~",
						String.valueOf(getIndianCurrencyFormat(String
								.valueOf(Math.round((Float.valueOf(list.get(i).getNewFixedSalaryPerMonth()) * 12)))))
								+ "/-");

				XWPFParagraph para4 = document.createParagraph();
				para4.setAlignment(ParagraphAlignment.BOTH);
				// para4.setNumID(numID);
				XWPFRun para4Run = para4.createRun();
				para4Run.setText("1. " + mainpara4);
				para4Run.setFontFamily("FreightSans Pro Light");
				para4Run.setFontSize(11);

				String mainpara5 = incrementLetterDetails.getParagraph2().replace("~~performancesalary~~",
						String.valueOf(getIndianCurrencyFormat(
								String.valueOf(Math.round(Float.valueOf(list.get(i).getDisbursedVariableZ()))))));

				XWPFParagraph para5 = document.createParagraph();
				para5.setAlignment(ParagraphAlignment.BOTH);
				XWPFRun para5Run = para5.createRun();
				para5Run.setText("2. " + mainpara5);
				para5Run.setFontFamily("FreightSans Pro Light");
				para5Run.setFontSize(11);

				XWPFParagraph para6 = document.createParagraph();
				para6.setAlignment(ParagraphAlignment.BOTH);
				XWPFRun para6Run = para6.createRun();
				para6Run.setText("3. " + incrementLetterDetails.getParagraph3());
				para6Run.setFontFamily("FreightSans Pro Light");
				para6Run.setFontSize(11);

				XWPFParagraph para7 = document.createParagraph();
				para7.setAlignment(ParagraphAlignment.BOTH);
				XWPFRun para7Run = para7.createRun();
				para7Run.setText("4. " + incrementLetterDetails.getParagraph4());
				para7Run.setFontFamily("FreightSans Pro Light");
				para7Run.setFontSize(11);
				// para7Run.setShadow(true);
				XWPFParagraph para8 = document.createParagraph();
				para8.setAlignment(ParagraphAlignment.BOTH);
				XWPFRun para8Run = para8.createRun();
				para8Run.setText("5. " + incrementLetterDetails.getParagraph5());
				para8Run.setFontFamily("FreightSans Pro Light");
				para8Run.setFontSize(11);
				para8.setSpacingAfterLines(200);

				XWPFParagraph para9 = document.createParagraph();
				para9.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para9Run = para9.createRun();
				para9Run.setText("Kindly acknowledge receipt of this letter by returning signed duplicate copy to HR.");
				para9Run.setFontFamily("FreightSans Pro Light");
				para9Run.setFontSize(11);
				para9.setSpacingAfterLines(150);

				XWPFParagraph para10 = document.createParagraph();
				para10.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para10Run = para10.createRun();
				para10Run.setText("With best regards,");
				para10Run.setFontFamily("FreightSans Pro Light");
				para10Run.setFontSize(11);
				para10.setSpacingBefore(10);
				para10.setSpacingAfter(2);
				// para10Run.setBold(true);

				XWPFParagraph para11 = document.createParagraph();
				para11.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para11Run = para11.createRun();
				para11Run.setText("For and on behalf of " + spvsDetailsEntity.getSpvsEntitiy().getCompanyName());
				para11Run.setFontFamily("FreightSans Pro Light");
				para11.setSpacingAfterLines(150);
				// para11Run.setBold(true);

				XWPFParagraph para12 = document.createParagraph();
				para12.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para12Run = para12.createRun();
				para12Run.setText(spvsDetailsEntity.getSpvsEntitiy().getDirector());
				para12Run.setFontFamily("FreightSans Pro Light");
				para12Run.setFontSize(11);
				// para12Run.setBold(true);
				para12.setSpacingAfter(1);

				XWPFParagraph para13 = document.createParagraph();
				para13.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para13Run = para13.createRun();
				para13Run.setText("Director");
				para13Run.setFontFamily("FreightSans Pro Light");
				para13Run.setFontSize(11);
				// para13Run.setBold(true);
				para13.setSpacingAfter(15);
				// para13.setSpacingAfterLines(600);

				XWPFParagraph para14 = document.createParagraph();
				para14.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun para14Run = para14.createRun();
				para14Run.setText("Annexure - A");
				para14Run.setFontFamily("FreightSans Pro Light");
				para14Run.setFontSize(11);
				// para14Run.setBold(true);

				XWPFTable table = document.createTable();
				table.setCellMargins(0, 100, 0, 100);
				XWPFTableRow row = table.getRow(0);
				XWPFParagraph tpara = row.getCell(0).getParagraphs().get(0);
				tpara.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun Run = tpara.createRun();
				Run.setText("Name ");
				Run.setFontFamily("FreightSans Pro Light");
				Run.setFontSize(11);
				// Run.setBold(true);

				XWPFParagraph tpara1 = row.addNewTableCell().getParagraphs().get(0);
				tpara1.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun Run1 = tpara1.createRun();
				Run1.setText(list.get(i).getEmpName());
				Run1.setFontFamily("Trebuchet MS");
				// Run1.setBold(true);
				Run1.setFontSize(10);

				row = table.createRow();

				XWPFParagraph tpara2 = row.getCell(0).getParagraphs().get(0);
				tpara2.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun Run2 = tpara2.createRun();
				Run2.setText("Employee Code ");
				Run2.setFontFamily("FreightSans Pro Light");
				Run2.setFontSize(11);
				// Run2.setBold(true);

				XWPFParagraph tpara3 = row.getCell(1).getParagraphs().get(0);
				tpara3.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun Run3 = tpara3.createRun();
				Run3.setText(list.get(i).getEmpCode());
				Run3.setFontFamily("Trebuchet MS");
				Run3.setFontSize(10);
				// Run3.setBold(true);

				row = table.createRow();

				XWPFParagraph tpara4 = row.getCell(0).getParagraphs().get(0);
				tpara4.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun Run4 = tpara4.createRun();
				Run4.setText("Designation ");
				Run4.setFontFamily("FreightSans Pro Light");
				Run4.setFontSize(11);
				// Run4.setBold(true);

				XWPFParagraph tpara5 = row.getCell(1).getParagraphs().get(0);
				tpara5.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun Run5 = tpara5.createRun();
				Run5.setText(list.get(i).getDesignation());
				Run5.setFontFamily("Trebuchet MS");
				Run5.setFontSize(10);
				// Run5.setBold(true);

//					        XWPFTable table= document.createTable();
//						    XWPFTableRow tableRowOne = table.getRow(0);	
//						  
//						    XWPFRun tbRun =tableRowOne.getCell(0).addParagraph().createRun();
				// int twipsPerInch = 9000;
				// tableRowOne.setHeight((int)(twipsPerInch*1/2));
				// tableRowOne.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);
//						    table.setCellMargins(0, 500, 0, 500);
//						    table.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(3000));
//						    table.setCellMargins(top, left, bottom, right);
				// CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
				// width.setType(STTblWidth.DXA);
				// width.setW(BigInteger.valueOf(2000));

				CTTblPr tb = table.getCTTbl().getTblPr();

				CTTbl cttblp = table.getCTTbl();
				CTTblPr cttblpr;
				cttblpr = (cttblp.getTblPr() == null ? cttblp.addNewTblPr() : cttblp.getTblPr());

				// table alignment
				CTJc ctjc = (cttblpr.isSetJc() ? cttblpr.getJc() : cttblpr.addNewJc());
				ctjc.setVal(STJc.CENTER);

				XWPFParagraph para15 = document.createParagraph();
				XWPFRun para15Run = para15.createRun();
				para15Run.setText("");

				XWPFParagraph para16 = document.createParagraph();
				para16.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun para16Run = para16.createRun();
				para16Run.setText("CTC BREAK-UP");
				para16Run.setFontFamily("FreightSans Pro Light");
				para16Run.setFontSize(11);
				para16Run.setBold(true);
				para16Run.setUnderline(UnderlinePatterns.SINGLE);

				// int table1Width = 60;
				XWPFTable table1 = document.createTable();

				table1.setCellMargins(0, 70, 0, 70);
				// table1.setWidth(table1Width);
				// table1.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(6000));
				// table1.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(2000));

				CTTblPr tb1 = table1.getCTTbl().getTblPr();

				CTTbl cttblp1 = table1.getCTTbl();
				CTTblPr cttblpr1;
				cttblpr1 = (cttblp1.getTblPr() == null ? cttblp1.addNewTblPr() : cttblp1.getTblPr());

				// table alignment
				CTJc ctjc1 = (cttblpr1.isSetJc() ? cttblpr1.getJc() : cttblpr1.addNewJc());
				ctjc1.setVal(STJc.CENTER);

				// table1.setInsideHBorder( XWPFBorderType.SINGLE, 10, 0, "001005");

//					        CTTblPr tblpro = table1.getCTTbl().getTblPr();
//
//					        CTTblBorders borders = tblpro.addNewTblBorders();
//					        borders.addNewBottom().setVal(STBorder.DOUBLE); 
//					        borders.addNewLeft().setVal(STBorder.THICK);
//					        borders.addNewRight().setVal(STBorder.BASIC_THIN_LINES);
//					        borders.addNewTop().setVal(STBorder.SINGLE);

				// table1.getCTTbl().getTblPr().getTblBorders().getTop().setSz(BigInteger.valueOf(10));
				// table1.getCTTbl().getTblPr().getTblBorders().getLeft().setSz(BigInteger.valueOf(12));
				// table1.getCTTbl().getTblPr().getTblBorders().getRight().setSz(BigInteger.valueOf(12));
				// table1.getCTTbl().getTblPr().getTblBorders().getBottom().setSz(BigInteger.valueOf(12));
				// table1.getCTTbl().getTblPr().getTblBorders().getInsideH().setSz(BigInteger.valueOf(12));
				// table1.getCTTbl().getTblPr().getTblBorders().getInsideV().setSz(BigInteger.valueOf(12));

				XWPFTableRow row1 = table1.getRow(0);

				int twipsPerInch111 = 7500;
				row1.setHeight((int) (twipsPerInch111 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para = row1.getCell(0).getParagraphs().get(0);
				t2para.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun t2Run = t2para.createRun();
				t2Run.setText("SALARY COMPONENTS");
				t2Run.setFontFamily("FreightSans Pro Light");
				t2Run.setBold(true);
				// cell.getCTTc().getTcPr().getTcBorders().addNewRight().setVal(STBorder.NIL)
				// row1.getCell(0).getCTTc().getTcPr().getTcBorders().addNewTop().setVal(STBorder.BASIC_BLACK_DASHES);

				XWPFParagraph t2para1 = row1.addNewTableCell().getParagraphs().get(0);
				t2para1.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun t2Run1 = t2para1.createRun();
				t2Run1.setText("MONTHLY");
				t2Run1.setFontFamily("FreightSans Pro Light");
				t2Run1.setBold(true);

				XWPFParagraph t2para2 = row1.addNewTableCell().getParagraphs().get(0);
				t2para2.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun t2Run2 = t2para2.createRun();
				t2Run2.setText("YEARLY");
				t2Run2.setFontFamily("FreightSans Pro Light");
				t2Run2.setBold(true);

				row1 = table1.createRow();

				XWPFParagraph t2para115 = row1.getCell(1).getParagraphs().get(0);
				t2para115.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun t2Run115 = t2para115.createRun();
				t2Run115.setText("INR");
				t2Run115.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para116 = row1.getCell(2).getParagraphs().get(0);
				t2para116.setAlignment(ParagraphAlignment.CENTER);
				XWPFRun t2Run116 = t2para116.createRun();
				t2Run116.setText("INR");
				t2Run116.setFontFamily("FreightSans Pro Light");

				int twipsPerInch = 7500;
				row1.setHeight((int) (twipsPerInch * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				row1 = table1.createRow();

				XWPFParagraph t2para3 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run3 = t2para3.createRun();
				t2Run3.setText("A.                                     BASE SALARY");
				t2Run3.setFontFamily("FreightSans Pro Light");
				t2Run3.setBold(true);
				row1.getCell(0).getCTTc().addNewTcPr();
				row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
				row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
				row1.getCtRow().removeTc(1);
				row1.getCtRow().removeTc(1);

				int twipsPerInch11 = 7500;
				row1.setHeight((int) (twipsPerInch11 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				row1 = table1.createRow();

				int twipsPerInch2 = 7500;
				row1.setHeight((int) (twipsPerInch2 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para4 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run4 = t2para4.createRun();
				t2Run4.setText("Basic");
				t2Run4.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para5 = row1.getCell(1).getParagraphs().get(0);
				t2para5.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run5 = t2para5.createRun();
				t2Run5.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getBasicSalary())))));
				t2Run5.setFontFamily("Trebuchet MS");
				t2Run5.setFontSize(10);

				XWPFParagraph t2para6 = row1.getCell(2).getParagraphs().get(0);
				t2para6.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run6 = t2para6.createRun();
				t2Run6.setText(String.valueOf(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getBasicSalary()) * 12)))));
				t2Run6.setFontFamily("Trebuchet MS");
				t2Run6.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch3 = 7500;
				row1.setHeight((int) (twipsPerInch3 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para7 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run7 = t2para7.createRun();
				t2Run7.setText("HRA");
				t2Run7.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para8 = row1.getCell(1).getParagraphs().get(0);
				t2para8.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run8 = t2para8.createRun();
				t2Run8.setText(getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getHr())))));
				t2Run8.setFontFamily("Trebuchet MS");
				t2Run8.setFontSize(10);

				XWPFParagraph t2para9 = row1.getCell(2).getParagraphs().get(0);
				t2para9.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run9 = t2para9.createRun();
				t2Run9.setText(String.valueOf(
						getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getHr()) * 12)))));
				t2Run9.setFontFamily("Trebuchet MS");
				t2Run9.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch4 = 7500;
				row1.setHeight((int) (twipsPerInch4 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para10 = row1.getCell(0).getParagraphs().get(0);

				XWPFRun t2Run10 = t2para10.createRun();
				t2Run10.setText("Special Allowance");
				t2Run10.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para11 = row1.getCell(1).getParagraphs().get(0);
				t2para11.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run11 = t2para11.createRun();
				t2Run11.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getSpecialAllowance())))));
				t2Run11.setFontFamily("Trebuchet MS");
				t2Run11.setFontSize(10);
				XWPFParagraph t2para12 = row1.getCell(2).getParagraphs().get(0);
				t2para12.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run12 = t2para12.createRun();
				t2Run12.setText(String.valueOf(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getSpecialAllowance()) * 12)))));
				t2Run12.setFontFamily("Trebuchet MS");
				t2Run12.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch5 = 7500;
				row1.setHeight((int) (twipsPerInch5 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para13 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run13 = t2para13.createRun();
				t2Run13.setText("Supplementary Allowance");
				t2Run13.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para14 = row1.getCell(1).getParagraphs().get(0);
				t2para14.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run14 = t2para14.createRun();
				t2Run14.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getSupplementaryAllowance())))));
				t2Run14.setFontFamily("Trebuchet MS");
				t2Run14.setFontSize(10);
				XWPFParagraph t2para15 = row1.getCell(2).getParagraphs().get(0);
				t2para15.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run15 = t2para15.createRun();
				t2Run15.setText(String.valueOf(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getSupplementaryAllowance()) * 12)))));
				t2Run15.setFontFamily("Trebuchet MS");
				t2Run15.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch6 = 7500;
				row1.setHeight((int) (twipsPerInch6 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para16 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run16 = t2para16.createRun();
				t2Run16.setText("Children Education Allowance");
				t2Run16.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para17 = row1.getCell(1).getParagraphs().get(0);
				t2para17.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run17 = t2para17.createRun();
				t2Run17.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getChildrenEducationAllowance())))));
				t2Run17.setFontFamily("Trebuchet MS");
				t2Run17.setFontSize(10);

				XWPFParagraph t2para18 = row1.getCell(2).getParagraphs().get(0);
				t2para18.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run18 = t2para18.createRun();
				t2Run18.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getChildrenEducationAllowance()) * 12))));
				t2Run18.setFontFamily("Trebuchet MS");
				t2Run18.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch7 = 7500;
				row1.setHeight((int) (twipsPerInch7 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				if (list.get(i).getDepartment().equalsIgnoreCase("solar Rooftop")) {
					String text = "Sales incentive Pay";
				} else {
					String text = "PF (Company's share)";
				}

				if (list.get(i).getDepartment().equalsIgnoreCase("solar Rooftop")) {

					XWPFParagraph t2para19 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run19 = t2para19.createRun();
					t2Run19.setText("Sales incentive Pay");
					t2Run19.setFontFamily("FreightSans Pro Light");

					XWPFParagraph t2para21 = row1.getCell(1).getParagraphs().get(0);
					t2para21.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run21 = t2para21.createRun();
					t2Run21.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getPf())))));
					t2Run21.setFontFamily("Trebuchet MS");
					t2Run21.setFontSize(10);

					XWPFParagraph t2para22 = row1.getCell(2).getParagraphs().get(0);
					t2para22.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run22 = t2para22.createRun();
					t2Run22.setText(getIndianCurrencyFormat(
							String.valueOf(Math.round(Float.valueOf(list.get(i).getPf()) * 12))));
					t2Run22.setFontFamily("Trebuchet MS");
					t2Run22.setFontSize(10);

				} else {
					XWPFParagraph t2para19 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run19 = t2para19.createRun();
					t2Run19.setText("PF (Company's share)");
					t2Run19.setFontFamily("FreightSans Pro Light");

					XWPFParagraph t2para21 = row1.getCell(1).getParagraphs().get(0);
					t2para21.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run21 = t2para21.createRun();
					t2Run21.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getPf())))));
					t2Run21.setFontFamily("Trebuchet MS");
					t2Run21.setFontSize(10);

					XWPFParagraph t2para22 = row1.getCell(2).getParagraphs().get(0);
					t2para22.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run22 = t2para22.createRun();
					t2Run22.setText(getIndianCurrencyFormat(
							String.valueOf(Math.round(Float.valueOf(list.get(i).getPf()) * 12))));
					t2Run22.setFontFamily("Trebuchet MS");
					t2Run22.setFontSize(10);
				}

				Float totalAmountMonth = Float.valueOf(list.get(i).getBasicSalary())
						+ Float.valueOf(list.get(i).getHr()) + +Float.valueOf(list.get(i).getSpecialAllowance())
						+ Float.valueOf(list.get(i).getSupplementaryAllowance())
						+ Float.valueOf(list.get(i).getChildrenEducationAllowance())
						+ Float.valueOf(list.get(i).getPf());

				Float totalAmountYear = (Float.valueOf(list.get(i).getBasicSalary()) * 12)
						+ (Float.valueOf(list.get(i).getHr()) * 12)
						+ +(Float.valueOf(list.get(i).getSpecialAllowance()) * 12)
						+ (Float.valueOf(list.get(i).getSupplementaryAllowance()) * 12)
						+ (Float.valueOf(list.get(i).getChildrenEducationAllowance()) * 12)
						+ (Float.valueOf(list.get(i).getPf()) * 12);

				row1 = table1.createRow();

				int twipsPerInch8 = 7500;
				row1.setHeight((int) (twipsPerInch8 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				// totalAmountMonth
				XWPFParagraph t2para23 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run23 = t2para23.createRun();
				t2Run23.setText("Total");
				t2Run23.setFontFamily("FreightSans Pro Light");
				t2Run23.setBold(true);

				XWPFParagraph t2para24 = row1.getCell(1).getParagraphs().get(0);
				t2para24.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run24 = t2para24.createRun();
				t2Run24.setText(getIndianCurrencyFormat(String.valueOf(Math.round(totalAmountMonth))));
				t2Run24.setFontFamily("Trebuchet MS");
				t2Run24.setBold(true);
				t2Run24.setFontSize(10);

				XWPFParagraph t2para25 = row1.getCell(2).getParagraphs().get(0);
				t2para25.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run25 = t2para25.createRun();
				t2Run25.setText(getIndianCurrencyFormat(String.valueOf(Math.round(totalAmountYear))));
				t2Run25.setFontFamily("Trebuchet MS");
				t2Run25.setBold(true);
				t2Run25.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch9 = 7500;
				row1.setHeight((int) (twipsPerInch9 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para26 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run26 = t2para26.createRun();
				t2Run26.setText("B.                                REIMBURSABLE (bills to be submitted as instructed)");
				t2Run26.setFontFamily("FreightSans Pro Light");
				t2Run26.setBold(true);

				row1.getCell(0).getCTTc().addNewTcPr();
				row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
				row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
				row1.getCtRow().removeTc(1);
				row1.getCtRow().removeTc(1);

				row1 = table1.createRow();

				int twipsPerInch10 = 7500;
				row1.setHeight((int) (twipsPerInch10 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para27 = row1.getCell(0).getParagraphs().get(0);

				XWPFRun t2Run27 = t2para27.createRun();
				t2Run27.setText("Residential Telephone");
				t2Run27.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para28 = row1.getCell(1).getParagraphs().get(0);
				t2para28.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run28 = t2para28.createRun();
				t2Run28.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getResidentTelephone())))));
				t2Run28.setFontFamily("Trebuchet MS");
				t2Run28.setFontSize(10);

				XWPFParagraph t2para29 = row1.getCell(2).getParagraphs().get(0);
				t2para29.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run29 = t2para29.createRun();
				t2Run29.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getResidentTelephone()) * 12))));
				t2Run29.setFontFamily("Trebuchet MS");
				t2Run29.setFontSize(10);

				row1 = table1.createRow();
				int twipsPerInch1111 = 7500;
				row1.setHeight((int) (twipsPerInch1111 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para30 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run30 = t2para30.createRun();
				t2Run30.setText("Attire");
				t2Run30.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para31 = row1.getCell(1).getParagraphs().get(0);
				t2para31.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run31 = t2para31.createRun();
				t2Run31.setText(
						getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getAttire())))));
				t2Run31.setFontFamily("Trebuchet MS");
				t2Run31.setFontSize(10);

				XWPFParagraph t2para32 = row1.getCell(2).getParagraphs().get(0);
				t2para32.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run32 = t2para32.createRun();
				t2Run32.setText(getIndianCurrencyFormat(
						String.valueOf(Math.round(Float.valueOf(list.get(i).getAttire()) * 12))));
				t2Run32.setFontFamily("Trebuchet MS");
				t2Run32.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch12 = 7500;
				row1.setHeight((int) (twipsPerInch12 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				Float sectionBExtraMonth = Float.valueOf(list.get(i).getNewspaper());
				Float sectionBExtraYear = (Float.valueOf(list.get(i).getNewspaper()) * 12);

				XWPFParagraph t2para33 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run33 = t2para33.createRun();
				t2Run33.setText("Newspaper, Books and Periodicals");
				t2Run33.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para34 = row1.getCell(1).getParagraphs().get(0);
				t2para34.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run34 = t2para34.createRun();
				t2Run34.setText(getIndianCurrencyFormat(String.valueOf(Math.round(sectionBExtraMonth))));
				t2Run34.setFontFamily("Trebuchet MS");
				t2Run34.setFontSize(10);

				XWPFParagraph t2para35 = row1.getCell(2).getParagraphs().get(0);
				t2para35.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run35 = t2para35.createRun();
				t2Run35.setText(getIndianCurrencyFormat(String.valueOf(Math.round(sectionBExtraYear))));
				t2Run35.setFontFamily("Trebuchet MS");
				t2Run35.setFontSize(10);

				row1 = table1.createRow();

				int twipsPerInch13 = 7500;
				row1.setHeight((int) (twipsPerInch13 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para36 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run36 = t2para36.createRun();
				t2Run36.setText("C.                                  TAXABLE COMPONENT (reimbursable as per law)");
				t2Run36.setFontFamily("FreightSans Pro Light");
				t2Run36.setBold(true);
				row1.getCell(0).getCTTc().addNewTcPr();
				row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
				row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
				row1.getCtRow().removeTc(1);
				row1.getCtRow().removeTc(1);

				row1 = table1.createRow();

				int twipsPerInch14 = 7500;
				row1.setHeight((int) (twipsPerInch14 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				XWPFParagraph t2para37 = row1.getCell(0).getParagraphs().get(0);
				XWPFRun t2Run37 = t2para37.createRun();
				t2Run37.setText("LTA (1 basic)");
				t2Run37.setFontFamily("FreightSans Pro Light");

				XWPFParagraph t2para38 = row1.getCell(1).getParagraphs().get(0);
				t2para38.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run38 = t2para38.createRun();
				t2Run38.setText(
						getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getLta())))));
				t2Run38.setFontFamily("Trebuchet MS");
				t2Run38.setFontSize(10);

				XWPFParagraph t2para39 = row1.getCell(2).getParagraphs().get(0);
				t2para39.setAlignment(ParagraphAlignment.RIGHT);
				XWPFRun t2Run39 = t2para39.createRun();
				t2Run39.setText(
						getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(list.get(i).getLta()) * 12))));
				t2Run39.setFontFamily("Trebuchet MS");
				t2Run39.setFontSize(10);

				Float fixedCTCYear = totalAmountYear + (Float.valueOf(list.get(i).getResidentTelephone()) * 12)
						+ (Float.valueOf(list.get(i).getAttire()) * 12) + sectionBExtraYear
						+ (Float.valueOf(list.get(i).getLta()) * 12) + (Float.valueOf(list.get(i).getGratuity()) * 12);

				// Float totalCTCYear = fixedCTCYear +
				// Float.valueOf(list.get(i).getVariablePay());

				Float totalCTCYear = Float.valueOf(list.get(i).getNewFixedSalaryPerYear())
						+ Float.valueOf(list.get(i).getNewVariablePerYear());
				Float ctcWitoutVariblePay = Float.valueOf(list.get(i).getNewFixedSalaryPerYear());
				Float fixedCTCMonth = null;
				String fixedCtc = null;

				// Float totalCTCYear= fixedCTCYear+Float.valueOf(list.get(i).getVariablePay());
				// Float fixedCTCMonth=null;
				// String fixedCtc=null;
				if (list.get(i).getCarLease().equalsIgnoreCase("Yes")) {
					fixedCtc = "FIXED CTC (A+B+C+D+E)";
//		        	 fixedCTCMonth =  totalAmountMonth + Float.valueOf(list.get(i).getResidentTelephone()) + Float.valueOf(list.get(i).getAttire()) +
//		            			sectionBExtraMonth + Float.valueOf(list.get(i).getLta()) + Float.valueOf(list.get(i).getGratuity());
//		        	 fixedCTCMonth=fixedCTCMonth + list.get(i).getCarLeaseAmount();
//		        	 System.out.println("fixedCTCMonth" +list.get(i).getCarLeaseAmount());

					row1 = table1.createRow();

					int twipsPerInch15 = 7500;
					row1.setHeight((int) (twipsPerInch15 * 1 / 20));
					row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

					XWPFParagraph t2para40 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run40 = t2para40.createRun();
					t2Run40.setText("D.                                 ELIGIBLITY (AS PER COMPANY Policy)");
					t2Run40.setFontFamily("FreightSans Pro Light");
					t2Run40.setBold(true);
					row1.getCell(0).getCTTc().addNewTcPr();
					row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
					row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
					// row1.getCtRow().removeTc(1);
					row1.getCtRow().removeTc(1);
					row1.getCtRow().removeTc(1);

					row1 = table1.createRow();
					int twipsPerInch16 = 7500;
					row1.setHeight((int) (twipsPerInch16 * 1 / 20));
					row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

					XWPFParagraph t2para41 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run41 = t2para41.createRun();
					t2Run41.setText("Gratuity");
					t2Run41.setFontFamily("FreightSans Pro Light");

					XWPFParagraph t2para42 = row1.getCell(1).getParagraphs().get(0);
					t2para42.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run42 = t2para42.createRun();
					t2Run42.setText(getIndianCurrencyFormat(
							String.valueOf(Math.round(Float.valueOf(list.get(i).getGratuity())))));
					t2Run42.setFontFamily("Trebuchet MS");
					t2Run42.setFontSize(10);

					XWPFParagraph t2para43 = row1.getCell(2).getParagraphs().get(0);
					t2para43.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run43 = t2para43.createRun();
					t2Run43.setText(getIndianCurrencyFormat(
							String.valueOf(Math.round(Float.valueOf(list.get(i).getGratuity()) * 12))));
					t2Run43.setFontFamily("Trebuchet MS");
					t2Run43.setFontSize(10);

					row1 = table1.createRow();

					int twipsPerInch17 = 7500;
					row1.setHeight((int) (twipsPerInch17 * 1 / 20));
					row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

					XWPFParagraph t2para140 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run140 = t2para140.createRun();
					t2Run140.setText(
							"E.                              Car Lease with the Third Party purely for official purposes");
					t2Run140.setFontFamily("FreightSans Pro Light");
					t2Run140.setBold(true);
					row1.getCell(0).getCTTc().addNewTcPr();
					row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
					row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
					row1.getCtRow().removeTc(1);
					row1.getCtRow().removeTc(1);

					row1 = table1.createRow();

					int twipsPerInch18 = 7500;
					row1.setHeight((int) (twipsPerInch18 * 1 / 20));
					row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

					XWPFParagraph t2para141 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run141 = t2para141.createRun();
					t2Run141.setText("Payment towards Car Lease");
					t2Run141.setFontFamily("FreightSans Pro Light");

					XWPFParagraph t2para142 = row1.getCell(1).getParagraphs().get(0);
					t2para142.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run142 = t2para142.createRun();
					t2Run142.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(list.get(i).getCarLeaseAmount()))));
					t2Run142.setFontFamily("Trebuchet MS");
					t2Run142.setFontSize(10);

					XWPFParagraph t2para143 = row1.getCell(2).getParagraphs().get(0);
					t2para143.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run143 = t2para143.createRun();
					t2Run143.setText(getIndianCurrencyFormat(
							String.valueOf(Math.round(Float.valueOf(list.get(i).getCarLeaseAmount()) * 12))));
					t2Run143.setFontFamily("Trebuchet MS");
					t2Run143.setFontSize(10);

					row1 = table1.createRow();

					int twipsPerInch19 = 7500;
					row1.setHeight((int) (twipsPerInch19 * 1 / 20));
					row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

					fixedCTCMonth = Float.valueOf(list.get(i).getNewFixedSalaryPerMonth());
					XWPFParagraph t2para44 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run44 = t2para44.createRun();
					t2Run44.setText(fixedCtc);
					t2Run44.setFontFamily("FreightSans Pro Light");
					t2Run44.setBold(true);

					XWPFParagraph t2para45 = row1.getCell(1).getParagraphs().get(0);
					t2para45.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run45 = t2para45.createRun();
					t2Run45.setText(getIndianCurrencyFormat(String.valueOf(Math.round(fixedCTCMonth))));
					t2Run45.setFontFamily("Trebuchet MS");
					t2Run45.setFontSize(10);

					XWPFParagraph t2para46 = row1.getCell(2).getParagraphs().get(0);
					t2para46.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run46 = t2para46.createRun();
					t2Run46.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(fixedCTCMonth) * 12))));
					t2Run46.setFontFamily("Trebuchet MS");
					t2Run46.setFontSize(10);
				} else {
					row1 = table1.createRow();

					int twipsPerInch20 = 7500;
					row1.setHeight((int) (twipsPerInch20 * 1 / 20));
					row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

					fixedCtc = "FIXED CTC (A+B+C+D)";
//		        		 fixedCTCMonth =  totalAmountMonth + Float.valueOf(list.get(i).getResidentTelephone()) + Float.valueOf(list.get(i).getAttire()) +
//		            			sectionBExtraMonth + Float.valueOf(list.get(i).getLta()) + Float.valueOf(list.get(i).getGratuity());
//		        		 fixedCTCMonth=fixedCTCMonth-list.get(i).getCarLeaseAmount();
					fixedCTCMonth = Float.valueOf(list.get(i).getNewFixedSalaryPerMonth());
					XWPFParagraph t2para44 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run44 = t2para44.createRun();
					t2Run44.setText(fixedCtc);
					t2Run44.setFontFamily("FreightSans Pro Light");
					t2Run44.setBold(true);

					XWPFParagraph t2para45 = row1.getCell(1).getParagraphs().get(0);
					t2para45.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run45 = t2para45.createRun();
					t2Run45.setText(getIndianCurrencyFormat(String.valueOf(Math.round(fixedCTCMonth))));
					t2Run45.setFontFamily("Trebuchet MS");
					t2Run45.setFontSize(10);
					t2Run45.setBold(true);

					XWPFParagraph t2para46 = row1.getCell(2).getParagraphs().get(0);
					t2para46.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run46 = t2para46.createRun();
					t2Run46.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(fixedCTCMonth) * 12))));
					t2Run46.setFontFamily("Trebuchet MS");
					t2Run46.setFontSize(10);
					t2Run46.setBold(true);

				}

//				  XWPFParagraph t2para44 =row1.getCell(0).getParagraphs().get(0); XWPFRun
//				  t2Run44 =t2para44.createRun(); t2Run44.setText("FIXED CTC (A+B+C+D)");
//				  t2Run44.setFontFamily("FreightSans Pro Light");
//				  t2Run44.setBold(true);
//				  
//				  XWPFParagraph t2para45=row1.getCell(1).getParagraphs().get(0); 
//				  t2para45.setAlignment(ParagraphAlignment.RIGHT);
//				  XWPFRun
//				  t2Run45 =t2para45.createRun();
//				  t2Run45.setText(String.valueOf(formatter.format(Math.round(fixedCTCMonth))));
//				  t2Run45.setFontFamily("Trebuchet MS");
//				  t2Run45.setFontSize(10);
//				  
//				  XWPFParagraph t2para46=row1.getCell(2).getParagraphs().get(0); 
//				  t2para46.setAlignment(ParagraphAlignment.RIGHT);
//				  XWPFRun
//				  t2Run46=t2para46.createRun(); t2Run46.setText(String.valueOf(formatter.format(Math.round(fixedCTCYear))));
//				  t2Run46.setFontFamily("Trebuchet MS");
//				  t2Run46.setFontSize(10);

				String variabletext = "";

				if (list.get(i).getVariableTypeId() == 2) {
					variabletext = "Incentive pay";
				} else if (list.get(i).getVariableTypeId() == 1) {
					variabletext = "Variable Pay";
				} else {
				}

				row1 = table1.createRow();
				int twipsPerInch22 = 7500;
				row1.setHeight((int) (twipsPerInch22 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				String newVariablePerYear = null;
				;
				if (list.get(i).getVariableTypeId() != 3) {
					newVariablePerYear = list.get(i).getNewVariablePerYear();
				} else {
					newVariablePerYear = "0";
				}

				if (list.get(i).getVariableTypeId() != 3) {

					XWPFParagraph t2para47 = row1.getCell(0).getParagraphs().get(0);

					XWPFRun t2Run47 = t2para47.createRun();
					t2Run47.setText(variabletext + "(One time payment to be disbursed as per company policy)");
					t2Run47.setFontFamily("FreightSans Pro Light");
					row1.getCell(0).getCTTc().addNewTcPr();
					row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
					row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));

					XWPFParagraph t2para49 = row1.getCell(1).getParagraphs().get(0);
					t2para49.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run49 = t2para49.createRun();
					t2Run49.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(newVariablePerYear)))));
					t2Run49.setFontFamily("Trebuchet MS");
					t2Run49.setFontSize(10);
					row1.getCtRow().removeTc(2);
				} else {
					XWPFParagraph t2para47 = row1.getCell(0).getParagraphs().get(0);

					XWPFRun t2Run47 = t2para47.createRun();
					t2Run47.setText("Incentive");
					t2Run47.setFontFamily("FreightSans Pro Light");
					row1.getCell(0).getCTTc().addNewTcPr();
					row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
					row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
					// float ctcWithoutVariablePay = totalCTCYear -
					// Float.parseFloat(list.get(i).getVariablePay());

					XWPFParagraph t2para49 = row1.getCell(1).getParagraphs().get(0);

					t2para49.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run49 = t2para49.createRun();
					t2Run49.setText(
							getIndianCurrencyFormat(String.valueOf(Math.round(Float.valueOf(newVariablePerYear)))));
					t2Run49.setFontFamily("Trebuchet MS");
					t2Run49.setFontSize(10);
					row1.getCtRow().removeTc(2);
				}

				row1 = table1.createRow();

				int twipsPerInch23 = 7500;
				row1.setHeight((int) (twipsPerInch23 * 1 / 20));
				row1.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT);

				if (list.get(i).getVariableTypeId() != 3) {
					XWPFParagraph t2para48 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run48 = t2para48.createRun();
					t2Run48.setText("Total CTC in INR (FIXED CTC +" + variabletext + ")");
					t2Run48.setFontFamily("FreightSans Pro Light");
					t2Run48.setBold(true);
					row1.getCell(0).getCTTc().addNewTcPr();
					row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
					row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));

					XWPFParagraph t2para50 = row1.getCell(1).getParagraphs().get(0);
					t2para50.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run50 = t2para50.createRun();
					t2Run50.setText(getIndianCurrencyFormat(String.valueOf(Math.round(totalCTCYear))));
					t2Run50.setFontFamily("Trebuchet MS");
					t2Run50.setFontSize(10);
					t2Run50.setBold(true);
					row1.getCtRow().removeTc(2);
				} else {
					XWPFParagraph t2para48 = row1.getCell(0).getParagraphs().get(0);
					XWPFRun t2Run48 = t2para48.createRun();
					t2Run48.setText("Total CTC in INR (FIXED CTC +" + variabletext + ")");
					t2Run48.setFontFamily("FreightSans Pro Light");
					t2Run48.setBold(true);
					row1.getCell(0).getCTTc().addNewTcPr();
					row1.getCell(0).getCTTc().getTcPr().addNewGridSpan();
					row1.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));

					XWPFParagraph t2para50 = row1.getCell(1).getParagraphs().get(0);
					t2para50.setAlignment(ParagraphAlignment.RIGHT);
					XWPFRun t2Run50 = t2para50.createRun();
					t2Run50.setText(getIndianCurrencyFormat(String.valueOf(Math.round(ctcWitoutVariblePay))));
					t2Run50.setFontFamily("Trebuchet MS");
					t2Run50.setFontSize(10);
					t2Run50.setBold(true);
					row1.getCtRow().removeTc(2);
				}

				if (list.get(i).getCarLease().equalsIgnoreCase("Yes")) {
					XWPFParagraph para17 = document.createParagraph();
					// para17.setAlignment(ParagraphAlignment.LEFT);
					XWPFRun para17Run = para17.createRun();
					para17Run.setText("*Car Hire lease, if applicable, to be submitted as per procedure");
					para17Run.setFontFamily("FreightSans Pro Light");
					para17Run.setFontSize(11);
					para17.setSpacingBefore(5);
					para17.setSpacingAfter(5);

					XWPFParagraph para18 = document.createParagraph();
					// para18.setAlignment(ParagraphAlignment.LEFT);
					XWPFRun para18Run = para18.createRun();
					para18Run.setText("*Figures have been rounded to nearest Rupees");
					para18Run.setFontFamily("FreightSans Pro Light");
					para18Run.setFontSize(11);
					para18.setSpacingBefore(5);
					para18.setSpacingAfter(5);

					CTSectPr sectPr11 = document.getDocument().getBody().addNewSectPr();
					CTPageMar pageMar = sectPr11.addNewPgMar();

					pageMar.setRight(BigInteger.valueOf(1720L));

				} else {

					XWPFParagraph para18 = document.createParagraph();
					// para18.setAlignment(ParagraphAlignment.LEFT);
					XWPFRun para18Run = para18.createRun();
					para18Run.setText("*Figures have been rounded to nearest Rupees");
					para18Run.setFontFamily("FreightSans Pro Light");
					para18Run.setFontSize(11);
					para18.setSpacingBefore(5);
					para18.setSpacingAfter(5);

					CTSectPr sectPr11 = document.getDocument().getBody().addNewSectPr();
					CTPageMar pageMar = sectPr11.addNewPgMar();

					pageMar.setRight(BigInteger.valueOf(1720L));

				}

				CTTblWidth width = table1.getCTTbl().addNewTblPr().addNewTblW();

				width.setType(STTblWidth.DXA);
				width.setW(BigInteger.valueOf(9000));

				FileOutputStream output = new FileOutputStream(file);

				document.write(out);
				output.close();
				// }

			}

		} catch (Exception e) {
		}

	}

	private String Format(String valueOf, Font font) {
		// TODO Auto-generated method stub
		return null;
	}

//	  @RequestMapping(value="/getSinglePdf",method=RequestMethod.GET)
//		public @ResponseBody void getEmployeePDF1(HttpServletRequest request, HttpServletResponse response)
//		{
//	      String fileName=UUID.randomUUID().toString();
//	      
//	      
//	      Integer spacingbefore=5;
//	      Integer spacingAfter=5;
//	      
//	      List<PDFDocuments> pfDocuments=new ArrayList<PDFDocuments>();
//			
//			try {
//			//Getting list of employee to generate pdf documents.
//			EmployeeBasicDetails list = employeeService.singlePdf(830);
//				
//			
//			//Set content type to application / pdf
//	        //browser will open the document only if this is set
//	        response.setContentType("application/pdf");
//	        //Get the output stream for writing PDF object        
//	        OutputStream out=response.getOutputStream();
//	        try {
//	        	 String FILE = CtoolConstanats.folder_base+fileName+".pdf";
//	        	
//	            Document doc = new Document();
//	            BaseFont base = BaseFont.createFont(CtoolConstanats.folder_base+"trebuchet-ms/trebuc.ttf", BaseFont.WINANSI, true);
//	            Font font = new Font(base, 10f, Font.NORMAL);
//	             Font font9_5 = new Font(base, 9.5f, Font.NORMAL);
//	             Font fontUnderline = new Font(base, 11f, Font.UNDERLINE);
//	             Font tabletext = new Font(base, 10f, Font.NORMAL);
//	       
//	            Font fontBold = FontFactory.getFont("Times-Roman", 10, Font.BOLD);
//	           Font trebucfontBols = new Font(base, 10f, Font.BOLD);
//	          
//	            Date date = new Date();
//	    		String dateName = CommonUtils.formatDate(date,"MMMM dd, yyyy");
//	    		
//	            /* Basic PDF Creation inside servlet */
//	    		
//	            PdfWriter.getInstance(doc, out);
//	            PdfWriter.getInstance(doc, new FileOutputStream(FILE));   
//	            doc.open();
//	         
//	           
//
//            	
//            	
//	            SpvsDetailsEntity spvsDetailsEntity=SpvsRepository.spvsDetails(list.getSpvsId());
//	            IncrementLetterDetails incrementLetterDetails=incrementvariablerepositiory.getIncrementLetterDetails(list.getIncrementLetterDetailsId());
//	            	
//	            	   String imageName1 = CtoolConstanats.folder_base+"logo.jpg";
//	                   Image image1 = Image.getInstance(imageName1 );
//	                   String imageName2 = CtoolConstanats.folder_base+spvsDetailsEntity.getHeaderImage();
//	                   Image image2 = Image.getInstance(imageName2);
//	                   String imageName3 = CtoolConstanats.folder_base+spvsDetailsEntity.getFooterImage();
//	                   Image image3 = Image.getInstance(imageName3);
//	            	PDFDocuments pdfDocuments=new PDFDocuments();
//	            	pdfDocuments.setEmpName(list.getEmpName());
//	            	pdfDocuments.setEmpCode(list.getEmpCode());
//	            	pdfDocuments.setCreatedOn(new Date());
//	            	pdfDocuments.setName(fileName+".pdf");
//	            	pdfDocuments.setStatus(CtoolConstanats.STATUS_ACTIVE);
//	            	pfDocuments.add(pdfDocuments);
//	            	
//	            // Creating image by file name
//	            image1 = Image.getInstance(imageName1);
//	            image1.scaleToFit(100f, 200f);
//	            image1.setAlignment(Element.ALIGN_RIGHT);
//	            doc.add(image1);
//	             
//	            PdfPTable table1 = new PdfPTable(1);
//	            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            for(int aw=0;aw<1 ; aw++){
//	            	
//	            	PdfPCell cell1 = new PdfPCell(new Phrase("Date: "+dateName,font));
//	            	PdfPCell cell2 = new PdfPCell(new Phrase("Document No: "+list.getDocumentNo(),font));
//	            	PdfPCell cell3 = new PdfPCell(new Phrase(""));
//	            	PdfPCell cell4 = new PdfPCell(new Phrase(""));
//	            	PdfPCell cell5 = new PdfPCell(new Phrase("Mr. "+list.getEmpName(),trebucfontBols));
//	            	PdfPCell cell6 = new PdfPCell(new Phrase("Emp Code:"+list.getEmpCode(),trebucfontBols));
//	                cell1.setBorder(PdfPCell.NO_BORDER); 
//	                cell2.setBorder(PdfPCell.NO_BORDER); 
//	                cell1.setPaddingLeft(0f);
//	                cell2.setPaddingLeft(0f);
//	                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                cell3.setBorder(PdfPCell.NO_BORDER); 
//	                cell4.setBorder(PdfPCell.NO_BORDER); 
//	                cell3.setPaddingLeft(0f);
//	                cell4.setPaddingLeft(0f);
//	                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                cell5.setBorder(PdfPCell.NO_BORDER); 
//	                cell6.setBorder(PdfPCell.NO_BORDER); 
//	                cell5.setPaddingLeft(0f);
//	                cell6.setPaddingLeft(0f);
//	                cell5.setPaddingTop(20);
//	                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                table1.addCell(cell1);
//	                table1.addCell(cell2);
//	                table1.addCell(cell3);
//	                table1.addCell(cell4);
//	                table1.addCell(cell5);
//	                table1.addCell(cell6);
//	 		    }
//	 		    doc.add(table1);
//	 		    String para = incrementLetterDetails.getTitle();
//		  
//		   		Paragraph paragraph=new Paragraph(para, fontUnderline);
//		   		paragraph.setAlignment(Element.ALIGN_CENTER);
//		   		paragraph.setSpacingBefore(10);
//		   		paragraph.setSpacingAfter(10);
//		   		
//		   		doc.add(paragraph);
//	 
//		   		PdfPTable table2 = new PdfPTable(1);
//		   		table2.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            for(int aw=0;aw<1 ; aw++){
//	            	
//	               String[] splitStr = list.getEmpName().split("\\s+");
//	            	
//	            
//	            	PdfPCell cell1 = new PdfPCell(new Phrase("Dear "+splitStr[0],font));
//	                cell1.setBorder(PdfPCell.NO_BORDER); 
//	                cell1.setPaddingLeft(0f);
//	                cell1.setNoWrap(false);
//	                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                table2.addCell(cell1);
//	 		    }
//	 		    doc.add(table2);
////	 		    String mainPara1 = "As a Company, we accomplished our target for the year 2017-2018 leaving a small percentage to be commissioned." + 
////	 		    		"Together we can achieve better overcoming the odds that we face in business. We need to continuously synergise " + 
////	 		    		"and collaborate to achieve Organisational goals.";
//	 		    
//	 		    
//		   		Paragraph para1 = new Paragraph(incrementLetterDetails.getParagraph6(),font);
//		   		para1.setSpacingBefore(10);
//		   		para1.setSpacingAfter(5);
//		   		para1.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para1);
////		   		String mainPara2 = "Based on your Self assessment and your Superior’s assessment of your performance for the year 2017-2018, we " + 
////		   				"revise your CTC as per the following:";
//		   		
//		   		
//		   		Paragraph para2 = null;
//		   		String p2=incrementLetterDetails.getParagraph7();
//		   		if(list.getIncrementLetterDetailsId()==2)
//		   				{
//		   			
//		   			String designation=list.getNewDesignation();
//		   			String p21=p2.replace("~~designation~~",designation);
//		   			para2=new Paragraph(p21,font);
//		   				}
//		   		else
//		   		{
//		   			para2=new Paragraph(p2, font);
//		   		}
//		   		para2.setSpacingBefore(5);
//		   		para2.setSpacingAfter(5);
//		   		para2.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para2);
////		   		String mainPara3 = "1. Your new Fixed Annual CTC for the year "+list.getAssessmentYear()+" has been revised to Rs."+list.getNewCTCYear()+"/-. Detailed CTC break up will " + 
////		   				"be as per the enclosed Annexure-A. This revised CTC will be effective from April 01, 2018.";
//		   		
//		   		String para3_1=incrementLetterDetails.getParagraph1().replace("~~year~~", list.getAssessmentYear());
//		   		String mainPara3=para3_1.replace("~~revisedsalary~~", list.getNewCTCYear()+"/-");
//		   		Paragraph para3 = new Paragraph("1. "+mainPara3,font);
//		   		para3.setSpacingBefore(5);
//		   		para3.setSpacingAfter(5);
//		   		para3.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para3);
////		   		String mainPara4 = "2. Your Incentive for the year 2017-2018 based on Solar Rooftop performance and your performance is Rs………/- " + 
////		   				"which will be disbursed to you in this month itself. Same will be subject to taxation as per Government rules.";
//		   		
//		   		String mainPara4=incrementLetterDetails.getParagraph2().replace("~~performancesalary~~", list.getVariablePay());
//		   		Paragraph para4 = new Paragraph("2. "+mainPara4,font);
//		   		para4.setSpacingBefore(5);
//		   		para4.setSpacingAfter(5);
//		   		para4.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para4);
//		   		
//		   		Paragraph para5 = new Paragraph("3. "+incrementLetterDetails.getParagraph3(),font);
//		   		para5.setSpacingBefore(5);
//		   		para5.setSpacingAfter(5);
//		   		para5.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para5);
//		   		
//		   		Paragraph para6 = new Paragraph("4. "+incrementLetterDetails.getParagraph4(),font);
//		   		para6.setSpacingBefore(5);
//		   		para6.setSpacingAfter(5);
//		   		para6.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para6);
//		   		Paragraph para7 = new Paragraph("5. "+incrementLetterDetails.getParagraph5(),font);
//		   		para7.setSpacingBefore(5);
//		   		para7.setSpacingAfter(5);
//		   		para7.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para7);
//		   		String mainPara8 = "Kindly acknowledge receipt of this letter by returning signed duplicate copy to HR.";
//		   		Paragraph para8 = new Paragraph(mainPara8,font);
//		   		para8.setSpacingBefore(10);
//		   		para8.setSpacingAfter(10);
//		   		para8.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para8);
//		   		String mainPara9 = "With best regards,";
//		   		Paragraph para9 = new Paragraph(mainPara9,font);
//		   		para9.setSpacingBefore(10);
//		   		para9.setSpacingAfter(2);
//		   		para9.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para9);
//		   		String mainPara10 = "For and on behalf of "+spvsDetailsEntity.getSpvsEntitiy().getCompanyName();
//		   		Paragraph para10 = new Paragraph(mainPara10,font);
//		   		para10.setSpacingAfter(10);
//		   		para10.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para10);
//		   		String mainPara11 = spvsDetailsEntity.getSpvsEntitiy().getDirector();
//		   		Paragraph para11 = new Paragraph(mainPara11,font);
//		   		para11.setSpacingAfter(1);
//		   		para11.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para11);
//		   		String mainPara12 = "Director";
//		   		Paragraph para12 = new Paragraph(mainPara12,font);
//		   		para12.setSpacingAfter(15);
//		   		para12.setAlignment(Element.ALIGN_JUSTIFIED);
//		   		doc.add(para12);
//		   		
//				image2 = Image.getInstance(imageName2);
//				image2.scaleToFit(350f, 350f);
//				
//				image2.setAlignment(Element.ALIGN_LEFT);
//				image2.setAbsolutePosition(40, 10);
//				image2.setSpacingBefore(1000);
//				doc.add(image2);
//				
//				
//				doc.newPage();
//				image3 = Image.getInstance(imageName1);
//				image3.scaleToFit(100f, 100f);
//				image3.setAlignment(Element.ALIGN_RIGHT);
//				doc.add(image3);
//				
//				String mainPara13 = "Annexure – A";
//		   		Paragraph para13 = new Paragraph(mainPara13,font);
//		   		para13.setSpacingAfter(10);
//		   		doc.add(para13);
//				 
//				
//		   		PdfPTable table3 = new PdfPTable(2);
//		   		
//	            	PdfPCell cell1 = new PdfPCell(new Phrase("Name:",trebucfontBols));
//	            	cell1.setPadding(2);
//	            	
//	            	
//	            	PdfPCell cell2 = new PdfPCell(new Phrase(list.getEmpName(),font));
//	            	cell2.setPadding(2);
//	            	PdfPCell cell3 = new PdfPCell(new Phrase("Employee Code:",trebucfontBols));
//	            	cell3.setPadding(2);
//	            	PdfPCell cell4 = new PdfPCell(new Phrase(list.getEmpCode(),font));
//	            	cell4.setPadding(2);
//	            	PdfPCell cell5 = new PdfPCell(new Phrase("Designation: ",trebucfontBols));
//	            	cell5.setPadding(2);
//	            	PdfPCell cell6 = new PdfPCell(new Phrase(list.getDesignation(),font));
//	            	
//	                cell1.setPaddingLeft(0f);
//	                cell1.setNoWrap(false);
//	                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                
//	                cell6.setPaddingLeft(0f);
//	                cell6.setNoWrap(false);
//	                cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                
//	                cell2.setPaddingLeft(0f);
//	                cell2.setNoWrap(false);
//	                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                
//	                cell3.setPaddingLeft(0f);
//	                cell3.setNoWrap(false);
//	                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                
//	                cell4.setPaddingLeft(0f);
//	                cell4.setNoWrap(false);
//	                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                
//	                cell5.setPaddingLeft(0f);
//	                cell5.setNoWrap(false);
//	                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
//	                
//	                table3.addCell(cell1);
//	                table3.addCell(cell2);
//	                table3.addCell(cell3);
//	                table3.addCell(cell4);
//	                table3.addCell(cell5);
//	                table3.addCell(cell6);
//	                table3.setHeaderRows(10);
//	 		        doc.add(table3);
//				
//	 		  
//	 		    
//	 		    String para14 = "CTC BREAK-UP";
//		   		Paragraph para15 = new Paragraph(para14,fontUnderline);
//		   		para15.setAlignment(Element.ALIGN_CENTER);
//		   		para15.setSpacingBefore(10);
//		   		para15.setSpacingAfter(10);
//		   		
//		   		float table4Width[]= {60,20,20};
//		   		PdfPTable table4 = new PdfPTable(table4Width);
//		   		table4.setWidthPercentage(70);
//	        	PdfPCell cell7 = new PdfPCell(new Phrase("SALARY COMPONENTS",tabletext));
//	        	PdfPCell cell8 = new PdfPCell(new Phrase("MONTHLY",tabletext));
//	        	PdfPCell cell9 = new PdfPCell(new Phrase("ANNUAL",tabletext));
//	        	PdfPCell cell10 = new PdfPCell(new Phrase("INR",tabletext));
//	        	PdfPCell cell11= new PdfPCell(new Phrase("A.                         BASE SALARY",tabletext));
//	        	PdfPCell cell12 = new PdfPCell(new Phrase("Basic",tabletext));
//	        	PdfPCell cell13 = new PdfPCell(new Phrase(list.getBasicSalary(),font9_5));
//	        	cell13.setPaddingRight(5f);
//	        	PdfPCell cell14 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getBasicSalary())*12),font9_5));
//	        	cell14.setPaddingRight(5f);
//	        	PdfPCell cell15 = new PdfPCell(new Phrase("HR",tabletext));
//	        	PdfPCell cell16 = new PdfPCell(new Phrase(list.getHr(),font9_5));
//	        	cell16.setPaddingRight(5f);
//	        	PdfPCell cell17 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getHr())*12),font9_5));
//	        	cell17.setPaddingRight(5f);
////	        	PdfPCell cell18 = new PdfPCell(new Phrase("Transport Allowance",fontnumber));
////	        	PdfPCell cell19 = new PdfPCell(new Phrase(list.getTransportAllowance(),fontnumber));
////	        	PdfPCell cell20 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getTransportAllowance())*12),fontnumber));
////	        	
//	        	PdfPCell cell21 = new PdfPCell(new Phrase("Special Allowance",tabletext));
//	        	PdfPCell cell22 = new PdfPCell(new Phrase(list.getSpecialAllowance(),font9_5));
//	        	cell22.setPaddingRight(5f);
//	        	PdfPCell cell23 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getSpecialAllowance())*12),font9_5));
//	        	cell23.setPaddingRight(5f);
//	        	PdfPCell cell24 = new PdfPCell(new Phrase("Supplementary Allowance",tabletext));
//	        	PdfPCell cell25 = new PdfPCell(new Phrase(list.getSupplementaryAllowance(),font9_5));
//	        	cell25.setPaddingRight(5f);
//	        	PdfPCell cell26 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getSupplementaryAllowance())*12),font9_5));
//	        	cell26.setPaddingRight(5f);
//	        	
//	        	PdfPCell cell27 = new PdfPCell(new Phrase("Children Education Allowance",tabletext));
//	        	PdfPCell cell28 = new PdfPCell(new Phrase(list.getChildrenEducationAllowance(),font9_5));
//	        	cell28.setPaddingRight(5f);
//	        	PdfPCell cell29 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getChildrenEducationAllowance())*12),font9_5));
//	        	cell29.setPaddingRight(5f);
//	        	PdfPCell cell30=null;
//	        	
//	        	if(list.getDepartment().equalsIgnoreCase("Solar Rooftop"))
//	        	{
//	        		 cell30 = new PdfPCell(new Phrase("Sales incentive pay ",tabletext));
//	        		
//	        	}
//	        	else
//	        	{
//	        		cell30 = new PdfPCell(new Phrase("PF (Company's share)",tabletext));
//	        	}
//	        	
//	        	
//	        	
//	        
//	        	PdfPCell cell31 = new PdfPCell(new Phrase(list.getPf(),font9_5));
//	        	cell31.setPaddingRight(5f);
//	        	PdfPCell cell32 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getPf())*12),font9_5));
//	        	cell32.setPaddingRight(5f);
//	        	Float totalAmountMonth = Float.valueOf(list.getBasicSalary()) + Float.valueOf(list.getHr()) +         			            + Float.valueOf(list.getSpecialAllowance()) + Float.valueOf(list.getSupplementaryAllowance()) + Float.valueOf(list.getChildrenEducationAllowance())
//	        			            + Float.valueOf(list.getPf());
//	        	
//	        	Float totalAmountYear = (Float.valueOf(list.getBasicSalary()) *12) + (Float.valueOf(list.getHr())*12) + 
//	            + (Float.valueOf(list.getSpecialAllowance())*12) + (Float.valueOf(list.getSupplementaryAllowance())*12) + (Float.valueOf(list.getChildrenEducationAllowance())*12)
//	            + (Float.valueOf(list.getPf())*12);
//	        	
//	        	PdfPCell cell33 = new PdfPCell(new Phrase("TOTAL",tabletext));
//	        	PdfPCell cell34 = new PdfPCell(new Phrase(String.valueOf(totalAmountMonth),font9_5));
//	        	cell34.setPaddingRight(5f);
//	        	PdfPCell cell35 = new PdfPCell(new Phrase(String.valueOf(totalAmountYear),font9_5));
//	        	cell35.setPaddingRight(5f);
//	        	PdfPCell cell36= new PdfPCell(new Phrase("B.                         REIMBURSABLE (bills to be submitted as instructed)",tabletext));
//	        	
////	        	PdfPCell cell37 = new PdfPCell(new Phrase("Medical",tabletext));
////	        	PdfPCell cell38 = new PdfPCell(new Phrase(list.getMedical(),font9_5));
////	        	cell38.setPaddingRight(5f);
////	        	PdfPCell cell39 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getMedical())*12),font9_5));
////	        	cell39.setPaddingRight(5f);
//	        	PdfPCell cell40 = new PdfPCell(new Phrase("Residential Telephone",tabletext));
//	        	PdfPCell cell41 = new PdfPCell(new Phrase(list.getResidentTelephone(),font9_5));
//	        	cell41.setPaddingRight(5f);
//	        	PdfPCell cell42 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getResidentTelephone())*12),font9_5));
//	        	cell42.setPaddingRight(5f);
//	        	
//	        	PdfPCell cell43 = new PdfPCell(new Phrase("Attire",tabletext));
//	        	PdfPCell cell44 = new PdfPCell(new Phrase(list.getAttire(),font9_5));
//	        	cell44.setPaddingRight(5f);
//	        	PdfPCell cell45 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getAttire())*12),font9_5));
//	        	cell45.setPaddingRight(5f);
//	        	
////	        	Float sectionBExtraMonth = 
////	        			Float.valueOf(list.getNewspaper()) + Float.valueOf(list.getCarLease())+ Float.valueOf(list.getDriver()) + Float.valueOf(list.getPetrol());
////	        	
//	        	Float sectionBExtraMonth = 
//	        			Float.valueOf(list.getNewspaper());
//	        	
////	        	Float sectionBExtraYear = 
////	        			(Float.valueOf(list.getNewspaper())*12) + (Float.valueOf(list.getCarLease())*12) + (Float.valueOf(list.getDriver())*12) + (Float.valueOf(list.getPetrol())*12);
////	        	
//	        	
//	        	Float sectionBExtraYear = 
//	        			(Float.valueOf(list.getNewspaper())*12);
//	        	
//	        	
//	        	PdfPCell cell46 = new PdfPCell(new Phrase("Newspaper, Books and periodicals",tabletext));
//	        	PdfPCell cell47 = new PdfPCell(new Phrase(String.valueOf(sectionBExtraMonth),font9_5));
//	        	cell47.setPaddingRight(5f);
//	        	PdfPCell cell48 = new PdfPCell(new Phrase(String.valueOf(sectionBExtraYear),font9_5));
//	        	cell48.setPaddingRight(5f);
//	        	
//	        	
//	        	PdfPCell cell49= new PdfPCell(new Phrase("C.                         TAXABLE COMPONENT (reimbursable as per law))",tabletext));
//	        	
//	        	PdfPCell cell50 = new PdfPCell(new Phrase("LTA (1 basic)",tabletext));
//	        	PdfPCell cell51 = new PdfPCell(new Phrase(list.getLta(),font9_5));
//	        	cell51.setPaddingRight(5f);
//	        	
//	        	
//	        	
//	        	
//	        	
//	        	
//	        	
//	        	PdfPCell cell52 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getLta())*12),font9_5));
//	        	cell52.setPaddingRight(5f);
//	        	PdfPCell cell53= new PdfPCell(new Phrase("D.                         ELIGIBILITY AS PER COMPANY POLICY))",tabletext));
//	        	PdfPCell cell54 = new PdfPCell(new Phrase("Gratuity",tabletext));
//	        	PdfPCell cell55 = new PdfPCell(new Phrase(list.getGratuity(),font9_5));
//	        	cell55.setPaddingRight(5f);
//	        	PdfPCell cell56 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getGratuity())*12),font9_5));
//	        	cell56.setPaddingRight(5f);
//	        	
//	        	
//	        	
//	        	PdfPCell carLeaseCell=new PdfPCell(new Phrase("E.           Car Lease with the Third Party purely for official purposes",tabletext));
//	        	
//	        	carLeaseCell.setNoWrap(false);
//	        	carLeaseCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//	        	carLeaseCell.setColspan(3);
//	            
//	        	PdfPCell carLeaseCell1 = new PdfPCell(new Phrase("Payment towards Car Lease",tabletext));
//	        	
//	        	carLeaseCell1.setNoWrap(false);
//	        	carLeaseCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//	        	
//	        	
//	        	PdfPCell carLeaseCell2 = new PdfPCell(new Phrase(String.valueOf(list.getCarLeaseAmount()),font9_5));
//	        	carLeaseCell2.setPaddingRight(5f);
//	        	
//	        	carLeaseCell2.setNoWrap(false);
//	        	carLeaseCell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	        	
//	        	
//	        	PdfPCell carLeaseCell3 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getCarLeaseAmount())*12),font9_5));
//	        	carLeaseCell3.setPaddingRight(5f);
//	        	carLeaseCell3.setNoWrap(false);
//	        	carLeaseCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	        	
//	        	
//	        	
//	        
//	        	
//	        	Float fixedCTCYear =  totalAmountYear  + (Float.valueOf(list.getResidentTelephone())*12) + (Float.valueOf(list.getAttire())*12) +
//	        			sectionBExtraYear + (Float.valueOf(list.getLta())*12) + (Float.valueOf(list.getGratuity())*12);
//	        	
//	        //	Float totalCTCYear = fixedCTCYear + Float.valueOf(list.getVariablePay());
//	        	
//	        	Float totalCTCYear = Float.valueOf(list.getNewFixedSalaryPerYear()) + Float.valueOf(list.getNewVariablePerYear());
//	        	Float ctcWitoutVariblePay = Float.valueOf(list.getNewFixedSalaryPerYear());
//	        	Float fixedCTCMonth=null;
//	           String fixedCtc=null;
//	        	if(list.getCarLease().equalsIgnoreCase("Yes"))
//	        	{
//	        		fixedCtc="FIXED CTC (A+B+C+D+E)";
////	        	 fixedCTCMonth =  totalAmountMonth + Float.valueOf(list.getResidentTelephone()) + Float.valueOf(list.getAttire()) +
////	            			sectionBExtraMonth + Float.valueOf(list.getLta()) + Float.valueOf(list.getGratuity());
////	        	 fixedCTCMonth=fixedCTCMonth + list.getCarLeaseAmount();
////	        	 System.out.println("fixedCTCMonth" +list.getCarLeaseAmount());
//	        	 fixedCTCMonth=Float.valueOf(list.getNewFixedSalaryPerMonth());
//	        	}
//	        	else
//	        	{
//	        		fixedCtc="FIXED CTC (A+B+C+D)";
////	        		 fixedCTCMonth =  totalAmountMonth + Float.valueOf(list.getResidentTelephone()) + Float.valueOf(list.getAttire()) +
////	            			sectionBExtraMonth + Float.valueOf(list.getLta()) + Float.valueOf(list.getGratuity());
////	        		 fixedCTCMonth=fixedCTCMonth-list.getCarLeaseAmount();
//	        		fixedCTCMonth=Float.valueOf(list.getNewFixedSalaryPerMonth());
//	        		
//	        	}
//	        	
//	        	
//	        	
//	        	PdfPCell cell57 = new PdfPCell(new Phrase(fixedCtc,tabletext));
//	        	PdfPCell cell58 = new PdfPCell(new Phrase(String.valueOf(fixedCTCMonth),font9_5));
//	        	cell58.setPaddingRight(5f);
//	     //   	PdfPCell cell59 = new PdfPCell(new Phrase(String.valueOf(fixedCTCYear),font9_5));
//	        	PdfPCell cell59 = new PdfPCell(new Phrase(String.valueOf(Float.valueOf(list.getNewFixedSalaryPerYear())),font9_5));
//	        	cell59.setPaddingRight(5f);
//	        	PdfPCell cell60=null;
//	        	String variabletext="";
//	        		if(list.getVariableTypeId()==2)
//	        	{
//	        		
//	        		 variabletext="Sales incentive pay";
//	        	}
//	        	else if(list.getVariableTypeId()==1)
//	        	{
//	        		 variabletext="Variable Pay";
//	        	}
//	        	else 
//	        	{
//	        		
//	        	}
//	        		PdfPCell cell63=null;
//	        
//	        		if(list.getVariableTypeId()!=3)
//	        		{
//	        			 cell60 = new PdfPCell(new Phrase(variabletext+"\n \n (Onetime payment to be disbursed as per Company Policy)",tabletext));
//	        	//		 cell63=new PdfPCell(new Phrase(String.valueOf(totalCTCYear),font9_5));
//	        			 cell63=new PdfPCell(new Phrase(String.valueOf(totalCTCYear),font9_5));
//	        			 cell63.setPaddingRight(5f);		
//	        		}
//	        		else
//	        		{
//	        			 cell60 = new PdfPCell(new Phrase("No Incentive Avialable",tabletext));
//	        			 cell63=new PdfPCell(new Phrase(String.valueOf(ctcWitoutVariblePay),font9_5));
//	             		cell63.setPaddingRight(5f);
//	        	        	
//	        		}
//	        		String newVariablePerYear=null;;
//	        		if(list.getVariableTypeId()!=3)
//	        		{
//	        			newVariablePerYear=list.getNewVariablePerYear();
//	        		}
//	        		else
//	        		{
//	        			newVariablePerYear="0";
//	        		}
//	        		
//	           PdfPCell cell61 = new PdfPCell(new Phrase(newVariablePerYear,font9_5));
//	           cell61.setPaddingRight(5f);
//	        	PdfPCell cell62 = new PdfPCell(new Phrase("TOTAL CTC in INR (FIXED CTC + "+variabletext+" )",tabletext));
//	        	
//	        	
//	        	
//	        	
//	        	cell7.setRowspan(2);
//	            cell7.setNoWrap(false);
//	            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
//	           
//	            cell8.setNoWrap(false);
//	            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            
//	            cell9.setNoWrap(false);
//	            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            
//	            cell10.setNoWrap(false);
//	            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
//	            
//	            cell11.setNoWrap(false);
//	            cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell11.setColspan(3);
//	            
//	            cell12.setNoWrap(false);
//	            cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell13.setNoWrap(false);
//	            cell13.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell14.setNoWrap(false);
//	            cell14.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell15.setNoWrap(false);
//	            cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell16.setNoWrap(false);
//	            cell16.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell17.setNoWrap(false);
//	            cell17.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
////	            cell18.setNoWrap(false);
////	            cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
////	            cell19.setNoWrap(false);
////	            cell19.setHorizontalAlignment(Element.ALIGN_LEFT);
////	            cell20.setNoWrap(false);
////	            cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
////	            
//	            cell21.setNoWrap(false);
//	            cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell22.setNoWrap(false);
//	            cell22.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell23.setNoWrap(false);
//	            cell23.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell24.setNoWrap(false);
//	            cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell25.setNoWrap(false);
//	            cell25.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell26.setNoWrap(false);
//	            cell26.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell27.setNoWrap(false);
//	            cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell28.setNoWrap(false);
//	            cell28.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell29.setNoWrap(false);
//	            cell29.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell30.setNoWrap(false);
//	            cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell31.setNoWrap(false);
//	            cell31.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell32.setNoWrap(false);
//	            cell32.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell33.setNoWrap(false);
//	            cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell34.setNoWrap(false);
//	            cell34.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell35.setNoWrap(false);
//	            cell35.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell36.setNoWrap(false);
//	            cell36.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell36.setColspan(3);
//	            
////	            cell37.setNoWrap(false);
////	            cell37.setHorizontalAlignment(Element.ALIGN_LEFT);
////	            cell38.setNoWrap(false);
////	            cell38.setHorizontalAlignment(Element.ALIGN_RIGHT);
////	            cell39.setNoWrap(false);
////	            cell39.setHorizontalAlignment(Element.ALIGN_RIGHT);
////	            
//	            cell40.setNoWrap(false);
//	            cell40.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell41.setNoWrap(false);
//	            cell41.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell42.setNoWrap(false);
//	            cell42.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell43.setNoWrap(false);
//	            cell43.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell44.setNoWrap(false);
//	            cell44.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell45.setNoWrap(false);
//	            cell45.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell46.setNoWrap(false);
//	            cell46.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell47.setNoWrap(false);
//	            cell47.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell48.setNoWrap(false);
//	            cell48.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell49.setNoWrap(false);
//	            cell49.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell49.setColspan(3);
//	            
//	            cell50.setNoWrap(false);
//	            cell50.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell51.setNoWrap(false);
//	            cell51.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell52.setNoWrap(false);
//	            cell52.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell53.setNoWrap(false);
//	            cell53.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell53.setColspan(3);
//	            
//	            cell54.setNoWrap(false);
//	            cell54.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell55.setNoWrap(false);
//	            cell55.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell56.setNoWrap(false);
//	            cell56.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	      
//	            
//	            cell57.setNoWrap(false);
//	            cell57.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell58.setNoWrap(false);
//	            cell58.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell59.setNoWrap(false);
//	            cell59.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            cell60.setNoWrap(false);
//	            cell60.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell60.setColspan(2);
//	            cell61.setNoWrap(false);
//	            cell61.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            cell62.setNoWrap(false);
//	            cell62.setHorizontalAlignment(Element.ALIGN_LEFT);
//	            cell62.setColspan(2);
//	            cell63.setNoWrap(false);
//	            cell63.setHorizontalAlignment(Element.ALIGN_RIGHT);
//	            
//	            table4.addCell(cell7);
//	            table4.addCell(cell8);
//	            table4.addCell(cell9);
//	            table4.addCell(cell10);
//	            table4.addCell(cell10);
//	            table4.addCell(cell11);
//	            table4.addCell(cell12);
//	            table4.addCell(cell13);
//	            table4.addCell(cell14);
//	            
//	            table4.addCell(cell15);
//	            table4.addCell(cell16);
//	            table4.addCell(cell17);
//	         //   table4.addCell(cell18);
//	         //   table4.addCell(cell19);
//	         //   table4.addCell(cell20);
//	            table4.addCell(cell21);
//	            table4.addCell(cell22);
//	            table4.addCell(cell23);
//	            table4.addCell(cell24);
//	            table4.addCell(cell25);
//	            table4.addCell(cell26);
//	            table4.addCell(cell27);
//	            table4.addCell(cell28);
//	            table4.addCell(cell29);
//	            table4.addCell(cell30);
//	            table4.addCell(cell31);
//	            table4.addCell(cell32);
//	            table4.addCell(cell33);
//	            table4.addCell(cell34);
//	            table4.addCell(cell35);
//	            table4.addCell(cell36);
////	            table4.addCell(cell37);
////	            table4.addCell(cell38);
////	            table4.addCell(cell39);
//	            table4.addCell(cell40);
//	            table4.addCell(cell41);
//	            table4.addCell(cell42);
//	            table4.addCell(cell43);
//	            table4.addCell(cell44);
//	            table4.addCell(cell45);
//	            table4.addCell(cell46);
//	            table4.addCell(cell47);
//	            table4.addCell(cell48);
//	            table4.addCell(cell49);
//	            table4.addCell(cell50);
//	            table4.addCell(cell51);
//	            table4.addCell(cell52);
//	            table4.addCell(cell53);
//	            table4.addCell(cell54);
//	            table4.addCell(cell55);
//	            table4.addCell(cell56);
//	            
//	            if(list.getCarLease().equalsIgnoreCase("Yes"))
//	            {
//	            	table4.addCell(carLeaseCell);
//	                table4.addCell(carLeaseCell1);
//	                table4.addCell(carLeaseCell2);
//	                table4.addCell(carLeaseCell3);
//	                	
//	            }
//	            
//	            table4.addCell(cell57);
//	            table4.addCell(cell58);
//	            table4.addCell(cell59);
//	            table4.addCell(cell60);
//	            table4.addCell(cell61);
//	            table4.addCell(cell62);
//	            table4.addCell(cell63);
//	           
//	            
//	            PdfPTable table5 = new PdfPTable(2);
//	            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
//
//	        	PdfPCell cell64 = new PdfPCell(new Phrase("Name :",font));
//	        	PdfPCell cell65 = new PdfPCell(new Phrase(list.getEmpName(),fontBold));
//	        	PdfPCell cell66 = new PdfPCell(new Phrase("Employee Code  :",font));
//	        	PdfPCell cell67 = new PdfPCell(new Phrase(list.getEmpCode(),fontBold));
//	        	PdfPCell cell68 = new PdfPCell(new Phrase("Designation : ",font));
//	        	PdfPCell cell69= new PdfPCell(new Phrase(list.getDesignation(),fontBold));
//	        	table5.setSpacingBefore(10);
//	        	table5.setSpacingAfter(10);
//	        	table5.setWidthPercentage(50);
//	        	table5.addCell(cell64);
//	        	table5.addCell(cell65);
//	        	
//	        	table5.addCell(cell66);
//	        	table5.addCell(cell67);
//	        	table5.addCell(cell68);
//	        	table5.addCell(cell69);
//			    
//	            
//	            String mainPara14 = "*Figures have been rounded to nearest Rupees";
//		   		Paragraph para16 = new Paragraph(mainPara14,tabletext);
//		   		para16.setSpacingAfter(10);
//		   		para16.setIndentationLeft(70);
//	            
//			   	image3 = Image.getInstance(imageName3);
//		        image3.scaleToFit(150f, 400f);
//		        image3.setAbsolutePosition(30, 10);
//		        image3.setSpacingBefore(1000);
//		        image3.setAlignment(Element.ALIGN_LEFT);
//		        doc.add(table5);
//		        
//		    	doc.add(para15);
//			   	
//		    	table4.setWidthPercentage(70);
//		        doc.add(table4);
//		        doc.add(para16);
//		        doc.add(image3);
//		        doc.newPage();
//		       
//		        
//	            
//	            
//	            pfdDocumentsService.savePDFDocuments(pfDocuments); 
//	            
//	    		doc.close();
//	    		
//	    		logger.info("sahi chl rha ha i");
//	        }
//	                catch (DocumentException exc){
//	                	//logs an exception thrown from somewhere
//	                	logger.error("DocumentException", exc);
//	                throw new IOException(exc.getMessage());
//	                }
//	        finally {            
//	            out.close();
//	        }
//			}catch(Exception ex)
//			{
//				logger.error("doGet EXCEEEEEEE------->\"", ex);
//				ex.printStackTrace();
//				System.out.println("doGet EXCEEEEEEE------->"+ex);
//			}
//		
//		}
//			

	@RequestMapping(value = "/variableTypeList", method = RequestMethod.POST)
	public @ResponseBody ResponseObject variableTypeList() throws Exception {
		ResponseObject rsobj = new ResponseObject();
		rsobj = employeeService.getVariableTypeList();
		return rsobj;
	}

}
