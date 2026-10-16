package io.bidmachine.ads.networks.adaptiverendering;

import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import io.bidmachine.core.UtilsKt;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmResult;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ProtoUtilsKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0000\u001a\u001a\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010*\u00020\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"KEY_ADAPTIVE_RENDERING_CONTEXT", "", "KEY_ALGORITHM", "KEY_ALGORITHMS", "KEY_COMPONENT", "KEY_DURATION", "KEY_NAME", "KEY_PHASE", "KEY_RESULT", "KEY_THRESHOLD", "KEY_WEIGHT", "toBMError", "Lio/bidmachine/utils/BMError;", "Lio/bidmachine/rendering/model/Error;", "baseBMError", "toEventParams", "", "", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "bidmachine-android-sdk_bh_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingAdapterKt {
    private static final String KEY_ADAPTIVE_RENDERING_CONTEXT = "adaptive_rendering_context";
    private static final String KEY_ALGORITHM = "algorithm";
    private static final String KEY_ALGORITHMS = "algorithms";
    private static final String KEY_COMPONENT = "component";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHASE = "phase";
    private static final String KEY_RESULT = "result";
    private static final String KEY_THRESHOLD = "threshold";
    private static final String KEY_WEIGHT = "weight";

    public static final BMError toBMError(Error error, BMError baseBMError) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        Intrinsics.checkNotNullParameter(baseBMError, "baseBMError");
        return new BMError(baseBMError, -1, error.getCom.bytedance.sdk.component.pglcrypt.PglCryptUtils.KEY_MESSAGE java.lang.String());
    }

    public static final Map<String, Object> toEventParams(BrokenCreativeEvent brokenCreativeEvent) {
        Intrinsics.checkNotNullParameter(brokenCreativeEvent, "<this>");
        try {
            ListValue mapNotNullToProtoListValue = ProtoUtilsKt.mapNotNullToProtoListValue(brokenCreativeEvent.getAlgorithmResults(), new Function1<BrokenCreativeAlgorithmResult, Value>() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingAdapterKt$toEventParams$algorithmsListValue$1
                @Override // kotlin.jvm.functions.Function1
                public final Value invoke(BrokenCreativeAlgorithmResult brokenCreativeAlgorithmResult) {
                    Intrinsics.checkNotNullParameter(brokenCreativeAlgorithmResult, "brokenCreativeAlgorithmResult");
                    BrokenCreativeAlgorithmParams algorithmParams = brokenCreativeAlgorithmResult.getAlgorithmParams();
                    Struct.Builder newBuilder = Struct.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                    Struct build = ProtoUtilsKt.putField(ProtoUtilsKt.putField(ProtoUtilsKt.putField(newBuilder, "name", algorithmParams.getType().getCom.ironsource.d4.h.W java.lang.String()), "weight", Float.valueOf(algorithmParams.getWeight())), "threshold", Float.valueOf(algorithmParams.getThreshold())).build();
                    Intrinsics.checkNotNullExpressionValue(build, "brokenCreativeAlgorithmR…build()\n                }");
                    Struct.Builder newBuilder2 = Struct.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
                    return ProtoUtilsKt.toProtoValue(ProtoUtilsKt.putField(ProtoUtilsKt.putField(ProtoUtilsKt.putField(newBuilder2, "algorithm", build), "result", Integer.valueOf(UtilsKt.convertToInt(brokenCreativeAlgorithmResult.getIsBroken()))), "duration", Long.valueOf(brokenCreativeAlgorithmResult.getDurationMs())));
                }
            });
            Struct.Builder newBuilder = Struct.newBuilder();
            Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
            Value protoValue = ProtoUtilsKt.toProtoValue(ProtoUtilsKt.putField(ProtoUtilsKt.putField(ProtoUtilsKt.putField(ProtoUtilsKt.putField(ProtoUtilsKt.putField(newBuilder, "result", Double.valueOf(brokenCreativeEvent.isBroken())), KEY_PHASE, Integer.valueOf(brokenCreativeEvent.getAdPhaseSequence())), KEY_COMPONENT, brokenCreativeEvent.getAdElementName()), "duration", Long.valueOf(brokenCreativeEvent.getDurationMs())), KEY_ALGORITHMS, mapNotNullToProtoListValue));
            HashMap hashMap = new HashMap();
            hashMap.put(KEY_ADAPTIVE_RENDERING_CONTEXT, protoValue);
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }
}
