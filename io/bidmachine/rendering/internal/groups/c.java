package io.bidmachine.rendering.internal.groups;

import io.bidmachine.rendering.internal.event.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/internal/groups/c;", "Lio/bidmachine/rendering/internal/event/e;", "Lio/bidmachine/rendering/internal/groups/b;", "stateGroupController", "<init>", "(Lio/bidmachine/rendering/internal/groups/b;)V", "", "", "params", "", "a", "(Ljava/util/List;)Z", "Lio/bidmachine/rendering/internal/groups/b;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b stateGroupController;

    public c(b stateGroupController) {
        Intrinsics.checkNotNullParameter(stateGroupController, "stateGroupController");
        this.stateGroupController = stateGroupController;
    }

    @Override // io.bidmachine.rendering.internal.event.e
    public boolean a(List<? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
        Iterator<T> it = params.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return !this.stateGroupController.a(arrayList);
    }
}
