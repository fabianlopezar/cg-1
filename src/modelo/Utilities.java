package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author INTEL i 7
 */
public class Utilities {

    // Metodo para guardar datos.
    public static boolean saveFile(LinkedList<Cliente> listaC) throws IOException {
        boolean t = false;
        FileWriter fileWriter = new FileWriter("clientes.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Cliente elem : listaC) {
            printWriter.println(elem.toString());
        }

        t = true;
        printWriter.close();
        return t;
    }

    //Metodo para cargar datos.
    public static LinkedList<Cliente> readFile() throws IOException {
        LinkedList<Cliente> listaC = new LinkedList<>();
        try {
            File myObj = new File("clientes.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                if(data.equals("")){
                    
                }else{
                    String[]arrLinea=data.split(",");
                    //                     codigo      edad                           nombre       telefono     correo
                    listaC.add(new Cliente(arrLinea[3],Integer.parseInt(arrLinea[4]), arrLinea[0], arrLinea[1], arrLinea[2]));
                }
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return listaC;
    }
}
