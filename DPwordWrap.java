public class DPwordWrap
{   

	public static void WordWrap(int text[],int p[],int width)
	{
	    int [][]extra=new int[text.length+1][];
	    extra[0]=new int[text.length+1];
	    for(int i=1;i<=text.length;i++)
	    {   
	    	extra[i]=new int[text.length+1];
	    	extra[i][i]=width-text[i-1];
	    	for(int j=i+1;j<=text.length;j++)
	    		extra[i][j]=extra[i][j-1]-text[j-1]-1;
	    }
	    
	    int [][]cl=new int [text.length+1][];
	    for(int i=1;i<=text.length;i++)
	    {
	    	cl[i]=new int[text.length+1];
	    	for(int j=i;j<=text.length;j++)
	    	{
	    		if(extra[i][j]<0)
	    			cl[i][j]=Integer.MAX_VALUE;
	    		else if(j==text.length)
	    		         {
	    			cl[i][j]=0;
	    		         }
	    		      else
	    			     {
	    		    	 cl[i][j]=extra[i][j]*extra[i][j];
	    			     }
	    	}
	    }
	    int []d=new int[text.length+1];
	    d[0]=0;
	    for(int i=1;i<=text.length;i++)
	    {   
	    	d[i]=Integer.MAX_VALUE;
	    	for(int j=1;j<=i;j++)
	    	{
	    		if(d[i-1]!=Integer.MAX_VALUE&&cl[j][i]!=Integer.MAX_VALUE&&d[i]>d[j-1]+cl[j][i])
	    		{
	    			d[i]=d[j-1]+cl[j][i];
	    			p[i]=j;
	    		}
	    	}
	    }
	    print(p,text.length); 
	}
	public static int print(int p[],int n)
	{   int k;
		if(p[n]==1)
			k=1;
		else
			k=print(p,p[n]-1)+1;
		System.out.println("第"+k+"行:"+p[n]+"->"+n);
		return k;
	}
	    public static void main(String[] args)
	    {
	    	  int l[] = {3, 2, 2, 5}; 
	    	  int M = 6; 
	    	  int []q=new int[5];
	    	  WordWrap(l,q,M); 
	    	
	    }
}