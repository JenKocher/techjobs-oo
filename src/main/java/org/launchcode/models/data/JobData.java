package org.launchcode.models.data;

import javafx.geometry.Pos;
import org.launchcode.models.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  * Created by LaunchCode
 */

/**
 * Notes to self from assignment instructions:
 *
 * JobData has several instance methods.
 *
 * Note that each controller already has a JobData object set up; the name of the object is jobData.
 *
 * Here are the instance methods and how they are used:
 *
 * To find a job by its ID:
 *     findById(Int)
 *     returns Job
 *
 *     Example:
 *     Find the job with ID 42:
 *     Job someJob = jobData.findById(42);
 *
 * To find all jobs matching the given string in the given column/property:
 *     findByColumnAndValue(JobFieldType, String)
 *     returns ArrayList<Job>
 *
 *     Example:
 *     Find all jobs at Enterprise:
 *     ArrayList<Job> jobsAtEnterprise = jobData.findByColumnAndValue(JobFieldType.EMPLOYER , "Enterprise");
 *
 * To find all jobs matching the given field in any column/property:
 *     findByValue(String)
 *     returns ArrayList<Job>
 *
 *     Example:
 *
 *     Find all job listings where Ruby is mentioned anywhere:
 *     ArrayList<Job> jobsInvolvingRuby = jobData.findByValue("Ruby");
 *
 * Working with a list of Job objects:
 *  To get the full list of Jobs:
 *      ArrayList<Job> allOfTheJobs = jobData.findAll();
 *
 *  To add a new Job object to the list:
 *      jobData.add(newJob);
 *
 *  Also, collections of classes that make up the individual properties of a Job object --
 *  Employer, Location, CoreCompetency, PositionType -- are available as properties of JobData.
 *
 *  For example,
 *      All employers are contained in a property called Employers. (Text says "Employers" but I think it
 *          should be "employers").
 *      All locations are contained in a property called locations.
 *      All core competencies are contained in a property called coreCompetencies.
 *      All position types are contained in a property called positionTypes.
 *
 * Given the existence of these collections, two methods may be of use with each property. Here are examples:
 *
 *     Find the employer with ID 7:
 *         Employer anEmployer = jobData.getEmployers().findById(7);
 *     Get all employers:
 *         ArrayList<Employer> allEmployers = jobData.getEmployers().findAll();
 *
 *     Find the location with ID 7:
 *         Location aLocation = jobData.getLocations().findById(7);
 *     Get all employers:
 *         ArrayList<Location> allLocations = jobData.getLocations().findAll();
 *
 *    Find the core competency with ID 7:
 *         CoreCompetency aCoreCompetency = jobData.getCoreCompetencies().findById(7);
 *     Get all core competencies:
 *         ArrayList<CoreCompetency> allCoreCompetencies = jobData.getCoreCompetencies().findAll();
 *
 *    Find the position type with ID 7:
 *         PositionType aPositionType = jobData.getPositionTypes().findById(7);
 *     Get all position types:
 *         ArrayList<PositionType> allPositionTypes = jobData.getPositionTypes().findAll();
 *
 */

public class JobData {

    private ArrayList<Job> jobs = new ArrayList<>();
    private static JobData instance;

    private JobFieldData<Employer> employers = new JobFieldData<>();
    private JobFieldData<Location> locations = new JobFieldData<>();
    private JobFieldData<CoreCompetency> coreCompetencies = new JobFieldData<>();
    private JobFieldData<PositionType> positionTypes = new JobFieldData<>();


    private JobData() {
        JobDataImporter.loadData(this);
    }


    public static JobData getInstance() {
        if (instance == null) {
            instance = new JobData();
        }
        return instance;
    }

    public Job findById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id)
                return job;
        }

        return null;
    }

    public ArrayList<Job> findAll() {
        return jobs;
    }


    public ArrayList<Job> findByColumnAndValue(JobFieldType column, String value) {

        ArrayList<Job> matchingJobs = new ArrayList<>();

        for (Job job : jobs) {
            if (getFieldByType(job, column).contains(value))
                matchingJobs.add(job);
        }

        return matchingJobs;
    }


    public ArrayList<Job> findByValue(String value) {

        ArrayList<Job> matchingJobs = new ArrayList<>();

        for (Job job : jobs) {

            if (job.getName().toLowerCase().contains(value)) {
                matchingJobs.add(job);
                continue;
            }

            for (JobFieldType column : JobFieldType.values()) {
                if (column != JobFieldType.ALL && getFieldByType(job, column).contains(value)) {
                    matchingJobs.add(job);
                    break;
                }
            }
        }

        return matchingJobs;
    }


    public void add(Job job) {
        jobs.add(job);
    }


    private static JobField getFieldByType(Job job, JobFieldType type) {
        switch(type) {
            case EMPLOYER:
                return job.getEmployer();
            case LOCATION:
                return job.getLocation();
            case CORE_COMPETENCY:
                return job.getCoreCompetency();
            case POSITION_TYPE:
                return job.getPositionType();
        }

        throw new IllegalArgumentException("Cannot get field of type " + type);
    }

    public JobFieldData<Employer> getEmployers() {
        return employers;
    }

    public JobFieldData<Location> getLocations() {
        return locations;
    }

    public JobFieldData<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public JobFieldData<PositionType> getPositionTypes() {
        return positionTypes;
    }
}
