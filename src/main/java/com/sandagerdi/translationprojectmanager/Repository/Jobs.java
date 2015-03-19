/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Repository;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/**
 *
 * @author Jóannes
 */
@DatabaseTable(tableName = "jobs")
public class Jobs {

    public static final String CLIENTS_ID_FIELD_NAME = "clients_id";
    public static final String JOBTYPES_ID_FIELD_NAME = "jobTypes_id";
    public static final String JOBTYPES_SERVICE_FIELD_NAME = "service";
    public static final String JOBTYPES_SOURCE_LANG_FIELD_NAME = "source_lang";
    public static final String JOBTYPES_TARGET_LANG_FIELD_NAME = "target_lang";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = CLIENTS_ID_FIELD_NAME)
    private Clients client;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = JOBTYPES_ID_FIELD_NAME)
    private JobTypes jobType;

    @DatabaseField(canBeNull = false)
    private Date dateCreated;
    @DatabaseField(canBeNull = false)
    private Date dateDeadline;

    @DatabaseField(canBeNull = false)
    private String description;

    @DatabaseField
    private double pay_hour;

    @DatabaseField
    private double words_new;
    @DatabaseField
    private double words_fuzzy50;
    @DatabaseField
    private double words_fuzzy75;
    @DatabaseField
    private double words_fuzzy85;
    @DatabaseField
    private double words_fuzzy95;
    @DatabaseField
    private double words_match;
    @DatabaseField
    private double words_rep;
    @DatabaseField
    private double words_ice;
    @DatabaseField
    private boolean isRush;

    // Job status
    @DatabaseField
    private int jobStatus;
    @DatabaseField
    private Date dateFinished;

    Jobs() {
    }

    public Jobs(Clients client, JobTypes jobType, Date dateCreated, Date dateDeadline, String description, double pay_hour, double words_new, double words_fuzzy50, double words_fuzzy75, double words_fuzzy85, double words_fuzzy95, double words_match, double words_rep, double words_ice, boolean isRush) {
        this.client = client;
        this.jobType = jobType;
        this.dateCreated = dateCreated;
        this.dateDeadline = dateDeadline;
        this.description = description;
        this.pay_hour = pay_hour;
        this.words_new = words_new;
        this.words_fuzzy50 = words_fuzzy50;
        this.words_fuzzy75 = words_fuzzy75;
        this.words_fuzzy85 = words_fuzzy85;
        this.words_fuzzy95 = words_fuzzy95;
        this.words_match = words_match;
        this.words_rep = words_rep;
        this.words_ice = words_ice;
        this.isRush = isRush;

        // job status
        this.jobStatus = JobStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public JobTypes getJobType() {
        return jobType;
    }

    public void setJobType(JobTypes jobType) {
        this.jobType = jobType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateDeadline() {
        return dateDeadline;
    }

    public void setDateDeadline(Date dateDeadline) {
        this.dateDeadline = dateDeadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPay_hour() {
        return pay_hour;
    }

    public void setPay_hour(double pay_hour) {
        this.pay_hour = pay_hour;
    }

    public double getWords_new() {
        return words_new;
    }

    public void setWords_new(double words_new) {
        this.words_new = words_new;
    }

    public double getWords_fuzzy50() {
        return words_fuzzy50;
    }

    public void setWords_fuzzy50(double words_fuzzy50) {
        this.words_fuzzy50 = words_fuzzy50;
    }

    public double getWords_fuzzy75() {
        return words_fuzzy75;
    }

    public void setWords_fuzzy75(double words_fuzzy75) {
        this.words_fuzzy75 = words_fuzzy75;
    }

    public double getWords_fuzzy85() {
        return words_fuzzy85;
    }

    public void setWords_fuzzy85(double words_fuzzy85) {
        this.words_fuzzy85 = words_fuzzy85;
    }

    public double getWords_fuzzy95() {
        return words_fuzzy95;
    }

    public void setWords_fuzzy95(double words_fuzzy95) {
        this.words_fuzzy95 = words_fuzzy95;
    }

    public double getWords_match() {
        return words_match;
    }

    public void setWords_match(double words_match) {
        this.words_match = words_match;
    }

    public double getWords_rep() {
        return words_rep;
    }

    public void setWords_rep(double words_rep) {
        this.words_rep = words_rep;
    }

    public double getWords_ice() {
        return words_ice;
    }

    public void setWords_ice(double words_ice) {
        this.words_ice = words_ice;
    }

    @Override
    public int hashCode() {
        return this.dateCreated.hashCode();
    }

    public boolean isRush() {
        return isRush;
    }

    public void setIsRush(boolean isRush) {
        this.isRush = isRush;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }
    
    //TODO pimp this
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != getClass()) {
            return false;
        }
        return this.dateCreated.equals(((Jobs) other).dateCreated);
    }
}
