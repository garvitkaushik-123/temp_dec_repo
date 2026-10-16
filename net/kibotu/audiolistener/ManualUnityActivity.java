package net.kibotu.audiolistener;

import android.os.Bundle;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerNativeActivity;

/* loaded from: classes8.dex */
public class ManualUnityActivity extends UnityPlayerNativeActivity {
    public static UnityPlayer unityPlayer;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        unityPlayer = this.mUnityPlayer;
    }
}
