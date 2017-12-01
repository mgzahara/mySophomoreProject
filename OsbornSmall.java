import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
public class OsbornSmall extends Building{
    private Integer totalRooms, maxStudents, currentStudents, num;
    //keys for descriptions must match indecies for rommates 
    private ArrayList< Roommates > 
            roommates, homelessRoommates; 
    private HashMap< Integer, Boolean >
            available;
    private ArrayList< String >
            outputStrings;
    private HashMap< Integer, String > 
            descriptions; 
    private HashMap< String, Student > 
            homeless, students, theRest;
    
    public OsbornSmall()
    {//constructor
        super();
        descriptions = new HashMap<>();
        students     = new HashMap<>();
        homeless     = new HashMap<>();
        theRest      = new HashMap<>();
        available    = new HashMap<>();
        
        roommates         = new ArrayList<>();
        outputStrings     = new ArrayList<>();
        homelessRoommates = new ArrayList<>();
        
        
        totalRooms      = 0;
        currentStudents = 0;
		num             = 0;
        maxStudents     = 58;
        
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
		
        descriptions.put(0, "Small Side - 171 | quiet"); totalRooms++;
        descriptions.put(1, "Small Side - 172 | quiet"); totalRooms++;
        descriptions.put(2, "Small Side - 173 | quiet"); totalRooms++;
        descriptions.put(3, "Small Side - 174 | quiet"); totalRooms++;
        descriptions.put(4, "Small Side - 175 | quiet"); totalRooms++;
        descriptions.put(5, "Small Side - 181 | quiet"); totalRooms++;
        descriptions.put(6, "Small Side - 182 | quiet"); totalRooms++;
        descriptions.put(7, "Small Side - 183 | quiet"); totalRooms++;
        descriptions.put(8, "Small Side - 184 | quiet"); totalRooms++;
        descriptions.put(9, "Small Side - 185 | quiet"); totalRooms++;
        descriptions.put(10, "Small Side - 272 | quiet"); totalRooms++;
        descriptions.put(11, "Small Side - 273 | quiet"); totalRooms++;
        descriptions.put(12, "Small Side - 274 | quiet"); totalRooms++;
        descriptions.put(13, "Small Side - 275 | quiet"); totalRooms++;
        descriptions.put(14, "Small Side - 281 | quiet"); totalRooms++;
        descriptions.put(15, "Small Side - 282 | quiet"); totalRooms++;
        descriptions.put(16, "Small Side - 283 | quiet"); totalRooms++;
        descriptions.put(17, "Small Side - 284 | quiet"); totalRooms++;
        descriptions.put(18, "Small Side - 285 | quiet"); totalRooms++;
        descriptions.put(19, "Small Side - 371 | quiet"); totalRooms++;
        descriptions.put(20, "Small Side - 372 | quiet"); totalRooms++;
        descriptions.put(21, "Small Side - 373 | quiet"); totalRooms++;
        descriptions.put(22, "Small Side - 374 | quiet"); totalRooms++;
        descriptions.put(23, "Small Side - 375 | quiet"); totalRooms++;
        descriptions.put(24, "Small Side - 381 | quiet"); totalRooms++;
        descriptions.put(25, "Small Side - 382 | quiet"); totalRooms++;
        descriptions.put(26, "Small Side - 383 | quiet"); totalRooms++;
        descriptions.put(27, "Small Side - 384 | quiet"); totalRooms++;
        descriptions.put(28, "Small Side - 385 | quiet"); totalRooms++; 
    }
    private boolean canLiveHere(Student student)
    {
        if(student.getGender().equals("Male") )
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
    {
        if(r.getGender().equals("Male") )
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
        {
            students.put(student.getID(), student);
            currentStudents++;
            return true; 
        }
        else
        {
            return false;
        }
    }
    public void match() throws FileNotFoundException
    {
        roommates = matchStudents(students, "Osborn Hall, Small Side");
        homeless = getHomeless();
        
        homelessRoommates = matchHomelessStudents(homeless);
        theRest = getHomeless();
        if(!theRest.isEmpty())
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
                homelessRoommates.add(room);
            }
            else
            {//theRest.size() == 2
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
                            homelessRoommates.add(room);
                            done = true;
                        }
                    }
                }
            }
        }
        //add all from homelessRoommates to roommates
        while(!homelessRoommates.isEmpty() )
        {
            roommates.add(homelessRoommates.get(0));
            homelessRoommates.remove(0);
        }
        
        assignRooms();
        output();
