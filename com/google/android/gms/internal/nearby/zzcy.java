package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public interface zzcy extends IInterface {
    void zzb(Status status, DiagnosisKeysDataMapping diagnosisKeysDataMapping) throws RemoteException;
}
