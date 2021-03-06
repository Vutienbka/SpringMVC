package com.codegym.Model;

public class EmailBox {
    private String[] language;
    private String[] pageSize;
    private String spamFilter;
    private String signature;

    public EmailBox() {
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public String[] getPageSize() {
        return pageSize;
    }

    public void setPageSize(String[] pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(String spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
