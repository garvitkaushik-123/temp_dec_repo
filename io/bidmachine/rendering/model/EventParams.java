package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/bidmachine/rendering/model/EventParams;", "", "Lio/bidmachine/rendering/model/EventType;", "eventType", "", "source", "", "Lio/bidmachine/rendering/model/EventTaskParams;", "eventTaskParamsList", "<init>", "(Lio/bidmachine/rendering/model/EventType;Ljava/lang/String;Ljava/util/List;)V", "a", "Lio/bidmachine/rendering/model/EventType;", "getEventType", "()Lio/bidmachine/rendering/model/EventType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/List;", "getEventTaskParamsList", "()Ljava/util/List;", "c", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class EventParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final EventType eventType;

    /* renamed from: b, reason: from kotlin metadata */
    private final List<EventTaskParams> eventTaskParamsList;

    /* renamed from: c, reason: from kotlin metadata */
    private final String source;

    public EventParams(EventType eventType, String source, List<EventTaskParams> eventTaskParamsList) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(eventTaskParamsList, "eventTaskParamsList");
        this.eventType = eventType;
        this.eventTaskParamsList = eventTaskParamsList;
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = source.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        this.source = lowerCase;
    }

    public final List<EventTaskParams> getEventTaskParamsList() {
        return this.eventTaskParamsList;
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final String getSource() {
        return this.source;
    }

    public /* synthetic */ EventParams(EventType eventType, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, str, (i & 4) != 0 ? new ArrayList() : list);
    }
}
