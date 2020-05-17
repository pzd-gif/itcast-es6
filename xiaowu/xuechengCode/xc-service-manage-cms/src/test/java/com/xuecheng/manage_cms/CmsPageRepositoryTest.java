package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * create by admin on 2020/5/6
 */
// 加载spring容器
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    private CmsPageRepository cmsPageRepository;
    @Test
    public void testFindAll(){
       //  System.out.println("findall");
        List<CmsPage> list = cmsPageRepository.findAll();
        System.out.println(list);
    }
    @Test
    public void testFindList(){
        // 分页的参数
        // page = 页码-1
        int page = 2;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        // 查询分页列表
        Page<CmsPage> pagePage = cmsPageRepository.findAll(pageable);
        // 获取集合
        System.out.println(pagePage.getContent());
    }
}
