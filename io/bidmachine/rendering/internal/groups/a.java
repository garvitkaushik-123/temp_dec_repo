package io.bidmachine.rendering.internal.groups;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R4\u0010\u0018\u001a\"\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u00030\u0014j\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u0003`\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/bidmachine/rendering/internal/groups/a;", "Lio/bidmachine/rendering/internal/groups/b;", "", "", "initial", "<init>", "(Ljava/util/List;)V", "stateGroup", "", "c", "(Ljava/lang/String;)V", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "d", "(Ljava/lang/String;)Z", "stateGroups", "a", "(Ljava/util/List;)Z", "Ljava/util/List;", "Ljava/util/HashSet;", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<String> initial;

    /* renamed from: b, reason: from kotlin metadata */
    private final HashSet<String> active;

    public a(List<String> initial) {
        Intrinsics.checkNotNullParameter(initial, "initial");
        this.initial = initial;
        this.active = new HashSet<>(initial);
    }

    private final void b(String stateGroup) {
        if (this.active.contains(stateGroup)) {
            return;
        }
        this.active.add(stateGroup);
    }

    private final void c(String stateGroup) {
        if (StringsKt.startsWith$default(stateGroup, C3040d4.i.c, false, 2, (Object) null)) {
            String substring = stateGroup.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            b(substring);
        } else if (StringsKt.startsWith$default(stateGroup, "!", false, 2, (Object) null)) {
            String substring2 = stateGroup.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            e(substring2);
        }
    }

    private final void e(String stateGroup) {
        if (Intrinsics.areEqual(stateGroup, EventTaskParams.STATE_GROUP_DEFAULT)) {
            return;
        }
        this.active.remove(stateGroup);
    }

    @Override // io.bidmachine.rendering.internal.groups.b
    public boolean a(List<String> stateGroups) {
        boolean z;
        Intrinsics.checkNotNullParameter(stateGroups, "stateGroups");
        synchronized (this.active) {
            if (!stateGroups.isEmpty()) {
                if (!stateGroups.isEmpty()) {
                    Iterator<T> it = stateGroups.iterator();
                    while (it.hasNext()) {
                        if (d((String) it.next())) {
                        }
                    }
                }
                z = false;
            }
            z = true;
        }
        return z;
    }

    public boolean d(String stateGroup) {
        boolean z;
        Intrinsics.checkNotNullParameter(stateGroup, "stateGroup");
        synchronized (this.active) {
            if (!Intrinsics.areEqual(stateGroup, EventTaskParams.STATE_GROUP_DEFAULT)) {
                z = this.active.contains(stateGroup);
            }
        }
        return z;
    }

    @Override // io.bidmachine.rendering.internal.groups.b
    public void a(String stateGroups) {
        Intrinsics.checkNotNullParameter(stateGroups, "stateGroups");
        synchronized (this.active) {
            List split$default = StringsKt.split$default((CharSequence) stateGroups, new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c((String) it2.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
