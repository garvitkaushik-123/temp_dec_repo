package com.mbridge.msdk.playercommon;

import com.mbridge.msdk.foundation.tools.p0;

/* loaded from: classes6.dex */
public class DefaultVideoPlayerStatusListener implements VideoPlayerStatusListener {
    protected static final String TAG = "DefaultVideoPlayerStatusListener";

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
        p0.a(TAG, "OnBufferingEnd");
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
        p0.a(TAG, "OnBufferingStart:" + str);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingTimeOut(String str) {
        p0.a(TAG, "onBufferingTimeOut:" + str);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        p0.a(TAG, "onPlayCompleted");
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        p0.a(TAG, "onPlayError:" + str);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i, int i2) {
        p0.a(TAG, "onPlayProgress:" + i + ",allDuration:" + i2);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i, int i2) {
        p0.a(TAG, "onPlayProgressMS:");
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        p0.a(TAG, "onPlaySetDataSourceError:" + str);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i) {
        p0.a(TAG, "onPlayStarted:" + i);
    }
}
