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
public class OsbornLarge extends Building{
    private Integer 
            totalRooms, maxStudents, maxQuiet, maxStandard, 
            currentQuietStudents, currentStandardStudents, currentStudents,
			num;
    //keys for descriptions must match indecies for rommates
    private HashMap<Integer, String> 
            descriptions;  
    private ArrayList< Roommates > 
            quietRoommates, standardRoommates, 
            qhRoommates, shRoommates;
    private ArrayList< String >
            outputStrings;
	private HashMap< Integer, Boolean >
			available;
    private HashMap< String, Student > 
            sHomeless, qHomeless, 
            quietStudents, standardStudents, 
            didntWantOsborn, theRest;
    /*
    
    different AL for each roommate type (quiet and standard)
    all HM probably unecessary
    
    */
    public OsbornLarge()
    {//constructor
        super();
        descriptions      = new HashMap<>();
        quietStudents     = new HashMap<>();
        standardStudents  = new HashMap<>();
        sHomeless         = new HashMap<>();
        qHomeless         = new HashMap<>();
        didntWantOsborn   = new HashMap<>();
        theRest           = new HashMap<>();
		available         = new HashMap<>();
        
        quietRoommates    = new ArrayList<>();
        standardRoommates = new ArrayList<>();
        qhRoommates       = new ArrayList<>();
        shRoommates       = new ArrayList<>();
		outputStrings     = new ArrayList<>();
        
        totalRooms              = 0;
		num                     = 0;
        currentStudents         = 0;
        currentQuietStudents    = 0;
        currentStandardStudents = 0;
        maxStudents             = 168;
        maxQuiet                = 28;
        maxStandard             = 140;
        
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
		
        descriptions.put(0, "Large Side - 111 | quiet");totalRooms++;
        descriptions.put(1, "Large Side - 112 | quiet");totalRooms++;
        descriptions.put(2, "Large Side - 113 | quiet");totalRooms++;
        descriptions.put(3, "Large Side - 114 | quiet");totalRooms++;
        descriptions.put(4, "Large Side - 115 | quiet");totalRooms++;
        descriptions.put(5, "Large Side - 122 | quiet");totalRooms++;
        descriptions.put(6, "Large Side - 123 | quiet");totalRooms++;
        descriptions.put(7, "Large Side - 124 | quiet");totalRooms++;
        descriptions.put(8, "Large Side - 125 | quiet");totalRooms++;
        descriptions.put(9, "Large Side - 131 | quiet");totalRooms++;
        descriptions.put(10, "Large Side - 132 | quiet");totalRooms++;
        descriptions.put(11, "Large Side - 133 | quiet");totalRooms++;
        descriptions.put(12, "Large Side - 134 | quiet");totalRooms++;
        descriptions.put(13, "Large Side - 135 | quiet");totalRooms++;
        descriptions.put(14, "Large Side - 141 | ");totalRooms++;
        descriptions.put(15, "Large Side - 142 | ");totalRooms++;
        descriptions.put(16, "Large Side - 143 | ");totalRooms++;
        descriptions.put(17, "Large Side - 144 | ");totalRooms++;
        descriptions.put(18, "Large Side - 145 | ");totalRooms++;
        descriptions.put(19, "Large Side - 152 | ");totalRooms++;
        descriptions.put(20, "Large Side - 153 | ");totalRooms++;
        descriptions.put(21, "Large Side - 154 | ");totalRooms++;
        descriptions.put(22, "Large Side - 155 | ");totalRooms++;
        descriptions.put(23, "Large Side - 161 | ");totalRooms++;
        descriptions.put(24, "Large Side - 162 | ");totalRooms++;
        descriptions.put(25, "Large Side - 163 | ");totalRooms++;
        descriptions.put(26, "Large Side - 164 | ");totalRooms++;
        descriptions.put(27, "Large Side - 165 | ");totalRooms++;
        descriptions.put(28, "Large Side - 211 | ");totalRooms++;
        descriptions.put(29, "Large Side - 212 | ");totalRooms++;
        descriptions.put(30, "Large Side - 213 | ");totalRooms++;
        descriptions.put(31, "Large Side - 214 | ");totalRooms++;
        descriptions.put(32, "Large Side - 215 | ");totalRooms++;
        descriptions.put(33, "Large Side - 222 | ");totalRooms++;
        descriptions.put(34, "Large Side - 223 | ");totalRooms++;
        descriptions.put(35, "Large Side - 224 | ");totalRooms++;
        descriptions.put(36, "Large Side - 225 | ");totalRooms++;
        descriptions.put(37, "Large Side - 231 | ");totalRooms++;
        descriptions.put(38, "Large Side - 232 | ");totalRooms++;
        descriptions.put(39, "Large Side - 233 | ");totalRooms++;
        descriptions.put(40, "Large Side - 234 | ");totalRooms++;
        descriptions.put(41, "Large Side - 235 | ");totalRooms++;
        descriptions.put(42, "Large Side - 241 | ");totalRooms++;
        descriptions.put(43, "Large Side - 242 | ");totalRooms++;
        descriptions.put(44, "Large Side - 243 | ");totalRooms++;
        descriptions.put(45, "Large Side - 244 | ");totalRooms++;
        descriptions.put(46, "Large Side - 245 | ");totalRooms++;
        descriptions.put(47, "Large Side - 252 | ");totalRooms++;
        descriptions.put(48, "Large Side - 253 | ");totalRooms++;
        descriptions.put(49, "Large Side - 254 | ");totalRooms++;
        descriptions.put(50, "Large Side - 255 | ");totalRooms++;
        descriptions.put(51, "Large Side - 261 | ");totalRooms++;
        descriptions.put(52, "Large Side - 262 | ");totalRooms++;
        descriptions.put(53, "Large Side - 263 | ");totalRooms++;
        descriptions.put(54, "Large Side - 264 | ");totalRooms++;
        descriptions.put(55, "Large Side - 265 | ");totalRooms++;
        descriptions.put(56, "Large Side - 311 | ");totalRooms++;
        descriptions.put(57, "Large Side - 312 | ");totalRooms++;
        descriptions.put(58, "Large Side - 313 | ");totalRooms++;
        descriptions.put(59, "Large Side - 314 | ");totalRooms++;
        descriptions.put(60, "Large Side - 315 | ");totalRooms++;
        descriptions.put(61, "Large Side - 322 | ");totalRooms++;
        descriptions.put(62, "Large Side - 323 | ");totalRooms++;
        descriptions.put(63, "Large Side - 324 | ");totalRooms++;
        descriptions.put(64, "Large Side - 325 | ");totalRooms++;
        descriptions.put(65, "Large Side - 331 | ");totalRooms++;
        descriptions.put(66, "Large Side - 332 | ");totalRooms++;
        descriptions.put(67, "Large Side - 333 | ");totalRooms++;
        descriptions.put(68, "Large Side - 334 | ");totalRooms++;
        descriptions.put(69, "Large Side - 335 | ");totalRooms++;
        descriptions.put(70, "Large Side - 341 | ");totalRooms++;
        descriptions.put(71, "Large Side - 342 | ");totalRooms++;
        descriptions.put(72, "Large Side - 343 | ");totalRooms++;
        descriptions.put(73, "Large Side - 344 | ");totalRooms++;
        descriptions.put(74, "Large Side - 345 | ");totalRooms++;
        descriptions.put(75, "Large Side - 352 | ");totalRooms++;
        descriptions.put(76, "Large Side - 353 | ");totalRooms++;
        descriptions.put(77, "Large Side - 354 | ");totalRooms++;
        descriptions.put(78, "Large Side - 355 | ");totalRooms++;
        descriptions.put(79, "Large Side - 361 | ");totalRooms++;
        descriptions.put(80, "Large Side - 362 | ");totalRooms++;
        descriptions.put(81, "Large Side - 363 | ");totalRooms++;
        descriptions.put(82, "Large Side - 364 | ");totalRooms++;
        descriptions.put(83, "Large Side - 365 | ");totalRooms++;
        
    }
    private boolean canLiveHere(Student student)
    {
        if(student.getGender().equals("Male") )
        {//no males allowed
            return false;
        }
        if(currentStudents >= maxStudents)
        {//no over fill
            return false;
        }
        return true;
    }
    private boolean canLiveHere(Roommates r)
    {
        if(r.getGender().equals("Male") )
        {//no males allowed
            return false;
        }
        if(currentStudents >= maxStudents - 1)
        {//no over fill
            return false;
        }
        return true;
    }
    public boolean putInto(Student student)
    {
        if(canLiveHere(student) )
        {
            if(student.getFirstRoomPreference() > 4 && student.getFirstRoomPreference() < 7)
            {//this is their first choice
                switch(student.getFirstRoomPreference() )
                {
                    case 5:
                        standardStudents.put(student.getID(), student);
                        currentStandardStudents++;
                        currentStudents++;
                        return true;
                    case 6:
                        quietStudents.put(student.getID(), student);
                        currentQuietStudents++;
                        currentStudents++;
                        return true;
                    default: 
                        return false;
                }
            }
            else if(student.getSecondRoomPreference() > 4 && student.getSecondRoomPreference() < 7)
            {//not first, but second
                switch(student.getSecondRoomPreference() )
                {
                    case 5:
                        standardStudents.put(student.getID(), student);
                        currentStandardStudents++;
                        currentStudents++;
                        return true;
                    case 6:
                        quietStudents.put(student.getID(), student);
                        currentQuietStudents++;
                        currentStudents++;
                        return true;
                    default: 
                        return false;
                }
            }
            else
            {//not first or second, but must live in osborn... freshman
                switch(student.getFirstRoomPreference() )
                {
                    //standard preference
                    case 1:
                    case 3:
                    case 7:
                    case 14:
                        standardStudents.put(student.getID(), student);
                        currentStandardStudents++;
                        currentStudents++;
                        return true;
                    //quiet preference
                    case 2:
                    case 4:
                    case 8:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        quietStudents.put(student.getID(), student);
                        currentQuietStudents++;
                        currentStudents++;
                        return true;
                    default: 
                        return false;
                }
            }
        }//end of if(canLiveHere() )
        else
        {//cannot live here
            return false;
        }
    }
	private void assignRooms()
	{
		System.out.println("inside OsbornLarge::assignRooms()");
		System.out.println("\nosbornLarge quietRoommates.size() : " + quietRoommates.size() );
		System.out.println("\nosbornLarge standardRoommates.size() : " + standardRoommates.size() );
		
		
		while(!quietRoommates.isEmpty() )
		{
			
		System.out.println("!quietRoommates.isEmpty()  : " + quietRoommates.size() );
		System.out.println("num : " + num);
			String s = descriptions.get(num) + "\n";
			s = s + quietRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + quietRoommates.get(0).getSecond().getFinalOutput() + "\n";
		System.out.println(s);
			outputStrings.add(s);
			available.put(num, false);
			quietRoommates.remove(0);
			num++;
		}
		while(!standardRoommates.isEmpty() )
		{
		System.out.println("!standardRoommates.isEmpty()  : " + standardRoommates.size() );
		System.out.println("num : " + num);
			String s = descriptions.get(num) + "\n";
			s = s + standardRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + standardRoommates.get(0).getSecond().getFinalOutput() + "\n";
			
		System.out.println(s);
			outputStrings.add(s);
			available.put(num, false);
			standardRoommates.remove(0);
			num++;
		}
		
		/*
//		System.out.println("\nosbornLarge occupied rooms");
		for(int i = 0; i < outputStrings.size(); i++)
		{
//			System.out.println(outputStrings.get(i) );
		}
//		System.out.println("\nosbornLarge Unoccupied rooms");
		for(int i = 0; i < available.size(); i++)
		{
			if(available.get(i) )
			{
//				System.out.println(descriptions.get(i) );
			}
		}
*/
		
        System.out.println("osbornLarge end of roomAssignment");
        System.out.println("quietRoommates.size(): " + quietRoommates.size());
        System.out.println("standardRoommates.size(): " + standardRoommates.size());


	}
    public void match()
    {
		
        System.out.println("\nosbornLarge STATS");
        System.out.println("standardStudents.size() : " + standardStudents.size() );
        System.out.println("quietStudents.size() : " + quietStudents.size() );
        System.out.println("currentStandardStudents : " + currentStandardStudents);
        System.out.println("currentQuietStudents : " + currentQuietStudents);
        System.out.println("currentStudents : " + currentStudents);
        System.out.println("------------------------");
		
		
		
        quietRoommates = matchStudents(quietStudents, "Osborn Hall, Large Side - Q");
        System.out.println("quietRoommates.size() : " + quietRoommates.size() );
		
        qHomeless = getHomeless();
        System.out.println("qHomeless.size() : " + qHomeless.size() );
		
        standardRoommates = matchStudents(standardStudents, "Osborn Hall, Large Side - S");
        System.out.println("standardRoommates.size() : " + standardRoommates.size() );
		
        sHomeless = getHomeless();
        System.out.println("sHomeless.size() : " + sHomeless.size() );
		
        
        qhRoommates = matchHomelessStudents(qHomeless);
        System.out.println("qhRoommates.size() : " + qhRoommates.size() );
		
        shRoommates = matchHomelessStudents(sHomeless);
        System.out.println("shRoommates.size() : " + shRoommates.size() );
		
        theRest = getHomeless();
        System.out.println("theRest.size() : " + theRest.size() );
		
        
        if(!theRest.isEmpty())
        {//if theRest is empty, do nothing, matching is done
            if(theRest.size() == 1)
            {
				
        System.out.println("if(theRest.size() == 1)");
                Set<Map.Entry<String, Student> > theRestSet = theRest.entrySet();
                Student it = new Student();
                Roommates room = new Roommates();
                for(Map.Entry<String, Student> i : theRestSet)
                {
                    it = (Student) i.getValue();
                }
                room.addFirst(it);
                qhRoommates.add(room);
            }
            else
            {//theRest.size() == 2
				
        System.out.println("else (theRest.size() == 2)");
                Set<Map.Entry<String, Student> > theRestSet1 = theRest.entrySet();
                Set<Map.Entry<String, Student> > theRestSet2 = theRest.entrySet();
                Student one    = new Student();
                Student two    = new Student();
                boolean done = false;
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
                            qhRoommates.add(room);
                            done = true;
                        }
                    }
                }
            }
        }
        while(!qhRoommates.isEmpty() )
        {
        System.out.println("!qhRoommates.isEmpty() : " + qhRoommates.size() );
            quietRoommates.add(qhRoommates.get(0) );
            qhRoommates.remove(0);
        }
        while(!shRoommates.isEmpty() )
        {
        System.out.println("!shRoommates.isEmpty() : " + shRoommates.size() );
            standardRoommates.add(shRoommates.get(0) );
            shRoommates.remove(0);
        }
        
        assignRooms();
		output();
