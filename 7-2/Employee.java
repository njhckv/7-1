import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee extends Person implements FileIO
{
    private String m_department = "";
    
    public Employee()
    {
        super();
        m_personType = PersonType.EMPLOYEE;

    }
    
    public Employee(int ID, String firstName, String lastName, String department)
    {
        super(PersonType.EMPLOYEE, ID, firstName, lastName);
        m_department = department;
        
    }


    @Override
    public String toString()
    {
        return (m_personType + "\t" + m_ID + "\t" + firstName + "\t" + m_lastName + "\t" + m_department);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Employee)
        {
            Employee ee = (Employee)o;
            return ((ee.m_personType == this.m_personType) 
                    && (ee.m_ID == this.m_ID) 
                    && (ee.firstName == this.firstName) 
                    && (ee.m_lastName == this.m_lastName)
                    && (ee.getDepartment() == this.m_department));
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public int compareTo(Object o)
    {
        if(o instanceof Employee)
        {
            Employee ce = (Employee)o;
            switch(m_sortOrder)
            {
                case DEPARTMENT:
                    if ((ce.m_department != null) && (this.m_department != null))
                        return (this.m_department).compareTo(ce.m_department);
                    else
                        System.out.println("There is null string");
                        return -1;
                            
                default:
                    return super.compareTo(ce);
            }   
        }
        else
        {
            System.out.println("The object in parenthesis is not an Employee");
            return -1;
        }
        
    }
    
    public void setInfo(String info)
    {
        String[] arr = info.split("\t");
        m_personType = arr[0].charAt(0);
        m_ID = Integer.parseInt(arr[1]);
        firstName = arr[2];
        m_lastName = arr[3];
        m_department = arr[4];
    }

    
    public String getDepartment()
    {
        return m_department;
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
        Employee a = new Employee(1, "Huanzhou", "Wang", "Product");
        Employee b = new Employee();
        System.out.println(a.equals(b));
        
        try {
            a.saveFile("test2.txt");
            a.loadFile("test2.txt");
            System.out.println(a);
        }
        
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
