package com.instagram.common.viewpoint.core;

import android.system.ErrnoException;
import android.system.OsConstants;

/* renamed from: com.facebook.ads.redexgen.X.5k, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07515k {
    public static boolean A00(Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
