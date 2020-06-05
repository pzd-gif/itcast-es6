package cn.itcast.test;

import cn.itcast.pojo.TbItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations="classpath:applicationContext-solr.xml")
public class TestTemplate {
    @Autowired
    private SolrTemplate template;

    //增加（修改）
    /*@Test
    public void testAdd(){
        TbItem item = new TbItem();
        item.setId(1L);
        item.setBrand("华为");
        item.setGoodsId(1L);
        item.setSeller("华为2号专卖店");
        item.setTitle("华为mate9");
        item.setPrice(new BigDecimal(2000));
        template.saveBean(item);
        template.commit();
    }*/
    //按主键查询
    /*@Test
    public void search(){
        TbItem item = template.getById(1, TbItem.class);
        System.out.println(item.getTitle());

    }*/

    //按主键删除
    /*@Test
    public void delete(){
        template.deleteById("1");
        template.commit();
    }*/

    //首先循环插入100条测试数据
    /*@Test
    public void testAddList(){
        List<TbItem> list=new ArrayList();

        for(int i=0;i<100;i++){
            TbItem item=new TbItem();
            item.setId(i+1L);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为2号专卖店");
            item.setTitle("华为Mate"+i);
            item.setPrice(new BigDecimal(2000+i));
            list.add(item);
        }

        template.saveBeans(list);
        template.commit();*
    }*/

    //分页查询
   /* @Test
    public void testPageQuery(){
        Query query=new SimpleQuery("*:*");
        query.setOffset(20);//开始索引（默认0）
        query.setRows(20);//每页记录数(默认10)
        ScoredPage<TbItem> page = template.queryForPage(query, TbItem.class);
        System.out.println("总记录数："+page.getTotalElements());
        List<TbItem> list = page.getContent();
        showList(list);
    }*/
    //显示记录数据
    private void showList(List<TbItem> list){
        for(TbItem item:list){
            System.out.println(item.getTitle() +item.getPrice());
        }
    }

    //条件查询
    @Test
    public void testPageQueryMutil(){
        Query query=new SimpleQuery("*:*");
        Criteria criteria=new Criteria("item_title").contains("2");
        criteria=criteria.and("item_title").contains("5");
        query.addCriteria(criteria);
        //query.setOffset(20);//开始索引（默认0）
        //query.setRows(20);//每页记录数(默认10)
        ScoredPage<TbItem> page = template.queryForPage(query, TbItem.class);
        System.out.println("总记录数："+page.getTotalElements());
        List<TbItem> list = page.getContent();
        showList(list);
    }

    //删除全部数据
    @Test
    public void testDeleteAll(){
        Query query=new SimpleQuery("*:*");
        template.delete(query);
        template.commit();
    }
}
