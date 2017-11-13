    package imagens;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BME08
 */
public class Report {
    private final String logo=("/imagens/temp.png");
    
    public Report(){
    
    }
    public void verRelatorio(String s){
        JasperReport repor;
        JasperPrint re;
        
        try {
        URL in = this.getClass().getResource("/imagens/"+s+".jasper");
        repor =(JasperReport)JRLoader.loadObject(in);
        Map parametros = new HashMap();
        parametros.clear();
        parametros.put("logo", this.getClass().getResourceAsStream(logo));
        re = JasperFillManager.fillReport(repor, parametros, new JREmptyDataSource());
        JasperViewer.viewReport(re, false);
        
        } catch(JRException ex){
       }
    }
    
    
}
