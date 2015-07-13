package com.controller.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastructures.models.*;
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

/**
 * Servlet implementation class UsersMasterListGenerator
 */
@WebServlet("/UsersMasterListGenerator")
public class UsersMasterListGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	String stud_no;
	String fname;
	String mname;
	String lname;
	String gen;
	String college_desc;
	String role;
	int recordCount = 0;

		response.setContentType("application/pdf");
        try {
        	HeaderGenerator generate = new HeaderGenerator();
        	Document document = new Document(PageSize.LETTER, 36,36,36,36);
            PdfWriter.getInstance(document, response.getOutputStream());
            
            document.open();
            
            //Fonts
            Font tableDetails = FontFactory.getFont("Arial", 9, Font.NORMAL);
            
            //header
            document.add(generate.getFileGenerationTimestamp());
            
            //heading
            document.add(generate.getHeader());
            document.add(generate.getSubHeader());
            
            Paragraph type = new Paragraph();
            type.add(new Phrase("MEMBERS MASTERLIST", FontFactory.getFont("Arial", 18, Font.BOLD)));
            type.setSpacingAfter(15);
            document.add(type);
            
            
            //TableHeader
            document.add(generate.generateTableHeaderMembersList());
            
            //TableDetails
            PdfPTable registeredMembersList = new PdfPTable(5);
            registeredMembersList.setWidthPercentage(100);
            float[] columnWidths = new float[] {13f, 26f,6.5f, 30.5f, 6f};
            registeredMembersList.setWidths(columnWidths);
            //TableHeader
            PdfPCell student_number = new PdfPCell();
            PdfPCell name = new PdfPCell();
            PdfPCell gender = new PdfPCell();
            PdfPCell college_affiliation = new PdfPCell();
            PdfPCell status = new PdfPCell();
            
            try {
    			Class.forName("com.mysql.jdbc.Driver");
    			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    			DatabaseInfo info = new DatabaseInfo();
    			Connection con = DriverManager.getConnection(info.getDatabasePath(), info.getUsername(), info.getPassword());

    			PreparedStatement ps = con.prepareStatement("SELECT usr.student_number, usr.first_name, usr.middle_name, usr.last_name, usr.gender, col.college_desc, usr.role_id FROM user_info usr, college col WHERE usr.college_no=col.college_id AND usr.role_id<>'S' ORDER BY usr.last_name ASC");
    			PreparedStatement ct = con.prepareStatement("SELECT COUNT(*) AS total FROM user_info usr, college col WHERE usr.college_no=col.college_id AND usr.role_id<>'S' ORDER BY usr.last_name ASC");
    			
    			ResultSet cnt = ct.executeQuery();
    			while(cnt.next()){
    				recordCount = cnt.getInt("total");
    			}
    			
    			if (recordCount > 0) {
    				ResultSet rs = ps.executeQuery();
    				while(rs.next()) {
        				stud_no = rs.getString("student_number");
        				fname = rs.getString("first_name");
        				mname = rs.getString("middle_name");
        				lname = rs.getString("last_name");
        				gen = rs.getString("gender");
        				college_desc = rs.getString("college_desc");
        				role = rs.getString("role_id");
        				
        				student_number = new PdfPCell(new Phrase(stud_no, tableDetails));
        				student_number.setColspan(1);
        	            student_number.setBorder(Rectangle.NO_BORDER);
        				if (!mname.equals(null)) {
        					name = new PdfPCell(new Phrase(lname + ", " + fname + " " + mname, tableDetails));
        				} else {
        					name = new PdfPCell(new Phrase(lname + ", " + fname, tableDetails));
        				}
        				name.setColspan(1);
        	            name.setBorder(Rectangle.NO_BORDER);
        				if (gen.equals("M")) {
        					gender = new PdfPCell(new Phrase("Male", tableDetails));
        				} else {
        					gender = new PdfPCell(new Phrase("Female", tableDetails));
        				}
        				gender.setColspan(1);
        	            gender.setBorder(Rectangle.NO_BORDER);
        	            college_affiliation = new PdfPCell(new Phrase(college_desc, tableDetails));
        	            college_affiliation.setColspan(1);
        	            college_affiliation.setBorder(Rectangle.NO_BORDER);
        	            if (role.equals("L") || role.equals("M")) {
        	            	status = new PdfPCell(new Phrase("Student", tableDetails));
        	            } else if (role.equals("A")) {
        	            	status = new PdfPCell(new Phrase("Alumni", tableDetails));
        	            }
        	            status.setColspan(1);
        	            status.setBorder(Rectangle.NO_BORDER);
        	            
        	            registeredMembersList.addCell(student_number);
        	            registeredMembersList.addCell(name);
        	            registeredMembersList.addCell(gender);
        	            registeredMembersList.addCell(college_affiliation);
        	            registeredMembersList.addCell(status);
        			}
    				document.add(registeredMembersList);
    			}

    		} catch (Exception e) {
    			System.out.println(e);
    		}

            document.add(generate.getRecordCount(recordCount));
            
            document.close();
        } catch (DocumentException de) {
            throw new IOException(de.getMessage());
        }
	}
}
