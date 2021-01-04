package util;



import java.util.List;

/**
 * 分页查询工具类
 */
public class PageBean<E> {
    /**当前页*/
    private Integer currentPage;
    /**总页数*/
    private Integer pageCount;
    /**每页显示的条数*/
    private Integer pageSize;
    /**总记录数*/
    private Integer totalCount;
    /**起始页*/
    private Integer startIndex;
    /**通过分页查询返回值查询结果*/
    private List<E> resultList;

    /**
     * 获取起始页
     * @return
     */
    public Integer getStartIndex() {
        return (currentPage-1)*pageSize;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取总页数
     * @return
     */
    public Integer getPageCount() {
        return totalCount%pageSize != 0 ? totalCount/pageSize + 1 :totalCount/pageSize;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getResultList() {
        return resultList;
    }

    public void setResultList(List<E> resultList) {
        this.resultList = resultList;
    }
}
