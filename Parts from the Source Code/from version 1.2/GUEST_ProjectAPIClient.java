/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.opcturkey.kepserverexdesktopclient;

 
//import com.mysql.cj.util.StringUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.awt.Component;
import java.awt.Dimension;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
 import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.codehaus.jettison.json.JSONException;
 import java.lang.Object;
 import java.net.MalformedURLException;
 import java.net.http.HttpRequest.BodyPublishers;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
 import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
 import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.ArrayUtils;
  import org.apache.commons.lang3.StringUtils;
 /**
 *
 * @author yunus emre vurgun 2022
 */
public class GUEST_ProjectAPIClient extends javax.swing.JFrame {
String ChannelNameGetterTemplate;
                          String tillEndPoint;
                                  int intOfChannelTagSlotName;
                                          int intOfClosingSymbolsForTagSlotName;
                                          ArrayList<String> channelList= new ArrayList<>();
                                          int channelCount;
                                          String json;
                                            ArrayList<String> splittedSmart= new ArrayList<>();
                                                ArrayList<String> splittedX= new ArrayList<>();
                                                ArrayList<String> tagHolder= new ArrayList<>();
                                                ArrayList<Integer> tagHolderINT= new ArrayList<>();
                                                 ArrayList<String> tagHolderStrings = new ArrayList<>();
                                                 int sumofthem;  
                                                ArrayList<String> deviceHolder = new ArrayList<>();
                                                ArrayList<String> tagNamesHolder = new ArrayList<>();
                                                 ArrayList<String> tagNamesHolder2 = new ArrayList<>();
                                               String[] xc2;
                                               ArrayList<String> thisTagDetailHolder = new ArrayList<>();
                                               String jsonResponseGlobal;
                                               String selected25toSTRGLBL;
                                               String innerTXT2="";
                                               ArrayList<String> CSVholder = new ArrayList<>();
                                                   int radioSetForAutoReconnect=0;
                                                           String dateTimeForFileName=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss.SSS"));
boolean popupStatus=true;
                   String[] splittedOneRowArray;                                
CheckSomethingSomewhere CSomSwhere = new CheckSomethingSomewhere();

    /**
     * Creates new form ProjectAPIClient
     */      private BufferedImage icon1;
      
     
     
     
     public void addActionListenerToIPbox(){
             jComboBox1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evnt){
                     
                  JComboBox jComboBox1 = (JComboBox) evnt.getSource();
                    Object selectedItem = jComboBox1.getSelectedItem();
                     System.out.println("SELECTED----> "+selectedItem.toString());
                      
                    String selectedItemAsString=selectedItem.toString();
                    String fullStringContainingSelectedName = "empty";
                    if(!(selectedItemAsString.contains("Select Configuration"))){
                        
                            
                            for(int i=0;i<CSVholder.size();i++){
                                if(CSVholder.get(i).contains(selectedItemAsString)){
                                    
                                    fullStringContainingSelectedName= CSVholder.get(i);
                                    
                                    break;
                                }
                            }
                            
                            System.out.println(fullStringContainingSelectedName);
                             
                            String mainString=fullStringContainingSelectedName;
                            
                            int startIndexOf_thisIsIP = mainString.indexOf("[")+2;
                            int endIndexOf_thisIsIP  = mainString.indexOf(",");
                            
                            String withoutIP = mainString.substring( endIndexOf_thisIsIP+3  ,  mainString.length()   );
                            System.out.println("fullStringContainingSelectedName_noip--->"+withoutIP);
                            
                             int startIndexOf_thisIsAdminName= 1;
                            int endIndexOf_thisIsAdminName= withoutIP.indexOf(",  ");
                            
                             String withoutName=withoutIP.substring(endIndexOf_thisIsAdminName+3,withoutIP.length());
                            System.out.println("fullStringContainingSelectedName_noip_noname--->"+withoutName);
                            
                            
                             int startIndexOf_thisIsPass= 0;
                            int endIndexOf_thisIsPass= withoutName.indexOf(",");
                                                        
                            String noPass=withoutName.substring(endIndexOf_thisIsPass+3,withoutName.length());

                           System.out.println("fullStringContainingSelectedName_noip_noname_nopass--->"+noPass);
                            
                            String thisIsIP=fullStringContainingSelectedName.substring(startIndexOf_thisIsIP, endIndexOf_thisIsIP);
                             String thisIsAdminName=withoutIP.substring(startIndexOf_thisIsAdminName-1, endIndexOf_thisIsAdminName);
                             String thisIsPass=withoutName.substring(startIndexOf_thisIsPass, endIndexOf_thisIsPass);
                            
                        System.out.println("The IP: "+thisIsIP);
                        System.out.println("The Admin Name: "+thisIsAdminName);
                       System.out.println("The Password: "+thisIsPass);
                       
                       
                       jTextField6.setText(thisIsAdminName);
                       jTextField7.setText(thisIsPass);
                       jTextField9.setText(thisIsIP);
                      /*
                        
                        
                        FIND SELECTED ITEM AS STRING'S ID [, , , ] IN THE ARRAY NAMED "CSVholder"
                        THEN AFTER YOU FIND THE LINE OF IT, SPLIT BY "," AND PLACE INTO USER OUTPUTS
                        CORRESPONDING VALUES.
                        
                        */
                        
                    }
                    
                       }
                 
               });
          }
     
     
     
     
