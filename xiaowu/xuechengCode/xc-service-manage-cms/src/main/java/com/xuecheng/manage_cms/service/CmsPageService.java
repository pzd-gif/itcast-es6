package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * create by admin on 2020/5/6
 */
@Service
public class CmsPageService {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        // 查询条件忽略
        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        // 分页条件
        // 页码
        if(page <= 0){
            page = 1;
        }
        page = page -1;
        // 每页显示的条数
        if(size <= 0){
            size = 10;
        }
        Pageable pageable = PageRequest.of(page,size);
        // 查询分页列表
        Page<CmsPage> pagePage = cmsPageRepository.findAll(pageable);
        // 组合返回对象
        QueryResult queryResult = new QueryResult();
        // 集合
        queryResult.setList(pagePage.getContent());
        // 总个数
        queryResult.setTotal(pagePage.getTotalElements());
        // 状态码
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}
