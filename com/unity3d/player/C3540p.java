package com.unity3d.player;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* renamed from: com.unity3d.player.p, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3540p implements OnCompleteListener {
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        if (task.isSuccessful()) {
            FirebaseIdentifiersHelper.nativeOnFirebaseAppInstanceIdResult((String) task.getResult());
        } else {
            FirebaseIdentifiersHelper.nativeOnFirebaseAppInstanceIdResult(null);
        }
    }
}
