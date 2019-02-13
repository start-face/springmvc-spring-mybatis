package com.ssm.tools;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-03 16:01
 **/
public class PageInfo<T> implements java.io.Serializable {

    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //排序
    private String orderBy;

    //由于startRow和endRow不常用，这里说个具体的用法
    //可以在页面中"显示startRow到endRow 共size条数据"

    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

    //第一页
    private int firstPage;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //最后一页
    private int lastPage;

    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pageNum", pageNum)
                .add("pageSize", pageSize)
                .add("size", size)
                .add("orderBy", orderBy)
                .add("startRow", startRow)
                .add("endRow", endRow)
                .add("total", total)
                .add("pages", pages)
                .add("list", list)
                .add("firstPage", firstPage)
                .add("prePage", prePage)
                .add("nextPage", nextPage)
                .add("lastPage", lastPage)
                .add("isFirstPage", isFirstPage)
                .add("isLastPage", isLastPage)
                .add("hasPreviousPage", hasPreviousPage)
                .add("hasNextPage", hasNextPage)
                .add("navigatePages", navigatePages)
                .add("navigatepageNums", navigatepageNums)
                .toString();
    }

    public int getPageNum() {
        return pageNum;
    }

    public PageInfo<T> setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageInfo<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getSize() {
        return size;
    }

    public PageInfo<T> setSize(int size) {
        this.size = size;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public PageInfo<T> setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public int getStartRow() {
        return startRow;
    }

    public PageInfo<T> setStartRow(int startRow) {
        this.startRow = startRow;
        return this;
    }

    public int getEndRow() {
        return endRow;
    }

    public PageInfo<T> setEndRow(int endRow) {
        this.endRow = endRow;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public PageInfo<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public PageInfo<T> setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public PageInfo<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public PageInfo<T> setFirstPage(int firstPage) {
        this.firstPage = firstPage;
        return this;
    }

    public int getPrePage() {
        return prePage;
    }

    public PageInfo<T> setPrePage(int prePage) {
        this.prePage = prePage;
        return this;
    }

    public int getNextPage() {
        return nextPage;
    }

    public PageInfo<T> setNextPage(int nextPage) {
        this.nextPage = nextPage;
        return this;
    }

    public int getLastPage() {
        return lastPage;
    }

    public PageInfo<T> setLastPage(int lastPage) {
        this.lastPage = lastPage;
        return this;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public PageInfo<T> setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
        return this;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public PageInfo<T> setLastPage(boolean lastPage) {
        isLastPage = lastPage;
        return this;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public PageInfo<T> setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
        return this;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public PageInfo<T> setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public PageInfo<T> setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
        return this;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public PageInfo<T> setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
        return this;
    }
}
