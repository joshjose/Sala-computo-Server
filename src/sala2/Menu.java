/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala2;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author josue
 */
public class Menu extends javax.swing.JFrame {
 List<JButton> maquinas = new ArrayList<>();

  ArrayList clientOutputStreams;
   ArrayList<String> users;
   int number,row,available,so=0;
      PrintWriter writer;  
  

  private int num_com;
    /**
     * Creates new form Menu 
     */
    public Menu() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
          
        showcomputers();
        WindowPane.setLayout(new GridLayout(1, 10));
        MacPane.setLayout(new GridLayout(1, 10));
        b_start();
    }

    
    
    

    public void showcomputers() {
        maquinas.clear();
        WindowPane.removeAll();
        MacPane.removeAll();
         
        
        Query request = new Query();
        Conexion_DB con = new Conexion_DB();
        ResultSet rs = request.executeQuery("select * from computadora", con);

        try {
            while (rs.next()) {
                if (rs.getInt(3) == 1) {
                    JButton btn = new JButton();
                    
                    if(rs.getString(4).equals("Windows")){
                        btn.setName("btn" + rs.getInt(1));
                    btn.setIcon(new ImageIcon(getClass().getResource("/icons/pc.png")));
                    }
                    else{
                        btn.setName("btn" + rs.getInt(1));
                    btn.setIcon(new ImageIcon(getClass().getResource("/icons/mac.png")));
                    }
                    
                    btn.setSize(50, 50);
                    btn.setSize(new Dimension(50, 50));
                    btn.setText(rs.getInt(1) + "");
                    btn.setFont(new Font("Arial", Font.BOLD, 20));
                    if (rs.getInt(2) == 0) {
                        btn.setBackground(java.awt.Color.green);
                      

                    } else {
                        btn.setBackground(java.awt.Color.red);
                       
                    }
                    btn.setVerticalTextPosition((int) CENTER_ALIGNMENT);
                    btn.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                    btn.addMouseListener(new MouseAdapter() {

                     public void mouseClicked(MouseEvent me){
                         if(SwingUtilities.isRightMouseButton(me)){
                         
                         ppm_computadoras.show(btn,me.getX(),me.getY());
                         
                         }
                     }   
                    });
                    
                    
                    WindowPane.add(btn);
                    maquinas.add(btn);
                } else if (rs.getInt(3) == 2) {
                        JButton btn = new JButton();
                    
                    if(rs.getString(4).equals("Windows")){
                        btn.setName("btn" + rs.getInt(1));
                    btn.setIcon(new ImageIcon(getClass().getResource("/icons/pc.png")));
                    }
                    else{
                        btn.setName("btn" + rs.getInt(1));
                    btn.setIcon(new ImageIcon(getClass().getResource("/icons/mac.png")));
                    }
                    
                    btn.setSize(50, 50);
                    btn.setSize(new Dimension(50, 50));
                    btn.setText(rs.getInt(1) + "");
                    btn.setFont(new Font("Arial", Font.BOLD, 20));
                    if (rs.getInt(2) == 0) {
                        btn.setBackground(java.awt.Color.green);
                      

                    } else {
                        btn.setBackground(java.awt.Color.red);
                       
                    }
                     btn.addMouseListener(new MouseAdapter() {

                     public void mouseClicked(MouseEvent me){
                         if(SwingUtilities.isRightMouseButton(me)){
                         
                         ppm_computadoras.show(btn,me.getX(),me.getY());
                         
                         }
                     }   
                    });

                        MacPane.add(btn);                       
                        maquinas.add(btn);
                    
                }

            }
        } catch (Exception e) {
            System.out.println("Error:"+e);
        } finally {
            con = null;
        }
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppm_computadoras = new javax.swing.JPopupMenu();
        edit_com = new javax.swing.JMenuItem();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        WindowPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MacPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Computadoras = new javax.swing.JMenuItem();
        Historial = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        edit_com.setText("Editar");
        edit_com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_comActionPerformed(evt);
            }
        });
        ppm_computadoras.add(edit_com);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(255, 153, 0));
        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CENTRO DE COMPUTO");

        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INSTITUTO TECNOLÓGICO SUPERIOR DE TEPOSCOLULA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fila 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 2, 36))); // NOI18N
        jScrollPane1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jScrollPane1.setName(""); // NOI18N

        WindowPane.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N

        javax.swing.GroupLayout WindowPaneLayout = new javax.swing.GroupLayout(WindowPane);
        WindowPane.setLayout(WindowPaneLayout);
        WindowPaneLayout.setHorizontalGroup(
            WindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1723, Short.MAX_VALUE)
        );
        WindowPaneLayout.setVerticalGroup(
            WindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(WindowPane);

        jScrollPane2.setBackground(new java.awt.Color(255, 153, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fila 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 2, 36))); // NOI18N
        jScrollPane2.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N

        MacPane.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N

        javax.swing.GroupLayout MacPaneLayout = new javax.swing.GroupLayout(MacPane);
        MacPane.setLayout(MacPaneLayout);
        MacPaneLayout.setHorizontalGroup(
            MacPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1723, Short.MAX_VALUE)
        );
        MacPaneLayout.setVerticalGroup(
            MacPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(MacPane);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel7.setText("Av. Tecnológico S/N, C.P. 69500, San Pedro y San Pablo Teposcolula, Oaxaca. ");

        jLabel8.setText("Tel. (953) 5378555, e-mail: dir_dteposcolula@tecnm.mx ");

        jLabel9.setText("www.itsteposcolula.edu.mx ");

        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane3.setViewportView(ta_chat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(6, 6, 6))
            .addComponent(jScrollPane3)
        );

        jMenu1.setText("Sala de Computo");
        jMenu1.add(jSeparator2);

        Computadoras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Computadoras.setText("Computadoras");
        Computadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComputadorasActionPerformed(evt);
            }
        });
        jMenu1.add(Computadoras);

        Historial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        Historial.setText("Historial");
        Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialActionPerformed(evt);
            }
        });
        jMenu1.add(Historial);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialActionPerformed
        history();
    }//GEN-LAST:event_HistorialActionPerformed

    private void ComputadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComputadorasActionPerformed
        computers();
    }//GEN-LAST:event_ComputadorasActionPerformed

    private void edit_comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_comActionPerformed
       computers();
    }//GEN-LAST:event_edit_comActionPerformed

    
     

    public void history() {
        History start = new History();
        start.setVisible(true);
    }

   


    public void computers(){
         Computers start = new Computers();
        start.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    /**
     * @return the num_com
     */
    public int getNum_com() {
        return num_com;
    }

    /**
     * @param num_com the num_com to set
     */
    public void setNum_com(int num_com) {
        this.num_com = num_com;
    }

////////////////////////////////////////////////////////////////////////////////////
    // methods to work with thread and handle clients
    public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;

       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
            client = user;
            try 
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                ta_chat.append("Unexpected error... \n");
            }

       }

       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            String[] data;

            try 
            {
               
                while ((message = reader.readLine()) != null) 
                {
                    
                    data = message.split(":");
                    
                    

                    if (data[2].equals(connect)) 
                    {
                        String Ncontrol=data[1];
                        
                        String Maquinanum=data[0];
                        
                        usar(Ncontrol,Maquinanum);
                        
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        String num= data[0];
                       
                            
                        finalizar(num);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                       ta_chat.append(data[0]+" "+data[1]+"\n");
                    } 
                    else 
                    {
                       
                    }
                } 
             } 
             catch (Exception ex) 
             {
                ta_chat.append("Lost a connection. \n");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
             } 
	} 
    }

   

                    

                               

    private void b_start() {                                        
        Thread starter = new Thread(new ServerStart());
        starter.start();
        
        ta_chat.append("Server started...\n");
    }                                       

                                    

 
   
    
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  

            try 
            {
                ServerSocket serverSock = new ServerSocket(1995);

                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);
                                writer.flush(); 

				Thread listener = new Thread(new ClientHandler(clientSock, writer));
				listener.start();
				ta_chat.append("Got a connection. \n");
                }
            }
            catch (Exception ex)
            {
                ta_chat.append("Error making a connection. \n");
            }
        }
    }
    
  
    
  
    
    public void telluser(String tell) 
    {
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
         try {
             
            PrintWriter writer1 = (PrintWriter) it.next();
            
               writer1.println(tell);
                writer1.flush();
            //    JOptionPane.showMessageDialog(null,"Message was  sent. \n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Message was not sent. \n "+ex);
            }
            
        }   
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Computadoras;
    private javax.swing.JMenuItem Historial;
    private javax.swing.JPanel MacPane;
    private javax.swing.JPanel WindowPane;
    private javax.swing.JMenuItem edit_com;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu ppm_computadoras;
    private javax.swing.JTextArea ta_chat;
    // End of variables declaration//GEN-END:variables


 public void usar(String  numcontrol, String maquina) {

        Query request = new Query();
        Conexion_DB con = new Conexion_DB();

        if (!numcontrol.isEmpty()) {

            ResultSet rs = request.executeQuery("select NumControl from alumno where NumControl='" + numcontrol + "'", con);
            try {
                   setNum_com(Integer.parseInt(maquina));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
          
            int id_alumno = 0, id_computer = 0;

            try {
                if (rs.next()) {
                    id_alumno = rs.getInt(1);

                    rs = request.executeQuery("select Id from computadora where Id=" + getNum_com() + "", con);
                    if (rs.next()) {
                        id_computer = rs.getInt(1);
                    }

                    Calendar cal = GregorianCalendar.getInstance();
                    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                    String date = format.format(cal.getTime());
                    String time = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

                    boolean start = request.execute("insert into registro(Id_Alumno,Id_Computer,Fecha,Tiempo_Inicio) values(" + id_alumno + ", " + id_computer + ", '" + date + "', '" + time + "')");
                    if (start) {
//                      JOptionPane.showMessageDialog(null, "registro agregado");
                   }
                    else{
   //                     JOptionPane.showMessageDialog(null, "error en rgistrar");
                    }
                    boolean start2 = request.execute("update  computadora set Disponible= '1' where Id = " + getNum_com()+ " ");
                    if (start2) {
   //                    JOptionPane.showMessageDialog(null, "Equipo: " + maquina + " ' ahora esta en uso, Favor de Cerrar Sesion cuando termine.'");
                    showcomputers();
                    }
                    
                      String tell= numcontrol+":"+maquina+":"+"enjoy:"+"Connect";

                    telluser(tell);
                    
                    

                } else {
                    //primero registrar el alumono despues usar computadora
                    String tell= ":"+":"+"El numero de control "+numcontrol+" no se encuentra en la base de datos!:"+"Error";
                    
                    telluser(tell);
                    
                }

            } catch (Exception e) {
            } finally {
                con = null;
            }

        } else {
            //  ingrese un ncontrol
            String tell= ":"+":"+"El numero de control no se encuentra en la base de datos!:"+"Error";
                    
                    telluser(tell);
            
            //
        }

    }
 
     public void finalizar(String number) {
        
        
        Query request = new Query();
        Conexion_DB con = new Conexion_DB();
        int id_alumno = 0;

        ResultSet rs;
        try {

            rs = request.executeQuery("select Id_Alumno from registro where Id_Computer=" + number + " and Tiempo_Fin is null", con);
            if (rs.next()) {
                id_alumno = rs.getInt(1);
            }

            Calendar cal = GregorianCalendar.getInstance();

            String time = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

            boolean end = request.execute("update registro set Tiempo_Fin = ' " + time + "' where Id_Alumno=" + id_alumno + " and Tiempo_Fin is null");

            if (end) {
//                JOptionPane.showMessageDialog(null, " completando tiempo de finalizacion");
           }
            boolean start2 = request.execute("update  computadora set Disponible= '0' where Id = " + number);
            if (start2) {
//                JOptionPane.showMessageDialog(null, "Equipo: " + number + "ahora esta Disponible.");
           showcomputers();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            con = null;
        }

    }
 

}
