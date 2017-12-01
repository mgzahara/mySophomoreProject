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
public class Brady extends Building{
    private Integer 
            totalRooms, maxStudents, maxQuietStudents, 
            maxStandardStudents, maxPrivate, 
            currentQuietStudents, currentStandardStudents, 
            currentStudents, currentPrivate, num;
    //keys for descriptions must match indecies for rommates
    private HashMap<Integer, String> 
            descriptions; 
	private HashMap< Integer, Boolean > 
			available;
    private ArrayList< Roommates > 
            quiet4Roommates, quiet2Roommates, 
            standard4Roommates, standard2Roommates, 
            quietHomelessRoommates, standardHomelessRoommates;
	private ArrayList< String > 
			outputStrings;
    private HashMap< String, Student > 
            quietHomeless, standardHomeless, theRest, 
            wantQuiet2, wantQuiet4, wantStandard2, wantStandard4, 
            wantPrivate;
    
    public Brady()
    {//constructor
        super();
        descriptions     = new HashMap<>();
        wantQuiet4       = new HashMap<>();
        wantQuiet2       = new HashMap<>();
        wantStandard4    = new HashMap<>();
        wantStandard2    = new HashMap<>();
        wantPrivate      = new HashMap<>();
        quietHomeless    = new HashMap<>();
        standardHomeless = new HashMap<>();
        theRest          = new HashMap<>();
		available        = new HashMap<>();
        
		outputStrings             = new ArrayList<>();
        quiet4Roommates           = new ArrayList<>();
        quiet2Roommates           = new ArrayList<>();
        standard4Roommates        = new ArrayList<>();
        standard2Roommates        = new ArrayList<>();
        quietHomelessRoommates    = new ArrayList<>();
        standardHomelessRoommates = new ArrayList<>();
        
        totalRooms              = 0;
        currentQuietStudents    = 0;
        currentStudents         = 0;
        currentStandardStudents = 0;
        currentPrivate          = 0;
		num                     = 0;
		
        maxStudents         = 169;
        maxQuietStudents    = 34;
        maxStandardStudents = 135;
        maxPrivate          = 3;
        
        //how many:
            //quiet 4man        6  rooms
            //quiet 2man        5  rooms
            //standard 4man     22 rooms
            //standard 2man     22 rooms
            //private           3  rooms
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
        
        descriptions.put(0,"104 | quiet");totalRooms++;
        descriptions.put(1,"105 | quiet");totalRooms++;
        descriptions.put(2,"107 | quiet");totalRooms++;
        descriptions.put(3,"109 | quiet");totalRooms++;
        descriptions.put(4,"111 | quiet");totalRooms++;
        descriptions.put(5,"101 | quiet split");totalRooms++;
        descriptions.put(6,"102 | quiet split");totalRooms++;
        descriptions.put(7,"110 | quiet split");totalRooms++;
        descriptions.put(8,"106 | quiet split");totalRooms++;
        descriptions.put(9,"108 | quiet split");totalRooms++;
        descriptions.put(10,"112 | quiet split");totalRooms++;
		
        descriptions.put(11,"151 | split");totalRooms++;
        descriptions.put(12,"152 | split");totalRooms++;
        descriptions.put(13,"156 | split");totalRooms++;
        descriptions.put(14,"158 | split");totalRooms++;
        descriptions.put(15,"160 | split");totalRooms++;
        descriptions.put(16,"162 | split");totalRooms++;
        descriptions.put(17,"202 | split");totalRooms++;
        descriptions.put(18,"204 | split");totalRooms++;
        descriptions.put(19,"206 | split");totalRooms++;
        descriptions.put(20,"208 | split");totalRooms++;
        descriptions.put(21,"210 | split");totalRooms++;
        descriptions.put(22,"212 | split");totalRooms++;
        descriptions.put(23,"252 | split");totalRooms++;
        descriptions.put(24,"254 | split");totalRooms++;
        descriptions.put(25,"256 | split");totalRooms++;
        descriptions.put(26,"258 | split");totalRooms++;
        descriptions.put(27,"260 | split");totalRooms++;
        descriptions.put(28,"262 | split");totalRooms++;
        descriptions.put(29,"272 | split");totalRooms++;
        descriptions.put(30,"222 | open");totalRooms++;
        descriptions.put(31,"224 | open");totalRooms++;
        descriptions.put(32,"226 | open");totalRooms++;
        descriptions.put(33,"154 | ");totalRooms++;
        descriptions.put(34,"155 | ");totalRooms++;
        descriptions.put(35,"157 | ");totalRooms++;
        descriptions.put(36,"159 | ");totalRooms++;
        descriptions.put(37,"161 | ");totalRooms++;
        descriptions.put(38,"165 | ");totalRooms++;
        descriptions.put(39,"173 | ");totalRooms++;
        descriptions.put(40,"207 | ");totalRooms++;
        descriptions.put(41,"209 | ");totalRooms++;
        descriptions.put(42,"211 | ");totalRooms++;
        descriptions.put(43,"217 | ");totalRooms++;
        descriptions.put(44,"219 | ");totalRooms++;
        descriptions.put(45,"221 | ");totalRooms++;
        descriptions.put(46,"223 | ");totalRooms++;
        descriptions.put(47,"225 | ");totalRooms++;
        descriptions.put(48,"257 | ");totalRooms++;
        descriptions.put(49,"259 | ");totalRooms++;
        descriptions.put(50,"261 | ");totalRooms++;
        descriptions.put(51,"267 | ");totalRooms++;
        descriptions.put(52,"269 | ");totalRooms++;
        descriptions.put(53,"271 | ");totalRooms++;
        descriptions.put(54,"275 | ");totalRooms++;
        descriptions.put(55,"273 | pr");totalRooms++;
        descriptions.put(56,"251 | pr");totalRooms++;
        descriptions.put(57,"201 | pr");totalRooms++;
		
		
    }
    private boolean canLiveHere(Student student)
    {//returns true if given student may live in the building, false if not
        if(student.getGender().equals("Female") )
        {
            return false;
        }
        if(currentStudents >= maxStudents)
        {
            return false;
        }
        return true;
    }
    private boolean canLiveHere(Roommates r)
    {//returns true if guven student may live in the building, false if not
        if(r.getGender().equals("Female") )
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
    {
        if(canLiveHere(student) )
        {//student can live here
            if(student.getFirstRoomPreference() > 0 && student.getFirstRoomPreference() < 5)
            {//first choice was of Brady
                if(!student.getFirstPrivateRoomDesired()  ||  currentPrivate >= maxPrivate )
                {//they DO NOT want a private room OR private rooms are full
                    switch(student.getFirstRoomPreference() )
                    {//can live here && firstChoice was Brady && DONT want private room
                        case 1:
                            wantStandard2.put(student.getID(), student);
                            currentStudents++;
                            currentStandardStudents++;
                            return true;
                        case 2:
                            wantQuiet2.put(student.getID(), student);
                            currentStudents++;
                            currentQuietStudents++;
                            return true;
                        case 3:
                            wantStandard4.put(student.getID(), student);
                            currentStudents++;
                            currentStandardStudents++;
                            return true;
                        case 4:
                            wantQuiet4.put(student.getID(), student);
                            currentStudents++;
                            currentQuietStudents++;
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
            }//close if firstChoice == Brady
            else if (student.getSecondRoomPreference() > 0 && student.getSecondRoomPreference() < 5)
            {//second choice was of Brady
                if(!student.getSecondPrivateRoomDesired()  || (currentPrivate >= maxPrivate) )
                {//they DO NOT want a private room
                    switch(student.getFirstRoomPreference() )
                    {//can live here && second choice was Brady && DONT want private room
                        case 1:
                            wantStandard2.put(student.getID(), student);
                            currentStudents++;
                            currentStandardStudents++;
                            return true;
                        case 2:
                            wantQuiet2.put(student.getID(), student);
                            currentStudents++;
                            currentQuietStudents++;
                            return true;
                        case 3:
                            wantStandard4.put(student.getID(), student);
                            currentStudents++;
                            currentStandardStudents++;
                            return true;
                        case 4:
                            wantQuiet4.put(student.getID(), student);
                            currentStudents++;
                            currentQuietStudents++;
                            return true;
                        default:
                            return false;
                    }
                }
                else
                {//they DO want a private room
                    currentStudents++;
                    currentPrivate++;
                    wantPrivate.put(student.getID(), student);
                    return true;
                }
            }//end second choice == Brady
            else
            {//can live here, but didnt want to
                switch(student.getFirstRoomPreference() )
                {
                    //quiet preference
                    case 5:
                    case 7:
                    case 14:
                        wantQuiet2.put(student.getID(), student);
                        currentStudents++;
                        return true;
                    //standard preference
                    case 6:
                    case 8:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        wantStandard2.put(student.getID(), student);
                        currentStudents++;
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
    public void match()
    {
		if(wantPrivate.size() < maxPrivate)
		{
//			System.out.println("in match() wantPrivate.size() : " + wantPrivate.size());
			while(pickPrivateStudent() )
			{ /*bodyless while loop to assign random students to be private*/
//			System.out.println("in match() wantPrivate.size() : " + wantPrivate.size());
			}
		}
		else
		{
//			System.out.println("in match() wantPrivate.size() : " + wantPrivate.size());
		}
        quiet4Roommates    = matchStudents(wantQuiet4,    "Brady Hall Q4");
        quiet2Roommates    = matchStudents(wantQuiet2,    "Brady Hall Q2");
        quietHomeless      = getHomeless();
        
        standard4Roommates = matchStudents(wantStandard4, "Brady Hall S4");
        standard2Roommates = matchStudents(wantStandard2, "Brady Hall S2");
        standardHomeless   = getHomeless();
        
        quietHomelessRoommates = matchHomelessStudents(quietHomeless);
        
        standardHomelessRoommates = matchHomelessStudents(standardHomeless);
        
        //get the rest of the homeless
        theRest = getHomeless();//will either be 0, 1, or 2
        addTheRest(theRest);
        //join homeless with the rest
        while(!quietHomelessRoommates.isEmpty() )
        {
            quiet2Roommates.add(quietHomelessRoommates.get(0) );
            quietHomelessRoommates.remove(0);
        }
        while(!standardHomelessRoommates.isEmpty() )
        {
            standard2Roommates.add(standardHomelessRoommates.get(0) );
            standardHomelessRoommates.remove(0);
        }
        assignRooms();
		output();
//        debug();

//        System.out.println("currentStudents: " + currentStudents);
    }
	private void assignRooms()
	{//associates each pair of roommates with a certain room in brady hall
//		System.out.println("matching private students with rooms");
		while(!wantPrivate.isEmpty() )
		{//take care of private students first
//			System.out.println("wantPrivate.size() : " + wantPrivate.size() );
			Map.Entry<String, Student> entry = wantPrivate.entrySet().iterator().next();
			
			String s = descriptions.get(55 + num) + "\n";
			s = s + wantPrivate.get(entry.getKey() ).getFinalOutput() + "\n\n";
			outputStrings.add(s);
			wantPrivate.remove(entry.getKey() );
			available.put(55 + num, false);
			num++;
		}
		
		num = 0;//reset num for regular cases
//		System.out.println("matching quiet2Roommates");
		while(quiet2Roommates.size() > 1 && num < 55)
		{//place all pairs from quiet2Roommates
//			System.out.println("quiet2Roommates.size() : " + quiet2Roommates.size() );
			getRoomsStrings(quiet2Roommates);
//			System.out.println("last room addition\n" + outputStrings.get(outputStrings.size() - 1 ) );
		}
		if(quiet2Roommates.size() == 1)
		{
			if(quiet4Roommates.size() > 0)
			{
//				System.out.println("quiet2Roommates.size() == 1\t\tif(quiet4Roommates.size() > 0)");
				getRoomsStrings(quiet2Roommates, quiet4Roommates);
			}
			else if(standard2Roommates.size() > 0)
			{
//				System.out.println("quiet2Roommates.size() == 1\t\telse if(standard2Roommates.size() > 0)");
				getRoomsStrings(quiet2Roommates, standard2Roommates);
			}
			else if(standard4Roommates.size() > 0)
			{
//				System.out.println("quiet2Roommates.size() == 1\t\telse if(standard4Roommates.size() > 0)");
				getRoomsStrings(quiet2Roommates, standard4Roommates);
			}
			else
			{//should never get here
//				System.out.println("\nshould never get here\nquiet2Roommates.size() == 1\t\telse");
				String s = descriptions.get(num) + "\n";
				s = s + quiet2Roommates.get(0).getFirst().getFinalOutput() + "\n";
				s = s + quiet2Roommates.get(0).getSecond().getFinalOutput() + "\n";
				outputStrings.add(s);
				num++;
				available.put(num, false);
				quiet2Roommates.remove(0);
			}
//			System.out.println("last room addition\n" + outputStrings.get(outputStrings.size() - 1 ) );
		}
		while(quiet4Roommates.size() > 1 && num < 55)
		{//place all pairs from quiet4Roommates
			getRoomsStrings(quiet4Roommates);
		}
		if(quiet4Roommates.size() == 1)
		{
			if(standard4Roommates.size() > 0)
			{
				getRoomsStrings(quiet4Roommates, standard4Roommates);
			}
			else if(standard2Roommates.size() > 0)
			{
				getRoomsStrings(quiet4Roommates, standard2Roommates);
			}
			else
			{
				String s = descriptions.get(num) + "\n";
				s = s + quiet4Roommates.get(0).getFirst().getFinalOutput() + "\n";
				s = s + quiet4Roommates.get(0).getSecond().getFinalOutput() + "\n\n";
				outputStrings.add(s);
				num++;
				available.put(num, false);
				quiet4Roommates.remove(0);
			}
		}
		while(standard4Roommates.size() > 1 && num < 55)
		{//place all pairs from standard4Roommates
			getRoomsStrings(standard4Roommates);
		}
		if(standard4Roommates.size() == 1)
		{
			if(standard2Roommates.size() > 0)
			{
				getRoomsStrings(standard4Roommates, standard2Roommates);
			}
			else
			{
				String s = descriptions.get(num) + "\n";
				s = s + standard4Roommates.get(0).getFirst().getFinalOutput() + "\n";
				s = s + standard4Roommates.get(0).getSecond().getFinalOutput() + "\n\n";
				outputStrings.add(s);
				num++;
				available.put(num, false);
				standard4Roommates.remove(0);
			}
		}
		while(standard2Roommates.size() > 1 && num < 55)
		{//place all pairs from standard4Roommates
			getRoomsStrings(standard2Roommates);
		}
		if(standard2Roommates.size() == 1)
		{
			String s = descriptions.get(num) + "\n";
			s = s + standard2Roommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + standard2Roommates.get(0).getSecond().getFinalOutput() + "\n\n";
			outputStrings.add(s);
			num++;
			available.put(num, false);
			standard2Roommates.remove(0);
		}
		
		
//        System.out.println("brady end of roomAssignment");
//        System.out.println("quiet4Roommates: " + quiet4Roommates.size());
//        System.out.println("quiet2Roommates: " + quiet2Roommates.size());
//        System.out.println("standard4Roommates: " + standard4Roommates.size());
//        System.out.println("standard2Roommates: " + standard2Roommates.size());
		
		//<editor-fold>
		/*
		System.out.println("\n----------------------\nbrady hall unordered room assignments");
		for(int i = 0; i < outputStrings.size(); i++)
		{
			System.out.println(outputStrings.get(i) );
		} 
//		System.out.println("\n----------------------\nquiet4Roommates.size() : " + quiet4Roommates.size());
//		System.out.println("\n----------------------\nquiet2Roommates.size() : " + quiet2Roommates.size());
//		System.out.println("\n----------------------\nstandard4Roommates.size() : " + standard4Roommates.size());
//		System.out.println("\n----------------------\nstandard2Roommates.size() : " + standard2Roommates.size());
//		System.out.println(standard2Roommates.get(0).getFirst().getFinalOutput());
//		System.out.println(standard2Roommates.get(0).getSecond().getFinalOutput());
		
		System.out.println("\n----------------------\nbrady hall unoccupied rooms");
		
		for(int i = 0; i < descriptions.size(); i++)
		{
			if(available.get(i) )
			{
				System.out.println(descriptions.get(i) );
			}
		}
*/
//</editor-fold>
	}
	private void getRoomsStrings(ArrayList< Roommates > al)
	{
		String s = descriptions.get(num) + "\n";
//		System.out.println("getRoomsStrings 1\nal.size() : " + al.size());
		if(num < 5)
		{//single pair
//			System.out.println("if(num < 5)");
			s = s + al.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al.get(0).getSecond().getFinalOutput();
			s = s + "\n";
			al.remove(0);
		}
		else if(num < 33)
		{//5 <= num <= 32 -> two pairs
//			System.out.println("else if(num < 33)");
			s = s + al.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al.get(0).getSecond().getFinalOutput();
			s = s + "\n";

			s = s + al.get(1).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al.get(1).getSecond().getFinalOutput();
			s = s + "\n";
			al.remove(0);
			al.remove(0);
		}
		else
		{//regular rooms -> single pair
//			System.out.println("else");
			s = s + al.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al.get(0).getSecond().getFinalOutput();
			s = s + "\n";
			al.remove(0);
		}
		outputStrings.add(s);
		available.put(num, false);
		num++;
	}
	private void getRoomsStrings(ArrayList< Roommates > al1, ArrayList< Roommates > al2)
	{
		String s = descriptions.get(num) + "\n";
//		System.out.println("getRoomsStrings 1\nal1.size() : " + al1.size() + " al2.size() : " + al2.size());
		if(num < 5)
		{//single pair
//			System.out.println("if(num < 5)");
			s = s + al1.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al1.get(0).getSecond().getFinalOutput();
			s = s + "\n";
			al1.remove(0);
		}
		else if(num < 33)
		{//5 <= num <= 32 -> two pairs
//			System.out.println("else if(num < 33)");
			s = s + al1.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al1.get(0).getSecond().getFinalOutput();
			s = s + "\n";
			al1.remove(0);

			s = s + al2.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al2.get(0).getSecond().getFinalOutput();
			s = s + "\n";
			al2.remove(0);
		}
		else
		{//regular rooms -> single pair
//			System.out.println("else");
			s = s + al1.get(0).getFirst().getFinalOutput();
			s = s + "\n";
			s = s + al1.get(0).getSecond().getFinalOutput();
			s = s + "\n";
			al1.remove(0);
		}
		outputStrings.add(s);
		available.put(num, false);
		num++;
	}
    public boolean addRoommates(Roommates r)
    {
        if(canLiveHere(r) )
        {
            switch(r.getFirstRoomPreference() )
            {
                case 3:
                    standard4Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    return true;
                case 4:
                    quiet4Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    return true;
                //standard preference
                case 2:
                case 5:
                case 7:
                case 14:
                    quiet2Roommates.add(r);
                    currentStudents = currentStudents + 2;
                    return true;
                //quiet preference
                case 1:
                case 6:
                case 8:
                case 15:
                case 16:
                case 17:
                case 18:
                    standard2Roommates.add(r);
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
    private void addTheRest(HashMap< String, Student > theRest)
    {
        if(!theRest.isEmpty() )
        {//if theRest is empty, do nothing, matching is done
            if(theRest.size() == 1)
            {
                Set<Map.Entry<String, Student> > theRestSet = theRest.entrySet();
                Student it = new Student();
                Roommates room = new Roommates();
                for(Map.Entry<String, Student> i : theRestSet)
                {
                    it = (Student) i.getValue();
                }
                room.addFirst(it);
                quietHomelessRoommates.add(room);
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
                            quietHomelessRoommates.add(room);
                            done = true;
                        }
                    }
                }
            }
        }
    }
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("bradyOut.csv"))) 
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
            System.out.println("\ninside catch clause of bradyOut\n");
        }
	}
	public void clear()
	{ 
		currentQuietStudents    = 0;
        currentStudents         = 0;
        currentStandardStudents = 0;
        currentPrivate          = 0;
		num                     = 0;
		
		wantQuiet4.clear();
        wantQuiet2.clear();
        wantStandard4.clear();
        wantStandard2.clear();
        wantPrivate.clear();
        quietHomeless.clear();
        standardHomeless.clear();
        theRest.clear();
        
		for(int i = 0; i < totalRooms; i++)
		{//reset to true
			available.put(i, true);
		}	
		
		outputStrings.clear();
        quiet4Roommates.clear();
        quiet2Roommates.clear();
        standard4Roommates.clear();
        standard2Roommates.clear();
        quietHomelessRoommates.clear();
        standardHomelessRoommates.clear();
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
		
		if(wantQuiet2.size() > 0)
		{
			keys = new ArrayList<>(wantQuiet2.keySet());
			String randomKey = keys.get( random.nextInt(keys.size()) );
			value = (Student) wantQuiet2.get(randomKey);
			
			wantPrivate.put(value.getID(), value);
			wantQuiet2.remove(value.getID() );
		}
		else if(wantStandard2.size() > 0)
		{
			keys = new ArrayList<>(wantStandard2.keySet());
			String randomKey = keys.get( random.nextInt(keys.size()) );
			value = (Student) wantStandard2.get(randomKey);
			
			wantPrivate.put(value.getID(), value);
			wantStandard2.remove(value.getID() );
		}
		else if(wantQuiet4.size() > 0)
		{
			keys = new ArrayList<>(wantQuiet4.keySet());
			String randomKey = keys.get( random.nextInt(keys.size()) );
			value = (Student) wantQuiet4.get(randomKey);
			
			wantPrivate.put(value.getID(), value);
			wantQuiet4.remove(value.getID() );
		}
		else if(wantStandard4.size() > 0)
		{//wantStandard2
			keys = new ArrayList<>(wantStandard4.keySet());
			String randomKey = keys.get( random.nextInt(keys.size()) );
			value = (Student) wantStandard4.get(randomKey);
			
			wantPrivate.put(value.getID(), value);
			wantStandard4.remove(value.getID() );
		}
		else
		{//no more students
			return false;
		}
		return true;
	}
    private void debug()
    {
		
		System.out.println("\nbradyHall\n----------------");
        System.out.println("currentStudents: " + currentStudents);
        System.out.println("queit4Roommates: " + quiet4Roommates.size());
        System.out.println("quiet2Roommates: " + quiet2Roommates.size());
        System.out.println("standard4Roommates: " + standard4Roommates.size());
        System.out.println("standard2Roommates: " + standard2Roommates.size());
        System.out.println("quietHomelessRoommates: " + quietHomelessRoommates.size());
        System.out.println("standardHomelessRoommates: " + standardHomelessRoommates.size());
        System.out.println("quietHomeless: " + quietHomeless.size());
        System.out.println("standardHomeless: " + standardHomeless.size());
        System.out.println("theRest: " + theRest.size());
        System.out.println("wantQuiet2: " + wantQuiet2.size());
        System.out.println("wantQuiet4: " + wantQuiet4.size());
        System.out.println("wantStandard2: " + wantStandard2.size());
        System.out.println("wantStandard4: " + wantStandard4.size());
        System.out.println("wantPrivate: " + wantPrivate.size());
//        System.out.println("BRADYHALL FINAL ROOMMATES");
        System.out.println("-------------------------");
        /*
        Set<Map.Entry<String, Student> > privateSet = wantPrivate.entrySet();
        for(Map.Entry<String, Student> i : privateSet)
        {
            Student temp = new Student();
            temp = (Student) i.getValue();
            System.out.println(temp.getWholeName() + " wants a private room");
        }
        
        //all for-loops are for troubleshooting purposes
        for(int i = 0; i < quiet4Roommates.size(); i++)
        {//quiet4Roommates
            Student first = new Student();
            Student second = new Student();
            
            first = quiet4Roommates.get(i).getFirst();
            second = quiet4Roommates.get(i).getSecond();
            System.out.println("Q4 --- " + first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        
        System.out.println();
        for(int i = 0; i < quiet2Roommates.size(); i++)
        {//quiet2Roommates
            Student first = new Student();
            Student second = new Student();
            
            first = quiet2Roommates.get(i).getFirst();
            second = quiet2Roommates.get(i).getSecond();
            System.out.println("Q2 --- " + first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        
        System.out.println();
        for(int i = 0; i < standard4Roommates.size(); i++)
        {//standard4Roommates
            Student first = new Student();
            Student second = new Student();
            
            first = standard4Roommates.get(i).getFirst();
            second = standard4Roommates.get(i).getSecond();
            System.out.println("S4 --- " + first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        
        System.out.println();
        for(int i = 0; i < standard2Roommates.size(); i++)
        {//standard2Roommates
            Student first = new Student();
            Student second = new Student();
            
            first = standard2Roommates.get(i).getFirst();
            second = standard2Roommates.get(i).getSecond();
            System.out.println("S2 --- " + first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        System.out.println();
        for(int i = 0; i < quietHomelessRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = quietHomelessRoommates.get(i).getFirst();
            second = quietHomelessRoommates.get(i).getSecond();
            System.out.println("QH --- " + first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        System.out.println();
        for(int i = 0; i < standardHomelessRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = standardHomelessRoommates.get(i).getFirst();
            second = standardHomelessRoommates.get(i).getSecond();
            System.out.println("SH --- " + first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        System.out.println();
*/
    }
}