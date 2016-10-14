
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

	//Makes the needed variables for the math
	private BigInteger n, d, e;
	
	//Declares the max bit length
	private static int bitlen = 1024;
	
	//This method allows for a different public key to be used
	public RSA(BigInteger newN, BigInteger newE){
		n = newN;
		e = newE;
	}
	
	//This method can both encrypt and decrypt
	public RSA(int bits){
		//Makes the bit length the length of the input
		bitlen = bits;
		//Makes a Secure RNG
		SecureRandom r = new SecureRandom();
		//Makes the two numbers to get the huge prime number
		BigInteger p = new BigInteger(bitlen/2, 100, r);
		BigInteger q = new BigInteger(bitlen/2, 100, r);
		//Multiplies the two big ints to get the number that makes the prime num
		n = p.multiply(q);
	}
	
}
