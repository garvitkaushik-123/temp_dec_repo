package io.bidmachine;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import io.bidmachine.protobuf.Extras;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.SharedPreferenceUtils;
import java.util.UUID;

/* loaded from: classes7.dex */
class BidMachineSharedPreference {
    private static final String KEY_BM_IFV = "bid_machine_ifv";
    private static final String KEY_CURRENT_SESSION_DURATION = "current_session_duration";
    private static final String KEY_FIRST_LAUNCH_TIME = "first_app_launch_ms";
    private static final String KEY_HW_INFO = "hw_info_";
    private static final String KEY_INIT_DATA = "initData";
    private static final String KEY_INIT_DATA_SESSION_ID = "init_data_session_id";
    private static final String KEY_INIT_EXTRAS = "init_extras";
    private static final String KEY_LAST_SESSION_DURATION = "last_session_duration";
    private static final String KEY_SESSION_COUNT = "session_count";
    private static final String KEY_USER_AGENT = "ua";
    private static final String KEY_USER_AGENT_DEVICE_OS = "ua_device_os";
    private static final String KEY_USER_AGENT_EXPIRATION = "ua_exp";
    private static final String NAME = "BidMachinePref";
    private static SharedPreferences sharedPreferences;

    BidMachineSharedPreference() {
    }

    static String obtainBMIFV(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        String optString = SharedPreferenceUtils.optString(sharedPreferences2, KEY_BM_IFV, null);
        if (!TextUtils.isEmpty(optString)) {
            return optString;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferenceUtils.putString(sharedPreferences2, KEY_BM_IFV, uuid);
        return uuid;
    }

    static long obtainFirstLaunchTimeMs(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        long optLong = SharedPreferenceUtils.optLong(sharedPreferences2, KEY_FIRST_LAUNCH_TIME, 0L);
        if (optLong != 0) {
            return optLong;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferenceUtils.putLong(sharedPreferences2, KEY_FIRST_LAUNCH_TIME, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    static void incrementSessionCount(Context context) {
        storeSessionCount(context, getSessionCount(context) + 1);
    }

    static void storeSessionCount(Context context, int sessionCount) {
        SharedPreferenceUtils.putInt(getSharedPreferences(context), KEY_SESSION_COUNT, Integer.valueOf(sessionCount));
    }

    static int getSessionCount(Context context) {
        return SharedPreferenceUtils.optInt(getSharedPreferences(context), KEY_SESSION_COUNT, 0);
    }

    static void storeCurrentSessionDurationMs(Context context, long sessionDuration) {
        SharedPreferenceUtils.putLong(getSharedPreferences(context), KEY_CURRENT_SESSION_DURATION, Long.valueOf(sessionDuration));
    }

    static long getCurrentSessionDurationMs(Context context) {
        return SharedPreferenceUtils.optLong(getSharedPreferences(context), KEY_CURRENT_SESSION_DURATION, 0L);
    }

    static void storeLastSessionDurationMs(Context context, long sessionDuration) {
        SharedPreferenceUtils.putLong(getSharedPreferences(context), KEY_LAST_SESSION_DURATION, Long.valueOf(sessionDuration));
    }

    static long getLastSessionDurationMs(Context context) {
        return SharedPreferenceUtils.optLong(getSharedPreferences(context), KEY_LAST_SESSION_DURATION, 0L);
    }

    static void applyCurrentToLastSessionDuration(Context context) {
        storeLastSessionDurationMs(context, getCurrentSessionDurationMs(context));
    }

    static void storeInitResponse(Context context, InitResponse response, String sessionId) {
        try {
            SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_INIT_DATA, Base64.encodeToString(response.toByteArray(), 0));
            SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_INIT_DATA_SESSION_ID, sessionId);
        } catch (Exception unused) {
        }
    }

    static InitResponse getInitResponse(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        try {
            return InitResponse.parseFrom(Base64.decode(sharedPreferences2.getString(KEY_INIT_DATA, null), 0));
        } catch (Exception unused) {
            SharedPreferenceUtils.remove(sharedPreferences2, KEY_INIT_DATA);
            return null;
        }
    }

    static String getInitResponseSessionId(Context context) {
        String optString = SharedPreferenceUtils.optString(getSharedPreferences(context), KEY_INIT_DATA_SESSION_ID, null);
        return optString != null ? optString : "";
    }

    static void storeInitExtras(Context context, Extras extras) {
        try {
            SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_INIT_EXTRAS, Base64.encodeToString(extras.toByteArray(), 0));
        } catch (Exception unused) {
        }
    }

    static Extras getInitExtras(Context context) {
        SharedPreferences sharedPreferences2 = getSharedPreferences(context);
        try {
            return Extras.parseFrom(Base64.decode(SharedPreferenceUtils.optString(sharedPreferences2, KEY_INIT_EXTRAS, null), 0));
        } catch (Exception unused) {
            SharedPreferenceUtils.remove(sharedPreferences2, KEY_INIT_EXTRAS);
            return null;
        }
    }

    static void clearInitExtras(Context context) {
        SharedPreferenceUtils.remove(getSharedPreferences(context), KEY_INIT_EXTRAS);
    }

    static String getValidUserAgent(Context context) {
        String userAgent = getUserAgent(context);
        if (TextUtils.isEmpty(userAgent) || !DeviceUtils.getOsVersion().equals(getUserAgentDeviceOs(context)) || getUserAgentExpirationMs(context) <= System.currentTimeMillis()) {
            return null;
        }
        return userAgent;
    }

    static void setValidUserAgent(Context context, String userAgent, long expirationMs) {
        setUserAgent(context, userAgent);
        setUserAgentDeviceOs(context, DeviceUtils.getOsVersion());
        setUserAgentExpirationMs(context, expirationMs);
    }

    static String getUserAgent(Context context) {
        return SharedPreferenceUtils.optString(getSharedPreferences(context), "ua", null);
    }

    static void setUserAgent(Context context, String userAgent) {
        SharedPreferenceUtils.putString(getSharedPreferences(context), "ua", userAgent);
    }

    static String getUserAgentDeviceOs(Context context) {
        return SharedPreferenceUtils.optString(getSharedPreferences(context), KEY_USER_AGENT_DEVICE_OS, null);
    }

    static void setUserAgentDeviceOs(Context context, String userAgentDeviceOs) {
        SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_USER_AGENT_DEVICE_OS, userAgentDeviceOs);
    }

    static long getUserAgentExpirationMs(Context context) {
        return SharedPreferenceUtils.optLong(getSharedPreferences(context), KEY_USER_AGENT_EXPIRATION, -1L);
    }

    static void setUserAgentExpirationMs(Context context, long userAgentExpirationMs) {
        SharedPreferenceUtils.putLong(getSharedPreferences(context), KEY_USER_AGENT_EXPIRATION, Long.valueOf(userAgentExpirationMs));
    }

    static String getHwInfo(Context context, String key) {
        return SharedPreferenceUtils.optString(getSharedPreferences(context), KEY_HW_INFO + key, null);
    }

    static void setHwInfo(Context context, String key, String value) {
        SharedPreferenceUtils.putString(getSharedPreferences(context), KEY_HW_INFO + key, value);
    }

    static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(NAME, 0);
        }
        return sharedPreferences;
    }

    static void clear(Context context) {
        SharedPreferenceUtils.clear(getSharedPreferences(context));
    }
}
