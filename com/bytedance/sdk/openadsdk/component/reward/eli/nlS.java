package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class nlS {
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli DbA;
    protected int eli;

    public nlS(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.eli = 0;
        this.DbA = eliVar;
        DbA();
        try {
            this.eli = SSo.Os(eliVar.SSo, SSo.eli());
            if (!eliVar.SSo.getWindow().hasFeature(1)) {
                eliVar.SSo.requestWindowFeature(1);
            }
            eliVar.SSo.getWindow().addFlags(16777344);
            if (eliVar.QI != 2 && SSo.Os(eliVar.SSo)) {
                return;
            }
            eliVar.SSo.getWindow().addFlags(1024);
        } catch (Throwable th) {
            Log.e("TTAD.RFSM", "init: ", th);
        }
    }

    public void eli(Ue ue) {
        if (ue == null) {
            return;
        }
        ue.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nlS.1
            @Override // java.lang.Runnable
            public void run() {
                View findViewById;
                try {
                    View decorView = nlS.this.DbA.SSo.getWindow().getDecorView();
                    if (decorView == null || (findViewById = decorView.findViewById(R.id.statusBarBackground)) == null) {
                        return;
                    }
                    findViewById.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    private void DbA() {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        eliVar.mm = eliVar.DbA.Nvn();
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar2 = this.DbA;
        eliVar2.QI = eli(eliVar2.SSo, this.DbA.DbA);
    }

    public static int eli(Activity activity, ev evVar) {
        return evVar.WO();
    }

    public void eli(boolean z) {
        float min;
        float max;
        int max2;
        int i;
        int i2;
        Os();
        float aGH = aGH();
        float ui = ui();
        if (this.DbA.QI == 2) {
            min = Math.max(aGH, ui);
            max = Math.min(aGH, ui);
        } else {
            min = Math.min(aGH, ui);
            max = Math.max(aGH, ui);
        }
        Activity activity = this.DbA.SSo;
        int Os = SSo.Os(activity, SSo.eli());
        if (this.DbA.QI != 2) {
            if (SSo.Os(activity)) {
                max -= Os;
            }
        } else if (SSo.Os(activity)) {
            min -= Os;
        }
        if (z) {
            this.DbA.oc = (int) min;
            this.DbA.rQ = (int) max;
            return;
        }
        int i3 = 20;
        if (this.DbA.QI != 2) {
            if (this.DbA.mm != 0.0f && this.DbA.mm != 100.0f) {
                i = (int) Math.max((max - (((min - 20.0f) - 20.0f) / this.DbA.mm)) / 2.0f, 0.0f);
                i2 = i;
                max2 = 20;
            }
            i3 = 0;
            max2 = 0;
            i = 0;
            i2 = 0;
        } else {
            if (this.DbA.mm != 0.0f && this.DbA.mm != 100.0f) {
                max2 = (int) Math.max((min - (((max - 20.0f) - 20.0f) * this.DbA.mm)) / 2.0f, 0.0f);
                i = 20;
                i2 = 20;
                i3 = max2;
            }
            i3 = 0;
            max2 = 0;
            i = 0;
            i2 = 0;
        }
        float f = i3;
        float f2 = max2;
        this.DbA.oc = (int) ((min - f) - f2);
        float f3 = i;
        float f4 = i2;
        this.DbA.rQ = (int) ((max - f3) - f4);
        if (this.DbA.yKf == null || this.DbA.yKf.du == 0) {
            activity.getWindow().getDecorView().setPadding(SSo.DbA(activity, f), SSo.DbA(activity, f3), SSo.DbA(activity, f2), SSo.DbA(activity, f4));
        }
    }

    public float[] eli(int i) {
        float[] fArr = new float[2];
        Activity activity = this.DbA.SSo;
        View decorView = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 35 && this.DbA.DbA.Nvn() == 100.0f) {
            fArr[0] = decorView.getWidth() - decorView.getPaddingLeft();
            fArr[1] = decorView.getHeight() - decorView.getPaddingTop();
        } else {
            fArr[0] = decorView.getWidth() - (decorView.getPaddingLeft() * 2);
            fArr[1] = decorView.getHeight() - (decorView.getPaddingTop() * 2);
        }
        fArr[0] = SSo.Os(activity, fArr[0]);
        float Os = SSo.Os(activity, fArr[1]);
        fArr[1] = Os;
        if (fArr[0] < 10.0f || Os < 10.0f) {
            fArr = DbA(this.eli);
        }
        if (activity.getResources() != null && activity.getResources().getConfiguration() != null) {
            if ((activity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i) {
                if (i == 2) {
                    float f = fArr[0];
                    float f2 = fArr[1];
                    if (f < f2) {
                        fArr[1] = f;
                        fArr[0] = f2;
                        return fArr;
                    }
                } else {
                    float f3 = fArr[0];
                    float f4 = fArr[1];
                    if (f3 > f4) {
                        fArr[1] = f3;
                        fArr[0] = f4;
                    }
                }
            }
        }
        return fArr;
    }

    public void eli() {
        SSo.eli(this.DbA.SSo);
        this.DbA.SSo.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nlS.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (nlS.this.DbA.SSo.isFinishing()) {
                            return;
                        }
                        nlS.this.DbA.SSo.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nlS.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SSo.eli(nlS.this.DbA.SSo);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        Xb.Os("TTAD.RFSM", e.getMessage());
                    }
                }
            }
        });
    }

    private float[] DbA(int i) {
        float ui = ui();
        float aGH = aGH();
        if ((this.DbA.QI == 1) != (ui > aGH)) {
            float f = ui + aGH;
            aGH = f - aGH;
            ui = f - aGH;
        }
        if (this.DbA.QI == 1) {
            ui -= i;
        } else {
            aGH -= i;
        }
        return new float[]{aGH, ui};
    }

    private void Os() {
        if (this.DbA.QI == 2) {
            if (this.DbA.Yw) {
                eli(this.DbA.SSo, 8);
                return;
            } else {
                eli(this.DbA.SSo, 0);
                return;
            }
        }
        eli(this.DbA.SSo, 1);
    }

    private static void eli(Activity activity, int i) {
        if (activity.getRequestedOrientation() == i) {
            return;
        }
        activity.setRequestedOrientation(i);
    }

    private float aGH() {
        return SSo.Os(this.DbA.SSo, SSo.NU(this.DbA.SSo));
    }

    private float ui() {
        return SSo.Os(this.DbA.SSo, SSo.nlS(this.DbA.SSo));
    }

    private static abstract class eli implements View.OnLayoutChangeListener {
        private int DbA;
        private int eli;

        abstract void eli(int i, int i2);

        private eli() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 == this.eli && i10 == this.DbA) {
                return;
            }
            this.eli = i9;
            this.DbA = i10;
            eli(i9, i10);
        }
    }

    public static class DbA {
        private eli eli;

        public void eli(Activity activity) {
            Window window;
            if (this.eli == null || activity == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.getDecorView().removeOnLayoutChangeListener(this.eli);
            this.eli = null;
        }

        public void eli(final Activity activity, final int i, final float f) {
            if (this.eli == null) {
                try {
                    boolean z = true;
                    if (com.bytedance.sdk.openadsdk.core.dV.aGH().qj() != 1) {
                        z = false;
                    }
                    final boolean z2 = z;
                    final boolean Os = SSo.Os(activity);
                    if (Os || z2) {
                        try {
                            this.eli = new eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nlS.DbA.1
                                boolean eli;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super();
                                }

                                /* JADX WARN: Removed duplicated region for block: B:17:0x00a7 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x0013, B:7:0x0046, B:9:0x005e, B:11:0x0067, B:13:0x0075, B:14:0x0079, B:15:0x00a1, B:17:0x00a7, B:18:0x00ac, B:20:0x00b4, B:24:0x007c, B:26:0x0080, B:28:0x008e, B:30:0x0092, B:31:0x0098, B:33:0x009c, B:34:0x00ba, B:36:0x00be, B:39:0x002d), top: B:1:0x0000 }] */
                                /* JADX WARN: Removed duplicated region for block: B:20:0x00b4 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x0013, B:7:0x0046, B:9:0x005e, B:11:0x0067, B:13:0x0075, B:14:0x0079, B:15:0x00a1, B:17:0x00a7, B:18:0x00ac, B:20:0x00b4, B:24:0x007c, B:26:0x0080, B:28:0x008e, B:30:0x0092, B:31:0x0098, B:33:0x009c, B:34:0x00ba, B:36:0x00be, B:39:0x002d), top: B:1:0x0000 }] */
                                /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
                                @Override // com.bytedance.sdk.openadsdk.component.reward.eli.nlS.eli
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                void eli(int i2, int i3) {
                                    int abs;
                                    float eli;
                                    try {
                                        if (i == 2 && activity.getResources().getConfiguration().orientation == 2) {
                                            abs = Math.abs(SSo.NU(activity) - activity.getWindow().getDecorView().getWidth());
                                        } else {
                                            abs = Math.abs(SSo.nlS(activity) - activity.getWindow().getDecorView().getHeight());
                                        }
                                        View decorView = activity.getWindow().getDecorView();
                                        int paddingLeft = decorView.getPaddingLeft();
                                        int paddingRight = decorView.getPaddingRight();
                                        int paddingBottom = decorView.getPaddingBottom();
                                        if (abs == 0) {
                                            int paddingTop = decorView.getPaddingTop();
                                            if (i == 1 && activity.getResources().getConfiguration().orientation == 1) {
                                                eli = SSo.eli();
                                            } else {
                                                if (i == 2 && activity.getResources().getConfiguration().orientation == 2) {
                                                    if (Os) {
                                                        paddingLeft += (int) SSo.eli();
                                                    }
                                                    if (z2) {
                                                        eli = SSo.eli();
                                                    }
                                                }
                                                if (decorView.isAttachedToWindow()) {
                                                    decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                                                    this.eli = true;
                                                }
                                                if (f != 100.0f) {
                                                    decorView.setBackgroundColor(-16777216);
                                                    return;
                                                }
                                                return;
                                            }
                                            paddingTop += (int) eli;
                                            if (decorView.isAttachedToWindow()) {
                                            }
                                            if (f != 100.0f) {
                                            }
                                        } else if (this.eli) {
                                            decorView.setPadding(paddingLeft, 0, paddingRight, paddingBottom);
                                            this.eli = false;
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                            };
                            activity.getWindow().getDecorView().addOnLayoutChangeListener(this.eli);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }
}
