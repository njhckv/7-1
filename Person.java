public class Person implements PersonType, Comparable
{
    protected char m_personType;
    protected int m_ID;
    protected String firstName;
    protected String m_lastName;
    protected OrderBy m_sortOrder;
    
    public Person()
    {
       this.m_personType = PersonType.PERSON;
       this.m_sortOrder = OrderBy.LAST_NAME;
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
    
    @Override
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
                    return (int)(cp.m_personType - this.m_personType);

                case ID:
                    return cp.m_ID - this.m_ID;

                case FIRST_NAME:
                    if ((cp.firstName != null) && (this.firstName != null))
                        return (cp.firstName).compareTo(this.firstName);
                    else
                        return -1;

                case LAST_NAME:
                    if ((cp.m_lastName != null) && (this.m_lastName != null))
                        return (cp.m_lastName).compareTo(this.m_lastName);
                    else
                        return -1;

                default:
                    return -1;
            }   
        }
        else
        {
            return -1;
        }
    }
    
    public void setInfo(String info)
    {
       //for Assignment07-02 
    }
        
}
