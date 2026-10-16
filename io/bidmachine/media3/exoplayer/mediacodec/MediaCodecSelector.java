package io.bidmachine.media3.exoplayer.mediacodec;

import io.bidmachine.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;

/* loaded from: classes7.dex */
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() { // from class: io.bidmachine.media3.exoplayer.mediacodec.MediaCodecSelector$$ExternalSyntheticLambda0
        @Override // io.bidmachine.media3.exoplayer.mediacodec.MediaCodecSelector
        public final List getDecoderInfos(String str, boolean z, boolean z2) {
            return MediaCodecUtil.getDecoderInfos(str, z, z2);
        }
    };
    public static final MediaCodecSelector PREFER_SOFTWARE = new MediaCodecSelector() { // from class: io.bidmachine.media3.exoplayer.mediacodec.MediaCodecSelector$$ExternalSyntheticLambda1
        @Override // io.bidmachine.media3.exoplayer.mediacodec.MediaCodecSelector
        public final List getDecoderInfos(String str, boolean z, boolean z2) {
            List decoderInfosSortedBySoftwareOnly;
            decoderInfosSortedBySoftwareOnly = MediaCodecUtil.getDecoderInfosSortedBySoftwareOnly(MediaCodecSelector.DEFAULT.getDecoderInfos(str, z, z2));
            return decoderInfosSortedBySoftwareOnly;
        }
    };

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;
}
