import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS
{
	/** function lcs **/
    public String lcs(String string1, String string2)
    {
        int l1 = string1.length();
        int l2 = string2.length();
 
        int[][] arr = new int[l1 + 1][l2 + 1];
 
        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                if (string1.charAt(i) == string2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else 
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
	
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2) 
        {
            if (string1.charAt(i) == string2.charAt(j)) 
            {
                sb.append(string1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1]) 
                i++;
            else
                j++;
        }
        return sb.toString();
    }
 
    /** Main Function **/
   
    	
    	  public static void main(String[] args) throws IOException
    	    { 
    		  BufferedReader br;
  	    	String st;
  			 String string1 ="";
  			//System.out.println("\nEnter string 1");
  			
  			 br = new BufferedReader(new FileReader("C:\\Users\\Tk\\Desktop\\Hello1.txt"));
  			  while ((st = br.readLine()) != null){
  				  string1 = string1 + st;
  			  }
  			  br.close();
  			  br = new BufferedReader(new FileReader("C:\\Users\\Tk\\Desktop\\Hello2.txt"));
  				 String string2 ="";
  				  while ((st = br.readLine()) != null){
  					  string2 = string2 + st;
  				  }
  				  br.close();
  				  //System.out.println(string2);
  				 // System.out.println(string1);
  				long startTime = System.currentTimeMillis();
  				//long startTime = System.nanoTime();
  				LCS  obj = new LCS(); 
  	        String result = obj.lcs(string1, string2);
  	      int length = result.length( );
  	    System.out.println("\nLongest Common Subsequence : "+ result);
  	        System.out.println("\nLongest Common Subsequence : "+ length);
  	      long endTime = System.currentTimeMillis();

  	    System.out.println("That took " + (endTime - startTime) + " milliseconds"); 
  	        	    }
 
}