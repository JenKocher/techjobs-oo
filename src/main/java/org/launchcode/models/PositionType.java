package org.launchcode.models;

/**
 * Created by LaunchCode
 */

/**
 * Notes to self from assignment instructions:
 *
 * If you have a Job instance:
 *
 * you get the name of the PositionType like this:
 * String employerName = job.getPositionType().getValue()
 *
 * You get the name of the job like this:
 * String jobName = job.getName()
 *
 * Note that whenever you access an Object (not being a String) in a String context,
 * the compiler calls the toString() method under the covers.
 *
 * Therefore, if you override the standard toString() from Object in your own
 * classes, you can make your Objects (not being a String) useful in a String context.
 *
 * Examples of String contexts are templates and printing.
 *
 * As an example, this will work, because the Project's
 * overridden toString() method returns the field's value:
 *
 * System.out.println(job.getPositionType());
 *
 */

public class PositionType extends JobField {

    public PositionType(String value) {
        super(value);
    }

}
