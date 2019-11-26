package model.openbrewdb;

import java.util.regex.Pattern;

public class StateSearchSpec implements SearchSpecification {
    private String queryParameter;

    public StateSearchSpec() {
        queryParameter = "by_state";
    }

    @Override
    public String getQueryParameter() {
        return queryParameter;
    }

    @Override
    public boolean checkSearchTermValidity(String searchTerm) {
        if (Pattern.matches("[a-zA-Z]",searchTerm)) {
            return true;
        } else if (Pattern.matches("[a-zA-Z]_[a-zA-Z]", searchTerm)) {
            return true;
        } else {
            return false;
        }
    }
}
