package io.bidmachine.rendering.internal.adform;

import android.content.Context;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.measurer.CompositeHtmlMeasurer;
import io.bidmachine.rendering.measurer.CompositeVideoMeasurer;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdElementType;
import io.bidmachine.rendering.model.MeasurerParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0011\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0011\u0010\u0019J+\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u001c\u0010 \u001a\n \u001e*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001f¨\u0006!"}, d2 = {"Lio/bidmachine/rendering/internal/adform/b;", "", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;)V", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "Lio/bidmachine/rendering/internal/adform/a;", "a", "(Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;)Lio/bidmachine/rendering/internal/adform/a;", "Lio/bidmachine/rendering/measurer/MeasurerFactory;", "measurerFactory", "", "Lio/bidmachine/rendering/model/MeasurerParams;", "measurerParamsList", "Lio/bidmachine/rendering/measurer/HtmlMeasurer;", "(Lio/bidmachine/rendering/measurer/MeasurerFactory;Ljava/util/List;)Lio/bidmachine/rendering/measurer/HtmlMeasurer;", "Lio/bidmachine/rendering/measurer/VideoMeasurer;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/measurer/MeasurerFactory;Ljava/util/List;)Lio/bidmachine/rendering/measurer/VideoMeasurer;", "Lio/bidmachine/rendering/internal/repository/a;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "applicationContext", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final io.bidmachine.rendering.internal.repository.a repository;

    /* renamed from: b, reason: from kotlin metadata */
    private final Context applicationContext;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdElementType.values().length];
            try {
                iArr[AdElementType.Mraid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdElementType.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdElementType.Image.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdElementType.Label.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AdElementType.Progress.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AdElementType.Countdown.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public b(Context context, io.bidmachine.rendering.internal.repository.a repository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        this.applicationContext = context.getApplicationContext();
    }

    public final io.bidmachine.rendering.internal.adform.a a(AdElementParams adElementParams, c adFormListener, io.bidmachine.rendering.internal.event.b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a brokenCreativeDetector) {
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        switch (a.$EnumSwitchMapping$0[adElementParams.getAdElementType().ordinal()]) {
            case 1:
                Context applicationContext = this.applicationContext;
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                return new io.bidmachine.rendering.internal.adform.html.a(applicationContext, this.repository, adElementParams, adFormListener, eventCallback, brokenCreativeDetector, a(adElementParams.getMeasurerFactory(), adElementParams.getMeasurerParamsList()));
            case 2:
                Context applicationContext2 = this.applicationContext;
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                return new io.bidmachine.rendering.internal.adform.video.a(applicationContext2, this.repository, adElementParams, adFormListener, eventCallback, brokenCreativeDetector, b(adElementParams.getMeasurerFactory(), adElementParams.getMeasurerParamsList()));
            case 3:
                Context applicationContext3 = this.applicationContext;
                Intrinsics.checkNotNullExpressionValue(applicationContext3, "applicationContext");
                return new io.bidmachine.rendering.internal.adform.image.a(applicationContext3, this.repository, adElementParams, adFormListener, eventCallback, brokenCreativeDetector);
            case 4:
                Context applicationContext4 = this.applicationContext;
                Intrinsics.checkNotNullExpressionValue(applicationContext4, "applicationContext");
                return new io.bidmachine.rendering.internal.adform.label.a(applicationContext4, this.repository, adElementParams, adFormListener, eventCallback, brokenCreativeDetector);
            case 5:
                Context applicationContext5 = this.applicationContext;
                Intrinsics.checkNotNullExpressionValue(applicationContext5, "applicationContext");
                return new io.bidmachine.rendering.internal.adform.progress.a(applicationContext5, this.repository, adElementParams, adFormListener, eventCallback, brokenCreativeDetector);
            case 6:
                Context applicationContext6 = this.applicationContext;
                Intrinsics.checkNotNullExpressionValue(applicationContext6, "applicationContext");
                return new io.bidmachine.rendering.internal.adform.countdown.a(applicationContext6, this.repository, adElementParams, adFormListener, eventCallback, brokenCreativeDetector);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final VideoMeasurer b(MeasurerFactory measurerFactory, List<MeasurerParams> measurerParamsList) {
        VideoMeasurer videoMeasurer;
        if (measurerFactory == null || measurerParamsList == null || measurerParamsList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MeasurerParams measurerParams : measurerParamsList) {
            try {
                videoMeasurer = measurerFactory.createVideoMeasurer(this.applicationContext, measurerParams.getName(), measurerParams.getParameters());
            } catch (Throwable unused) {
                videoMeasurer = null;
            }
            if (videoMeasurer != null) {
                arrayList.add(videoMeasurer);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new CompositeVideoMeasurer(arrayList);
    }

    public final HtmlMeasurer a(MeasurerFactory measurerFactory, List<MeasurerParams> measurerParamsList) {
        HtmlMeasurer htmlMeasurer;
        if (measurerFactory == null || measurerParamsList == null || measurerParamsList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MeasurerParams measurerParams : measurerParamsList) {
            try {
                htmlMeasurer = measurerFactory.createHtmlMeasurer(this.applicationContext, measurerParams.getName(), measurerParams.getParameters());
            } catch (Throwable unused) {
                htmlMeasurer = null;
            }
            if (htmlMeasurer != null) {
                arrayList.add(htmlMeasurer);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new CompositeHtmlMeasurer(arrayList);
    }
}
