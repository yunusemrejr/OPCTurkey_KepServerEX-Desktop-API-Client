/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.opcturkey.kepserverexdesktopclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.awt.Color;
import static java.awt.Color.ORANGE;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.Timer;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author yunus
 */
public class GUEST_ReadAndWrite extends javax.swing.JFrame {
    int enablepop=0;
public String tagNameToWriteTo,
    newAssignedValue,IP_URL_x,WritingStatusString;
                                                ArrayList<String> splittedX= new ArrayList<>();
                                            ArrayList<String> splittedSmart= new ArrayList<>();
                                             ArrayList<String> tagNamesList= new ArrayList<>();
                                             
                                             
                                             private ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
                                             
 int checkcheckD=0;
               
      int toggle1=0;
    /**
     * Creates new form ReadAndWrite
     */      private BufferedImage icon1;
                                               ArrayList<String> CSVholder = new ArrayList<>();
                   String[] splittedOneRowArray;                                

     
     public void addActionListenerToIPbox(){
             jComboBox2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evnt){
                     
                  JComboBox jComboBox2 = (JComboBox) evnt.getSource();
                    Object selectedItem = jComboBox2.getSelectedItem();
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
                            
                            
                            String thisIsIP=fullStringContainingSelectedName.substring(startIndexOf_thisIsIP, endIndexOf_thisIsIP);
                  
                           
                        System.out.println("The IP/URL: "+thisIsIP);
                    
                       
                       
                       jTextField1.setText(thisIsIP);
                      /*
                        
                        
                        FIND SELECTED ITEM AS STRING'S ID [, , , ] IN THE ARRAY NAMED "CSVholder"
                        THEN AFTER YOU FIND THE LINE OF IT, SPLIT BY "," AND PLACE INTO USER OUTPUTS
                        CORRESPONDING VALUES.
                        
                        */
                        
                    }
                    
                       }
                 
               });
          }
     
     
     
     
    public GUEST_ReadAndWrite() {
          
          
        initComponents();
        
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
              
              if(!(Arrays.toString(oneRow).contains("/iotgateway"))){
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
                    jComboBox2
                            .addItem(addThis.replace("]", ""));
                    CSVholder.add(Arrays.toString(splittedOneRowArray));
                    
                    
               }
              }
              
               
          }
         
          System.out.println("CSVholder---->"+CSVholder);
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
   
          
          
       
     
      
            //  
          
     
     ///*******/////
        
        
        
        
        
        
             // jLabel6.setVisible(false);
                     jComboBox1.setVisible(false);
    jLabel7.setVisible(false);
               jTextField6.setVisible(false);
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

        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\Guest Mode (1).png")); // NOI18N

        setResizable(false);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setForeground(new java.awt.Color(204, 255, 255));
        jButton3.setText("Read");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("LIST:");

        jTextField6.setBackground(new java.awt.Color(51, 51, 0));
        jTextField6.setForeground(new java.awt.Color(204, 255, 255));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 51));
        jButton4.setForeground(new java.awt.Color(204, 255, 255));
        jButton4.setText("Connect to This IP");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Connection Status:");

        jTextField7.setBackground(new java.awt.Color(0, 153, 0));
        jTextField7.setForeground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Read / Write (IoT Gateway REST API Client)");

        jTextField1.setBackground(new java.awt.Color(153, 255, 153));
        jTextField1.setText("http://127.0.0.1:3001/iotgateway/");

        jTextField2.setBackground(new java.awt.Color(255, 153, 153));
        jTextField2.setText("Enter Your Tag Name for Writing Here (or select)");
        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(255, 51, 51));
        jTextField9.setForeground(new java.awt.Color(204, 255, 255));
        jTextField9.setText("your status is:");
        jTextField9.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setForeground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Write");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Writing Status:");
        jLabel11.setEnabled(false);

        jTextField3.setBackground(new java.awt.Color(204, 204, 255));
        jTextField3.setText("Enter Your Tag Name for Reading Here (or select)");
        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setForeground(new java.awt.Color(204, 255, 255));
        jButton2.setText("SHOW LIST OF TAGS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(255, 153, 153));
        jTextField4.setText("Enter the New Value for This Tag");
        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(102, 102, 255));
        jTextField5.setForeground(new java.awt.Color(204, 255, 255));
        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Tag" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\1121.png")); // NOI18N

        jToggleButton1.setBackground(new java.awt.Color(153, 153, 255));
        jToggleButton1.setForeground(new java.awt.Color(204, 255, 255));
        jToggleButton1.setText("Auto-Read (ON/OFF)");
        jToggleButton1.setEnabled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(0, 102, 102));
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("Enable Writing");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("READ VALUE:");
        jLabel8.setEnabled(false);

        jComboBox2.setBackground(new java.awt.Color(51, 204, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select IP/URL" }));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator3.setForeground(new java.awt.Color(51, 102, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 11));

        jSeparator4.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator4.setForeground(new java.awt.Color(51, 102, 255));
        jSeparator4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 11));

        jSeparator5.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator5.setForeground(new java.awt.Color(51, 102, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jSeparator5.setPreferredSize(new java.awt.Dimension(0, 11));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\Guest Mode (1).png")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\yunus\\Documents\\NetBeansProjects\\KepServerExDesktopClient\\src\\main\\java\\com\\opcturkey\\kepserverexdesktopclient\\resources\\Copyright © ASP OTOMASYON A.Ş. (5).png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("Options");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Auto-Read (on/off)");
        jMenuItem3.setEnabled(false);
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jRadioButtonMenuItem2.setText("Enable Writing");
        jRadioButtonMenuItem2.setEnabled(false);
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem2);

        jMenuItem2.setText("Show List of Tags");
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Refresh this page");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Enable Confirmation Prompts");
        jMenuItem4.setEnabled(false);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(339, 339, 339)
                    .addComponent(jLabel12)
                    .addGap(31, 31, 31)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(jLabel9))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(340, 340, 340)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(150, 150, 150)
                                            .addComponent(jLabel8))
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(222, 222, 222)
                                    .addComponent(jLabel11))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(170, 170, 170)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(188, 188, 188)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    public void main2() throws IOException {
        
        
       //ReadAndWrite readwrite = new ReadAndWrite();
        //var tagNameToWriteTo = readwrite.tagNameToWriteTo;
        //String newAssignedValue = readwrite.newAssignedValue;
       // String IP_URL_x = readwrite.IP_URL_x; 
        
  try{
      
      WritingStatusString="writing...";
      jTextField9.setForeground(Color.GRAY);
jTextField9.setText(WritingStatusString);


      URL url = new URL(IP_URL_x+"write");
HttpURLConnection http = (HttpURLConnection)url.openConnection();

http.setRequestMethod("POST");
http.setDoOutput(true);

http.setRequestProperty("Accept", "application/json");
http.setRequestProperty("Content-Type", "application/json");

String data = "[{\"id\": " + "\"" + tagNameToWriteTo + "\"" + "," + "\"v\": \"" + newAssignedValue +  "\"}]";

byte[] output = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(output);
stream.close();
System.out.println(http.getResponseCode() + " ------ " + http.getResponseMessage());


  if(http.getResponseMessage().isEmpty()){
      
        WritingStatusString="Failed";
        jTextField9.setForeground(Color.orange);
        jTextField9.setText(WritingStatusString);
        
        }
  
  else{
         WritingStatusString=http.getResponseMessage();
         jTextField9.setForeground(Color.white);
         jTextField9.setText(WritingStatusString);
         
        }
 

http.disconnect();

  }
  
  catch(IOException e){
      
      throw new IOException(e);
      
  }
       


    
         
         
        
    }
    
    /**
     *
     */

     
     
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
jToggleButton1.setEnabled(true);
        
    try {
        actionPerfRead();
    } catch (InterruptedException ex) {
        Logger.getLogger(ReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_jButton3ActionPerformed
    
 
    
    
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       // TODO add your handling code here:
        final String IP_URL = jTextField1.getText();
        final String POST_API_URL = IP_URL+"browse";

        if(IP_URL.length()>0 && ! IP_URL.contains(" ")){
            
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
        .GET()
        .header("accept", "application/json")
        .uri(URI.create(POST_API_URL))
        .build();
        HttpResponse <String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body().toString();

            if(json.length()>0){
                jTextField7.setForeground(Color.white);
                jTextField7.setText("connected");
                jTextField2.setEnabled(true);
jTextField9.setEnabled(true);
 jLabel11.setEnabled(true);
 jTextField3.setEnabled(true);
 jTextField4.setEnabled(true);
 jTextField5.setEnabled(true);
 jComboBox1.setEnabled(true);
 jLabel8.setEnabled(true);
 jButton3.setEnabled(true);
 jSeparator3.setEnabled(true);
  jMenuItem2.setEnabled(true);
 jMenuItem3.setEnabled(true);
 jMenuItem4.setEnabled(true);

            }else{
                jTextField7.setForeground(Color.orange);
                jTextField7.setText("failed");

            }

        }catch (IOException ex){
            jTextField7.setForeground(Color.orange);
             jTextField7.setText("failed");
            throw new RuntimeException(ex);
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);

            // readValueField.setText();
            // String IPString =
            // String TagString = tagField.getText();

            // var client = HttpClient.newHttpClient();
            // var request = HttpRequest.newBuilder(URI.create(IPString))

            // .header("accept", "application/json")
            // .build();

            //var response = client.send(request, new JsonBodyHandler<>(APOD.class));
            //Object obj = JSONValue.parse(responseVal);
            // JSONObject jsonObject = (JSONObject) obj;
            //  int KepValue = (int) jsonObject.get("v");
            // readValueField.setText(response.body().toString());

        }
        
       }else{
            jTextField7.setForeground(Color.orange);
            jTextField7.setText("Your input is incorrect. Make sure there are no spaces.");
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed


                   
    
           
 
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
runAutoCode(0);



        // WRITE INTO TAG VALUE FUNCTION

        
        if(enablepop==1){
            
       

                              this.setVisible(false);
                                     
                                     /////////
                                  int lastWarningDialogBeforeWriteAction = JOptionPane.showConfirmDialog(
                                  
                                  null, "You are about to attempt changing tag values in your KepServerEX project via IoT Gateway. This operation is irreversable. Do you confirm this action?", "IMPORTANT WARNING!", JOptionPane.YES_NO_OPTION);
                                  
                                  if(lastWarningDialogBeforeWriteAction == JOptionPane.YES_OPTION){
                                      JOptionPane.showMessageDialog(null, "Writing operation Started, find the results in the status box.");
                                      writingActionFunction();
                                      
                                       this.setVisible(true);
                                  }else{
                                      JOptionPane.showMessageDialog(null, "Writing operation has been cancelled safely.");
                                      System.out.println("operation cancelled.");
                                      
                                       this.setVisible(true);
                                  }
                                    
                                     ////////
        
        
         }else{
            writingActionFunction();
        }
        
        
        
        ////////////7


    }//GEN-LAST:event_jButton1ActionPerformed

    public int writingActionFunction(){
        
        
                tagNameToWriteTo=jTextField2.getText();
        newAssignedValue =jTextField4.getText();
        IP_URL_x = jTextField1.getText();

        jTextField9.setForeground(Color.GRAY);
         jTextField9.setText("writing");
         
         if(tagNameToWriteTo.length()>0 && newAssignedValue.length()>0 && IP_URL_x.length()>0 && !tagNameToWriteTo.contains(" ") && !newAssignedValue.contains(" ") 
                 && !IP_URL_x.contains(" ")){
             
         
    try {
        main2();
        
        
        
        
        
        /*  try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
        var  tagNameToWriteTo=jTextField2.getText();
        var newAssignedValue =jTextField4.getText();
        try {
        
        jTextField9.setText("success");
        
        } catch (Exception e) {
        e.printStackTrace();
        jTextField9.setText("failed");
        }
        } catch (IOException e) {
        System.out.println(e.getMessage());
        }*/
        //////////////77
    } catch (IOException ex) {
        Logger.getLogger(ReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    }else{
             jTextField9.setForeground(Color.orange);
            jTextField9.setText("error. Incorrect inputs. Make sure you haven't left any spaces in any inputs and your value types are compatible.");
            }
         
         
        return 0;
    }
    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    
    boolean multipleclickdetected=false;
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //SHOW ALL TAGS FUNCTION
          
           
           
           
        jTextField6.setText("");
        splittedX.clear();
        tagNamesList.clear();
        splittedSmart.clear();
                    if(multipleclickdetected==true){
            jComboBox1.setEnabled(false);
            
                    }
        try{
            final String IP_URL = jTextField1.getText()+"browse";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
            .GET()
            .header("accept", "application/json")
            .uri(URI.create(IP_URL))
            .build();
            HttpResponse <String> response;

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json2 = response.body().toString();
            var cleanedJson2 = json2.substring(json2.indexOf("\"id\":"));
            var finalResult2 = cleanedJson2.split("}],")[0];

            
            //////
            
            
            
             int x = StringUtils.countMatches(finalResult2, ",");
                 for(int i=0;i<x;i++){
                     String[] xc = finalResult2.split(",");
                         splittedX.add(xc[i]);
                         
                         
                 }
                 
                for (int i = 0;i<splittedX.size();i++) {
                    boolean xxz = splittedX.get(i).contains("}");
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
                      
                      
                           indexOfCommonDot = eachString.indexOf(",");
                          endOfTheElementLength=  eachString.length();
                          substringForTagName = eachString.substring(indexOfCommonDot+7,  endOfTheElementLength-2);
                        if(substringForTagName.contains("\"")){
                            substringForTagName=eachString.substring(indexOfCommonDot+8,  endOfTheElementLength-2);
                        }
                        
                        
                         
                        System.out.println(substringForTagName);
                        tagNamesList.add(substringForTagName);
                        
                
                   
                }
                  
                  for( int i = 0;  i  <  tagNamesList.size(); i++ ){
                      
                      jTextField6.setText(jTextField6.getText()+" , "+tagNamesList.get(i));
                      jComboBox1.addItem(tagNamesList.get(i));
                  }
                 
               
                
                
           
            
            multipleclickdetected=true;
          
            
            
            
            //////
            
            

        }catch(RuntimeException ex){
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        
        
         jComboBox1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evnt){
                    
                    
                  JComboBox jComboBox1 = (JComboBox) evnt.getSource();
                    Object selectedItem = jComboBox1.getSelectedItem();
                    jTextField3.setText((String) selectedItem);
                    jTextField2.setText((String) selectedItem);
                
                }
                });
         
         jButton3.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    boolean auto_refreshOFF_is_not_activated;
    
     
    
  
    
    
    public void timerAndRestart() throws InterruptedException{
        
        

    Date date1 = new Date();
        // Delay for 1 seonds
TimeUnit.SECONDS.sleep(1);        
        
        

    Date date2 = new Date();
        
        if(date1 != date2){
            //checkerFuncforAutoRef();
            jTextField6.setText("dates different");
        } 
        
        
        
        
    }
    
    
    
    
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
 


