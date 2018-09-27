package com.mylhyl.pageloading;

import android.view.View;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public abstract class PageLoadingDelegate {

    /**
     * 获取加载数据视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getProgressLayout();

    /**
     * 获取空数据视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getEmptyLayout();

    /**
     * 获取错误视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorLayout();

    /**
     * 获取网络错误视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorNetLayout();

    /**
     * 获取加载数据视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getProgressTipViewId() {
        return View.NO_ID;
    }

    /**
     * 获取空数据视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getEmptyTipViewId() {
        return View.NO_ID;
    }

    /**
     * 获取错误视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getErrorTipViewId() {
        return View.NO_ID;
    }

    /**
     * 获取网络错误视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getErrorNetTipViewId() {
        return View.NO_ID;
    }
}
