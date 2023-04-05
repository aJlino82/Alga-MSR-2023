package com.sms.loginapp.controllers;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sms.loginapp.models.User;
import com.sms.loginapp.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    UserService userService;

    @GetMapping("/gerar")
    protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        Document document = new Document();
        Font bold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

        try {
            //cod
            response.setContentType("application/pdf");
            //nome do doc
            response.addHeader("Content-Disposition", "inline; filename=contrato" + "contatos.pdf");
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            document.add(new Paragraph("Lista de usuários"));
            document.add(new Chunk("\n"));//pula linha

            Chunk chunk = new Chunk("O texto deve ser ");
            Chunk chunk1 = new Chunk("negrito nesse ponto ", bold);
            Chunk chunk2 = new Chunk("e a partir daqui, normal.");
            Paragraph p = new Paragraph();
            p.add(chunk);
            p.add(chunk1);
            p.add(chunk2);
            document.add(p);
            document.add(new Chunk("\n"));

            PdfPTable table = new PdfPTable(3);//3 colunas
            PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Email"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
            table.addCell(col1);
            table.addCell(col2);
            table.addCell(col3);

            List<User> list = userService.findAll();

            for (int i = 0; i < list.size(); i++) {
                table.addCell(list.get(i).getName());
                table.addCell(list.get(i).getEmail());
                table.addCell(list.get(i).getPhone());
            }
            document.add(table);

            document.close();
        } catch (Exception e) {
            System.out.println(e);
            document.close();
        }
    }

    @GetMapping("gerar/{id}")
    public void gerarInd(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        Document document = new Document();

        //nome do arquivo **.pdf
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=contrato-" + currentDateTime + ".pdf");

    }

}
