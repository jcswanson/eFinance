package com.ist412.efinance.model;

import com.plaid.client.request.PlaidApi;

import java.io.Serializable;
import java.util.HashMap;


public class Plaid implements Serializable {

    private long plaidClientID;

    private String plaidRedirectUri;

    private String plaidSecret;

    private String plaidEnv;

    private String plaidProducts;

    private String plaidCountryCodes;



    public long getPlaidClientID() {
        return plaidClientID;
    }

    public void setPlaidClientID(long plaidClientID) {
        this.plaidClientID = plaidClientID;
    }

    public String getPlaidSecret() {
        return plaidSecret;
    }

    public void setPlaidSecret(String plaidSecret) {
        this.plaidSecret = plaidSecret;
    }

    public String getPlaidEnv() {
        return plaidEnv;
    }

    public void setPlaidEnv(String plaidEnv) {
        this.plaidEnv = plaidEnv;
    }

    public String getPlaidProducts() {
        return plaidProducts;
    }

    public void setPlaidProducts(String plaidProducts) {
        this.plaidProducts = plaidProducts;
    }

    public String getPlaidCountryCodes() {
        return plaidCountryCodes;
    }

    public void setPlaidCountryCodes(String plaidCountryCodes) {
        this.plaidCountryCodes = plaidCountryCodes;
    }

    public String getPlaidRedirectUri() {
        return plaidRedirectUri;
    }

    public void setPlaidRedirectUri(String plaidRedirectUri) {
        this.plaidRedirectUri = plaidRedirectUri;
    }
}
