package com.fyber.inneractive.sdk.web;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* loaded from: classes4.dex */
public final class a0 implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    public final String f1789a;
    public MediaScannerConnection b;

    public a0(String str) {
        this.f1789a = str;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public final void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection = this.b;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.scanFile(this.f1789a, null);
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String str, Uri uri) {
        MediaScannerConnection mediaScannerConnection = this.b;
        if (mediaScannerConnection != null) {
            mediaScannerConnection.disconnect();
        }
    }
}
