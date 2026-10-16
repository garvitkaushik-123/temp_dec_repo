package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J@\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0012¨\u0006*"}, d2 = {"Lio/bidmachine/rendering/model/EventTaskParams;", "", "Lio/bidmachine/rendering/model/EventTaskType;", "eventTaskType", "", "target", "value", "", "stateGroups", "<init>", "(Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;)V", "component1", "()Lio/bidmachine/rendering/model/EventTaskType;", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Object;", "component4", "()Ljava/util/List;", "copy", "(Lio/bidmachine/rendering/model/EventTaskType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;)Lio/bidmachine/rendering/model/EventTaskParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lio/bidmachine/rendering/model/EventTaskType;", "getEventTaskType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getTarget", "c", "Ljava/lang/Object;", "getValue", "d", "Ljava/util/List;", "getStateGroups", "Companion", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EventTaskParams {
    public static final String STATE_GROUP_DEFAULT = "default";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final EventTaskType eventTaskType;

    /* renamed from: b, reason: from kotlin metadata */
    private final String target;

    /* renamed from: c, reason: from kotlin metadata */
    private final Object value;

    /* renamed from: d, reason: from kotlin metadata */
    private final List<String> stateGroups;

    public EventTaskParams(EventTaskType eventTaskType, String target, Object obj, List<String> stateGroups) {
        Intrinsics.checkNotNullParameter(eventTaskType, "eventTaskType");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(stateGroups, "stateGroups");
        this.eventTaskType = eventTaskType;
        this.target = target;
        this.value = obj;
        this.stateGroups = stateGroups;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTaskParams copy$default(EventTaskParams eventTaskParams, EventTaskType eventTaskType, String str, Object obj, List list, int i, Object obj2) {
        if ((i & 1) != 0) {
            eventTaskType = eventTaskParams.eventTaskType;
        }
        if ((i & 2) != 0) {
            str = eventTaskParams.target;
        }
        if ((i & 4) != 0) {
            obj = eventTaskParams.value;
        }
        if ((i & 8) != 0) {
            list = eventTaskParams.stateGroups;
        }
        return eventTaskParams.copy(eventTaskType, str, obj, list);
    }

    /* renamed from: component1, reason: from getter */
    public final EventTaskType getEventTaskType() {
        return this.eventTaskType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTarget() {
        return this.target;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public final List<String> component4() {
        return this.stateGroups;
    }

    public final EventTaskParams copy(EventTaskType eventTaskType, String target, Object value, List<String> stateGroups) {
        Intrinsics.checkNotNullParameter(eventTaskType, "eventTaskType");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(stateGroups, "stateGroups");
        return new EventTaskParams(eventTaskType, target, value, stateGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTaskParams)) {
            return false;
        }
        EventTaskParams eventTaskParams = (EventTaskParams) other;
        return this.eventTaskType == eventTaskParams.eventTaskType && Intrinsics.areEqual(this.target, eventTaskParams.target) && Intrinsics.areEqual(this.value, eventTaskParams.value) && Intrinsics.areEqual(this.stateGroups, eventTaskParams.stateGroups);
    }

    public final EventTaskType getEventTaskType() {
        return this.eventTaskType;
    }

    public final List<String> getStateGroups() {
        return this.stateGroups;
    }

    public final String getTarget() {
        return this.target;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((this.eventTaskType.hashCode() * 31) + this.target.hashCode()) * 31;
        Object obj = this.value;
        return ((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.stateGroups.hashCode();
    }

    public String toString() {
        return "EventTaskParams(eventTaskType=" + this.eventTaskType + ", target=" + this.target + ", value=" + this.value + ", stateGroups=" + this.stateGroups + ')';
    }

    public /* synthetic */ EventTaskParams(EventTaskType eventTaskType, String str, Object obj, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventTaskType, str, (i & 4) != 0 ? null : obj, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}
