package com.instagram.common.viewpoint.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.InternalFrame;

/* loaded from: assets/audience_network/classes2.dex */
public class IG implements Parcelable.Creator<InternalFrame> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final InternalFrame createFromParcel(Parcel parcel) {
        return new InternalFrame(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final InternalFrame[] newArray(int i) {
        return new InternalFrame[i];
    }
}
