package org.launchcode.models.forms;

import org.launchcode.models.JobFieldType;

/**
 * Created by LaunchCode
 */


/**
 * Notes to self from assignment instructions:
 *
 * This class was established to create a model to be used during the search process so that
 * the application could utilize the benefits of model binding and validation.
 *
 * The fields here represent the data that are necessary to display and process the search form.
 * Specifically:
 *     SearchController uses model binding with a SearchForm object to process the form, and
 *     we pass a SearchForm object into the view to display the form.
 */

public class SearchForm {

    // The search options
    private JobFieldType[] fields = JobFieldType.values();

    // The selected search options
    private JobFieldType searchField = JobFieldType.ALL;

    // The search string
    private String keyword;

    public JobFieldType getSearchField() {
        return searchField;
    }

    public void setSearchField(JobFieldType searchField) {
        this.searchField = searchField;
    }

    public JobFieldType[] getFields() {
        return fields;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
