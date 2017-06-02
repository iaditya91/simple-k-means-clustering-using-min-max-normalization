package hepatitis1;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class CsvToArff {
     
  public static void main(String[] args) throws Exception {
   
 
    // load CSV
    CSVLoader loader = new CSVLoader();
    loader.setSource(new File("minmax.csv"));
    Instances data = loader.getDataSet();
    String fileName = "hepatitis.arff";


    // save ARFF
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    writer.write(data.toString());
    writer.flush();
    writer.close();

  }
}