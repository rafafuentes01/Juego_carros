package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Guardar_Info {
	public static void podio(String info) throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyymmddHHmmss");
        File txt = new File("src/principal/"+formato.format(fecha)+"podio.txt");
        FileWriter podio_final = new FileWriter(txt);
        PrintWriter grabar = new PrintWriter(podio_final);
        grabar.write("Podio \n");
        grabar.println(info);
        podio_final.close();
    }

}
