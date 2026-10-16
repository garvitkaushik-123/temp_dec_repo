package com.tiktok.appevents;

import android.content.Context;
import com.tiktok.util.TTUtil;
import java.io.Serializable;
import java.security.MessageDigest;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTUserInfo implements Cloneable, Serializable {
    static final String TAG = "com.tiktok.appevents.TTUserInfo";
    public static volatile TTUserInfo sharedInstance = new TTUserInfo();
    String anonymousId;
    String email;
    String externalId;
    String externalUserName;
    transient boolean isIdentified = false;
    String phoneNumber;

    public static void reset(Context context, boolean forceGenerateAnoId) {
        sharedInstance.anonymousId = TTUtil.getOrGenAnoId(context, forceGenerateAnoId);
        sharedInstance.externalId = null;
        sharedInstance.externalUserName = null;
        sharedInstance.phoneNumber = null;
        sharedInstance.email = null;
        sharedInstance.isIdentified = false;
    }

    private String toSha256(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
            return null;
        }
    }

    public boolean isIdentified() {
        return this.isIdentified;
    }

    public void setIdentified() {
        this.isIdentified = true;
    }

    public void setExternalId(String externalId) {
        this.externalId = toSha256(externalId);
    }

    public void setExternalUserName(String externalUserName) {
        this.externalUserName = toSha256(externalUserName);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = toSha256(phoneNumber);
    }

    public void setEmail(String email) {
        this.email = toSha256(email);
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("anonymous_id", this.anonymousId);
            String str = this.externalId;
            if (str != null) {
                jSONObject.put("external_id", str);
            }
            String str2 = this.externalUserName;
            if (str2 != null) {
                jSONObject.put("external_username", str2);
            }
            String str3 = this.phoneNumber;
            if (str3 != null) {
                jSONObject.put("phone_number", str3);
            }
            String str4 = this.email;
            if (str4 != null) {
                jSONObject.put("email", str4);
                return jSONObject;
            }
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
        }
        return jSONObject;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TTUserInfo m9167clone() {
        try {
            return (TTUserInfo) super.clone();
        } catch (Exception unused) {
            return new TTUserInfo();
        }
    }
}
