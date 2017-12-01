import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Matt
 */
public class Moloney extends Building{
    private Integer 
            maxStudents, totalRooms, maxPrivate,
            currentStudents, currentFemales, currentMales, currentPrivate,
			num, privateMales, privateFemales;
    //keys for descriptions must match indecies for rommates
    private HashMap<Integer, String> 
            descriptions;  
    private ArrayList< Roommates > 
            male1Roommates, male2Roommates, male3Roommates,
            m1hRoommates, m2hRoommates, m3hRoommates,
            f1hRoommates, f2hRoommates, f3hRoommates,
            female1Roommates, female2Roommates, female3Roommates,
            want1Roommates, want2Roommates, want3Roommates, allRoommates;
    private HashMap<String, Student> 
            m1Homeless, m2Homeless, m3Homeless,  
            f1Homeless, f2Homeless, f3Homeless,
            malesWant1, malesWant2, malesWant3, 
            femalesWant1, femalesWant2, femalesWant3,
            wantPrivate, theRestMales, theRestFemales;
	private HashMap< Integer, Boolean > 
			available;
	private ArrayList< String >
			outputStrings;
    			
	
    public Moloney()
    {
        super();
        descriptions   = new HashMap<>();
        malesWant1     = new HashMap<>();
        malesWant2     = new HashMap<>();
        malesWant3     = new HashMap<>();
        femalesWant1   = new HashMap<>();
        femalesWant2   = new HashMap<>();
        femalesWant3   = new HashMap<>();
        m1Homeless     = new HashMap<>();
        m2Homeless     = new HashMap<>();
        m3Homeless     = new HashMap<>();
        f1Homeless     = new HashMap<>();
        f2Homeless     = new HashMap<>();
        f3Homeless     = new HashMap<>();
        wantPrivate    = new HashMap<>();
        theRestMales   = new HashMap<>();
        theRestFemales = new HashMap<>();
		available      = new HashMap<>();
        
        male1Roommates   = new ArrayList<>();
        male2Roommates   = new ArrayList<>();
        male3Roommates   = new ArrayList<>();
        female1Roommates = new ArrayList<>();
        female2Roommates = new ArrayList<>();
        female3Roommates = new ArrayList<>();
        m1hRoommates     = new ArrayList<>();
        m2hRoommates     = new ArrayList<>();
        m3hRoommates     = new ArrayList<>();
        f1hRoommates     = new ArrayList<>();
        f2hRoommates     = new ArrayList<>();
        f3hRoommates     = new ArrayList<>();
        want1Roommates   = new ArrayList<>();
        want2Roommates   = new ArrayList<>();
        want3Roommates   = new ArrayList<>();
		outputStrings    = new ArrayList<>();
		allRoommates     = new ArrayList<>();
        
        maxStudents     = 60;
        maxPrivate      = 8;        
        totalRooms      = 0;
		privateMales    = 0;
		privateFemales  = 0;
        currentFemales  = 0; 
        currentMales    = 0;
        currentStudents = 0;
        currentPrivate  = 0;
		num             = 0;
        
		
		available.put(0,true);
        available.put(1,true);
        available.put(2,true);
        available.put(3,true);
        available.put(4,true);
        available.put(5,true);
        available.put(6,true);
        available.put(7,true);
        available.put(8,true);
        available.put(9,true);
		available.put(10,true);
        available.put(11,true);
        available.put(12,true);
        available.put(13,true);
        available.put(14,true);
        available.put(15,true);
        available.put(16,true);
        available.put(17,true);
        available.put(18,true);
        available.put(19,true);
		available.put(20,true);
        available.put(21,true);
        available.put(22,true);
        available.put(23,true);
        available.put(24,true);
        available.put(25,true);
        available.put(26,true);
        available.put(27,true);
        available.put(28,true);
        available.put(29,true);
		available.put(30,true);
        available.put(31,true);
        available.put(32,true);
        available.put(33,true);
		
		
		
        
        descriptions.put(0, "Moloney Hall - 114 | quiet");totalRooms++;
        
        descriptions.put(1, "Moloney Hall - 116 | quiet");totalRooms++;
        
        descriptions.put(2, "Moloney Hall - 223 | quiet");totalRooms++;
        
        descriptions.put(3, "Moloney Hall - 224 | quiet");totalRooms++;
        
        descriptions.put(4, "Moloney Hall - 225 | quiet");totalRooms++;
        
        descriptions.put(5, "Moloney Hall - 226 | quiet");totalRooms++;
        
        descriptions.put(6, "Moloney Hall - 117-1 | quiet");totalRooms++;
        descriptions.put(7, "Moloney Hall - 117-2 | quiet");totalRooms++;
        
        descriptions.put(8, "Moloney Hall - 118-1 | quiet");totalRooms++;
        descriptions.put(9, "Moloney Hall - 118-2 | quiet");totalRooms++;
        
        descriptions.put(10, "Moloney Hall - 119-1 | quiet");totalRooms++;
        descriptions.put(11, "Moloney Hall - 119-2 | quiet");totalRooms++;
        
        descriptions.put(12, "Moloney Hall - 120-1 | quiet");totalRooms++;
        descriptions.put(13, "Moloney Hall - 120-2 | quiet");totalRooms++;
        
        descriptions.put(14, "Moloney Hall - 227-1 | quiet");totalRooms++;
        descriptions.put(15, "Moloney Hall - 227-2 | quiet");totalRooms++;
        
        descriptions.put(16, "Moloney Hall - 228-1 | quiet");totalRooms++;
        descriptions.put(17, "Moloney Hall - 228-2 | quiet");totalRooms++;
        
        descriptions.put(18, "Moloney Hall - 229-1 | quiet");totalRooms++;
        descriptions.put(19, "Moloney Hall - 229-2 | quiet");totalRooms++;
        
        descriptions.put(20, "Moloney Hall - 230-1 | quiet");totalRooms++;
        descriptions.put(21, "Moloney Hall - 230-2 | quiet");totalRooms++;
		
        descriptions.put(22, "Moloney Hall - 111-1 | quiet");totalRooms++;
        descriptions.put(23, "Moloney Hall - 112-1 | quiet");totalRooms++;
        descriptions.put(24, "Moloney Hall - 221-1 | quiet");totalRooms++;
        descriptions.put(25, "Moloney Hall - 222-1 | quiet");totalRooms++;
		
        descriptions.put(26, "Moloney Hall - 111-2 | quiet pr");totalRooms++;
        descriptions.put(27, "Moloney Hall - 111-3 | quiet pr");totalRooms++;
        descriptions.put(28, "Moloney Hall - 112-2 | quiet pr");totalRooms++;
        descriptions.put(29, "Moloney Hall - 112-3 | quiet pr");totalRooms++;
        descriptions.put(30, "Moloney Hall - 221-2 | quiet pr");totalRooms++;
        descriptions.put(31, "Moloney Hall - 221-3 | quiet pr");totalRooms++;
        descriptions.put(32, "Moloney Hall - 222-2 | quiet pr");totalRooms++;
        descriptions.put(33, "Moloney Hall - 222-3 | quiet pr");totalRooms++;
    }
    private boolean canLiveHere(Student student)
    {
        if(currentStudents >= maxStudents)
        {//full
            return false;
        }
        if(student.getGradYearDelta() < 2)
        {//too young
            return false;
        }
        if(currentStudents == (maxStudents - 1) )
        {//only one more student slot left
            if(currentPrivate < maxPrivate)
            {
                return true;
            }
            switch(currentMales%2)
            {//get the right gender
                case 0: return !student.getGender().equals("Male");
                case 1: return  student.getGender().equals("Male");
                default:break;
            }
        }
        return true;
    }
    private boolean canLiveHere(Roommates r)
    {
        if(currentStudents >= maxStudents - 1)
        {//full
            return false;
        }
        if(r.getGradYearDelta() < 2)
        {//too young
            return false;
        }
        return true;
    }
    public boolean putInto(Student student)
    {
        if(canLiveHere(student) )
        {
            if(student.getGender().equals("Male") )
            {
                if(student.getFirstRoomPreference() > 14 && student.getFirstRoomPreference() < 18)
                {
                    if(!student.getFirstPrivateRoomDesired() || (currentPrivate >= maxPrivate) )
                    {//they DO NOT want a private room OR private rooms are full
                        switch (student.getFirstRoomPreference() )
                        {
                            case 15:
                                currentStudents++;
                                currentMales++;
                                malesWant1.put(student.getID(), student);
                                return true;
                            case 16:
                                currentStudents++;
                                currentMales++;
                                malesWant2.put(student.getID(), student);
                                return true;
                            case 17:
                                currentStudents++;
                                currentMales++;
                                malesWant3.put(student.getID(), student);
                                return true;
                            default:
                                return false;
                        }
                    }
                    else
                    {//can live here && want to && want a private room
                        currentStudents++;
                        currentPrivate++;
                        wantPrivate.put(student.getID(), student);
						if(student.getGender().equals("Male") )
						{ privateMales++; }
						else
						{ privateFemales++; }
                        return true;
                    }
                }
                else if(student.getSecondRoomPreference() > 14 && student.getSecondRoomPreference() < 18)
                {
                    if(!student.getSecondPrivateRoomDesired() || (currentPrivate >= maxPrivate) )
                    {//they DO NOT want a private room OR private rooms are full
                        switch (student.getSecondRoomPreference() )
                        {
                            case 15:
                                currentStudents++;
                                currentMales++;
                                malesWant1.put(student.getID(), student);
                                return true;
                            case 16:
                                currentStudents++;
                                currentMales++;
                                malesWant2.put(student.getID(), student);
                                return true;
                            case 17:
                                currentStudents++;
                                currentMales++;
                                malesWant3.put(student.getID(), student);
                                return true;
                            default:
                                return false;
                        }
                    }
                    else
                    {//can live here && want to && want a private room
                        currentStudents++;
                        currentPrivate++;
                        wantPrivate.put(student.getID(), student);
						if(student.getGender().equals("Male") )
						{ privateMales++; }
						else
						{ privateFemales++; }
                        return true;                        
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {//female
                if(student.getFirstRoomPreference() > 14 && student.getFirstRoomPreference() < 18)
                {
                    if(!student.getFirstPrivateRoomDesired() || (currentPrivate >= maxPrivate) )
                    {//they DO NOT want a private room OR private rooms are full
                        switch (student.getFirstRoomPreference() )
                        {
                            case 15:
                                currentStudents++;
                                currentFemales++;
                                femalesWant1.put(student.getID(), student);
                                return true;
                            case 16:
                                currentStudents++;
                                currentFemales++;
                                femalesWant2.put(student.getID(), student);
                                return true;
                            case 17:
                                currentStudents++;
                                currentFemales++;
                                femalesWant3.put(student.getID(), student);
                                return true;
                            default: 
                                return false;
                        }
                    }
                    else
                    {//can live here && want to && want a private room
                        currentStudents++;
                        currentPrivate++;
                        wantPrivate.put(student.getID(), student);
                        return true;      
                    }
                }
                else if(student.getSecondRoomPreference() > 14 && student.getSecondRoomPreference() < 18)
                {
                 if(!student.getFirstPrivateRoomDesired() || (currentPrivate >= maxPrivate) )
                    {//they DO NOT want a private room OR private rooms are full   
                        switch (student.getSecondRoomPreference() )
                        {
                            case 15:
                                currentStudents++;
                                currentFemales++;
                                femalesWant1.put(student.getID(), student);
                                return true;
                            case 16:
                                currentStudents++;
                                currentFemales++;
                                femalesWant2.put(student.getID(), student);
                                return true;
                            case 17:
                                currentStudents++;
                                currentFemales++;
                                femalesWant3.put(student.getID(), student);
                                return true;
                            default: 
                                return false;
                        }
                    }
                 else
                 {//can live here && want to && want a private room
                        currentStudents++;
                        currentPrivate++;
                        wantPrivate.put(student.getID(), student);
                        return true;
                 }
                        
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    public boolean addRoommates(Roommates r)
    {
        if(canLiveHere(r) )
        {
			Boolean toReturn;
            switch(r.getFirstRoomPreference() )
            {
                case 15:
                    want1Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    toReturn = true;
					break;
                case 16:
                    want2Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    toReturn = true;
					break;
                case 17:
                    want3Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    toReturn = true;
					break;
                default: break;
            }
            switch(r.getSecondRoomPreference() )
            {
                case 15:
                    want1Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    toReturn = true;
					break;
                case 16:
                    want2Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    toReturn = true;
					break;
                case 17:
                    want3Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    toReturn = true;
					break;
                default: 
                    toReturn = false;
					break;
            }
			if(toReturn)
			{//if they got a place, update the gender totals
				if(r.getGender().equals("Male") )
				{
					currentMales = currentMales + 2;
				}
				else
				{
					currentFemales = currentFemales + 2;
				}
			}
			return toReturn;
        }
        else
        {
            return false;
        }
    }
    public void match()
    {
		if(wantPrivate.size() < maxPrivate)
		{
			System.out.println("in match() wantPrivate.size() : " + wantPrivate.size());
			while(pickPrivateStudent() )
			{ /*bodyless while loop to assign random students to be private*/ 
			System.out.println("in match() wantPrivate.size() : " + wantPrivate.size());}
		}
		else
		{
			System.out.println("in match() wantPrivate.size() : " + wantPrivate.size());
		}
        //males
        male1Roommates = matchStudents(malesWant1, "Moloney Hall");
        m1Homeless = getHomeless();
        male2Roommates = matchStudents(malesWant2, "Moloney Hall");
        m2Homeless = getHomeless();
        male3Roommates = matchStudents(malesWant3, "Moloney Hall");
        m3Homeless = getHomeless();

        m1hRoommates = matchHomelessStudents(m1Homeless);
        m2hRoommates = matchHomelessStudents(m2Homeless);
        m3hRoommates = matchHomelessStudents(m3Homeless);
        theRestMales = getHomeless();
        join("mh");
        addTheRest(theRestMales, "Male");
        
        //females
        female1Roommates = matchStudents(femalesWant1, "Moloney Hall");
        f1Homeless = getHomeless();
        female2Roommates = matchStudents(femalesWant2, "Moloney Hall");
        f2Homeless = getHomeless();
        female3Roommates = matchStudents(femalesWant3, "Moloney Hall");
        f3Homeless = getHomeless();
        
        f1hRoommates = matchHomelessStudents(f1Homeless);
        f2hRoommates = matchHomelessStudents(f2Homeless);
        f3hRoommates = matchHomelessStudents(f3Homeless);
        theRestFemales = getHomeless();
        join("fh");
        addTheRest(theRestFemales, "Female");
        join();
        
        assignRooms();
		output();
//        debug();

//        System.out.println("currentStudents: " + currentStudents);
    }
	public void clear()
	{
		
        malesWant1     = new HashMap<>();
        malesWant2     = new HashMap<>();
        malesWant3     = new HashMap<>();
        femalesWant1   = new HashMap<>();
        femalesWant2   = new HashMap<>();
        femalesWant3   = new HashMap<>();
        m1Homeless     = new HashMap<>();
        m2Homeless     = new HashMap<>();
        m3Homeless     = new HashMap<>();
        f1Homeless     = new HashMap<>();
        f2Homeless     = new HashMap<>();
        f3Homeless     = new HashMap<>();
        wantPrivate    = new HashMap<>();
        theRestMales   = new HashMap<>();
        theRestFemales = new HashMap<>();
        
        male1Roommates   = new ArrayList<>();
        male2Roommates   = new ArrayList<>();
        male3Roommates   = new ArrayList<>();
        female1Roommates = new ArrayList<>();
        female2Roommates = new ArrayList<>();
        female3Roommates = new ArrayList<>();
        m1hRoommates     = new ArrayList<>();
        m2hRoommates     = new ArrayList<>();
        m3hRoommates     = new ArrayList<>();
        f1hRoommates     = new ArrayList<>();
        f2hRoommates     = new ArrayList<>();
        f3hRoommates     = new ArrayList<>();
        want1Roommates   = new ArrayList<>();
        want2Roommates   = new ArrayList<>();
        want3Roommates   = new ArrayList<>();
        
		for(int i = 0; i < totalRooms; i++)
		{//reset to true
			available.put(i, true);
		}
		
        currentFemales  = 0; 
        currentMales    = 0;
        currentStudents = 0;
        currentPrivate  = 0;
		num             = 0;
	}
    private void addTheRest(HashMap<String, Student> theRest, String sex)
    {//adds all left over students to their gendered lists, with a roommate if possible
        if(sex.equals("Male") )
        {
            while(!theRest.isEmpty() )
            {
                if(theRest.size() > 1)
                {
                    Set<Map.Entry<String, Student> > theRestSet1 = theRest.entrySet();
                    Set<Map.Entry<String, Student> > theRestSet2 = theRest.entrySet();
                    Student one    = new Student();
                    Student two    = new Student();
                    boolean done   = false;
                    String roommateID = "";
                    Roommates room = new Roommates();
                    
                    for(Map.Entry<String, Student> i : theRestSet1)
                    {
                        Integer highestCompat = 0, currentCompat = 0;
                        one = (Student) i.getValue();
                        for(Map.Entry<String, Student> j : theRestSet2)
                        {
                            two = (Student) j.getValue();
                            if(!one.getID().equals(two.getID() ))
                            {//NOT the same ID#
                                currentCompat = one.getSimilarFactor(two);
                                if(currentCompat > highestCompat)
                                {
                                    highestCompat = currentCompat;
                                    roommateID = two.getID();
                                }
                            }
                        }
                        break;
                    }
                    //now have the ID of one's new roommate
                    room.addFirst(one);
                    room.addSecond(theRest.get(roommateID) );
                    male1Roommates.add(room);
                    //remove two new roommates that were just added to male1Roommates
                    theRest.remove(one.getID() );
                    theRest.remove(theRest.get(roommateID) );
                }
                else
                {//theRestMales.size() == 1
                    Set<Map.Entry<String, Student> > theRestSet = theRest.entrySet();
                    Student it = new Student();
                    Roommates room = new Roommates();
                    for(Map.Entry<String, Student> i : theRestSet)
                    {
                        it = (Student) i.getValue();
                    }
                    room.addFirst(it);
                    male1Roommates.add(room);
                    theRest.remove(it.getID() );
                }
            }//end while
        }//end if -> males
        else
        {//female
            while(!theRest.isEmpty() )
            {
                if(theRest.size() > 1)
                {
                    Set<Map.Entry<String, Student> > theRestSet1 = theRest.entrySet();
                    Set<Map.Entry<String, Student> > theRestSet2 = theRest.entrySet();
                    Student one    = new Student();
                    Student two    = new Student();
                    boolean done   = false;
                    String roommateID = "";
                    Roommates room = new Roommates();
                    
                    for(Map.Entry<String, Student> i : theRestSet1)
                    {
                        Integer highestCompat = 0, currentCompat = 0;
                        one = (Student) i.getValue();
                        for(Map.Entry<String, Student> j : theRestSet2)
                        {
                            two = (Student) j.getValue();
                            if(!one.getID().equals(two.getID() ))
                            {//NOT the same ID#
                                currentCompat = one.getSimilarFactor(two);
                                if(currentCompat > highestCompat)
                                {
                                    highestCompat = currentCompat;
                                    roommateID = two.getID();
                                }
                            }
                        }
                        break;
                    }
                    //now have the ID of one's new roommate
                    room.addFirst(one);
                    room.addSecond(theRest.get(roommateID) );
                    female1Roommates.add(room);
                    //remove two new roommates that were just added to male1Roommates
                    theRest.remove(one.getID() );
                    theRest.remove(theRest.get(roommateID) );
                }
                else
                {//theRestMales.size() == 1
                    Set<Map.Entry<String, Student> > theRestSet = theRest.entrySet();
                    Student it = new Student();
                    Roommates room = new Roommates();
                    for(Map.Entry<String, Student> i : theRestSet)
                    {
                        it = (Student) i.getValue();
                    }
                    room.addFirst(it);
                    female1Roommates.add(room);
                    theRest.remove(it.getID() );
                }
            }//end while
        }//end else -> females
        //debug();
    }
    private void join()
    {//join male and female Roommates objs into one list per
	 //then join all of those into a single AL
        while(!male1Roommates.isEmpty() )
        {
            want1Roommates.add(male1Roommates.get(0) );
            male1Roommates.remove(0);
        }
        while(!male2Roommates.isEmpty() )
        {
            want2Roommates.add(male2Roommates.get(0) );
            male2Roommates.remove(0);
        }
        while(!male3Roommates.isEmpty() )
        {
            want3Roommates.add(male3Roommates.get(0) );
            male3Roommates.remove(0);
        }
        
        while(!female1Roommates.isEmpty() )
        {
            want1Roommates.add(female1Roommates.get(0) );
            female1Roommates.remove(0);
        }
        while(!female2Roommates.isEmpty() )
        {
            want2Roommates.add(female2Roommates.get(0) );
            female2Roommates.remove(0);
        }
        while(!female3Roommates.isEmpty() )
        {
            want3Roommates.add(female3Roommates.get(0) );
            female3Roommates.remove(0);
        }
		//put all Roommate obj into a AL behaving as a queue
		while(!want1Roommates.isEmpty() )
		{
			allRoommates.add(want1Roommates.get(0) );
			want1Roommates.remove(0);
		}
		while(!want2Roommates.isEmpty() )
		{
			allRoommates.add(want2Roommates.get(0) );
			want2Roommates.remove(0);
		}
		while(!want3Roommates.isEmpty() )
		{
			allRoommates.add(want3Roommates.get(0) );
			want3Roommates.remove(0);
		}
		
    }
    private void join(String s)
    {//joins the homeless matches into the rest of the matches per gender
        if(s.equals("mh") )
        {
            while(!m1hRoommates.isEmpty() )
            {
                male1Roommates.add(m1hRoommates.get(0) );
                m1hRoommates.remove(0);
            }
            while(!m2hRoommates.isEmpty() )
            {
                male2Roommates.add(m2hRoommates.get(0) );
                m2hRoommates.remove(0);
            }
            while(!m3hRoommates.isEmpty() )
            {
                male3Roommates.add(m3hRoommates.get(0) );
                m3hRoommates.remove(0);
            }
        }
        else if(s.equals("fh") )
        {
            while(!f1hRoommates.isEmpty() )
            {
                female1Roommates.add(f1hRoommates.get(0) );
                f1hRoommates.remove(0);
            }
            while(!f2hRoommates.isEmpty() )
            {
                female2Roommates.add(f2hRoommates.get(0) );
                f2hRoommates.remove(0);
            }
            while(!f3hRoommates.isEmpty() )
            {
                female3Roommates.add(f3hRoommates.get(0) );
                f3hRoommates.remove(0);
            }
        }
    }
	private void assignRooms()
	{
//		System.out.println("matching private students with rooms");
		while(!wantPrivate.isEmpty() )
		{//take care of private students first
//			System.out.println("wantPrivate.size() : " + wantPrivate.size() );
			Map.Entry<String, Student> entry = wantPrivate.entrySet().iterator().next();
			
			String s = descriptions.get(26 + num) + "\n";
			s = s + wantPrivate.get(entry.getKey() ).getFinalOutput() + "\n\n";
			outputStrings.add(s);
			wantPrivate.remove(entry.getKey() );
			available.put(26 + num, false);
			num++;
		}
		num = 0;
		
		//by now, all gender has been removed from the process, they have been "join" - ed -> join()
		
		while(!allRoommates.isEmpty() && num < 26)
		{//place all pairs from quiet2Roommates
//			System.out.println("allRoommates.size() : " + allRoommates.size() );
			getRoomsStrings();
//			System.out.println("last room addition\n" + outputStrings.get(outputStrings.size() - 1 ) );
		}		
		
		
		
		
//        System.out.println("moloney end of roomAssignment");
//        System.out.println("wantPrivate: " + wantPrivate.size());
//        System.out.println("allRoommates: " + allRoommates.size());
		
		
		
	}
	private void getRoomsStrings()
	{
		String s = descriptions.get(num) + "\n";
		
		s = s + allRoommates.get(0).getFirst().getFinalOutput();
		s = s + "\n";
		s = s + allRoommates.get(0).getSecond().getFinalOutput();
		s = s + "\n";
		allRoommates.remove(0);
		
		outputStrings.add(s);
		available.put(num, false);
		num++;
	}
	private Boolean pickPrivateStudent()
	{//pick a random student from a HM with Students, then put them into wantPrivate 
	 //while removing them from their original HM
		if(wantPrivate.size() >= maxPrivate)
		{//brady hall now has the most private students it can
			return false;	
		}
		
		Random random    = new Random();
		List<String> keys;
		Student value = new Student();
		
		if(currentPrivate == (maxPrivate - 1) )
		{//only one more private student allowed, get the right gender
			String requiredSex;
			if(privateMales % 2 == 0)
			{//even number of males on private, need private female
				requiredSex = "Female";
			}
			else
			{
				requiredSex = "Male";
			}
			
			//do the thing in here rather than outside of it where requiredSex wouldnt be initialized
			switch(requiredSex)
			{
				case "Male":
					if(malesWant1.size() > 0)
					{
						keys = new ArrayList<>(malesWant1.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant1.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant1.remove(value.getID() );
						return true;
					}
					else if(malesWant2.size() > 0)
					{
						keys = new ArrayList<>(malesWant2.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant2.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant2.remove(value.getID() );
						return true;
					}
					else if(malesWant3.size() > 0)
					{
						keys = new ArrayList<>(malesWant3.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant3.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant3.remove(value.getID() );
						return true;
					}
					else
					{//need a male, but there are none
						return false;
					}
				case "Female":
					if(femalesWant1.size() > 0)
					{
						keys = new ArrayList<>(femalesWant1.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant1.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant1.remove(value.getID() );
						return true;
					}
					else if(femalesWant2.size() > 0)
					{
						keys = new ArrayList<>(femalesWant2.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant2.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant2.remove(value.getID() );
						return true;
					}
					else if(femalesWant3.size() > 0)
					{
						keys = new ArrayList<>(femalesWant3.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant3.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant3.remove(value.getID() );
						return true;
					}
					else
					{//need a female, but there are none
						return false;
					}
				default: return false;
			}
		}
		else
		{//normal case
			Integer whichOne = random.nextInt(2) + 1;
			switch(whichOne)
			{
				case 1: //males
					if(malesWant1.size() > 0)
					{
						keys = new ArrayList<>(malesWant1.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant1.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant1.remove(value.getID() );
						return true;
					}
					else if(malesWant2.size() > 0)
					{
						keys = new ArrayList<>(malesWant2.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant2.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant2.remove(value.getID() );
						return true;
					}
					else if(malesWant3.size() > 0)
					{
						keys = new ArrayList<>(malesWant3.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant3.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant3.remove(value.getID() );
						return true;
					}
					
				case 2: //females
					if(femalesWant1.size() > 0)
					{
						keys = new ArrayList<>(femalesWant1.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant1.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant1.remove(value.getID() );
						return true;
					}
					else if(femalesWant2.size() > 0)
					{
						keys = new ArrayList<>(femalesWant2.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant2.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant2.remove(value.getID() );
						return true;
					}
					else if(femalesWant3.size() > 0)
					{
						keys = new ArrayList<>(femalesWant3.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant3.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant3.remove(value.getID() );
						return true;
					}
				default: break;
			}
			if(value.getFirstName().equals("") )
			{//didnt get a student from the above switch, do it again for the other gender
				switch(whichOne)
				{
					case 1: //females
					if(femalesWant1.size() > 0)
					{
						keys = new ArrayList<>(femalesWant1.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant1.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant1.remove(value.getID() );
						return true;
					}
					else if(femalesWant2.size() > 0)
					{
						keys = new ArrayList<>(femalesWant2.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant2.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant2.remove(value.getID() );
						return true;
					}
					else if(femalesWant3.size() > 0)
					{
						keys = new ArrayList<>(femalesWant3.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) femalesWant3.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						femalesWant3.remove(value.getID() );
						return true;
					}

					case 2: //males
					if(malesWant1.size() > 0)
					{
						keys = new ArrayList<>(malesWant1.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant1.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant1.remove(value.getID() );
						return true;
					}
					else if(malesWant2.size() > 0)
					{
						keys = new ArrayList<>(malesWant2.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant2.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant2.remove(value.getID() );
						return true;
					}
					else if(malesWant3.size() > 0)
					{
						keys = new ArrayList<>(malesWant3.keySet());
						String randomKey = keys.get( random.nextInt(keys.size()) );
						value = (Student) malesWant3.get(randomKey);
			
						wantPrivate.put(value.getID(), value);
						malesWant3.remove(value.getID() );
						return true;
					}

					default: break;
				}
			}
			return false;
		}
	}
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("moloneyOut.csv"))) 
        {
            for(int i = 0; i < outputStrings.size(); i++)
            {
                if(i == outputStrings.size() - 1 )
                {
                    out.print(outputStrings.get(i) );
                }
                else
                {
                    out.println(outputStrings.get(i) );
                }
            }
			out.println("\nUnused Rooms");
			for(int i = 0; i < available.size(); i++)
			{
				if(available.get(i) )
				{
					out.println(descriptions.get(i) );
				}
			}
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\ninside catch clause of moloneyOut\n");
        }
	}
    private void debug()
    {
		
		System.out.println("\nmoloney\n----------------");
        System.out.println("currentStudents: " + currentStudents);
        System.out.println("m1Homeless: " + m1Homeless.size());
        System.out.println("m2Homeless: " + m2Homeless.size());
        System.out.println("m3Homeless: " + m3Homeless.size());
        System.out.println("f1Homeless: " + f1Homeless.size());
        System.out.println("f2Homeless: " + f2Homeless.size());
        System.out.println("f3Homeless: " + f3Homeless.size());
        System.out.println("malesWant1: " + malesWant1.size());
        System.out.println("malesWant2: " + malesWant2.size());
        System.out.println("malesWant3: " + malesWant3.size());
        System.out.println("femalesWant1: " + femalesWant1.size());
        System.out.println("femalesWant2: " + femalesWant2.size());
        System.out.println("femalesWant3: " + femalesWant3.size());
        System.out.println("wantPrivate: " + wantPrivate.size());
        System.out.println("theRestMales: " + theRestMales.size());
        System.out.println("theRestFemales: " + theRestFemales.size());
		
		
        System.out.println("male1Roommates: " + male1Roommates.size());
        System.out.println("male2Roommates: " + male2Roommates.size());
        System.out.println("male3Roommates: " + male3Roommates.size());
        System.out.println("m1hRoommates: " + m1hRoommates.size());
        System.out.println("m2hRoommates: " + m2hRoommates.size());
        System.out.println("m3hRoommates: " + m3hRoommates.size());
        System.out.println("f1hRoommates: " + f1hRoommates.size());
        System.out.println("f2hRoommates: " + f2hRoommates.size());
        System.out.println("f3hRoommates: " + f3hRoommates.size());
        System.out.println("female1Roommates: " + female1Roommates.size());
        System.out.println("female2Roommates: " + female2Roommates.size());
        System.out.println("female3Roommates: " + female3Roommates.size());
        System.out.println("want1Roommates: " + want1Roommates.size());
        System.out.println("want2Roommates: " + want2Roommates.size());
        System.out.println("want3Roommates: " + want3Roommates.size());
//        System.out.println("MOLONEY HALL FINAL ROOMMATES");
        System.out.println("-------------------------");
        /*
        for(int i = 0; i < want1Roommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = want1Roommates.get(i).getFirst();
            second = want1Roommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        for(int i = 0; i < want2Roommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = want2Roommates.get(i).getFirst();
            second = want2Roommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        for(int i = 0; i < want3Roommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = want3Roommates.get(i).getFirst();
            second = want3Roommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
*/
    }
}