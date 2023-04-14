package com.sms.loginapp.models.documents;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sms.loginapp.models.User;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
    public synchronized void printList(List<User> userList, int n) {

        String path = "src/main/resources/static/output/contrato-" + userList.get(n).getName() + ".pdf";

        try {

            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();

            document.add(new Paragraph("Olá mundo! " + userList.get(n).getName()));

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        document.close();

        //chama metodo que compacta os carquivos de uma pasta
        try {
            compactFiles("src/main/resources/static/output", "src/main/resources/static/zipados/contratos.zip");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //chama metodos que apaga todos os arquivos de uma pasta

        //deleteAllFilesInFolder("src/main/resources/static/output");


    }

    @Override
    public synchronized void compactFiles(String pastaOrigem, String arquivoDestino) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(arquivoDestino);
            ZipOutputStream zos = new ZipOutputStream(fos);
            File pasta = new File(pastaOrigem);
            for (File arquivo : pasta.listFiles()) {
                if (arquivo.getName().endsWith(".pdf")) {
                    FileInputStream fis = new FileInputStream(arquivo);
                    ZipEntry entrada = new ZipEntry(arquivo.getName());
                    zos.putNextEntry(entrada);
                    byte[] buffer = new byte[4096];
                    int bytesLidos = 0;
                    while ((bytesLidos = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, bytesLidos);
                    }
                    fis.close();
                    zos.closeEntry();
                }
            }
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized static void deleteAllFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }
}