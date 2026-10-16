package com.sourcepoint.cmplibrary;

import com.ironsource.C3040d4;
import kotlin.Metadata;

/* compiled from: SpClient.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/sourcepoint/cmplibrary/UnitySpClient;", "Lcom/sourcepoint/cmplibrary/SpClient;", "onConsentReady", "", C3040d4.i.b0, "", "onSpFinished", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UnitySpClient extends SpClient {
    void onConsentReady(String consent);

    void onSpFinished(String consent);
}
