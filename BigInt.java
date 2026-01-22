import java.util.Scanner;
import java.util.ArrayList;

public class BigInt
{
    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(9);
        a.add(2);
        
        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(3);
        
        ArrayList<Integer> c = add(a, b);

        for (int i = 0; i < c.size(); i++)
        {
            System.out.println(c.get(i));
        }
    }

    public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        int leftover = 0;

        for (int i = Math.max(a.size(), b.size())-1; i > -1; i--)
        {
            if (i<a.size() && i<b.size())
            {
                int adig = a.get(i);
                int bdig = b.get(i);

                int newdig = (adig+bdig)%10;
                leftover = (adig+bdig)/10;

                ans.add(0, newdig+leftover);
            } else if (a.size() > b.size())
            {
                ans.add(0, a.get(i)+leftover);
            } else ans.add(0, b.get(i)+leftover);
        }

        return ans;
    }
}