JFrame globalLogFrame;




    public GUEST_ProjectAPIClient() {
       
       
     
     initComponents();
     jButton3.setVisible(false);
     jToggleButton2.setVisible(false);
     jButton4.setVisible(false);
     jButton2.setVisible(false);
          jButton4.setEnabled(false);

     jMenuItem6.doClick();
     jButton9.setVisible(false);
     jLabel29.setVisible(false);   jInternalFrame1.setVisible(false);  jInternalFrame2.setVisible(false);   jScrollPane1.setVisible(false);  
    
     /////*******
     ///&&&&&
    
  
     ///&&&&&
     
     
             try(CSVReader reader = new CSVReader(new FileReader("KepServerList.csv"))){
             
             var list= reader.readAll();
            
            list.remove(list.get(0));
            
            for(int i=0;i<list.size();i++){
                
               if(Arrays.toString(list.get(i)).contains(",")==false){
                   
                   list.remove(list.get(i));
               } 
               
               
                
            }
            
            
          
          
            Object object1; Object object2; Object object3; Object object4;
            
            String[] objectsOfCSV;
          for(int i=0; i < list.size(); i++){
              
              
              var oneRow= list.get(i);
              
              if(Arrays.toString(oneRow).contains("/iotgateway")){
                  oneRow.equals("");
              }else{
                   splittedOneRowArray = Arrays.toString(oneRow).split(",");
              
               object1=splittedOneRowArray[0].replace("[", "").replace("]","");
               object2=splittedOneRowArray[1].replace("[", "").replace("]","");
               object3=splittedOneRowArray[2].replace("[", "").replace("]","");
               object4=splittedOneRowArray[3].replace("[", "").replace("]","");
               
               System.out.println(Arrays.toString(splittedOneRowArray));
               var addThis= splittedOneRowArray[3];
                 if(addThis!=null &&addThis!="" && addThis!=" "){
                    jComboBox1.addItem(addThis.replace("]", ""));
                    CSVholder.add(Arrays.toString(splittedOneRowArray));
                    
                    
               }
              }
              
               
          }
         
          
          addActionListenerToIPbox();
              
              
            
         } catch (FileNotFoundException ex) {
            Logger.getLogger(MutlipleKepServerList.class.getName()).log(Level.SEVERE, null, ex);
            
             JOptionPane warningX = new JOptionPane("Ops! You don't have any pre-saved configurations! Or you deleted a very important file!");warningX.setVisible(true);
        } 
          
          
          catch (IOException ex) {
            Logger.getLogger(MutlipleKepServerList.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane warningX = new JOptionPane("Ops! You don't have any pre-saved configurations! Or another error occured!");warningX.setVisible(true);
        }
          
          
          
          catch (CsvException ex) {
            Logger.getLogger(MutlipleKepServerList.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane warningX = new JOptionPane("Ops! You don't have any pre-saved configurations! Or there is comething else wrong!");warningX.setVisible(true);
        }
          
          
          catch(ArrayIndexOutOfBoundsException ae){
          JOptionPane warningX = new JOptionPane("Ops! You don't have any pre-saved configurations! Or there is comething else wrong because when we read, we only find empty fields!");
   warningX.setVisible(true);
              
        }
          
          catch(Exception e){
               JOptionPane warningX = new JOptionPane("Ops! You don't have any pre-saved configurations! Or there is comething else wrong because when we read, we only find empty fields!");
   warningX.setVisible(true);
          }
   
          
          
       
     
     
     
     ///*******/////
     
  jInternalFrame1.setVisible(false); 
 jInternalFrame2.setVisible(false); 
 jInternalFrame3.setVisible(false); 
 
 jTextArea1.setVisible(false);
  jLabel29.setVisible(false);
     
     
     
     jLabel29.setVisible(false);
jTextArea1.setVisible(false);
 
            
     jInternalFrame3.setVisible(true);
     jInternalFrame2.setVisible(false);
     jInternalFrame1.setVisible(false);
             jLabel43.setVisible(false);  jLabel44.setVisible(false);  jTextField34.setVisible(false);  jLabel45.setVisible(false);  
jTextField35.setVisible(false);  jLabel46.setVisible(false); 
 jTextField36.setVisible(false);  jLabel37.setVisible(false);  
jTextField29.setVisible(false);  jButton10.setVisible(false);
       jButton5.setVisible(true);
jButton6.setVisible(true);
jTextArea2.setVisible(true);
jLabel38.setVisible(false);  jTextField28.setVisible(false);  jTextField30.setVisible(false); 
 jLabel39.setVisible(false);  jLabel40.setVisible(false);  jTextField31.setVisible(false);  jLabel42.setVisible(false); 
 jTextField33.setVisible(false);  jLabel41.setVisible(false);  jTextField32.setVisible(false);  jButton8.setVisible(false);        // TODO add your handling code here:
  
            try {
            this.icon1 = ImageIO.read(new File("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\robotic-arm.png"));
            
            
        } catch (IOException ex) {
            Logger.getLogger(WelcomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        setIconImage(icon1);
   
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField18 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jComboBox24 = new javax.swing.JComboBox<>();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jFrame3 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox23 = new javax.swing.JComboBox<>();
        jTextField19 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBox25 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jComboBox26 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel16 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel38 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jTextField18.setBackground(new java.awt.Color(255, 204, 204));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel26.setText("Number of Devices in Channel (select):");

        jComboBox24.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu3.setText("jMenu3");

        setTitle("KepServerEX Desktop Client by OPCTurkey");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("Kepware Server API Access");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 340, 1331, 10));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setForeground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 131, 100, -1));

        jTextField6.setBackground(new java.awt.Color(204, 255, 255));
        jTextField6.setText("administrator");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 131, 146, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel10.setText("User:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 131, 30, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel11.setText("Password:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 131, -1, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setText("IP and Port:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 131, -1, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setText("Connection Status:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 131, -1, 20));

        jTextField7.setBackground(new java.awt.Color(204, 255, 255));
        jTextField7.setForeground(new java.awt.Color(153, 153, 153));
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 131, 146, -1));

        jTextField9.setBackground(new java.awt.Color(204, 255, 255));
        jTextField9.setText("127.0.0.1:57412");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 131, 146, -1));

        jTextField11.setBackground(new java.awt.Color(71, 133, 194));
        jTextField11.setForeground(new java.awt.Color(204, 255, 255));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 131, 120, -1));

        jTextField12.setBackground(new java.awt.Color(71, 133, 194));
        jTextField12.setForeground(new java.awt.Color(204, 255, 255));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, 220, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel14.setText("Number of Channels:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("No. of Devices:");
        jLabel15.setEnabled(false);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 310, -1, -1));

        jComboBox23.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        jComboBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox23ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 200, 490, -1));

        jTextField19.setBackground(new java.awt.Color(71, 133, 194));
        jTextField19.setForeground(new java.awt.Color(204, 255, 255));
        jTextField19.setEnabled(false);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 280, 200, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel27.setText("Number of Tags in Device:");
        jLabel27.setEnabled(false);
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 280, 160, -1));

        jComboBox25.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        jComboBox25.setEnabled(false);
        jComboBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox25ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox25, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 240, 490, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel28.setText("Name of Selected Tag:");
        jLabel28.setEnabled(false);
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 250, -1, -1));

        jTextField20.setBackground(new java.awt.Color(71, 133, 194));
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setEnabled(false);
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 250, 220, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel29.setText("Modification Status:");
        jLabel29.setEnabled(false);
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1114, 380, -1, -1));

        jButton4.setBackground(new java.awt.Color(51, 102, 255));
        jButton4.setForeground(new java.awt.Color(204, 255, 255));
        jButton4.setText("Show All Tag Names in Device");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 4, -1));

        jTextField22.setBackground(new java.awt.Color(71, 133, 194));
        jTextField22.setForeground(new java.awt.Color(204, 255, 255));
        jTextField22.setEnabled(false);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 310, 250, -1));

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 204));
        jButton2.setText("Restart Window");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 4, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel31.setText("Select a Tag:");
        jLabel31.setEnabled(false);
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 280, -1, -1));

        jComboBox26.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        jComboBox26.setEnabled(false);
        jComboBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox26ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox26, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 280, 500, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\Untitled_design__25_-removebg-preview.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 17, -1, 64));

        jTextField25.setBackground(new java.awt.Color(204, 255, 255));
        jTextField25.setEnabled(false);
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1144, 200, 150, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel34.setText("Tag Scan Rate:");
        jLabel34.setEnabled(false);
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1044, 200, -1, -1));

        jTextField26.setBackground(new java.awt.Color(204, 255, 255));
        jTextField26.setEnabled(false);
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1114, 240, 180, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel35.setText("Tag Address:");
        jLabel35.setEnabled(false);
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 240, -1, -1));

        jTextField27.setBackground(new java.awt.Color(204, 255, 255));
        jTextField27.setEnabled(false);
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 280, 160, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel36.setText("Tag Data Type");
        jLabel36.setEnabled(false);
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 280, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setForeground(new java.awt.Color(204, 255, 255));
        jButton9.setText("Delete Selected Tag");
        jButton9.setEnabled(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 0, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1340, 16));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel16.setText("Project ID:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 190, -1, 20));

        jTextField14.setBackground(new java.awt.Color(71, 133, 194));
        jTextField14.setForeground(new java.awt.Color(204, 255, 255));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 190, 280, -1));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("View Upcoming Console Log Messages of This Page");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 4, -1));

        jToggleButton2.setBackground(new java.awt.Color(0, 51, 51));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(204, 255, 255));
        jToggleButton2.setText("Safe Mode (ON/OFF)");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 0, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel32.setText("Select a Device:");
        jLabel32.setEnabled(false);
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 240, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel17.setText("Select Channel:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 200, -1, -1));

        jInternalFrame1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel38.setText("Unique Tag Name:");
        jLabel38.setEnabled(false);
        jInternalFrame1.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 3, -1, -1));

        jTextField28.setBackground(new java.awt.Color(204, 255, 255));
        jTextField28.setEnabled(false);
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 255, -1));

        jTextField30.setBackground(new java.awt.Color(204, 255, 255));
        jTextField30.setEnabled(false);
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 28, 310, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel39.setText("Tag Address:");
        jLabel39.setEnabled(false);
        jInternalFrame1.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 31, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel40.setText("Data Type:");
        jLabel40.setEnabled(false);
        jInternalFrame1.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, -1, -1));

        jTextField31.setBackground(new java.awt.Color(204, 255, 255));
        jTextField31.setEnabled(false);
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 51, 320, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel42.setText("Scan Rate (ms):");
        jLabel42.setEnabled(false);
        jInternalFrame1.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 110, -1, -1));

        jTextField33.setBackground(new java.awt.Color(204, 255, 255));
        jTextField33.setEnabled(false);
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField33ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 107, 280, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel41.setText("Read/Write Access:");
        jLabel41.setEnabled(false);
        jInternalFrame1.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 82, -1, -1));

        jTextField32.setBackground(new java.awt.Color(204, 255, 255));
        jTextField32.setText("1");
        jTextField32.setEnabled(false);
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 79, 270, -1));

        jButton8.setBackground(new java.awt.Color(255, 204, 102));
        jButton8.setForeground(new java.awt.Color(0, 51, 51));
        jButton8.setText("Create New Tag");
        jButton8.setEnabled(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 147, 244, -1));

        getContentPane().add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 370, 460, -1));

        jInternalFrame3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jInternalFrame3.setResizable(true);
        jInternalFrame3.setVisible(true);
        jInternalFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jInternalFrame3.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 32, 1307, 152));

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Clear Logs");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 6, 109, -1));

        jButton6.setBackground(new java.awt.Color(153, 0, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 204, 204));
        jButton6.setText("X");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 38, -1));

        jButton7.setBackground(new java.awt.Color(51, 153, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Expand");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 6, -1, -1));

        jButton11.setBackground(new java.awt.Color(153, 255, 153));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton11.setText("Export Logs as .txt");
        jButton11.setEnabled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 6, -1, -1));

        jInternalFrame2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jInternalFrame2.setVisible(true);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 102, 0));
        jLabel43.setText("Your Selected Tag is: null");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel44.setText("New Scan Rate:");
        jLabel44.setEnabled(false);

        jTextField34.setBackground(new java.awt.Color(204, 255, 255));
        jTextField34.setEnabled(false);
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel45.setText("New Address:");
        jLabel45.setEnabled(false);

        jTextField35.setBackground(new java.awt.Color(204, 255, 255));
        jTextField35.setEnabled(false);
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel46.setText("New Data Type:");
        jLabel46.setEnabled(false);

        jTextField36.setBackground(new java.awt.Color(204, 255, 255));
        jTextField36.setEnabled(false);
        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField36ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel37.setText("New Tag Name:");
        jLabel37.setEnabled(false);

        jTextField29.setBackground(new java.awt.Color(204, 255, 255));
        jTextField29.setEnabled(false);
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 204, 102));
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setText("Change Selected Tag Details");
        jButton10.setEnabled(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField34))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField35))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField36))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton10)))
                .addGap(69, 69, 69))
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame3.getContentPane().add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, -10, -1, -1));

        getContentPane().add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 350, 1325, 220));

        jComboBox1.setBackground(new java.awt.Color(51, 204, 0));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Configuration" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 131, 220, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 410, 240, 192));

        jSeparator3.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 160, 1340, 16));

        jSeparator4.setForeground(new java.awt.Color(0, 51, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1014, 160, 22, 180));

        jSeparator5.setForeground(new java.awt.Color(0, 51, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 180, 22, 160));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1049, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\Guest Mode (1).png")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 6, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\Untitled design (24).png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1381, 640));

        jMenu1.setText("Main Options");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jRadioButtonMenuItem2.setText("Safe Mode (on/off)");
        jRadioButtonMenuItem2.setEnabled(false);
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem2);

        jMenuItem2.setText("Hide Console Log Messages");
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Reconnect to API");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Always Reconnect After a Tag Modify Action");
        jRadioButtonMenuItem1.setEnabled(false);
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tag Options");
        jMenu2.setEnabled(false);
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        jMenuItem3.setText("Create Tag");
        jMenuItem3.setEnabled(false);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Change Tag Details");
        jMenuItem4.setEnabled(false);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Delete Tag");
        jMenuItem5.setEnabled(false);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Turn-off Action Approval Popups");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed
  
 private static final String getBasicAuthenticationHeader(String username, String password){
     String valueToEncode = username + ":"+password;
     return "Basic "+Base64.getEncoder().encodeToString(valueToEncode.getBytes());
 }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

          
        


// TODO add your handling code here:
        
        String adminName = jTextField6.getText();
        String passWord = jTextField7.getText();
        String ip_and_port = jTextField9.getText();
        jTextField11.setText(" ");
        if(adminName.length()==0||ip_and_port.length()==0){
            jTextField11.setText("some fields can not be empty");
            
        }else{
            try {
                clickedConnect();
            } catch (JSONException ex) {
                Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         
      jButton1.setEnabled(false);
      jButton2.setEnabled(true);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox23ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jComboBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox25ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed
 
    
    

 
     
    public int advancedWritingActionFunction(){
        
        
        
        
        return 0;
    }
 
 
   
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       //or(){
        //  selected25toSTRGLBL.split(",") ;
       //
       // jTextArea1.setText(selected25toSTRGLBL);
        //SHOW ALL TAG NAMES AND THEIR VALUES FOR SELECTED DEVICE
        
 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


 

        // connect again button on-click
                 ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////

         ///////*************/////////////////////
         
         
         
        GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
          PapiC2.show();
        
       this.dispose();
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox26ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed



      
      this.setVisible(false);
                                     
                                     /////////
                                      
                                    Object[] buttons={"YES, DELETE THE TAG!","NO! CANCEL!"}; 
                                     
                                  int lastWarningDialogBeforeWriteAction = JOptionPane.showOptionDialog(
                                  
                                  null, "You are about to DELETE the tag you selected. This action can NOT be undone. Are you sure to DELETE this tag?",
                                          "IMPORTANT LAST WARNING!", JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE, null,     buttons,   buttons[0]);
                                  
                                  if(lastWarningDialogBeforeWriteAction == JOptionPane.YES_OPTION){
                                      JOptionPane.showMessageDialog(null, "Deleting tag operation Started, find the results in the status box.");
                                      
          try {
              deleteTagAction();
          } catch (IOException ex) {
              Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
          }
                                      
                                       this.setVisible(true);
                                  }else{
                                      JOptionPane.showMessageDialog(null, "Deleting tag operation has been cancelled safely.");
                                      System.out.println("operation cancelled.");
                                         if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "operation cancelled" );
                }
                                      
                                       this.setVisible(true);
                                  }
                                    
                                     ////////

                 

    }//GEN-LAST:event_jButton9ActionPerformed

    public int changeTagAction()throws MalformedURLException, IOException, InterruptedException{
        String adminName = jTextField6.getText();
                     String passWord = jTextField7.getText();
        String nameOfTheTag=jTextField20.getText().replaceAll(" ", "");
         String ip_and_port= jTextField9.getText();
          String theUrl = "http://"+ip_and_port+"/config/v1/project/channels/"+jComboBox23.getSelectedItem().toString()+"/devices/"+jComboBox25.getSelectedItem().toString()+"/tags/"+nameOfTheTag;
          System.out.println("\n\nthe url for change tag name req: "+theUrl+"\n\n");
            if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\nthe url for change tag name req: "+theUrl+"\n\n" +"     ////"+dateTimeForFileName+"////\n");
                }
        
            
          
          String bodyInfo="{\n" +
