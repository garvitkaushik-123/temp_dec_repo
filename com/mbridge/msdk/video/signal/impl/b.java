package com.mbridge.msdk.video.signal.impl;

import android.content.res.Configuration;
import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: DefaultJSActivity.java */
/* loaded from: classes6.dex */
public class b implements com.mbridge.msdk.video.signal.b {
    @Override // com.mbridge.msdk.video.signal.b
    public void a(Configuration configuration) {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onConfigurationChanged:" + configuration.orientation);
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void b() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onDestory");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void c() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onStop");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void d() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onResume");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void e() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onBackPressed");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void f() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onRestart");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void g() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onPause");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void h() {
        p0.a("DefaultJSActivity", "DefaultJSActivity-onStart");
    }

    @Override // com.mbridge.msdk.video.signal.b
    public int a() {
        p0.a("DefaultJSActivity", "isSystemResume");
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.b
    public void a(int i) {
        p0.a("DefaultJSActivity", "setSystemResume,isResume:" + i);
    }
}
