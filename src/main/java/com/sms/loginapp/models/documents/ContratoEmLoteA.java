package com.sms.loginapp.models.documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sms.loginapp.models.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContratoEmLoteA implements Contrato {

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
    Document document = new Document();

    @Override
    public void setHead() {

    }

    @Override
    public void setBody() {

    }

    @Override
    public void setFoot() {

    }

    @Override
    public void print(String nome) {

    }

    @Override
    public void printList(List<User> userList, int n) {

        String path = "src/main/resources/static/output/contrato-" + userList.get(n).getName() + ".pdf";

        try {

            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();

            document.add(new Paragraph("Olá mundo! " + userList.get(n).getName()));

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        document.close();
    }

}