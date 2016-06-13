package com.brilliantbear.wallpapers.view;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.brilliantbear.wallpapers.R;
import com.brilliantbear.wallpapers.adapter.ListAdapter;
import com.brilliantbear.wallpapers.bean.ObjectsBean;
import com.brilliantbear.wallpapers.bean.ResultBean;
import com.brilliantbear.wallpapers.presenter.IPresenter;
import com.brilliantbear.wallpapers.presenter.PresenterCompl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bear on 2016-6-12.
 */
public class ListFragment extends Fragment implements IView<ResultBean>, OnRefreshListener, OnLoadMoreListener, ListAdapter.OnItemClickListener {


    private View mRootView;
    private RecyclerView listImg;
    private ListAdapter mAdapter;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private IPresenter<ResultBean> mPresenter;
    private List<ObjectsBean> objectsBeens;
    private SwipeToLoadLayout mSwipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null)
            mRootView = inflater.inflate(R.layout.fragment_list, container, false);
        listImg = (RecyclerView) mRootView.findViewById(R.id.swipe_target);
        mSwipe = (SwipeToLoadLayout) mRootView.findViewById(R.id.swipeToLoadLayout);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        objectsBeens = new ArrayList<>();
        mAdapter = new ListAdapter(mContext, objectsBeens);
        mAdapter.setOnItemClickListener(this);
        mLayoutManager = new LinearLayoutManager(mContext);
        listImg.setLayoutManager(mLayoutManager);
        listImg.setAdapter(mAdapter);

        mSwipe.setOnRefreshListener(this);
        mSwipe.setOnLoadMoreListener(this);

        mPresenter = new PresenterCompl(mContext, this);
        ResultBean cache = mPresenter.getCache();
        if (cache != null && cache.getObjects() != null) {
            objectsBeens.addAll(cache.getObjects());
            mAdapter.notifyDataSetChanged();
        }
//        mPresenter.getData(0);
        mSwipe.setRefreshing(true);
    }

    @Override
    public void showProgress() {

    }


    @Override
    public void hideProgress() {
        if (mSwipe.isRefreshing()) {
            mSwipe.setRefreshing(false);
        } else if (mSwipe.isLoadingMore()) {
            mSwipe.setLoadingMore(false);
        }
    }

    @Override
    public void showData(ResultBean data) {
        if (mSwipe.isRefreshing()) {
            objectsBeens.clear();
        }
        objectsBeens.addAll(data.getObjects());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSth(String sth) {
        Snackbar.make(mRootView, sth, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        Log.d("TAG", "refresh");
        mPresenter.getData(0);
    }

    @Override
    public void onLoadMore() {
        Log.d("TAG", "load more");
        mPresenter.getData(objectsBeens.size());
    }

    @Override
    public void onClick(View view, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("将该图片设置成壁纸?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.setWallpaper(objectsBeens.get(position).getUrl());
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }
}
