package com.sourcepoint.cmplibrary.data.local;

import android.content.SharedPreferences;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: DataStorageCcpa.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\b`\u0018\u0000 >2\u00020\u0001:\u0001>J\b\u00103\u001a\u000204H&J\b\u00105\u001a\u000204H&J\b\u00106\u001a\u000204H&J\n\u00107\u001a\u0004\u0018\u00010\u0003H&J\n\u00108\u001a\u0004\u0018\u00010\u0003H&J\b\u00109\u001a\u00020\u0003H&J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u0002042\u0006\u0010;\u001a\u00020\u0003H&J\u0010\u0010=\u001a\u0002042\u0006\u0010;\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R(\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010'X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020-X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0005\"\u0004\b2\u0010\u0007¨\u0006?"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "", "ccpaChildPmId", "", "getCcpaChildPmId", "()Ljava/lang/String;", "setCcpaChildPmId", "(Ljava/lang/String;)V", "ccpaConsentUuid", "getCcpaConsentUuid", "setCcpaConsentUuid", "ccpaDateCreated", "getCcpaDateCreated", "setCcpaDateCreated", "ccpaExpirationDate", "getCcpaExpirationDate", "setCcpaExpirationDate", "ccpaMessageMetaData", "getCcpaMessageMetaData", "setCcpaMessageMetaData", "ccpaPostChoiceResp", "getCcpaPostChoiceResp", "setCcpaPostChoiceResp", "ccpaSampleRate", "", "getCcpaSampleRate", "()D", "setCcpaSampleRate", "(D)V", "ccpaSampled", "", "getCcpaSampled", "()Ljava/lang/Boolean;", "setCcpaSampled", "(Ljava/lang/Boolean;)V", "ccpaStatus", "getCcpaStatus", "setCcpaStatus", "gppData", "", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "uspstring", "getUspstring", "setUspstring", "clearCcpaConsent", "", "clearGppData", "deleteCcpaConsent", "getCcpa", "getCcpaConsentResp", "getCcpaMessage", "saveCcpa", "value", "saveCcpaConsentResp", "saveCcpaMessage", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DataStorageCcpa {
    public static final String CCPA_CONSENT_RESP = "sp.ccpa.consent.resp";
    public static final String CCPA_DATE_CREATED = "sp.ccpa.key.date.created";
    public static final String CCPA_EXPIRATION_DATE_MESSAGE = "sp.ccpa.key.expiration.date";
    public static final String CCPA_JSON_MESSAGE = "sp.ccpa.json.message";
    public static final String CCPA_MESSAGE_METADATA = "sp.ccpa.key.message.metadata";
    public static final String CCPA_POST_CHOICE_RESP = "sp.ccpa.key.post.choice";
    public static final String CCPA_SAMPLING_RESULT = "sp.ccpa.key.sampling.result";
    public static final String CCPA_SAMPLING_VALUE = "sp.ccpa.key.sampling";
    public static final String CCPA_STATUS = "sp.ccpa.key.v7.status";
    public static final String CONSENT_CCPA_UUID_KEY = "sp.ccpa.consentUUID";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String KEY_CCPA = "sp.ccpa.key";
    public static final String KEY_CCPA_APPLIES = "sp.ccpa.key.applies";
    public static final String KEY_CCPA_CHILD_PM_ID = "sp.ccpa.key.childPmId";
    public static final String KEY_CCPA_MESSAGE_SUBCATEGORY = "sp.ccpa.key.message.subcategory";
    public static final String KEY_CCPA_OLD = "sp.key.ccpa";
    public static final String KEY_IABGPP_PREFIX = "IABGPP_";
    public static final String KEY_IAB_US_PRIVACY_STRING = "IABUSPrivacy_String";

    void clearCcpaConsent();

    void clearGppData();

    void deleteCcpaConsent();

    String getCcpa();

    String getCcpaChildPmId();

    String getCcpaConsentResp();

    String getCcpaConsentUuid();

    String getCcpaDateCreated();

    String getCcpaExpirationDate();

    String getCcpaMessage();

    String getCcpaMessageMetaData();

    String getCcpaPostChoiceResp();

    double getCcpaSampleRate();

    Boolean getCcpaSampled();

    String getCcpaStatus();

    Map<String, Object> getGppData();

    SharedPreferences getPreference();

    String getUspstring();

    void saveCcpa(String value);

    void saveCcpaConsentResp(String value);

    void saveCcpaMessage(String value);

    void setCcpaChildPmId(String str);

    void setCcpaConsentUuid(String str);

    void setCcpaDateCreated(String str);

    void setCcpaExpirationDate(String str);

    void setCcpaMessageMetaData(String str);

    void setCcpaPostChoiceResp(String str);

    void setCcpaSampleRate(double d);

    void setCcpaSampled(Boolean bool);

    void setCcpaStatus(String str);

    void setGppData(Map<String, ? extends Object> map);

    void setUspstring(String str);

    /* compiled from: DataStorageCcpa.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa$Companion;", "", "()V", "CCPA_CONSENT_RESP", "", "CCPA_DATE_CREATED", "CCPA_EXPIRATION_DATE_MESSAGE", "CCPA_JSON_MESSAGE", "CCPA_MESSAGE_METADATA", "CCPA_POST_CHOICE_RESP", "CCPA_SAMPLING_RESULT", "CCPA_SAMPLING_VALUE", "CCPA_STATUS", "CONSENT_CCPA_UUID_KEY", "KEY_CCPA", "KEY_CCPA_APPLIES", "KEY_CCPA_CHILD_PM_ID", "KEY_CCPA_MESSAGE_SUBCATEGORY", "KEY_CCPA_OLD", "KEY_IABGPP_PREFIX", "KEY_IAB_US_PRIVACY_STRING", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CCPA_CONSENT_RESP = "sp.ccpa.consent.resp";
        public static final String CCPA_DATE_CREATED = "sp.ccpa.key.date.created";
        public static final String CCPA_EXPIRATION_DATE_MESSAGE = "sp.ccpa.key.expiration.date";
        public static final String CCPA_JSON_MESSAGE = "sp.ccpa.json.message";
        public static final String CCPA_MESSAGE_METADATA = "sp.ccpa.key.message.metadata";
        public static final String CCPA_POST_CHOICE_RESP = "sp.ccpa.key.post.choice";
        public static final String CCPA_SAMPLING_RESULT = "sp.ccpa.key.sampling.result";
        public static final String CCPA_SAMPLING_VALUE = "sp.ccpa.key.sampling";
        public static final String CCPA_STATUS = "sp.ccpa.key.v7.status";
        public static final String CONSENT_CCPA_UUID_KEY = "sp.ccpa.consentUUID";
        public static final String KEY_CCPA = "sp.ccpa.key";
        public static final String KEY_CCPA_APPLIES = "sp.ccpa.key.applies";
        public static final String KEY_CCPA_CHILD_PM_ID = "sp.ccpa.key.childPmId";
        public static final String KEY_CCPA_MESSAGE_SUBCATEGORY = "sp.ccpa.key.message.subcategory";
        public static final String KEY_CCPA_OLD = "sp.key.ccpa";
        public static final String KEY_IABGPP_PREFIX = "IABGPP_";
        public static final String KEY_IAB_US_PRIVACY_STRING = "IABUSPrivacy_String";

        private Companion() {
        }
    }
}
