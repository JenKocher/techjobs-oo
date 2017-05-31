package org.launchcode.models;

/**
 * Created by LaunchCode
 */

/**
 * Notes to self from assignment instructions:
 *
 * This class is an enum.
 *
 * It enables the view and controller layers to seek out data (rendering search and list options
 * for the former, and collecting these options for the latter) related to a specific field,
 * or all fields, of a Job instance.
 *
 * Also, many of JobData's methods now work by taking in a JobFieldType parameter instead of a string.
 *
 * Examples:
 *
 * Where previously we would find all Employers this way:
 *     ArrayList<string> employers = JobData.findByColumnAndValue("employer", "aSearchTerm");
 * Now we do this:
 *     ArrayList<JobField> employers = JobData.findByColumnAndValue(JobFieldType.EMPLOYER, "aSearchTerm");
 *
 * Where previously we would find all Locations this way:
 *     ArrayList<string> locations = JobData.findByColumnAndValue("employer", "aSearchTerm");
 * Now we do this:
 *     ArrayList<JobField> locations = JobData.findByColumnAndValue(JobFieldType.LOCATION, "aSearchTerm");
 *
 * Where previously we would find all PositionTypes this way:
 *     ArrayList<string> positionTypes = JobData.findByColumnAndValue("positionType", "aSearchTerm");
 * Now we do this:
 *     ArrayList<JobField> positionTypes = JobData.findByColumnAndValue(JobFieldType.POSITION_TYPE, "aSearchTerm");
 *
 * Where previously we would find all coreCompetencies this way:
 *     ArrayList<string> coreCompetencies = JobData.findByColumnAndValue("coreCompetency", "aSearchTerm");
 * Now we do this:
 *     ArrayList<JobField> coreCompetencies = JobData.findByColumnAndValue(JobFieldType.CORE_COMPETENCY, "aSearchTerm");
 *
 */



public enum JobFieldType {

    EMPLOYER ("Employer"),
    LOCATION ("Location"),
    CORE_COMPETENCY ("Skill"),
    POSITION_TYPE ("Position Type"),
    ALL ("All");

    private final String name;

    JobFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
