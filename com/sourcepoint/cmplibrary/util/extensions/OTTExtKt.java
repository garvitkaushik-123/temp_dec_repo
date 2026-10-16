package com.sourcepoint.cmplibrary.util.extensions;

import android.content.Context;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTTExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toMessageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "Landroid/content/Context;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OTTExtKt {
    public static final MessageType toMessageType(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.software.leanback");
        if (hasSystemFeature) {
            return MessageType.OTT;
        }
        if (hasSystemFeature) {
            throw new NoWhenBranchMatchedException();
        }
        return MessageType.MOBILE;
    }
}
