package com.sourcepoint.cmplibrary.data.local;

import android.content.SharedPreferences;
import com.ironsource.C3040d4;
import kotlin.Metadata;

/* compiled from: DataStorage.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001@J\b\u0010;\u001a\u00020<H&J\n\u0010=\u001a\u0004\u0018\u00010\tH&J\u0010\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020\tH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u0012\u0010\u001a\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\u001a\u0010\"\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR\u001a\u0010%\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\rR\u001a\u0010(\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\rR\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u000200X¦\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00105\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u00108R\u0012\u00109\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0007¨\u0006A"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;", "ccpaApplies", "", "getCcpaApplies", "()Z", "ccpaConsentStatus", "", "getCcpaConsentStatus", "()Ljava/lang/String;", "setCcpaConsentStatus", "(Ljava/lang/String;)V", "choiceResp", "getChoiceResp", "setChoiceResp", "consentStatus", "getConsentStatus", "setConsentStatus", "consentStatusResponse", "getConsentStatusResponse", "setConsentStatusResponse", "dataRecordedConsent", "getDataRecordedConsent", "setDataRecordedConsent", "gdprApplies", "getGdprApplies", C3040d4.i.a0, "getGdprConsentStatus", "setGdprConsentStatus", "messagesOptimized", "getMessagesOptimized", "setMessagesOptimized", "messagesOptimizedLocalState", "getMessagesOptimizedLocalState", "setMessagesOptimizedLocalState", "metaDataResp", "getMetaDataResp", "setMetaDataResp", "nonKeyedLocalState", "getNonKeyedLocalState", "setNonKeyedLocalState", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "propertyId", "", "getPropertyId", "()I", "setPropertyId", "(I)V", "savedConsent", "getSavedConsent", "setSavedConsent", "(Z)V", "usNatApplies", "getUsNatApplies", "clearAll", "", "getLocalState", "saveLocalState", "value", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DataStorage extends DataStorageGdpr, DataStorageCcpa, DataStorageUSNat {
    public static final String CCPA_CONSENT_STATUS = "sp.ccpa.key.consent.status";
    public static final String CHOICE_RESP = "sp.key.choice";
    public static final String CONSENT_STATUS = "sp.key.consent.status";
    public static final String CONSENT_STATUS_RESPONSE = "sp.key.consent.status.response";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DATA_RECORDED_CONSENT = "sp.key.data.recorded.consent";
    public static final String GDPR_CONSENT_STATUS = "sp.gdpr.key.consent.status";
    public static final String KEY_PROPERTY_ID = "sp.key.config.propertyId";
    public static final int LOCAL_DATA_VERSION_HARDCODED_VALUE = 1;
    public static final String LOCAL_DATA_VERSION_KEY = "sp.key.localDataVersion";
    public static final String LOCAL_STATE = "sp.key.local.state";
    public static final String LOCAL_STATE_OLD = "key_local_state";
    public static final String MESSAGES_OPTIMIZED = "sp.key.messages";
    public static final String MESSAGES_OPTIMIZED_LOCAL_STATE = "sp.key.messages.v7.local.state";
    public static final String META_DATA_RESP = "sp.key.meta.data";
    public static final String NON_KEYED_LOCAL_STATE = "sp.key.messages.v7.nonKeyedLocalState";
    public static final String PV_DATA_RESP = "sp.key.pv.data";
    public static final String SAVED_CONSENT = "sp.key.saved.consent";

    void clearAll();

    boolean getCcpaApplies();

    String getCcpaConsentStatus();

    String getChoiceResp();

    String getConsentStatus();

    String getConsentStatusResponse();

    String getDataRecordedConsent();

    boolean getGdprApplies();

    String getGdprConsentStatus();

    String getLocalState();

    String getMessagesOptimized();

    String getMessagesOptimizedLocalState();

    String getMetaDataResp();

    String getNonKeyedLocalState();

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr, com.sourcepoint.cmplibrary.data.local.DataStorageCcpa, com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    SharedPreferences getPreference();

    int getPropertyId();

    boolean getSavedConsent();

    boolean getUsNatApplies();

    void saveLocalState(String value);

    void setCcpaConsentStatus(String str);

    void setChoiceResp(String str);

    void setConsentStatus(String str);

    void setConsentStatusResponse(String str);

    void setDataRecordedConsent(String str);

    void setGdprConsentStatus(String str);

    void setMessagesOptimized(String str);

    void setMessagesOptimizedLocalState(String str);

    void setMetaDataResp(String str);

    void setNonKeyedLocalState(String str);

    void setPropertyId(int i);

    void setSavedConsent(boolean z);

    /* compiled from: DataStorage.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorage$Companion;", "", "()V", "CCPA_CONSENT_STATUS", "", "CHOICE_RESP", "CONSENT_STATUS", "CONSENT_STATUS_RESPONSE", "DATA_RECORDED_CONSENT", "GDPR_CONSENT_STATUS", "KEY_PROPERTY_ID", "LOCAL_DATA_VERSION_HARDCODED_VALUE", "", "LOCAL_DATA_VERSION_KEY", "LOCAL_STATE", "LOCAL_STATE_OLD", "MESSAGES_OPTIMIZED", "MESSAGES_OPTIMIZED_LOCAL_STATE", "META_DATA_RESP", "NON_KEYED_LOCAL_STATE", "PV_DATA_RESP", "SAVED_CONSENT", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CCPA_CONSENT_STATUS = "sp.ccpa.key.consent.status";
        public static final String CHOICE_RESP = "sp.key.choice";
        public static final String CONSENT_STATUS = "sp.key.consent.status";
        public static final String CONSENT_STATUS_RESPONSE = "sp.key.consent.status.response";
        public static final String DATA_RECORDED_CONSENT = "sp.key.data.recorded.consent";
        public static final String GDPR_CONSENT_STATUS = "sp.gdpr.key.consent.status";
        public static final String KEY_PROPERTY_ID = "sp.key.config.propertyId";
        public static final int LOCAL_DATA_VERSION_HARDCODED_VALUE = 1;
        public static final String LOCAL_DATA_VERSION_KEY = "sp.key.localDataVersion";
        public static final String LOCAL_STATE = "sp.key.local.state";
        public static final String LOCAL_STATE_OLD = "key_local_state";
        public static final String MESSAGES_OPTIMIZED = "sp.key.messages";
        public static final String MESSAGES_OPTIMIZED_LOCAL_STATE = "sp.key.messages.v7.local.state";
        public static final String META_DATA_RESP = "sp.key.meta.data";
        public static final String NON_KEYED_LOCAL_STATE = "sp.key.messages.v7.nonKeyedLocalState";
        public static final String PV_DATA_RESP = "sp.key.pv.data";
        public static final String SAVED_CONSENT = "sp.key.saved.consent";

        private Companion() {
        }
    }
}
