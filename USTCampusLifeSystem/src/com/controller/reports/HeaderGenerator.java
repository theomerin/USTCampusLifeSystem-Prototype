package com.controller.reports;

import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderGenerator {
	public Paragraph getFileGenerationTimestamp() {
		//Fonts
        Font header = FontFactory.getFont("Arial", 9, Font.ITALIC);
        
        //header
        Paragraph headingRight = new Paragraph("File last generated: " + new Date().toString(), header);
        headingRight.setAlignment(Element.ALIGN_RIGHT);
        headingRight.setSpacingAfter(15);
        return headingRight;
	}
	
	public Paragraph getHeader() {
		//Fonts
        Font heading = FontFactory.getFont("Arial", 12, Font.BOLD);
        
        //heading
        Paragraph head = new Paragraph("UST CAMPUS FEAST", heading);
        head.setAlignment(Element.ALIGN_CENTER);
        head.setSpacingAfter(1);
        return head;
	}
	
	public Paragraph getSubHeader() {
		//Fonts
        Font subHeading = FontFactory.getFont("Arial", 10, Font.NORMAL);
        
        //heading
        Phrase subHeadings = new Phrase(6);
        subHeadings.add("Light of Jesus Family\n");
        subHeadings.add("LOJ-Campus Life\n");
        subHeadings.add("University of Santo Tomas");
        Paragraph subHead = new Paragraph(10);
        subHead.setFont(subHeading);
        subHead.add(subHeadings);
        subHead.setAlignment(Element.ALIGN_CENTER);
        subHead.setSpacingAfter(20);
        return subHead;
	}
	
	public PdfPTable generateTableHeaderMembersList() throws DocumentException {
		//Fonts
        Font tableHeader = FontFactory.getFont("Arial", 9.5f, Font.BOLD);
        
        //Table
        PdfPTable registeredMembersList = new PdfPTable(5);
        registeredMembersList.setWidthPercentage(100);
        float[] columnWidths = new float[] {13f, 26f, 6.5f, 30.5f, 6f};
        registeredMembersList.setWidths(columnWidths);
        //TableHeader
        PdfPCell student_number;
        PdfPCell name;
        PdfPCell gender;
        PdfPCell college_affiliation;
        PdfPCell status;
        
        student_number = new PdfPCell(new Phrase("Student Number", tableHeader));
        student_number.setColspan(1);
        student_number.setPadding(2.5f);
        student_number.setBorder(Rectangle.BOTTOM);
        student_number.setUseBorderPadding(true);
        student_number.setBorderWidthBottom(2f);
        student_number.setBorderColorBottom(BaseColor.BLACK);
        name = new PdfPCell(new Phrase("Name", tableHeader));
        name.setColspan(1);
        name.setPadding(2.5f);
        name.setBorder(Rectangle.BOTTOM);
        name.setUseBorderPadding(true);
        name.setBorderWidthBottom(2f);
        name.setBorderColorBottom(BaseColor.BLACK);
        gender = new PdfPCell(new Phrase("Gender", tableHeader));
        gender.setColspan(1);
        gender.setPadding(2.5f);
        gender.setBorder(Rectangle.BOTTOM);
        gender.setUseBorderPadding(true);
        gender.setBorderWidthBottom(2f);
        gender.setBorderColorBottom(BaseColor.BLACK);
        college_affiliation = new PdfPCell(new Phrase("College Affiliation", tableHeader));
        college_affiliation.setColspan(1);
        college_affiliation.setPadding(2.5f);
        college_affiliation.setBorder(Rectangle.BOTTOM);
        college_affiliation.setUseBorderPadding(true);
        college_affiliation.setBorderWidthBottom(2f);
        college_affiliation.setBorderColorBottom(BaseColor.BLACK);
        status = new PdfPCell(new Phrase("Status", tableHeader));
        status.setColspan(1);
        status.setPadding(2.5f);
        status.setBorder(Rectangle.BOTTOM);
        status.setUseBorderPadding(true);
        status.setBorderWidthBottom(2f);
        status.setBorderColorBottom(BaseColor.BLACK);
        
        registeredMembersList.addCell(student_number);
        registeredMembersList.addCell(name);
        registeredMembersList.addCell(gender);
        registeredMembersList.addCell(college_affiliation);
        registeredMembersList.addCell(status);
        
        return registeredMembersList;
	}
	
	public Paragraph getRecordCount(int count) {
		//Fonts
        Font subHeading = FontFactory.getFont("Arial", 10, Font.BOLD);
        
        //heading
        Phrase subHeadings = new Phrase(6);
        
        if (count == 0) {
        	subHeadings.add("No records found in the database");
        } else if (count == 1){
        	subHeadings.add(count + " record found in the database");
        } else {
        	subHeadings.add(count + " records found in the database");
        }
        
        Paragraph subHead = new Paragraph(10);
        subHead.setFont(subHeading);
        subHead.add(subHeadings);
        subHead.setAlignment(Element.ALIGN_CENTER);
        subHead.setSpacingBefore(5);
        subHead.setSpacingAfter(15);
        return subHead;
	}
}
