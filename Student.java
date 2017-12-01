import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Matt
 */
public class Student {
    
    private String firstName, lastName, idNum, gender;
    private Integer gradYear;
	
    //hard match categories
    private boolean smoker, rmSmoker, earlyBedTime, studyInRoom, roomMateSigOther;//true -> okay w/rommate having bf/gf over | false -> NOT okay w/rommate having bf/gf over
    
    //soft match categories
    private Integer whileStudying, borrow, firstRoomPreference, secondRoomPreference;
    private boolean firstPrivateRoomDesired, secondPrivateRoomDesired, neat;
    private String wantToRoomWithFname, wantToRoomWithLname, wantToRoomWithID;
    private ArrayList<String>softMatches;
    
    public Student()
    {//default constructor
        this.smoker = true;
        this.rmSmoker = true;
        this.earlyBedTime = true;
        this.studyInRoom = true;
        this.roomMateSigOther = true;
        this.neat = true;
        this.firstName = "";
        this.lastName = "";
		this.idNum = "";
		this.gradYear = 0;
        this.gender = "";
        this.whileStudying = 0;
        this.borrow = 0;
        this.firstRoomPreference = 0;
        this.secondRoomPreference = 0;
        this.firstPrivateRoomDesired = false;
        this.secondPrivateRoomDesired = false;
        this.wantToRoomWithFname = "";
        this.wantToRoomWithLname = "";
        this.wantToRoomWithID = "";
        this.softMatches = new ArrayList<>();
    }
    public Student(String firstName, String lastName, boolean smoker, boolean earlyBedTime, 
                   boolean studyInRoom, boolean roomMateSigOther,
		   String id, Integer gradYear, String gender)
    {//overloaded constructor
        this.smoker = smoker;
        this.rmSmoker = true;
        this.earlyBedTime = earlyBedTime;
        this.studyInRoom = studyInRoom;
        this.roomMateSigOther = roomMateSigOther;
        this.firstName = firstName;
        this.lastName = lastName;
	this.idNum = id;
	this.gradYear = gradYear;
	this.gender = gender;
        this.softMatches = new ArrayList<String>();
        this.neat = true;
        this.whileStudying = 0;
        this.borrow = 0;
        this.firstRoomPreference = 0;
        this.secondRoomPreference = 0;
        this.firstPrivateRoomDesired = false;
        this.secondPrivateRoomDesired = false;
    }
    Student(Student s)
    {//copy constructor
        this.smoker = s.smoker;
        this.rmSmoker = s.rmSmoker;
        this.earlyBedTime = s.earlyBedTime;
        this.studyInRoom = s.studyInRoom;
        this.roomMateSigOther = s.roomMateSigOther;
        this.firstName = s.firstName;
        this.lastName = s.lastName;
	this.idNum = s.idNum;
	this.gradYear = s.gradYear;
	this.gender = s.gender;
        for(String thing : s.softMatches)
        {
            addToArrayList(thing);
        }
        this.neat = s.neat;
        this.whileStudying = s.whileStudying;
        this.borrow = s.borrow;
        this.firstRoomPreference = s.firstRoomPreference;
        this.secondRoomPreference = s.secondRoomPreference;
        this.firstPrivateRoomDesired = s.firstPrivateRoomDesired;
        this.secondPrivateRoomDesired = s.secondPrivateRoomDesired;
        //compatibility is not included in this function 
        //because the only reason to use a copy constructor
        //is to hold a Student obj during a loop to calc compatibility
    }
    
    
    //setters
    //<editor-fold>
    public void setWantToRoomWithFname(String s)
    {
        this.wantToRoomWithFname = s;
    }
    public void setWantToRoomWithLname(String s)
    {
        this.wantToRoomWithLname = s;
    }
    public void setWantToRoomWithID(String s)
    {
        this.wantToRoomWithID = s;
    }
    public void setFirstPrivateRoomDesired(Boolean b)
    {
        this.firstPrivateRoomDesired = b;
    }
    public void setSecondPrivateRoomDesired(Boolean b)
    {
        this.secondPrivateRoomDesired = b;
    }
    public void setFirstRoomPreference(Integer i)
    {
        this.firstRoomPreference = i;
    }
    public void setSecondRoomPreference(Integer i)
    {
        this.secondRoomPreference = i;
    }
    public void setNeat(boolean n)
    {
        this.neat = n;
    }
    public void setWhileStudying(Integer i)
    {
        this.whileStudying = i;
    }
    public void setBorrow(Integer i)
    {
        this.borrow = i;
    }
    public void setID(String id)
    {
	this.idNum = id;
    }
    public void setGender(String s)
    {
        this.gender = s;
    }
    public void setGradYear(Integer year)
    {
	this.gradYear = year;
    }
    public void setFirstName(String n)
    {
        this.firstName = n;
    }
    public void setLastName(String n)
    {
        this.lastName = n;
    }
    public void setSmoker(boolean s)
    {
        this.smoker = s;
    }
    public void setRmSmoker(boolean s)
    {
        this.rmSmoker = s;
    }
    public void setEarlyBedTime(boolean ebt)
    {
        this.earlyBedTime = ebt;
    }
    public void setStudyInRoom(boolean sir)
    {
        this.studyInRoom = sir;
    }
    public void setRoomMateSigOther(boolean rmso)
    {
        this.roomMateSigOther = rmso;
    }
    public void addToArrayList(String s)
    {
        softMatches.add(s);
    }
    //</editor-fold>
    
