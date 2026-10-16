package com.unity3d.ads.core.configuration;

import com.ironsource.C3040d4;
import com.unity3d.services.core.misc.JsonStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MediationTraitsMetadataReader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;", "Lcom/unity3d/ads/core/configuration/MetadataReader;", "Lorg/json/JSONObject;", "jsonStorage", "Lcom/unity3d/services/core/misc/JsonStorage;", "(Lcom/unity3d/services/core/misc/JsonStorage;)V", "getBooleanTrait", "", C3040d4.h.W, "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MediationTraitsMetadataReader extends MetadataReader<JSONObject> {
    public static final String BOLD_SDK_ENABLED = "boldSdkEnabled";
    public static final String MEDIATION_TRAITS = "mediation.traits.value";
    public static final String USE_REFACTORED_HTTP_CLIENT = "useRefactoredHttpClient";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediationTraitsMetadataReader(JsonStorage jsonStorage) {
        super(jsonStorage, MEDIATION_TRAITS);
        Intrinsics.checkNotNullParameter(jsonStorage, "jsonStorage");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean getBooleanTrait(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MediationTraitsMetadataReader mediationTraitsMetadataReader = this;
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
            if (!jSONObject.has(key)) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Boolean.valueOf(jSONObject.optBoolean(key));
            }
        }
        return null;
    }
}
