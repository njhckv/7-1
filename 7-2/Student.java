import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student extends Person implements FileIO
{
    private String m_major = "";
    
    public Student()
    {
        m_personType = PersonType.STUDENT;
        m_ID = 0;
        firstName = null;
        m_lastName = null;
        m_major = null;
    }
    
    public Student(int ID, String firstName, String lastName, String major)
    {
        m_personType = PersonType.STUDENT;
        m_ID = ID;
        this.firstName = firstName;
        m_lastName = lastName;
        m_major = major;
        
    }

    @Override
    public String toString()
    {
        return (m_personType + "\t" + m_ID + "\t" + firstName + "\t" + m_lastName + "\t" + m_major);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Student)
        {
            Student ss = (Student)o;
            return ((ss.m_personType == this.m_personType) 
                    && (ss.m_ID == this.m_ID) 
                    && (ss.firstName == this.firstName) 
                    && (ss.m_lastName == this.m_lastName)
                    && (ss.getMajor() == this.m_major));
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public int compareTo(Object o)
    {
        if(o instanceof Student)
        {
            Student ct = (Student)o;
            switch(m_sortOrder)
            {
                case MAJOR:
                    if ((ct.m_major != null) && (this.m_major != null))
                        return (this.m_major).compareTo(ct.m_major);
                    else
                        System.out.println("There is null string");
                        return -1;
                        
                default:
                    return super.compareTo(ct);
            }
                            
        }
        else
        {
            System.out.println("The object in parenthesis is not a Student");
            return -1;
        }
        
    }
    
    public void setInfo(String info)
    {
       String[] arr = info.split("\t");
        m_personType = arr[0].charAt(0);
        m_ID         = Integer.parseInt(arr[1]);
        firstName  = arr[2];
        m_lastName   = arr[3];
        m_major      = arr[4];
    }

    
    public String getMajor()
    {
        return m_major;
    }

    @Override
    public void saveFile(String a_fileName) 
            throws FileNotFoundException
    {
        java.io.File file = new java.io.File(a_fileName);
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        
        output.print(this.toString());
        output.close();
    }

    @Override
    public void loadFile(String a_fileName) 
            throws FileNotFoundException 
    {
        java.io.File file = new java.io.File(a_fileName);
        Scanner input = new Scanner(file);
        
        setInfo(input.nextLine());
    }
    
    public static void main(String[] arg)
    {
        Student a = new Student(108, "Huanzhou", "Wang", "Econ");
        Student b = new Student(108, "Huanzhou", "Zang", "Econ");
        System.out.println(a.equals(b));
        
        System.out.println(a.compareTo(b));
        
        
        try {
            a.saveFile("test.txt");
            a.loadFile("test.txt");
            System.out.println(a);
        }
        
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
