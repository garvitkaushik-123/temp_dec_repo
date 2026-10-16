package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IBinderPool extends IInterface {

    public static class Default implements IBinderPool {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            return null;
        }
    }

    IBinder queryBinder(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IBinderPool {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IBinderPool");
        }

        public static IBinderPool asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IBinderPool");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBinderPool)) {
                return (IBinderPool) queryLocalInterface;
            }
            return new eli(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.IBinderPool");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IBinderPool");
            IBinder queryBinder = queryBinder(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(queryBinder);
            return true;
        }

        private static class eli implements IBinderPool {
            public static IBinderPool eli;
            private IBinder DbA;

            eli(IBinder iBinder) {
                this.DbA = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.DbA;
            }

            @Override // com.bytedance.sdk.openadsdk.IBinderPool
            public IBinder queryBinder(int i) throws RemoteException {
                IBinder readStrongBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IBinderPool");
                    obtain.writeInt(i);
                    if (!this.DbA.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        readStrongBinder = Stub.getDefaultImpl().queryBinder(i);
                    } else {
                        obtain2.readException();
                        readStrongBinder = obtain2.readStrongBinder();
                    }
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IBinderPool iBinderPool) {
            if (eli.eli != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iBinderPool == null) {
                return false;
            }
            eli.eli = iBinderPool;
            return true;
        }

        public static IBinderPool getDefaultImpl() {
            return eli.eli;
        }
    }
}
