package com.cl.entity.view;

import com.cl.entity.ZiyuanfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 资源分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-28 19:01:03
 */
@TableName("ziyuanfenlei")
public class ZiyuanfenleiView  extends ZiyuanfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZiyuanfenleiView(){
	}
 
 	public ZiyuanfenleiView(ZiyuanfenleiEntity ziyuanfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, ziyuanfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
