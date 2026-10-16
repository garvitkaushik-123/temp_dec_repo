package io.adn.sdk.internal.domain.model.ad;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAdEntity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BË\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003Jé\u0001\u00102\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÇ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00106\u001a\u000207H×\u0001J\t\u00108\u001a\u00020\u0004H×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u00069"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastLinearTracking;", "", "creativeView", "", "", "start", "firstQuartile", CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, "thirdQuartile", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, CampaignEx.JSON_NATIVE_VIDEO_MUTE, "unMute", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, CampaignEx.JSON_NATIVE_VIDEO_RESUME, "rewind", "skip", "closeLinear", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/VastProgressTracking;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCreativeView", "()Ljava/util/List;", "getStart", "getFirstQuartile", "getMidpoint", "getThirdQuartile", "getComplete", "getMute", "getUnMute", "getPause", "getResume", "getRewind", "getSkip", "getCloseLinear", "getProgress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastLinearTracking {
    public static final int $stable = 8;
    private final List<String> closeLinear;
    private final List<String> complete;
    private final List<String> creativeView;
    private final List<String> firstQuartile;
    private final List<String> midpoint;
    private final List<String> mute;
    private final List<String> pause;
    private final List<VastProgressTracking> progress;
    private final List<String> resume;
    private final List<String> rewind;
    private final List<String> skip;
    private final List<String> start;
    private final List<String> thirdQuartile;
    private final List<String> unMute;

    public final List<String> component1() {
        return this.creativeView;
    }

    public final List<String> component10() {
        return this.resume;
    }

    public final List<String> component11() {
        return this.rewind;
    }

    public final List<String> component12() {
        return this.skip;
    }

    public final List<String> component13() {
        return this.closeLinear;
    }

    public final List<VastProgressTracking> component14() {
        return this.progress;
    }

    public final List<String> component2() {
        return this.start;
    }

    public final List<String> component3() {
        return this.firstQuartile;
    }

    public final List<String> component4() {
        return this.midpoint;
    }

    public final List<String> component5() {
        return this.thirdQuartile;
    }

    public final List<String> component6() {
        return this.complete;
    }

    public final List<String> component7() {
        return this.mute;
    }

    public final List<String> component8() {
        return this.unMute;
    }

    public final List<String> component9() {
        return this.pause;
    }

    public final VastLinearTracking copy(List<String> creativeView, List<String> start, List<String> firstQuartile, List<String> midpoint, List<String> thirdQuartile, List<String> complete, List<String> mute, List<String> unMute, List<String> pause, List<String> resume, List<String> rewind, List<String> skip, List<String> closeLinear, List<VastProgressTracking> progress) {
        Intrinsics.checkNotNullParameter(creativeView, "creativeView");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(firstQuartile, "firstQuartile");
        Intrinsics.checkNotNullParameter(midpoint, "midpoint");
        Intrinsics.checkNotNullParameter(thirdQuartile, "thirdQuartile");
        Intrinsics.checkNotNullParameter(complete, "complete");
        Intrinsics.checkNotNullParameter(mute, "mute");
        Intrinsics.checkNotNullParameter(unMute, "unMute");
        Intrinsics.checkNotNullParameter(pause, "pause");
        Intrinsics.checkNotNullParameter(resume, "resume");
        Intrinsics.checkNotNullParameter(rewind, "rewind");
        Intrinsics.checkNotNullParameter(skip, "skip");
        Intrinsics.checkNotNullParameter(closeLinear, "closeLinear");
        Intrinsics.checkNotNullParameter(progress, "progress");
        return new VastLinearTracking(creativeView, start, firstQuartile, midpoint, thirdQuartile, complete, mute, unMute, pause, resume, rewind, skip, closeLinear, progress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastLinearTracking)) {
            return false;
        }
        VastLinearTracking vastLinearTracking = (VastLinearTracking) other;
        return Intrinsics.areEqual(this.creativeView, vastLinearTracking.creativeView) && Intrinsics.areEqual(this.start, vastLinearTracking.start) && Intrinsics.areEqual(this.firstQuartile, vastLinearTracking.firstQuartile) && Intrinsics.areEqual(this.midpoint, vastLinearTracking.midpoint) && Intrinsics.areEqual(this.thirdQuartile, vastLinearTracking.thirdQuartile) && Intrinsics.areEqual(this.complete, vastLinearTracking.complete) && Intrinsics.areEqual(this.mute, vastLinearTracking.mute) && Intrinsics.areEqual(this.unMute, vastLinearTracking.unMute) && Intrinsics.areEqual(this.pause, vastLinearTracking.pause) && Intrinsics.areEqual(this.resume, vastLinearTracking.resume) && Intrinsics.areEqual(this.rewind, vastLinearTracking.rewind) && Intrinsics.areEqual(this.skip, vastLinearTracking.skip) && Intrinsics.areEqual(this.closeLinear, vastLinearTracking.closeLinear) && Intrinsics.areEqual(this.progress, vastLinearTracking.progress);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.creativeView.hashCode() * 31) + this.start.hashCode()) * 31) + this.firstQuartile.hashCode()) * 31) + this.midpoint.hashCode()) * 31) + this.thirdQuartile.hashCode()) * 31) + this.complete.hashCode()) * 31) + this.mute.hashCode()) * 31) + this.unMute.hashCode()) * 31) + this.pause.hashCode()) * 31) + this.resume.hashCode()) * 31) + this.rewind.hashCode()) * 31) + this.skip.hashCode()) * 31) + this.closeLinear.hashCode()) * 31) + this.progress.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VastLinearTracking(creativeView=");
        sb.append(this.creativeView).append(", start=").append(this.start).append(", firstQuartile=").append(this.firstQuartile).append(", midpoint=").append(this.midpoint).append(", thirdQuartile=").append(this.thirdQuartile).append(", complete=").append(this.complete).append(", mute=").append(this.mute).append(", unMute=").append(this.unMute).append(", pause=").append(this.pause).append(", resume=").append(this.resume).append(", rewind=").append(this.rewind).append(", skip=");
        sb.append(this.skip).append(", closeLinear=").append(this.closeLinear).append(", progress=").append(this.progress).append(')');
        return sb.toString();
    }

    public VastLinearTracking(List<String> creativeView, List<String> start, List<String> firstQuartile, List<String> midpoint, List<String> thirdQuartile, List<String> complete, List<String> mute, List<String> unMute, List<String> pause, List<String> resume, List<String> rewind, List<String> skip, List<String> closeLinear, List<VastProgressTracking> progress) {
        Intrinsics.checkNotNullParameter(creativeView, "creativeView");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(firstQuartile, "firstQuartile");
        Intrinsics.checkNotNullParameter(midpoint, "midpoint");
        Intrinsics.checkNotNullParameter(thirdQuartile, "thirdQuartile");
        Intrinsics.checkNotNullParameter(complete, "complete");
        Intrinsics.checkNotNullParameter(mute, "mute");
        Intrinsics.checkNotNullParameter(unMute, "unMute");
        Intrinsics.checkNotNullParameter(pause, "pause");
        Intrinsics.checkNotNullParameter(resume, "resume");
        Intrinsics.checkNotNullParameter(rewind, "rewind");
        Intrinsics.checkNotNullParameter(skip, "skip");
        Intrinsics.checkNotNullParameter(closeLinear, "closeLinear");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.creativeView = creativeView;
        this.start = start;
        this.firstQuartile = firstQuartile;
        this.midpoint = midpoint;
        this.thirdQuartile = thirdQuartile;
        this.complete = complete;
        this.mute = mute;
        this.unMute = unMute;
        this.pause = pause;
        this.resume = resume;
        this.rewind = rewind;
        this.skip = skip;
        this.closeLinear = closeLinear;
        this.progress = progress;
    }

    public final List<String> getCreativeView() {
        return this.creativeView;
    }

    public final List<String> getStart() {
        return this.start;
    }

    public final List<String> getFirstQuartile() {
        return this.firstQuartile;
    }

    public final List<String> getMidpoint() {
        return this.midpoint;
    }

    public final List<String> getThirdQuartile() {
        return this.thirdQuartile;
    }

    public final List<String> getComplete() {
        return this.complete;
    }

    public final List<String> getMute() {
        return this.mute;
    }

    public final List<String> getUnMute() {
        return this.unMute;
    }

    public final List<String> getPause() {
        return this.pause;
    }

    public final List<String> getResume() {
        return this.resume;
    }

    public final List<String> getRewind() {
        return this.rewind;
    }

    public final List<String> getSkip() {
        return this.skip;
    }

    public final List<String> getCloseLinear() {
        return this.closeLinear;
    }

    public final List<VastProgressTracking> getProgress() {
        return this.progress;
    }
}
