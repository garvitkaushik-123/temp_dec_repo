package io.bidmachine.iab.vast;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.vast.activity.VastView;

/* loaded from: classes7.dex */
public interface VastViewListener {
    void onClick(VastView vastView, VastRequest vastRequest, IabClickCallback clickCallback, String url);

    void onComplete(VastView vastView, VastRequest vastRequest);

    void onFinish(VastView vastView, VastRequest vastRequest, boolean isPlayingFinished);

    void onOrientationRequested(VastView vastView, VastRequest vastRequest, int orientation);

    void onShowFailed(VastView vastView, VastRequest vastRequest, IabError iabError);

    void onShown(VastView vastView, VastRequest vastRequest);
}
