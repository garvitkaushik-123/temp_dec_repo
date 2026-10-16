package com.bytedance.adsdk.ugeno.FC.DbA;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.DbA.eli;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.adsdk.ugeno.DbA.eli<com.bytedance.adsdk.ugeno.FC.DbA.eli> {
    private com.bytedance.adsdk.ugeno.FC.DbA.eli vb;

    public DbA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ugeno.FC.DbA.eli eli() {
        com.bytedance.adsdk.ugeno.FC.DbA.eli eliVar = new com.bytedance.adsdk.ugeno.FC.DbA.eli(this.DbA);
        this.vb = eliVar;
        eliVar.eli(this);
        return this.vb;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        this.vb.setEventMap(this.XxP);
        super.DbA();
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public eli.C0117eli aAs() {
        return new eli(this);
    }

    public static class eli extends eli.C0117eli {
        protected int ujq;

        public eli(com.bytedance.adsdk.ugeno.DbA.eli eliVar) {
            super(eliVar);
            this.ujq = -1;
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        public void eli(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.eli(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.ujq = eli(str2);
            }
        }

        private int eli(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split("\\|")) == null || split.length <= 0) {
                return -1;
            }
            int i = 0;
            for (String str2 : split) {
                i |= DbA(str2);
            }
            return i;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int DbA(String str) {
            char c;
            str.hashCode();
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals("bottom")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -348726240:
                    if (str.equals("center_vertical")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1063616078:
                    if (str.equals("center_horizontal")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return 80;
                case 1:
                    return 17;
                case 2:
                    return 16;
                case 3:
                    return 48;
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.DbA.eli.C0117eli
        /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams eli() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.eli, (int) this.DbA);
            layoutParams.leftMargin = (int) this.MGA;
            layoutParams.rightMargin = (int) this.kb;
            layoutParams.topMargin = (int) this.wC;
            layoutParams.bottomMargin = (int) this.FC;
            layoutParams.gravity = this.ujq;
            return layoutParams;
        }
    }
}