//        debug();

        System.out.println("currentStudents: " + currentStudents);
    }
	private void output()
	{
		//sort output 
		Collections.sort(outputStrings);
		try (PrintStream out = new PrintStream(
                new FileOutputStream("osbornSmallOut.csv"))) 
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
            System.out.println("\ninside catch clause of osbornSmallOut\n");
        }
	}
    public boolean addRoommates(Roommates r)
    {
        if(canLiveHere(r) )
        {
            roommates.add(r);
            return true;
        }
        else
        {
            return false;
        }
    }
	public void clear()
	{
		students.clear();
        homeless.clear();
        theRest.clear();
        roommates.clear();
        outputStrings.clear();
        homelessRoommates.clear();
		
		for(int i = 0; i < totalRooms; i++)
		{//reset to true
			available.put(i, true);
		}
		
        currentStudents = 0;
		num             = 0;
	}
    private void assignRooms()
    {
//        System.out.println("\nosbornSmall\n----------------");
//        System.out.println("roommates: " + roommates.size());
//        System.out.println("homelessRoommates: " + homelessRoommates.size());
        
		while(!roommates.isEmpty() )
		{
			String line = "";
            Roommates r = new Roommates();
            Student s1  = new Student();
            Student s2  = new Student();
            
            line = line + descriptions.get(num) + "\n";
            line = line + roommates.get(0).getFirst().getFinalOutput() + "\n";
            line = line + roommates.get(0).getSecond().getFinalOutput() + "\n";
            
            outputStrings.add(num, line);
			available.put(num, false);
			num++;
			roommates.remove(0);
		}
        /*
        for(int i = 0; i < roommates.size(); i++)
        {
            String line = "";
            Roommates r = new Roommates();
            Student s1  = new Student();
            Student s2  = new Student();
            
            r = roommates.get(i);
            s1 = r.getFirst();
            s2 = r.getSecond();
            
            line = line + descriptions.get(i) + "\n";
            line = line + s1.getFinalOutput() + "\n";
            line = line + s2.getFinalOutput() + "\n";
            
            outputStrings.add(i, line);
			available.put(i, false);
            //roomAvailablility.set(i, false);
        }
		
        System.out.println("Osborn Small Assigned Rooms");
        for(int j = 0; j < outputStrings.size(); j++)
        {
            System.out.println(j + ":");
            System.out.println(outputStrings.get(j) );
            System.out.println();
        }
        System.out.println("Osborn Small Unassigned Rooms");
        for(int j = 0; j < available.size(); j++)
        {
			if(available.get(j) )
			{
				System.out.println(descriptions.get(j) );
			}
        }
*/
		
		
//        System.out.println("osbornSmall end of roomAssignment");
//        System.out.println("roommates.size(): " + roommates.size());

    }
    private void debug()
    {
		System.out.println("\nosbornSmall\n----------------");
		
        System.out.println("currentStudents: " + currentStudents);
        System.out.println("homeless: " + homeless.size());
        System.out.println("students: " + students.size());
        System.out.println("theRest: " + theRest.size());
        System.out.println("roommates: " + roommates.size());
        System.out.println("homelessRoommates: " + homelessRoommates.size());
		
//        System.out.println("OSBORN SMALL SIDE MATCHES");
        System.out.println("-------------------------");
		/*
        for(int i = 0; i < roommates.size(); i++)
        {
            Student first = new Student();
            Student second = new Student();
            
            first = roommates.get(i).getFirst();
            second = roommates.get(i).getSecond();
//            System.out.println(first.getWholeName() + " is rooming with \n\t" + second.getWholeName());
        }
*/
    }
}
