package com.sourcepoint.cmplibrary.util;

import android.app.Activity;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.util.ViewsManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewsManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/util/ViewsManager;", "Lcom/sourcepoint/cmplibrary/util/ViewsManager$Companion;", "actWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "messageTimeout", "", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewsManagerKt {
    public static final ViewsManager create(ViewsManager.Companion companion, WeakReference<Activity> actWeakReference, ConnectionManager connectionManager, long j) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(actWeakReference, "actWeakReference");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        return new ViewsManagerImpl(actWeakReference, connectionManager, j);
    }
}
