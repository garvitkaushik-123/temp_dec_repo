package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.util.e1;

/* loaded from: classes4.dex */
public interface f0 {
    com.fyber.inneractive.sdk.util.b0 a(e1 e1Var, com.fyber.inneractive.sdk.util.g gVar);

    com.fyber.inneractive.sdk.util.b0 a(String str, e1 e1Var, boolean z);

    void a(View view);

    void a(View view, String str);

    void a(String str, String str2);

    void a(boolean z);

    void a(boolean z, Orientation orientation);

    void c();

    void e();

    void f();

    void h();

    void i();

    void j();

    com.fyber.inneractive.sdk.ignite.m o();

    void onCompleted();

    void onPlayerError();

    void onProgress(int i, int i2);
}
