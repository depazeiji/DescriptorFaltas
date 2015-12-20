/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descripciones_faltas_judiciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ine031
 */
public class Descripciones_Faltas_Judiciales {

    /**
     * @param args the command line arguments
     */
    private static String rutaCSVFuente = "/home/ine031/Descargas/Faltas Judiciales T3 2014/csv T3 faltas  2014";
    private static String rutaTEXDestino = "/home/ine031/Descargas/Faltas Judiciales T3 2014/Salida";
    
    public static void main(String[] args) {
        Generador g = new Generador(rutaCSVFuente, rutaTEXDestino);
        g.run();
    }
}
