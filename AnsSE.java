import java.util.*;
class AnsSE
{
    static DB_Queries queries;
    static Questions currententry;
    static List<Questions> result;
    static String ques[],ans[];
    public static void Ans()
    {
    }

    public static int AnsCheck(String q,String a)
    {
        try
        {
            queries=new DB_Queries();
            result=queries.getAllQues();
            int entries1=result.size();
            ques=new String[entries1];
            ans=new String[entries1];
            for(int x=0;x<=entries1-1;x++)
            {
                int currentindex,temp;
                if(entries1!=0)
                { 
                    currentindex=x;
                    currententry=result.get(currentindex);
                    ques[x]=currententry.getQues().toString().trim();
                    ans[x]=currententry.getAns().toString().trim();
                }
                else
                {
                    System.out.println("Error");
                }
            }
            for(int x=0;x<=result.size();x++)
            {
                if(q.equals(ques[x]) && a.equals(ans[x]))
                {
                    return 1;
                }
            }
        }
        catch(Exception e)
        {
        }
        return 0;
    }

    public static void main(String args[])
    {
        AnsSE.Ans();
    }
}
