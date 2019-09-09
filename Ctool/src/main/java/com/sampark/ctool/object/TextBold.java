package com.sampark.ctool.object;

import java.io.IOException;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.element.Text;

public class TextBold {
	
	public static Text textBold(String text, Integer fontSize) throws IOException
	{

		 PdfFont font = PdfFontFactory.createFont("c:/windows/fonts/verdana.ttf", PdfEncodings.IDENTITY_H, true);
			Text bold = new Text(text)
			        .setFont(font)
			        .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.FILL_STROKE)
			        .setStrokeWidth(0.5f)
			        .setStrokeColor(DeviceGray.BLACK).setFontSize(fontSize);
			return bold;
	}

}
