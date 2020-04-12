/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import com.lowagie.text.*;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import static com.lowagie.text.Font.BOLD;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jesús
 */
public class Factura {
    
    private Font fuenteBold = new Font(Font.TIMES_ROMAN,18,Font.BOLD);
    private Font fuenteItalic = new Font(Font.NORMAL);
    private Font fuenteNormal = new Font(Font.NORMAL);
    
    public void generarPDF(String rutaImagen, String nombreCliente, String direccion, String cedula, String salida, String facturasPendientes,String serviciosAdicionales,String valorMesActual, String totalaPagar){
        try{
            
            Document document=new Document(PageSize.A4, 0,0,0,10);
            PdfWriter.getInstance(document, new FileOutputStream(salida));
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(600, 100);
            document.open();
            Paragraph paragraph=new Paragraph();
            paragraph.add("\n");
            
            
            document.add(imagen);
            document.add(getHeader(nombreCliente,direccion,cedula));
            document.add(getTablasFactActual(valorMesActual,cedula));
            document.add(paragraph);
            document.add(getTablaDisclaimer());
            document.add(paragraph);
            document.add(getTablaEstadoCuenta());
            document.add(paragraph);
            document.add(getTablasServicios(facturasPendientes,serviciosAdicionales,valorMesActual, totalaPagar));
            document.add(paragraph);
            //document.add(getFooter(footer));
            document.close();
            
        }catch(Exception e){
            
        }
                
        
    }
    
