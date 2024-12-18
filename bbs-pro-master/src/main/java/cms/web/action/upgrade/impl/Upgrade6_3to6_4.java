package cms.web.action.upgrade.impl;

import java.util.Date;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cms.bean.upgrade.UpgradeLog;
import cms.bean.upgrade.UpgradeSystem;
import cms.service.upgrade.UpgradeService;
import cms.utils.JsonUtils;
import cms.utils.SpringConfigTool;
import cms.web.action.favorite.QuestionFavoriteConfig;
import cms.web.action.favorite.TopicFavoriteConfig;
import cms.web.action.like.LikeConfig;
import cms.web.action.upgrade.UpgradeManage;
/**
 * 6.3升级到6.4版本执行程序
 *
 */
public class Upgrade6_3to6_4 {
	private static final Logger logger = LogManager.getLogger(Upgrade6_3to6_4.class);
	
	
	/**
	 * 运行
	 * @param upgradeId 升级Id
	 */
    public static void run(String upgradeId){
    	UpgradeService upgradeService = (UpgradeService)SpringConfigTool.getContext().getBean("upgradeServiceBean");
    	UpgradeManage upgradeManage = (UpgradeManage)SpringConfigTool.getContext().getBean("upgradeManage");
    	
    	for(int i =0; i< 100; i++){
    		upgradeManage.taskRunMark_delete();
			upgradeManage.taskRunMark_add(1L);
    		UpgradeSystem upgradeSystem = upgradeService.findUpgradeSystemById(upgradeId);
    		if(upgradeSystem == null || upgradeSystem.getRunningStatus().equals(9999)){
    			break;
    		}
    		if(upgradeSystem.getRunningStatus()>=40 && upgradeSystem.getRunningStatus()<200){
    			
				
    			updateSQL_disableusername(upgradeService);
    			upgradeService.addLog(upgradeId, JsonUtils.toJSONString(new UpgradeLog(new Date(),"表disableusername修改SQL成功",1))+",");
    			
    			updateSQL_systemsetting(upgradeService);
    			upgradeService.addLog(upgradeId, JsonUtils.toJSONString(new UpgradeLog(new Date(),"表systemsetting修改SQL成功",1))+",");
    			
    			//更改运行状态
				upgradeService.updateRunningStatus(upgradeId ,200,JsonUtils.toJSONString(new UpgradeLog(new Date(),"升级流程结束",1))+",");

    		}
    		
    		
    		if(upgradeSystem.getRunningStatus()>=200 && upgradeSystem.getRunningStatus()<9999){
    			//更改运行状态
				upgradeService.updateRunningStatus(upgradeId ,9999,JsonUtils.toJSONString(new UpgradeLog(new Date(),"升级完成",1))+",");

    		}
    		
    		
    		
    		
    	}
    	upgradeManage.taskRunMark_delete();
    }
    
  
	/**
	 * 修改disableusername表字段(修复6.2升级6.3版本用户不能注册的错误)
	 * @param upgradeService
	 */
    private static void updateSQL_disableusername(UpgradeService upgradeService){
    	String updateSQL = "UPDATE disableusername SET name = '*\\\\*' WHERE name = '*\\*';";
    	upgradeService.insertNativeSQL(updateSQL);
    }
    
    
    /**
	 * 修改systemsetting表字段
	 * @param upgradeService
	 */
    private static void updateSQL_systemsetting(UpgradeService upgradeService){
    	String updateSQL = "UPDATE systemsetting SET allowMentionMaxNumber=30;";
    	upgradeService.insertNativeSQL(updateSQL);
    }
}
