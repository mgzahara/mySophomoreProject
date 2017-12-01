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
public class Neveu extends Building{
    private Integer maxStudents, totalRooms; 
    private Integer currentMales, currentFemales, currentStudents,
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
    
    public Neveu()
    {
        super();
        descriptions   = new HashMap<>();
        males          = new HashMap<>();
        females        = new HashMap<>();
        maleHomeless   = new HashMap<>();
        femaleHomeless = new HashMap<>();
        theRestMales   = new HashMap<>();
		available      = new HashMap<>();
        theRestFemales = new HashMap<>();
        
        maleRoommates   = new ArrayList<>();
        femaleRoommates = new ArrayList<>();
        mhRoommates     = new ArrayList<>();
        fhRoommates     = new ArrayList<>();
		outputStrings   = new ArrayList<>();
        
        maxStudents     = 38;
        currentMales    = 0;
        currentFemales  = 0;
        currentStudents = 0;
		num             = 0;
        totalRooms      = 0;
        
        
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
		
        descriptions.put(0, "Neveu Hall - 111 | quiet");totalRooms++;
        descriptions.put(1, "Neveu Hall - 112 | quiet");totalRooms++;
        descriptions.put(2, "Neveu Hall - 114 | quiet");totalRooms++;
        descriptions.put(3, "Neveu Hall - 115 | quiet");totalRooms++;
        descriptions.put(4, "Neveu Hall - 116 | quiet");totalRooms++;
        descriptions.put(5, "Neveu Hall - 117 | quiet");totalRooms++;
        descriptions.put(6, "Neveu Hall - 118 | quiet");totalRooms++;
        descriptions.put(7, "Neveu Hall - 119 | quiet");totalRooms++;
        descriptions.put(8, "Neveu Hall - 120 | quiet");totalRooms++;
        descriptions.put(9, "Neveu Hall - 221 | quiet");totalRooms++;
        descriptions.put(10, "Neveu Hall - 222 | quiet");totalRooms++;
        descriptions.put(11, "Neveu Hall - 223 | quiet");totalRooms++;
        descriptions.put(12, "Neveu Hall - 224 | quiet");totalRooms++;
        descriptions.put(13, "Neveu Hall - 225 | quiet");totalRooms++;
        descriptions.put(14, "Neveu Hall - 226 | quiet");totalRooms++;
        descriptions.put(15, "Neveu Hall - 227 | quiet");totalRooms++;
        descriptions.put(16, "Neveu Hall - 228 | quiet");totalRooms++;
        descriptions.put(17, "Neveu Hall - 229 | quiet");totalRooms++;
        descriptions.put(18, "Neveu Hall - 230 | quiet");totalRooms++;
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
            switch(currentMales%2)
            {//get the right gender
                case 0: return !student.getGender().equals("Male");
                case 1: return student.getGender().equals("Male");
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
            if(student.getFirstRoomPreference() == 18)
            {
                if(student.getGender().equals("Male") )
                {
                    currentMales++;
                    currentStudents++;
                    males.put(student.getID(), student);
                    return true;
                }
                else
                {//female
                    currentFemales++;
                    currentStudents++;
                    females.put(student.getID(), student);
                    return true;
                }
            }
            else if(student.getSecondRoomPreference() == 18)
            {
                if(student.getGender().equals("Male") )
                {
                    currentMales++;
                    currentStudents++;
                    males.put(student.getID(), student);
                    return true;
                }
                else
                {//female
                    currentFemales++;
                    currentStudents++;
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
		
        currentMales    = 0;
        currentFemales  = 0;
        currentStudents = 0;
		num             = 0;
	}
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("neveuOut.csv"))) 
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
            System.out.println("\ninside catch clause of neveuOut\n");
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
		System.out.println("\nneveu occupied rooms");
		for(int i = 0; i < outputStrings.size(); i++)
		{
			System.out.println(outputStrings.get(i) );
		}
		System.out.println("\nneveu Unoccupied rooms");
		for(int i = 0; i < available.size(); i++)
		{
			if(available.get(i) )
			{
				System.out.println(descriptions.get(i) );
			}
		}
		*/
				
		
//        System.out.println("neveu end of roomAssignment");
//        System.out.println("maleRoommates: " + maleRoommates.size());
//        System.out.println("femaleRoommates: " + femaleRoommates.size());
	}
    private void debug()
    {
		
        System.out.println("\nneveu\n----------------");
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
        System.out.println("-------------------------");
		
		/*
        System.out.println("NEVEU MALE MATCHES");
        for(int i = 0; i < maleRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = maleRoommates.get(i).getFirst();
            second = maleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
        
        System.out.println("NEVEU FEMALE MATCHES");
        for(int i = 0; i < femaleRoommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = femaleRoommates.get(i).getFirst();
            second = femaleRoommates.get(i).getSecond();
            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
*/
    }
}
