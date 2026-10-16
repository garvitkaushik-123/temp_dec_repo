package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* compiled from: VideoViewJSListener.java */
/* loaded from: classes6.dex */
public class n extends o {
    private boolean A;
    private int B;
    private boolean C;
    private MBridgeVideoView.u D;
    private IJSFactory x;
    private int y;
    private boolean z;

    public n(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.listener.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        this.z = false;
        this.A = false;
        this.C = false;
        this.x = iJSFactory;
        this.y = i;
        this.z = i2 == 0;
        this.B = i4;
        if (iJSFactory == null) {
            this.f5152a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.o, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        int i2;
        int i3 = i;
        if (this.f5152a) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 8) {
                                if (i3 != 20) {
                                    if (i3 != 114) {
                                        if (i3 != 116) {
                                            switch (i3) {
                                                case 10:
                                                    this.C = true;
                                                    this.x.getJSNotifyProxy().a(0);
                                                    break;
                                                case 11:
                                                case 12:
                                                    this.x.getJSVideoModule().videoOperate(3);
                                                    if (this.b.getVideo_end_type() == 3) {
                                                        this.x.getJSVideoModule().setVisible(0);
                                                    } else if (this.b.getAdSpaceT() != 2) {
                                                        this.x.getJSVideoModule().setVisible(8);
                                                    }
                                                    if (i3 == 12) {
                                                        k();
                                                        i2 = 2;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                    this.x.getJSNotifyProxy().a(i2);
                                                    if (this.x.getJSCommon().i() == 2) {
                                                        this.x.getJSVideoModule().setVisible(0);
                                                        com.mbridge.msdk.video.signal.j jSVideoModule = this.x.getJSVideoModule();
                                                        this.x.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                                    } else if (i3 == 12) {
                                                        if (this.B == 1) {
                                                            if (this.b.getAdSpaceT() != 2) {
                                                                this.x.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                                                            } else {
                                                                this.x.getJSContainerModule().showVideoEndCover();
                                                            }
                                                        }
                                                    } else if (this.b.getAdSpaceT() != 2) {
                                                        this.x.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                                                    } else {
                                                        this.x.getJSContainerModule().showVideoEndCover();
                                                    }
                                                    this.x.getJSVideoModule().dismissAllAlert();
                                                    if (i3 == 12 && !this.C && this.B == 1) {
                                                        k();
                                                        j();
                                                        h();
                                                        i();
                                                        if (r0.a().a("i_l_s_t_r_i", false) && !this.A) {
                                                            this.A = true;
                                                            MBridgeVideoView.u uVar = this.D;
                                                            if (uVar != null) {
                                                                uVar.a();
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 13:
                                                    if (!this.x.getJSVideoModule().isH5Canvas()) {
                                                        this.x.getJSVideoModule().closeVideoOperate(0, 2);
                                                    }
                                                    this.x.getJSNotifyProxy().a(-1);
                                                    break;
                                                case 14:
                                                    if (!this.z) {
                                                        this.x.getJSVideoModule().closeVideoOperate(0, 1);
                                                        break;
                                                    }
                                                    break;
                                                case 15:
                                                    if (obj != null && (obj instanceof MBridgeVideoView.v)) {
                                                        this.z = true;
                                                        this.x.getJSNotifyProxy().a((MBridgeVideoView.v) obj);
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case INVALID_RI_ENDPOINT_VALUE:
                                                        case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                                                            this.x.getJSNotifyProxy().a(i3 == 123 ? 7 : 6, "");
                                                            break;
                                                        case INVALID_METRICS_ENDPOINT_VALUE:
                                                            this.x.getJSContainerModule().hideAlertWebview();
                                                            break;
                                                    }
                                            }
                                        } else {
                                            com.mbridge.msdk.video.signal.j jSVideoModule2 = this.x.getJSVideoModule();
                                            this.x.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                        }
                                    } else if (this.x.getJSCommon().i() == 2) {
                                        com.mbridge.msdk.video.signal.j jSVideoModule3 = this.x.getJSVideoModule();
                                        this.x.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                    }
                                } else if (r0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                                    this.D = (MBridgeVideoView.u) obj;
                                }
                            } else if (this.x.getJSContainerModule().showAlertWebView()) {
                                this.x.getJSVideoModule().alertWebViewShowed();
                            } else {
                                this.x.getJSVideoModule().showAlertView();
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        Integer num = ((Integer) obj).intValue() == 1 ? 2 : 1;
                        this.x.getJSVideoModule().soundOperate(num.intValue(), -1);
                        this.x.getJSNotifyProxy().a(5, num + "");
                    }
                }
                this.x.getJSVideoModule().dismissAllAlert();
                if (i3 == 2) {
                    this.x.getJSNotifyProxy().a(2, "");
                }
                this.x.getJSVideoModule().videoOperate(3);
                if (this.x.getJSCommon().i() != 2) {
                    if (this.b.getVideo_end_type() != 3) {
                        this.x.getJSVideoModule().setVisible(8);
                    } else {
                        this.x.getJSVideoModule().setVisible(0);
                    }
                    if (this.y == 2 && !this.x.getJSContainerModule().endCardShowing() && this.b.getAdSpaceT() != 2) {
                        this.x.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                        this.x.getJSNotifyProxy().a(1);
                    }
                }
                i3 = 16;
                this.x.getJSNotifyProxy().a(1);
            } else if (!this.x.getJSContainerModule().endCardShowing()) {
                this.x.getJSNotifyProxy().a(1, obj != null ? obj.toString() : "");
            }
        }
        super.a(i3, obj);
    }
}
