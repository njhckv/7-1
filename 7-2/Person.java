public class Person implements PersonType, Comparable
{
    protected char m_personType;
    protected int m_ID;
    protected String firstName;
    protected String m_lastName;
    protected OrderBy m_sortOrder;
    
    public Person()
    {
       m_personType = PersonType.PERSON;
       m_ID = 0;
       firstName = m_lastName = null;
       m_sortOrder = OrderBy.LAST_NAME;
       
    }
    
    public Person(char type, int ID, String firstName, String lastName)
    {
        m_personType = type;
        m_ID = ID;
        this.firstName = firstName;
        m_lastName = lastName;
        m_sortOrder = OrderBy.LAST_NAME;
    }
    
    public char getType()
    {
        return m_personType;
        
    }
    
    public int getID()
    {
        return m_ID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return m_lastName;
    }
    
    public void setOrderBy(OrderBy order)
    {
        m_sortOrder = order;
    }
    
    @Override
    public String toString()
    {
        return (m_personType + "\t" + m_ID + "\t" + firstName + "\t" + m_lastName);
    }
    
    public boolean equals(Object o)
    {
        if (o instanceof Person)
        {
            Person cp = (Person)o;
            return ((cp.m_personType == this.m_personType) && (cp.m_ID == this.m_ID) && (cp.firstName == this.firstName) && (cp.m_lastName == this.m_lastName));
        }
        else
        {
            return false;
        }
        
    }

    @Override
    public int compareTo(Object o) 
    {
        if(o instanceof Person)
        {
            Person cp = (Person)o;
            switch(m_sortOrder)
            {
                case TYPE:
                    return (int)(this.m_personType - cp.m_personType);

                case ID:
                    return this.m_ID - cp.m_ID;

                case FIRST_NAME:
                    if ((cp.firstName != null) && (this.firstName != null))
                        return (this.firstName).compareTo(cp.firstName);
                    else
                        System.out.println("There is null string");
                        return -1;

                case LAST_NAME:
                    if ((cp.m_lastName != null) && (this.m_lastName != null))
                        return (this.m_lastName).compareTo(cp.m_lastName);
                    else
                        System.out.println("There is null string");
                        return -1;

                default:
                    System.out.println("The way to order is not in OrderBy");
                    return -1;
            }   
        }
        else
        {
            System.out.println("The object is not a Person");
            return -1;
        }
    }
    

        
    

}
