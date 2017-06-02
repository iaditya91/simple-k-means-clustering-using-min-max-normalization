package hepatitis1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;



public class minmax {
	
	private static int counterdata;
	private static int fieldlen;
	
	
	public static void main(String args[]){
		float data[][]= new float[2000][2000];
		String s=readfile("hepetitis.csv");
		String has[]=s.split("\n");
		for(int i=0;i<has.length;i++){
			String fields[]=has[i].split(",");
			fieldlen=fields.length;
			for(int j=0;j<fields.length;j++){
				try{
				data[i][j]=Float.valueOf(fields[j]);
			    counterdata++;
				}catch(NumberFormatException e){
					System.out.println(e.getMessage());
				}
			}	
			
		}
		System.out.println("MIN-MAX");
		minmaxnorm(data);	
	}
	
	
	
	//readfile
	public static String readfile(String file1)
	{
		BufferedReader br=null;
		String ab="";
		try{
			String cline;
			br=new BufferedReader(new FileReader(file1));
			//d=br.readLine();
			while((cline=br.readLine())!=null)
				{ab=ab+cline+"\n";}
		}catch(IOException e)
		{
			System.out.println("cannot open file"+file1);
		}finally{
			try{
				if(br!=null)
				br.close();
			} catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
		}
	
		return ab;
	}

   
	//minmax norm method
	public static void minmaxnorm(float[][] data){
		float newdata[][]=new float[2000][2000];
		String s;
		int i,j,fielddat=counterdata/fieldlen;
		int newmax=1;
		int newmin=0;
	    for(j=0;j<fieldlen;j++){
		float max=max(data,j);
		float min=min(data,j);
		for(i=0;i<fielddat;i++){
			 newdata[i][j] = ((data[i][j]-min)*(newmax-newmin))/((max-min)+newmin);
		}
		}
	    DecimalFormat df=new DecimalFormat("#.##");
	    s="\n";
	    newFile(s,"minmax.csv");
	    for(j=0;j<fielddat;j++){
	     s=	 df.format(newdata[j][0])+","+df.format(newdata[j][1])+","+df.format(newdata[j][2])+","+df.format(newdata[j][3])+","+df.format(newdata[j][4])+","+df.format(newdata[j][5])+","+df.format(newdata[j][6])+","+df.format(newdata[j][7])+","+df.format(newdata[j][8])+","+df.format(newdata[j][9])+","+df.format(newdata[j][10])+","+df.format(newdata[j][11])+","+df.format(newdata[j][12])+","+df.format(newdata[j][13])+","+df.format(newdata[j][14])+","+df.format(newdata[j][15])+","+df.format(newdata[j][16])+","+df.format(newdata[j][17])+","+df.format(newdata[j][18])+","+data[j][fieldlen-1];
	    newFile(s,"minmax.csv");
	      System.out.println(s);
	    }
		
	}

  
	
	//min method
	public static float min(float[][] data,int j){
		float min=1000;
		int i,fieldcol=counterdata/fieldlen;
		for(i=0;i<fieldcol;i++){
			   if(min>data[i][j]){
	                min=data[i][j];}
		}
	return min;
	}

	
	
	
	//max method
	public static float max(float[][] data,int j) {
        float max = 0;
        int fieldcol=counterdata/fieldlen;
        for(int i=0;i<fieldcol;i++){     
            if(data[i][j]>max){
                max=data[i][j];
           }
        }
        return max;
    }
	
	
	
	
	
	//new file method
	public static void newFile(String s,String file2){
		try{
			PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file2,true)));
			out.println(s.toString());
			out.close();
			
		}catch(IOException e)
		{
			System.out.print(e.getMessage());
		}
	}
}



