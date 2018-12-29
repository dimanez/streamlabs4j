package com.github.twitch4j.streamlabs4j.api;

import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsDonationsData;
import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsUser;
import com.netflix.hystrix.HystrixCommand;
import feign.Param;
import feign.RequestLine;
public interface StreamlabsApi {

    /**
     * Gets information about the user associated with the specified token
     *
     * @param authToken Your authentication token
     * @return the user associated with this token
     */
    @RequestLine("GET /user?" +
        "access_token={access_token}")
    HystrixCommand<StreamlabsUser> getUser(
        @Param("access_token") String authToken
    );

    /**
     * Gets donations about the user associated with the specified token
     *
     * @param authToken Your authentication token
     * @param limit     Limit the number of donations
     * @param before    Donation id of the value before your first one
     * @param after     Donation id of the value after your last one
     * @param currency  Desired currency (can be null)
     * @param verified  true = donations associated with a bank / paypal ...etc account
     *                  false = donations created by the streamer
     *                  nothing ("") = true and false
     * @return A list of donations associated with this token
     */
    @RequestLine("GET /donations?" +
        "access_token={access_token}&" +
        "limit={limit}&" +
        "before={before}&" +
        "after={after}&" +
        "currency={currency}&" +
        "verified={verified}")
    HystrixCommand<StreamlabsDonationsData> getDonations(
        @Param("access_token") String authToken,
        @Param("limit") int limit,
        @Param("before") String before,
        @Param("after") String after,
        @Param("currency") String currency,
        @Param("verified") String verified
        @Param("currency") String currency,
        @Param("created_at") String createdAt,
        @Param("access_token") String authToken,
        @Param("skip_alert") String skipAlert
    );

}
