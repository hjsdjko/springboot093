package com.cl.dao;

import com.cl.entity.DiscussziyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussziyuanxinxiView;


/**
 * 资源信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
public interface DiscussziyuanxinxiDao extends BaseMapper<DiscussziyuanxinxiEntity> {
	
	List<DiscussziyuanxinxiView> selectListView(@Param("ew") Wrapper<DiscussziyuanxinxiEntity> wrapper);

	List<DiscussziyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussziyuanxinxiEntity> wrapper);
	
	DiscussziyuanxinxiView selectView(@Param("ew") Wrapper<DiscussziyuanxinxiEntity> wrapper);
	

}
