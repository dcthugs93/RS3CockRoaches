package scripts;

import org.tribot.api.input.Mouse;
import org.tribot.api.rs3.*;
import org.tribot.api.rs3.types.*;
import org.tribot.api.rs3.util.ThreadSettings;
import org.tribot.api.rs3.util.ThreadSettings.MODEL_CLICKING_METHOD;
import org.tribot.api.General;



public class Looting{


	public static boolean lootOnScreen(){
			ScreenModel[] RuneSQ = ScreenModels.findNearest(RS3CockRoachSoldiers.runeSQ);
			ScreenModel[] RuneSC = ScreenModels.findNearest(RS3CockRoachSoldiers.runeSC);
			ScreenModel[] LawRune = ScreenModels.findNearest(RS3CockRoachSoldiers.lawRune);
			ScreenModel[] MithrilOre = ScreenModels.findNearest(RS3CockRoachSoldiers.mithrilOre);
			ScreenModel[] AdamantiteOre = ScreenModels.findNearest(RS3CockRoachSoldiers.adamantiteOre);
			
			if(RuneSQ.length > 0 || RuneSC.length > 0 || LawRune.length > 0 || MithrilOre.length > 0 || AdamantiteOre.length > 0){
				return true;
			}
		return false;
	}

	public static void lootGoods(){

		ScreenModel[] RuneSQ = ScreenModels.findNearest(RS3CockRoachSoldiers.runeSQ);
		ScreenModel[] RuneSC = ScreenModels.findNearest(RS3CockRoachSoldiers.runeSC);
		ScreenModel[] LawRune = ScreenModels.findNearest(RS3CockRoachSoldiers.lawRune);
		ScreenModel[] MithrilOre = ScreenModels.findNearest(RS3CockRoachSoldiers.mithrilOre);
		ScreenModel[] AdamantiteOre = ScreenModels.findNearest(RS3CockRoachSoldiers.adamantiteOre);
		ScreenModel RuneSQ1 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.runeSQ);
		ScreenModel RuneSC1 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.runeSC);
		ScreenModel LawRune1 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.lawRune);
		ScreenModel MithrilOre1 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.mithrilOre);
		ScreenModel AdamantiteOre1 = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.adamantiteOre);
	
		if (RuneSQ.length > 0)	{
			if(RuneSQ[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				  
				Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
				General.sleep(500, 700);
				RandomizedClicks.clickScreenModel(RuneSQ1, "Take Rune", -2, 2, -3, 3);
				General.sleep(2000, 3000);
			}else { Camera.setRotation(General.random(60, 120)); General.sleep(1000, 1500); }
		} else
		
		if (RuneSC.length > 0)	{
			if(RuneSC[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				  
				Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
				General.sleep(500, 700);
				RandomizedClicks.clickScreenModel(RuneSC1, "Take Rune", -2, 2, -3, 3);
				General.sleep(2000, 3000);
			}else { Camera.setRotation(General.random(60, 120)); General.sleep(1000, 1500); }
		} else
		
		if (LawRune.length > 0)	{
			if(LawRune[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				  
				Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
				General.sleep(500, 700);
				RandomizedClicks.clickScreenModel(LawRune1, "Take Law Rune", -2, 2, -3, 3);
				General.sleep(2000, 3000);
			}else { Camera.setRotation(General.random(60, 120)); General.sleep(1000, 1500); }
		} else
		
		if (MithrilOre.length > 0)	{
			if(MithrilOre[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				  
				Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
				General.sleep(500, 700);
				RandomizedClicks.clickScreenModel(MithrilOre1, "Take Mithril", -2, 2, -3, 3);
				General.sleep(2000, 3000);
			}else { Camera.setRotation(General.random(60, 120)); General.sleep(1000, 1500); }
		} else
		
		if (AdamantiteOre.length > 0)	{
			if(AdamantiteOre[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){				  
				Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
				General.sleep(500, 700);
				RandomizedClicks.clickScreenModel(AdamantiteOre1, "Take Adamantite", -2, 2, -3, 3);
				General.sleep(2000, 3000);
			}else { Camera.setRotation(General.random(60, 120)); General.sleep(1000, 1500); }
		}
	}
	
}
