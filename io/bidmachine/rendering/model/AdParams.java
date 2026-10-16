package io.bidmachine.rendering.model;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.ironsource.C3061e8;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.model.VisibilityParams;
import io.bidmachine.util.UtilsKt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b$\u0018\u00002\u00020\u0001:\u00012B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lio/bidmachine/rendering/model/AdParams;", "", "Lio/bidmachine/rendering/model/CacheType;", "cacheType", "Ljava/util/Queue;", "Lio/bidmachine/rendering/model/AdPhaseParams;", "adPhaseParamsQueue", "Lio/bidmachine/rendering/model/VisibilityParams;", C3061e8.s, "placeholderParams", "Lio/bidmachine/rendering/model/Orientation;", "orientation", "Lio/bidmachine/rendering/model/Background;", "background", "", "", "customParams", "<init>", "(Lio/bidmachine/rendering/model/CacheType;Ljava/util/Queue;Lio/bidmachine/rendering/model/VisibilityParams;Lio/bidmachine/rendering/model/AdPhaseParams;Lio/bidmachine/rendering/model/Orientation;Lio/bidmachine/rendering/model/Background;Ljava/util/Map;)V", C3040d4.h.W, "getCustomParam", "(Ljava/lang/String;)Ljava/lang/String;", "a", "Lio/bidmachine/rendering/model/CacheType;", "getCacheType", "()Lio/bidmachine/rendering/model/CacheType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/Queue;", "getAdPhaseParamsQueue", "()Ljava/util/Queue;", "c", "Lio/bidmachine/rendering/model/VisibilityParams;", "getVisibilityParams", "()Lio/bidmachine/rendering/model/VisibilityParams;", "d", "Lio/bidmachine/rendering/model/AdPhaseParams;", "getPlaceholderParams", "()Lio/bidmachine/rendering/model/AdPhaseParams;", "e", "Lio/bidmachine/rendering/model/Orientation;", "getOrientation", "()Lio/bidmachine/rendering/model/Orientation;", InneractiveMediationDefs.GENDER_FEMALE, "Lio/bidmachine/rendering/model/Background;", "getBackground", "()Lio/bidmachine/rendering/model/Background;", "g", "Ljava/util/Map;", "getCustomParams", "()Ljava/util/Map;", "Builder", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class AdParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CacheType cacheType;

    /* renamed from: b, reason: from kotlin metadata */
    private final Queue<AdPhaseParams> adPhaseParamsQueue;

    /* renamed from: c, reason: from kotlin metadata */
    private final VisibilityParams visibilityParams;

    /* renamed from: d, reason: from kotlin metadata */
    private final AdPhaseParams placeholderParams;

    /* renamed from: e, reason: from kotlin metadata */
    private final Orientation orientation;

    /* renamed from: f, reason: from kotlin metadata */
    private final Background background;

    /* renamed from: g, reason: from kotlin metadata */
    private final Map<String, String> customParams;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00002\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lio/bidmachine/rendering/model/AdParams$Builder;", "", "<init>", "()V", "Ljava/util/Queue;", "Lio/bidmachine/rendering/model/AdPhaseParams;", "adPhaseParamsQueue", "setAdPhaseParamsQueue", "(Ljava/util/Queue;)Lio/bidmachine/rendering/model/AdParams$Builder;", "adPhaseParams", "addAdPhaseParams", "(Lio/bidmachine/rendering/model/AdPhaseParams;)Lio/bidmachine/rendering/model/AdParams$Builder;", "", "", "customParams", "setCustomParams", "(Ljava/util/Map;)Lio/bidmachine/rendering/model/AdParams$Builder;", "Lio/bidmachine/rendering/model/CacheType;", "cacheType", "setCacheType", "(Lio/bidmachine/rendering/model/CacheType;)Lio/bidmachine/rendering/model/AdParams$Builder;", "placeholderParams", "setPlaceholderParams", "Lio/bidmachine/rendering/model/VisibilityParams;", C3061e8.s, "setVisibilityParams", "(Lio/bidmachine/rendering/model/VisibilityParams;)Lio/bidmachine/rendering/model/AdParams$Builder;", "Lio/bidmachine/rendering/model/Orientation;", "orientation", "setOrientation", "(Lio/bidmachine/rendering/model/Orientation;)Lio/bidmachine/rendering/model/AdParams$Builder;", "Lio/bidmachine/rendering/model/Background;", "background", "setBackground", "(Lio/bidmachine/rendering/model/Background;)Lio/bidmachine/rendering/model/AdParams$Builder;", "Lio/bidmachine/rendering/model/AdParams;", "build", "()Lio/bidmachine/rendering/model/AdParams;", "a", "Ljava/util/Queue;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/Map;", "c", "Lio/bidmachine/rendering/model/CacheType;", "d", "Lio/bidmachine/rendering/model/AdPhaseParams;", "e", "Lio/bidmachine/rendering/model/VisibilityParams;", InneractiveMediationDefs.GENDER_FEMALE, "Lio/bidmachine/rendering/model/Orientation;", "g", "Lio/bidmachine/rendering/model/Background;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Queue<AdPhaseParams> adPhaseParamsQueue = new LinkedList();

        /* renamed from: b, reason: from kotlin metadata */
        private final Map<String, String> customParams = new HashMap();

        /* renamed from: c, reason: from kotlin metadata */
        private CacheType cacheType;

        /* renamed from: d, reason: from kotlin metadata */
        private AdPhaseParams placeholderParams;

        /* renamed from: e, reason: from kotlin metadata */
        private VisibilityParams visibilityParams;

        /* renamed from: f, reason: from kotlin metadata */
        private Orientation orientation;

        /* renamed from: g, reason: from kotlin metadata */
        private Background background;

        public final Builder addAdPhaseParams(AdPhaseParams adPhaseParams) {
            Intrinsics.checkNotNullParameter(adPhaseParams, "adPhaseParams");
            this.adPhaseParamsQueue.add(adPhaseParams);
            return this;
        }

        public final AdParams build() {
            Background background = this.background;
            CacheType cacheType = this.cacheType;
            if (cacheType == null) {
                cacheType = i.f7072a.b();
            }
            CacheType cacheType2 = cacheType;
            Queue<AdPhaseParams> queue = this.adPhaseParamsQueue;
            VisibilityParams visibilityParams = this.visibilityParams;
            if (visibilityParams == null) {
                visibilityParams = new VisibilityParams.Builder().build();
            }
            return new AdParams(cacheType2, queue, visibilityParams, this.placeholderParams, this.orientation, background, this.customParams);
        }

        public final Builder setAdPhaseParamsQueue(Queue<AdPhaseParams> adPhaseParamsQueue) {
            UtilsKt.setSafely(this.adPhaseParamsQueue, adPhaseParamsQueue);
            return this;
        }

        public final Builder setBackground(Background background) {
            this.background = background;
            return this;
        }

        public final Builder setCacheType(CacheType cacheType) {
            Intrinsics.checkNotNullParameter(cacheType, "cacheType");
            this.cacheType = cacheType;
            return this;
        }

        public final Builder setCustomParams(Map<String, String> customParams) {
            UtilsKt.setSafely(this.customParams, customParams);
            return this;
        }

        public final Builder setOrientation(Orientation orientation) {
            this.orientation = orientation;
            return this;
        }

        public final Builder setPlaceholderParams(AdPhaseParams placeholderParams) {
            this.placeholderParams = placeholderParams;
            return this;
        }

        public final Builder setVisibilityParams(VisibilityParams visibilityParams) {
            this.visibilityParams = visibilityParams;
            return this;
        }
    }

    public AdParams(CacheType cacheType, Queue<AdPhaseParams> adPhaseParamsQueue, VisibilityParams visibilityParams, AdPhaseParams adPhaseParams, Orientation orientation, Background background, Map<String, String> customParams) {
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        Intrinsics.checkNotNullParameter(adPhaseParamsQueue, "adPhaseParamsQueue");
        Intrinsics.checkNotNullParameter(visibilityParams, "visibilityParams");
        Intrinsics.checkNotNullParameter(customParams, "customParams");
        this.cacheType = cacheType;
        this.adPhaseParamsQueue = adPhaseParamsQueue;
        this.visibilityParams = visibilityParams;
        this.placeholderParams = adPhaseParams;
        this.orientation = orientation;
        this.background = background;
        this.customParams = customParams;
    }

    public final Queue<AdPhaseParams> getAdPhaseParamsQueue() {
        return this.adPhaseParamsQueue;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final CacheType getCacheType() {
        return this.cacheType;
    }

    public final String getCustomParam(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.customParams.get(key);
    }

    public final Map<String, String> getCustomParams() {
        return this.customParams;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final AdPhaseParams getPlaceholderParams() {
        return this.placeholderParams;
    }

    public final VisibilityParams getVisibilityParams() {
        return this.visibilityParams;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AdParams(CacheType cacheType, Queue queue, VisibilityParams visibilityParams, AdPhaseParams adPhaseParams, Orientation orientation, Background background, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cacheType, queue, visibilityParams, adPhaseParams, orientation, r8, r9);
        Map map2;
        Background background2;
        adPhaseParams = (i & 8) != 0 ? null : adPhaseParams;
        orientation = (i & 16) != 0 ? null : orientation;
        if ((i & 32) != 0) {
            map2 = map;
            background2 = null;
        } else {
            map2 = map;
            background2 = background;
        }
    }
}
