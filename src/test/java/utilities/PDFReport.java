package utilities;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * JyperionListener
 * 
 * @author janaudy at jyperion dot org
 */
public class PDFReport implements ITestListener {
	private Logger log;
	private Document document = null;
	PdfPTable successTable = null, failTable = null;
	private HashMap<Integer, Throwable> throwableMap = null;
	private int nbExceptions = 0;

	public PDFReport() {
		BasicConfigurator.configure();
		log = Logger.getLogger(PDFReport.class);

		this.document = new Document();
		this.throwableMap = new HashMap<Integer, Throwable>();
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (successTable == null) {
			this.successTable = new PdfPTable(new float[] { .3f, .4f, .1f, .4f, .1f });
			Paragraph p = new Paragraph("PASSED TESTS");
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(5);
			cell.setBackgroundColor(BaseColor.GREEN);
			this.successTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Test Data"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.successTable.addCell(cell);
		}

		String[] className = result.getTestClass().getName().split(Pattern.quote("."));

		PdfPCell cell = new PdfPCell(new Paragraph(className[className.length - 1]));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getName()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis() - result.getStartMillis())));
		this.successTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Paragraph excep = new Paragraph(new Chunk(throwable.toString(),
					new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.UNDERLINE))
							.setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.successTable.addCell(cell);
		} else {
			this.successTable.addCell(new PdfPCell(new Paragraph("")));
		}
		this.successTable.addCell(new PdfPCell(new Paragraph("")));
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (this.failTable == null) {
			this.failTable = new PdfPTable(new float[] { .3f, .4f, .1f, .4f, .1f });
			this.failTable.setTotalWidth(20f);
			Paragraph p = new Paragraph("FAILED TESTS",
					new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(5);
			cell.setBackgroundColor(BaseColor.RED);
			this.failTable.addCell(cell);

			cell = new PdfPCell(new Paragraph("Class"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Method"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Time (ms)"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Exception"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
			cell = new PdfPCell(new Paragraph("Test Data"));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			this.failTable.addCell(cell);
		}

		String[] className = result.getTestClass().getName().split(Pattern.quote("."));

		PdfPCell cell = new PdfPCell(new Paragraph(className[className.length - 1]));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(result.getName()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("" + (result.getEndMillis() - result.getStartMillis())));
		this.failTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Paragraph excep = new Paragraph(new Chunk(throwable.toString(),
					new Font(Font.FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE, Font.UNDERLINE))
							.setLocalGoto("" + throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.failTable.addCell(cell);
		} else {
			this.failTable.addCell(new PdfPCell(new Paragraph("")));
		}
		this.failTable.addCell(new PdfPCell(new Paragraph("")));
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(context.getName() + ".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.document.open();

		Paragraph p = new Paragraph(context.getName() + " TESTNG RESULTS",
				FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));

		try {
			this.document.add(p);
			this.document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {

		try {
			if (this.failTable != null) {

				this.failTable.setSpacingBefore(15f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(15f);
			}

			if (this.successTable != null) {

				this.successTable.setSpacingBefore(15f);
				this.document.add(this.successTable);
				this.successTable.setSpacingBefore(15f);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Paragraph p = new Paragraph("EXCEPTIONS SUMMARY", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
		try {
			this.document.add(p);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		Set<Integer> keys = this.throwableMap.keySet();

		assert keys.size() == this.nbExceptions;

		for (Integer key : keys) {
			Throwable throwable = this.throwableMap.get(key);

			Chunk chunk = new Chunk(throwable.toString(), FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
			chunk.setLocalDestination("" + key);
			Paragraph throwTitlePara = new Paragraph(chunk);
			try {
				this.document.add(throwTitlePara);
			} catch (DocumentException e3) {
				e3.printStackTrace();
			}

			StackTraceElement[] elems = throwable.getStackTrace();
			String exception = "";
			for (StackTraceElement ste : elems) {
				Paragraph throwParagraph = new Paragraph(ste.toString());
				try {
					this.document.add(throwParagraph);
				} catch (DocumentException e2) {
					e2.printStackTrace();
				}
			}
		}

		this.document.close();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
