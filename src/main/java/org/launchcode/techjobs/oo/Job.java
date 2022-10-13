package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer,
               Location location,
               PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id && Objects.equals(name, job.name) && Objects.equals(employer, job.employer) && Objects.equals(location, job.location) && Objects.equals(positionType, job.positionType) && Objects.equals(coreCompetency, job.coreCompetency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employer, location, positionType, coreCompetency);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String toString(Job job) {

        Field[] fields = job.getClass().getDeclaredFields();
        ArrayList<String> fieldsList = new ArrayList<>();
        String missingData = "Data not available";

        for (Field f : fields) {
            fieldsList.add(f.toString());
        }

        for (String c : fieldsList) {
            if (c.equals("")) {
                fieldsList.remove(c);
                fieldsList.add(missingData);
            }
        }

        /*
        for (Field f : fields) {
                if (f.toString().equals("")) {
                    fieldsList.add(missingData);
                } else {
                    fieldsList.add(f.toString());
                }
            }

         */

        String returnedJob = "\n" + "ID: " + fieldsList.get(0) + '\n' + "Name: " + fieldsList.get(2) + '\n' + "Employer: " + fieldsList.get(3) + '\n' + "Location: " + fieldsList.get(4) + '\n' + "Position Type: " + fieldsList.get(5) + '\n' + "Core Competency: " + fieldsList.get(6) + "\n";

        return returnedJob;
    }

}
