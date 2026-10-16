package com.digitalturbine.ignite.cl.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IIgniteServiceAPI extends IInterface {

    public static abstract class Stub extends Binder implements IIgniteServiceAPI {

        public static class Proxy implements IIgniteServiceAPI {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI
            public void authenticate(String str, String str2, Bundle bundle, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongInterface(iIgniteServiceCallback);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI
            public void cancel(String str, Bundle bundle, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI");
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongInterface(iIgniteServiceCallback);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI
            public void getProperty(String str, Bundle bundle, Bundle bundle2, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI");
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    _Parcel.writeTypedObject(obtain, bundle2, 0);
                    obtain.writeStrongInterface(iIgniteServiceCallback);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI
            public void install(String str, Bundle bundle, Bundle bundle2, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI");
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    _Parcel.writeTypedObject(obtain, bundle2, 0);
                    obtain.writeStrongInterface(iIgniteServiceCallback);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI
            public String version() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IIgniteServiceAPI asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IIgniteServiceAPI)) ? new Proxy(iBinder) : (IIgniteServiceAPI) queryLocalInterface;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void authenticate(String str, String str2, Bundle bundle, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException;

    void cancel(String str, Bundle bundle, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException;

    void getProperty(String str, Bundle bundle, Bundle bundle2, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException;

    void install(String str, Bundle bundle, Bundle bundle2, IIgniteServiceCallback iIgniteServiceCallback) throws RemoteException;

    String version() throws RemoteException;
}
