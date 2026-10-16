package com.sourcepoint.cmplibrary.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: DataStorageImpl.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0006\n\u0002\b<\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0019\b\u0002\u0018\u0000 µ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002µ\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\n\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u000b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010\u009f\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010 \u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010¡\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010¢\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010£\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010¤\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\u000b\u0010¥\u0001\u001a\u00030\u009d\u0001H\u0096\u0001J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\n\u0010©\u0001\u001a\u00020\u0010H\u0096\u0001J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\n\u0010¬\u0001\u001a\u00020\u0010H\u0096\u0001J\u000b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\u0015\u0010®\u0001\u001a\u00030\u009d\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0013\u0010¯\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010°\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010±\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010²\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010³\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010´\u0001\u001a\u00030\u009d\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010%\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u0018\u0010(\u001a\u00020)X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u0004\u0018\u00010\fX\u0096\u000f¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R(\u00106\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R(\u00109\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R(\u0010<\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R(\u0010?\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u000eR\u001a\u0010J\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\bK\u0010\u0012\"\u0004\bL\u0010\u0014R(\u0010M\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0012\"\u0004\bO\u0010\u0014R\u001a\u0010P\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\bQ\u0010\u0012\"\u0004\bR\u0010\u0014R\u001a\u0010S\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\bT\u0010\u0012\"\u0004\bU\u0010\u0014R\u001a\u0010V\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\bW\u0010\u0012\"\u0004\bX\u0010\u0014R\u001a\u0010Y\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\bZ\u0010\u0012\"\u0004\b[\u0010\u0014R\u001a\u0010\\\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\f\u001a\u0004\b]\u0010\u0012\"\u0004\b^\u0010\u0014R\u0018\u0010_\u001a\u00020)X\u0096\u000f¢\u0006\f\u001a\u0004\b`\u0010+\"\u0004\ba\u0010-R\u001a\u0010b\u001a\u0004\u0018\u00010\fX\u0096\u000f¢\u0006\f\u001a\u0004\bc\u00100\"\u0004\bd\u00102R(\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010g\u0018\u00010fX\u0096\u000f¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR(\u0010l\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bm\u0010\u0012\"\u0004\bn\u0010\u0014R(\u0010o\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bp\u0010\u0012\"\u0004\bq\u0010\u0014R(\u0010r\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bs\u0010\u0012\"\u0004\bt\u0010\u0014R(\u0010u\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bv\u0010\u0012\"\u0004\bw\u0010\u0014R\u001b\u0010x\u001a\u00020y8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\bz\u0010{R(\u0010\u007f\u001a\u00020~2\u0006\u0010\u0015\u001a\u00020~8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R(\u0010\u0084\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b\u0085\u0001\u0010\u000e\"\u0006\b\u0086\u0001\u0010\u0087\u0001R)\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010g0fX\u0096\u000f¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010i\"\u0005\b\u008a\u0001\u0010kR\u0016\u0010\u008b\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u000eR\u001d\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010\u0012\"\u0005\b\u008f\u0001\u0010\u0014R\u001d\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0005\b\u0092\u0001\u0010\u0014R\u001b\u0010\u0093\u0001\u001a\u00020)X\u0096\u000f¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010+\"\u0005\b\u0095\u0001\u0010-R\u001d\u0010\u0096\u0001\u001a\u0004\u0018\u00010\fX\u0096\u000f¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u00100\"\u0005\b\u0098\u0001\u00102R\u001d\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0010X\u0096\u000f¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u0010\u0012\"\u0005\b\u009b\u0001\u0010\u0014¨\u0006¶\u0001"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageImpl;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "context", "Landroid/content/Context;", "dsGdpr", "dsCcpa", "dsUsNat", "(Landroid/content/Context;Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;)V", "ccpaApplies", "", "getCcpaApplies", "()Z", "ccpaChildPmId", "", "getCcpaChildPmId", "()Ljava/lang/String;", "setCcpaChildPmId", "(Ljava/lang/String;)V", "value", "ccpaConsentStatus", "getCcpaConsentStatus", "setCcpaConsentStatus", "ccpaConsentUuid", "getCcpaConsentUuid", "setCcpaConsentUuid", "ccpaDateCreated", "getCcpaDateCreated", "setCcpaDateCreated", "ccpaExpirationDate", "getCcpaExpirationDate", "setCcpaExpirationDate", "ccpaMessageMetaData", "getCcpaMessageMetaData", "setCcpaMessageMetaData", "ccpaPostChoiceResp", "getCcpaPostChoiceResp", "setCcpaPostChoiceResp", "ccpaSampleRate", "", "getCcpaSampleRate", "()D", "setCcpaSampleRate", "(D)V", "ccpaSampled", "getCcpaSampled", "()Ljava/lang/Boolean;", "setCcpaSampled", "(Ljava/lang/Boolean;)V", "ccpaStatus", "getCcpaStatus", "setCcpaStatus", "choiceResp", "getChoiceResp", "setChoiceResp", "consentStatus", "getConsentStatus", "setConsentStatus", "consentStatusResponse", "getConsentStatusResponse", "setConsentStatusResponse", "dataRecordedConsent", "getDataRecordedConsent", "setDataRecordedConsent", "getDsCcpa", "()Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "getDsGdpr", "()Lcom/sourcepoint/cmplibrary/data/local/DataStorageGdpr;", "getDsUsNat", "()Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;", "gdprApplies", "getGdprApplies", "gdprChildPmId", "getGdprChildPmId", "setGdprChildPmId", C3040d4.i.a0, "getGdprConsentStatus", "setGdprConsentStatus", "gdprConsentUuid", "getGdprConsentUuid", "setGdprConsentUuid", "gdprDateCreated", "getGdprDateCreated", "setGdprDateCreated", "gdprExpirationDate", "getGdprExpirationDate", "setGdprExpirationDate", "gdprMessageMetaData", "getGdprMessageMetaData", "setGdprMessageMetaData", "gdprPostChoiceResp", "getGdprPostChoiceResp", "setGdprPostChoiceResp", "gdprSampleRate", "getGdprSampleRate", "setGdprSampleRate", "gdprSampled", "getGdprSampled", "setGdprSampled", "gppData", "", "", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "messagesOptimized", "getMessagesOptimized", "setMessagesOptimized", "messagesOptimizedLocalState", "getMessagesOptimizedLocalState", "setMessagesOptimizedLocalState", "metaDataResp", "getMetaDataResp", "setMetaDataResp", "nonKeyedLocalState", "getNonKeyedLocalState", "setNonKeyedLocalState", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "preference$delegate", "Lkotlin/Lazy;", "", "propertyId", "getPropertyId", "()I", "setPropertyId", "(I)V", "savedConsent", "getSavedConsent", "setSavedConsent", "(Z)V", "tcData", "getTcData", "setTcData", "usNatApplies", "getUsNatApplies", "usNatConsentData", "getUsNatConsentData", "setUsNatConsentData", "usnatChildPmId", "getUsnatChildPmId", "setUsnatChildPmId", "usnatSampleRate", "getUsnatSampleRate", "setUsnatSampleRate", "usnatSampled", "getUsnatSampled", "setUsnatSampled", "uspstring", "getUspstring", "setUspstring", "clearAll", "", "clearCcpaConsent", "clearGdprConsent", "clearGppData", "clearInternalData", "clearTCData", "deleteCcpaConsent", "deleteGdprConsent", "deleteUsNatConsent", "getAuthId", "getCcpa", "getCcpaConsentResp", "getCcpaMessage", "getGdpr", "getGdprConsentResp", "getGdprMessage", "getLocalState", "saveAuthId", "saveCcpa", "saveCcpaConsentResp", "saveCcpaMessage", "saveGdpr", "saveGdprConsentResp", "saveLocalState", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DataStorageImpl implements DataStorage, DataStorageGdpr, DataStorageUSNat, DataStorageCcpa {
    private final DataStorageCcpa dsCcpa;
    private final DataStorageGdpr dsGdpr;
    private final DataStorageUSNat dsUsNat;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void clearCcpaConsent() {
        this.dsCcpa.clearCcpaConsent();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void clearGdprConsent() {
        this.dsGdpr.clearGdprConsent();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void clearGppData() {
        this.dsCcpa.clearGppData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void clearInternalData() {
        this.dsGdpr.clearInternalData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void clearTCData() {
        this.dsGdpr.clearTCData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void deleteCcpaConsent() {
        this.dsCcpa.deleteCcpaConsent();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void deleteGdprConsent() {
        this.dsGdpr.deleteGdprConsent();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void deleteUsNatConsent() {
        this.dsUsNat.deleteUsNatConsent();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getAuthId() {
        return this.dsGdpr.getAuthId();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpa() {
        return this.dsCcpa.getCcpa();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaChildPmId() {
        return this.dsCcpa.getCcpaChildPmId();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaConsentResp() {
        return this.dsCcpa.getCcpaConsentResp();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaConsentUuid() {
        return this.dsCcpa.getCcpaConsentUuid();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaDateCreated() {
        return this.dsCcpa.getCcpaDateCreated();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaExpirationDate() {
        return this.dsCcpa.getCcpaExpirationDate();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaMessage() {
        return this.dsCcpa.getCcpaMessage();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaMessageMetaData() {
        return this.dsCcpa.getCcpaMessageMetaData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaPostChoiceResp() {
        return this.dsCcpa.getCcpaPostChoiceResp();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public double getCcpaSampleRate() {
        return this.dsCcpa.getCcpaSampleRate();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public Boolean getCcpaSampled() {
        return this.dsCcpa.getCcpaSampled();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getCcpaStatus() {
        return this.dsCcpa.getCcpaStatus();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdpr() {
        return this.dsGdpr.getGdpr();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprChildPmId() {
        return this.dsGdpr.getGdprChildPmId();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprConsentResp() {
        return this.dsGdpr.getGdprConsentResp();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprConsentUuid() {
        return this.dsGdpr.getGdprConsentUuid();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprDateCreated() {
        return this.dsGdpr.getGdprDateCreated();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprExpirationDate() {
        return this.dsGdpr.getGdprExpirationDate();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprMessage() {
        return this.dsGdpr.getGdprMessage();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprMessageMetaData() {
        return this.dsGdpr.getGdprMessageMetaData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public String getGdprPostChoiceResp() {
        return this.dsGdpr.getGdprPostChoiceResp();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public double getGdprSampleRate() {
        return this.dsGdpr.getGdprSampleRate();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public Boolean getGdprSampled() {
        return this.dsGdpr.getGdprSampled();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public Map<String, Object> getGppData() {
        return this.dsCcpa.getGppData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public Map<String, Object> getTcData() {
        return this.dsGdpr.getTcData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public String getUsNatConsentData() {
        return this.dsUsNat.getUsNatConsentData();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public String getUsnatChildPmId() {
        return this.dsUsNat.getUsnatChildPmId();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public double getUsnatSampleRate() {
        return this.dsUsNat.getUsnatSampleRate();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public Boolean getUsnatSampled() {
        return this.dsUsNat.getUsnatSampled();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public String getUspstring() {
        return this.dsCcpa.getUspstring();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void saveAuthId(String value) {
        this.dsGdpr.saveAuthId(value);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void saveCcpa(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.dsCcpa.saveCcpa(value);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void saveCcpaConsentResp(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.dsCcpa.saveCcpaConsentResp(value);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void saveCcpaMessage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.dsCcpa.saveCcpaMessage(value);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void saveGdpr(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.dsGdpr.saveGdpr(value);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void saveGdprConsentResp(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.dsGdpr.saveGdprConsentResp(value);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaChildPmId(String str) {
        this.dsCcpa.setCcpaChildPmId(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaConsentUuid(String str) {
        this.dsCcpa.setCcpaConsentUuid(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaDateCreated(String str) {
        this.dsCcpa.setCcpaDateCreated(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaExpirationDate(String str) {
        this.dsCcpa.setCcpaExpirationDate(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaMessageMetaData(String str) {
        this.dsCcpa.setCcpaMessageMetaData(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaPostChoiceResp(String str) {
        this.dsCcpa.setCcpaPostChoiceResp(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaSampleRate(double d) {
        this.dsCcpa.setCcpaSampleRate(d);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaSampled(Boolean bool) {
        this.dsCcpa.setCcpaSampled(bool);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setCcpaStatus(String str) {
        this.dsCcpa.setCcpaStatus(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprChildPmId(String str) {
        this.dsGdpr.setGdprChildPmId(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprConsentUuid(String str) {
        this.dsGdpr.setGdprConsentUuid(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprDateCreated(String str) {
        this.dsGdpr.setGdprDateCreated(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprExpirationDate(String str) {
        this.dsGdpr.setGdprExpirationDate(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprMessageMetaData(String str) {
        this.dsGdpr.setGdprMessageMetaData(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprPostChoiceResp(String str) {
        this.dsGdpr.setGdprPostChoiceResp(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprSampleRate(double d) {
        this.dsGdpr.setGdprSampleRate(d);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setGdprSampled(Boolean bool) {
        this.dsGdpr.setGdprSampled(bool);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setGppData(Map<String, ? extends Object> map) {
        this.dsCcpa.setGppData(map);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageGdpr
    public void setTcData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.dsGdpr.setTcData(map);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsNatConsentData(String str) {
        this.dsUsNat.setUsNatConsentData(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsnatChildPmId(String str) {
        this.dsUsNat.setUsnatChildPmId(str);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsnatSampleRate(double d) {
        this.dsUsNat.setUsnatSampleRate(d);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public void setUsnatSampled(Boolean bool) {
        this.dsUsNat.setUsnatSampled(bool);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorageCcpa
    public void setUspstring(String str) {
        this.dsCcpa.setUspstring(str);
    }

    public DataStorageImpl(final Context context, DataStorageGdpr dsGdpr, DataStorageCcpa dsCcpa, DataStorageUSNat dsUsNat) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dsGdpr, "dsGdpr");
        Intrinsics.checkNotNullParameter(dsCcpa, "dsCcpa");
        Intrinsics.checkNotNullParameter(dsUsNat, "dsUsNat");
        this.dsGdpr = dsGdpr;
        this.dsCcpa = dsCcpa;
        this.dsUsNat = dsUsNat;
        this.preference = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageImpl$preference$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return PreferenceManager.getDefaultSharedPreferences(context);
            }
        });
    }

    public final DataStorageGdpr getDsGdpr() {
        return this.dsGdpr;
    }

    public final DataStorageCcpa getDsCcpa() {
        return this.dsCcpa;
    }

    public final DataStorageUSNat getDsUsNat() {
        return this.dsUsNat;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage, com.sourcepoint.cmplibrary.data.local.DataStorageGdpr, com.sourcepoint.cmplibrary.data.local.DataStorageCcpa, com.sourcepoint.cmplibrary.data.local.DataStorageUSNat
    public SharedPreferences getPreference() {
        Object value = this.preference.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public boolean getSavedConsent() {
        return getPreference().getBoolean("sp.key.saved.consent", false);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setSavedConsent(boolean z) {
        getPreference().edit().putBoolean("sp.key.saved.consent", z).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getMessagesOptimized() {
        return getPreference().getString("sp.key.messages", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setMessagesOptimized(String str) {
        getPreference().edit().putString("sp.key.messages", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getConsentStatusResponse() {
        return getPreference().getString("sp.key.consent.status.response", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setConsentStatusResponse(String str) {
        getPreference().edit().putString("sp.key.consent.status.response", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getGdprConsentStatus() {
        return getPreference().getString("sp.gdpr.key.consent.status", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setGdprConsentStatus(String str) {
        getPreference().edit().putString("sp.gdpr.key.consent.status", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public boolean getCcpaApplies() {
        Object obj;
        Boolean applies;
        final String metaDataResp = getMetaDataResp();
        if (metaDataResp == null) {
            return false;
        }
        Either check = FunctionalUtilsKt.check(new Function0<MetaDataResp.Ccpa>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageImpl$ccpaApplies$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataResp.Ccpa invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.Companion);
                String str = metaDataResp;
                converter.getSerializersModule();
                return ((MetaDataResp) converter.decodeFromString(MetaDataResp.INSTANCE.serializer(), str)).getCcpa();
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        MetaDataResp.Ccpa ccpa = (MetaDataResp.Ccpa) obj;
        if (ccpa == null || (applies = ccpa.getApplies()) == null) {
            return false;
        }
        return applies.booleanValue();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public boolean getUsNatApplies() {
        Object obj;
        Boolean applies;
        final String metaDataResp = getMetaDataResp();
        if (metaDataResp == null) {
            return false;
        }
        Either check = FunctionalUtilsKt.check(new Function0<MetaDataResp.USNat>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageImpl$usNatApplies$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataResp.USNat invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.Companion);
                String str = metaDataResp;
                converter.getSerializersModule();
                return ((MetaDataResp) converter.decodeFromString(MetaDataResp.INSTANCE.serializer(), str)).getUsNat();
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        MetaDataResp.USNat uSNat = (MetaDataResp.USNat) obj;
        if (uSNat == null || (applies = uSNat.getApplies()) == null) {
            return false;
        }
        return applies.booleanValue();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public boolean getGdprApplies() {
        Object obj;
        Boolean applies;
        final String metaDataResp = getMetaDataResp();
        if (metaDataResp == null) {
            return false;
        }
        Either check = FunctionalUtilsKt.check(new Function0<MetaDataResp.Gdpr>() { // from class: com.sourcepoint.cmplibrary.data.local.DataStorageImpl$gdprApplies$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataResp.Gdpr invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.Companion);
                String str = metaDataResp;
                converter.getSerializersModule();
                return ((MetaDataResp) converter.decodeFromString(MetaDataResp.INSTANCE.serializer(), str)).getGdpr();
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        MetaDataResp.Gdpr gdpr = (MetaDataResp.Gdpr) obj;
        if (gdpr == null || (applies = gdpr.getApplies()) == null) {
            return false;
        }
        return applies.booleanValue();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getCcpaConsentStatus() {
        return getPreference().getString("sp.ccpa.key.consent.status", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setCcpaConsentStatus(String str) {
        getPreference().edit().putString("sp.ccpa.key.consent.status", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getMessagesOptimizedLocalState() {
        return getPreference().getString("sp.key.messages.v7.local.state", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setMessagesOptimizedLocalState(String str) {
        getPreference().edit().putString("sp.key.messages.v7.local.state", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getNonKeyedLocalState() {
        return getPreference().getString("sp.key.messages.v7.nonKeyedLocalState", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setNonKeyedLocalState(String str) {
        getPreference().edit().putString("sp.key.messages.v7.nonKeyedLocalState", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public int getPropertyId() {
        return getPreference().getInt("sp.key.config.propertyId", 0);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setPropertyId(int i) {
        getPreference().edit().putInt("sp.key.config.propertyId", i).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getConsentStatus() {
        return getPreference().getString("sp.key.consent.status", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setConsentStatus(String str) {
        getPreference().edit().putString("sp.key.consent.status", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getMetaDataResp() {
        return getPreference().getString("sp.key.meta.data", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setMetaDataResp(String str) {
        getPreference().edit().putString("sp.key.meta.data", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getChoiceResp() {
        return getPreference().getString("sp.key.choice", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setChoiceResp(String str) {
        getPreference().edit().putString("sp.key.choice", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getDataRecordedConsent() {
        return getPreference().getString("sp.key.data.recorded.consent", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void setDataRecordedConsent(String str) {
        getPreference().edit().putString("sp.key.data.recorded.consent", str).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void saveLocalState(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        getPreference().edit().putString("sp.key.local.state", value).apply();
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public String getLocalState() {
        return getPreference().getString("sp.key.local.state", null);
    }

    @Override // com.sourcepoint.cmplibrary.data.local.DataStorage
    public void clearAll() {
        this.dsCcpa.deleteCcpaConsent();
        this.dsGdpr.deleteGdprConsent();
        this.dsUsNat.deleteUsNatConsent();
        getPreference().edit().remove("sp.key.local.state").remove("key_local_state").remove("sp.key.localDataVersion").remove("sp.key.saved.consent").remove("sp.key.messages").remove("sp.key.meta.data").remove("sp.key.pv.data").remove("sp.key.choice").remove("sp.key.data.recorded.consent").remove("sp.key.consent.status.response").remove("sp.gdpr.key.consent.status").remove("sp.key.consent.status").remove("sp.ccpa.key.consent.status").remove("sp.key.messages.v7.local.state").remove("sp.key.messages.v7.nonKeyedLocalState").remove("sp.key.config.propertyId").apply();
    }
}
