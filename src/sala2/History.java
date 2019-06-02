/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala2;

import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author josue 
 */
public class History extends javax.swing.JFrame {

    private DefaultTableModel hsytab;
    String model[]; 
    

    /**
     * Creates new form History
     */
    public History() {
        initComponents();
 Calendar cal = GregorianCalendar.getInstance();                   
                    Date date =cal.getTime();
                    datefecha.setDate(date);
                    dateA.setDate(date);
                    dateB.setDate(date);
                 
                    
        mostrarlista();
    }

    public void mostrarlista() {
        Query request = new Query();
        Conexion_DB con = new Conexion_DB();
        String SQLQuery = "";
        if (vall.isSelected()) {
            SQLQuery = "SELECT registro.Id,alumno.NumControl, concat( persona.Nombres,' ',persona.Apellidos)as Nombre, registro.Id_Computer,registro.Fecha, registro.Tiempo_Inicio,registro.Tiempo_Fin FROM registro INNER JOIN alumno ON registro.Id_Alumno=alumno.NumControl INNER JOIN persona ON alumno.Id_Persona=persona.Id where registro.Id_Computer like " + getMaquina() + " and registro.Tiempo_Inicio like " + getHour();
        }
        if (vfecha.isSelected()) {
            
           
                    
                    String f;
            f = new SimpleDateFormat("yyyy-MM-dd").format(datefecha.getDate());
            SQLQuery = "SELECT registro.Id,alumno.NumControl, concat( persona.Nombres,' ',persona.Apellidos)as Nombre, registro.Id_Computer,registro.Fecha, registro.Tiempo_Inicio,registro.Tiempo_Fin FROM registro INNER JOIN alumno ON registro.Id_Alumno=alumno.NumControl INNER JOIN persona ON alumno.Id_Persona=persona.Id where registro.Id_Computer like " + getMaquina() + " and registro.Tiempo_Inicio like " + getHour()+ "and registro.Fecha like '" + f + "'";

        }
        if (vmes.isSelected()) {
            SQLQuery = "SELECT registro.Id,alumno.NumControl, concat( persona.Nombres,' ',persona.Apellidos)as Nombre, registro.Id_Computer,registro.Fecha, registro.Tiempo_Inicio,registro.Tiempo_Fin FROM registro INNER JOIN alumno ON registro.Id_Alumno=alumno.NumControl INNER JOIN persona ON alumno.Id_Persona=persona.Id where registro.Id_Computer like " + getMaquina() + " and registro.Tiempo_Inicio like " + getHour()+ "and registro.Fecha like '2019-" + getMes() + "%'";

        }

           
        if (vfechafecha.isSelected()) {
             String f1;
            f1 = new SimpleDateFormat("yyyy-MM-dd").format(dateA.getDate());
             String f2;
            f2 = new SimpleDateFormat("yyyy-MM-dd").format(dateB.getDate());
       SQLQuery = "SELECT registro.Id,alumno.NumControl, concat( persona.Nombres,' ',persona.Apellidos)as Nombre, registro.Id_Computer,registro.Fecha, registro.Tiempo_Inicio,registro.Tiempo_Fin FROM registro INNER JOIN alumno ON registro.Id_Alumno=alumno.NumControl INNER JOIN persona ON alumno.Id_Persona=persona.Id where registro.Id_Computer like " + getMaquina() + " and registro.Tiempo_Inicio like " + getHour()+ "and registro.Fecha >= '" + f1 + "'"+" and registro.Fecha  <='" + f2 + "'"; 
        }

        ResultSet rs = request.executeQuery(SQLQuery, con);
        try {
            String titulos[] = {"Id", "No. control", "Nombre", "Computadora", "Fecha", "Tiem", "Tiempo Finalizado"};
            String datos[] = new String[7];

            hsytab = new DefaultTableModel(null, titulos);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);

                hsytab.addRow(datos);
            }
            historytable.setModel(hsytab);
            return;
        } catch (Exception e) {
        } finally {
            con = null;
        }
    }

    public String getMaquina() {
        String like = " ";
        if (maquinas.getSelectedIndex() == 0) {
            like = "'%'";
        }
        if (maquinas.getSelectedIndex() == 1) {
            like = "'1'";
        }
        if (maquinas.getSelectedIndex() == 2) {
            like = "'2'";
        }
        if (maquinas.getSelectedIndex() == 3) {
            like = "'3'";
        }
        if (maquinas.getSelectedIndex() == 4) {
            like = "'4'";
        }
        if (maquinas.getSelectedIndex() == 5) {
            like = "'5'";
        }
        if (maquinas.getSelectedIndex() == 6) {
            like = "'6'";
        }
        if (maquinas.getSelectedIndex() == 7) {
            like = "'7'";
        }
        if (maquinas.getSelectedIndex() == 8) {
            like = "'8'";
        }
        if (maquinas.getSelectedIndex() == 9) {
            like = "'9'";
        }
        if (maquinas.getSelectedIndex() == 10) {
            like = "'10'";
        }
        if (maquinas.getSelectedIndex() == 11) {
            like = "'11'";
        }
        if (maquinas.getSelectedIndex() == 12) {
            like = "'12'";
        }
        if (maquinas.getSelectedIndex() == 13) {
            like = "'13'";
        }
        if (maquinas.getSelectedIndex() == 14) {
            like = "'14'";
        }
        if (maquinas.getSelectedIndex() == 15) {
            like = "'15'";
        }
        if (maquinas.getSelectedIndex() == 16) {
            like = "'16'";
        }

        return like;
    }

    public String getHour() {
        String like = " ";
        if (hour.getSelectedIndex() == 0) {
            like = "'%'";
        }

        if (hour.getSelectedIndex() == 1) {
            like = "'09%'";
        }
        if (hour.getSelectedIndex() == 2) {
            like = "'10%'";
        }
        if (hour.getSelectedIndex() == 3) {
            like = "'11%'";
        }
        if (hour.getSelectedIndex() == 4) {
            like = "'00%'";
        }
        if (hour.getSelectedIndex() == 5) {
            like = "'01%'";
        }
        if (hour.getSelectedIndex() == 6) {
            like = "'02%'";
        }
        if (hour.getSelectedIndex() == 7) {
            like = "'03%'";
        }
        if (hour.getSelectedIndex() == 8) {
            like = "'04%'";
        }
        if (hour.getSelectedIndex() == 9) {
            like = "'05%'";
        }
        if (hour.getSelectedIndex() == 10) {
            like = "'06%'";
        }
        if (hour.getSelectedIndex() == 11) {
            like = "'07%'";
        }
        if (hour.getSelectedIndex() == 12) {
            like = "'08%'";
        }

        return like;
    }

    public String getMes() {
        String num="";
        if (month.getMonth() == 0) {
            num = "01";
        }if (month.getMonth() == 1) {
            num = "02";
        }if (month.getMonth() == 2) {
            num = "03";
        }if (month.getMonth() == 3) {
            num = "04";
        }if (month.getMonth() == 4) {
            num = "05";
        }if (month.getMonth() == 5) {
            num = "06";
        }if (month.getMonth() == 6) {
            num = "07";
        }if (month.getMonth() == 7) {
            num = "08";
        }if (month.getMonth() == 8) {
            num = "09";
        }if (month.getMonth() == 9) {
            num = "10";
        }if (month.getMonth() == 10) {
            num = "11";
        }if (month.getMonth() == 11) {
            num = "12";
        }
    return num;
    }


