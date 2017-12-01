import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Matt
 */
public class Village extends Building{
    private Integer 
            totalRooms, maxStudents, maxQuiet, maxStandard, 
            currentStudents, currentQM, 
            currentQF, currentSM, currentSF, 
            currentMales, currentFemales,
			num;
    //keys for descriptions must match indecies for rommates
    private HashMap<Integer, String> 
            descriptions; 
    private ArrayList< Roommates > 
            qmhRoommates, smhRoommates, qfhRoommates, sfhRoommates,
            quietMaleRoommates, quietFemaleRoommates, 
            standardMaleRoommates, standardFemaleRoommates;
    private ArrayList< String >
            outputStrings;
    private HashMap<String, Student> 
            qmHomeless, smHomeless, qfHomeless, sfHomeless,
            quietMales, quietFemales, 
            standardMales, standardFemales,
            theRestMales, theRestFemales;
	private HashMap< Integer, Boolean > 
			available;
    
    public Village()
    {//constructor
        super();
        descriptions    = new HashMap<>();
        quietMales      = new HashMap<>();
        quietFemales    = new HashMap<>();
        standardMales   = new HashMap<>();
        standardFemales = new HashMap<>();
        theRestMales    = new HashMap<>();
        theRestFemales  = new HashMap<>();
        qmHomeless      = new HashMap<>();
        smHomeless      = new HashMap<>();
        qfHomeless      = new HashMap<>();
        sfHomeless      = new HashMap<>();
		available       = new HashMap<>();
        
        quietMaleRoommates      = new ArrayList<>();
        quietFemaleRoommates    = new ArrayList<>();
        standardMaleRoommates   = new ArrayList<>();
        standardFemaleRoommates = new ArrayList<>();
        qmhRoommates            = new ArrayList<>();
        smhRoommates            = new ArrayList<>();
        qfhRoommates            = new ArrayList<>();
        sfhRoommates            = new ArrayList<>();
        outputStrings           = new ArrayList<>();
        
        totalRooms      = 0;
        currentStudents = 0;
        currentQM       = 0;
        currentQF       = 0;
        currentSM       = 0;
        currentSF       = 0;
        currentMales    = 0; 
        currentFemales  = 0;
		num             = 0;
        maxQuiet        = 122;
        maxStandard     = 138;
        maxStudents     = 260;
        
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
        available.put(34,true);
        available.put(35,true);
        available.put(36,true);
        available.put(37,true);
        available.put(38,true);
        available.put(39,true);
		available.put(40,true);
        available.put(41,true);
        available.put(42,true);
        available.put(43,true);
        available.put(44,true);
        available.put(45,true);
        available.put(46,true);
        available.put(47,true);
        available.put(48,true);
        available.put(49,true);
		available.put(50,true);
        available.put(51,true);
        available.put(52,true);
        available.put(53,true);
        available.put(54,true);
        available.put(55,true);
        available.put(56,true);
        available.put(57,true);
		available.put(58,true);
        available.put(59,true);
		available.put(60,true);
        available.put(61,true);
        available.put(62,true);
        available.put(63,true);
        available.put(64,true);
        available.put(65,true);
        available.put(66,true);
        available.put(67,true);
        available.put(68,true);
        available.put(69,true);
		available.put(70,true);
        available.put(71,true);
        available.put(72,true);
        available.put(73,true);
        available.put(74,true);
        available.put(75,true);
        available.put(76,true);
        available.put(77,true);
        available.put(78,true);
        available.put(79,true);
		available.put(80,true);
        available.put(81,true);
        available.put(82,true);
        available.put(83,true);
        available.put(84,true);
        available.put(85,true);
        available.put(86,true);
        available.put(87,true);
        available.put(88,true);
        available.put(89,true);
		available.put(90,true);
        available.put(91,true);
        available.put(92,true);
        available.put(93,true);
        available.put(94,true);
        available.put(95,true);
        available.put(96,true);
        available.put(97,true);
        available.put(98,true);
        available.put(99,true);
		available.put(100,true);
        available.put(101,true);
        available.put(102,true);
        available.put(103,true);
        available.put(104,true);
        available.put(105,true);
        available.put(106,true);
        available.put(107,true);
        available.put(108,true);
        available.put(109,true);
		available.put(110,true);
        available.put(111,true);
        available.put(112,true);
        available.put(113,true);
        available.put(114,true);
        available.put(115,true);
        available.put(116,true);
        available.put(117,true);
        available.put(118,true);
        available.put(119,true);
		available.put(120,true);
        available.put(121,true);
        available.put(122,true);
        available.put(123,true);
        available.put(124,true);
        available.put(125,true);
        available.put(126,true);
        available.put(127,true);
        available.put(128,true);
        available.put(129,true);
		
		
        descriptions.put(0, "Student Village - A1A | quiet");totalRooms++;
        descriptions.put(1, "Student Village - A1B | quiet");totalRooms++;
        descriptions.put(2, "Student Village - A1C | quiet");totalRooms++;
        descriptions.put(3, "Student Village - A1D | quiet");totalRooms++;
        descriptions.put(4, "Student Village - A3A | quiet");totalRooms++;
        descriptions.put(5, "Student Village - A3B | quiet");totalRooms++;
        descriptions.put(6, "Student Village - A3C | quiet");totalRooms++;
        descriptions.put(7, "Student Village - A3D | quiet");totalRooms++;
        descriptions.put(8, "Student Village - A4A | quiet");totalRooms++;
        descriptions.put(9, "Student Village - A4B | quiet");totalRooms++;
        descriptions.put(10, "Student Village - A4C | quiet");totalRooms++;
        descriptions.put(11, "Student Village - A4D | quiet");totalRooms++;
        descriptions.put(12, "Student Village - A5A | quiet");totalRooms++;
        descriptions.put(13, "Student Village - A5C | quiet");totalRooms++;
        descriptions.put(14, "Student Village - A5D | quiet");totalRooms++;
        descriptions.put(15, "Student Village - A6A | quiet");totalRooms++;
        descriptions.put(16, "Student Village - A6B | quiet");totalRooms++;
        descriptions.put(17, "Student Village - A6C | quiet");totalRooms++;
        descriptions.put(18, "Student Village - A6D | quiet");totalRooms++;
        descriptions.put(19, "Student Village - A7A | quiet");totalRooms++;
        descriptions.put(20, "Student Village - A7B | quiet");totalRooms++;
        descriptions.put(21, "Student Village - A7C | quiet");totalRooms++;
        descriptions.put(22, "Student Village - A7D | quiet");totalRooms++;
        descriptions.put(23, "Student Village - A8A | quiet");totalRooms++;
        descriptions.put(24, "Student Village - A8B | quiet");totalRooms++;
        descriptions.put(25, "Student Village - A8C | quiet");totalRooms++;
        descriptions.put(26, "Student Village - A8D | quiet");totalRooms++;
        descriptions.put(27, "Student Village - A9A | quiet");totalRooms++;
        descriptions.put(28, "Student Village - A9B | quiet");totalRooms++;
        descriptions.put(29, "Student Village - A9C | quiet");totalRooms++;
        descriptions.put(30, "Student Village - A9D | quiet");totalRooms++;
        descriptions.put(31, "Student Village - B1A | quiet");totalRooms++;
        descriptions.put(32, "Student Village - B1B | quiet");totalRooms++;
        descriptions.put(33, "Student Village - B1C | quiet");totalRooms++;
        descriptions.put(34, "Student Village - B1D | quiet");totalRooms++;
        descriptions.put(35, "Student Village - B2A | quiet");totalRooms++;
        descriptions.put(36, "Student Village - B2B | quiet");totalRooms++;
        descriptions.put(37, "Student Village - B2C | quiet");totalRooms++;
        descriptions.put(38, "Student Village - B4A | quiet");totalRooms++;
        descriptions.put(39, "Student Village - B4B | quiet");totalRooms++;
        descriptions.put(40, "Student Village - B4C | quiet");totalRooms++;
        descriptions.put(41, "Student Village - B4D | quiet");totalRooms++;
        descriptions.put(42, "Student Village - B5B | quiet");totalRooms++;
        descriptions.put(43, "Student Village - B5C | quiet");totalRooms++;
        descriptions.put(44, "Student Village - B5D | quiet");totalRooms++;
        descriptions.put(45, "Student Village - B6A | quiet");totalRooms++;
        descriptions.put(46, "Student Village - B6B | quiet");totalRooms++;
        descriptions.put(47, "Student Village - B6C | quiet");totalRooms++;
        descriptions.put(48, "Student Village - B6D | quiet");totalRooms++;
        descriptions.put(49, "Student Village - B7A | quiet");totalRooms++;
        descriptions.put(50, "Student Village - B7B | quiet");totalRooms++;
        descriptions.put(51, "Student Village - B7C | quiet");totalRooms++;
        descriptions.put(52, "Student Village - B7D | quiet");totalRooms++;
        descriptions.put(53, "Student Village - B8A | quiet");totalRooms++;
        descriptions.put(54, "Student Village - B8B | quiet");totalRooms++;
        descriptions.put(55, "Student Village - B8C | quiet");totalRooms++;
        descriptions.put(56, "Student Village - B8D | quiet");totalRooms++;
        descriptions.put(57, "Student Village - B9A | quiet");totalRooms++;
        descriptions.put(58, "Student Village - B9B | quiet");totalRooms++;
        descriptions.put(59, "Student Village - B9C | quiet");totalRooms++;
        descriptions.put(60, "Student Village - B9D | quiet");totalRooms++;
        descriptions.put(61, "Student Village - C1A | ");totalRooms++;
        descriptions.put(62, "Student Village - C1B | ");totalRooms++;
        descriptions.put(63, "Student Village - C1C | ");totalRooms++;
        descriptions.put(64, "Student Village - C1D | ");totalRooms++;
        descriptions.put(65, "Student Village - C2B | ");totalRooms++;
        descriptions.put(66, "Student Village - C2C | ");totalRooms++;
        descriptions.put(67, "Student Village - C2D | ");totalRooms++;
        descriptions.put(68, "Student Village - C4A | ");totalRooms++;
        descriptions.put(69, "Student Village - C4B | ");totalRooms++;
        descriptions.put(70, "Student Village - C4C | ");totalRooms++;
        descriptions.put(71, "Student Village - C5A | ");totalRooms++;
        descriptions.put(72, "Student Village - C5B | ");totalRooms++;
        descriptions.put(73, "Student Village - C5C | ");totalRooms++;
        descriptions.put(74, "Student Village - C5D | ");totalRooms++;
        descriptions.put(75, "Student Village - C6A | ");totalRooms++;
        descriptions.put(76, "Student Village - C6B | ");totalRooms++;
        descriptions.put(77, "Student Village - C6C | ");totalRooms++;
        descriptions.put(78, "Student Village - C6D | ");totalRooms++;
        descriptions.put(79, "Student Village - C7A | ");totalRooms++;
        descriptions.put(80, "Student Village - C7B | ");totalRooms++;
        descriptions.put(81, "Student Village - C7C | ");totalRooms++;
        descriptions.put(82, "Student Village - C7D | ");totalRooms++;
        descriptions.put(83, "Student Village - C8A | ");totalRooms++;
        descriptions.put(84, "Student Village - C8B | ");totalRooms++;
        descriptions.put(85, "Student Village - C8C | ");totalRooms++;
        descriptions.put(86, "Student Village - C8D | ");totalRooms++;
        descriptions.put(87, "Student Village - C9A | ");totalRooms++;
        descriptions.put(88, "Student Village - C9B | ");totalRooms++;
        descriptions.put(89, "Student Village - C9C | ");totalRooms++;
        descriptions.put(90, "Student Village - C9D | ");totalRooms++;
        descriptions.put(91, "Student Village - D0A | ");totalRooms++;
        descriptions.put(92, "Student Village - D0B | ");totalRooms++;
        descriptions.put(93, "Student Village - D0C | ");totalRooms++;
        descriptions.put(94, "Student Village - D0D | ");totalRooms++;
        descriptions.put(95, "Student Village - D1A | ");totalRooms++;
        descriptions.put(96, "Student Village - D1B | ");totalRooms++;
        descriptions.put(97, "Student Village - D1C | ");totalRooms++;
        descriptions.put(98, "Student Village - D1D | ");totalRooms++;
        descriptions.put(99, "Student Village - D2A | ");totalRooms++;
        descriptions.put(100, "Student Village - D2B | ");totalRooms++;
        descriptions.put(101, "Student Village - D2C | ");totalRooms++;
        descriptions.put(102, "Student Village - D2D | ");totalRooms++;
        descriptions.put(103, "Student Village - D3A | ");totalRooms++;
        descriptions.put(104, "Student Village - D3B | ");totalRooms++;
        descriptions.put(105, "Student Village - D3C | ");totalRooms++;
        descriptions.put(106, "Student Village - D3D | ");totalRooms++;
        descriptions.put(107, "Student Village - D4A | ");totalRooms++;
        descriptions.put(108, "Student Village - D4B | ");totalRooms++;
        descriptions.put(109, "Student Village - D4C | ");totalRooms++;
        descriptions.put(110, "Student Village - D4D | ");totalRooms++;
        descriptions.put(111, "Student Village - D5A | ");totalRooms++;
        descriptions.put(112, "Student Village - D5B | ");totalRooms++;
        descriptions.put(113, "Student Village - D5C | ");totalRooms++;
        descriptions.put(114, "Student Village - D6A | ");totalRooms++;
        descriptions.put(115, "Student Village - D6B | ");totalRooms++;
        descriptions.put(116, "Student Village - D6C | ");totalRooms++;
        descriptions.put(117, "Student Village - D6D | ");totalRooms++;
        descriptions.put(118, "Student Village - D7A | ");totalRooms++;
        descriptions.put(119, "Student Village - D7B | ");totalRooms++;
        descriptions.put(120, "Student Village - D7C | ");totalRooms++;
        descriptions.put(121, "Student Village - D7D | ");totalRooms++;
        descriptions.put(122, "Student Village - D8A | ");totalRooms++;
        descriptions.put(123, "Student Village - D8B | ");totalRooms++;
        descriptions.put(124, "Student Village - D8C | ");totalRooms++;
        descriptions.put(125, "Student Village - D8D | ");totalRooms++;
        descriptions.put(126, "Student Village - D9A | ");totalRooms++;
        descriptions.put(127, "Student Village - D9B | ");totalRooms++;
        descriptions.put(128, "Student Village - D9C | ");totalRooms++;
        descriptions.put(129, "Student Village - D9D | ");totalRooms++;
    }
    private boolean canLiveHere(Student student)
    {
        if(currentStudents >= maxStudents)
        {
            return false;
        }
        if(student.getGradYearDelta() < 1)
        {
            return false;
        }
        if(currentStudents == (maxStudents - 1) )
        {//the village only has room for one more person, get the right gender
            switch(currentMales%2)
            {//even number of males, do NOT accept a male
                case 0: return !student.getGender().equals("Male");
                case 1: return student.getGender().equals("Male");
                default:break;
            }
        }
        return true;
    }
    private boolean canLiveHere(Roommates r)
    {
        if(currentStudents >= maxStudents)
        {
            return false;
        }
        if(currentStudents >= maxStudents - 1)
        {
            return false;
        }
        return true;
    }
    public boolean putInto(Student student)
    {//i dont check second preference because students who get put here
     //either wanted it or they didnt, either way, their first choice 
     //will be telling of their preferences
        if(canLiveHere(student) )
        {
            //MAYBE TWEAK THE ABOVE STATEMENT
            if(student.getGender().equals("Male") )
            {
                switch(student.getFirstRoomPreference() )
                {
                    //standard preference
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 14:
                        currentStudents++;
                        currentSM++;
                        currentMales++;
                        standardMales.put(student.getID(), student);
                        return true;
                    //quiet preference
                    case 2:
                    case 4:
                    case 6:
                    case 8:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        currentStudents++;
                        currentQM++;
                        currentMales++;
                        quietMales.put(student.getID(), student);
                        return true;
                    default: 
                        return false;
                }
            }
            else
            {//female
                switch(student.getFirstRoomPreference() )
                {
                    //standard preference
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 14:
                        currentStudents++;
                        currentSF++;
                        currentFemales++;
                        standardFemales.put(student.getID(), student);
                        return true;
                    //quiet preference
                    case 2:
                    case 4:
                    case 6:
                    case 8:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        currentStudents++;
                        currentQF++;
                        currentFemales++;
                        quietFemales.put(student.getID(), student);
                        return true;
                    default: 
                        return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    public void match() throws FileNotFoundException
    {        
        //match boys
        quietMaleRoommates = matchStudents(quietMales, "Student Village - QM");
        qmHomeless = getHomeless();
        standardMaleRoommates = matchStudents(standardMales, "Student Village - SM");
        smHomeless = getHomeless();
        
        qmhRoommates = matchHomelessStudents(qmHomeless);
        smhRoommates = matchHomelessStudents(smHomeless);
        theRestMales = getHomeless();
        
        while(!qmhRoommates.isEmpty() )
        {
            quietMaleRoommates.add(qmhRoommates.get(0) );
            qmhRoommates.remove(0);
        }
        while(!smhRoommates.isEmpty() )
        {
            standardMaleRoommates.add(smhRoommates.get(0) );
            smhRoommates.remove(0);
        }
        addTheRest(theRestMales, "Male");
        
        //match girls
        quietFemaleRoommates = matchStudents(quietFemales, "Student Village - QF");
        qfHomeless = getHomeless();
        standardFemaleRoommates = matchStudents(standardFemales, "Student Village - SF");
        sfHomeless = getHomeless();
        
        qfhRoommates = matchHomelessStudents(qfHomeless);
        sfhRoommates = matchHomelessStudents(sfHomeless);
        theRestFemales = getHomeless();
        while(!qfhRoommates.isEmpty() )
        {
            quietFemaleRoommates.add(qfhRoommates.get(0) );
            qfhRoommates.remove(0);
        }
        while(!sfhRoommates.isEmpty() )
        {
            standardFemaleRoommates.add(sfhRoommates.get(0) );
            sfhRoommates.remove(0);
        }
        addTheRest(theRestFemales, "Female");
        
        assignRooms();
        output();
//        debug();

//        System.out.println("currentStudents: " + currentStudents);
        
    }
    private void addTheRest(HashMap<String, Student> theRest, String sex)
    {
        if(sex.equals("Male") )
        {
            if(!theRest.isEmpty() )
            {//if theRest is empty, do nothing, matching is done
                if(theRest.size() == 1)
                {
                    Set<Map.Entry<String, Student> > theRestSet = theRest.entrySet();
                    Student it     = new Student();
                    Roommates room = new Roommates();
                    
                    for(Map.Entry<String, Student> i : theRestSet)
                    {
                        it = (Student) i.getValue();
                    }
                    room.addFirst(it);
                    quietMaleRoommates.add(room);
                }
                else
                {//theRest.size() == 2
                    Set<Map.Entry<String, Student> > theRestSet1 = theRest.entrySet();
                    Set<Map.Entry<String, Student> > theRestSet2 = theRest.entrySet();
                    Student one    = new Student();
                    Student two    = new Student();
                    boolean done   = false;
                    Roommates room = new Roommates();
                    
                    for(Map.Entry<String, Student> i : theRestSet1)
                    {
                        one = (Student) i.getValue();
                        for(Map.Entry<String, Student> j : theRestSet2)
                        {
                            two = (Student) j.getValue();
                            if(!one.getID().equals(two.getID() ) && !done )
                            {//NOT the same ID#
                                room.addFirst(one);
                                room.addSecond(two);
                                quietMaleRoommates.add(room);
                                done = true;
                            }
                        }
                    }
                }
            } 
        }
        else
        {//female
            if(!theRest.isEmpty() )
            {//if theRest is empty, do nothing, matching is done
                if(theRest.size() == 1)
                {
                    Set<Map.Entry<String, Student> > theRestSet = theRest.entrySet();
                    Student it     = new Student();
                    Roommates room = new Roommates();
                    
                    for(Map.Entry<String, Student> i : theRestSet)
                    {
                        it = (Student) i.getValue();
                    }
                    room.addFirst(it);
                    quietFemaleRoommates.add(room);
                }
                else
                {//theRest.size() == 2
                    Set<Map.Entry<String, Student> > theRestSet1 = theRest.entrySet();
                    Set<Map.Entry<String, Student> > theRestSet2 = theRest.entrySet();
                    Student one    = new Student();
                    Student two    = new Student();
                    boolean done   = false;
                    Roommates room = new Roommates();
                    
                    for(Map.Entry<String, Student> i : theRestSet1)
                    {
                        one = (Student) i.getValue();
                        for(Map.Entry<String, Student> j : theRestSet2)
                        {
                            two = (Student) j.getValue();
                            if(!one.getID().equals(two.getID() ) && !done )
                            {//NOT the same ID#
                                room.addFirst(one);
                                room.addSecond(two);
                                quietFemaleRoommates.add(room);
                                done = true;
                            }
                        }
                    }
                }
            }//end of if(!theRest.isEmpty() )
        }//end of addTheRest for females
    }
    public boolean addRoommates(Roommates r)
    {
        if(canLiveHere(r) )
        {
            if(r.getGender().equals("Male") )
            {
                switch(r.getFirstRoomPreference() )
                {
                    //quiet preference
                    case 2:
                    case 4:
                    case 5:
                    case 7:
                    case 14:
                        quietMaleRoommates.add(r);
                        currentStudents = currentStudents + 2;
                        return true;
                    //standard preference
                    case 1:
                    case 3:
                    case 6:
                    case 8:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        standardMaleRoommates.add(r);
                        currentStudents = currentStudents + 2;
                        return true;
                    default: 
                        return false;
                }
            }
            else
            {//females
                switch(r.getFirstRoomPreference() )
                {
                    //quiet preference
                    case 2:
                    case 4:
                    case 5:
                    case 7:
                    case 14:
                        quietFemaleRoommates.add(r);
                        currentStudents = currentStudents + 2;
                        return true;
                    //standard preference
                    case 1:
                    case 3:
                    case 6:
                    case 8:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        standardFemaleRoommates.add(r);
                        currentStudents = currentStudents + 2;
                        return true;
                    default: 
                        return false;
                }
            }
        }//end of if(canLiveHere() )
        else
        {
            return false;
        }
    }
	public void clear()
	{
		quietMales.clear();
        quietFemales.clear();
        standardMales.clear();
        standardFemales.clear();
        theRestMales.clear();
        theRestFemales.clear();
        qmHomeless.clear();
        smHomeless.clear();
        qfHomeless.clear();
        sfHomeless.clear();
        
        quietMaleRoommates.clear();
        quietFemaleRoommates.clear();
        standardMaleRoommates.clear();
        standardFemaleRoommates.clear();
        qmhRoommates.clear();
        smhRoommates.clear();
        qfhRoommates.clear();
        sfhRoommates.clear();
        outputStrings.clear();
		
		
		for(int i = 0; i < totalRooms; i++)
		{//reset to true
			available.put(i, true);
		}
		
		
        currentStudents = 0;
        currentQM       = 0;
        currentQF       = 0;
        currentSM       = 0;
        currentSF       = 0;
        currentMales    = 0; 
        currentFemales  = 0;
		num             = 0;
		
	}
    private void assignRooms()
    {
		while(!quietMaleRoommates.isEmpty() )
		{
			String s = descriptions.get(num) + "\n";
			s = s + quietMaleRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + quietMaleRoommates.get(0).getSecond().getFinalOutput() + "\n";
			outputStrings.add(s);
			available.put(num, false);
			quietMaleRoommates.remove(0);
			num++;
		}
		while(!quietFemaleRoommates.isEmpty() )
		{
			String s = descriptions.get(num) + "\n";
			s = s + quietFemaleRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + quietFemaleRoommates.get(0).getSecond().getFinalOutput() + "\n";
			outputStrings.add(s);
			available.put(num, false);
			quietFemaleRoommates.remove(0);
			num++;
		}
		while(!standardMaleRoommates.isEmpty() )
		{
			String s = descriptions.get(num) + "\n";
			s = s + standardMaleRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + standardMaleRoommates.get(0).getSecond().getFinalOutput() + "\n";
			outputStrings.add(s);
			available.put(num, false);
			standardMaleRoommates.remove(0);
			num++;
		}
		while(!standardFemaleRoommates.isEmpty() )
		{
			String s = descriptions.get(num) + "\n";
			s = s + standardFemaleRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + standardFemaleRoommates.get(0).getSecond().getFinalOutput() + "\n";
			outputStrings.add(s);
			available.put(num, false);
			standardFemaleRoommates.remove(0);
			num++;
		}
		
		/*
		System.out.println("\nvillage occupied rooms");
		for(int i = 0; i < outputStrings.size(); i++)
		{
			System.out.println(outputStrings.get(i) );
		}
		System.out.println("\nvillage Unoccupied rooms");
		for(int i = 0; i < available.size(); i++)
		{
			if(available.get(i) )
			{
				System.out.println(descriptions.get(i) );
			}
		}
		*/
		
//        System.out.println("theVillage end of roomAssignment");
//		System.out.println("quietMaleRoommates.size() : " + quietMaleRoommates.size() );
//		System.out.println("quietFemaleRoommates.size() : " + quietFemaleRoommates.size() );
//		System.out.println("standardMaleRoommates.size() : " + standardMaleRoommates.size() );
//		System.out.println("standardFemaleRoommates.size() : " + standardFemaleRoommates.size() );
		
				
				
						
    }
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("villageOut.csv"))) 
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
            System.out.println("\ninside catch clause of villageOut\n");
        }
	}
    private void debug()
    {
		System.out.println("\ntheVillage\n----------------");
		
        System.out.println("currentStudents: " + currentStudents);
        System.out.println("qmhRoommates: " + qmhRoommates.size());
        System.out.println("smhRoommates: " + smhRoommates.size());
        System.out.println("qfhRoommates: " + qfhRoommates.size());
        System.out.println("sfhRoommates: " + sfhRoommates.size());
        System.out.println("quietMaleRoommates: " + quietMaleRoommates.size());
        System.out.println("quietFemaleRoommates: " + quietFemaleRoommates.size());
        System.out.println("standardMaleRoommates: " + standardMaleRoommates.size());
        System.out.println("standardFemaleRoommates: " + standardFemaleRoommates.size());
        System.out.println("smHomeless: " + smHomeless.size());
        System.out.println("qfHomeless: " + qfHomeless.size());
        System.out.println("sfHomeless: " + sfHomeless.size());
        System.out.println("quietMales: " + quietMales.size());
        System.out.println("quietFemales: " + quietFemales.size());
        System.out.println("standardMales: " + standardMales.size());
        System.out.println("standardFemales: " + standardFemales.size());
        System.out.println("theRestMales: " + theRestMales.size());
        System.out.println("theRestFemales: " + theRestFemales.size());
		
//        System.out.println("VILLAGE MATCHES");
        System.out.println("-------------------------");
		/*
        for(int i = 0; i < quietMaleRoommates.size(); i++)
        {//quiet males
            Student first = new Student();
            Student second = new Student();
            
            first = quietMaleRoommates.get(i).getFirst();
            second = quietMaleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        for(int i = 0; i < quietFemaleRoommates.size(); i++)
        {//quiet females
            Student first = new Student();
            Student second = new Student();
            
            first = quietFemaleRoommates.get(i).getFirst();
            second = quietFemaleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        for(int i = 0; i < standardMaleRoommates.size(); i++)
        {//standard males
            Student first = new Student();
            Student second = new Student();
            
            first = standardMaleRoommates.get(i).getFirst();
            second = standardMaleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        for(int i = 0; i < standardFemaleRoommates.size(); i++)
        {//standard females
            Student first = new Student();
            Student second = new Student();
            
            first = standardFemaleRoommates.get(i).getFirst();
            second = standardFemaleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
*/
    }
}