"		\"PROJECT_ID\": "+jTextField14.getText()+",\n" +
"		\"common.ALLTYPES_NAME\": \""+jTextField29.getText()+"\",\n" +
"		\"common.ALLTYPES_DESCRIPTION\": \"\",\n" +
"		\"servermain.TAG_ADDRESS\": \""+jTextField35.getText()+"\",\n" +
"		\"servermain.TAG_DATA_TYPE\": "+jTextField36.getText()+",\n" +
"		\"servermain.TAG_READ_WRITE_ACCESS\": 1,\n" +
"		\"servermain.TAG_SCAN_RATE_MILLISECONDS\": "+jTextField34.getText()+"		\n" +
"	}";
        
          
          
                HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                            .PUT(BodyPublishers.ofString(bodyInfo))
                            .header("accept", "application/json")
                    .uri(URI.create(theUrl))
                            .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
                            .build();
                    HttpResponse<String>response ;
                    
                    
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                       String responseBody = response.body();
                
                       
                       
                    System.out.println(responseBody);
                       if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ responseBody +"     ////"+dateTimeForFileName+"////\n");
                }
        jTextArea1.setText("Your CHANGE request \n has been sent to server.");
        
        if(responseBody.length()==0){
            jTextArea1.setText("Server returned an empty\n response body."
                     + "Server returned \nthis status code: \n"+response.statusCode());
        }
        
        if(responseBody.length()>0){
          jTextArea1.setText("Server returned this\n response body: \n"+response.body()+"\n"
                    + "Server returned this \nstatus code: "+response.statusCode());
        }
  
                    return 0;
                   }
    
    
    
    
    
    
    
    public int deleteTagAction() throws MalformedURLException, IOException, InterruptedException{
        String adminName = jTextField6.getText();
                     String passWord = jTextField7.getText();
        String nameOfTheTag=jTextField20.getText().replaceAll(" ", "");
         String ip_and_port= jTextField9.getText();
          String theUrl = "http://"+ip_and_port+"/config/v1/project/channels/"+jComboBox23.getSelectedItem().toString()+"/devices/"+jComboBox25.getSelectedItem().toString()+"/tags/"+nameOfTheTag;
          System.out.println("\n\nthe url for delete req: "+theUrl+"\n\n");
        
           if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+  "\n\nthe url for delete req: "+theUrl+"\n\n"+"     ////"+dateTimeForFileName+"////\n");
                }
          
          
                HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                            .DELETE()
                            .header("accept", "application/json")
                    .uri(URI.create(theUrl))
                            .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
                            .build();
                    HttpResponse<String>response ;
                    
                    
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                       String responseBody = response.body();
                       
                       
                       
                    System.out.println(responseBody);
                       if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ responseBody +"     ////"+dateTimeForFileName+"////\n");
                }
        jTextArea1.setText("Your DELETE request \n has been sent to server.");
        
        if(responseBody.length()==0){
          //  jTextArea1.setText("Server returned an empty response body."
               //     + "Server returned this status code: "+response.statusCode());
        }
        
        if(responseBody.length()>0){
          //  jTextArea1.setText("Server returned this response body: "+response.body()+"\n"
                 //   + "Server returned this status code: "+response.statusCode());
        }
         /*  
        URL url = new URL(theUrl);
 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("DELETE");
int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        jTextField21.setText(responseCode+" returned.");
                   */  return 0;
                   }
    
    
    
    /////CREATE NEW TAG ACTION FUNCTION/////
    
    
 ////
    /////
    
       public int createTagAction() throws MalformedURLException, IOException, InterruptedException{
        String adminName = jTextField6.getText();
                     String passWord = jTextField7.getText();
        String nameOfTheTag=jTextField20.getText().replaceAll(" ", "");
         String ip_and_port= jTextField9.getText();
          String theUrl = "http://"+ip_and_port+"/config/v1/project/channels/"+jComboBox23.getSelectedItem().toString()+"/devices/"+jComboBox25.getSelectedItem().toString()+"/tags/";
          System.out.println("\n\nthe url for create req: "+theUrl+"\n\n");
            if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\nthe url for create req: "+theUrl+"\n\n" +"     ////"+dateTimeForFileName+"////\n");
                }
          
          String UniqueTagName0=jTextField28.getText();
          String adress0=jTextField30.getText();
          String typee0=jTextField31.getText();
          String scanratee0=jTextField33.getText();
          String readwriteaces0=jTextField32.getText();
          
          
          
          String bodyInfo="	{\n" +
"		\"common.ALLTYPES_NAME\": \""+UniqueTagName0+"\",\n" +
"		\"common.ALLTYPES_DESCRIPTION\": \"\",\n" +
"		\"servermain.TAG_ADDRESS\": \""+adress0+"\",\n" +
"		\"servermain.TAG_DATA_TYPE\": "+typee0+",\n" +
"		\"servermain.TAG_READ_WRITE_ACCESS\": "+readwriteaces0+",\n" +
"		\"servermain.TAG_SCAN_RATE_MILLISECONDS\": "+scanratee0+"\n" +
"\n" +
"	}";
        
          
          
                HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                            .POST(BodyPublishers.ofString(bodyInfo))
                            .header("accept", "application/json")
                    .uri(URI.create(theUrl))
                            .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
                            .build();
                    HttpResponse<String>response ;
                    
                    
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                       String responseBody = response.body();
                       
                       
                       
                    System.out.println(responseBody);
                       if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+responseBody  +"     ////"+dateTimeForFileName+"////\n");
                }
                  //  jTextArea1.setText(responseBody);
        jTextArea1.setText("Your CREATE request \n has been sent to server.");
        
        if(responseBody.length()==0){
           // jTextArea1.setText("Server returned an empty response body."
                  //  + "Server returned this status code: "+response.statusCode());
        }
        
        if(responseBody.length()>0){
           // jTextArea1.setText("Server returned this response body: "+response.body()+"\n"
               //     + "Server returned this status code: "+response.statusCode());
        }
         /*  
        URL url = new URL(theUrl);
 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("DELETE");
int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        jTextField21.setText(responseCode+" returned.");
                   */  return 0;
                   }
    
//
       //
       //
       //
///////      END ///////////////////


                    

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                     //
  jLabel29.setEnabled(true); 
 jTextArea1.setEnabled(true);
   jLabel29.setVisible(true); 
 jTextArea1.setVisible(true);jScrollPane1.setEnabled(true);
jScrollPane1.setVisible(true); 
 //
 if(popupStatus==true){
       
        this.setVisible(false);

        /////////
        int lastWarningDialogBeforeWriteAction = JOptionPane.showConfirmDialog(
            null, "You are about to attempt CREATING A NEW TAG in your KepServerEX project via configuration API. This operation is irreversable. Do you confirm this action?", "IMPORTANT WARNING!", JOptionPane.YES_NO_OPTION);

        if(lastWarningDialogBeforeWriteAction == JOptionPane.YES_OPTION){
            //////

jLabel28.setVisible(false); 
jTextField20.setVisible(false);   jLabel32.setVisible(false);   jLabel17.setVisible(false);   jTextField22.setVisible(false);  
 jLabel31.setVisible(false);   jComboBox26.setVisible(false);   jTextField25.setVisible(false);   jLabel34.setVisible(false);  
 jButton1.setVisible(false);   jTextField6.setVisible(false);   jLabel10.setVisible(false);   jLabel11.setVisible(false);   jLabel12.setVisible(false);   
jLabel13.setVisible(false);   jTextField7.setVisible(false);   jTextField9.setVisible(false);   jComboBox1.setVisible(false);   jTextField26.setVisible(false);  
 jLabel35.setVisible(false);   jTextField27.setVisible(false);   jLabel36.setVisible(false);   jSeparator2.setVisible(false);   
jTextField11.setVisible(false);   jTextField12.setVisible(false);   jLabel16.setVisible(false);   jLabel14.setVisible(false);   jTextField14.setVisible(false);  
 jLabel15.setVisible(false);  
 jComboBox23.setVisible(false);   jTextField19.setVisible(false);   jLabel27.setVisible(false);   jComboBox25.setVisible(false); 


///////
            JOptionPane.showMessageDialog(null, "operation Started, find the results in the status box.");
            try {
                createTagAction();
            } catch (                                 IOException | InterruptedException ex) {
                Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(true);
           if(radioSetForAutoReconnect==1){
                                       GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
                                       PapiC2.show();
                                         this.dispose();
                                      jButton1.doClick();
                                  } }else{
            JOptionPane.showMessageDialog(null, "Creating a new tag operation has been cancelled safely.");
            System.out.println("operation cancelled.");
               if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+"operation cancelled."  +"     ////"+dateTimeForFileName+"////\n");
                }
            this.setVisible(true);
        }

        ////////
    }else{
      try {
                createTagAction();
            } catch (                                 IOException | InterruptedException ex) {
                Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(true);
           if(radioSetForAutoReconnect==1){
                                       GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
                                       PapiC2.show();
                                         this.dispose();
                                      jButton1.doClick();
                                  }
     
 }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jTextField33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField33ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTextArea2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        globalLogFrame.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButtonMenuItem2.isSelected()){
            
            
jLabel38.setVisible(false); 
 jTextField28.setVisible(false);
jTextField30.setVisible(false); 
 jLabel39.setVisible(false); 
 jLabel40.setVisible(false); 

 jTextField31.setVisible(false); 
 jLabel42.setVisible(false);
 jTextField33.setVisible(false); 
jLabel41.setVisible(false); 
 jTextField32.setVisible(false); 

 jButton8.setVisible(false); 
 jLabel43.setVisible(false); 
 jLabel44.setVisible(false);
 jTextField34.setVisible(false); 
 jLabel45.setVisible(false);
jTextField35.setVisible(false); 

 jTextField36.setVisible(false);
 jButton9.setVisible(false); 
 //jSeparator3.setVisible(false); 
 //jSeparator4.setVisible(false); 
 jLabel37.setVisible(false); 

 jTextField29.setVisible(false); 
 jButton10.setVisible(false);
 jLabel29.setVisible(false); 
 jTextArea1.setVisible(false); 
jLabel46.setVisible(false); 
            
        }else{
            jLabel38.setVisible(true); 
 jTextField28.setVisible(true);
jTextField30.setVisible(true); 
 jLabel39.setVisible(true); 
 jLabel40.setVisible(true); 

 jTextField31.setVisible(true); 
 jLabel42.setVisible(true);
 jTextField33.setVisible(true); 
jLabel41.setVisible(true); 
 jTextField32.setVisible(true); 

 jButton8.setVisible(true); 
 jLabel43.setVisible(true); 
 jLabel44.setVisible(true);
 jTextField34.setVisible(true); 
 jLabel45.setVisible(true);
jTextField35.setVisible(true); 

 jTextField36.setVisible(true);
 jButton9.setVisible(true); 
 //jSeparator3.setVisible(true); 
 //jSeparator4.setVisible(true); 
 jLabel37.setVisible(true); 

 jTextField29.setVisible(true); 
 jButton10.setVisible(true);
 jLabel29.setVisible(true); 
 jTextArea1.setVisible(true);
 //
  jLabel29.setEnabled(true); 
 jTextArea1.setEnabled(true);
 //
 jLabel46.setVisible(true); 
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
jMenuItem2.setEnabled(false);
 jInternalFrame3.setVisible(false);
 jScrollPane1.setEnabled(true);
jScrollPane1.setVisible(true); 
      
         if(popupStatus==true){
        
        
        jLabel29.setVisible(true);
jTextArea1.setVisible(true);
//jTextArea1.setVisible(true);
//jLabel47.setVisible(true);   
      this.setVisible(false);
                                     
                                     /////////
                                      
                                    Object[] buttons={"YES, DELETE THE TAG!","NO! CANCEL!"}; 
                                     
                                  int lastWarningDialogBeforeWriteAction = JOptionPane.showOptionDialog(
                                  
                                  null, "You are about to DELETE the tag you selected. This action can NOT be undone. Are you sure to DELETE this tag?",
                                          "IMPORTANT LAST WARNING!", JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE, null,     buttons,   buttons[0]);
                                  
                                  if(lastWarningDialogBeforeWriteAction == JOptionPane.YES_OPTION){
                                      
//////

jLabel28.setVisible(false); 
jTextField20.setVisible(false);   jLabel32.setVisible(false);   jLabel17.setVisible(false);   jTextField22.setVisible(false);  
 jLabel31.setVisible(false);   jComboBox26.setVisible(false);   jTextField25.setVisible(false);   jLabel34.setVisible(false);  
 jButton1.setVisible(false);   jTextField6.setVisible(false);   jLabel10.setVisible(false);   jLabel11.setVisible(false);   jLabel12.setVisible(false);   
jLabel13.setVisible(false);   jTextField7.setVisible(false);   jTextField9.setVisible(false);   jComboBox1.setVisible(false);   jTextField26.setVisible(false);  
 jLabel35.setVisible(false);   jTextField27.setVisible(false);   jLabel36.setVisible(false);   jSeparator2.setVisible(false);   
jTextField11.setVisible(false);   jTextField12.setVisible(false);   jLabel16.setVisible(false);   jLabel14.setVisible(false);   jTextField14.setVisible(false);  
 jLabel15.setVisible(false);  
 jComboBox23.setVisible(false);   jTextField19.setVisible(false);   jLabel27.setVisible(false);   jComboBox25.setVisible(false); 


///////
                                      JOptionPane.showMessageDialog(null, "Deleting tag operation Started, find the results in the status box.");
                                      
          try {
              deleteTagAction();
          } catch (IOException ex) {
              Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
          }
                                      
                                       this.setVisible(true);
                                   if(radioSetForAutoReconnect==1){
                                       GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
                                       PapiC2.show();
                                         this.dispose();
                                      jButton1.doClick();
                                  }   }else{
                                      JOptionPane.showMessageDialog(null, "Deleting tag operation has been cancelled safely.");
                                      System.out.println("operation cancelled.");
                                         if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "operation cancelled" +"     ////"+dateTimeForFileName+"////\n");
                }
                                      
                                       this.setVisible(true);
                                  }
                                    
                                     ////////
    }else{
                try {
              deleteTagAction();
          } catch (IOException ex) {
              Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
          }
                                      
                                       this.setVisible(true);
                                   if(radioSetForAutoReconnect==1){
                                       GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
                                       PapiC2.show();
                                         this.dispose();
                                      jButton1.doClick();
                                  } 
             
         }// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