/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewDate = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        vall = new javax.swing.JRadioButton();
        hour = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        vfecha = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        historytable = new javax.swing.JTable();
        vmes = new javax.swing.JRadioButton();
        vfechafecha = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maquinas = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        datefecha = new com.toedter.calendar.JDateChooser();
        month = new com.toedter.calendar.JMonthChooser();
        dateA = new com.toedter.calendar.JDateChooser();
        dateB = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jrb_maquina = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        viewDate.add(vall);
        vall.setSelected(true);
        vall.setText("Visualizar desde Inicio");
        vall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vallActionPerformed(evt);
            }
        });

        hour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas  Horas", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", " " }));
        hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourActionPerformed(evt);
            }
        });

        viewDate.add(vfecha);
        vfecha.setText("Visualizar por Fecha:");
        vfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vfechaActionPerformed(evt);
            }
        });

        historytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(historytable);

        viewDate.add(vmes);
        vmes.setText("Visualizar por Mes:");
        vmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmesActionPerformed(evt);
            }
        });

        viewDate.add(vfechafecha);
        vfechafecha.setText("Visualizar entre Fechas:");
        vfechafecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vfechafechaActionPerformed(evt);
            }
        });

        jLabel1.setText("Visualizar por Equipo:");

        jLabel3.setText("Visualizar por Hora:");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        jLabel2.setText("a");

        maquinas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos los Equipos", "Equipo 1", "Equipo 2", "Equipo 3", "Equipo 4", "Equipo 5", "Equipo 6", "Equipo 7", "Equipo 8", "Equipo 9", "Equipo 10", "Equipo 11", "Equipo 12", "Equipo 13", "Equipo 14", "Equipo 15", "Equipo 16" }));
        maquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinasActionPerformed(evt);
            }
        });

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        datefecha.setDateFormatString("yyyy-MM-dd");
        datefecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datefechaPropertyChange(evt);
            }
        });

        month.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthPropertyChange(evt);
            }
        });

        dateA.setDateFormatString("yyyy-MM-dd");
        dateA.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateAPropertyChange(evt);
            }
        });

        dateB.setDateFormatString("yyyy-MM-dd");
        dateB.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateBPropertyChange(evt);
            }
        });

        jLabel4.setText("Graficas:");
        jLabel4.setToolTipText("Mostrar en reporte");

        jrb_maquina.setText("Uso de Maquinas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrb_maquina)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(vall)
                                .addGap(258, 258, 258)
                                .addComponent(vmes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(vfechafecha)
                                .addGap(18, 18, 18)
                                .addComponent(dateA, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateB, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(vfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(datefecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vall)
                        .addComponent(vmes))
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vfecha))
                    .addComponent(datefecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vfechafecha)
                    .addComponent(dateA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dateB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jrb_maquina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vfechaActionPerformed
        mostrarlista();
    }//GEN-LAST:event_vfechaActionPerformed

    private void vfechafechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vfechafechaActionPerformed
        mostrarlista();
    }//GEN-LAST:event_vfechafechaActionPerformed

    private void maquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinasActionPerformed
        mostrarlista();
    }//GEN-LAST:event_maquinasActionPerformed

    private void hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourActionPerformed
        mostrarlista();
    }//GEN-LAST:event_hourActionPerformed

    private void vallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vallActionPerformed
        mostrarlista();
    }//GEN-LAST:event_vallActionPerformed

    private void vmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vmesActionPerformed
        mostrarlista();
    }//GEN-LAST:event_vmesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
         try{
       
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            int[] cant=new int[100]; 
            for(int i=0;i<100;i++){
            cant[i]=0;
            
            }

            for(int i=0;i<hsytab.getRowCount();i++){
            
             cant[Integer.parseInt(hsytab.getValueAt(i, 3).toString())]++;

            }
            
           for(int i=0;i<cant.length;i++){
          
               if(cant[i]!=0)
               {
                   
                   dataset.setValue(cant[i],"Equipo",""+i);
                   
               
               }
            
            }  
           JFreeChart chart = ChartFactory.createBarChart3D("Uso de Equipos en el Centro de Computo", "Equipo",
   "Número de Uso", dataset, PlotOrientation.VERTICAL, true,
   true, false);
           
          ChartUtilities.saveChartAsJPEG(new File("C:/SalaC/images/usomaquinas.jpg"), chart, 500, 300);
           if(jrb_maquina.isSelected()){
          // Creación del panel con el gráfico
ChartPanel panel = new ChartPanel(chart);

JFrame ventana = new JFrame("El grafico");
ventana.getContentPane().add(panel);
ventana.pack();
ventana.setVisible(true);
ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
       
        
        
               
                  GeneratePDF generar = new GeneratePDF();
               JFileChooser jfchooser =new JFileChooser();
              
               
               jfchooser.setDragEnabled(true);
                 jfchooser.approveSelection();
                jfchooser.showSaveDialog(null);
                
               File pdf=jfchooser.getSelectedFile();
               
               
               generar.createPDF( pdf , hsytab);
      
  } catch (Exception e) {
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void datefechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datefechaPropertyChange
          mostrarlista();
    }//GEN-LAST:event_datefechaPropertyChange

    private void monthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthPropertyChange
         mostrarlista();
    }//GEN-LAST:event_monthPropertyChange

    private void dateAPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateAPropertyChange
       mostrarlista();
    }//GEN-LAST:event_dateAPropertyChange

    private void dateBPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateBPropertyChange
        mostrarlista();
    }//GEN-LAST:event_dateBPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(History.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateA;
    private com.toedter.calendar.JDateChooser dateB;
    private com.toedter.calendar.JDateChooser datefecha;
    private javax.swing.JTable historytable;
    private javax.swing.JComboBox hour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton jrb_maquina;
    private javax.swing.JComboBox maquinas;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JRadioButton vall;
    private javax.swing.JRadioButton vfecha;
    private javax.swing.JRadioButton vfechafecha;
    private javax.swing.ButtonGroup viewDate;
    private javax.swing.JRadioButton vmes;
    // End of variables declaration//GEN-END:variables
}
