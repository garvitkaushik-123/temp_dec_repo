package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.view.View;
import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes6.dex */
public interface z {
    void a(View view);

    void a(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i);
}
