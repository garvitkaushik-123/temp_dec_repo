package com.instagram.common.viewpoint.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.BinaryFrame;

/* loaded from: assets/audience_network/classes2.dex */
public class I9 implements Parcelable.Creator<BinaryFrame> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final BinaryFrame createFromParcel(Parcel parcel) {
        return new BinaryFrame(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final BinaryFrame[] newArray(int i) {
        return new BinaryFrame[i];
    }
}
