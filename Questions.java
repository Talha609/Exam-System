class Questions
{
    String ques;
    String ans;
    String o1,o2,o3;
    int n;
    public Questions()
    {
    }
    public Questions(String n,String ans,String o1,String o2,String o3)
    {
        setQues(n);
        setAns(ans);
        setO1(o1);
        setO2(o2);
        setO3(o3);
    }
    
    public void setQues(String n)
    {
        ques=n;
    }
    public String getQues()
    {
        return ques;
    }
    
    public void setAns(String p)
    {
        ans=p;
    }
    public String getAns()
    {
        return ans;
    }
    
    public void setO2(String c)
    {
        o2=c;
    }
    public String getO2()
    {
        return o2;
    }
    
    public void setO1(String mp)
    {
        o1=mp;
    }
    public String getO1()
    {
        return o1;
    }
    
    public void setO3(String c)
    {
        o3=c;
    }
    public String getO3()
    {
        return o3;
    }
}