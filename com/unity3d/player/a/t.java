package com.unity3d.player.a;

import android.util.Log;

/* loaded from: classes7.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6535a = false;

    public static void Log(int i, String str) {
        if (f6535a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
