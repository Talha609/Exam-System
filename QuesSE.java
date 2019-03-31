import java.util.*;
import javax.swing.*;
import java.util.Random.*;
import java.awt.event.*;
class QuesSE implements ActionListener
{
    static DB_Queries queries;
    static int i=0,j=0,entries1=GetQues.GetQues();
    static ArrayList<Integer> temp=Random();
    static List<Questions> result;
    static String ques[],ans[][],o1[],o2[],o3[];
    static Questions currententry;
    public static String Ques(int t)
    {
        queries=new DB_Queries();
        result=queries.getAllQues();
        ques=new String[entries1];
        ans=new String[entries1][4];
        for(int x=0;x<=entries1-1;x++)
        {
            int currentindex;
            if(entries1!=0)
            { 
                currentindex=x;
                currententry=result.get(currentindex);
                ques[x]=currententry.getQues().toString().trim();
            }
            else
            {
                System.out.println("Error");
            }
        }
        String que=ques[temp.get(--t)];
        AnsRand();
        return que.toString().trim();
    }

    public static void AnsRand()
    {
        queries=new DB_Queries();
        result=queries.getAllQues();
        for(int x=0;x<=entries1-1;x++)
        {
            ArrayList<Integer> options=RandomOptions();
            int currentindex;
            if(entries1!=0)
            { 
                currentindex=x;
                currententry=result.get(currentindex);
                ans[x][options.get(0)]=currententry.getAns().toString().trim();
                ans[x][options.get(1)]=currententry.getO1().toString().trim();
                ans[x][options.get(2)]=currententry.getO2().toString().trim();
                ans[x][options.get(3)]=currententry.getO3().toString().trim();
            }
            else
            {
                System.out.println("Error");
            }
        }
    }

    public static String Ans(int t)
    {
        String que=ans[temp.get(--t)][j++];
        if(j==4)
        {
            i++;
            j=0;
        }
        return que.toString().trim();
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==FirstSE.next && i==5)
        {
            FirstSE.next.setEnabled(false);
        }
    }

    public static ArrayList<Integer> Random()
    {
        Random r=new Random();
        ArrayList<Integer> num = new ArrayList<Integer>();
        while (num.size() < entries1) 
        { 
            int a = r.nextInt(entries1); 
            if (!num.contains(a)) 
            {
                num.add(a);
            }
        }
        return num;
    }

    public static ArrayList<Integer> RandomOptions()
    {
        Random r=new Random();
        ArrayList<Integer> num = new ArrayList<Integer>();
        while (num.size() < 4) 
        { 
            int a = r.nextInt(4); 
            if (!num.contains(a)) 
            {
                num.add(a);
            }
        }
        return num;
    }

    public static void main(String args[])
    {
        QuesSE ques=new QuesSE();
    }
}