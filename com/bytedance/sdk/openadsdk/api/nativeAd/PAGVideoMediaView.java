package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.DbA.eli;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.utils.aGH;

/* loaded from: classes3.dex */
public class PAGVideoMediaView extends PAGMediaView implements eli.InterfaceC0172eli {
    private MGA DbA;
    private final com.bytedance.sdk.openadsdk.eli.DbA.eli Os;
    private ev aGH;

    public PAGVideoMediaView(Context context, View view, com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar) {
        super(context);
        eli(view);
        this.Os = eliVar;
    }

    private void eli(View view) {
        if (view instanceof MGA) {
            MGA mga = (MGA) view;
            this.DbA = mga;
            addView(mga, -1, -1);
        }
    }

    private void eli() {
        MGA mga = this.DbA;
        if (mga != null) {
            mga.Dfc();
        }
    }

    private boolean DbA() {
        MGA mga = this.DbA;
        if (mga != null) {
            return mga.NU();
        }
        return false;
    }

    public void handleInterruptVideo() {
        if (DbA()) {
            return;
        }
        eli();
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.eli.DbA.eli eliVar = this.Os;
        if (eliVar == null) {
            return;
        }
        eliVar.eli(new PAGVideoAdListener() { // from class: com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView.1
            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPlay() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPaused() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdComplete() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoError() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof eli) {
            ((eli) onClickListener).eli((eli.InterfaceC0172eli) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void close() {
        MGA mga = this.DbA;
        if (mga != null) {
            mga.aqO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.eli.InterfaceC0172eli
    public long getVideoProgress() {
        MGA mga = this.DbA;
        if (mga == null || mga.getNativeVideoController() == null) {
            return 0L;
        }
        return this.DbA.getNativeVideoController().MGA();
    }

    public void setMaterialMeta(ev evVar) {
        this.aGH = evVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH.eli(this, this.aGH);
    }
}
