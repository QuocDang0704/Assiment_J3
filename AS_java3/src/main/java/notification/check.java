/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Đặng Quốc
 */
public class check {
    public static void checkRong(JTextField txt, StringBuilder sb, String text){
        if (txt.getText().isEmpty()) {
            sb.append(text+"\n");
            txt.requestFocus();
        }
    }
    public static void checkRong(JPasswordField txt, StringBuilder sb, String text){
        if (new String(txt.getPassword()).isEmpty()) {
            sb.append(text+"\n");
            txt.requestFocus();
        }
    }
    public static void checkRong(JTextArea txt, StringBuilder sb, String text){
        if (txt.getText().isEmpty()) {
            sb.append(text+"\n");
            txt.requestFocus();
        }
    }
}
