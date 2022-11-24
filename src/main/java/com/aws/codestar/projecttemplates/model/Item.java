package com.aws.codestar.projecttemplates.model;


public class Item {

    // Parameterized Constructor
    // to assign the values
    // to the properties of
    // the entity
    public Item(
            Integer id, String Name
    )
    {

        super();

        this.id = id;

        this.Name = Name;


    }

    private Integer id;

    private String Name;


    // Overriding the toString method
    // to find all the values
    @Override
    public String toString()
    {

        return "item [id="
                + id + ", Name="
                + Name + "]";


    }

    // Getters and setters of
    // the properties
    public Integer getId()
    {

        return id;
    }

    public void setId(Integer id)
    {

        this.id = id;
    }

    public String getName()
    {

        return Name;
    }

    public void setName(
            String Name)
    {

        this.Name = Name;
    }


}
