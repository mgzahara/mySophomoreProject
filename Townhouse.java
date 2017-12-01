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
public class Townhouse extends Building{
    private Integer maxStudents, totalRooms;
    private Integer currentStudents, currentMales, currentFemales,
			num;
    //keys for descriptions must match indecies for rommates
    private HashMap<Integer, String> 
            descriptions;  
    private ArrayList< Roommates > 
            maleRoommates, femaleRoommates,
            mhRoommates, fhRoommates;
	private ArrayList< String >
			outputStrings;
    private HashMap<String, Student> 
            males, females, 
            maleHomeless, femaleHomeless,
            theRestMales, theRestFemales;
	private HashMap< Integer, Boolean >
			available;
    
    public Townhouse()
    {
        super();
        descriptions   = new HashMap<>();
        males          = new HashMap<>();
        females        = new HashMap<>();
        maleHomeless   = new HashMap<>();
        femaleHomeless = new HashMap<>();
        theRestMales   = new HashMap<>();
        theRestFemales = new HashMap<>();
		available      = new HashMap<>();
        
        maleRoommates   = new ArrayList<>();
        femaleRoommates = new ArrayList<>();
        mhRoommates     = new ArrayList<>();
        fhRoommates     = new ArrayList<>();
		outputStrings   = new ArrayList<>();
        
        maxStudents     = 112; 
        totalRooms      = 0;
        currentStudents = 0; 
        currentMales    = 0;
        currentFemales  = 0;
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
		
        descriptions.put(0, "Townhouses - 901F | ");totalRooms++;
        descriptions.put(1, "Townhouses - 902F | ");totalRooms++;
        descriptions.put(2, "Townhouses - 903F | ");totalRooms++;
        descriptions.put(3, "Townhouses - 904F | ");totalRooms++;
        descriptions.put(4, "Townhouses - 905F | ");totalRooms++;
        descriptions.put(5, "Townhouses - 906F | ");totalRooms++;
        descriptions.put(6, "Townhouses - 907F | ");totalRooms++;
        descriptions.put(7, "Townhouses - 908F | ");totalRooms++;
        descriptions.put(8, "Townhouses - 909F | ");totalRooms++;
        descriptions.put(9, "Townhouses - 910F | ");totalRooms++;
        descriptions.put(10, "Townhouses - 912F | ");totalRooms++;
        descriptions.put(11, "Townhouses - 913F | ");totalRooms++;
        descriptions.put(12, "Townhouses - 914F | ");totalRooms++;
        descriptions.put(13, "Townhouses - 915F | ");totalRooms++;
        descriptions.put(14, "Townhouses - 917F | ");totalRooms++;
        descriptions.put(15, "Townhouses - 918F | ");totalRooms++;
        descriptions.put(16, "Townhouses - 919F | ");totalRooms++;
        descriptions.put(17, "Townhouses - 920F | ");totalRooms++;
        descriptions.put(18, "Townhouses - 922F | ");totalRooms++;
        descriptions.put(19, "Townhouses - 924F | ");totalRooms++;
        descriptions.put(20, "Townhouses - 926F | ");totalRooms++;
        descriptions.put(21, "Townhouses - 930F | ");totalRooms++;
        descriptions.put(22, "Townhouses - 932F | ");totalRooms++;
        descriptions.put(23, "Townhouses - 934F | ");totalRooms++;
        descriptions.put(24, "Townhouses - 936F | ");totalRooms++;
        descriptions.put(25, "Townhouses - 938F | ");totalRooms++;
        descriptions.put(26, "Townhouses - 940F | ");totalRooms++;
        
        descriptions.put(27, "Townhouses - 901B | ");totalRooms++;
        descriptions.put(28, "Townhouses - 902B | ");totalRooms++;
        descriptions.put(29, "Townhouses - 903B | ");totalRooms++;
        descriptions.put(30, "Townhouses - 904B | ");totalRooms++;
        descriptions.put(31, "Townhouses - 905B | ");totalRooms++;
        descriptions.put(32, "Townhouses - 906B | ");totalRooms++;
        descriptions.put(33, "Townhouses - 907B | ");totalRooms++;
        descriptions.put(34, "Townhouses - 908B | ");totalRooms++;
        descriptions.put(35, "Townhouses - 909B | ");totalRooms++;
        descriptions.put(36, "Townhouses - 910B | ");totalRooms++;
        descriptions.put(37, "Townhouses - 912B | ");totalRooms++;
        descriptions.put(38, "Townhouses - 913B | ");totalRooms++;
        descriptions.put(39, "Townhouses - 914B | ");totalRooms++;
        descriptions.put(40, "Townhouses - 915B | ");totalRooms++;
        descriptions.put(41, "Townhouses - 917B | ");totalRooms++;
        descriptions.put(42, "Townhouses - 918B | ");totalRooms++;
        descriptions.put(43, "Townhouses - 919B | ");totalRooms++;
        descriptions.put(44, "Townhouses - 920B | ");totalRooms++;
        descriptions.put(45, "Townhouses - 922B | ");totalRooms++;
        descriptions.put(46, "Townhouses - 924B | ");totalRooms++;
        descriptions.put(47, "Townhouses - 926B | ");totalRooms++;
        descriptions.put(48, "Townhouses - 930B | ");totalRooms++;
        descriptions.put(49, "Townhouses - 932B | ");totalRooms++;
        descriptions.put(50, "Townhouses - 934B | ");totalRooms++;
        descriptions.put(51, "Townhouses - 936B | ");totalRooms++;
        descriptions.put(52, "Townhouses - 938B | ");totalRooms++;
        descriptions.put(53, "Townhouses - 940B | ");totalRooms++;
        descriptions.put(54, "Townhouses - 911B | ");totalRooms++;
        descriptions.put(55, "Townhouses - 928B | ");totalRooms++;
    }
    private boolean canLiveHere(Student student)
    {
        if(currentStudents >= maxStudents)
        {
            return false;
        }
        if(student.getGradYearDelta() < 2)
        {
            return false;
        }
        if(currentStudents == (maxStudents - 1) )
        {//only one more student slot left
            switch(student.getGender())
            {//get the right gender
				case "Male":
					if(currentMales % 2 == 0)
					{//we have an even amount of males
						return false;
					}
					else
					{
						return true;
					}
				case "Female":
					if(currentFemales % 2 == 0)
					{//we have an even amount of males
						return false;
					}
					else
					{
						return true;
					}
                default:break;
            }
        }
        return true;
    }
    private boolean canLiveHere(Roommates r)
    {
        if(currentStudents >= maxStudents - 1)
        {
            return false;
        }
        if(r.getGradYearDelta() < 2)
        {
            return false;
        }
        return true;
    }
    public boolean putInto(Student student)
    {
        if(canLiveHere(student) )
        {
            if(student.getFirstRoomPreference() == 14)
            {
                if(student.getGender().equals("Male") )
                {
                    currentStudents++;
                    currentMales++;
                    males.put(student.getID(), student);
                    return true;
                }
                else
                {//female
                    currentStudents++;
                    currentFemales++;
                    females.put(student.getID(), student);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean addRoommates(Roommates r)
    {
        if(canLiveHere(r) )
        {
            if(r.getGender().equals("Male") )
            {
                maleRoommates.add(r);
                currentStudents = currentStudents + 2;
                return true;
            }
            else
            {//females
                femaleRoommates.add(r);
                currentStudents = currentStudents + 2;
                return true;
            }
        }
        else
        {
            return false;
        }
    }
    public void match()
    {
        //match males
        maleRoommates = matchStudents(males, "Neveu Apartments");
        maleHomeless = getHomeless();
        mhRoommates = matchHomelessStudents(maleHomeless);
        theRestMales = getHomeless();
        
        if(!theRestMales.isEmpty() )
        {
            Student it = new Student();
            Roommates room = new Roommates();
            Set<Map.Entry<String, Student> > theRestMalesSet = theRestMales.entrySet();
            for(Map.Entry<String, Student> i : theRestMalesSet)
            {
                it = (Student) i.getValue();
            }
            room.addFirst(it);
            mhRoommates.add(room);
        }
        
        //match females
        femaleRoommates = matchStudents(females, "Neveu Apartments");
        femaleHomeless = getHomeless();
        fhRoommates = matchHomelessStudents(femaleHomeless);
        theRestFemales = getHomeless();
        
        if(!theRestFemales.isEmpty() )
        {
            Student it = new Student();
            Roommates room = new Roommates();
            Set<Map.Entry<String, Student> > theRestMalesSet = theRestFemales.entrySet();
            for(Map.Entry<String, Student> i : theRestMalesSet)
            {
                it = (Student) i.getValue();
            }
            room.addFirst(it);
            fhRoommates.add(room);
        }
        
        //integrate homeless matches in with regular matches
        while(!mhRoommates.isEmpty() )
        {
            maleRoommates.add(mhRoommates.get(0) );
            mhRoommates.remove(0);
        }
        while(!fhRoommates.isEmpty() )
        {
            femaleRoommates.add(fhRoommates.get(0) );
            fhRoommates.remove(0);
        }
        
        assignRooms();
		output();
//        debug();

//        System.out.println("currentStudents: " + currentStudents);
    }
	public void clear()
	{
		males.clear();
        females.clear();
        maleHomeless.clear();
        femaleHomeless.clear();
        theRestMales.clear();
        theRestFemales.clear();
        
        maleRoommates.clear();
        femaleRoommates.clear();
        mhRoommates.clear();
        fhRoommates.clear();
		outputStrings.clear();
        
		for(int i = 0; i < totalRooms; i++)
		{//reset to true
			available.put(i, true);
		}
		
        currentStudents = 0; 
        currentMales    = 0;
        currentFemales  = 0;
		num             = 0;
	}
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("townhouseOut.csv"))) 
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
            System.out.println("\ninside catch clause of townhouseOut\n");
        }
	}
	private void assignRooms()
	{
		while(!maleRoommates.isEmpty() )
		{
			String s = descriptions.get(num) + "\n";
			s = s + maleRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + maleRoommates.get(0).getSecond().getFinalOutput() + "\n";
			outputStrings.add(s);
			available.put(num, false);
			maleRoommates.remove(0);
			num++;
		}
		while(!femaleRoommates.isEmpty() )
		{
			String s = descriptions.get(num) + "\n";
			s = s + femaleRoommates.get(0).getFirst().getFinalOutput() + "\n";
			s = s + femaleRoommates.get(0).getSecond().getFinalOutput() + "\n";
			outputStrings.add(s);
			available.put(num, false);
			femaleRoommates.remove(0);
			num++;
		}
		
		/*
		System.out.println("\ntownhouse occupied rooms");
		for(int i = 0; i < outputStrings.size(); i++)
		{
			System.out.println(outputStrings.get(i) );
		}
		System.out.println("\ntownhouse Unoccupied rooms");
		for(int i = 0; i < available.size(); i++)
		{
			if(available.get(i) )
			{
				System.out.println(descriptions.get(i) );
			}
		}
*/
		
		
//        System.out.println("townhouse end of roomAssignment");
//        System.out.println("maleRoommates: " + maleRoommates.size());
//        System.out.println("femaleRoommates: " + femaleRoommates.size());


	}
    private void debug()
    {
		System.out.println("\ntownhouse\n----------------");
        System.out.println("currentStudents: " + currentStudents);
        System.out.println("maleRoommates: " + maleRoommates.size());
        System.out.println("femaleRoommates: " + femaleRoommates.size());
        System.out.println("mhRoommates: " + mhRoommates.size());
        System.out.println("fhRoommates: " + fhRoommates.size());
        System.out.println("males: " + males.size());
        System.out.println("females: " + females.size());
        System.out.println("maleHomeless: " + maleHomeless.size());
        System.out.println("femaleHomeless: " + femaleHomeless.size());
        System.out.println("theRestMales: " + theRestMales.size());
        System.out.println("theRestFemales: " + theRestFemales.size());
//        System.out.println("TOWNHOUSE MATCHES");
        System.out.println("-------------------");
		
		/*
        for(int i = 0; i < maleRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = maleRoommates.get(i).getFirst();
            second = maleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with " + second.getWholeName());
        }
        for(int i = 0; i < femaleRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = femaleRoommates.get(i).getFirst();
            second = femaleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with " + second.getWholeName());
        }
*/
    }
}
