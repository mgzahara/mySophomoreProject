public class Roommates {
    
    private Student first, second;
    
    
    public Roommates()
    {//constructor
        first = new Student();
        second = new Student();
    }
    public Roommates(Roommates r)
    {//copy constructor
        this.first = r.first;
        this.second = r.second;
    }
    public void addFirst(Student f)
    {
        first = f;
    }
    public void addSecond(Student s)
    {
        second = s;
    }
    public Student getFirst()
    {
        return first;
    }
    public Student getSecond()
    {
        return second;
    }
    public Integer getGradYearDelta()
    {
        Integer toReturn = 0;
        if(first.getGradYearDelta() < second.getGradYearDelta() )
        {
            toReturn = first.getGradYearDelta();
        }
        else
        {
            toReturn = second.getGradYearDelta();
        }
        return toReturn;
    }
    public Integer getGradYear()
    {
        Integer toReturn = 0;
        if(first.getGradYear() < second.getGradYear() )
        {
            toReturn = first.getGradYear();
        }
        else
        {
            toReturn = second.getGradYear();
        }
        return toReturn;
    }
    public Integer getFirstRoomPreference()
    {
        Integer toReturn = 0;
        if(first.getGradYear() < second.getGradYear() )
        {
            toReturn = first.getFirstRoomPreference();
        }
        else
        {
            toReturn = second.getFirstRoomPreference();
        }
        return toReturn;
    }
    public Integer getSecondRoomPreference()
    {
        Integer toReturn = 0;
        if(first.getGradYear() < second.getGradYear() )
        {
            toReturn = first.getSecondRoomPreference();
        }
        else
        {
            toReturn = second.getSecondRoomPreference();
        }
        return toReturn;
    }
    public String getGender()
    {
        return first.getGender();
    }
    public String printRoommates()
    {
        String line = "";
        line = line + first.getLastName() + 
                ", " + first.getFirstName() + 
                " - A" + first.getID();
        if(!second.getFirstName().equals("") )
        {//"second" must be an actual Student obj, not just the default new Student
            line = line + "\n" + 
                    second.getLastName() + 
                    ", " + second.getFirstName() + 
                    " - A" + second.getID();
        }
        return line;
    }
}
