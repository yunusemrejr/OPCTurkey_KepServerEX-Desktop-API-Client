/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.opcturkey.kepserverexdesktopclient;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author yunus
 */
         
     public class loginCreditChanger{

     public static void main(String[] args){
         loginCreditChangerDetails LCCD = new loginCreditChangerDetails();
         LCCD.setTitle("Change Login Credentials");
         LCCD.setVisible(true);
         LCCD.setBounds(10,10,370,600);
         LCCD.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         LCCD.setResizable(false);
                         
     }    
         
     }
     