//        debug();

        System.out.println("very last thing - currentStudents: " + currentStudents);
        
    }
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("osbornLargeOut.csv"))) 
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
            System.out.println("\ninside catch clause of osbornLargeOut\n");
        }
	}
    public boolean addRoommates(Roommates r)
    {
        if(canLiveHere(r) )
        {
            switch(r.getFirstRoomPreference() )
            {
                //quiet preference
                case 2:
                case 4:
                case 5:
                case 7:
                case 14:
                    quietRoommates.add(r);
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
                    standardRoommates.add(r);
                    currentStudents = currentStudents + 2;
                    return true;
                default: 
                    return false;
            }
        }
        else
        {
            return false;
        }
    }
	public void clear()
	{ 
		quietStudents.clear();
        standardStudents.clear();
        sHomeless.clear();
        qHomeless.clear();
        didntWantOsborn.clear();
        theRest.clear();
        
        quietRoommates.clear();
        standardRoommates.clear();
        qhRoommates.clear();
        shRoommates.clear();
		outputStrings.clear();
		
		for(int i = 0; i < totalRooms; i++)
		{//reset to true
			available.put(i, true);
		}
		
		num                     = 0;
        currentStudents         = 0;
        currentQuietStudents    = 0;
        currentStandardStudents = 0;
	}
    private void debug()
    {
        System.out.println("\nosbornLarge\n----------------");
		
        System.out.println("quietRoommates: " + quietRoommates.size());
        System.out.println("standardRoommates: " + standardRoommates.size());
        System.out.println("qhRoommates: " + qhRoommates.size());
        System.out.println("sHomeless: " + sHomeless.size());
        System.out.println("qHomeless: " + qHomeless.size());
        System.out.println("quietStudents: " + quietStudents.size());
        System.out.println("standardStudents: " + standardStudents.size());
        System.out.println("didntWantOsborn: " + didntWantOsborn.size());
        System.out.println("theRest: " + theRest.size());
//		System.out.println("OSBORN LARGE SIDE MATCHES");
        System.out.println("-------------------------");
		/*
        for(int i = 0; i < quietRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = quietRoommates.get(i).getFirst();
            second = quietRoommates.get(i).getSecond();
//            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        for(int i = 0; i < standardRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = standardRoommates.get(i).getFirst();
            second = standardRoommates.get(i).getSecond();
//            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
*/
    }
    
}
