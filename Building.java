import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Matt
 */
public class Building {
    
    static private HashMap<String, Student> homeless;
    
    Building()
    {
        homeless = new HashMap<>();
    }
    public ArrayList< Roommates > matchHomelessStudents(HashMap<String, Student> all)
    {
        ArrayList<Roommates> allRoommates = new ArrayList<>();
        
        while(all.size() > 1)
        {
            //System.out.println("top of while loop - all.size() == " + all.size() );
            Set<Map.Entry<String, Student> > allSet1 = all.entrySet();
            Set<Map.Entry<String, Student> > allSet2 = all.entrySet();
            Student first  = new Student();
            Student second = new Student();
            
            String roommateID = "";
            Roommates room = new Roommates();
            
            for(Entry<String, Student> i : allSet1)
            {
                Integer highestCompat = 0, currentCompat = 0;
                first = (Student) i.getValue();
                
            //System.out.println("first student " + first.getWholeName() + " " + first.getID() );
                for(Entry<String, Student> j : allSet2)
                {
                    second = (Student) j.getValue();
                    
            //System.out.println("second - " + second.getWholeName() + " " + second.getID() );
                    if(!first.getID().equals(second.getID() ) )
                    {//not the same student
                        currentCompat = first.getSimilarFactor(second);
                        if(currentCompat > highestCompat)
                        {
                            highestCompat = currentCompat;
                            roommateID = second.getID();
                        }
                    }
                }
                break;
            }
            //once here, you have first assigned to some student, 
            //and roommateID MAYBE assigned to the ID of the Student first will room with
            
            room.addFirst(first);
			if(!roommateID.equals("") )
			{
				second = (Student) all.get(roommateID);
			}
            room.addSecond(second);
            //add room to list of all roommates
            allRoommates.add(room);
            //remove both students from all
            all.remove(roommateID);
            all.remove(first.getID() );
        }
        if(all.size() == 1)
        {//one person left
            Set<Map.Entry<String, Student> > allSet1 = all.entrySet();
            Student temp = new Student();
            for(Entry<String, Student> i : allSet1)
            {//put into homeless to deal with later
                temp = (Student) i.getValue();
                homeless.put(temp.getID(), temp);
                all.remove(temp.getID() );
            }
        }
        return allRoommates;
    }
    public ArrayList< Roommates > matchStudents(HashMap<String, Student> all, String buildingName)
    {
        //System.out.println("--------------------");
//        System.out.println(all.size() + " students passed to matchStudents from " + buildingName);
        
        
        //while any number of students remain in all
        ArrayList<Roommates> allRoommates = new ArrayList<>();
        while(all.size() > 1)
        {
            //System.out.println("top of while loop - all.size() == " + all.size() );
            Set<Map.Entry<String, Student> > allSet1 = all.entrySet();
            Set<Map.Entry<String, Student> > allSet2 = all.entrySet();
            Student first = new Student();
            Student second = new Student();
            
            String roommateID = "";
            Roommates room = new Roommates();
            
            for(Entry<String, Student> i : allSet1)
            {
                Integer highestCompat = 0, currentCompat = 0;
                first = (Student) i.getValue();
                
                for(Entry<String, Student> j : allSet2)
                {
                    second = (Student) j.getValue();
                    
                    if(first.getID() != second.getID()
                            && first.isHardMatch(second) )
                    {//not the same student && is allowed to room together
                        currentCompat = first.getSimilarFactor(second);
                        if(currentCompat > highestCompat)
                        {
                            highestCompat = currentCompat;
                            roommateID = second.getID();
                        }
                    }
                }
                break;
            }
            //once here, you have first assigned to some student, 
            //and roommateID MAYBE assigned to the ID of the Student first will room with
            
            if(!roommateID.equals("") )
            {//we found a student to room with
                room.addFirst(first);
                second = (Student) all.get(roommateID);
                room.addSecond(second);
                //add room to list of all roommates
                allRoommates.add(room);
                //remove both students from all
                all.remove(roommateID);
                all.remove(first.getID() );
            }
            else
            {//we did not find a student to room with
                //System.out.println("adding " + first.getWholeName() + " to homeless AL");
                homeless.put(first.getID(), first);
                //System.out.println("all.size() before " + all.size() );
                all.remove(first.getID() );
                //System.out.println("all.size() after homeless addition " + all.size() );
            }
        }
        if(all.size() == 1)
        {//one person left
            Set<Map.Entry<String, Student> > allSet1 = all.entrySet();
            Student temp = new Student();
            for(Entry<String, Student> i : allSet1)
            {//put into homeless to deal with later
                temp = (Student) i.getValue();
                homeless.put(temp.getID(), temp);
                all.remove(temp.getID() );
            }
        }
        return allRoommates;
    }//end of matchStudents()
    public void addToHomeless(Student s)
    {
        homeless.put(s.getID(), s);
    }
    static public HashMap< String, Student > getHomeless()
    {
        //System.out.println("getHomeless called, size = " + homeless.size() );
        HashMap<String, Student> copy = new HashMap<>();
        Set<Map.Entry<String, Student> > homelessSet = homeless.entrySet();
        
        for(Entry<String, Student> i : homelessSet)
        {//put all from homeless HM into copy HM
            Student temp = new Student();
            temp = (Student) i.getValue();
            copy.put(temp.getID(), temp);
        }
        
        clearHomeless();//empty homeless HM
        
        //System.out.println("copy size = " + copy.size() );
        //System.out.println("copy size after = " + copy.size() );
        
        return copy;
    }
    static private void clearHomeless()
    {//systematically removes all students from homeless HM 
     //without ruining the references to those students
        while(homeless.size() > 0)
        {//remove first element until empty
            Student temp = new Student();
            Set<Map.Entry<String, Student> > homelessSet = homeless.entrySet();
            for(Entry<String, Student> i : homelessSet)
            {
                temp = (Student) i.getValue();
                break;
            }
            
            homeless.remove(temp.getID() );
        }
    }
}
