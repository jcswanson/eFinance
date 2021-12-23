package com.ist412.efinance.model;

import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import com.sun.net.httpserver.HttpExchange;
import retrofit2.Response;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;


@Entity
public class Plaid implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plaid_id")
    private long pid;

    private static PlaidApi plaidClient;

    private String CLIENT_ID = "61bf78bb9730990012e7d7eb";
    private String SECRET = "912cf12d40964cdb8b5941eeebd660";


    public Plaid() {

    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plaidApplicant_id")
    private User plaidApplicant;



//    public void handle(HttpExchange t) throws IOException {
//        // Create your Plaid client
//        HashMap<String, String> apiKeys = new HashMap<String, String>();
//        apiKeys.put("clientId", CLIENT_ID);
//        apiKeys.put("secret", SECRET);
//        ApiClient apiClient = new ApiClient(apiKeys);
//        apiClient.setPlaidAdapter(ApiClient.Sandbox);

//        plaidClient = apiClient.createService(PlaidApi.class);

//        User userFromDB = new User();
//        String clientUserId = userFromDB.getUid().toString();
//        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
//                .clientUserId(clientUserId);

//        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
//                .user(user)
//                .clientName("Plaid Test App")
//                .products(Arrays.asList(Products.fromValue("auth")))
//                .countryCodes(Arrays.asList(CountryCode.US))
//                .language("en")
//                .redirectUri("https://domainname.com/oauth-page.html")
//                .webhook("https://webhook.example.com");
//
//        Response<LinkTokenCreateResponse> response = plaidClient
//                .linkTokenCreate(request)
//                .execute();
//
//                response.body();

//    }








}
