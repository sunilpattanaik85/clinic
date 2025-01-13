package com.clinicexa.clinic.controller;

import com.clinicexa.clinic.dto.DoctorAppointmentDetails;
import com.clinicexa.clinic.entity.DoctorAppointment;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class UserPDFExporter {
    private DoctorAppointmentDetails doctorAppointmentDetails;
    public UserPDFExporter(DoctorAppointmentDetails doctorAppointmentDetails){
        this.doctorAppointmentDetails = doctorAppointmentDetails;
    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Date Of AppointMent", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Patient Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Disease Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Medicine Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Prescription", font));
        table.addCell(cell);
    }
    private void writeTableData(PdfPTable table) {
            table.addCell(doctorAppointmentDetails.getStrDateOfAppointment());
            table.addCell(doctorAppointmentDetails.getPatientName());
            table.addCell(doctorAppointmentDetails.getDiseaseName());
            table.addCell(doctorAppointmentDetails.getMedicineName());
            table.addCell(doctorAppointmentDetails.getPrescription());
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.RED);

        Paragraph p = new Paragraph(doctorAppointmentDetails.getDoctorName(), font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
