package com.facebook.ads.internal.util.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class WrappedParcelable implements Parcelable {
    public static final Parcelable.Creator<WrappedParcelable> CREATOR = new Parcelable.Creator<WrappedParcelable>() { // from class: com.facebook.ads.internal.util.parcelable.WrappedParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WrappedParcelable createFromParcel(Parcel parcel) {
            return new WrappedParcelable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WrappedParcelable[] newArray(int i) {
            return new WrappedParcelable[i];
        }
    };
    private final byte[] mParcelableBytes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected WrappedParcelable(Parcel parcel) {
        this.mParcelableBytes = parcel.createByteArray();
    }

    public WrappedParcelable(Parcelable parcelable) {
        this.mParcelableBytes = marshallParcelable(parcelable);
    }

    public WrappedParcelable(byte[] bArr) {
        this.mParcelableBytes = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mParcelableBytes);
    }

    public Parcelable unwrap(ClassLoader classLoader) {
        Parcel obtain = Parcel.obtain();
        byte[] bArr = this.mParcelableBytes;
        if (bArr == null) {
            return null;
        }
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Parcelable readParcelable = obtain.readParcelable(classLoader);
        obtain.recycle();
        return readParcelable;
    }

    public static byte[] marshallParcelable(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(parcelable, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
