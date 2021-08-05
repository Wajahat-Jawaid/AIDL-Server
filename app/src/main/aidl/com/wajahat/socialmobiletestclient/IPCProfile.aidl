package com.wajahat.socialmobiletestclient;

import com.wajahat.socialmobiletestclient.data.Profile;

interface IPCProfile {

    /** Return the response to the client */
    void setLoginResponse(in Profile response);
}