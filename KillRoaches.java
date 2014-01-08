package scripts;

import org.tribot.api.input.Mouse;
import org.tribot.api.rs3.*;
import org.tribot.api.rs3.types.*;
import org.tribot.api.rs3.util.ThreadSettings;
import org.tribot.api.rs3.util.ThreadSettings.MODEL_CLICKING_METHOD;
import org.tribot.api.General;



public class KillRoaches{

	public static void fightRoaches()  {
			ScreenModel[] cockRoach = ScreenModels.findNearest(RS3CockRoachSoldiers.CockRoach1);  
			ScreenModel[] cockRoach2 = ScreenModels.findNearest(RS3CockRoachSoldiers.CockRoach2); 
			ScreenModel cockRoachRC1 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.CockRoach1);
			ScreenModel cockRoachRC2 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.CockRoach2);
			
			/* Lets check again we dont want to die or miss out on our loot*/
			if (Looting.lootOnScreen())	{
					Looting.lootGoods();
					General.sleep(500, 1000);
			}
			
			if(Backpack.find(RS3CockRoachSoldiers.monkFish).length >= 1 && Game.getHitpoints() <= 1500){
				ClickableMovements.eatFood();
				General.sleep(100, 300);
			}
			
			if (cockRoach.length > 0)	{	
					if(cockRoach[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				
						Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
						General.sleep(500, 700);
						RandomizedClicks.clickScreenModel(cockRoachRC1, "Attack", -2, 6, -3, 9);
						General.sleep(100, 300);
						while(Player.getAnimation() > 0){
						General.sleep(3000, 5000);
						}
					}else{ Camera.setRotation(50 + General.random(0, 30)); General.sleep(1500, 2000); }	
			
			} else 	if (cockRoach2.length > 0)	{	
					if(cockRoach2[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				
						Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
						General.sleep(500, 700);
						RandomizedClicks.clickScreenModel(cockRoachRC2, "Attack", -2, 6, -3, 9);
						General.sleep(100, 300);
						while(Player.getAnimation() > 0){
						General.sleep(3000, 5000);
						}
					}else{ Camera.setRotation(50 + General.random(0, 30)); General.sleep(1500, 2000); }	
			} 
	}
}
