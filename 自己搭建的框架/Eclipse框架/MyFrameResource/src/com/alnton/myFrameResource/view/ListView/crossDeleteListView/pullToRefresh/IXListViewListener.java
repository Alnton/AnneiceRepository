package com.alnton.myFrameResource.view.ListView.crossDeleteListView.pullToRefresh;

/**
 * implements this interface to get refresh/load more event.
 */
public interface IXListViewListener
{
    public void onRefresh();
    
    public void onLoadMore();
}