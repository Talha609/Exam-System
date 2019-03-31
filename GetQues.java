import java.awt.*;
import java.util.List;
class GetQues //get no of ques
{
    static DB_Queries queries;
    static List< Questions > result;
    public static int GetQues()
    {
        queries=new DB_Queries();
        result=queries.getAllQues();
        queries.close();
        return result.size();
    }

    public static void main(String args[])
    {
        new GetQues();
    }
}