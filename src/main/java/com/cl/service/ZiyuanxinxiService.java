package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanxinxiView;


/**
 * 资源信息
 *
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
public interface ZiyuanxinxiService extends IService<ZiyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuanxinxiView> selectListView(Wrapper<ZiyuanxinxiEntity> wrapper);
   	
   	ZiyuanxinxiView selectView(@Param("ew") Wrapper<ZiyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuanxinxiEntity> wrapper);
   	

}

