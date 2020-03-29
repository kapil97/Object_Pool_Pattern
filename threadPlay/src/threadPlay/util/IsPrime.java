package threadPlay.util;

public class IsPrime implements IsPrimeI{

	public synchronized boolean primeCheck(String number)
	{	
		int num=Integer.parseInt(number);
		boolean prime=true;
		if(num==1)
			prime=false;
		else
		{
			for(int i=2;i<=num/2;i++)
			{
				if (num % i == 0) {
					prime = false;
				}
			}
		
			
		
		}

		return prime;
	}
}
