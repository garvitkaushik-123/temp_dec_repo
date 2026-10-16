package com.bytedance.adsdk.ugeno.wC;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public abstract class eli implements Parcelable {
    private final Parcelable DbA;
    public static final eli eli = new eli() { // from class: com.bytedance.adsdk.ugeno.wC.eli.1
    };
    public static final Parcelable.Creator<eli> CREATOR = new Parcelable.ClassLoaderCreator<eli>() { // from class: com.bytedance.adsdk.ugeno.wC.eli.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public eli createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public eli createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return eli.eli;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public eli[] newArray(int i) {
            return new eli[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private eli() {
        this.DbA = null;
    }

    protected eli(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.DbA = parcelable == eli ? null : parcelable;
    }

    protected eli(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.DbA = readParcelable == null ? eli : readParcelable;
    }

    public final Parcelable eli() {
        return this.DbA;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.DbA, i);
    }
}
