/*
 *  Copyright Jóannes í Sandagerði 2014
 */
package com.sandagerdi.translationprojectmanager.Repository;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jóannes
 */
@DatabaseTable(tableName = "jobTypes")
public class JobTypes {

    public static final String ACCOUNT_ID_FIELD_NAME = "account_id";
    public static final String ACCOUNT_SERVICE_FIELD_NAME = "service";
    public static final String ACCOUNT_SOURCE_LANG_FIELD_NAME = "source_lang";
    public static final String ACCOUNT_TARGET_LANG_FIELD_NAME = "target_lang";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, columnName = ACCOUNT_ID_FIELD_NAME)
    private Clients client;
    @DatabaseField(columnName = ACCOUNT_SERVICE_FIELD_NAME, canBeNull = false)
    private String service;
    @DatabaseField(columnName = ACCOUNT_SOURCE_LANG_FIELD_NAME)
    private String source_lang;
    @DatabaseField(columnName = ACCOUNT_TARGET_LANG_FIELD_NAME)
    private String target_lang;
    @DatabaseField
    private double pay_hour;
    @DatabaseField
    private double pay_minimum;
    @DatabaseField
    private double pay_rush;
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

    JobTypes() {
    }

    public JobTypes(Clients client, String service, String source_lang, String target_lang, double pay_hour, double pay_minimum, double pay_rush, double words_new, double words_fuzzy50, double words_fuzzy75, double words_fuzzy85, double words_fuzzy95, double words_match, double words_rep, double words_ice) {
        this.client = client;
        this.service = service;
        this.source_lang = source_lang;
        this.target_lang = target_lang;
        this.pay_hour = pay_hour;
        this.pay_minimum = pay_minimum;
        this.pay_rush = pay_rush;
        this.words_new = words_new;
        this.words_fuzzy50 = words_fuzzy50;
        this.words_fuzzy75 = words_fuzzy75;
        this.words_fuzzy85 = words_fuzzy85;
        this.words_fuzzy95 = words_fuzzy95;
        this.words_match = words_match;
        this.words_rep = words_rep;
        this.words_ice = words_ice;
    }
    /**
     * @return the client
     */
    public Clients getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Clients client) {
        this.client = client;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the source_lang
     */
    public String getSource_lang() {
        return source_lang;
    }

    /**
     * @param source_lang the source_lang to set
     */
    public void setSource_lang(String source_lang) {
        this.source_lang = source_lang;
    }

    /**
     * @return the target_lang
     */
    public String getTarget_lang() {
        return target_lang;
    }

    /**
     * @param target_lang the target_lang to set
     */
    public void setTarget_lang(String target_lang) {
        this.target_lang = target_lang;
    }

    /**
     * @return the pay_hour
     */
    public double getPay_hour() {
        return pay_hour;
    }

    /**
     * @param pay_hour the pay_hour to set
     */
    public void setPay_hour(double pay_hour) {
        this.pay_hour = pay_hour;
    }

    /**
     * @return the pay_minimum
     */
    public double getPay_minimum() {
        return pay_minimum;
    }

    /**
     * @param pay_minimum the pay_minimum to set
     */
    public void setPay_minimum(double pay_minimum) {
        this.pay_minimum = pay_minimum;
    }

    /**
     * @return the pay_rush
     */
    public double getPay_rush() {
        return pay_rush;
    }

    /**
     * @param pay_rush the pay_rush to set
     */
    public void setPay_rush(double pay_rush) {
        this.pay_rush = pay_rush;
    }

    /**
     * @return the words_new
     */
    public double getWords_new() {
        return words_new;
    }

    /**
     * @param words_new the words_new to set
     */
    public void setWords_new(double words_new) {
        this.words_new = words_new;
    }

    /**
     * @return the words_fuzzy50
     */
    public double getWords_fuzzy50() {
        return words_fuzzy50;
    }

    /**
     * @param words_fuzzy50 the words_fuzzy50 to set
     */
    public void setWords_fuzzy50(double words_fuzzy50) {
        this.words_fuzzy50 = words_fuzzy50;
    }

    /**
     * @return the words_fuzzy75
     */
    public double getWords_fuzzy75() {
        return words_fuzzy75;
    }

    /**
     * @param words_fuzzy75 the words_fuzzy75 to set
     */
    public void setWords_fuzzy75(double words_fuzzy75) {
        this.words_fuzzy75 = words_fuzzy75;
    }

    /**
     * @return the words_fuzzy85
     */
    public double getWords_fuzzy85() {
        return words_fuzzy85;
    }

    /**
     * @param words_fuzzy85 the words_fuzzy85 to set
     */
    public void setWords_fuzzy85(double words_fuzzy85) {
        this.words_fuzzy85 = words_fuzzy85;
    }

    /**
     * @return the words_fuzzy95
     */
    public double getWords_fuzzy95() {
        return words_fuzzy95;
    }

    /**
     * @param words_fuzzy95 the words_fuzzy95 to set
     */
    public void setWords_fuzzy95(double words_fuzzy95) {
        this.words_fuzzy95 = words_fuzzy95;
    }

    /**
     * @return the words_match
     */
    public double getWords_match() {
        return words_match;
    }

    /**
     * @param words_match the words_match to set
     */
    public void setWords_match(double words_match) {
        this.words_match = words_match;
    }

    /**
     * @return the words_rep
     */
    public double getWords_rep() {
        return words_rep;
    }

    /**
     * @param words_rep the words_rep to set
     */
    public void setWords_rep(double words_rep) {
        this.words_rep = words_rep;
    }

    /**
     * @return the words_ice
     */
    public double getWords_ice() {
        return words_ice;
    }

    /**
     * @param words_ice the words_ice to set
     */
    public void setWords_ice(double words_ice) {
        this.words_ice = words_ice;
    }
    
}
