package org.launchcode.models.forms;

import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */

/**
 * Notes to self from assignment instructions:
 *
 * This class was established to create a model to be used during the job-creation process so that
 * the application could utilize the benefits of model binding and validation.
 *
 * The fields here represent the data that are necessary to create a job.
 *
 */

public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    /*
        TODO #3 - Include other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters
     */

    //  This is the beginning of where Jen added code.
    @NotNull
    private int locationId;

    @NotNull
    private int coreCompetencyId;

    @NotNull
    private int positionTypeId;
     //   This is the end of where Jen added code.

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        //This object contains all the data, plus it also contains
        //ArrayLists for the following objects: employers, locations, coreCompetencies, and
        //positionTypes

        //This is the data store
        JobData jobData = JobData.getInstance();

        //TODO #4 - populate the other ArrayList collections needed in the view
        employers = jobData.getEmployers().findAll();

        /* Jen's added code begins here. */
        locations = jobData.getLocations().findAll();
        coreCompetencies = jobData.getCoreCompetencies().findAll();
        positionTypes = jobData.getPositionTypes().findAll();
        /* Jen's added code ends here. */
    }
    public void setName(String name) {this.name = name;}
    public String getName() {
        return name;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }
    public int getEmployerId() {
        return employerId;
    }

    public void setLocationId(int aLocationId) {this.locationId = aLocationId;}
    public int getLocationId() {return locationId;}

    public void setCoreCompetencyId(int aCoreCompetencyId) {this.coreCompetencyId = aCoreCompetencyId;}
    public int getCoreCompetencyId(){return coreCompetencyId;}

    public void setPositionTypeId(int aPositionTypeId) {this.positionTypeId = aPositionTypeId;}
    public int getPositionTypeId(){return positionTypeId;}

    //Put setters before getters because you must set before you get.
    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }
    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;}
    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }
    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }
}
