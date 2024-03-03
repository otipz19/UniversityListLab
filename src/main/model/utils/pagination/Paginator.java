package main.model.utils.pagination;

import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;

public class Paginator<T> {
    private final int pageSize;
    private final IMyList<T> list;
    private int curIndex;
    private int curPage;

    public Paginator(int pageSize, IMyList<T> list){
        this.pageSize = pageSize;
        this.list = list;
    }

    public boolean hasNextPage(){
        return curIndex < list.count() - 1;
    }

    public IMyList<T> getNextPage(){
        var page = new MyList<T>();
        int i;
        for(i = curIndex; i < list.count() && i < curIndex + pageSize; i++){
            page.add(list.getAt(i));
        }
        curIndex = i;
        curPage++;
        return page;
    }

    public int getPageSize(){
        return pageSize;
    }

    public int getCurPage(){
        return curPage;
    }

    public int getTotalPages(){
        return (int)Math.ceil((double)list.count() / pageSize);
    }
}
