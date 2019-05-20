/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartsswing;


import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;

/**
 *
 * @author user 6
 */
public class UtilsSwing {


    /**
     * Formato de fecha para los campos de fecha
     */
    public static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Formato de fecha para la base de datos
     * genera un string con la fecha con la siguiente estructura
     * yyyyMMdd
     */
    public static final DateFormat FTFECHA = new SimpleDateFormat("yyyyMMdd");
    /**
     * Formato de fecha para la base de datos
     * genera un string con la fecha con la siguiente estructura
     *
     */
    public static final DateFormat STRINGTOFECHA = new SimpleDateFormat("dd/MM/yyyy");

        /**
     * Formato de fecha para la base de datos
     * genera un string con la fecha con la siguiente estructura
     *
     */
    public static final DateFormat HORA = new SimpleDateFormat("HHmmss");

    /**
     * Cierra la venta que se pasa comom argumento
     * @param jframe ventana a cerrar
     */
    private static void CierraVentana(final JFrame jframe) {
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(false);
        jframe.dispose();
    }

    /**
     * Abre una ventana de confirmación antes de cerrar la ventana
     * que se pasa como argumento
     * @param jframe ventana que se va a cerrar
     */
    public static void ConfirmarCerrar(final JFrame jframe) {
        Object[] options = {"Si",
            "No"};
        int n = JOptionPane.showOptionDialog(jframe,
                "¿Deseas cerrar la sesión?",
                "Administración de pedidos",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]);
        if (n == 0) {
            jframe.setVisible(false);
            jframe.dispose();
            CierraVentana(jframe);
        }
    }

    /**
     * Se utiliza para presentar un mensaje en pantalla y cerrar
     * el jframe padre.
     * @param texto texto del mensaje
     * @param jframe frame en el que va a aparecer el mensaje
     */
    public static void mensajeExito(String texto,
            final JFrame jframe) {
        Object[] options = {"Aceptar"};
        JOptionPane.showOptionDialog(jframe,
                texto,
                    "Administración de pedidos",
                JOptionPane.YES_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]);
    }

    /**
     * Abre una ventana de confirmación antes de
     * cancelar la operación que se está se realizando
     * @param jframe ventana que se va a cerrar
     * @param mensaje mensaje de cancelación
     */
    public static int confirmaCancelacion(final JFrame jframe,
            String mensaje) {
        Object[] options = {"Aceptar", "Cancelar"};
        int n = JOptionPane.showOptionDialog(jframe,
                mensaje,
                "Administración de pedidos",
                JOptionPane.YES_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[1]);
        if (n == 0) {
            jframe.setVisible(false);
            jframe.dispose();
            //CierraVentana(jframe);
        }
        return n;
    }
    
        public static int confirmaOperacion(final JFrame jframe,
            String mensaje) {
        Object[] options = {"Aceptar", "Cancelar"};
        int n = JOptionPane.showOptionDialog(jframe,
                mensaje,
                "Administración de pedidos",
                JOptionPane.YES_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[1]);
        return n;
    }

    /**
     * Se utiliza para presentar un mensaje de error
     * en pantalla sin cerrar el
     * jframe padre.
     * @param texto texto del mensaje
     * @param jframe frame en el que va a aparecer el mensaje
     */
    public static void mensajeError(String texto,
            final JFrame jframe) {
        Object[] options = {"Aceptar"};
        JOptionPane.showOptionDialog(jframe,
                texto,
                "Administración de pedidos",
                JOptionPane.YES_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]);
    }

    /**
     * Se utiliza para presentar un mensaje de error
     * en pantalla sin cerrar el
     * jframe padre.
     * @param texto texto del mensaje
     * @param jframe frame en el que va a aparecer el mensaje
     */
    public static void mensajeWarning(String texto,
            final JFrame jframe) {
        Object[] options = {"Aceptar"};
        JOptionPane.showOptionDialog(jframe,
                texto,
                "Administración de pedidos",
                JOptionPane.YES_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]);
    }

    /**
     * Método que realiza la carga de las propiedades del cliente de
     * sistema de directorios.
     * @param archivo archivo
     *
     * @return Un Objeto con las propiedades de la aplicación.
     *
     * @throws SipareEJBException
     *             En caso de que la operación no tenga éxito.
     */
    public static synchronized Properties cargaPropiedades(String archivo) 
    {
        Properties props = new Properties();
        try {
            props.clear();
            props.load(new FileInputStream(archivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }

    /**
     * Método que inicia la fecha de un campo de fecha a la
     * actual
     * @return String con el campo de fecha
     */
    public static final String obtieneFechaDia() {
        String fechaActual = df.format(Calendar.getInstance().getTime());
        return fechaActual;
    }

    /**
     * Mueve de carpeta un archivo
     * @param sourceFile ruta del archivo a cambiar
     * @param destinationFile ruta destino del archivo
     */
    public static void fileMove(String sourceFile, String destinationFile) {
        //System.out.println("Desde: " + sourceFile);
        //System.out.println("Hacia: " + destinationFile);
        boolean seCopio = false;
        File inFile = null;
        File outFile = null;
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            inFile = new File(sourceFile);
            outFile = new File(destinationFile +  inFile.getName() +
                    UtilsSwing.HORA.format(Calendar.getInstance().getTime()));

            in = new FileInputStream(inFile);
            out = new FileOutputStream(outFile);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            seCopio = true;

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                   out.close();
                }
                if (seCopio) {
                    File file = new File(sourceFile);

                    if (file.exists()) {
                        System.out.println("Lixto calixto: " +
                                inFile.getAbsolutePath());
                        file.delete();
                    }
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    /**
     * Valida un directorio
     * @param path archivo a validar
     * @param action crea el folder sino existe
     * @return true si se pudo crear el archivo
     */
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action) {
            file.mkdirs();
        }
        return isDirectory;
    }
    
    	/*************** funciones para reportes de consar ****************/
	/**
	 * Rellena espacios.
	 * @param cadena the cadena
	 * @param car the car
	 * @param cant the cant
	 * @param pos si es 1 es a la izquierda, si es 0 a la derecha
	 * 
	 * @return String como debe quedar
	 */
	public static String rellenaEspacios(String cadena, String caracRelleno, int cant, int pos) {

		String ret = cadena; // cadena;
		if (cadena.length() > cant) { // la cadena es mayor al logitud deseada
			ret = cadena.substring(0, cant);
		}

		cant = cant - cadena.length();

		if (cant > 0) {
			char[] ca = new char[cant];
			Arrays.fill(ca, caracRelleno.charAt(0));
			ret = new String(ca);
			// Rellenamos a la derecha
			if (pos == 0) {
				ret = cadena + ret;
			}
			else {
				ret = ret + cadena;
			}
		}
		// logg.info("rellenaEspacios {" + ret + "}");
		return ret;
	}
        
        /**
	 * Formatea monto.
	 * 
	 * @param monto
	 *            the monto
	 * @param detalle
	 *            the detalle
	 */
	public static void formateaMonto(BigDecimal monto, StringBuffer detalle) {
		if (null == monto) {
			monto = new BigDecimal("0.0");
		}
		if (monto.signum() == -1) {
			detalle.append("-");
			detalle.append(UtilsSwing.rellenaEspacios(monto.movePointRight(2)
					.toString(), "0", 15, 1)); // importe
		}
		else {
			//detalle.append("+");
			detalle.append(UtilsSwing.rellenaEspacios(monto.movePointRight(2)
					.toString(), "0", 16, 1)); // importe
		}
	}
}
