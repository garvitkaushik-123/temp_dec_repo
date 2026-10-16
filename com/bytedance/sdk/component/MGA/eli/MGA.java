package com.bytedance.sdk.component.MGA.eli;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: classes3.dex */
public interface MGA extends IInterface {
    int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException;

    int eli(Uri uri, String str, String[] strArr) throws RemoteException;

    String eli(Uri uri) throws RemoteException;

    String eli(Uri uri, ContentValues contentValues) throws RemoteException;

    Map eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException;

    public static abstract class eli extends Binder implements MGA {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public eli() {
            attachInterface(this, "com.bytedance.sdk.component.log.impl.IListenerEventManager");
        }

        public static MGA eli(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof MGA)) {
                return (MGA) queryLocalInterface;
            }
            return new C0133eli(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                Map eli = eli(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.createStringArray(), parcel.readString(), parcel.createStringArray(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeMap(eli);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                String eli2 = eli(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(eli2);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                String eli3 = eli(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(eli3);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                int eli4 = eli(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                parcel2.writeInt(eli4);
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
            int eli5 = eli(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.createStringArray());
            parcel2.writeNoException();
            parcel2.writeInt(eli5);
            return true;
        }

        /* renamed from: com.bytedance.sdk.component.MGA.eli.MGA$eli$eli, reason: collision with other inner class name */
        private static class C0133eli implements MGA {
            public static MGA eli;
            private IBinder DbA;

            C0133eli(IBinder iBinder) {
                this.DbA = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.DbA;
            }

            @Override // com.bytedance.sdk.component.MGA.eli.MGA
            public Map eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
                Map readHashMap;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr2);
                    obtain.writeString(str2);
                    if (!this.DbA.transact(1, obtain, obtain2, 0) && eli.eli() != null) {
                        readHashMap = eli.eli().eli(uri, strArr, str, strArr2, str2);
                    } else {
                        obtain2.readException();
                        readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    }
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.component.MGA.eli.MGA
            public String eli(Uri uri) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.DbA.transact(2, obtain, obtain2, 0) && eli.eli() != null) {
                        readString = eli.eli().eli(uri);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.component.MGA.eli.MGA
            public String eli(Uri uri, ContentValues contentValues) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        obtain.writeInt(1);
                        contentValues.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.DbA.transact(3, obtain, obtain2, 0) && eli.eli() != null) {
                        readString = eli.eli().eli(uri, contentValues);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.component.MGA.eli.MGA
            public int eli(Uri uri, String str, String[] strArr) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (!this.DbA.transact(4, obtain, obtain2, 0) && eli.eli() != null) {
                        readInt = eli.eli().eli(uri, str, strArr);
                    } else {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.component.MGA.eli.MGA
            public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        obtain.writeInt(1);
                        contentValues.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (!this.DbA.transact(5, obtain, obtain2, 0) && eli.eli() != null) {
                        readInt = eli.eli().eli(uri, contentValues, str, strArr);
                    } else {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static MGA eli() {
            return C0133eli.eli;
        }
    }
}
