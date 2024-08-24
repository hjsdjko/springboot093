package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiyuanfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanfenleiView;


/**
 * 资源分类
 *
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
public interface ZiyuanfenleiService extends IService<ZiyuanfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuanfenleiView> selectListView(Wrapper<ZiyuanfenleiEntity> wrapper);
   	
   	ZiyuanfenleiView selectView(@Param("ew") Wrapper<ZiyuanfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuanfenleiEntity> wrapper);
   	

}

