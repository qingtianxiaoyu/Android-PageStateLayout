package com.mylhyl.pageloading;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by hupei on 2018/9/27 13:49.
 */
public class PageLoadingView extends FrameLayout implements PageLoading {

    private PageLoadingCreater mPageLoadingCreater = new PageLoadingCreater();

    public PageLoadingView(@NonNull Context context) {
        this(context, null);
    }

    public PageLoadingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageLoadingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.PageLoading);
        int progressLayout = ta.getResourceId(R.styleable.PageLoading_pl_progressLayout, NO_ID);
        int emptyLayout = ta.getResourceId(R.styleable.PageLoading_pl_emptyLayout, NO_ID);
        int errorLayout = ta.getResourceId(R.styleable.PageLoading_pl_errorLayout, NO_ID);
        int errorNetLayout = ta.getResourceId(R.styleable.PageLoading_pl_errorNetLayout, NO_ID);
        if (!isInEditMode()) {
            if (progressLayout != NO_ID)
                mPageLoadingCreater.setProgressLayout(progressLayout);
            if (emptyLayout != NO_ID)
                mPageLoadingCreater.setEmptyLayout(emptyLayout);
            if (errorLayout != NO_ID)
                mPageLoadingCreater.setErrorLayout(errorLayout);
            if (errorNetLayout != NO_ID)
                mPageLoadingCreater.setErrorNetLayout(errorNetLayout);
        }
        ta.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1) {
            throw new IllegalStateException("PageLoadingView can host only one direct child");
        }
        if (!isInEditMode()) {
            setRootView(this);
            View view = getChildAt(0);
            setContentView(view);
            mPageLoadingCreater.create();
        }
    }

    @Override
    public void setErrorClickShowProgress(boolean show) {
        mPageLoadingCreater.setErrorClickShowProgress(show);
    }

    @Override
    public void setRootView(View rootView) {
        mPageLoadingCreater.setRootView(rootView);
    }

    @Override
    public void setContentView(int contentId) {
        mPageLoadingCreater.setContentView(contentId);
    }

    @Override
    public void setContentView(View contentView) {
        mPageLoadingCreater.setContentView(contentView);
    }

    @Override
    public void setOnErrorListener(OnErrorClickListener listener) {
        mPageLoadingCreater.setOnErrorListener(listener);
    }

    @Override
    public void setOnErrorNetListener(OnErrorNetClickListener listener) {
        mPageLoadingCreater.setOnErrorNetListener(listener);
    }

    @Override
    public void setEmptyTip(int resId) {
        mPageLoadingCreater.setEmptyTip(resId);
    }

    @Override
    public void setErrorTip(int resId) {
        mPageLoadingCreater.setEmptyTip(resId);
    }

    @Override
    public void setErrorNetTip(int resId) {
        mPageLoadingCreater.setErrorNetTip(resId);
    }

    @Override
    public void showProgressView(int resId) {
        mPageLoadingCreater.showProgressView(resId);
    }

    @Override
    public void showProgressView() {
        mPageLoadingCreater.showProgressView();
    }

    @Override
    public void showContentView() {
        mPageLoadingCreater.showContentView();
    }

    @Override
    public void showEmptyView() {
        mPageLoadingCreater.showEmptyView();
    }

    @Override
    public void showErrorView() {
        mPageLoadingCreater.showErrorView();
    }

    @Override
    public void showErrorNetView() {
        mPageLoadingCreater.showErrorNetView();
    }

    @Override
    public View getEmptyView() {
        return mPageLoadingCreater.getEmptyView();
    }

    @Override
    public View getErrorView() {
        return mPageLoadingCreater.getErrorView();
    }

    @Override
    public View getErrorNetView() {
        return mPageLoadingCreater.getErrorNetView();
    }

    @Override
    public TextView getProgressTipView() {
        return mPageLoadingCreater.getProgressTipView();
    }

    @Override
    public void setProgressTip(int resId) {
        mPageLoadingCreater.setProgressTip(resId);
    }

    @Override
    public TextView getEmptyTipView() {
        return mPageLoadingCreater.getEmptyTipView();
    }

    @Override
    public void setEmptyTip(String text) {
        mPageLoadingCreater.setEmptyTip(text);
    }

    @Override
    public TextView getErrorTip() {
        return mPageLoadingCreater.getErrorTip();
    }

    @Override
    public void setErrorTip(String text) {
        mPageLoadingCreater.setErrorTip(text);
    }

    @Override
    public TextView getErrorNetTip() {
        return mPageLoadingCreater.getErrorNetTip();
    }

    @Override
    public void setErrorNetTip(String text) {
        mPageLoadingCreater.setErrorNetTip(text);
    }

    @Override
    public void create() {
        mPageLoadingCreater.create();
    }
}
