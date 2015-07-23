package actors;

import play.data.validation.Constraints;

import java.io.Serializable;

/**
 * Created by Ott Konstantin on 02.06.2015.
 * holds the command data
 */
public class CmdMessage implements Serializable {



    @Constraints.Required
    public String sru;
    @Constraints.Required
    public String endpoint;
    @Constraints.Required
    public String pds;
    @Constraints.Required
    public String searchkey;
    @Constraints.Required
    public String replacekey;
    public String replacekeyattribute;
    @Constraints.Required
    public String institution;
    @Constraints.Required
    public String userName;
    @Constraints.Required
    public String password;
    public  String key;
    public  String replace;
    public  boolean update;
    public  boolean reset;
    public  boolean status;
    public  boolean log;
    public  boolean testmodus;
    public String data;


    public CmdMessage(String key, String replace, boolean testmodus) {
        this.key = key;
        this.replace = replace;
        this.update = true;
        this.testmodus = testmodus;
    }

    public CmdMessage() {}

    public CmdMessage(boolean testmodus) {
        this.testmodus = testmodus;
        }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public String getSru() {
        return sru;
    }

    public void setSru(String sru) {
        this.sru = sru;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getPds() {
        return pds;
    }

    public void setPds(String pds) {
        this.pds = pds;
    }

    public String getSearchkey() {
        return searchkey;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
    }

    public String getReplacekey() {
        return replacekey;
    }

    public void setReplacekey(String replacekey) {
        this.replacekey = replacekey;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getReplacekeyattribute() {
        return replacekeyattribute;
    }

    public void setReplacekeyattribute(String replacekeyattribute) {
        this.replacekeyattribute = replacekeyattribute;
    }

    public String toString() {
        return "status: " + status  + " reset: " + reset;
    }
}
