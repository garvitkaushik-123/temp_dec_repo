package com.unity3d.ads.core.extensions;

import android.content.Context;
import com.ironsource.V5;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextExtensions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"unityAdsDataStoreFile", "Ljava/io/File;", "Landroid/content/Context;", V5.c.b, "", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ContextExtensionsKt {
    public static final File unityAdsDataStoreFile(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), UnityAdsConstants.Cache.DATASTORE_PATH + fileName);
    }
}
