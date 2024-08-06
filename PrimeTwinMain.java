import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimeTwinMain {

    public static void main(String[] args) {
        List<Integer> primes = generatePrimesUpTo(40000);
        List<Integer> twinPrimes = findTwinPrimes(primes);

        try (FileWriter writer = new FileWriter("A_PrimeTwin.txt")) {
            for (int prime : twinPrimes) {
                System.out.println(prime);
                writer.write(prime + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> generatePrimesUpTo(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static List<Integer> findTwinPrimes(List<Integer> primes) {
        List<Integer> twinPrimes = new ArrayList<>();
        for (int i = 0; i < primes.size() - 1; i++) {
            if (primes.get(i + 1) - primes.get(i) == 2) {
                twinPrimes.add(primes.get(i));
                twinPrimes.add(primes.get(i + 1));
            }
        }
        return twinPrimes;
    }
}
