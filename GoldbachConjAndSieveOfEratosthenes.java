import java.util.Scanner;
import java.util.ArrayList;

public class GoldbachConjAndSieveOfEratosthenes
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an even number greater than 2");

        ArrayList<Integer> s = sieve(100);
        for (int i = 0; i < s.size(); i++)
        {
            System.out.println(s.get(i));
        }

        if (!in.hasNextInt())
        {
            System.out.println("Not a valid number");
            System.exit(0);
        }

        int num = in.nextInt();

        if (num%2 == 1 || num == 2)
        {
            System.out.println("Not a valid number");
            System.exit(0);
        }

        ArrayList<Integer> nums = sieve(num);

        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < nums.size(); i++)
        {
            for (int j = i; j < nums.size(); j++)
            {
                if (nums.get(i) + nums.get(j) == num)
                {
                    ans1 = nums.get(i);
                    ans2 = nums.get(j);
                }
            }
        }

        System.out.println(num + " = " + ans1 + " + " + ans2);
    }

    public static ArrayList<Integer> sieve(int n)
    {
        ArrayList<Integer> lst = new ArrayList();

        for (int i = 2; i < n; i++)
        {
            lst.add(i);
        }

        int p = 2;
        for (int j = 0; j < lst.size(); j++)
        {
            for (int i = j+1; i < lst.size(); i++)
            {
                if (lst.get(i)%p == 0)
                {
                    lst.remove(i);
                    i--;
                }
            }
            p = lst.get(j);
        }

        return lst;
    }
}