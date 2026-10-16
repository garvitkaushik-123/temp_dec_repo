package io.bidmachine;

import java.util.List;

/* loaded from: classes7.dex */
public enum MediaAssetType {
    Icon,
    Image,
    Video,
    All;

    public static boolean isAll(List<MediaAssetType> mediaAssetTypeList) {
        if (mediaAssetTypeList.contains(All)) {
            return true;
        }
        return mediaAssetTypeList.contains(Icon) && mediaAssetTypeList.contains(Image) && mediaAssetTypeList.contains(Video);
    }
}
