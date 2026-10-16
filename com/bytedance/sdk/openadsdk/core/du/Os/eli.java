package com.bytedance.sdk.openadsdk.core.du.Os;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import io.bidmachine.media3.common.MimeTypes;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class eli {
    public static final Set<String> eli = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.du.Os.eli.1
        {
            add("image/jpeg");
            add("image/png");
            add(MimeTypes.IMAGE_BMP);
            add("image/gif");
            add("image/jpg");
        }
    };
    public static Set<String> DbA = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.du.Os.eli.2
        {
            add("application/x-javascript");
        }
    };

    public enum DbA {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.du.Os.eli$eli, reason: collision with other inner class name */
    public enum EnumC0190eli {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    public static Point eli(Context context, int i, int i2, DbA dbA) {
        if (context == null) {
            context = dV.eli();
        }
        Point point = new Point(i, i2);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int DbA2 = SSo.DbA(context, i);
        int DbA3 = SSo.DbA(context, i2);
        if (DbA2 > width || DbA3 > height) {
            Point point2 = new Point();
            if (DbA.HTML_RESOURCE == dbA) {
                point2.x = Math.min(width, DbA2);
                point2.y = Math.min(height, DbA3);
            } else {
                float f = DbA2;
                float f2 = f / width;
                float f3 = DbA3;
                float f4 = f3 / height;
                if (f2 >= f4) {
                    point2.x = width;
                    point2.y = (int) (f3 / f2);
                } else {
                    point2.x = (int) (f / f4);
                    point2.y = height;
                }
            }
            if (point2.x >= 0 && point2.y >= 0) {
                point2.x = SSo.Os(context, point2.x);
                point2.y = SSo.Os(context, point2.y);
                return point2;
            }
        }
        return point;
    }
}
