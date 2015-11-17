
package services;

/**
 * @author S Samarasinghe d315004
 */
public class RestResponse {

    private int responseCode;
    private String response;
    private String errorMessage;

    public RestResponse() {
    }

    public RestResponse(int responseCode, String response, String errorMessage) {
        super();
        this.responseCode = responseCode;
        this.response = response;
        this.errorMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
