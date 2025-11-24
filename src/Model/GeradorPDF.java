package Model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeradorPDF {

    public void gerarRelatorioFinanceiro(ObservableList<OrdemDeServico> ordens, String caminhoArquivo) throws Exception {
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(caminhoArquivo));
        documento.open();

        Font fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório Financeiro - Ordens Finalizadas", fonteTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        documento.add(titulo);

        Paragraph data = new Paragraph("Gerado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
        data.setSpacingAfter(20);
        documento.add(data);

        PdfPTable tabela = new PdfPTable(5); // 5 colunas
        tabela.setWidthPercentage(100);
        tabela.setWidths(new float[]{1, 3, 2, 2, 2}); // Largura relativa das colunas

        adicionarCelulaCabecalho(tabela, "ID");
        adicionarCelulaCabecalho(tabela, "Cliente");
        adicionarCelulaCabecalho(tabela, "Veículo");
        adicionarCelulaCabecalho(tabela, "Data Finalização");
        adicionarCelulaCabecalho(tabela, "Valor Total");

        double somaTotal = 0;
        for (OrdemDeServico ordem : ordens) {
            tabela.addCell(ordem.getIdOrdem());
            tabela.addCell(ordem.getClienteNome());
            tabela.addCell(ordem.getVeiculoPlaca());
            tabela.addCell(ordem.getDataFinalizacao());
            tabela.addCell(ordem.getValorTotal());

            // Tentar somar o valor total convertendo de String (R$ ...) para double
            try {
                String v = ordem.getValorTotal().replace("R$", "").replace(".", "").replace(",", ".").trim();
                somaTotal += Double.parseDouble(v);
            } catch (Exception e) {
                // ignora erro de conversão
            }
        }

        documento.add(tabela);

        Paragraph total = new Paragraph("\nFaturamento Total Listado: R$ " + String.format("%,.2f", somaTotal));
        total.setAlignment(Element.ALIGN_RIGHT);
        Font fonteTotal = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.DARK_GRAY);
        total.setFont(fonteTotal);
        documento.add(total);

        documento.close();
    }

    private void adicionarCelulaCabecalho(PdfPTable tabela, String texto) {
        PdfPCell celula = new PdfPCell(new Phrase(texto, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        celula.setHorizontalAlignment(Element.ALIGN_CENTER);
        celula.setBackgroundColor(BaseColor.LIGHT_GRAY);
        celula.setPadding(5);
        tabela.addCell(celula);
    }
}