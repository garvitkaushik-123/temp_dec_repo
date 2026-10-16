package com.bytedance.adsdk.ugeno.FC.eli;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.FC.MGA.DbA;
import com.bytedance.adsdk.ugeno.eli;
import com.bytedance.adsdk.ugeno.kb.aGH;
import com.bytedance.adsdk.ugeno.kb.eli;
import com.bytedance.adsdk.ugeno.kb.wC;
import com.bytedance.adsdk.ugeno.ui;

/* loaded from: classes3.dex */
public class eli extends DbA {
    private String Bnk;
    private boolean CH;
    private boolean QMZ;
    private String QW;
    private eli.C0126eli Tju;
    private String hg;
    private int kEI;
    private String nY;
    private int yw;

    public eli(Context context) {
        super(context);
        this.Bnk = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.FC.MGA.DbA, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        aGH();
        ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    protected void FS() {
        super.FS();
        if (this.CH) {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setTextColor(this.yw);
        }
        if (this.QMZ) {
            if (this.ND) {
                eli(this.Tju);
            } else {
                aGH(this.kEI);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    protected void jh() {
        super.jh();
        if (this.CH) {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setTextColor(this.vb);
        }
        if (this.QMZ) {
            if (this.ND) {
                eli(this.RY);
            } else {
                aGH(this.eU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void DbA(Drawable drawable) {
        char c;
        if (drawable == null) {
            return;
        }
        String str = this.Bnk;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 113114:
                if (str.equals("row")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (c == 1) {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (c == 2) {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        } else {
            ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void aGH() {
        if (TextUtils.isEmpty(this.hg)) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setCompoundDrawables(null, null, null, null);
        if (this.hg.startsWith("local://")) {
            try {
                DbA(wC.eli(this.DbA, aGH.DbA(this.DbA, this.hg.replace("local://", ""))));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        ui.eli().DbA().eli(this.FC, this.hg, new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.FC.eli.eli.1
            @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
            public void eli(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.FC.eli.eli.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eli.this.DbA(new BitmapDrawable(eli.this.DbA.getResources(), bitmap));
                    }
                });
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.FC.MGA.DbA, com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.Bnk = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.yw = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                this.CH = true;
                break;
            case "image":
                this.hg = str2;
                break;
            case "highlightImage":
                this.QW = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.kb.eli.Os(str2)) {
                    this.ND = true;
                    this.Tju = com.bytedance.adsdk.ugeno.kb.eli.DbA(str2);
                } else {
                    this.kEI = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                    this.ND = false;
                }
                this.QMZ = true;
                break;
            case "highlightBackgroundImage":
                this.nY = str2;
                break;
        }
    }
}
