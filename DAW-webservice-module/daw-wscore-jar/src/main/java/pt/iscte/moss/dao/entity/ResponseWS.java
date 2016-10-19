package pt.iscte.moss.dao.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "responseWS")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseWS {

    @XmlElement(name = "value")
    private String value;

    public ResponseWS() {
    }

    public ResponseWS(int param) {
	value = String.valueOf(param);
    }

    public ResponseWS(boolean param) {
	value = String.valueOf(param);
    }

    public String getResponseValue() {
	return value;
    }

    public void setResponseValue(String responseValue) {
	this.value = responseValue;
    }
}
