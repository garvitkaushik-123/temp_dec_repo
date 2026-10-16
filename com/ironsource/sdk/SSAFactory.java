package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.F9;
import com.ironsource.Od;

@Deprecated
/* loaded from: classes6.dex */
public class SSAFactory {
    public static Od getPublisherInstance(Activity activity) throws Exception {
        return F9.b((Context) activity);
    }

    public static Od getPublisherTestInstance(Activity activity, int i) throws Exception {
        return F9.a(activity, i);
    }
}
