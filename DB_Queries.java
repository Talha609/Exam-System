import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
class DB_Queries
{
    Connection c;
    PreparedStatement getques=null,insert=null,allques=null,delete=null;
    public DB_Queries()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Questions;integratedSecurity=true;");
            getques=c.prepareStatement("SELECT * FROM QuesTable WHERE Questions = ?");
            insert=c.prepareStatement("INSERT INTO QuesTable VALUES(?,?,?,?,?)");
            allques=c.prepareStatement("SELECT * FROM QuesTable");
            delete=c.prepareStatement("DELETE FROM QuesTable");
            //System.out.println("Query Passed");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public List< Questions > getQues(String name)
    {
        List< Questions > results=null;
        ResultSet resultSet=null;
        try
        {
            getques.setString(1,name);
            resultSet=getques.executeQuery();
            results=new ArrayList< Questions >();
            while(resultSet.next())
            {
                results.add(new Questions(resultSet.getString("Questions"),resultSet.getString("Answer"),resultSet.getString("O1"),resultSet.getString("O2"),resultSet.getString("O3")));
            }   
        }   
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                close();
            }
        }
        return results;
    }

    public int addQues(String ques,String ans,String o1,String o2,String o3)
    {
        int r=0;
        try
        {
            insert.setString(1,ques);
            insert.setString(2,ans);
            insert.setString(3,o1);
            insert.setString(4,o2);
            insert.setString(5,o3);
            //result=insert.execute();
            r=insert.executeUpdate();
            //System.out.println("Products Added");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            close();
        }
        //return result;
        return r;
    }

    public void del()
    {
        try
        {
            delete.executeUpdate();
        }
        catch(Exception e)
        {
        }
    }
    public List< Questions > getAllQues()
    {
        List< Questions > results=null;
        ResultSet resultSet=null;
        try
        {
            resultSet=allques.executeQuery();
            results=new ArrayList< Questions >();
            while(resultSet.next())
            {
                results.add(new Questions(resultSet.getString("Questions"),resultSet.getString("Answer"),resultSet.getString("O1"),resultSet.getString("O2"),resultSet.getString("O3")));
                //System.out.println(resultSet.getString("Questions"));
            }   
        }   
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                close();
            }
        }
        return results;
    }

    public void close()
    {
        try
        {
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new DB_Queries();
    }
}