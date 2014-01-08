package scripts;

import org.tribot.api.input.Mouse;
import org.tribot.api.rs3.*;
import org.tribot.api.rs3.types.*;
import org.tribot.api.rs3.util.ThreadSettings;
import org.tribot.api.rs3.util.ThreadSettings.MODEL_CLICKING_METHOD;
import org.tribot.api.General;


public class ClickableMovements{

	public static void clickOnCave()  {
			ScreenModel[] Cave = ScreenModels.findNearest(RS3CockRoachSoldiers.cave); 
			if (Cave.length > 0)	{	
				if(Cave[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){
					Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
					General.sleep(500, 700);
					Cave[0].click("Enter");
					General.sleep(2000, 3000);
			} else if(!Cave[0].isClickable(MODEL_CLICKING_METHOD.CENTRE) || !Cave[0].isVisible()){ Camera.setRotation(General.random(40, 80)); General.sleep(1000, 1500); }	
			
		}
	}

	
	public static void eatFood(){
		if(Backpack.find(RS3CockRoachSoldiers.monkFish).length >= 0){
		Backpack.find(RS3CockRoachSoldiers.monkFish)[0].click("Eat");
		} else { General.println("food not found");  WalkableMovements.walkToRope();}
	}
	
	
	public static void climbRope()  {
			EGWPosition PlayerPOS = EGW.getPosition();
			
			ScreenModel[] Rope = ScreenModels.findNearest(RS3CockRoachSoldiers.rope); 
			ScreenModel RopeClick = RandomizedClicks.getClosestModel(RS3CockRoachSoldiers.rope);
			if(Rope.length > 0 && EGW.getFloor() > 2)	{		
				if(Rope[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){	
					Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
					General.sleep(500, 700);
					RandomizedClicks.clickScreenModel(RopeClick, "Climb", -2, 2, -10, 15);
					General.sleep(2000, 3000);
					} else { Camera.setRotation(General.random(80, 100)); General.sleep(1000, 1500); }
			}
	}
	
		public static void bank() {
		ScreenModel[] banker = ScreenModels.findNearest(RS3CockRoachSoldiers.Banker); 

			if (banker.length > 0)	{	
				if(banker[0].isClickable(MODEL_CLICKING_METHOD.CENTRE)){
					Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
					General.sleep(500, 700);
					banker[0].click("Bank");
					General.sleep(500, 700);
				} else { Camera.setRotation(General.random(60, 120)); General.sleep(1500, 2000); }	
					if(Banking.isBankScreenOpen()){
						Banking.depositBackpack();
						General.sleep(2000, 3000);
						Banking.withdraw(10, RS3CockRoachSoldiers.monkFish);
						General.sleep(2000, 3000);
						Banking.close();
					 }
			}else{
			    Mouse.setSpeed(RS3CockRoachSoldiers.mouseSpeed);
                WebWalking.walkTo(RS3CockRoachSoldiers.Bank_Pos);
                while (Player.isMoving())
                    General.sleep(800, 1000);
            }
		
    }
}
