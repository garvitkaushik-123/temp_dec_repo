package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.io.File;
import kotlin.coroutines.Continuation;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a$a, reason: collision with other inner class name */
    public static final class C0477a {
        public static /* synthetic */ Object a(a aVar, String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadMedia");
            }
            if ((i & 8) != 0) {
                aVar2 = null;
            }
            return aVar.a(str, file, str2, aVar2, continuation);
        }
    }

    Object a(String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, Continuation<? super i.a> continuation);

    boolean a(File file);

    boolean b(File file);
}
