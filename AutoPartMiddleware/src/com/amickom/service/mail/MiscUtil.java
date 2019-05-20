package com.amickom.service.mail;

import com.amickom.service.exception.RefaccionariaException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author NA-AT Consulting
 *	Proyecto: Perfil de Cliente en Banco
 *  ID: 066
 * 
 */
public class MiscUtil {

    /**
     * variable para el log
     */
    private static Logger log = Logger.getLogger(MiscUtil.class);

    /**
     * Constructor
     */
    public MiscUtil() {
    }

    /**
     * @param source source
     * @return String
     * @throws RefaccionariaException RefaccionariaException
     */
    public String getSource(Integer source) throws RefaccionariaException {
        return this.getSource(source.toString());
    }

    /**
     * @param source source
     * @return String
     * @throws RefaccionariaException RefaccionariaException
     */
    public String getSource(String source) throws RefaccionariaException {
        StringBuffer resource = new StringBuffer();
        resource.append("archivos/sipare/properties/");
        resource.append(source);
        resource.append(".htm.properties");
        return this.loadResource(resource.toString()).toString();
    }
    
        /**
     * @param source source
     * @return String
     * @throws RefaccionariaException RefaccionariaException
     */
    public String getSourceFromClassPath(String source) throws RefaccionariaException {
        StringBuffer resource = new StringBuffer();
        //resource.append("archivos/sipare/properties/");
        resource.append(source);
        resource.append(".htm.properties");
        return this.loadResourceFromClassPath(resource.toString()).toString();
    }

    /**
     * @param resource resource
     * @return StringBuffer
     * @throws RefaccionariaException RefaccionariaException
     */
    private StringBuffer loadResource(String resource)
            throws RefaccionariaException {
        StringBuffer html = new StringBuffer();
        try {

            InputStream is = new FileInputStream(resource);
            BufferedReader br;
            for (br = new BufferedReader(new InputStreamReader(is)); br.ready();) {
                String line = br.readLine();
                html.append(line);
            }

            br.close();
            is.close();
        } catch (IOException ioexception) {
            log.error("Error trying to load "
                    + "resource " + resource);
            throw new RefaccionariaException("Loading of " + resource
                    + "produced "
                    + "and IOException");
        } catch (NullPointerException nullpointerexception) {
            log.error("Resource not found " + resource);
            throw new RefaccionariaException("Resource " + resource
                    + " not found1");
        }
        return html;
    }
    
        /**
     * @param resource resource
     * @return StringBuffer
     * @throws RefaccionariaException RefaccionariaException
     */
    private StringBuffer loadResourceFromClassPath(String resource)
            throws RefaccionariaException {
        StringBuffer html = new StringBuffer();
        try {

            //InputStream is = new FileInputStream(resource);
            InputStream is =  MiscUtil.class.getClassLoader().getResourceAsStream(resource);
            BufferedReader br;
            for (br = new BufferedReader(new InputStreamReader(is)); br.ready();) {
                String line = br.readLine();
                html.append(line);
            }

            br.close();
            is.close();
        } catch (IOException ioexception) {
            log.error("Error trying to load "
                    + "resource " + resource);
            throw new RefaccionariaException("Loading of " + resource
                    + "produced "
                    + "and IOException");
        } catch (NullPointerException nullpointerexception) {
            log.error("Resource not found " + resource);
            throw new RefaccionariaException("Resource " + resource
                    + " not found1");
        }
        return html;
    }

    /**
     * 
     * M�todo : convertDate2HumanReadable 
     * @param date - 
     * @return String -
     */
    public static String convertDate2HumanReadable(Date date) {
        date.getTime();

        String humanStr = "";
        List days = new ArrayList();
        days.add(0, "???");
        days.add(1, "Domingo");
        days.add(2, "Lunes");
        days.add(3,
                "Martes");
        days.add(4,
                "Miercoles");
        days.add(5,
                "Jueves");
        days.add(6,
                "Viernes");
        days.add(7,
                "Sábado");

        List months = new ArrayList();

        //months.add(0, "NOT-A-MONTH");
        //months.add(1, "NOT-A-MONTH");
        months.add(0, "Enero");
        months.add(1, "Febrero");
        months.add(2, "Marzo");
        months.add(3,
                "Abril");
        months.add(4,
                "Mayo");
        months.add(5,
                "Junio");
        months.add(6,
                "Julio");
        months.add(7,
                "Agosto");
        months.add(8,
                "Septiembre");
        months.add(9,
                "Octubre");
        months.add(10,
                "Noviembre");
        months.add(11,
                "Diciembre");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        humanStr += days.get(calendar.get(Calendar.DAY_OF_WEEK)) + ", "
                + calendar.get(Calendar.DAY_OF_MONTH) + " de"
                + months.get(calendar.get(Calendar.MONTH)) + " de "
                + calendar.get(Calendar.YEAR);

        return humanStr;
    }
}
