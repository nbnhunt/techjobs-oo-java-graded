package org.launchcode.techjobs.oo;

import java.lang.reflect.Array;
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

    @Override
    public String toString(){
        String output = "";
        if (name.equals("")){
            name = "Data not available";
        }
        if (employer.getValue().equals("") || employer.getValue() == null){
            employer.setValue("Data not available");
        }
        if (location.getValue().equals("") || location.getValue() == null){
            location.setValue("Data not available");
        }
        if (coreCompetency.getValue().equals("") || coreCompetency.getValue() == null){
            coreCompetency.setValue("Data not available");
        }
        if (positionType.getValue().equals("") || positionType.getValue() == null){
            positionType.setValue("Data not available");
        }

        output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency);
        return output;
    }
/*
    public String toString(Job job) {

        // Fine. I'll make a big loop.
        String[] fieldsList = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        // Job.getClass() cannot be referenced from a static context
        Field[] fields = Job.class.getDeclaredFields();
        String missingData = "Data not available";
        String returnedJob = "\n";
        int index = 0;

        // try->catch to review what is being submitted per field re: Ch 11.1 Exceptions...
        // exceptions are thrown if a program attempts to set a value not allowed by me
        // these are used to avoid runtime exceptions
        // make sure it's a JobField
        // return missing data if empty or null
        // return data if not empty
        // repeat the string returnedJob as needed per check
        for (Field f : fields) {
            if (f.getName() == "nextId") {
            } else {
                try {
                    if (f.get(this) instanceof JobField) {
                        if (((JobField) f.get(this)).getValue() == "") {
                            returnedJob = returnedJob + fieldsList[index] + missingData + "\n";
                        } else {
                            returnedJob = returnedJob + fieldsList[index] + f.get(this) + "\n";
                        }
                    } else if (f.get(this) == null || f.get(this) == "") {
                        returnedJob = returnedJob + fieldsList[index] + missingData + "\n";
                    } else {
                        returnedJob = returnedJob + fieldsList[index] + f.get(this) + "\n";
                    }
                    index++;
                } catch (Exception e) {
                    returnedJob = returnedJob + fieldsList[index] + missingData + "\n";
                    index++;
                }
            }
        }

        return returnedJob;

 */

        /*
        Field[] fields = job.getClass().getDeclaredFields();
        ArrayList<String> fieldsList = new ArrayList<>();
        String missingData = "Data not available";

        // instanceof?

        for (Field f : fields) {
                if (f.toString().equals("")) {
                    fieldsList.add(missingData);
                } else {
                    fieldsList.add(f.toString());
                }
            }

        String returnedJob = "\n" + "ID: " + fieldsList.get(0) + '\n' + "Name: " + fieldsList.get(2) + '\n' + "Employer: " + fieldsList.get(3) + '\n' + "Location: " + fieldsList.get(4) + '\n' + "Position Type: " + fieldsList.get(5) + '\n' + "Core Competency: " + fieldsList.get(6) + "\n";

        return returnedJob;

         */
    }