jMenuItem2.setEnabled(false);
 jInternalFrame3.setVisible(false);
        jTextField29.setText(jTextField20.getText());
        
        jTextField34.setText(jTextField25.getText());
        jTextField35.setText(jTextField26.getText());
        jTextField36.setText(jTextField27.getText());
        
        jLabel29.setVisible(true);
jTextArea1.setVisible(true);
//jTextArea1.setVisible(true);
//jLabel47.setVisible(true);        // TODO add your handling code here:
        jLabel43.setVisible(true);  jLabel44.setVisible(true);  jTextField34.setVisible(true);  jLabel45.setVisible(true);  
jTextField35.setVisible(true);  jLabel46.setVisible(true); 
 jTextField36.setVisible(true);  jLabel37.setVisible(true);  
jTextField29.setVisible(true);  jButton10.setVisible(true);
jInternalFrame2.setVisible(true);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
jMenuItem2.setEnabled(false);
        jInternalFrame3.setVisible(false);
        jLabel29.setVisible(true);
jTextArea1.setVisible(true);
jTextArea1.setVisible(true);
//jLabel47.setVisible(true);
jInternalFrame1.setVisible(true);jLabel38.setVisible(true);  jTextField28.setVisible(true);  jTextField30.setVisible(true); 
 jLabel39.setVisible(true);  jLabel40.setVisible(true);  jTextField31.setVisible(true);  jLabel42.setVisible(true); 
 jTextField33.setVisible(true);  jLabel41.setVisible(true);  jTextField32.setVisible(true);  jButton8.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed
int control=0;
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        
        
        if(control==0){
        jInternalFrame3.setVisible(false);
        jTextArea2.setEnabled(false);
        jTextArea2.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        
        jMenuItem2.setText("View Console Log Messages");
        control=1;
        }
        
        
        else{
            
            
              jInternalFrame3.setVisible(true);
        jTextArea2.setEnabled(true);
         jTextArea2.setVisible(true);
        jButton5.setVisible(true);
        jButton6.setVisible(true);
        
        jMenuItem2.setText("Hide Console Log Messages"); 
           control=0; 
        }
        
        
        
       
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        // connect again button on-click
        ///////*************/////////////////////
        ///////*************/////////////////////
        ///////*************/////////////////////
        ///////*************/////////////////////
        ///////*************/////////////////////
        ///////*************/////////////////////

        ///////*************/////////////////////

        GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
        PapiC2.show();

        this.dispose();
        jButton1.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
     if(jRadioButtonMenuItem2.isSelected()){
         jRadioButtonMenuItem2.setText("(ON) Safe Mode (on/off)");
         jInternalFrame2.setVisible(false);  jInternalFrame1.setVisible(false);  jLabel29.setVisible(false);  jTextArea1.setVisible(false); 
         jMenu2.setEnabled(false);
         
         
         
         jInternalFrame1.setVisible(false);
          jInternalFrame2.setVisible(false);
               jLabel29.setVisible(false);
jTextArea1.setVisible(false);
//jTextArea1.setVisible(false);
//jLabel47.setVisible(false);
         jMenuItem5.setEnabled(false);
            //jLabel47.setVisible(false);
            //jTextArea1.setVisible(false);
            jLabel38.setVisible(false);
            jTextField28.setVisible(false);
            jTextField30.setVisible(false);
            jLabel39.setVisible(false);
            jLabel40.setVisible(false);
             jTextField31.setVisible(false);
            jLabel42.setVisible(false);
            jTextField33.setVisible(false);
            jLabel41.setVisible(false);
            jTextField32.setVisible(false);

            jButton8.setVisible(false);
            jLabel43.setVisible(false);
            jLabel44.setVisible(false);
            jTextField34.setVisible(false);
            jLabel45.setVisible(false);
            jTextField35.setVisible(false);

            jTextField36.setVisible(false);
            jButton9.setVisible(false);
            //jSeparator3.setVisible(false);
            //jSeparator4.setVisible(false);
            jLabel37.setVisible(false);

            jTextField29.setVisible(false);
            jButton10.setVisible(false);
            jLabel29.setVisible(false);
            jTextArea1.setVisible(false);
            jLabel46.setVisible(false);

        }else{
          jRadioButtonMenuItem2.setText("(OFF) Safe Mode (on/off)");
          jMenu2.setEnabled(true);
              jLabel29.setVisible(true);
jTextArea1.setVisible(true);
//jTextArea1.setVisible(true);
//jLabel47.setVisible(true);
         jMenuItem5.setEnabled(true);
            jLabel38.setVisible(true);
            jTextField28.setVisible(true);
            jTextField30.setVisible(true);
            jLabel39.setVisible(true);
            jLabel40.setVisible(true);

            jTextField31.setVisible(true);
            jLabel42.setVisible(true);
            jTextField33.setVisible(true);
            jLabel41.setVisible(true);
            jTextField32.setVisible(true);

            jButton8.setVisible(true);
            jLabel43.setVisible(true);
            jLabel44.setVisible(true);
            jTextField34.setVisible(true);
            jLabel45.setVisible(true);
            jTextField35.setVisible(true);

            jTextField36.setVisible(true);
            jButton9.setVisible(true);
            //jSeparator3.setVisible(true);
            //jSeparator4.setVisible(true);
            jLabel37.setVisible(true);

            jTextField29.setVisible(true);
            jButton10.setVisible(true);
            jLabel29.setVisible(true);
            jTextArea1.setVisible(true);
            jLabel46.setVisible(true);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 innerTXT2 = jTextArea2.getText();  
        LogExpanded LOGEX= new LogExpanded();
       LOGEX.getlogshere=jTextArea2.getText();
        LOGEX.show();
        /*
             // TODO add your handling code here:
        JFrame logframe = new JFrame("Logs");
        globalLogFrame=logframe;
        JPanel logpanel = new JPanel();
        logpanel.setLayout(new FlowLayout());
       jInternalFrame3.setVisible(false);
       JInternalFrame jInternalFrameX = new JInternalFrame();
        jInternalFrameX.setSize(new Dimension(500,500));
        jTextArea2.setSize(new Dimension(300,300));
       jInternalFrameX.add(jButton5);
        jInternalFrameX.add(jButton6);
         jInternalFrameX.add(jTextArea2);

         
           
           
           logpanel.add(jInternalFrameX);
         
         logframe.add(logpanel);
        logframe.setSize(550,550);
        logframe.setLocationRelativeTo(null);
        logframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        logframe.setAlwaysOnTop(true);
        logframe.setVisible(true);
        logpanel.setVisible(true);
          jInternalFrameX.setVisible(true);
            
         
        if(logframe.isVisible()){
            jButton7.setVisible(false);
        }
        */
    }//GEN-LAST:event_jButton7ActionPerformed

    
    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed


     if(jRadioButtonMenuItem1.isSelected()){
         radioSetForAutoReconnect=1;
         jRadioButtonMenuItem1.setText("(ON) Always Reconnect After a Tag Modify Action");
     }else{
          radioSetForAutoReconnect=0;
          jRadioButtonMenuItem1.setText("(OFF) Always Reconnect After a Tag Modify Action");
     }




        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        
        
       if(popupStatus==true){
           this.setVisible(false);
       
        /////////
        int lastWarningDialogBeforeWriteLogsinTextAction = JOptionPane.showConfirmDialog(
            null ,"You are about to export your current logs as a txt file into the folder where this program runs. Do you approve?","IMPORTANT", JOptionPane.YES_NO_OPTION);

        if(lastWarningDialogBeforeWriteLogsinTextAction == JOptionPane.YES_OPTION){
 
            JOptionPane.showMessageDialog(null, "operation Started");
            
            
            
            
            
            /////create and write into text file (file name will have a unique id)
            //
            //
            //
                      String file_name=null;
      try {

        String dateTimeForFileNameClean=dateTimeForFileName.replaceAll(":","-");
          file_name="Logs-"+dateTimeForFileNameClean+".txt";
          System.out.println("creating file named: "+file_name);
          jTextArea2.append("\ncreating file named: "+ file_name+ "                                     "+dateTimeForFileName+" \n");
          File file = new File(file_name);
          file.createNewFile();
            FileWriter fileWriter1 = new FileWriter(file_name);
                      System.out.println("writing into file named: "+file_name);
jTextArea2.append("\n writing into file named:  "+file_name+"                                 "+dateTimeForFileName+" \n");
      fileWriter1.write(jTextArea2.getText() );
      fileWriter1.close();
      } catch (FileNotFoundException ex) {
          Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
      }
      
 
             
             
    
              
            
            
            //
            //
            //
            ///////////////////////////////////////////////////////////////////////
            
            this.setVisible(true);
    
        }
        
        
        
        else{
            JOptionPane.showMessageDialog(null, "Exporting logs operation has been cancelled safely.");
            System.out.println("operation cancelled.");
               if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+"operation cancelled." +"                         "+dateTimeForFileName+" \n" );
                }
            this.setVisible(true);
        }        // TODO add your handling code here:
        
        
        
        
        }
       else{
                       
            
            /////create and write into text file (file name will have a unique id)
            //
            //
            //
                      String file_name=null;
      try {

        String dateTimeForFileNameClean=dateTimeForFileName.replaceAll(":","-");
          file_name="Logs-"+dateTimeForFileNameClean+".txt";
          System.out.println("creating file named: "+file_name);
          jTextArea2.append("\ncreating file named: "+ file_name+ "                              "+dateTimeForFileName+" \n");
          File file = new File(file_name);
          file.createNewFile();
            FileWriter fileWriter1 = new FileWriter(file_name);
                      System.out.println("writing into file named: "+file_name);
jTextArea2.append("\n writing into file named:  "+file_name+"                           "+dateTimeForFileName+" \n");
      fileWriter1.write(jTextArea2.getText() );
      fileWriter1.close();
      } catch (FileNotFoundException ex) {
          Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
      }
      
 
             
             
    
              
            
            
            //
            //
            //
            ///////////////////////////////////////////////////////////////////////
      
 
             
             
    
              
            
            
            //
            //
            //
            ///////////////////////////////////////////////////////////////////////
       }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    if(popupStatus==true){
       
    popupStatus=false;
    
    jMenuItem6.setText("Turn-on Action Approval Popups"); 
    }
    else{
            popupStatus=true;
jMenuItem6.setText("Turn-off Action Approval Popups"); 
    }
    

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextArea2.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //
        if(jInternalFrame1.isVisible()==true || jInternalFrame2.isVisible()==true){
            jLabel29.setEnabled(true);
            jTextArea1.setEnabled(true);
            jLabel29.setVisible(true);
            jTextArea1.setVisible(true);jScrollPane1.setEnabled(true);
            jScrollPane1.setVisible(true);
        } //

        if(popupStatus==true){

            // TODO add your handling code here:

            this.setVisible(false);

            /////////

            Object[] buttons={"YES, CHANGE THE TAG!","NO! CANCEL!"};

            int lastWarningDialogBeforeWriteAction = JOptionPane.showOptionDialog(

                null, "You are about to CHANGE THE VALUES of the tag you selected. This action can NOT be undone. Are you sure to CHANGE this tag?",
                "IMPORTANT LAST WARNING!", JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE, null,     buttons,   buttons[0]);

            if(lastWarningDialogBeforeWriteAction == JOptionPane.YES_OPTION){

                //////

                jLabel28.setVisible(false);
                jTextField20.setVisible(false);   jLabel32.setVisible(false);   jLabel17.setVisible(false);   jTextField22.setVisible(false);
                jLabel31.setVisible(false);   jComboBox26.setVisible(false);   jTextField25.setVisible(false);   jLabel34.setVisible(false);
                jButton1.setVisible(false);   jTextField6.setVisible(false);   jLabel10.setVisible(false);   jLabel11.setVisible(false);   jLabel12.setVisible(false);
                jLabel13.setVisible(false);   jTextField7.setVisible(false);   jTextField9.setVisible(false);   jComboBox1.setVisible(false);   jTextField26.setVisible(false);
                jLabel35.setVisible(false);   jTextField27.setVisible(false);   jLabel36.setVisible(false);   jSeparator2.setVisible(false);
                jTextField11.setVisible(false);   jTextField12.setVisible(false);   jLabel16.setVisible(false);   jLabel14.setVisible(false);   jTextField14.setVisible(false);
                jLabel15.setVisible(false);
                jComboBox23.setVisible(false);   jTextField19.setVisible(false);   jLabel27.setVisible(false);   jComboBox25.setVisible(false);

                ///////
                JOptionPane.showMessageDialog(null, "Changing tag operation Started, find the results in the status box.");

                try {
                    if(jTextField36.getText().length()!=0 && jTextField35.getText().length()!=0 &&  jTextField34.getText().length()!=0 &&  jTextField29.getText().length()!=0  ){
                        changeTagAction();
                    }else{
                        this.setVisible(false);

                        final JOptionPane successPaneitself = new JOptionPane("Ops! You can not leave a blank box!");
                        final JDialog dialogOfSuccess = successPaneitself.createDialog(null,"INFORMATION MESSAGE");
                        Timer timer1= new Timer(2000, new ActionListener(){

                            @Override
                            public void actionPerformed(ActionEvent arg0){
                                dialogOfSuccess.dispose();
                            }

                        });

                        timer1.start();
                        dialogOfSuccess.setVisible(true);
                        dialogOfSuccess.dispose();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.setVisible(true);

                if(radioSetForAutoReconnect==1){
                    GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
                    PapiC2.show();
                    this.dispose();
                    jButton1.doClick();
                }

            }else{
                JOptionPane.showMessageDialog(null, "Changing tag operation has been cancelled safely.");
                System.out.println("operation cancelled.");
                if(jTextArea2.isEnabled()==true ){
                    jTextArea2.append("\n"+ "operation cancelled." +"    ////"+dateTimeForFileName+"////\n");
                }
                this.setVisible(true);
            }

            ////////

        }  else{
            try {
                if(jTextField36.getText().length()!=0 && jTextField35.getText().length()!=0 &&  jTextField34.getText().length()!=0 &&  jTextField29.getText().length()!=0  ){
                    changeTagAction();
                }else{
                    this.setVisible(false);

                    final JOptionPane successPaneitself = new JOptionPane("Ops! You can not leave a blank box!");
                    final JDialog dialogOfSuccess = successPaneitself.createDialog(null,"INFORMATION MESSAGE");
                    Timer timer1= new Timer(2000, new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent arg0){
                            dialogOfSuccess.dispose();
                        }

                    });

                    timer1.start();
                    dialogOfSuccess.setVisible(true);
                    dialogOfSuccess.dispose();
                }

            } catch (IOException ex) {
                Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.setVisible(true);
            if(radioSetForAutoReconnect==1){
                GUEST_ProjectAPIClient PapiC2= new GUEST_ProjectAPIClient();
                PapiC2.show();
                this.dispose();
                jButton1.doClick();
            }

        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36ActionPerformed

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////
         ///////*************/////////////////////

    
   ////
    

     //////BEFORE THE LAST DROPDOWN COMBOBOX SETTINGS////////
 
    public int beforeTheLastComboBox(){
     jComboBox25.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evnt){
                     String adminName = jTextField6.getText();
                     String passWord = jTextField7.getText();
                   JComboBox jComboBox25 = (JComboBox) evnt.getSource() ;
                     
                    Object selectedItem = jComboBox25.getSelectedItem();
                    String selected25toSTR = selectedItem.toString();
                    selected25toSTRGLBL = selected25toSTR;
                    String ip_and_port= jTextField9.getText();
                    String connectionURLGetDeviceInfo = "http://"+ip_and_port+"/config/v1/project/channels/"+jComboBox23.getSelectedItem().toString()+"/devices/"+selectedItem.toString();
                    
                    HttpClient clientGetDeviceInfo = HttpClient.newHttpClient();
                    HttpRequest requestGetDeviceInfo = (HttpRequest) HttpRequest.newBuilder()
                            .GET()
                            .header("accept", "application/json")
                    .uri(URI.create(connectionURLGetDeviceInfo))
                            .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
                            .build();
                    HttpResponse<String>responseGetDeviceInfo ;
                     
                    
                    
                    try {
                       responseGetDeviceInfo = clientGetDeviceInfo.send(requestGetDeviceInfo, HttpResponse.BodyHandlers.ofString());
                       String responseBody = responseGetDeviceInfo.body();
                       selected25toSTRGLBL = responseBody;
                        
                        System.out.println("\nRESPONSE: /JSON: "+responseBody+"*****END of response\n");
                            if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\nRESPONSE: /JSON: "+responseBody+"*****END of response\n" +"                    "+dateTimeForFileName+" \n");
                }
                        if(responseBody.contains("\"servermain.DEVICE_STATIC_TAG_COUNT\": ")){
                          int indexOfTAGCOUNT= responseBody.indexOf("\"servermain.DEVICE_STATIC_TAG_COUNT\": ");
                          int beginningIndexOfNumericValue=indexOfTAGCOUNT+38;
                          String afterTheIdentifierWholeRestX= responseBody.substring(beginningIndexOfNumericValue, responseBody.length());
                          String afterTheIdentifierWholeRest = afterTheIdentifierWholeRestX.substring(0,afterTheIdentifierWholeRestX.indexOf(","));
                          System.out.println("\n***************************"+afterTheIdentifierWholeRest+"---->number of tags inside particular device****\n");
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n***************************"+afterTheIdentifierWholeRest+"---->number of tags inside particular device****\n" +"                     "+dateTimeForFileName+" \n");
                }
                            
                           jTextField19.setText(afterTheIdentifierWholeRest);
                          
                        }
                        
                 
                      
                    
                    }catch (InterruptedException | IOException ex) {
                        Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
        
                   
                    ////write into the last combo box ///
              
        
                   
                    ////write into the last combo box ///
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                 activateTAGCOMBOBOX();
        
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    ////////write into the last combo...
                    
                    
                    
                    
                    
                    
                }
            });



     return 0;
 }
 
             ///end of///BEFORE THE LAST DROPDOWN COMBOBOX SETTINGS////////
                 ///end of///BEFORE THE LAST DROPDOWN COMBOBOX SETTINGS////////
             ///end of///BEFORE THE LAST DROPDOWN COMBOBOX SETTINGS////////

 
 
 
 ////****** ***** LAST COMBO BOX **** ***** ////
  ////****** ***** LAST COMBO BOX **** ***** ////
  ////****** ***** LAST COMBO BOX **** ***** ////
 
 
 public int activateTAGCOMBOBOX(){
     
      String adminName = jTextField6.getText();
                     String passWord = jTextField7.getText();
                  
                    Object selectedItem = jComboBox25.getSelectedItem();
                    String ip_and_port= jTextField9.getText();
           
                         
                    String connectionURLGetDeviceTAGInfo = "http://"+ip_and_port+"/config/v1/project/channels/"+jComboBox23.getSelectedItem().toString()+"/devices/"+selectedItem.toString()+"/tags";
                    
                    HttpClient connectionURLGetDeviceTAGInfoCLIENT = HttpClient.newHttpClient();
                    HttpRequest connectionURLGetDeviceTAGInfoREQ = (HttpRequest) HttpRequest.newBuilder()
                            .GET()
                            .header("accept", "application/json")
                    .uri(URI.create(connectionURLGetDeviceTAGInfo))
                            .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
                            .build();
                    HttpResponse<String>responseGetDeviceInfofortags ;
                     
                    
                    
                    try {
                       responseGetDeviceInfofortags = connectionURLGetDeviceTAGInfoCLIENT.send(connectionURLGetDeviceTAGInfoREQ, HttpResponse.BodyHandlers.ofString());
                       String responseBody = responseGetDeviceInfofortags.body();
                        
                        System.out.println("\n\n\nRESPONSE: /JSON: "+responseBody+"*****END of response\n\n\n");
                         
                          if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+"\n\n\nRESPONSE: /JSON: "+responseBody+"*****END of response\n\n\n"  +"                    "+dateTimeForFileName+" \n");
                }
                         //Your task is to identify tag names from this string 
                         
                         Pattern pattern1 = Pattern.compile("(\\\"common.ALLTYPES_NAME\": \"(?:\\\"??[^\\\"]*?\\\",))");     // REGEX
                         Matcher matcher1 = pattern1.matcher(responseBody);   // kepserex response JSON
                         
                         
                         while(matcher1.find()){
                             System.out.println("****List of TAGS retrieved from JSON response: "+matcher1.group());
                                if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "****List of TAGS retrieved from JSON response: "+matcher1.group() +"                  "+dateTimeForFileName+" \n");
                }
                             tagNamesHolder.add(matcher1.group());  
                         }
                         
                         String matcherisString = tagNamesHolder.toString();
                         
                         
                          String cleaning1 =matcherisString.replaceAll("common.ALLTYPES_NAME\": \"","");
                         
                          String cleaning2 =cleaning1.replaceAll("\"","");
                          String cleaning3 = cleaning2.replaceAll(",","\n");
                          System.out.println(cleaning3);
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ cleaning3 +"                   "+dateTimeForFileName+" \n");
                }
                          //
                          //
                          //
                          //
                          
                          ///////ccccccc---ERROR TRYING TO ADD TAG NAMES INTO COMBOBOX!///////
                         String cleaningEXTRA = cleaning2.replaceAll(",","#&");
                          tagNamesHolder.clear();
                                                System.out.println("\n\n\n\n\n cleaningEXTRA reminder: --> "+cleaningEXTRA+"\n\n\n\n\n");
   if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\n\n\n\n cleaningEXTRA reminder: --> "+cleaningEXTRA+"\n\n\n\n\n" +"                          "+dateTimeForFileName+" \n");
                }
                                 int x2 = StringUtils.countMatches(cleaningEXTRA, "#&");
                                  for(int i=0;i<x2;i++){
                                      xc2 = cleaningEXTRA.split("#&");
                                      if(i<=cleaningEXTRA.length()){
                                          tagNamesHolder.add(xc2[i]);
                                      }
                                           
                                         
                                  }
                         
                          System.out.println("\n---tagNamesHolder.toString()-->>>>> B1.0---->"+tagNamesHolder.toString());   //B1.0 means control for Bug number 1.0 of bugs regarding this
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n---tagNamesHolder.toString()-->>>>> B1.0---->"+tagNamesHolder.toString() +"                         "+dateTimeForFileName+" \n");
                }
                          System.out.println("\n--Arrays.toString(xc2)--->>>>> B1.1---->"+Arrays.toString(xc2));     //B1.1 means control for Bug number 1.0 of bugs regarding this
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n--Arrays.toString(xc2)--->>>>> B1.1---->"+Arrays.toString(xc2) +"                        "+dateTimeForFileName+" \n");
                }
                          String gettagstring;
                          for(int i=0; i < tagNamesHolder.size();i++){
                             gettagstring= tagNamesHolder.get(i);
                              
                              if(gettagstring.equals("")){
                                  tagNamesHolder.remove(i);
                              }
                              
                          }
                          
                          for(int i=0;i<tagNamesHolder.size()-(tagNamesHolder.size()-1);i++){
                              gettagstring= tagNamesHolder.get(i);
                              
                              if(gettagstring.contains("[")){
                                  tagNamesHolder.remove(i);
                                  tagNamesHolder.add(0,gettagstring.replace("[", ""));
                                  
                              }
                          }
                       
                         jComboBox26.removeAllItems();
                          
                          
                          int ii=0;
          for (String i : tagNamesHolder) {
              
              jComboBox26.addItem(tagNamesHolder.get(ii));
              ii++;
          }                     //
          if(jInternalFrame1.isVisible()==true || jInternalFrame2.isVisible()==true){
              
         
  jLabel29.setEnabled(true); 
 jTextArea1.setEnabled(true);
   jLabel29.setVisible(true); 
   jScrollPane1.setEnabled(true);
jScrollPane1.setVisible(true); 
 jTextArea1.setVisible(true);
 } //
         selected25toSTRGLBL= tagNamesHolder.toString();
          tagNamesHolder.clear();
          ii=0;
                         /// 
                         //
                         //
                         //
                         //
          
          
               jComboBox26.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evnt){
                     // 
                     jMenuItem3.setEnabled(true); jMenuItem4.setEnabled(true); jMenuItem5.setEnabled(true);
                     if(jInternalFrame1.isVisible()==true || jInternalFrame2.isVisible()==true){
  jLabel29.setEnabled(true); 
 jTextArea1.setEnabled(true);
   jLabel29.setVisible(true); 
 jTextArea1.setVisible(true);
 jScrollPane1.setEnabled(true);
jScrollPane1.setVisible(true); 
 //
                }                   
                  JComboBox jComboBox26 = (JComboBox) evnt.getSource();
                    Object selectedItem = jComboBox26.getSelectedItem();
                    jTextField20.setText((String) selectedItem);
                    jLabel43.setText( "Your Selected Tag is: " + selectedItem);
                    
                    if(jTextField20.getText().length()>0){
                        jButton9.setEnabled(true);
                        jButton10.setEnabled(true);
                        jButton8.setEnabled(true);
                        jLabel29.setEnabled(true);
                        jLabel37.setEnabled(true);
                        jLabel38.setEnabled(true);
                        jLabel39.setEnabled(true);
                        jLabel41.setEnabled(true);
                        jLabel42.setEnabled(true);
                        jLabel44.setEnabled(true);
                        jLabel45.setEnabled(true);
                        jLabel46.setEnabled(true);
                        jLabel40.setEnabled(true);
                        jTextArea1.setEnabled(true);
                        jTextField29.setEnabled(true);
                        jTextField28.setEnabled(true);
                        jTextField30.setEnabled(true);
                        jTextField31.setEnabled(true);
                        jTextField32.setEnabled(true);
                        jTextField33.setEnabled(true);
                        jTextField34.setEnabled(true);
                        jTextField35.setEnabled(true);
                        jTextField36.setEnabled(true);
                        jTextArea1.setEnabled(true);
                        jButton4.setEnabled(true);
                    }
                    
                     
                  ////MAKING AN API CALL TO GET DETAILS OF TAG! ----START
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
          
               
               
               
               
               
                String tagNameZ = jTextField20.getText().replaceAll(" ", "");
             String connectionURL = "http://"+ip_and_port+"/config/v1/project/channels/"+jComboBox23.getSelectedItem().toString()+"/devices/"+jComboBox25.getSelectedItem().toString()+"/tags/"+tagNameZ;

               
               String statusX;
               
                  HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                
                
        .GET()
        .header("accept", "application/json")
              
        .uri(URI.create(connectionURL))
                 .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
        .build();
        HttpResponse <String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String tagCallResponse = response.body().toString();
            System.out.println("\n\n\n the repsonse from TAG API CALL:\n"+tagCallResponse+"\n\n\n");
            
               if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\n\n the repsonse from TAG API CALL:\n"+tagCallResponse+"\n\n\n" +"                          "+dateTimeForFileName+" \n");
                }
            
                     ///***get tag scan rate--start--//  full json = tagCallResponse
                          
                         Pattern pattern2 = Pattern.compile("(\\\"servermain.TAG_SCAN_RATE_MILLISECONDS\":(?:\\ ??[^\\\"]*?\\,))");     // REGEX
                         Matcher matcher2 = pattern2.matcher(tagCallResponse);   // kepserex response JSON (details of a particular tag)
                         
                         thisTagDetailHolder.clear();
                         while(matcher2.find()){
                             System.out.println("\n\n****List of DETAILS OF THIS TAG retrieved from JSON response: "+matcher2.group()+"\n\n");
                                if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\n****List of DETAILS OF THIS TAG retrieved from JSON response: "+matcher2.group()+"\n\n" +"                         "+dateTimeForFileName+" \n");
                }
                             thisTagDetailHolder.add(matcher2.group());  
                         }
                         
                         String matcherisString = thisTagDetailHolder.toString();
                         
                         
                          String cleaning1_2 =matcherisString.replaceAll("\"servermain.TAG_SCAN_RATE_MILLISECONDS\": ","");
                         
                          String cleaning2_2 =cleaning1_2.replaceAll("\"","");
                          String cleaning3_2 = cleaning2_2.replaceAll(",","\n");
                          String cleaning3_2_2 = cleaning3_2.replaceAll("\\[","");
                         String cleaning3_2_3 = cleaning3_2_2.replaceAll("\\]","");

                          System.out.println("\n\n\nyour tag scan rate is:"+cleaning3_2_3);
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\n\nyour tag scan rate is:"+cleaning3_2_3 +"                        "+dateTimeForFileName+" \n");
                }
                          jTextField25.setText(cleaning3_2_3);
                          
                          thisTagDetailHolder.clear();
                    ///***get tag scan rate--end--//
            
            
            
            
            
            
            
                      ///***get tag address --start--//full json = tagCallResponse
            Pattern patternQ = Pattern.compile("(\\\"servermain.TAG_ADDRESS\": (?:\\\"??[^\\\"]*?\\\",))");     // REGEX
                         Matcher matcherQ = patternQ.matcher(tagCallResponse);   // kepserex response JSON (details of a particular tag)
                         
                         thisTagDetailHolder.clear();
                         while(matcherQ.find()){
                             
                             thisTagDetailHolder.add(matcherQ.group());  
                         }
                         
                         String matcherisStringQ = thisTagDetailHolder.toString();
                         
                         
                          String cleaning1_2Q =matcherisStringQ.replaceAll("\"servermain.TAG_ADDRESS\": " ,   "");
                         
                          String cleaning2_2Q =cleaning1_2Q.replaceAll("\"","");
                          String cleaning3_2Q = cleaning2_2Q.replaceAll(",","\n");
                          String cleaning3_2_2Q = cleaning3_2Q.replaceAll("\\[","");
                         String cleaning3_2_3Q = cleaning3_2_2Q.replaceAll("\\]","");

                          System.out.println("\n\n\nyour tag ADDRESS is:"+cleaning3_2_3Q);
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\n\nyour tag ADDRESS is:"+cleaning3_2_3Q +"                         "+dateTimeForFileName+" \n");
                }
                          jTextField26.setText(cleaning3_2_3Q);
                          
                           thisTagDetailHolder.clear();
                     ///***get tag address --end--//
            
            
            
            
            
            
            
                     ///***get tag data type --start--//full json = tagCallResponse
                     Pattern patternW = Pattern.compile("(\\\"servermain.TAG_DATA_TYPE\":(?:\\ ??[^\\\"]*?\\,))");     // REGEX
                         Matcher matcherW = patternW.matcher(tagCallResponse);   // kepserex response JSON (details of a particular tag)
                         
                         thisTagDetailHolder.clear();
                         while(matcherW.find()){
                             
                             thisTagDetailHolder.add(matcherW.group());  
                         }
                         
                         String matcherisStringW = thisTagDetailHolder.toString();
                         
                         
                          String cleaning1_2W =matcherisStringW.replaceAll("\"servermain.TAG_DATA_TYPE\": ","");
                         
                          String cleaning2_2W =cleaning1_2W.replaceAll("\"","");
                          String cleaning3_2W = cleaning2_2W.replaceAll(",","\n");
                          String cleaning3_2_2W = cleaning3_2W.replaceAll("\\[","");
                         String cleaning3_2_3W = cleaning3_2_2W.replaceAll("\\]","");

                          System.out.println("\n\n\nyour tag ADDRESS is:"+cleaning3_2_3W);
                             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n\n\nyour tag ADDRESS is:"+cleaning3_2_3W +"                              "+dateTimeForFileName+" \n");
                }
                          jTextField27.setText(cleaning3_2_3W);
                          
                           thisTagDetailHolder.clear();
                      ///***get tag data type --end--//
            
            
             statusX="";
             
                 var statuscode= response.statusCode();
            if(statuscode==200){
                statusX="connected (200 OK)";
                jTextField11.setText(statusX);
                

            }  else{
                statusX="failed, reason: server didn't return 200 OK";
                                jTextField11.setText(statusX);

            }

            
        }catch (IOException ex){
            throw new RuntimeException(ex); 
         }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

        
       if(!"connected (200 OK)".equals(statusX)){
            if(!"failed, reason: server didn't return 200 OK".equals(statusX)){
                jTextField11.setText("failed");
             }
           
        } 
               
               
               
               
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////                                                 ////
               ////MAKING AN API CALL TO GET DETAILS OF TAG! ----END
                              
                }
                });
          
                
               
               
               
                          
               

          //add them into the combo box correctly.
          //after that we will create another action listener outside of here to listen to selection of there too.
                      
                    
                    }catch (InterruptedException | IOException ex) {
                        Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
                    
                    
     return 0;
 }
 
 
 
 
  ////****** ***** END OF LAST COMBO BOX **** ***** ////
  ////****** ***** END OF LAST COMBO BOX **** ***** ////
  ////****** ***** END OF LAST COMBO BOX **** ***** ////
 

    //
 
 //
 
 
 //
 

    
    /*public int jumpToChannelETCModifiers(String channelInputValue){
        
        channelInputValue = jTextField8.getText();
                
        
        return 0;
    }
 */
    public static boolean isInteger(String stringValueOfNum){
        if(stringValueOfNum==null){
            return false;
        }
        
        
        
        try {
            int integer = Integer.parseInt(stringValueOfNum);
        }
        
        
        
        
        catch(NumberFormatException numEx){
            return false;
        }
        
        
        
    return true;
    }
    
    
    public int getProjectID(){
         String indexIdentifier1="PROJECT_ID\": ";
        String indexIdentifier2=",\n" +
"		\"common.ALLTYPES_NAME";
        
        
        if(StringUtils.countMatches(jsonResponseGlobal,indexIdentifier1)>0){
            System.out.println("countMatches = >0 for projectID indexIdentifier1");
               if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "countMatches = >0 for projectID indexIdentifier1" +"                         "+dateTimeForFileName+"\n");
                }
            if(StringUtils.countMatches(jsonResponseGlobal,indexIdentifier2)>0){
                System.out.println("countMatches = >0 for projectID indexIdentifier2");
                   if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "countMatches = >0 for projectID indexIdentifier2" +"                        "+dateTimeForFileName+" \n");
                }
                
                
                
                      int indexOfProjectID = jsonResponseGlobal.indexOf(indexIdentifier1);
        
        int indexOfEndofProjectID = jsonResponseGlobal.indexOf(indexIdentifier2);
        
                String resultIDpre= jsonResponseGlobal.substring(indexOfProjectID,indexOfEndofProjectID);
                String resultID=resultIDpre.replaceAll("[^0-9]","");
        System.out.println(resultID);
           if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+resultID +"                       "+dateTimeForFileName+" \n" );
                }
        jTextField14.setText(resultID);
        
        
        
        
            }
        }else{
            System.out.println("countMatches = 0 for projectID");
               if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "countMatches = 0 for projectID" +"                       "+dateTimeForFileName+"\n");
                }
        }

        jsonResponseGlobal="";
         
        
       return 0;
    }
    
    
    public int clickedConnect() throws JSONException{
        
    
        
        
        

       
       
        String statusX="";
        String adminName = jTextField6.getText();
        String passWord = jTextField7.getText();
        if(jTextField7.getText().length()<1){
            passWord="";
        }
        String ip_and_port = jTextField9.getText();
        String connectionURL="http://"+ip_and_port+"/config/v1/admin";
        
        
       
        ///////////////////////////////////////////
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                
                
        .GET()
        .header("accept", "application/json")
              
        .uri(URI.create(connectionURL))
                 .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
        .build();
        HttpResponse <String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body().toString();
            
             statusX="";
                 var statuscode= response.statusCode();
            if(statuscode==200){
                statusX="connected (200 OK)";
                jTextField11.setText(statusX);
                //////get JSON Details
             
                
                 getChannel();
                 
   
                
                //jumpToChannelETCModifiers();
                ///end

            }  else{
                statusX="failed, reason: server didn't return 200 OK";
                                jTextField11.setText(statusX);

            }

            
        }catch (IOException ex){
            throw new RuntimeException(ex); 
         }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

        
       if(!"connected (200 OK)".equals(statusX)){
            if(!"failed, reason: server didn't return 200 OK".equals(statusX)){
                jTextField11.setText("failed");
            return 0; 
            }
           
        }    
        
        ///////////////////////////////////////////
        return 0;
    }
    

    /*public int putThingsIntoNewComboBox(){
        
        
        
        
        
        return 0;
    } */ boolean triggerunderstander=false;
     public int getChannel(){   
    
        String adminName = jTextField6.getText();
        String passWord = jTextField7.getText();
        String ip_and_port = jTextField9.getText();
        String connectionURL="http://"+ip_and_port+"/config/v1/project/channels";
        
                HttpClient client = HttpClient.newHttpClient();
     HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                
                
        .GET()
        .header("accept", "application/json")
              
        .uri(URI.create(connectionURL))
                 .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
        .build();
        HttpResponse <String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
             json = response.body().toString();
             jsonResponseGlobal=json;
                 var statuscode= response.statusCode();
                 getProjectID();
            if(statuscode==200){
               
                //////get JSON Channel Count
                   channelCount = StringUtils.countMatches(json, "\"PROJECT_ID\":");
                  jTextField12.setText( ""+channelCount);
                  
                  ///////////////////////////////////
                   
                  /////get JSON channel names in a list /*
                  
                    ChannelNameGetterTemplate="";
                     tillEndPoint="";
                    intOfChannelTagSlotName= json.indexOf("\"common.ALLTYPES_NAME\": \"");
                    intOfClosingSymbolsForTagSlotName=json.indexOf("\",");
                 
                   
                                  ////-------**********************************-------------////////////
          

                  
                      
                    
                    /* ArrayList<String> ChannelNames = new ArrayList<> (); 
                  
                  for(int i=0;i<channelCount;i++){
                      
                   ChannelNames.add(ChannelNameGetterTemplate);
                   
                   int newStartingPoint = json.indexOf(ChannelNameGetterTemplate.length()+2);   //puts starting point to the end of the radius of previous channel name
                    String deletingSection = json.substring(0,newStartingPoint);
                    System.out.println(deletingSection);
                      String replace = json.replace(deletingSection,""); //delete everything until the newStartingPoint
                        
                 } 
                  */
                 // System.out.println(ChannelNames.get(5));
                  
                 //jComboBox23.addItem("");
                 
                  
               
                ///end
                
                
                
                
                /*for(int i=0;i<x;i++){
                    putToDropDown();
                }*/
                int x = StringUtils.countMatches(json, "\",");
                 for(int i=0;i<x;i++){
                     String[] xc = json.split("\",");
                         splittedX.add(xc[i]);
                         
                         
                 }
                 
                for (int i = 0;i<splittedX.size();i++) {
                    boolean xxz = splittedX.get(i).contains("\"common.ALLTYPES_NAME\": \"");
                    if(xxz==true){
                        splittedSmart.add(splittedX.get(i));
                    }  
                    
                    
                }
                
                
                
                String eachString="";
                int endOfTheElementLength;
                int indexOfCommonDot;
                String substringForTagName="";
                
                
                
               
                
                  for(int i = 0; i<splittedSmart.size();i++){
                      
                     
               
                      eachString= splittedSmart.get(i);
                      
                      
                          indexOfCommonDot = eachString.indexOf("\"common.ALLTYPES_NAME\": \"");
                          endOfTheElementLength=  eachString.length();
                          substringForTagName = eachString.substring(indexOfCommonDot+25,  endOfTheElementLength);
                       
                          jComboBox23.addItem(substringForTagName);
                  System.out.println(substringForTagName);
                   if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ substringForTagName +"                          "+dateTimeForFileName+" \n");
                }
                 
                }
                 
               int indexofdot=0;
                jComboBox23.removeItemAt( indexofdot);
                
                
            beforeTheLastComboBox();
            
            }  else{
                 String statusX="failed, reason: server didn't return 200 OK";
                                jTextField11.setText(statusX);
            }

            
            ///////COMBOBOX EVENT LISTENERS  IF CHANNEL NAME IS SELECTED FROM DROPDOWN ---> DISPLAYS THE CURRENT TOTAL TAG COUNT OF CHANNEL
                       /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////

            
            
            jComboBox23.addActionListener(new ActionListener(){
            
                
          
                @Override
                public void actionPerformed(ActionEvent evnt){
                     if(true){
                        jLabel15.setEnabled(true);
                            jTextField19.setEnabled(true); 
                            
                           jLabel27.setEnabled(true); 
                                   jLabel28.setEnabled(true);
                                   jTextField20.setEnabled(true);
                                           jTextField22.setEnabled(true); 
                                           jComboBox25.setEnabled(true); 
                                                   jComboBox26.setEnabled(true);
                                                   jLabel31.setEnabled(true); 
                                                           jLabel32.setEnabled(true); 
                                                           jTextField25.setEnabled(true);
                            
                                                                   jLabel34.setEnabled(true);
                                                                   jLabel35.setEnabled(true); 
                                                                           jTextField26.setEnabled(true);
                                                                           jTextField27.setEnabled(true);
                                                                                   jLabel36.setEnabled(true);
                    } 
                                                                                   
                    
                    deviceHolder.clear();
                    
                    
                    
                    
                /*    ///SHOW WARNING POP-UP ////START
                        if (triggerunderstander == false) {

        JOptionPane optionPane = new JOptionPane();

        optionPane.setMessage(""
                + "VERY IMPORTANT NOTE: \nWhen selecting an item from the \"Select Device\" dropdown menu,"
                + " \nyour first selection may not return anything. In this case, select it once more."
                + "\nThis also applies to your first selection."
                + "\nThank You.");
        optionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
        optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(null, "VERY IMPORTANT REMINDER");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        triggerunderstander = true;

      }
                ///SHOW WARNING POP-UP ////END        
                        
                               
                
                */
                
                
                
                
                
                //MAKE HTTPREQUEST FOR SELECTED KEPSERVER DEVICE////START
                    
                    JComboBox jComboBox23 = (JComboBox) evnt.getSource();
                    Object selectedItem = jComboBox23.getSelectedItem();
                    
                    String connectionURL2 = "http://"+ip_and_port+"/config/v1/project/channels/"+selectedItem.toString()+"/devices";
                    
                    HttpClient client2 = HttpClient.newHttpClient();
                    HttpRequest request2 = (HttpRequest) HttpRequest.newBuilder()
                            .GET()
                            .header("accept", "application/json")
                    .uri(URI.create(connectionURL2))
                            .header("Authorization", getBasicAuthenticationHeader(adminName, passWord))
                            .build();
                    HttpResponse<String> response3322;
                    
                    //MAKE HTTPREQUEST FOR SELECTED KEPSERVER DEVICE////END
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    try {
                        
                      
                    
                  // for(int z=0; z<2;z++){
                      
                        ///response2 is our response from above call ----START
                        response3322 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
                        String response2 = response3322.body();
                        System.out.println(response2);
                           if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ response2 +"                          "+dateTimeForFileName+"\n");
                }
                        String response2Clone = response2;
                        ///response2 is our response from above call ----END
                        
                        
                        
                        
                        
                        
                        
         /// GET AND PRINT TAG COUNT INSIDE DEVICE --- START
         //////////////
                   if (response2.length() > 0) {

       int occurence445 = StringUtils.countMatches(response2, "\"servermain.DEVICE_STATIC_TAG_COUNT\": ");

       if (occurence445 == 1) {

           int getIndexOfThisOccurence = response2.indexOf("\"servermain.DEVICE_STATIC_TAG_COUNT\": ");
           String identifier = "\"servermain.DEVICE_STATIC_TAG_COUNT\": ";
           int getIndexOfTheEndingOfThisOccurence = getIndexOfThisOccurence + identifier.length();
           String substringStartingFromWhereWeIndexedOurEnding = response2.substring(getIndexOfTheEndingOfThisOccurence, response2.length());
           int indexOfEndComma = substringStartingFromWhereWeIndexedOurEnding.indexOf(",");
           String tagCountValueItself = substringStartingFromWhereWeIndexedOurEnding.substring(0, indexOfEndComma);
           System.out.println("Tag count is: " + tagCountValueItself);
              if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+  "Tag count is: " + tagCountValueItself+"                         "+dateTimeForFileName+" \n");
                }
           //jTextField13.setText(tagCountValueItself);

       }

       if (occurence445 > 1) {

           for (int i = 0; i < occurence445; i++) {

               int getIndexOfThisOccurence = response2.indexOf("\"servermain.DEVICE_STATIC_TAG_COUNT\": ");
               String identifier = "\"servermain.DEVICE_STATIC_TAG_COUNT\": ";
               int getIndexOfTheEndingOfThisOccurence = getIndexOfThisOccurence + identifier.length();
               String substringStartingFromWhereWeIndexedOurEnding = response2.substring(getIndexOfTheEndingOfThisOccurence, response2.length());
               int indexOfEndComma = substringStartingFromWhereWeIndexedOurEnding.indexOf(",");
               String tagCountValueItself = substringStartingFromWhereWeIndexedOurEnding.substring(0, indexOfEndComma);
               System.out.println("Tag count for one of the devices is: " + tagCountValueItself);
                  if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "Tag count for one of the devices is: " + tagCountValueItself +"                         "+dateTimeForFileName+" \n");
                }
               tagHolder.add(tagCountValueItself);
               response2 = substringStartingFromWhereWeIndexedOurEnding;

           }

           for (String str: tagHolder) {
               if (isInteger(str)) {
                   tagHolderINT.add(Integer.parseInt(str));
               }

               System.out.println(str);
           }

           sumofthem = tagHolderINT.stream()
               .mapToInt(a -> (int) a)
               .sum();

           System.out.println(sumofthem);
   if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+sumofthem +"                              "+dateTimeForFileName+" \n" );
                }
          // jTextField13.setText(Integer.toString(sumofthem));

           tagHolderINT.clear();
           tagHolder.clear();

       }
       //////////////
     /// GET AND PRINT TAG COUNT INSIDE DEVICE --- END
                               
                                 
                               
                               
                               
                               
                               
                               
                               
                               
                               
                      /////get PROJECT_ID occurence count and put it as device count into jTextField---START
                     int countMatch = StringUtils.countMatches(response2Clone, "\"PROJECT_ID\":");  
                        System.out.println(" counted number of devices in this channel are:  "+countMatch);
                           if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ " counted number of devices in this channel are:  "+countMatch +"                        "+dateTimeForFileName+" \n");
                }
                      jTextField22.setText(String.valueOf(countMatch));
                      ////get PROJECT_ID occurence count and put it as device count into jTextField ---END
                      
                               
                      
                      
                      
                      
                      
                      
                      System.out.println("***RESPONSE2CLONE******"+response2Clone+"************");
                        
                         if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+" ***RESPONSE2CLONE******"+response2Clone+"************" +"                        "+dateTimeForFileName+" \n");
                }
                      
                      
                      
                      
                      
                      
                      
                      
                       int indexOf_xyz;
                       String valueWEwant="";
                       String identifyxyz= "\"common.ALLTYPES_NAME\": \"";
                        String response2CloneSUB;
                            int indexOfValueWeWantsEND;
                             
                     for(int i=0;i<countMatch;i++){
                           
                          if(response2Clone.length()>0 && StringUtils.countMatches(response2Clone, "ommon.ALLTYPES_DESCR")>1 ){
                              
                          
                         
                          indexOf_xyz = response2Clone.indexOf("\"common.ALLTYPES_NAME\": \""); //bunu bul
                             valueWEwant = response2Clone.substring(indexOf_xyz + identifyxyz.length() , response2Clone.indexOf("\",\n" +
"		\"common.ALLTYPES_DESCRIP")); //onun degerini cek
                             indexOfValueWeWantsEND= response2Clone.indexOf(valueWEwant)+valueWEwant.length();
                             response2CloneSUB= response2Clone.substring(indexOfValueWeWantsEND , response2Clone.length()-indexOfValueWeWantsEND ); //ona kadarkileri sil
                              
                             if(response2CloneSUB.length()>1){
                                 response2Clone=response2CloneSUB.substring(response2CloneSUB.indexOf("FROM_CACHE"),response2CloneSUB.length());
                             }
                             if(valueWEwant.length()>0){
                                      deviceHolder.add(valueWEwant); //bu degeri Array'e ekle
                                       System.out.println(valueWEwant + "..... activated because we have more than 1 device ");
                                          if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+  valueWEwant + "..... activated because we have more than 1 device "+"                 "+dateTimeForFileName+"\n");
                }
                                       System.out.println("\n^^^^^^^^^^^^^^"+response2Clone+"^^^^^^^^^^\n");
                                          if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n^^^^^^^^^^^^^^"+response2Clone+"^^^^^^^^^^\n" +"                  "+dateTimeForFileName+" \n"+"                        "+dateTimeForFileName+" \n");
                }
                                   }  
                             
                         }
                          
                          
                           
                          
                          
                      } 
                      
                      
                      for(int i=0;i<countMatch;i++){
                                            /******************************/
                          
                          
                          if(response2Clone.length()>0 && StringUtils.countMatches(response2Clone, "\"common.ALLTYPES_NAME\": \"")<2 && StringUtils.countMatches(response2Clone, "\"common.ALLTYPES_NAME\": \"")>0){
                              
                //if there is only 1 tag
                         
                 indexOf_xyz = response2Clone.indexOf("\"common.ALLTYPES_NAME\": \""); //bunu bul
               valueWEwant = response2Clone.substring(indexOf_xyz + identifyxyz.length() , response2Clone.indexOf("\",\n" +
"		\"common.ALLTYPES_DESCRIP")); //onun degerini cek
             indexOfValueWeWantsEND= response2Clone.indexOf(valueWEwant)+valueWEwant.length();
              response2CloneSUB= response2Clone.substring(indexOfValueWeWantsEND , response2Clone.length()-indexOfValueWeWantsEND ); //ona kadarkileri sil
                              
                    if(response2CloneSUB.length()>1){
                                 response2Clone=response2CloneSUB;
                             }
                      if(valueWEwant.length()>0){
                                       deviceHolder.add(valueWEwant); //bu degeri Array'e ekle
                          System.out.println(valueWEwant + "..... activated because we have less than 2 devices ");
                                        if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ valueWEwant + "..... activated because we have less than 2 devices " +"                         "+dateTimeForFileName+" \n");
                }  
                                   }  
                             
                         }
                          
                          
                          /*******/
                      }
                      
                      System.out.println("\n *DEVICE NAMES IN CURRENT CHANNEL: "+deviceHolder+"*********\n");
                         if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ "\n *DEVICE NAMES IN CURRENT CHANNEL: "+deviceHolder+"*********\n" +"                          "+dateTimeForFileName+" \n");
                }
                            //add to dropdown
                       
                     jComboBox25.removeAllItems();
                                         for (int i = 0; i < deviceHolder.size(); i++) {
                                
                                jComboBox25.addItem(deviceHolder.get(i));
                                 }
                                         
                                         
                                 
                              
                           // putThingsIntoNewComboBox();
                       
                       
         
                  
                  
                      /////////
                        
                    }
                    
                     
                    
                     
                  // }
                    
                    
                    }catch (InterruptedException | IOException ex) {
                        Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
        
                   
                    
                    
                }
                
                 
                    
                    
            });
            
        
       
            /////////////xxxxx///////////////
                        /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////
            /////////////xxxxx///////////////

            
        }catch (IOException ex){
            throw new RuntimeException(ex); 
         }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
        
        return 0;
   
    }
 
     
     
      public int putTagsIntoDropDown(){
          
          System.out.println(tagHolderStrings + "this is perma");
             if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ tagHolderStrings + "this is perma"+"                        "+dateTimeForFileName+" \n" );
                }
          for(int i=0;i<tagHolderStrings.size();i++){
              
              System.out.println(tagHolderStrings.get(i));
                 if(jTextArea2.isEnabled()==true ){
                  jTextArea2.append("\n"+ tagHolderStrings.get(i) +"                      "+dateTimeForFileName+" \n");
                }
          }
          
         return 0;
     }
    
     
     
     public int putToDropDown()  {
     /*          

          if (json.contains("\"common.ALLTYPES_NAME\": \"")) {
               

    ChannelNameGetterTemplate = json.substring(intOfChannelTagSlotName + 25, intOfClosingSymbolsForTagSlotName + 1);  //return channel name (like "Bender")
       
    if(ChannelNameGetterTemplate.contains("\"")){
             ChannelNameGetterTemplate=ChannelNameGetterTemplate.replace("\"", ".");
            }
    jComboBox23.addItem(ChannelNameGetterTemplate); //add "bender" to comboBox
    channelList.add(ChannelNameGetterTemplate); //add "bender" to array
    
    
    

         if (json.contains(ChannelNameGetterTemplate)) { //if json has the newly found tag name
        
            tillEndPoint = json.substring(0,  json.indexOf(ChannelNameGetterTemplate)  ); //variable tillEndPoint = the part of json till the newly found tag name
            tillEndPoint = tillEndPoint + ChannelNameGetterTemplate + "\"\","; //variable tillEndPoint = the part of json till the newly found tag name + tag name + ",
            
         
            
             
             
            if(json.contains(tillEndPoint)){
                
                
                json = json.replace(tillEndPoint, "");   //json is now missing the tillEndPoint
                
                
            }
            
            
            else{
                System.out.println("TILL END POINT NOT FOUND");
            }
           
           
            
               
             }else{
             
             return 0;
         }
    
    
    
    
     }          




System.out.println(channelList);
         
               
         */       
     return 0;
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
            java.util.logging.Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUEST_ProjectAPIClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUEST_ProjectAPIClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox23;
    private javax.swing.JComboBox<String> jComboBox24;
    private javax.swing.JComboBox<String> jComboBox25;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables

  
}
