import java.math.BigInteger;
import java.security.SecureRandom;

public class rsa {

	public static void main(String[] args){
		
		//Creates a BigInteger ONE to subtract 1 from a BigInteger bc you can't subtract an int from BigInteger
		BigInteger ONE = new BigInteger("1");
		//Secure Random is just a completely unpredictable RND
		SecureRandom rand = new SecureRandom();

		//Creates the BigIntegers for equation
		BigInteger d, e, n;
		BigInteger p = BigInteger.probablePrime(128, rand);
		BigInteger q = BigInteger.probablePrime(128, rand);
		//Finds the Phi of Q 
		BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));
		
		n = p.multiply(q);
		e = new BigInteger("65537");
		d = e.modInverse(phi);

		String string = "this is a test";
		BigInteger plainText = new BigInteger(string.getBytes());
		BigInteger cipherText = plainText.modPow(e, n);
		BigInteger originalMessage = cipherText.modPow(d, n);
		String decrypted = new String(originalMessage.toByteArray());

		System.out.println("original: " + string);
		System.out.println("encrypted: " + cipherText);
		System.out.println("decrypted: " + decrypted);
		
	}
	
}

