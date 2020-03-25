package threadPlay.util;

public class IsPrime implements IsPrimeI{

	public int primeCheck(String number)
	{	
		int num=Integer.parseInt(number);
		boolean prime=true;
		for(int i=2;i<=num/2;i++)
		{
			if (num % i == 0) {
				prime = false;
			}
		}
		if(prime)
			return num;
		return 0;
	}
}
