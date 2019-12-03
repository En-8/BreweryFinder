package model.openbrewdb;

public enum SortDirection {
    ASCENDING('+'), DESCENDING('-');

    private char sortDirection;

    SortDirection(char sortDirection) {
        this.sortDirection = sortDirection;
    }

    public char getSortDirection() {
        return sortDirection;
    }
}
