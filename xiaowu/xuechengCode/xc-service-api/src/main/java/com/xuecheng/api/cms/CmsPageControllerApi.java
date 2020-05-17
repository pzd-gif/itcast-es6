package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * create by admin on 2020/5/5
 */
@Api(value = "页面管理接口",description = "页面管理接口,提供了页面的增删改查")
public interface CmsPageControllerApi {
    // 分页查询页面列表
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "size",value = "每页显示的条数",required = true,paramType = "path",dataType = "int"),
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
