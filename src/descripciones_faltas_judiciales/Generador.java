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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ine031
 */
public class Generador {
    
    private String ruta;
    private File texs;
    
    public Generador(String ruta, String rutaTEX){
        this.ruta = ruta;
        texs = new File(rutaTEX);
    }
    
    public void run(){
        generarCSVFalta("1_01");
        
        generarCSV("1_02");
        generarCSV("1_03");
        generarCSV("1_04");
        generarCSV("1_05");
        generarCSV("1_06");
        generarCSV("1_07");
        generarCSV("1_08");
        generarCSV("1_09");
        generarCSV("1_10");
        des1_11();
        
        des2_01();
        generarCSV("2_02");
        generarCSV("2_03");
        generarCSV("2_04");
        generarCSV("2_05");
        generarCSV("2_06");
        generarCSV("2_07");
        
        generarCSV("3_01");
        generarCSV("3_02");
        generarCSV("3_03");
        generarCSV("3_04");
        generarCSV("3_05");
    }

    private void des2_01(){
        File f = new File(ruta, "2_01" + ".csv");
        System.out.println("RUTA 2_01 CSV: " + f.getAbsolutePath());
        BufferedReader br = null;
        String line = "";
        int anio = 0;
            boolean encabezado = true;
            
            try {
                br = new BufferedReader(new FileReader(f.getAbsolutePath()));
            while ((line = br.readLine()) != null) {
                        if(encabezado){
                            encabezado = false;
                        }
                        else{
                            String[] valores = line.split(";");
                            String[] fecha = valores[0].split("-");
                            anio = Integer.parseInt(fecha[1]);
                        }
                    }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            File seccion = new File(texs, "2_01");
                File des = new File(seccion, "descripcion");
        escribirTEX(des.getAbsolutePath(), "Las estadísticas de infractores menores de edad"
                + " ayudan a generar propuestas de programas de ocupación del tiempo"
                + " en jóvenes. La gráfica muestra la serie histórica de faltas cometidas "
                + "por personas menores de 18 años ocurridas en el período " + (anio-2) + "-" + (anio) + ".");  
    }
    
    private void generarCSVFalta(String csv){
        File f = new File(ruta, csv + ".csv");
        System.out.println(f.getAbsolutePath());
        BufferedReader br = null;
        String line = "";
            boolean encabezado = true;
            
            List<Falta> lista = new ArrayList();
            try {
                br = new BufferedReader(new FileReader(f.getAbsolutePath()));
            while ((line = br.readLine()) != null) {
                        if(encabezado){
                            encabezado = false;
                        }
                        else{
                String[] valores = line.split(";");
                            lista.add(new Falta(valores[0], valores[1]));
                        }
                    }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            File seccion = new File(texs, csv);
                File des = new File(seccion, "descripcion");
        escribirTEX(des.getAbsolutePath(), des1_1(lista));     
    }
        
    private void generarCSV(String csv) {
        File f = new File(ruta, csv + ".csv");
    BufferedReader br = null;
    String line = "";
        boolean encabezado = true;
        
        List<Porcentaje> lista = new ArrayList();
        try {
            br = new BufferedReader(new FileReader(f.getAbsolutePath()));
        while ((line = br.readLine()) != null) {
                    if(encabezado){
                        encabezado = false;
                    }
                    else{
            String[] valores = line.split(";");
                        lista.add(new Porcentaje(valores[0], valores[1]));
                    }
                }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        File seccion = new File(texs, csv);
        File des = new File(seccion, "descripcion");
        switch(csv){
            case "1_02":
                escribirTEX(des.getAbsolutePath(), des1_2(lista));
                break;
            case "1_03":
                escribirTEX(des.getAbsolutePath() , des1_3(lista));
                break;
            case "1_04":
                escribirTEX(des.getAbsolutePath() , des1_4(lista));
                break;
            case "1_05":
                escribirTEX(des.getAbsolutePath() , des1_5(lista));
                break;
            case "1_06":
                escribirTEX(des.getAbsolutePath() , des1_6(lista));
                break;
            case "1_07":
                escribirTEX(des.getAbsolutePath() , des1_7(lista));
                break;
            case "1_08":
                escribirTEX(des.getAbsolutePath() , des1_8(lista));
                break;
            case "1_09":
                escribirTEX(des.getAbsolutePath() , des1_9(lista));
                break;
            case "1_10":
                escribirTEX(des.getAbsolutePath() , des1_10(lista));
                break;   
            case "2_02":
                escribirTEX(des.getAbsolutePath() , des2_2(lista));
                break;   
            case "2_03":
                escribirTEX(des.getAbsolutePath() , des2_3(lista));
                break;    
            case "2_04":
                escribirTEX(des.getAbsolutePath() , des2_4(lista));
                break;    
            case "2_05":
                escribirTEX(des.getAbsolutePath() , des2_5(lista));
                break;    
            case "2_06":
                escribirTEX(des.getAbsolutePath() , des2_6(lista));
                break;    
            case "2_07":
                escribirTEX(des.getAbsolutePath() , des2_7(lista));
                break; 
            case "3_01":
                escribirTEX(des.getAbsolutePath() , des3_1(lista));
                break; 
            case "3_02":
                escribirTEX(des.getAbsolutePath() , des3_2(lista));
                break; 
            case "3_03":
                escribirTEX(des.getAbsolutePath() , des3_3(lista));
                break; 
            case "3_04":
                escribirTEX(des.getAbsolutePath() , des3_4(lista));
                break; 
            case "3_05":
                escribirTEX(des.getAbsolutePath() , des3_5(lista));
                break; 
            default:
                break;
        }
  }
    
    private void des1_11(){
        File f = new File(ruta, "1_11" + ".csv");
        System.out.println("RUTA CSV 11: " + f.getAbsolutePath());
        BufferedReader br = null;
        String line = "";
            boolean encabezado = true;
            
            List<Porcentaje> hombres = new ArrayList();
            List<Porcentaje> mujeres = new ArrayList();
            try {
                br = new BufferedReader(new FileReader(f.getAbsolutePath()));
            while ((line = br.readLine()) != null) {
                        if(encabezado){
                            encabezado = false;
                        }
                        else{
                String[] valores = line.split(";");
                            hombres.add(new Porcentaje(valores[0], valores[1]));
                            mujeres.add(new Porcentaje(valores[0], valores[2]));
                        }
                    }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            File seccion = new File(texs, "1_11");
        File des = new File(seccion, "descripcion");
        System.out.println("RUTA 11: " + des.getAbsolutePath());
        escribirTEX(des.getAbsolutePath(), des1_11(hombres, mujeres));  
    }
    
    /*
    Necesita 5 ternas de valores (tipo, porcentaje hombres y porcentaje mujeres)
    Se tienen 2 listas de Falta, una para hombres y otra para mujeres.
    El valor común en las 2 listas es el tipo de falta. 
    */
    private String des1_11(List<Porcentaje> mujeres, List<Porcentaje> hombres){
        return "La gráfica muestra la distribución porcentual por tipo de falta y sexo. Del total de infractores"
                + " que cometieron faltas contra "
                + hombres.get(0).getNombre().toLowerCase() + ", el "
                + hombres.get(0).getValor()
                + "\\% fueron hombres y el "
                + mujeres.get(0).getValor()
                + "\\% mujeres. En las faltas contra "
                + hombres.get(1).getNombre().toLowerCase()
                + ", el "
                + hombres.get(1).getValor()
                + "\\% de los infractores fueron hombres y el "
                + mujeres.get(1).getValor()
                + "\\% mujeres."
                ;
    }
    
    private String getMayorHombresMujeres(double hombres, double mujeres){
        if(hombres >= mujeres) return "" + (hombres-mujeres) + " casos, siendo los hombres los más incidentes.";
        else return "" + (mujeres-hombres) + " casos, siendo las mujeres las más incidentes.";
    }
    
    private String des1_1(List<Falta> lista){
        int actual = (int)(lista.get(lista.size()-1).getValor());
        int anterior = (int)(lista.get(lista.size()-5).getValor());
        String descripcion = "La gráfica de la serie histórica muestra un " + getDifFaltas(actual, anterior)
                + " personas en el " + (lista.get(lista.size()-1).getTrimestreCadena()) + " trimestre " + lista.get(lista.size()-1).getAnio()
                + ", comparado con el " + (lista.get(lista.size()-5).getTrimestreCadena()) + " trimestre del año " + lista.get(lista.size()-5).getAnio()
                + "."
                ;
        return descripcion;
    }
    
    private String getDifFaltas(int actual, int anterior){
        int diferencia = actual - anterior;
        if(diferencia < 0){
            return "decremento de " + (diferencia * -1);
        }else{
            return "incremento de " + diferencia;
        }
    }

    private String des1_2(List<Porcentaje> lista){
        return "La distribución porcentual de faltas muestra que los departamentos de "
                + lista.get(0).getNombre() + ", " + lista.get(1).getNombre() + " y "
                + lista.get(2).getNombre() + " tienen los porcentajes más altos de faltas judiciales.";
    }
    
    private String des1_3(List<Porcentaje> lista){
        return "En el área " + lista.get(0).getNombre() + " se registró la mayor incidencia de faltas judiciales con un "
                + lista.get(0).getValor() + "\\%. En el área " + lista.get(1).getNombre() + " "
                + lista.get(1).getValor() + "\\% y se desconoce el área geográfica en "
                + lista.get(2).getValor() + "\\% de los casos.";
    }
    
    private String des1_4(List<Porcentaje> lista){
        for(int i=0; i<lista.size(); i++){
            for(int j=0; j<lista.size(); j++){
                if(lista.get(i).getValor() < lista.get(j).getValor()){
                    Porcentaje aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }
        return "La gráfica muestra la distribución porcentual de faltas judiciales según el"
                + " rango de edad del infractor, que para el presente año refleja que el " 
                + lista.get(lista.size()-1).getValor() + "\\% de infractores oscila entre la edad de " + getRango(lista.get(lista.size()-1).getNombre()) + " años."
                ;
    }
    
    private String des1_5(List<Porcentaje> lista){
        return "La gráfica muestra la distribución porcentual de faltas judiciales"
                + " según el sexo del infractor, donde "
                + lista.get(0).getValor() + "\\% de infractores fueron hombres y " + lista.get(1).getValor() + "\\% mujeres.";
    }
    
    private String des1_6(List<Porcentaje> lista){
        return "La distribución de faltas judiciales según grupo étnico indica que el "
                + lista.get(0).getValor() + "\\% de las faltas cometidas fueron por personas " + lista.get(0).getNombre().toLowerCase() + "s.";
    }
    
    private String des1_7(List<Porcentaje> lista){
        return "Las personas " + lista.get(0).getNombre().toLowerCase() + "s son las que cometen más faltas judicailes, reportando un "
                + lista.get(0).getValor() + "\\%. Las personas " + lista.get(1).getNombre().toLowerCase() + "s presentan un "
                + lista.get(1).getValor() + "\\%.";
    }
    
    private String des1_8(List<Porcentaje> lista){
        for(int i=0; i<lista.size()-2; i++){
            for(int j=0; j<lista.size()-2; j++){
                if(lista.get(i).getValor() < lista.get(j).getValor()){
                    Porcentaje aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }
        return "El nivel de educación de los infractores indica las condiciones"
                + " de formación académica que tienen los infractores de faltas judiciales."
                + " La gráfica muestra que un " + lista.get(lista.size()-1).getValor() + "\\% de personas con nivel de escolaridad "
                + lista.get(lista.size()-1).getNombre().toLowerCase() + " cometen más faltas que los de nivel " + lista.get(lista.size()-2).getNombre().toLowerCase() + " con "
                + lista.get(lista.size()-2).getValor() + "\\% de faltas.";
    }
    
    private String des1_9(List<Porcentaje> lista){
        return "La gráfica muestra que un " + lista.get(0).getValor() + "\\% de personas que cometieron faltas estaban en estado de ebriedad. Sin embargo, un "
                + lista.get(1).getValor() + "\\% estaban sobrios.";
    }

    private String des1_10(List<Porcentaje> lista){
        return "La gráfica muestra que los tipos de faltas judiciales más incidentes son las en contra de " 
                + lista.get(0).getNombre().toLowerCase() + " (" + lista.get(0).getValor() + "\\%) y contra "
                + lista.get(1).getNombre().toLowerCase() + " (" + lista.get(1).getValor() + "\\%).";
    }

    private String des2_2(List<Porcentaje> lista){
        return "La gráfica muestra que los departamentos de " 
                + lista.get(0).getNombre() + ", " + lista.get(1).getNombre() + " y " + lista.get(2).getNombre() 
                + " presentan los casos más altos de infractores.";
    }

    private String des2_3(List<Porcentaje> lista){
        return "La gráfica muestra que las faltas cometidas por personas menores de 18 años tuvieron una incidencia de " 
                + lista.get(0).getValor() + "\\% por parte de hombres y " 
                + lista.get(1).getValor() + "\\% por parte de mujeres.";
    }

    private String des2_4(List<Porcentaje> lista){
        return "El " 
                +   lista.get(4).getValor() + "\\% de los menores infractores tienen 17 años y el " 
                +   (lista.get(3).getValor() + lista.get(2).getValor()) + "\\% están en un rango de edad de 15 a 16 años.";
    }   

    private String des2_5(List<Porcentaje> lista){
        return "Los infractores no indígenas representan el " 
                +   lista.get(1).getValor() + "\\% de los menores infractores y el " 
                +   lista.get(0).getValor() + "\\% son infractores indígenas.";
    }  

    private String des2_6(List<Porcentaje> lista){
        return "La gráfica muestra que el " 
                +   lista.get(0).getValor() + "\\% de los infractores menores de edad tienen nivel de escolaridad primaria y el " 
                +   lista.get(1).getValor() + "\\% nivel de escolaridad básico.";
    }   

    private String des2_7(List<Porcentaje> lista){
        return "La gráfica muestra que el " 
                +   lista.get(0).getValor() + "\\% de las infracciones de menores de edad fueron contra las personas, y el " 
                +   lista.get(2).getValor() + "\\% fueron contra la propiedad.";
    }   
    
    private String des3_1(List<Porcentaje> lista){
        return "La tendencia histórica muestra la gráfica del " + getFechaLetras(lista.get(lista.size()-1).getNombre()) 
               + ", registrando un " + getIncrementoDecremento(lista.get(lista.size()-1).getValor(), lista.get(lista.size()-5).getValor())
                + " infracciones respecto a las del " + getFechaLetras(lista.get(lista.size()-5).getNombre()) + ".";
    }   
    
    private String des3_2(List<Porcentaje> lista){
        return "Los datos registrados en la serie histórica en las fallas contra la propiedad hubo un"
                + getIncrementoDecremento(lista.get(lista.size()-1).getValor(), lista.get(lista.size()-5).getValor())
                + " faltas en el " + getFechaLetras(lista.get(lista.size()-1).getNombre()) 
                + " respecto al " + getFechaLetras(lista.get(lista.size()-5).getNombre()) + ".";
    }   
    
    private String des3_3(List<Porcentaje> lista){
        return "La secuencia de años anteriores en la serie histórica de faltas contra las buenas costumbres, muestra en el "
                + getFechaLetras(lista.get(lista.size()-1).getNombre()) + ",un "
                + getIncrementoDecremento(lista.get(lista.size()-1).getValor(), lista.get(lista.size()-5).getValor())
                + " faltas cometidas en relación al " + getFechaLetras(lista.get(lista.size()-5).getNombre()) + ".";
    }   
    
    private String des3_4(List<Porcentaje> lista){
        return "La gráfica muestra la serie histórica de faltas contra el orden público ocurridas entre el "
                + getFechaLetras(lista.get(0).getNombre()) + " y el "
                + getFechaLetras(lista.get(lista.size()-1).getNombre())
                + ", registrando "
                + getIncrementoDecremento(lista.get(lista.size()-1).getValor(), lista.get(lista.size()-5).getValor())
                + " faltas en el " + getFechaLetras(lista.get(lista.size()-1).getNombre())
                + " comparado con el " + getFechaLetras(lista.get(lista.size()-5).getNombre()) + ".";
    }   
    
    private String des3_5(List<Porcentaje> lista){
        return "Según datos registrados en la serie histórica para las otras faltas, hubo un"
                + getIncrementoDecremento(lista.get(lista.size()-1).getValor(), lista.get(lista.size()-5).getValor())
                + " faltas en el "
                + getFechaLetras(lista.get(lista.size()-1).getNombre()) + ", con respecto al "
                + getFechaLetras(lista.get(lista.size()-5).getNombre()) + ".";
    }   
    
    private String getIncrementoDecremento(Double val1, Double val2){
        if(val1 > val2) return " incremento de " + (int)(val1-val2);
        else return " decremento de " + (int)(val2-val1);
    }
    
    private String getFechaLetras(String abreviada){
        String fecha[] = abreviada.split("-");
        String trimestre = fecha[0];
        switch(trimestre){
            case "T1" :
                trimestre = "primer trimestre";
                break;
            case "T2" :
                trimestre = "segundo trimestre";
                break;
            case "T3" :
                trimestre = "tercer trimestre";
                break;
            case "T4" :
                trimestre = "cuarto trimestre";
                break;
            default:
                break;
        }
        return trimestre + " del año " + fecha[1];
    }

    private String getRango(String rangoConGuion){
        String[] valores = rangoConGuion.trim().split(" ");
        return valores[0] + " a " + valores[2];
    }
    
    
    
    private void escribirTEX(String nombre, String texto){
         File file = new File(nombre);
         file.getParentFile().setReadable(true, false);
        file.getParentFile().setExecutable(true, false);
        file.getParentFile().setWritable(true, false);
        file.getParentFile().mkdirs();
        String fileName = nombre + ".tex";
         Path textFile = Paths.get(fileName);
         List<String> lines = new ArrayList<>();
         lines.add(texto);
        try {
            Files.write(textFile, lines, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
