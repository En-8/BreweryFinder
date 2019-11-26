package model.openbrewdb;

enum TypeSearchSpecOptions implements SearchOption {
    MICRO("micro"), REGIONAL("regional"), BREWPUB("brewpub"), LARGE("large"),
    PLANNING("planning"), BAR("bar"), CONTRACT("contract"), PROPRIETOR("proprietor");

    String searchOption;

    TypeSearchSpecOptions(String searchOption) {
        this.searchOption = searchOption;
    }

    public String getSearchOption() {
        return searchOption;
    }
}
