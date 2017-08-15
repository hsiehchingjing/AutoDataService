package hayaa.dataservice.model;

public final class Paging {
    int PageIndex;//获取或设置起始页的页号，该页号是0基的
    int PageSize;//获取或设置每页的大小。注意：无论Paging是否允许为空，当PageSize=-1时，表示全量查询。 
}
