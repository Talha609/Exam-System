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
                /*ans[x]=currententry.getAns().toString().trim();
                o1[x]=currententry.getO1().toString().trim(); 
                o2[x]=currententry.getO2().toString().trim();
                o3[x]=currententry.getO3().toString().trim();*/
            }
            else
            {
                System.out.println("Error");
            }
        }
        //String ques[]={"_____________ is the sub-program within main program which process data and return value.","Constructor name is same as ___________ name.","An _________ is set of homogeneous data elements.","class is ____________ that define variable and method common to all object of certain kind.","Syntax for ternary operator."};
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
                /*System.out.println(ans[x][0]);
                System.out.println(ans[x][1]);
                System.out.println(ans[x][2]);
                System.out.println(ans[x][3]);*/
            }
            else
            {
                System.out.println("Error");
            }
        }
        //String ans[][]={{"class","variables","function","array"},{"class","array","function","variables"},{"array","list","variables","datatypes"},{"datatype","blueprint","method","package"},{"statement 1 : statement 2 ? condition","condition : statement 1 : statement 2","condition 1 : condition 2 ? statement","None of these"}};
        /*String que=ans[temp.get(--t)][j++];
        if(j==4)
        {
            i++;
            if(i==5)
            {
            //FirstSE.next.setEnabled(false);
            }
            j=0;
        }
        return que.toString().trim();*/
    }

    public static String Ans(int t)
    {
        String que=ans[temp.get(--t)][j++];
        if(j==4)
        {
            i++;
            /*if(i==5)
            {
            //FirstSE.next.setEnabled(false);
            }*/
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
        //System.out.println(num);
        return num;
    }

    public static void main(String args[])
    {
        QuesSE ques=new QuesSE();
    }
}