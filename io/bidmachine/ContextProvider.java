package io.bidmachine;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes7.dex */
public interface ContextProvider {
    Activity getActivity();

    Context getApplicationContext();

    Context getContext();
}
