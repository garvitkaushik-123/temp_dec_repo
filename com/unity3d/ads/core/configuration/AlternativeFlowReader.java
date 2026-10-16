package com.unity3d.ads.core.configuration;

import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.configuration.ConfigurationReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: AlternativeFlowReader.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u000bH\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "", "configurationReader", "Lcom/unity3d/services/core/configuration/ConfigurationReader;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "mediationMetadataReader", "Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;", "(Lcom/unity3d/services/core/configuration/ConfigurationReader;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;)V", "isAlternativeFlowEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isAlternativeFlowRead", "invoke", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public class AlternativeFlowReader {
    private final ConfigurationReader configurationReader;
    private final MutableStateFlow<Boolean> isAlternativeFlowEnabled;
    private final MutableStateFlow<Boolean> isAlternativeFlowRead;
    private final MediationTraitsMetadataReader mediationMetadataReader;
    private final SessionRepository sessionRepository;

    public AlternativeFlowReader(ConfigurationReader configurationReader, SessionRepository sessionRepository, MediationTraitsMetadataReader mediationMetadataReader) {
        Intrinsics.checkNotNullParameter(configurationReader, "configurationReader");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(mediationMetadataReader, "mediationMetadataReader");
        this.configurationReader = configurationReader;
        this.sessionRepository = sessionRepository;
        this.mediationMetadataReader = mediationMetadataReader;
        this.isAlternativeFlowRead = StateFlowKt.MutableStateFlow(false);
        this.isAlternativeFlowEnabled = StateFlowKt.MutableStateFlow(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke() {
        if (this.isAlternativeFlowRead.getValue().booleanValue()) {
            return this.isAlternativeFlowEnabled.getValue().booleanValue();
        }
        MediationTraitsMetadataReader mediationTraitsMetadataReader = this.mediationMetadataReader;
        Object obj = mediationTraitsMetadataReader.getJsonStorage().get(mediationTraitsMetadataReader.getKey());
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
            if (!(obj instanceof JSONObject)) {
                obj = null;
            }
        }
        obj = null;
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            JSONObject jSONObject2 = jSONObject.has(MediationTraitsMetadataReader.BOLD_SDK_ENABLED) ? jSONObject : null;
            if (jSONObject2 != null) {
                this.isAlternativeFlowEnabled.setValue(Boolean.valueOf(jSONObject2.optBoolean(MediationTraitsMetadataReader.BOLD_SDK_ENABLED)));
                this.isAlternativeFlowRead.setValue(true);
            }
        }
        if (!this.isAlternativeFlowRead.getValue().booleanValue()) {
            if (!this.configurationReader.getCurrentConfiguration().getExperiments().isBoldSdkNextSessionEnabled()) {
                this.isAlternativeFlowEnabled.setValue(false);
            } else {
                this.isAlternativeFlowEnabled.setValue(Boolean.valueOf(this.sessionRepository.getNativeConfiguration().getFeatureFlags().getBoldSdkNextSessionEnabled()));
            }
            this.isAlternativeFlowRead.setValue(true);
        }
        return this.isAlternativeFlowEnabled.getValue().booleanValue();
    }
}
