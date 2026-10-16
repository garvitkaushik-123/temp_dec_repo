package com.bytedance.sdk.component.adexpress.aGH;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class FC {
    public static eli eli(String str) {
        eli eliVar = eli.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        return eli.CSS;
                    }
                    if (path.endsWith(".js")) {
                        return eli.JS;
                    }
                    if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico")) {
                        if (path.endsWith(".html")) {
                            return eli.HTML;
                        }
                    }
                    return eli.IMAGE;
                }
            } catch (Throwable unused) {
            }
        }
        return eliVar;
    }

    public static boolean DbA(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String path = parse.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public enum eli {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String ui;

        eli(String str) {
            this.ui = str;
        }

        public String eli() {
            return this.ui;
        }
    }
}
