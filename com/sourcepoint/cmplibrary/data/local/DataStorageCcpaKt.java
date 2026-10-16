package com.sourcepoint.cmplibrary.data.local;

import android.content.Context;
import com.sourcepoint.cmplibrary.data.local.DataStorageCcpa;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataStorageCcpa.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa;", "Lcom/sourcepoint/cmplibrary/data/local/DataStorageCcpa$Companion;", "context", "Landroid/content/Context;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DataStorageCcpaKt {
    public static final DataStorageCcpa create(DataStorageCcpa.Companion companion, Context context) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new DataStorageCcpaImpl(context);
    }
}
