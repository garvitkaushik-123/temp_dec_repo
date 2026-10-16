package com.bytedance.sdk.openadsdk.utils;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Pair;
import androidx.core.view.GravityCompat;
import com.ironsource.D5;
import io.ktor.util.date.GMTDateParser;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class du {
    private static final Map<String, Pair<? extends Drawable, Integer>> eli = new HashMap();
    private static Integer DbA = null;

    public static Drawable eli(Context context, String str) {
        return eli(context, str, true);
    }

    public static Drawable eli(Context context, String str, boolean z) {
        Pair<? extends Drawable, Integer> pair;
        DbA = Integer.valueOf(com.bytedance.sdk.openadsdk.core.dV.aGH().rn());
        new Object[]{"get drawable by code, ", "drawable name is: ".concat(String.valueOf(str))};
        Map<String, Pair<? extends Drawable, Integer>> map = eli;
        new Object[]{"drawableMap size is：", Integer.valueOf(map.size()), "and drawable content is: ", map};
        if (map.containsKey(str) && (pair = map.get(str)) != null) {
            Drawable drawable = (Drawable) pair.first;
            map.put(str, new Pair<>(drawable, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
            return drawable;
        }
        eli();
        return eli(str, context, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Drawable eli(String str, Context context, boolean z) {
        char c;
        Drawable drawable;
        Drawable drawable2;
        str.hashCode();
        switch (str.hashCode()) {
            case -2137782317:
                if (str.equals("tt_leftbackicon_selector_for_dark")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2023672829:
                if (str.equals("tt_dislike_dialog_bg")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -2010340681:
                if (str.equals("tt_leftbackbutton_titlebar_photo_preview")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1888785259:
                if (str.equals("tt_seek_progress")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1883903877:
                if (str.equals("tt_dislike_middle_seletor")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1881901373:
                if (str.equals("tt_ad_cover_btn_begin_bg")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1818605128:
                if (str.equals("tt_leftbackicon_selector")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1724866088:
                if (str.equals("tt_seek_thumb_normal")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1698792361:
                if (str.equals("tt_stop_movebar_textpage")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1500492368:
                if (str.equals("tt_backup_btn_1")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1308443384:
                if (str.equals("tt_ad_report_info_bg")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1222892514:
                if (str.equals("tt_playable_btn_bk")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1163545839:
                if (str.equals("tt_dislike_bottom_seletor")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1150582740:
                if (str.equals("tt_seek_thumb_fullscreen")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1147412691:
                if (str.equals("tt_custom_dialog_bg")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1107858393:
                if (str.equals("tt_ad_loading_three_mid")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -876774215:
                if (str.equals("tt_close_move_detail")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -875200849:
                if (str.equals("tt_mute_btn_bg")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -847552402:
                if (str.equals("tt_seek_thumb")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -561153052:
                if (str.equals("tt_reward_countdown_bg")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -508263579:
                if (str.equals("tt_play_movebar_textpage")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -473198695:
                if (str.equals("tt_refreshing_video_textpage")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -404284879:
                if (str.equals("tt_playable_progress_style")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -292612462:
                if (str.equals("tt_seek_thumb_fullscreen_selector")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -226695937:
                if (str.equals("tt_ad_landing_loading_three_mid")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -154809169:
                if (str.equals("tt_pangle_ad_mute_btn_bg")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -97103333:
                if (str.equals("tt_video_black_desc_gradient")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 16094728:
                if (str.equals("tt_ad_loading_three_left")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 27541452:
                if (str.equals("tt_mute_wrapper")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 57270120:
                if (str.equals("tt_dislike_top_bg")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 106179457:
                if (str.equals("tt_comment_tv")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 242455215:
                if (str.equals("tt_reward_full_new_bar_bg")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 247520514:
                if (str.equals("tt_reward_full_video_backup_btn_bg")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 310787585:
                if (str.equals("tt_full_reward_loading_progress_style")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case 314734139:
                if (str.equals("tt_detail_video_btn_bg")) {
                    c = '\"';
                    break;
                }
                c = 65535;
                break;
            case 410262782:
                if (str.equals("tt_pangle_banner_btn_bg")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 484030064:
                if (str.equals("tt_seek_thumb_fullscreen_press")) {
                    c = Typography.dollar;
                    break;
                }
                c = 65535;
                break;
            case 494589792:
                if (str.equals("tt_browser_download_selector")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case 504597563:
                if (str.equals("tt_ad_loading_three_right")) {
                    c = Typography.amp;
                    break;
                }
                c = 65535;
                break;
            case 507305701:
                if (str.equals("tt_pangle_btn_bg")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case 708409173:
                if (str.equals("tt_privacy_progress_style")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case 991946046:
                if (str.equals("tt_privacy_btn_bg")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 1054661938:
                if (str.equals("tt_seek_thumb_press")) {
                    c = GMTDateParser.ANY;
                    break;
                }
                c = 65535;
                break;
            case 1094767909:
                if (str.equals("tt_unmute_wrapper")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case 1115144587:
                if (str.equals("tt_titlebar_close_seletor_for_dark")) {
                    c = AbstractJsonLexerKt.COMMA;
                    break;
                }
                c = 65535;
                break;
            case 1193160467:
                if (str.equals("tt_ad_landing_loading_three_right")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case 1234814491:
                if (str.equals("tt_landingpage_loading_text_rect")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            case 1241312517:
                if (str.equals("tt_shadow_btn_back_withoutnight")) {
                    c = '/';
                    break;
                }
                c = 65535;
                break;
            case 1360033453:
                if (str.equals("tt_circle_solid_mian")) {
                    c = '0';
                    break;
                }
                c = 65535;
                break;
            case 1391934389:
                if (str.equals("tt_browser_progress_style")) {
                    c = '1';
                    break;
                }
                c = 65535;
                break;
            case 1459143575:
                if (str.equals("tt_download_corner_bg")) {
                    c = '2';
                    break;
                }
                c = 65535;
                break;
            case 1473061455:
                if (str.equals("tt_ad_report_info_button_bg")) {
                    c = '3';
                    break;
                }
                c = 65535;
                break;
            case 1562327088:
                if (str.equals("tt_ad_landing_loading_three_left")) {
                    c = '4';
                    break;
                }
                c = 65535;
                break;
            case 1635801742:
                if (str.equals("tt_pangle_ad_close_btn_bg")) {
                    c = '5';
                    break;
                }
                c = 65535;
                break;
            case 1733712735:
                if (str.equals("tt_lefterbackicon_titlebar_press_wrapper")) {
                    c = '6';
                    break;
                }
                c = 65535;
                break;
            case 1859118378:
                if (str.equals("tt_reward_video_download_btn_bg")) {
                    c = '7';
                    break;
                }
                c = 65535;
                break;
            case 1908435428:
                if (str.equals("tt_ad_loading_rect")) {
                    c = '8';
                    break;
                }
                c = 65535;
                break;
            case 1967077738:
                if (str.equals("tt_shadow_btn_back")) {
                    c = '9';
                    break;
                }
                c = 65535;
                break;
            case 1986221289:
                if (str.equals("tt_dislike_top_seletor")) {
                    c = AbstractJsonLexerKt.COLON;
                    break;
                }
                c = 65535;
                break;
            case 1987199879:
                if (str.equals("tt_video_loading_progress_bar")) {
                    c = ';';
                    break;
                }
                c = 65535;
                break;
            case 1995246663:
                if (str.equals("tt_ad_skip_btn_bg2")) {
                    c = Typography.less;
                    break;
                }
                c = 65535;
                break;
            case 2051103617:
                if (str.equals("tt_privacy_webview_bg")) {
                    c = D5.T;
                    break;
                }
                c = 65535;
                break;
            case 2091139328:
                if (str.equals("tt_titlebar_close_seletor")) {
                    c = Typography.greater;
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
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_lefterbackicon_titlebar_press_for_dark"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_lefterbackicon_titlebar_for_dark"));
                break;
            case 1:
                drawable2 = eli(0, -1, new int[]{SSo.DbA(context, 8.0f)}, null, null, null);
                break;
            case 2:
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_white_lefterbackicon_titlebar_press"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_white_lefterbackicon_titlebar"));
                break;
            case 3:
                drawable = new LayerDrawable(new Drawable[]{eli(0, Integer.valueOf(Color.parseColor("#A5FFFFFF")), new int[]{SSo.DbA(context, 1.5f)}, new int[]{-1, SSo.DbA(context, 1.0f)}, null, null), new ClipDrawable(eli(0, -1, new int[]{SSo.DbA(context, 1.5f)}, new int[]{-1, SSo.DbA(context, 1.0f)}, null, null), GravityCompat.START, 1), new ClipDrawable(eli(0, Integer.valueOf(Color.parseColor("#fff85959")), new int[]{SSo.DbA(context, 1.5f)}, new int[]{-1, SSo.DbA(context, 1.0f)}, null, null), GravityCompat.START, 1)});
                drawable2 = drawable;
                break;
            case 4:
                drawable2 = eli(eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fde6e6e6")), null, null, null, null), eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fdffffff")), null, null, null, null));
                break;
            case 5:
                drawable2 = eli(eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_2a90d7")), new int[]{SSo.DbA(context, 6.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "@color/tt_7f2a90d7"))), eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_2a90d7")), new int[]{SSo.DbA(context, 6.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "@color/tt_2a90d7"))));
                break;
            case 6:
                drawable2 = com.bytedance.sdk.component.utils.ev.Os(context, "tt_lefterbackicon_titlebar");
                break;
            case 7:
                drawable2 = eli(1, -1, null, new int[]{SSo.DbA(context, 15.0f), SSo.DbA(context, 15.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0);
                break;
            case '\b':
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_new_pause_video_press"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_new_pause_video"));
                break;
            case '\t':
                drawable2 = eli(eli(0, Integer.valueOf(Color.parseColor("#33f32830")), new int[]{SSo.DbA(context, 4.0f)}, null, null, null), eli(0, Integer.valueOf(Color.parseColor("#f32830")), new int[]{SSo.DbA(context, 4.0f)}, null, null, null));
                break;
            case '\n':
                drawable2 = eli(0, -1, new int[]{SSo.DbA(context, 12.0f), SSo.DbA(context, 12.0f), 0, 0}, null, null, null);
                break;
            case 11:
                drawable2 = eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_00000000")), new int[]{SSo.DbA(context, 30.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.0f)), -1);
                break;
            case '\f':
                drawable2 = eli(eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fde6e6e6")), new int[]{0, 0, SSo.DbA(context, 5.0f), SSo.DbA(context, 5.0f)}, null, null, null), eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fdffffff")), new int[]{0, 0, SSo.DbA(context, 5.0f), SSo.DbA(context, 5.0f)}, null, null, null));
                break;
            case '\r':
                drawable2 = eli(1, -1, null, new int[]{SSo.DbA(context, 18.0f), SSo.DbA(context, 18.0f)}, null, null);
                break;
            case 14:
                drawable2 = eli(0, -1, new int[]{SSo.DbA(context, 6.0f)}, null, Integer.valueOf(SSo.DbA(context, 0.8f)), -1);
                break;
            case 15:
                drawable2 = eli(0, null, null, null, Integer.valueOf(SSo.DbA(context, 1.5f)), -1);
                break;
            case 16:
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_close_move_details_pressed"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_close_move_details_normal"));
                break;
            case 17:
                drawable2 = eli(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{SSo.DbA(context, 28.0f), SSo.DbA(context, 28.0f)}, null, null);
                break;
            case 18:
                drawable2 = eli(eli(1, -1, null, new int[]{SSo.DbA(context, 22.0f), SSo.DbA(context, 22.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0), eli(1, -1, null, new int[]{SSo.DbA(context, 15.0f), SSo.DbA(context, 15.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0));
                break;
            case 19:
                drawable2 = eli(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{SSo.DbA(context, 28.0f), SSo.DbA(context, 28.0f)}, null, null);
                break;
            case 20:
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_new_play_video"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_new_play_video"));
                break;
            case 21:
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_refreshing_video_textpage_pressed"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_refreshing_video_textpage_normal"));
                break;
            case 22:
                drawable = new LayerDrawable(new Drawable[]{eli(0, Integer.valueOf(Color.parseColor("#4DFC625C")), new int[]{SSo.DbA(context, 3.0f)}, null, null, null), new ClipDrawable(eli(0, Integer.valueOf(Color.parseColor("#FC625C")), new int[]{SSo.DbA(context, 3.0f)}, null, null, null), GravityCompat.START, 1)});
                drawable2 = drawable;
                break;
            case 23:
                drawable2 = eli(eli(1, -1, null, new int[]{SSo.DbA(context, 18.0f), SSo.DbA(context, 18.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0), eli(1, -1, null, new int[]{SSo.DbA(context, 18.0f), SSo.DbA(context, 18.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0));
                break;
            case 24:
                drawable2 = eli(0, null, null, null, Integer.valueOf(SSo.DbA(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case 25:
                drawable2 = eli(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{SSo.DbA(context, 28.0f), SSo.DbA(context, 28.0f)}, null, null);
                break;
            case 26:
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setGradientType(0);
                gradientDrawable.setColors(new int[]{com.bytedance.sdk.component.utils.ev.kb(context, "tt_ff1a1a1a"), com.bytedance.sdk.component.utils.ev.kb(context, "tt_00000000")});
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                drawable = gradientDrawable;
                drawable2 = drawable;
                break;
            case 27:
                drawable2 = eli(0, null, new int[]{SSo.DbA(context, 6.0f), 0, 0, SSo.DbA(context, 6.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.5f)), -1);
                break;
            case 28:
                Drawable Os = com.bytedance.sdk.component.utils.ev.Os(context, "tt_mute");
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[0], Os);
                stateListDrawable.setAutoMirrored(true);
                drawable = stateListDrawable;
                drawable2 = drawable;
                break;
            case 29:
                drawable2 = eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fdffffff")), new int[]{SSo.DbA(context, 5.0f), SSo.DbA(context, 5.0f), 0, 0}, null, null, null);
                break;
            case 30:
                drawable2 = eli(0, -1, new int[]{SSo.DbA(context, 4.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.0f)), Integer.valueOf(Color.parseColor("#0F161823")));
                break;
            case 31:
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#ccffffff")), new int[]{SSo.DbA(context, 18.0f)}, null, null, null);
                break;
            case ' ':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#ff0088ff")), new int[]{SSo.DbA(context, 6.0f)}, null, null, null);
                break;
            case '!':
                GradientDrawable eli2 = eli(0, Integer.valueOf(Color.parseColor("#EAEAEA")), new int[]{SSo.DbA(context, 50.0f)}, null, null, null);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(SSo.DbA(context, 15.0f));
                gradientDrawable2.setColors(new int[]{Color.parseColor("#1A73E8"), Color.parseColor("#569FFF")});
                gradientDrawable2.setGradientType(0);
                gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                drawable2 = new LayerDrawable(new Drawable[]{eli2, new ScaleDrawable(gradientDrawable2, GravityCompat.START, 1.0f, -1.0f)});
                break;
            case '\"':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#26000000")), new int[]{SSo.DbA(context, 4.0f)}, null, null, null);
                break;
            case '#':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#ff2f87f8")), new int[]{SSo.DbA(context, 2.0f)}, new int[]{SSo.DbA(context, 98.0f), SSo.DbA(context, 25.0f)}, null, null);
                break;
            case '$':
                drawable2 = eli(1, -1, null, new int[]{SSo.DbA(context, 18.0f), SSo.DbA(context, 18.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0);
                break;
            case '%':
                drawable2 = eli(eli(0, Integer.valueOf(Color.parseColor("#2582c3")), null, null, null, null), eli(0, Integer.valueOf(Color.parseColor("#2a90d7")), null, null, null, null));
                break;
            case '&':
                drawable2 = eli(0, null, new int[]{0, SSo.DbA(context, 6.0f), SSo.DbA(context, 6.0f), 0}, null, Integer.valueOf(SSo.DbA(context, 1.5f)), -1);
                break;
            case '\'':
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setShape(0);
                gradientDrawable3.setSize(SSo.DbA(context, 280.0f), SSo.DbA(context, 38.0f));
                gradientDrawable3.setCornerRadius(SSo.DbA(context, 19.0f));
                gradientDrawable3.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable3.setColors(new int[]{Color.parseColor("#fff02d42"), Color.parseColor("#fffc4b3c")});
                gradientDrawable3.setGradientType(0);
                gradientDrawable3.setUseLevel(true);
                drawable = gradientDrawable3;
                drawable2 = drawable;
                break;
            case '(':
                drawable2 = new LayerDrawable(new Drawable[]{eli(0, Integer.valueOf(Color.parseColor("#33007AFF")), null, null, null, null), new ClipDrawable(eli(0, Integer.valueOf(Color.parseColor("#007AFF")), null, null, null, null), GravityCompat.START, 1)});
                break;
            case ')':
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setShape(0);
                gradientDrawable4.setSize(SSo.DbA(context, 258.0f), SSo.DbA(context, 43.0f));
                gradientDrawable4.setCornerRadius(SSo.DbA(context, 22.0f));
                gradientDrawable4.setColors(new int[]{Color.parseColor("#73CBFC"), Color.parseColor("#3F9CF7")});
                gradientDrawable4.setGradientType(0);
                drawable = gradientDrawable4;
                drawable2 = drawable;
                break;
            case '*':
                drawable2 = eli(1, -1, null, new int[]{SSo.DbA(context, 22.0f), SSo.DbA(context, 22.0f)}, Integer.valueOf(SSo.DbA(context, 1.0f)), 0);
                break;
            case '+':
                Drawable Os2 = com.bytedance.sdk.component.utils.ev.Os(context, "tt_unmute");
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[0], Os2);
                stateListDrawable2.setAutoMirrored(true);
                drawable = stateListDrawable2;
                drawable2 = drawable;
                break;
            case ',':
                drawable2 = eli(com.bytedance.sdk.component.utils.ev.Os(context, "tt_titlebar_close_press_for_dark"), com.bytedance.sdk.component.utils.ev.Os(context, "tt_titlebar_close_for_dark"));
                break;
            case '-':
                drawable2 = eli(0, null, new int[]{0, SSo.DbA(context, 6.0f), SSo.DbA(context, 6.0f), 0}, null, Integer.valueOf(SSo.DbA(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case '.':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#141A73E8")), new int[]{SSo.DbA(context, 5.0f)}, null, null, null);
                break;
            case '/':
                Drawable Os3 = com.bytedance.sdk.component.utils.ev.Os(context, "tt_shadow_lefterback_titlebar_press_withoutnight");
                StateListDrawable eli3 = eli(Os3, com.bytedance.sdk.component.utils.ev.Os(context, "tt_shadow_lefterback_titlebar_withoutnight"));
                eli3.addState(new int[]{-16842910}, Os3);
                drawable2 = eli3;
                break;
            case '0':
                drawable2 = eli(1, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_e0e0e0")), null, null, null, null);
                break;
            case '1':
                drawable2 = new LayerDrawable(new Drawable[]{eli(0, -1, new int[]{0}, null, null, null), new ClipDrawable(eli(0, Integer.valueOf(Color.parseColor("#1A73E8")), new int[]{0}, null, null, null), 3, 1)});
                break;
            case '2':
                drawable2 = eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_4a90e2")), new int[]{SSo.DbA(context, 4.0f)}, null, null, null);
                break;
            case '3':
                drawable2 = eli(eli(0, Integer.valueOf(Color.parseColor("#0D000000")), new int[]{SSo.DbA(context, 2.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.0f)), Integer.valueOf(Color.parseColor("#1F000000"))), eli(0, -1, new int[]{SSo.DbA(context, 2.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.0f)), Integer.valueOf(Color.parseColor("#1618231F"))));
                break;
            case '4':
                drawable2 = eli(0, null, new int[]{SSo.DbA(context, 6.0f), 0, 0, SSo.DbA(context, 6.0f)}, null, Integer.valueOf(SSo.DbA(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case '5':
                drawable2 = eli(1, Integer.valueOf(Color.parseColor("#30333333")), null, new int[]{SSo.DbA(context, 28.0f), SSo.DbA(context, 28.0f)}, null, null);
                break;
            case '6':
                Drawable Os4 = com.bytedance.sdk.component.utils.ev.Os(context, "tt_lefterbackicon_titlebar_press");
                StateListDrawable stateListDrawable3 = new StateListDrawable();
                stateListDrawable3.addState(new int[0], Os4);
                stateListDrawable3.setAutoMirrored(true);
                drawable = stateListDrawable3;
                drawable2 = drawable;
                break;
            case '7':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#ff007aff")), new int[]{SSo.DbA(context, 18.0f)}, null, null, null);
                break;
            case '8':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#33FFFFFF")), new int[]{SSo.DbA(context, 15.0f)}, null, null, null);
                break;
            case '9':
                Drawable Os5 = com.bytedance.sdk.component.utils.ev.Os(context, "tt_shadow_lefterback_titlebar_press");
                StateListDrawable eli4 = eli(Os5, com.bytedance.sdk.component.utils.ev.Os(context, "tt_shadow_lefterback_titlebar"));
                eli4.addState(new int[]{-16842910}, Os5);
                drawable2 = eli4;
                break;
            case ':':
                drawable2 = eli(eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fde6e6e6")), new int[]{SSo.DbA(context, 5.0f), SSo.DbA(context, 5.0f), 0, 0}, null, null, null), eli(0, Integer.valueOf(com.bytedance.sdk.component.utils.ev.kb(context, "tt_fdffffff")), new int[]{SSo.DbA(context, 5.0f), SSo.DbA(context, 5.0f), 0, 0}, null, null, null));
                break;
            case ';':
                RotateDrawable rotateDrawable = new RotateDrawable();
                rotateDrawable.setDrawable(com.bytedance.sdk.component.utils.ev.Os(context, "tt_normalscreen_loading"));
                rotateDrawable.setFromDegrees(0.0f);
                rotateDrawable.setToDegrees(360.0f);
                rotateDrawable.setPivotX(0.5f);
                rotateDrawable.setPivotY(0.5f);
                drawable = rotateDrawable;
                drawable2 = drawable;
                break;
            case '<':
                drawable2 = eli(0, Integer.valueOf(Color.parseColor("#66161823")), new int[]{SSo.DbA(context, 14.0f)}, null, null, null);
                break;
            case '=':
                drawable2 = eli(0, -1, new int[]{SSo.DbA(context, 14.5f)}, null, null, null);
                break;
            case '>':
                drawable2 = com.bytedance.sdk.component.utils.ev.Os(context, "tt_titlebar_close_drawable");
                break;
            default:
                drawable2 = null;
                break;
        }
        if (z) {
            eli.put(str, new Pair<>(drawable2, 1));
        }
        return drawable2;
    }

    private static void eli() {
        Map<String, Pair<? extends Drawable, Integer>> map = eli;
        if (map.size() < DbA.intValue()) {
            return;
        }
        String str = null;
        int i = Integer.MAX_VALUE;
        for (Map.Entry<String, Pair<? extends Drawable, Integer>> entry : map.entrySet()) {
            if (((Integer) entry.getValue().second).intValue() < i) {
                str = entry.getKey();
                i = ((Integer) entry.getValue().second).intValue();
                if (i == 1) {
                    break;
                }
            }
        }
        eli.remove(str);
    }

    private static GradientDrawable eli(int i, Integer num, int[] iArr, int[] iArr2, Integer num2, Integer num3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i);
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        int length = iArr != null ? iArr.length : 0;
        if (length == 1) {
            gradientDrawable.setCornerRadius(iArr[0]);
        } else if (length == 4) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            gradientDrawable.setCornerRadii(new float[]{i2, i2, i3, i3, i4, i4, i5, i5});
        }
        if (iArr2 != null && iArr2.length == 2) {
            gradientDrawable.setSize(iArr2[0], iArr2[1]);
        }
        if (num2 != null && num3 != null) {
            gradientDrawable.setStroke(num2.intValue(), num3.intValue());
        }
        return gradientDrawable;
    }

    private static StateListDrawable eli(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (drawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
        }
        if (drawable2 != null) {
            stateListDrawable.addState(new int[0], drawable2);
        }
        return stateListDrawable;
    }

    public static Drawable eli(Context context, int i) {
        return eli(context, Color.parseColor("#1A73E8"), i);
    }

    public static Drawable eli(Context context, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(SSo.DbA(context, i2));
        return gradientDrawable;
    }
}
