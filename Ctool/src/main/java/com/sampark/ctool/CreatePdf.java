package com.sampark.ctool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @author mkl
 */
public class CreatePdf
{
    final static File RESULT_FOLDER = new File("D:\\home\\appsrv\\ctool\\TestPdf", "xmlworker");

   
    public static void setUpBeforeClass() throws Exception
    {
        RESULT_FOLDER.mkdirs();
    }

    /**
     * <a href="http://stackoverflow.com/questions/41743574/itextpdf-creates-unvalid-pdf-document">
     * Itextpdf creates unvalid pdf document
     * </a>
     * <p>
     * CasperSlynge.html
     * </p>
     * <p>
     * Works for me. Admittedly, I replaced the {@link ByteArrayInputStream} by a
     * resource {@link InputStream} and the {@link ByteArrayOutputStream} by a
     * {@link FileOutputStream}.
     * </p>
     * <p>
     * I also added a `Charset` but the test created a valid file without, too.
     * </p>
     */
   
    public void testCreatePdfLikeCasperSlynge() throws IOException, DocumentException
    {
        try (   InputStream resource = getClass().getResourceAsStream("test.html");
                FileOutputStream result = new FileOutputStream(new File(RESULT_FOLDER, "CasperSlynge.pdf")))
        {
            // step 1
            Document document = new Document();
            String imageName1 = CtoolConstanats.folder_base+"logo.jpg";
            Image image1 = Image.getInstance(imageName1);
            image1 = Image.getInstance(imageName1);
            image1.scaleToFit(100f, 200f);
            image1.setAlignment(Element.ALIGN_RIGHT);
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, result);
            // step 3
            document.open();
            document.add(image1);
            
            String imageName2 = CtoolConstanats.folder_base+"RSEG.png";
            Image  image2 = Image.getInstance(imageName2);
			image2.scaleToFit(350f, 350f);
			
			image2.setAlignment(Element.ALIGN_LEFT);
			image2.setAbsolutePosition(40, 10);
			image2.setSpacingBefore(1000);
			document.add(image2);
			
            // step 4
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, resource, Charset.forName("UTF8"));
            // step 5
            document.close();
            System.out.println("created");
        }
    }
    
    
    public static void main(String[] args) throws Exception {
		CreatePdf.setUpBeforeClass();
    	CreatePdf createPdf=new CreatePdf();
    	createPdf.testCreatePdfLikeCasperSlynge();
	}
}
