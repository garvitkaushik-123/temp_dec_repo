package io.bidmachine.media3.common;

import io.bidmachine.media3.common.util.Size;
import java.util.List;

/* loaded from: classes7.dex */
public interface VideoCompositorSettings {
    public static final VideoCompositorSettings DEFAULT = new VideoCompositorSettings() { // from class: io.bidmachine.media3.common.VideoCompositorSettings.1
        @Override // io.bidmachine.media3.common.VideoCompositorSettings
        public Size getOutputSize(List<Size> list) {
            return list.get(0);
        }

        @Override // io.bidmachine.media3.common.VideoCompositorSettings
        public OverlaySettings getOverlaySettings(int i, long j) {
            return new OverlaySettings() { // from class: io.bidmachine.media3.common.VideoCompositorSettings.1.1
            };
        }
    };

    Size getOutputSize(List<Size> list);

    OverlaySettings getOverlaySettings(int i, long j);
}
