package io.bidmachine.utils;

import io.bidmachine.core.Utils;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.CreativeLoadingMethod;

/* loaded from: classes8.dex */
public class IabUtils {
    private static final CacheControl DEFAULT_CACHE_CONTROL = CacheControl.FullLoad;

    public static CacheControl toCacheControl(Object object) {
        CreativeLoadingMethod valueOf;
        if (object == null) {
            return DEFAULT_CACHE_CONTROL;
        }
        if (object instanceof CacheControl) {
            return (CacheControl) object;
        }
        if (object instanceof CreativeLoadingMethod) {
            valueOf = (CreativeLoadingMethod) object;
        } else {
            if (object instanceof String) {
                try {
                    valueOf = CreativeLoadingMethod.valueOf((String) object);
                } catch (IllegalArgumentException unused) {
                }
            }
            valueOf = null;
        }
        if (valueOf != null) {
            int i = AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod[valueOf.ordinal()];
            if (i == 1) {
                return CacheControl.Stream;
            }
            if (i == 2) {
                return CacheControl.PartialLoad;
            }
            return DEFAULT_CACHE_CONTROL;
        }
        return DEFAULT_CACHE_CONTROL;
    }

    /* renamed from: io.bidmachine.utils.IabUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod;

        static {
            int[] iArr = new int[CreativeLoadingMethod.values().length];
            $SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod = iArr;
            try {
                iArr[CreativeLoadingMethod.Stream.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod[CreativeLoadingMethod.PartialLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static BMError mapError(IabError iabError) {
        BMError bMError;
        int code = iabError.getCode();
        if (code == 1) {
            bMError = BMError.NoConnection;
        } else {
            if (code != 3) {
                if (code == 5) {
                    bMError = BMError.PlaceholderTimeout;
                } else if (code == 6) {
                    bMError = BMError.Expired;
                } else if (code != 7) {
                    bMError = BMError.InternalUnknownError;
                }
            }
            bMError = BMError.NoFill;
        }
        return new BMError(bMError, code, iabError.getMessage());
    }

    public static IabElementStyle transform(AdExtension.ControlAsset extensionControlView) {
        if (extensionControlView == null) {
            return null;
        }
        try {
            IabElementStyle iabElementStyle = new IabElementStyle();
            iabElementStyle.setMargin(extensionControlView.getMargin());
            iabElementStyle.setPadding(extensionControlView.getPadding());
            iabElementStyle.setContent(extensionControlView.getContent());
            iabElementStyle.setFillColor(Utils.safeParseColor(extensionControlView.getFill()));
            iabElementStyle.setFontStyle(Integer.valueOf(extensionControlView.getFontStyle()));
            iabElementStyle.setWidth(Integer.valueOf(extensionControlView.getWidth()));
            iabElementStyle.setHeight(Integer.valueOf(extensionControlView.getHeight()));
            iabElementStyle.setHideAfter(Float.valueOf(extensionControlView.getHideafter()));
            iabElementStyle.setHorizontalPosition(Utils.parseHorizontalPosition(extensionControlView.getX()));
            iabElementStyle.setVerticalPosition(Utils.parseVerticalPosition(extensionControlView.getY()));
            iabElementStyle.setOpacity(Float.valueOf(extensionControlView.getOpacity()));
            iabElementStyle.setOutlined(Boolean.valueOf(extensionControlView.getOutlined()));
            iabElementStyle.setStrokeColor(Utils.safeParseColor(extensionControlView.getStroke()));
            iabElementStyle.setStrokeWidth(Float.valueOf(extensionControlView.getStrokeWidth()));
            iabElementStyle.setStyle(extensionControlView.getStyle());
            iabElementStyle.setVisible(Boolean.valueOf(extensionControlView.getVisible()));
            return iabElementStyle;
        } catch (Exception unused) {
            return null;
        }
    }
}
