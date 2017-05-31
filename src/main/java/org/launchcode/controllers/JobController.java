package org.launchcode.controllers;

import org.launchcode.models.Job;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */

/**
 * Notes to self from assignment:
 *
 * Work in this controller to enable the creation of a Job object, including all necessary fields.
 */

@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();
    private Model model;
    private JobForm jobForm;
    private Errors errors;

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view

        /* Jen's added code starts here */
        Job aJob = jobData.findById(id);
        model.addAttribute("aJob", aJob);
        /* Jen's added code ends here */

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model. If valid:
        // create a new Job and add it to the jobData data store. Then
        // redirect to the job-detail view for the new Job.

        //If the JobForm model is invalid, then:
        if (errors.hasErrors()){
            return "new-job";
        //else, if the JobForm model is valid:
        } else {
            //create a new job
            Job aJob = new Job();

            //populate the fields with the objects referred to by the values in the view
            aJob.setName(jobForm.getName());
            aJob.setEmployer(jobData.getEmployers().findById(jobForm.getEmployerId()));
            aJob.setLocation(jobData.getLocations().findById(jobForm.getLocationId()));
            aJob.setPositionType(jobData.getPositionTypes().findById(jobForm.getPositionTypeId()));
            aJob.setCoreCompetency(jobData.getCoreCompetencies().findById(jobForm.getCoreCompetencyId()));

            //add the new Job to the jobData data store.
            jobData.add(aJob);

            //display the new Job
            model.addAttribute("aJob", aJob);
            return "job-detail";
        }
    }
}