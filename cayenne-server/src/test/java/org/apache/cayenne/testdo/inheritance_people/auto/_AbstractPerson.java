package org.apache.cayenne.testdo.inheritance_people.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.testdo.inheritance_people.PersonNotes;

/**
 * Class _AbstractPerson was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AbstractPerson extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String PERSON_ID_PK_COLUMN = "PERSON_ID";

    public static final Property<String> NAME = new Property<>("name");
    public static final Property<String> PERSON_TYPE = new Property<>("personType");
    public static final Property<List<PersonNotes>> NOTES = new Property<>("notes");

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setPersonType(String personType) {
        writeProperty("personType", personType);
    }
    public String getPersonType() {
        return (String)readProperty("personType");
    }

    public void addToNotes(PersonNotes obj) {
        addToManyTarget("notes", obj, true);
    }
    public void removeFromNotes(PersonNotes obj) {
        removeToManyTarget("notes", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<PersonNotes> getNotes() {
        return (List<PersonNotes>)readProperty("notes");
    }


}
