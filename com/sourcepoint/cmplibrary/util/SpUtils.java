package com.sourcepoint.cmplibrary.util;

import android.content.Context;
import com.sourcepoint.cmplibrary.SpCacheObjet;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.local.DataStorageCcpa;
import com.sourcepoint.cmplibrary.data.local.DataStorageCcpaKt;
import com.sourcepoint.cmplibrary.data.local.DataStorageGdpr;
import com.sourcepoint.cmplibrary.data.local.DataStorageGdprKt;
import com.sourcepoint.cmplibrary.data.local.DataStorageImplKt;
import com.sourcepoint.cmplibrary.data.local.DataStorageUSNat;
import com.sourcepoint.cmplibrary.data.local.DataStorageUSNatKt;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusApiModelExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.SPCCPAConsent;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SPGDPRConsent;
import com.sourcepoint.cmplibrary.model.exposed.SpUsNatConsent;
import com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;

/* compiled from: SpUtils.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DEFAULT_CCPA_USP_STRING", "", "campaignApplies", "", "context", "Landroid/content/Context;", "campaign", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "clearAllData", "", "updateCcpaUspString", "ccpaCS", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "userConsents", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpUtils {
    private static final String DEFAULT_CCPA_USP_STRING = "1---";

    /* compiled from: SpUtils.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CcpaStatus.values().length];
            try {
                iArr[CcpaStatus.rejectedAll.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CcpaStatus.rejectedSome.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CampaignType.values().length];
            try {
                iArr2[CampaignType.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CampaignType.CCPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CampaignType.USNAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ String updateCcpaUspString$default(CcpaCS ccpaCS, Logger logger, int i, Object obj) {
        if ((i & 2) != 0) {
            logger = null;
        }
        return updateCcpaUspString(ccpaCS, logger);
    }

    public static final String updateCcpaUspString(CcpaCS ccpaCS, Logger logger) {
        Boolean applies = ccpaCS != null ? ccpaCS.getApplies() : null;
        CcpaStatus status = ccpaCS != null ? ccpaCS.getStatus() : null;
        Boolean signedLspa = ccpaCS != null ? ccpaCS.getSignedLspa() : null;
        if (!Intrinsics.areEqual((Object) applies, (Object) true)) {
            if (logger != null) {
                logger.computation(" Ccpa UspString", StringsKt.trimIndent("\n                applies[" + applies + "]\n                1---\n            "));
                return DEFAULT_CCPA_USP_STRING;
            }
            return DEFAULT_CCPA_USP_STRING;
        }
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        String str = "N";
        String str2 = (i == 1 || i == 2) ? "Y" : "N";
        if (signedLspa != null && !Intrinsics.areEqual((Object) signedLspa, (Object) false)) {
            str = "Y";
        }
        String str3 = "1Y" + str2 + str;
        if (logger != null) {
            logger.computation(" Ccpa UspString", StringsKt.trimIndent("\n                spec Version[1] - oppToOptOut[Y]\n                ccpaStatus[" + status + "] => optOutSale[" + str2 + "]\n                signedLspa[" + signedLspa + "] => LspaCovTransac[" + str + "]\n                usPString[" + str3 + "]\n            "));
        }
        return str3;
    }

    public static final SPConsents userConsents(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final DataStorageGdpr dataStorageGdpr = (DataStorageGdpr) SpCacheObjet.INSTANCE.fetchOrStore(DataStorageGdpr.class, new Function0<DataStorageGdpr>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$dataStorageGdpr$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DataStorageGdpr invoke() {
                return DataStorageGdprKt.create(DataStorageGdpr.INSTANCE, context);
            }
        });
        final DataStorageCcpa dataStorageCcpa = (DataStorageCcpa) SpCacheObjet.INSTANCE.fetchOrStore(DataStorageCcpa.class, new Function0<DataStorageCcpa>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$dataStorageCcpa$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DataStorageCcpa invoke() {
                return DataStorageCcpaKt.create(DataStorageCcpa.INSTANCE, context);
            }
        });
        final DataStorageUSNat dataStorageUSNat = (DataStorageUSNat) SpCacheObjet.INSTANCE.fetchOrStore(DataStorageUSNat.class, new Function0<DataStorageUSNat>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$dataStorageUSNat$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DataStorageUSNat invoke() {
                return DataStorageUSNatKt.create(DataStorageUSNat.INSTANCE, context);
            }
        });
        return userConsents((DataStorage) SpCacheObjet.INSTANCE.fetchOrStore(DataStorage.class, new Function0<DataStorage>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$dataStorage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DataStorage invoke() {
                return DataStorageImplKt.create(DataStorage.INSTANCE, context, dataStorageGdpr, dataStorageCcpa, dataStorageUSNat);
            }
        }));
    }

    public static final boolean campaignApplies(Context context, CampaignType campaign) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(campaign, "campaign");
        DataStorage create = DataStorageImplKt.create(DataStorage.INSTANCE, context, DataStorageGdprKt.create(DataStorageGdpr.INSTANCE, context), DataStorageCcpaKt.create(DataStorageCcpa.INSTANCE, context), DataStorageUSNatKt.create(DataStorageUSNat.INSTANCE, context));
        int i = WhenMappings.$EnumSwitchMapping$1[campaign.ordinal()];
        if (i == 1) {
            return create.getGdprApplies();
        }
        if (i == 2) {
            return create.getCcpaApplies();
        }
        if (i == 3) {
            return create.getUsNatApplies();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void clearAllData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataStorageImplKt.create(DataStorage.INSTANCE, context, DataStorageGdprKt.create(DataStorageGdpr.INSTANCE, context), DataStorageCcpaKt.create(DataStorageCcpa.INSTANCE, context), DataStorageUSNatKt.create(DataStorageUSNat.INSTANCE, context)).clearAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        r0 = r3.copy((r32 & 1) != 0 ? r3.applies : java.lang.Boolean.valueOf(r31.getCcpaApplies()), (r32 & 2) != 0 ? r3.consentedAll : null, (r32 & 4) != 0 ? r3.dateCreated : null, (r32 & 8) != 0 ? r3.gpcEnabled : null, (r32 & 16) != 0 ? r3.newUser : null, (r32 & 32) != 0 ? r3.rejectedAll : null, (r32 & 64) != 0 ? r3.rejectedCategories : null, (r32 & 128) != 0 ? r3.rejectedVendors : null, (r32 & 256) != 0 ? r3.signedLspa : null, (r32 & 512) != 0 ? r3.uspstring : null, (r32 & 1024) != 0 ? r3.status : null, (r32 & 2048) != 0 ? r3.gppData : null, (r32 & 4096) != 0 ? r3.uuid : null, (r32 & 8192) != 0 ? r3.webConsentPayload : null, (r32 & 16384) != 0 ? r3.expirationDate : null);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SPConsents userConsents(DataStorage dataStorage) {
        SPCCPAConsent sPCCPAConsent;
        final String gdprConsentStatus;
        SPGDPRConsent sPGDPRConsent;
        final String usNatConsentData;
        Object obj;
        USNatConsentData copy$default;
        UsNatConsentInternal usNatConsentInternal;
        Object obj2;
        GdprCS copy$default2;
        GDPRConsentInternal gDPRUserConsent;
        Object obj3;
        CcpaCS copy;
        CCPAConsentInternal cCPAConsentInternal;
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        final String ccpaConsentStatus = dataStorage.getCcpaConsentStatus();
        SpUsNatConsent spUsNatConsent = null;
        if (ccpaConsentStatus != null) {
            Either check = FunctionalUtilsKt.check(new Function0<CcpaCS>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CcpaCS invoke() {
                    Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                    String str = ccpaConsentStatus;
                    converter.getSerializersModule();
                    return (CcpaCS) converter.decodeFromString(CcpaCS.INSTANCE.serializer(), str);
                }
            });
            if (check instanceof Either.Right) {
                obj3 = ((Either.Right) check).getR();
            } else {
                if (!(check instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj3 = null;
            }
            CcpaCS ccpaCS = (CcpaCS) obj3;
            if (ccpaCS != null && copy != null && (cCPAConsentInternal = ConsentStatusApiModelExtKt.toCCPAConsentInternal(copy)) != null) {
                sPCCPAConsent = new SPCCPAConsent(cCPAConsentInternal);
                gdprConsentStatus = dataStorage.getGdprConsentStatus();
                if (gdprConsentStatus != null) {
                    Either check2 = FunctionalUtilsKt.check(new Function0<GdprCS>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GdprCS invoke() {
                            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                            String str = gdprConsentStatus;
                            converter.getSerializersModule();
                            return (GdprCS) converter.decodeFromString(GdprCS.INSTANCE.serializer(), str);
                        }
                    });
                    if (check2 instanceof Either.Right) {
                        obj2 = ((Either.Right) check2).getR();
                    } else {
                        if (!(check2 instanceof Either.Left)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        obj2 = null;
                    }
                    GdprCS gdprCS = (GdprCS) obj2;
                    if (gdprCS != null && (copy$default2 = GdprCS.copy$default(gdprCS, Boolean.valueOf(dataStorage.getGdprApplies()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null)) != null && (gDPRUserConsent = ConsentStatusApiModelExtKt.toGDPRUserConsent(copy$default2)) != null) {
                        sPGDPRConsent = new SPGDPRConsent(gDPRUserConsent);
                        usNatConsentData = dataStorage.getUsNatConsentData();
                        if (usNatConsentData != null) {
                            Either check3 = FunctionalUtilsKt.check(new Function0<USNatConsentData>() { // from class: com.sourcepoint.cmplibrary.util.SpUtils$userConsents$5$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final USNatConsentData invoke() {
                                    Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                                    String str = usNatConsentData;
                                    converter.getSerializersModule();
                                    return (USNatConsentData) converter.decodeFromString(USNatConsentData.INSTANCE.serializer(), str);
                                }
                            });
                            if (check3 instanceof Either.Right) {
                                obj = ((Either.Right) check3).getR();
                            } else {
                                if (!(check3 instanceof Either.Left)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                obj = null;
                            }
                            USNatConsentData uSNatConsentData = (USNatConsentData) obj;
                            if (uSNatConsentData != null && (copy$default = USNatConsentData.copy$default(uSNatConsentData, Boolean.valueOf(dataStorage.getUsNatApplies()), null, null, null, null, null, null, null, null, null, null, null, null, 8190, null)) != null && (usNatConsentInternal = ConsentStatusApiModelExtKt.toUsNatConsentInternal(copy$default)) != null) {
                                spUsNatConsent = new SpUsNatConsent(usNatConsentInternal);
                            }
                        }
                        return new SPConsents(sPGDPRConsent, sPCCPAConsent, spUsNatConsent);
                    }
                }
                sPGDPRConsent = null;
                usNatConsentData = dataStorage.getUsNatConsentData();
                if (usNatConsentData != null) {
                }
                return new SPConsents(sPGDPRConsent, sPCCPAConsent, spUsNatConsent);
            }
        }
        sPCCPAConsent = null;
        gdprConsentStatus = dataStorage.getGdprConsentStatus();
        if (gdprConsentStatus != null) {
        }
        sPGDPRConsent = null;
        usNatConsentData = dataStorage.getUsNatConsentData();
        if (usNatConsentData != null) {
        }
        return new SPConsents(sPGDPRConsent, sPCCPAConsent, spUsNatConsent);
    }
}
