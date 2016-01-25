package cn.refactor.library;

import android.content.Context;

/**
 * 作者 : andy
 * 日期 : 16/1/21 12:07
 * 邮箱 : andyxialm@gmail.com
 * 描述 : 工具类
 */
public class CompatUtils {
    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
