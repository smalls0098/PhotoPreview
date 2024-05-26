package com.wgw.photo.preview.interfaces;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

public interface IViewHolder {

    void bindData(View view, @Nullable Object data, int position);

    void destroy();

    @LayoutRes int getLayoutId();

}
