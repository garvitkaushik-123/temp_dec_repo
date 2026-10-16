package com.sourcepoint.cmplibrary.data.local;

import android.content.SharedPreferences;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: DataStorageGdpr.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\b`\u0018\u0000 :2\u00020\u0001:\u0001:J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u00020.H&J\b\u00100\u001a\u00020.H&J\b\u00101\u001a\u00020.H&J\n\u00102\u001a\u0004\u0018\u00010\u0003H&J\n\u00103\u001a\u0004\u0018\u00010\u0003H&J\n\u00104\u001a\u0004\u0018\u00010\u0003H&J\b\u00105\u001a\u00020\u0003H&J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010\u0003H&J\u0010\u00108\u001a\u00020.2\u0006\u00107\u001a\u00020\u0003H&J\u0010\u00109\u001a\u00020.2\u0006\u00107\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R&\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010(X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006;"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;", "", "gdprChildPmId", "", "getGdprChildPmId", "()Ljava/lang/String;", "setGdprChildPmId", "(Ljava/lang/String;)V", "gdprConsentUuid", "getGdprConsentUuid", "setGdprConsentUuid", "gdprDateCreated", "getGdprDateCreated", "setGdprDateCreated", "gdprExpirationDate", "getGdprExpirationDate", "setGdprExpirationDate", "gdprMessageMetaData", "getGdprMessageMetaData", "setGdprMessageMetaData", "gdprPostChoiceResp", "getGdprPostChoiceResp", "setGdprPostChoiceResp", "gdprSampleRate", "", "getGdprSampleRate", "()D", "setGdprSampleRate", "(D)V", "gdprSampled", "", "getGdprSampled", "()Ljava/lang/Boolean;", "setGdprSampled", "(Ljava/lang/Boolean;)V", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "tcData", "", "getTcData", "()Ljava/util/Map;", "setTcData", "(Ljava/util/Map;)V", "clearGdprConsent", "", "clearInternalData", "clearTCData", "deleteGdprConsent", "getAuthId", "getGdpr", "getGdprConsentResp", "getGdprMessage", "saveAuthId", "value", "saveGdpr", "saveGdprConsentResp", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DataStorageGdpr {
    public static final String AUTH_ID_KEY = "sp.gdpr.authId";
    public static final String CMP_SDK_ID_KEY = "IABTCF_CmpSdkID";
    public static final String CMP_SDK_VERSION_KEY = "IABTCF_CmpSdkVersion";
    public static final String CONSENT_UUID_KEY = "sp.gdpr.consentUUID";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DEFAULT_EMPTY_CONSENT_STRING = "";
    public static final String DEFAULT_EMPTY_UUID = "";
    public static final String DEFAULT_META_DATA = "{}";
    public static final String EU_CONSENT_KEY = "sp.gdpr.euconsent";
    public static final String GDPR_CONSENT_RESP = "sp.gdpr.consent.resp";
    public static final String GDPR_DATE_CREATED = "sp.gdpr.key.date.created";
    public static final String GDPR_EXPIRATION_DATE_MESSAGE = "sp.gdpr.key.expiration.date";
    public static final String GDPR_JSON_MESSAGE = "sp.gdpr.json.message";
    public static final String GDPR_MESSAGE_METADATA = "sp.gdpr.key.message.metadata";
    public static final String GDPR_POST_CHOICE_RESP = "sp.gdpr.key.post.choice";
    public static final String GDPR_SAMPLING_RESULT = "sp.gdpr.key.sampling.result";
    public static final String GDPR_SAMPLING_VALUE = "sp.gdpr.key.sampling";
    public static final String GDPR_TCData = "TCData";
    public static final String IABTCF_KEY_PREFIX = "IABTCF_";
    public static final String KEY_GDPR_APPLIES = "sp.gdpr.key.applies";
    public static final String KEY_GDPR_APPLIES_OLD = "sp.key.gdpr.applies";
    public static final String KEY_GDPR_CHILD_PM_ID = "sp.gdpr.key.childPmId";
    public static final String KEY_GDPR_MESSAGE_SUBCATEGORY = "sp.gdpr.key.message.subcategory";
    public static final String KEY_GDPR_MESSAGE_SUBCATEGORY_OLD = "sp.key.gdpr.message.subcategory";
    public static final String META_DATA_KEY = "sp.gdpr.metaData";
    public static final String USER_CONSENT_KEY = "sp.gdpr.userConsent";

    void clearGdprConsent();

    void clearInternalData();

    void clearTCData();

    void deleteGdprConsent();

    String getAuthId();

    String getGdpr();

    String getGdprChildPmId();

    String getGdprConsentResp();

    String getGdprConsentUuid();

    String getGdprDateCreated();

    String getGdprExpirationDate();

    String getGdprMessage();

    String getGdprMessageMetaData();

    String getGdprPostChoiceResp();

    double getGdprSampleRate();

    Boolean getGdprSampled();

    SharedPreferences getPreference();

    Map<String, Object> getTcData();

    void saveAuthId(String value);

    void saveGdpr(String value);

    void saveGdprConsentResp(String value);

    void setGdprChildPmId(String str);

    void setGdprConsentUuid(String str);

    void setGdprDateCreated(String str);

    void setGdprExpirationDate(String str);

    void setGdprMessageMetaData(String str);

    void setGdprPostChoiceResp(String str);

    void setGdprSampleRate(double d);

    void setGdprSampled(Boolean bool);

    void setTcData(Map<String, ? extends Object> map);

    /* compiled from: DataStorageGdpr.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr$Companion;", "", "()V", "AUTH_ID_KEY", "", "CMP_SDK_ID_KEY", "CMP_SDK_VERSION_KEY", "CONSENT_UUID_KEY", "DEFAULT_AUTH_ID", "getDEFAULT_AUTH_ID", "()Ljava/lang/String;", "DEFAULT_EMPTY_CONSENT_STRING", "DEFAULT_EMPTY_UUID", "DEFAULT_META_DATA", "EU_CONSENT_KEY", "GDPR_CONSENT_RESP", "GDPR_DATE_CREATED", "GDPR_EXPIRATION_DATE_MESSAGE", "GDPR_JSON_MESSAGE", "GDPR_MESSAGE_METADATA", "GDPR_POST_CHOICE_RESP", "GDPR_SAMPLING_RESULT", "GDPR_SAMPLING_VALUE", "GDPR_TCData", "IABTCF_KEY_PREFIX", "KEY_GDPR_APPLIES", "KEY_GDPR_APPLIES_OLD", "KEY_GDPR_CHILD_PM_ID", "KEY_GDPR_MESSAGE_SUBCATEGORY", "KEY_GDPR_MESSAGE_SUBCATEGORY_OLD", "META_DATA_KEY", "USER_CONSENT_KEY", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AUTH_ID_KEY = "sp.gdpr.authId";
        public static final String CMP_SDK_ID_KEY = "IABTCF_CmpSdkID";
        public static final String CMP_SDK_VERSION_KEY = "IABTCF_CmpSdkVersion";
        public static final String CONSENT_UUID_KEY = "sp.gdpr.consentUUID";
        private static final String DEFAULT_AUTH_ID = null;
        public static final String DEFAULT_EMPTY_CONSENT_STRING = "";
        public static final String DEFAULT_EMPTY_UUID = "";
        public static final String DEFAULT_META_DATA = "{}";
        public static final String EU_CONSENT_KEY = "sp.gdpr.euconsent";
        public static final String GDPR_CONSENT_RESP = "sp.gdpr.consent.resp";
        public static final String GDPR_DATE_CREATED = "sp.gdpr.key.date.created";
        public static final String GDPR_EXPIRATION_DATE_MESSAGE = "sp.gdpr.key.expiration.date";
        public static final String GDPR_JSON_MESSAGE = "sp.gdpr.json.message";
        public static final String GDPR_MESSAGE_METADATA = "sp.gdpr.key.message.metadata";
        public static final String GDPR_POST_CHOICE_RESP = "sp.gdpr.key.post.choice";
        public static final String GDPR_SAMPLING_RESULT = "sp.gdpr.key.sampling.result";
        public static final String GDPR_SAMPLING_VALUE = "sp.gdpr.key.sampling";
        public static final String GDPR_TCData = "TCData";
        public static final String IABTCF_KEY_PREFIX = "IABTCF_";
        public static final String KEY_GDPR_APPLIES = "sp.gdpr.key.applies";
        public static final String KEY_GDPR_APPLIES_OLD = "sp.key.gdpr.applies";
        public static final String KEY_GDPR_CHILD_PM_ID = "sp.gdpr.key.childPmId";
        public static final String KEY_GDPR_MESSAGE_SUBCATEGORY = "sp.gdpr.key.message.subcategory";
        public static final String KEY_GDPR_MESSAGE_SUBCATEGORY_OLD = "sp.key.gdpr.message.subcategory";
        public static final String META_DATA_KEY = "sp.gdpr.metaData";
        public static final String USER_CONSENT_KEY = "sp.gdpr.userConsent";

        private Companion() {
        }

        public final String getDEFAULT_AUTH_ID() {
            return DEFAULT_AUTH_ID;
        }
    }
}
