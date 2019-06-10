/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.*;
import com.itextpdf.awt.*;
import com.itextpdf.xmp.*;
import com.itextpdf.testutils.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josue
 */
public class GeneratePDF {
    // Fonts definitions (Definición de fuentes).
    
   Document document = new  Document() ;
   PdfWriter writer;
   
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
    private static final String logotipos= "C:/SalaC/images/LOGOS.png";
    private static final String chartsE= "C:/SalaC/images/usomaquinas.jpg";
    private static final String chartsC= "C:/SalaC/images/usoporcarreras.jpg";
    private static final String chartsH= "C:/SalaC/images/usoporhora.jpg";
    /**
     * We create a PDF document with iText using different elements to learn 
     * to use this library.
     * Creamos un documento PDF con iText usando diferentes elementos para aprender 
     * a usar esta librería.
     * @param pdfNewFile  <code>String</code> 
     *      pdf File we are going to write. 
     *      Fichero pdf en el que vamos a escribir. 
     */
    public void createPDF(File pdfNewFile,DefaultTableModel hystab,String MaxE,String MaxC,String MaxH) {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {   
            try {    
               writer.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            
             
                  
            document.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            document.addTitle("Instituto Tecnologoco Superior de Teposcolula");
            document.addSubject("Reporte de Sala de computo)");
            document.addKeywords("ITSTE,sala de computo,maquinas");
            document.addAuthor("josue jose jose");
            
            
            
            // First page
            // Primera página 
            Chunk chunk = new Chunk("Sala de Computo", chapterFont);
            chunk.setBackground(BaseColor.ORANGE);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter1 = new Chapter( 1);
            
               // We add an image (Añadimos una imagen)
            Image image;
            try {
                image = Image.getInstance(logotipos);  
                image.setAbsolutePosition(10, 650);
                chapter1.add(image);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            
            
             Paragraph saltlin = new Paragraph("\n \n \n \n \n  \n", subcategoryFont);
            Paragraph title = new Paragraph(chunk);
             Paragraph par1= new Paragraph("El siguiente tabla muesta los resultados de busqueda correspondientes a un periodo de tiempo predeterminado. ", subcategoryFont);
            Paragraph par2 = new Paragraph(" ", subcategoryFont);
            Paragraph par3 = new Paragraph(" ", subcategoryFont);
        
           
            
            chapter1.add(saltlin );
            chapter1.add(title);
            chapter1.add(par1);
             DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            par2.add(dottedline);
            chapter1.setNumberDepth(0);
            chapter1.add(par2);
             
          
            
           
            // How to use PdfPTable
            // Utilización de PdfPTable
            
            // We use various elements to add title and subtitle
            // Usamos varios elementos para añadir título y subtítulo
            Anchor anchor = new Anchor("Tabla para visualizar uso de equipos", categoryFont);
            anchor.setName("Tabla para visualizar uso de equipos");            
            
            
            
          
            Integer numColumns = hystab.getColumnCount();
            Integer numRows = hystab.getRowCount(); 
            
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns); 
            // Now we fill the PDF table 
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
          
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int column = 0; column < numColumns; column++) {
                columnHeader = new PdfPCell(new Phrase(hystab.getColumnName(column)));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                columnHeader.setBackgroundColor(BaseColor.ORANGE);
                table.addCell(columnHeader);
            }
            table.setHeaderRows(1);
           
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int row = 0; row < numRows; row++) {
                
                for (int column = 0; column < numColumns; column++) {
                    table.addCell(hystab.getValueAt(row, column).toString());
                    
                }
                  
            }
           
            // We add the table (Añadimos la tabla)
            
            par3.add(table);
            chapter1.add(par3);
            
            //_______________________________________________________________________________________________________________//
                                            // ocupamos capitulo 2 para mostrar las graficas
              Chapter chapter2 = new Chapter(1);
            
            
            
            
              Paragraph par4= new Paragraph("Se muestra el uso de los equipos por medio de una Grafica", subcategoryFont);
            
             
      
            chapter2.add(par4);
            chapter2.add(par2);
             // We add an image (Añadimos una imagen)
            Image image2;
            try {
                image2 = Image.getInstance(chartsE);  
                image2.setPaddingTop(100);
                chapter2.add(image2);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            
             Paragraph par5= new Paragraph("Equipo mas utiliado: "+MaxE, subcategoryFont);
             chapter2.add(par5);
             
             
             //____________________________________________________________________________________________________//
             Chapter chapter3 = new Chapter(1);
            
            
            
            
              Paragraph par6= new Paragraph("Se muestra el uso que se da a los equipos por carrera ", subcategoryFont);
            
             
      
            chapter3.add(par6);
            chapter3.add(par2);
             // We add an image (Añadimos una imagen)
            Image image3;
            try {
                image3 = Image.getInstance(chartsC);  
                image3.setPaddingTop(100);
                chapter3.add(image3);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            
             Paragraph par7= new Paragraph("La Carrera que hace uso del centro de computo con mas frecuencia es la "+MaxC, subcategoryFont);
             chapter3.add(par7);
             
             
             
             
                     //____________________________________________________________________________________________________//
             Chapter chapter4 = new Chapter(1);
            
            
            
            
              Paragraph par8= new Paragraph("Se muestra la hora de uso de los equipos", subcategoryFont);
            
             
      
            chapter4.add(par8);
            chapter4.add(par2);
             // We add an image (Añadimos una imagen)
            Image image4;
            try {
                image4 = Image.getInstance(chartsH);  
                image4.setPaddingTop(100);
                chapter4.add(image4);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            
             Paragraph par9= new Paragraph("El centro de computo cuenta con una hora pico a las "+MaxH, subcategoryFont);
             chapter4.add(par9);
             
             
             
             
             
       
             
             
             
             
            // We add the paragraph with the table (Añadimos el elemento con la tabla).
            document.add(chapter1);
            document.add(chapter2);
            document.add(chapter3);
            document.add(chapter4);
          
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado su archivo PDF!");
            JOptionPane.showMessageDialog(null,"Your PDF file has been generated!(¡Se ha generado tu hoja PDF!" );
        } catch (DocumentException documentException) {
            System.out.println("The file does not exist (Se ha producido un error al generar un documento): " + documentException);
        }
    
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
       
    }
}

