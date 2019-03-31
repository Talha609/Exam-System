import java.util.Calendar;
class Time
{
    public Time()throws Exception
    {
        for(;;)                   
        {
            Calendar c=Calendar.getInstance();
            System.out.print("Time :- " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
            Thread.sleep(300);   
            System.out.println("\t\t\t\t\t\t"+"\f");              
        }
    }
    public static void main(String args[])throws Exception 
    {
        new Time();
    }
}