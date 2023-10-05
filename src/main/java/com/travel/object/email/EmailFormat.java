
package com.travel.object.email;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FromEmail",
    "ToEmail",
    "CcEmail",
    "BccEmail",
    "MailSubject",
    "MailBody",
    "BookingID",
    "MailType"
})
public class EmailFormat {

    @JsonProperty("FromEmail")
    private String fromEmail;
    @JsonProperty("ToEmail")
    private String toEmail;
    @JsonProperty("CcEmail")
    private String ccEmail;
    @JsonProperty("BccEmail")
    private String bccEmail;
    @JsonProperty("MailSubject")
    private String mailSubject;
    @JsonProperty("MailBody")
    private String mailBody;
    @JsonProperty("BookingID")
    private String bookingID;
    @JsonProperty("MailType")
    private String mailType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FromEmail")
    public String getFromEmail() {
        return fromEmail;
    }

    @JsonProperty("FromEmail")
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    @JsonProperty("ToEmail")
    public String getToEmail() {
        return toEmail;
    }

    @JsonProperty("ToEmail")
    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    @JsonProperty("CcEmail")
    public String getCcEmail() {
        return ccEmail;
    }

    @JsonProperty("CcEmail")
    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    @JsonProperty("BccEmail")
    public String getBccEmail() {
        return bccEmail;
    }

    @JsonProperty("BccEmail")
    public void setBccEmail(String bccEmail) {
        this.bccEmail = bccEmail;
    }

    @JsonProperty("MailSubject")
    public String getMailSubject() {
        return mailSubject;
    }

    @JsonProperty("MailSubject")
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    @JsonProperty("MailBody")
    public String getMailBody() {
        return mailBody;
    }

    @JsonProperty("MailBody")
    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    @JsonProperty("BookingID")
    public String getBookingID() {
        return bookingID;
    }

    @JsonProperty("BookingID")
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    @JsonProperty("MailType")
    public String getMailType() {
        return mailType;
    }

    @JsonProperty("MailType")
    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
