import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


public class BAJASDAT {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */	
	
public static int  convierteaentero (char aconvertir){
		
		switch((int)aconvertir){
		case 48:
	        return(0);	     		
		case 49:
			return(1);	     
		case 50:
			return(2);	 
		case 51:
			return(3);	       
		case 52:
			return(4);	        
		case 53:
			return(5); 	       
		case 54:
			return(6);	       	        
		case 55:
			return(7);	       
		case 56:
			return(8);	      
		case 57:
			return(9);	        
	    default:
	        System.out.println("No puedo sacar el entero del char");				
		}
		return (aconvertir);	      	   				
	}
	
		
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try{			
		File archivo = new File ("sdat.txt");
	    FileReader fr = null;
	    BufferedReader br = null;
	    
	    
	    fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        
        String sdat=""; 
        sdat=br.readLine();
       
        int resultado1;
        int resultado2;
        int resultado3;
        int resultado4;
        int buscado=0;
        System.out.println("Intento bajar");
        System.out.println(sdat);
                
		File directorio = new File("sdat");		
	//	directorio.mkdir();
		
		 while (buscado!=1){	        
	
		
		//URL url = new URL("ftp://ftp.nai.com/licensed/antivirus/datfiles/4.x/"+sdat+";type=i");		
			 URL url = new URL("ftp://ftp.nai.com/licensed/_spanish/antivirus/superdat/"+sdat+";type=i");
		URLConnection con = url.openConnection();
		
		if (con.getContentLength()==-1) { //si mal
				  		

				resultado1=convierteaentero(sdat.charAt(4));
				resultado2=convierteaentero(sdat.charAt(5));
				resultado3=convierteaentero(sdat.charAt(6));
				resultado4=convierteaentero(sdat.charAt(7));
	       		  		        
				if (resultado4==9){     
					resultado4=0;
					resultado3=resultado3+1;
					if (resultado3==10){
						resultado3=0;
						resultado2=resultado2+1;
						if (resultado2==10){
							resultado2=0;
							resultado1=resultado1+1;
						}
					}
					//System.out.println(resultado1);
					//System.out.println(resultado2);
					//System.out.println(resultado3);
					//System.out.println(resultado4);
				}
				else {
					resultado4=resultado4+1; 			  		        	
				}

			sdat="sdat"+resultado1+resultado2+resultado3+resultado4+".exe";		  						  				
			//	System.out.println("pruebo con este otro : "+sdat);		  				
		
		}		  			  		  				  	
		else{  //si bien	
		
		
			BufferedInputStream in = new BufferedInputStream(con.getInputStream());
			FileOutputStream out = new FileOutputStream(directorio.getAbsoluteFile()+"\\sdat.exe");					
			int i = 0;
			byte[] bytesIn = new byte[1024];
			System.out.println("Bajando...");
			
						
			while ((i = in.read(bytesIn)) >= 0) {
				out.write(bytesIn, 0, i);				
			}
			 
			out.close();
			in.close();				
			
			 resultado1=convierteaentero(sdat.charAt(4));
		     resultado2=convierteaentero(sdat.charAt(5));
		     resultado3=convierteaentero(sdat.charAt(6));
		     resultado4=convierteaentero(sdat.charAt(7));
		       
		        
		        if (resultado4==9){     
		        	resultado4=0;
		        	resultado3=resultado3+1;
		        	if (resultado3==10){
		        		resultado3=0;
		        		resultado2=resultado2+1;
		        		if (resultado2==10){
		        			resultado2=0;
		            		resultado1=resultado1+1;
		        		}
		        	}
		        	 System.out.println(resultado1);
		             System.out.println(resultado2);
		             System.out.println(resultado3);
		             System.out.println(resultado4);
		        }
		        else {
		        	resultado4=resultado4+1; 
		        	System.out.print("en el else");
		        }

		        BufferedWriter bw =new BufferedWriter (new FileWriter(archivo));
		        bw.write("sdat"+resultado1+resultado2+resultado3+resultado4+".exe");
		        bw.close();				
		
		
			buscado=1;
		}  // FIN DEL ELSE
	
		
	 }//FIN DEL WHILE
		
	
		}
		catch (Exception ex) {			
	       // ex.printStackTrace();
	        //System.out.println(ex.getMessage());	        
	    }			    	
	}
}
