package com.applovin.impl;

import adn.analytics.Analytics;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;

/* loaded from: classes2.dex */
public abstract class u6 {
    public static String a(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 2) {
            return "SFBX CMP";
        }
        if (intValue == 3) {
            return "Liveramp CMP";
        }
        if (intValue == 5) {
            return "UserCentrics CMP";
        }
        if (intValue == 6) {
            return "Sourcepoint Dialogue CMP";
        }
        if (intValue == 7) {
            return "Didomi CMP";
        }
        if (intValue == 27) {
            return "Associated Newspapers Ltd CMP";
        }
        if (intValue == 28) {
            return "Onetrust / Cookiepro CMP";
        }
        if (intValue == 104) {
            return "AdOcean CMP";
        }
        if (intValue == 105) {
            return "Dailymotion CMP";
        }
        if (intValue == 302) {
            return "Gravito CMP";
        }
        if (intValue == 303) {
            return "Impala CMP";
        }
        if (intValue == 414) {
            return "MBEX LTD CMP";
        }
        if (intValue == 415) {
            return "Match Group LLC CMP";
        }
        switch (intValue) {
            case 10:
                break;
            case 14:
                break;
            case 21:
                break;
            case 31:
                break;
            case 35:
                break;
            case 59:
                break;
            case 68:
                break;
            case TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER /* 72 */:
                break;
            case 76:
                break;
            case Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER /* 79 */:
                break;
            case 84:
                break;
            case 90:
                break;
            case INVALID_RI_ENDPOINT_VALUE:
                break;
            case INVALID_METRICS_ENDPOINT_VALUE:
                break;
            case 134:
                break;
            case 167:
                break;
            case 171:
                break;
            case 198:
                break;
            case 212:
                break;
            case 231:
                break;
            case 237:
                break;
            case 246:
                break;
            case 258:
                break;
            case 260:
                break;
            case 273:
                break;
            case 280:
                break;
            case 300:
                break;
            case 306:
                break;
            case ASSET_FAILED_TO_DELETE_VALUE:
                break;
            case AD_CLOSED_MISSING_HEARTBEAT_VALUE:
                break;
            case 327:
                break;
            case 329:
                break;
            case 340:
                break;
            case 345:
                break;
            case 348:
                break;
            case 355:
                break;
            case 371:
                break;
            case 385:
                break;
            case 387:
                break;
            case 397:
                break;
            case 399:
                break;
            case 409:
                break;
            case 421:
                break;
            case 432:
                break;
            case 436:
                break;
            default:
                switch (intValue) {
                }
        }
        return null;
    }
}