    private Paragraph getHeader(String nombreCliente, String direccion, String cedula){
        Date date = new Date(); // This object contains the current date value
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String fechaActual=formatter.format(date);
        String infoCliente="\n\n    cliente  " + nombreCliente + "\n    direccion  " + direccion + "\n    cedula  " + cedula+ "\n    Fecha de expedición "+ fechaActual + "\n    Factura de venta n"+ "\n\n\n\n";
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_LEFT);
        c.append(infoCliente);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }
    
    private Paragraph getFooter(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }
    
    private Paragraph getTablasFactActual(String valorMesActual,String cedula){
        Paragraph paragraph = new Paragraph();
        PdfPCell cell = null;
            //Tabla main
            PdfPTable tablamain=new PdfPTable(2);
            tablamain.setWidthPercentage(80);
            
            //celda 1 tabla main
            PdfPCell tablacell = new PdfPCell();
            tablacell.setBorder(PdfPCell.NO_BORDER);
            
            PdfPTable tabla=new PdfPTable(2);
            cell = new PdfPCell(new Phrase("Factura Mes"));
            cell.setBackgroundColor(Color.green);
            tabla.addCell(cell);
            // Obtienes el mes actual
            Month mes = LocalDate.now().getMonth();

            // Obtienes el nombre del mes
            String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            tabla.addCell(nombreMes);
            
            tablacell.addElement(tabla);
            tablamain.addCell(tablacell);
            
            //segunda celda tabla main
            PdfPCell tabla1cell = new PdfPCell();
            tabla1cell.setBorder(PdfPCell.NO_BORDER);
            
            PdfPTable tabla1=new PdfPTable(2);
            Date date = new Date(); // This object contains the current date value
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            cell = new PdfPCell(new Phrase("Numero para pagos"));
            cell.setBackgroundColor(Color.GREEN);
            tabla1.addCell(cell);
            tabla1.addCell(cedula + formatter.format(date).toString().replace("-", ""));
            
            tabla1cell.addElement(tabla1);
            tablamain.addCell(tabla1cell);
    
            
            //Tercera celda tabla main
            PdfPCell tabla2cell = new PdfPCell();
            tabla2cell.setBorder(PdfPCell.NO_BORDER);
            
            PdfPTable tabla2=new PdfPTable(2);
            cell = new PdfPCell(new Phrase("Fecha Entrega"));
            cell.setBackgroundColor(Color.GREEN);
            tabla2.addCell(cell);
            tabla2.addCell(formatter.format(date));
            
            tabla2cell.addElement(tabla2);
            tablamain.addCell(tabla2cell);
            
            //Cuarta celda tabla main
            PdfPCell tabla3cell = new PdfPCell();
            tabla3cell.setBorder(PdfPCell.NO_BORDER);
            
            PdfPTable tabla3=new PdfPTable(2);
            cell = new PdfPCell(new Phrase("Fecha límite de pago"));
            cell.setBackgroundColor(Color.GREEN);
            tabla3.addCell(cell);
            tabla3.addCell(formatter.format(date));
            
            tabla3cell.addElement(tabla3);
            tablamain.addCell(tabla3cell);
            
            //Quinta celda tabla main
            PdfPCell tabla4cell = new PdfPCell();
            tabla4cell.setBorder(PdfPCell.NO_BORDER);
            
            PdfPTable tabla4=new PdfPTable(2);
            cell = new PdfPCell(new Phrase("Proxima factura"));
            cell.setBackgroundColor(Color.GREEN);
            tabla4.addCell(cell);
            tabla4.addCell(formatter.format(date));
            
            tabla4cell.addElement(tabla4);
            tablamain.addCell(tabla4cell);
            
            //Sexta celda tabla main
            PdfPCell tabla5cell = new PdfPCell();
            tabla5cell.setBorder(PdfPCell.NO_BORDER);
            
            PdfPTable tabla5=new PdfPTable(2);
            cell = new PdfPCell(new Phrase("TOTAL A PAGAR"));
            cell.setBackgroundColor(Color.GREEN);
            tabla5.addCell(cell);
            tabla5.addCell(valorMesActual);
            
            tabla5cell.addElement(tabla5);
            tablamain.addCell(tabla5cell);
            
            tabla.setWidthPercentage(100);
            tabla1.setWidthPercentage(100);
            tabla2.setWidthPercentage(100);
            tabla3.setWidthPercentage(100);
            tabla4.setWidthPercentage(100);
            tabla5.setWidthPercentage(100);
            
            
            paragraph.add(tablamain);
            
            return paragraph;
    }
    
    private Paragraph getTablaEstadoCuenta(){
        String texto="RESUMEN DE TU CUENTA";
        Paragraph paragraph=new Paragraph();
        Paragraph paragraph1=new Paragraph();
        PdfPTable tablamain=new PdfPTable(1);
        
        Chunk c = new Chunk();
        c.append(texto);
        c.setFont(fuenteBold);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        paragraph1.add(c);
        PdfPCell cell = new PdfPCell(new Phrase(paragraph1));
        cell.setBackgroundColor(Color.green);
        tablamain.addCell(cell);
        paragraph.add(tablamain);
        
        return paragraph;
    }
    
    private Paragraph getTablaDisclaimer(){
        String texto="Estimado cliente, pague oportunamente y evite la suspensión del servicio, cobro de reconexión por producto e intereses de mora: El inccumplimiento en los pagos genera reportes a Centrales de Riesgo como moroso. Si ya realizó el pago, haga caso omiso.\n ";
        Paragraph paragraph=new Paragraph();
        PdfPTable tablamain=new PdfPTable(1);
        
        
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        cell.setBackgroundColor(Color.green);
        tablamain.addCell(cell);
        paragraph.add(tablamain);
        
        return paragraph;
    }
    
    private Paragraph getTablasServicios(String facturasPendientes,String serviciosAdicionales,String valorMesActual, String totalaPagar){
        Paragraph paragraph = new Paragraph();
        PdfPCell cell = null;
            //Tabla main
            PdfPTable tablamain=new PdfPTable(2);
            tablamain.setWidthPercentage(80);
            
            PdfPTable tabla=new PdfPTable(2);
            cell = new PdfPCell(new Phrase("Servicio Fijo"));
            cell.setBackgroundColor(Color.gray);
            tablamain.addCell(cell);

            cell = new PdfPCell(new Phrase("Valor"));
            cell.setBackgroundColor(Color.gray);
            tablamain.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Facturas Pendientes"));
            tablamain.addCell(cell);
            tablamain.addCell("$"+ facturasPendientes);
            
            cell = new PdfPCell(new Phrase("Servicios adicionales"));
            tablamain.addCell(cell);
            tablamain.addCell("$"+ serviciosAdicionales);
            
            cell = new PdfPCell(new Phrase("Mes Actual"));
            tablamain.addCell(cell);
            tablamain.addCell("$"+ valorMesActual);
            
            cell = new PdfPCell(new Phrase("TOTAL A PAGAR"));
            cell.setBackgroundColor(Color.gray);
            tablamain.addCell(cell);
            
            cell = new PdfPCell(new Phrase("$"+totalaPagar));
            cell.setBackgroundColor(Color.gray);
            tablamain.addCell(cell);
            
            
            paragraph.add(tablamain);
            
            return paragraph;
    }
    
}
