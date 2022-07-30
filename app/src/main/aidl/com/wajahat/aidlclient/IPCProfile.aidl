package com.wajahat.aidlclient;

import com.wajahat.aidlclient.data.Profile;

interface IPCProfile {

    /** Return the response to the client */
    void setLoginResponse(in Profile response);
}