///7
    ///
    ///
    ///
    //
    ///
    ///
    
    
     
    
   
    
public  final HttpClient myHttpClient = HttpClient.newBuilder()
            
            .build();

    int agentEye2=0;
public  void runAutoCode(int agentEye){
    
   if(agentEye==2){
       System.out.println("agentEye is 2, returned.");
       return;
       
   }
    if(agentEye==1){
        
    
    final Runnable autocode=new Runnable(){
 
        public void run(){
        
            System.out.println("agentEye="+agentEye);
            if(agentEye==1 && checkcheckD==1){
                
            
            final String IP_URL = jTextField1.getText();
        final String TAG_NAME = jTextField3.getText();
        final String POST_API_URL = IP_URL+"read?ids="+TAG_NAME;
       
        
            HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
        .uri(URI.create(POST_API_URL))
        .build();
        HttpResponse <String> response;
         try{  
            response = myHttpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body().toString();

            var cleanedJson = json.substring(json.indexOf("\"v\":"));
            var finalResult = cleanedJson.split(",")[0];
jTextField5.setForeground(Color.white);
            jTextField5.setText(finalResult);
            
            
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        } }else{
                   
                try {     
                    System.out.println("going to sleep");
                    
                      Thread.interrupted();
                      
                      throw new Exception();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                } catch (Exception ex) {
                    Logger.getLogger(ReadAndWrite.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                
            }   
        }

       
        
    };
    
  ScheduledFuture<?> autoHandle = scheduler.scheduleAtFixedRate(autocode,5,5,SECONDS);
        

 
  
  if(scheduler.isShutdown()){
      
 
 scheduler.schedule(new Runnable(){
     public void run(){
         autoHandle.cancel(true);
         scheduler.shutdown();
       
     }
 },60*60, SECONDS);
 
  }
 
}else{
        System.out.println("agentEye is 0/OFF so the auto read won't activate.");
    }
   
}
 ///7
    ///
    ///
    ///
    //
    ///
    ///


 

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
     

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        jButton1.setEnabled(true);
        jToggleButton2.setVisible(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        ReadAndWrite rw= new ReadAndWrite();
        rw.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       // jLabel6.setVisible(true);
        jComboBox1.setVisible(true);       //SHOW ALL TAGS FUNCTION
        jLabel7.setVisible(true);
        jTextField6.setVisible(true);

        jTextField6.setText("");
        splittedX.clear();
        tagNamesList.clear();
        splittedSmart.clear();
        if(multipleclickdetected==true){
            jComboBox1.setEnabled(false);

        }
        try{
            final String IP_URL = jTextField1.getText()+"browse";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
            .GET()
            .header("accept", "application/json")
            .uri(URI.create(IP_URL))
            .build();
            HttpResponse <String> response;

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json2 = response.body().toString();
            var cleanedJson2 = json2.substring(json2.indexOf("\"id\":"));
            var finalResult2 = cleanedJson2.split("}],")[0];

            //////

            int x = StringUtils.countMatches(finalResult2, ",");
            for(int i=0;i<x;i++){
                String[] xc = finalResult2.split(",");
                splittedX.add(xc[i]);

            }

            for (int i = 0;i<splittedX.size();i++) {
                boolean xxz = splittedX.get(i).contains("}");
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

                indexOfCommonDot = eachString.indexOf(",");
                endOfTheElementLength=  eachString.length();
                substringForTagName = eachString.substring(indexOfCommonDot+7,  endOfTheElementLength-2);
                if(substringForTagName.contains("\"")){
                    substringForTagName=eachString.substring(indexOfCommonDot+8,  endOfTheElementLength-2);
                }

                System.out.println(substringForTagName);
                tagNamesList.add(substringForTagName);

            }

            for( int i = 0;  i  <  tagNamesList.size(); i++ ){

                jTextField6.setText(jTextField6.getText()+" , "+tagNamesList.get(i));
                jComboBox1.addItem(tagNamesList.get(i));
            }

            multipleclickdetected=true;

            //////

        }catch(RuntimeException ex){
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        jComboBox1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evnt){

                JComboBox jComboBox1 = (JComboBox) evnt.getSource();
                Object selectedItem = jComboBox1.getSelectedItem();
                jTextField3.setText((String) selectedItem);
                jTextField2.setText((String) selectedItem);

            }
        });

        jButton3.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:
        jButton1.setEnabled(true);
        jToggleButton2.setVisible(false);   
         jTextField2.setEnabled(true); 
                 jTextField4.setEnabled(true); 
                 jLabel11.setEnabled(true);
                         jTextField9.setEnabled(true);
                         
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
  if(checkcheckD==0){  //ACTIVATE
             System.out.println("activated");
             
  
             
           jButton3.setEnabled(false);
             jMenuItem3.setText("turn OFF - Auto-Read (on/off)");
          jButton3.setForeground(ORANGE);
            checkcheckD=1;
            
            
               if(scheduler.isShutdown()==true){
                 scheduler=Executors.newScheduledThreadPool(1);
             }
            
            
            
             runAutoCode(1);
             
             
          
             
             System.out.println("runAutoCode(1);\n checkcheckD=1;");
             
         }
         
         else{    // TURN OFF
             System.out.println("deactivated");
             
             
               
              jMenuItem3.setText("turn ON- Auto-Read (on/off)");
              jButton3.setForeground(new Color( 204,255,255));
             jButton3.setEnabled(true);
             
              checkcheckD=0;
              System.out.println("runAutoCode(0);\n checkcheckD=0;");
           runAutoCode(2);   
             if(scheduler.isShutdown()==false){
                 scheduler.shutdown();
             }
             
           
         }     
      
      
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(jMenuItem4.getText().equals("Enable Confirmation Prompts")){
             enablepop=1;
             System.out.println("enablepop=1;");
             jMenuItem4.setText("Disable Confirmation Prompts");
        }else{
            enablepop=0;
            jMenuItem4.setText("Enable Confirmation Prompts");
        }
       
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
 
 
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
            java.util.logging.Logger.getLogger(ReadAndWrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadAndWrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadAndWrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadAndWrite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadAndWrite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    void actionPerfRead() throws InterruptedException {
          final String IP_URL = jTextField1.getText();
        final String TAG_NAME = jTextField3.getText();
        final String POST_API_URL = IP_URL+"read?ids="+TAG_NAME;
        if(TAG_NAME.length()>0 && "connected".equals(jTextField7.getText()) && IP_URL.length()>0 && ! TAG_NAME.contains(" ")){
           

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
        .GET()
        .header("accept", "application/json")
        .uri(URI.create(POST_API_URL))
        .build();
        HttpResponse <String> response;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body().toString();

            var cleanedJson = json.substring(json.indexOf("\"v\":"));
            var finalResult = cleanedJson.split(",")[0];
jTextField5.setForeground(Color.white);
            jTextField5.setText(finalResult);
            
            
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }else {
            jTextField5.setForeground(Color.orange);
            jTextField5.setText("incorrect inputs (don't leave spaces, keep previous boxes intact)");
        }
        
     
        
    } 
   
    
}
