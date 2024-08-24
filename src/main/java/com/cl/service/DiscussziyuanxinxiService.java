package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussziyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussziyuanxinxiView;


/**
 * 资源信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
public interface DiscussziyuanxinxiService extends IService<DiscussziyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussziyuanxinxiView> selectListView(Wrapper<DiscussziyuanxinxiEntity> wrapper);
   	
   	DiscussziyuanxinxiView selectView(@Param("ew") Wrapper<DiscussziyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussziyuanxinxiEntity> wrapper);
   	

}