    //getters
    //<editor-fold>
    public String getWantToRoomWithFname()
    {
        return this.wantToRoomWithFname;
    }
    public String getWantToRoomWithLname()
    {
        return this.wantToRoomWithLname;
    }
    public String getWantToRoomWithID()
    {
        return this.wantToRoomWithID;
    }
    public Integer getGradYearDelta()
    {
        return Calendar.getInstance().get(Calendar.YEAR) - this.gradYear;
    }
    public boolean getFirstPrivateRoomDesired()
    {
        return this.firstPrivateRoomDesired;
    }
    public boolean getSecondPrivateRoomDesired()
    {
        return this.secondPrivateRoomDesired;
    }
    public Integer getFirstRoomPreference()
    {
        return this.firstRoomPreference;
    }
    public Integer getSecondRoomPreference()
    {
        return this.secondRoomPreference;
    }
    public String getID()
    {
            return this.idNum;
    }
    public Integer getGradYear()
    {
            return this.gradYear;
    }
    public String getGender()
    {
        return this.gender;
    }
    public boolean getSmoker()
    {
        return this.smoker;
    }    
    public boolean getRmSmoker()
    {
        return this.rmSmoker;
    }
    public boolean getEarlyBedTime()
    {
        return this.earlyBedTime;
    }
    public boolean getStudyInRoom()
    {
        return this.studyInRoom;
    }
    public boolean getRoomMateSigOther()
    {
        return this.roomMateSigOther;
    }
    public boolean getNeat()
    {
        return this.neat;
    }
    public Integer getWhileStudying()
    {
        return this.whileStudying;
    }
    public Integer getBorrow()
    {
        return this.borrow;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getWholeName()
    {
        return (this.firstName + " " + this.lastName);
    }
    public String getFinalOutput()
    {
        String line = "";
		if(this.firstName.equals("") )
		{
			return line;
		}
        line = line + getWholeName() + " - A" + this.idNum;
        return line;        
    }
    public String getSaveOutput()
    {//returns a single string for output/save
        String line = "";
        
        line = line + firstName + ",";
        line = line + lastName + ",";
        line = line + idNum + ",";
        line = line + gradYear.toString() + ",";
        line = line + gender + ",";
        if(smoker)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        if(rmSmoker)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        if(earlyBedTime)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        if(studyInRoom)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        if(roomMateSigOther)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        if(neat)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        line = line + whileStudying.toString() + ",";
        line = line + borrow.toString() + ",";
        line = line + firstRoomPreference.toString() + ",";
        line = line + secondRoomPreference.toString() + ",";
        if(firstPrivateRoomDesired)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        if(secondPrivateRoomDesired)
        { line = line + "1,"; }
        else
        { line = line + "0,"; }
        line = line + wantToRoomWithFname + ",";
        line = line + wantToRoomWithLname + ",";
        line = line + wantToRoomWithID + ",";
        for(int i = 0; i < softMatches.size(); i++)
        {
            if(i == (softMatches.size() - 1) )
            {
                line = line + softMatches.get(i);
            }
            else
            {
                line = line + softMatches.get(i) + ",";
            }
        }
        
        return line;
    }
    public ArrayList<String> getSoftMatches()
    {
        return this.softMatches;
    }
    //</editor-fold>
            
    public Boolean isHardMatch(Student right)
    {//returns true ONLY if all hard match categories are the same
        return (   (this.smoker           == right.smoker) 
                && (this.earlyBedTime     == right.earlyBedTime)
                && (this.studyInRoom      == right.studyInRoom)
                && (this.roomMateSigOther == right.roomMateSigOther) );
    }
    public Integer getSimilarFactor(Student right)
    {//write this later to calculate compatibility
        Integer similarFactor = 0;
        
        //if ant hardMatch factor is the same, reward heavily
        //this will not affect normal matching since they must be hardMatches anyway
        //this only matters when matching the homeless
        if(this.smoker == right.smoker) 
        {
            similarFactor = similarFactor + 15;
        }
        if(this.earlyBedTime == right.earlyBedTime)
        {
            similarFactor = similarFactor + 15;
        }
        if(this.studyInRoom == right.studyInRoom)
        {
            similarFactor = similarFactor + 15;
        }
        if(this.roomMateSigOther == right.roomMateSigOther)
        {
            similarFactor = similarFactor + 15;
        }
        
        
        
        
        if(this.neat == right.neat)
        {
            similarFactor = similarFactor + 6;
        }
        else
        {
            similarFactor = similarFactor - 6;
        }
        switch( abs(this.whileStudying - right.whileStudying) )
        {
            case 0: similarFactor = similarFactor + 6;  break;//exactly the same choice
            case 1: similarFactor = similarFactor - 3;  break;//one off in either direction
            case 2: similarFactor = similarFactor - 6;  break;//largest diff possible
            default: break;
        }
        switch( abs(this.borrow - right.borrow) )
        {
            case 0: similarFactor = similarFactor + 6;  break;//exactly the same choice
            case 1: similarFactor = similarFactor - 3;  break;//one off in either direction
            case 2: similarFactor = similarFactor - 6;  break;//largest diff possible
            default: break;
        }
        for(int i = 0; i < this.softMatches.size(); i++)
        {
            for(int j = 0; j < right.softMatches.size(); j++)
            {
                if(this.softMatches.get(i).equals(right.softMatches.get(j) ) )
                {
                    similarFactor++;
                }
            }
        }
        
        return similarFactor;
    }
    public void display()
    {//probably get rid of
        System.out.println("------------------------");
        System.out.println(this.idNum);        
        System.out.println(this.firstName + " " + this.lastName +  " " + this.gradYear +"\n");
        /*
        if(this.smoker)
        {
            System.out.println("Smoker");
        }
        else
        {
            System.out.println("NOT a smoker");
        }
        if(this.earlyBedTime)
        {
            System.out.println(this.firstName + " goes to bed early");
        }
        else
        {
            System.out.println(this.firstName + " goes to bed late");
        }
        if(this.studyInRoom)
        {
            System.out.println("introvert");
        }
        else
        {
            System.out.println("extrovert");
        }
        if(this.roomMateSigOther)
        {
            System.out.println("Bring her over!");
        }
        else
        {
            System.out.println("Please Don't");
        }
        */
    }
}