/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgtGerador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author BME08
 */
public class QrCode {
    private String s;
    private File arquivo = new File("C:\\Users\\BME08\\Documents\\NetBeansProjects\\geradorQRCode\\src\\imagens\\temp.png");
    public QrCode(){
    
    }
    public void Gerar(String s){
    this.s = s;
        

    if(s.length()==0){
        JOptionPane.showMessageDialog(null,"Insira algum valor!");
    
    } try {
                  FileOutputStream f = new FileOutputStream(arquivo);
                  ByteArrayOutputStream out = net.glxn.qrgen.QRCode.from(s)
                    .to(ImageType.PNG)
                    .withSize(130, 130)
                    .stream();
                  
            f.write(out.toByteArray());
            f.close();
    } catch (IOException ex) {
            Logger.getLogger(FmrQRCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JLabel carrega() throws IOException{
        BufferedImage icone = ImageIO.read(arquivo);
        JLabel label = new JLabel(new ImageIcon(icone));
        return label;
        }
    
    public File getFile(){
        return this.arquivo;  
    }
} 
    

