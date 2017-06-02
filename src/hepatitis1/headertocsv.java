package hepatitis1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class headertocsv {
	public static void main(String args[]){
		
		 String str = "CLASS,AGE,SEX,STEROID,ANTIVIRALS,FATIGUE, MALAISE,ANOREXIA,LIVER BIG, LIVER FIRM,SPLEEN PALPABLE,SPIDERS,ASCITES,VARICES,BILIRUBIN,ALK PHOSPHATE,SGOT,ALBUMIN,PROTIME,HISTOLOGY";  
		    byte data[] = str.getBytes();       

		    try {                           
		            RandomAccessFile f = new RandomAccessFile(new File("minmax.csv"), "rw");
		            f.getChannel().position(0);         
		            f.write(data);
		            f.close();
		    } catch (IOException e) {       
		            e.printStackTrace();
		    }


	

}

}
