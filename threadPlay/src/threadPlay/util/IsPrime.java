package threadPlay.util;

public class IsPrime implements IsPrimeI{

/**
 * Checks if a number is prime or not
 * @param number number to be checked 
 */

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
	@Override
    public String toString(){
        String returnValue="Returns if value is prime or not";
        return returnValue;
}
}
