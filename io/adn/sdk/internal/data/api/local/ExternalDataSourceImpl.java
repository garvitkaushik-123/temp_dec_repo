package io.adn.sdk.internal.data.api.local;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.adn.sdk.internal.domain.model.config.SdkParameterKey;
import io.adn.sdk.internal.domain.model.privacy.PrivacyInfo;
import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import io.adn.sdk.publisher.AdnMediationType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ExternalDataSource.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120%H\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010%H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0012H\u0016J#\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010+\u001a\u0002H*H\u0016¢\u0006\u0002\u0010,J\n\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f¨\u0006."}, d2 = {"Lio/adn/sdk/internal/data/api/local/ExternalDataSourceImpl;", "Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "<init>", "()V", "privacyInfo", "Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;", "getPrivacyInfo", "()Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;", "setPrivacyInfo", "(Lio/adn/sdk/internal/domain/model/privacy/PrivacyInfo;)V", "publisherSignalsJson", "", "getPublisherSignalsJson", "()Ljava/lang/String;", "setPublisherSignalsJson", "(Ljava/lang/String;)V", "publisherSignalsMap", "", "", "sdkParameters", "Lio/adn/sdk/internal/domain/model/config/SdkParameterKey;", "mediationType", "Lio/adn/sdk/publisher/AdnMediationType;", "getMediationType", "()Lio/adn/sdk/publisher/AdnMediationType;", "setMediationType", "(Lio/adn/sdk/publisher/AdnMediationType;)V", "isTestMode", "", "()Z", "setTestMode", "(Z)V", "isAdsMuted", "setAdsMuted", "setPublisherSignals", "", "signals", "", "setSdkParameter", C3040d4.h.W, "value", "getSdkParameter", "T", "defaultValue", "(Lio/adn/sdk/internal/domain/model/config/SdkParameterKey;Ljava/lang/Object;)Ljava/lang/Object;", "logExternalData", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ExternalDataSourceImpl implements ExternalDataSource {
    public static final int $stable = 8;
    private boolean isAdsMuted;
    private boolean isTestMode;
    private AdnMediationType mediationType;
    private PrivacyInfo privacyInfo = new PrivacyInfo();
    private String publisherSignalsJson;
    private Map<String, Object> publisherSignalsMap;
    private final Map<SdkParameterKey, Object> sdkParameters;

    /* compiled from: ExternalDataSource.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SdkParameterKey.values().length];
            try {
                iArr[SdkParameterKey.DIAGNOSTIC_SAMPLING_PERCENTAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SdkParameterKey.ENABLE_SELF_ATTRIBUTION_TRACKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ExternalDataSourceImpl() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SdkParameterKey.DIAGNOSTIC_SAMPLING_PERCENTAGE, 5);
        linkedHashMap.put(SdkParameterKey.ENABLE_SELF_ATTRIBUTION_TRACKING, false);
        this.sdkParameters = linkedHashMap;
        this.mediationType = AdnMediationType.NONE;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public PrivacyInfo getPrivacyInfo() {
        return this.privacyInfo;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setPrivacyInfo(PrivacyInfo privacyInfo) {
        Intrinsics.checkNotNullParameter(privacyInfo, "<set-?>");
        this.privacyInfo = privacyInfo;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public String getPublisherSignalsJson() {
        return this.publisherSignalsJson;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setPublisherSignalsJson(String str) {
        this.publisherSignalsJson = str;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public AdnMediationType getMediationType() {
        return this.mediationType;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setMediationType(AdnMediationType adnMediationType) {
        Intrinsics.checkNotNullParameter(adnMediationType, "<set-?>");
        this.mediationType = adnMediationType;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    /* renamed from: isTestMode, reason: from getter */
    public boolean getIsTestMode() {
        return this.isTestMode;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setTestMode(boolean z) {
        this.isTestMode = z;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    /* renamed from: isAdsMuted, reason: from getter */
    public boolean getIsAdsMuted() {
        return this.isAdsMuted;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setAdsMuted(boolean z) {
        this.isAdsMuted = z;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setPublisherSignals(Map<String, ? extends Object> signals) {
        Intrinsics.checkNotNullParameter(signals, "signals");
        LinkedHashMap linkedHashMap = this.publisherSignalsMap;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        linkedHashMap.putAll(signals);
        this.publisherSignalsMap = linkedHashMap;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public Map<String, Object> publisherSignalsMap() {
        return this.publisherSignalsMap;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public void setSdkParameter(String key, Object value) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Iterator<E> it = SdkParameterKey.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((SdkParameterKey) obj).getKey(), key)) {
                    break;
                }
            }
        }
        SdkParameterKey sdkParameterKey = (SdkParameterKey) obj;
        if (sdkParameterKey == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[sdkParameterKey.ordinal()];
        if (i == 1) {
            if (value instanceof Integer) {
                this.sdkParameters.put(sdkParameterKey, value);
            }
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (value instanceof Boolean) {
                this.sdkParameters.put(sdkParameterKey, value);
            }
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public <T> T getSdkParameter(SdkParameterKey key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this.sdkParameters.get(key);
        if (t == null) {
            t = null;
        }
        return t == null ? defaultValue : t;
    }

    @Override // io.adn.sdk.internal.domain.repository.ExternalDataSource
    public String logExternalData() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ExternalDataSourceImpl externalDataSourceImpl = this;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, "4.25.2");
            jSONObject.put("mediation_type", getMediationType().getValue());
            jSONObject.put("test_ads_enabled", getIsTestMode());
            jSONObject.put("consent_given", getPrivacyInfo().getHasUserConsent());
            jSONObject.put("do_not_sell", getPrivacyInfo().getDoNotSell());
            jSONObject.put("extra_parameters", getPublisherSignalsJson());
            for (Map.Entry<SdkParameterKey, Object> entry : this.sdkParameters.entrySet()) {
                SdkParameterKey key = entry.getKey();
                jSONObject.put(key.getKey(), entry.getValue());
            }
            Map<String, Object> map = this.publisherSignalsMap;
            if (map != null) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    jSONObject.put(entry2.getKey(), entry2.getValue());
                }
            }
            m10241constructorimpl = Result.m10241constructorimpl(jSONObject.toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        return (String) m10241constructorimpl;
    }
}
